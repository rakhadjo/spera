package docotel.spera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SperaApplication {

	public static void main(String[] args) {
            try {
		SpringApplication.run(SperaApplication.class, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
	}

}
