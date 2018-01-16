package ruCh.messenger.rea.repositories;

import org.springframework.data.repository.CrudRepository;
import ruCh.messenger.rea.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
