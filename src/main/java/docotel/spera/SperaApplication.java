package docotel.spera;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author rakhadjo
 */
@SpringBootApplication
public class SperaApplication {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
            try {
		SpringApplication.run(SperaApplication.class, args);
            } catch (Exception e) {
                e.printStackTrace();
            }
	}

}
