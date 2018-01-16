package ruCh.messenger.rea.repositories;

import org.springframework.data.repository.CrudRepository;
import ruCh.messenger.rea.model.Message;

public interface MessageRepository extends CrudRepository<Message,Long> {
}
