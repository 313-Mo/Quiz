package Quiz.Master.Group.QuizMaster.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;  
import jakarta.persistence.Id;  

@Entity
public class QuizUser {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;
    private int age;
    
    protected QuizUser() {
        this.firstName = null;
        this.lastName = null;
        this.username = null;
        this.password = null;
        this.email = null;
        this.age = 0;
    }

    public QuizUser(String firstName, String lastName, String username, String password, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getEmail() {
        return email;
    }
    public int getAge() {
        return age;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
}
