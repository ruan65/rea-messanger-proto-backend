package ruCh.messenger.rea.repositories;

import org.springframework.data.repository.CrudRepository;
import ruCh.messenger.rea.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
}
