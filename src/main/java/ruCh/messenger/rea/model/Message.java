package ruCh.messenger.rea.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="message")
public class Message implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text;

    @ManyToOne
    @JoinColumn(name="instance_id")
    private Instance instance;

    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name="task_id")
    private Task task;

    public Message() {
    }

    public Message(String text, Instance instance) {
        this.text = text;
        this.instance = instance;
    }

    public Message(String text, Instance instance, Room room) {
        this.text = text;
        this.instance = instance;
        this.room = room;
    }

    public Message(String text, Instance instance, Task task) {
        this.text = text;
        this.instance = instance;
        this.task = task;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", instance=" + instance +
                ", room=" + room +
                ", task=" + task +
                '}';
    }
}
