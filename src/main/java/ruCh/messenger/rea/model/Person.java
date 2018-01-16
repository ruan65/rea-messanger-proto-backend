package ruCh.messenger.rea.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="person")
public class Person implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")

    private String firstName;
    @Column(name = "last_name")
    private String lastName;

//    @Id
//    @OneToOne()
//    @JoinColumn(name="user_id")
//    private User user;

    @ManyToOne
    @JoinColumn(name="instance_id")
    private Instance instance;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        this.instance = instance;
    }

    public Person(String firstName, String lastName, Instance instance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instance = instance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
//                ", user=" + user +
                ", instance=" + instance +
                '}';
    }
}
