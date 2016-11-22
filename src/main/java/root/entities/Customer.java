package entities;

import javax.persistence.*;

@Entity(name = "Customer")
@Table(name = "tblCustomer")
public class Customer {
    @Id
    @Column(name = "CustomerId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FirstName", length = 100)
    private String firstName;
    @Column(name = "LastName", length = 100)
    private String lastName;
    @Column(name = "PatronymicName", length = 100)
    private String patronymicName;
    @Column(name = "PersonalNumber", length = 20)
    private String personalNumber;
    @Column(name = "Active", columnDefinition="bool default '1'")
    private Boolean active;

    public Customer(){}

    public Customer(String firstName, String lastName, String patronymicName, String personalNumber){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPatronymicName(patronymicName);
        this.setpersonalNumber(personalNumber);
    }

    public Customer(Integer id, String firstName, String lastName, String patronymicName, String personalNumber){
        this.setId(id);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPatronymicName(patronymicName);
        this.setpersonalNumber(personalNumber);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getPatronymicName() {
        return patronymicName;
    }

    public void setPatronymicName(String patronymicName) {
        this.patronymicName = patronymicName;
    }

    public String getpersonalNumber() {
        return personalNumber;
    }

    public void setpersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }
}
