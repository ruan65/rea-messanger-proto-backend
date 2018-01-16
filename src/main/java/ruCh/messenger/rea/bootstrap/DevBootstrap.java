package ruCh.messenger.rea.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import ruCh.messenger.rea.model.*;
import ruCh.messenger.rea.repositories.*;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private InstanceRepository instanceRepository;
    private MessageRepository messageRepository;
    private PersonRepository personRepository;
    private ProjectRepository projectRepository;
    private RoomRepository roomRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public DevBootstrap(InstanceRepository instanceRepository, MessageRepository messageRepository, PersonRepository personRepository, ProjectRepository projectRepository, RoomRepository roomRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.instanceRepository = instanceRepository;
        this.messageRepository = messageRepository;
        this.personRepository = personRepository;
        this.projectRepository = projectRepository;
        this.roomRepository = roomRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       initData();
    }

    private void initData() {
        Instance company = new Instance("Rosenergoatom", "somewhere in deep deep Russia");
        Project project = new Project("ruCH","messenger development and implementation", company);
        Room room = new Room("ruCH_Dev", "Messenger backend development", company, project);
        Task task = new Task("JPA", "develop the first version of db using JPA with Hibernate", project);

        Person artemKarpov = new Person("Artem","Karpov",company);
        User artem = new User("artem", "ar.karpov@gmail.com", "+79154741514", company, artemKarpov);

        Person nelioLikas = new Person("Nelio","Lukas", company);
        User nelio = new User("nelio", "nelio@gmail.com", "+123421342", company, nelioLikas);

        Person tomFrancis = new Person("Tom","Francis", company);
        User tom = new User("tom", "tom@gmail.com", "+46345635", company, tomFrancis);

        Message instanceMessage = new Message("Demo instance message",company);
        Message roomMessage = new Message("Demo room message",company, room);
        Message taskMessage = new Message("Demo task message",company, task);

        instanceRepository.save(company);
        projectRepository.save(project);
        roomRepository.save(room);
        taskRepository.save(task);

        personRepository.save(artemKarpov);
        personRepository.save(nelioLikas);
        personRepository.save(tomFrancis);

        userRepository.save(artem);
        userRepository.save(nelio);
        userRepository.save(tom);

        messageRepository.save(instanceMessage);
        messageRepository.save(roomMessage);
        messageRepository.save(taskMessage);

    }
}
