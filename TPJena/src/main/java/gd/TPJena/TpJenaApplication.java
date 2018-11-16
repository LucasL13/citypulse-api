package gd.TPJena;

import gd.TPJena.services.SPQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.servlet.ServletContext;

@SpringBootApplication
public class TpJenaApplication {

	@Autowired
	SPQLService service;

	@Autowired
	ServletContext servletContext;

	public static void main(String[] args) {
		SpringApplication.run(TpJenaApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		service.loadData(	servletContext.getRealPath("/WEB-INF/aarhus_parking.ttl"),
							servletContext.getRealPath("/WEB-INF/aarhus_weather_humidity.ttl"));
		System.out.println("Data model loaded : API is running");
	}

}
