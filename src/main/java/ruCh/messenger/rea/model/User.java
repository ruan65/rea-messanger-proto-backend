package ruCh.messenger.rea.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String email;
    private String phone;

    @ManyToOne
    @JoinColumn(name="instance_id")
    private Instance instance;

    @OneToOne
            //(cascade = CascadeType.ALL, mappedBy = "user")
    private Person person;

    public User() {
    }

    public User(String login, String email, String phone, Instance instance) {
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.instance = instance;
    }

    public User(String login, String email, String phone, Instance instance, Person person) {
        this.login = login;
        this.email = email;
        this.phone = phone;
        this.instance = instance;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", instance=" + instance +
                ", person=" + person +
                '}';
    }
}


