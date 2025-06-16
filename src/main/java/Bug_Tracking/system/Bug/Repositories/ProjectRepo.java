package Bug_Tracking.system.Bug.Repositories;

import Bug_Tracking.system.Bug.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

}
