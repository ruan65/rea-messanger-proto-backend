package ruCh.messenger.rea.repositories;

import org.springframework.data.repository.CrudRepository;
import ruCh.messenger.rea.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
