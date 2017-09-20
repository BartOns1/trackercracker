package be.trackercracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TrackercrackerApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(TrackercrackerApplication.class, args);
	}
}
