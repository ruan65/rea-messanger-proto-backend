package ruCh.messenger.rea.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="instance")
public class Instance implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "instance", cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @OneToMany(mappedBy = "instance", cascade = CascadeType.ALL)
    private Set<Project> projects;

    @OneToMany(mappedBy = "instance", cascade = CascadeType.ALL)
    private Set<Message> messages;

    @OneToMany(mappedBy = "instance", cascade = CascadeType.ALL)
    private Set<Person> persons;

    @OneToMany(mappedBy = "instance", cascade = CascadeType.ALL)
    private Set<User> users;

    public Instance() {
    }

    public Instance(String name) {
        this.name = name;
    }

    public Instance(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Instance(String name, String address, Set<Room> rooms) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
    }

    public Instance(String name, String address, Set<Room> rooms, Set<Project> projects) {
        this.name = name;
        this.address = address;
        this.rooms = rooms;
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Instance{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", rooms=" + rooms +
                ", projects=" + projects +
                ", messages=" + messages +
                ", persons=" + persons +
                ", users=" + users +
                '}';
    }
}
