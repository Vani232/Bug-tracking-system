
package Bug_Tracking.system.Bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Now it will scan everything under 'Bug'
public class BugTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BugTrackerApplication.class, args);
    }
}

