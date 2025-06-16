package Bug_Tracking.system.Bug.Repositories;

import Bug_Tracking.system.Bug.Entities.Bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepo extends JpaRepository<Bug, Integer>{

}
