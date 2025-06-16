package Bug_Tracking.system.Bug.Repositories;

import Bug_Tracking.system.Bug.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
