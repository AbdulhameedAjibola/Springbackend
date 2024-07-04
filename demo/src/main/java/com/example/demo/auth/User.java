package com.example.demo.auth;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String gender;

    @Column(unique = true, nullable = false)
    private Integer nin;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String localGovernment;

    @Column(nullable = false)
    private String state;

    @Column(unique = true)
    private String anonymousId;

    @Column(unique = true)
    private String phoneNumber;

    @Column(unique = true)
    private String tenDigitCode;

    public User() {
    }

    public User(Long id, String email, int age, String gender, int nin, String password, String localGovernment, String state, String anonymousId, String phoneNumber, String tenDigitCode) {
        this.id = id;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.nin = nin;
        this.password = password;
        this.localGovernment = localGovernment;
        this.state = state;
        this.anonymousId = anonymousId;
        this.phoneNumber = phoneNumber;
        this.tenDigitCode = tenDigitCode;
    }

    public User(String email, int age, String gender, int nin, String password, String localGovernment, String state, String anonymousId, String phoneNumber, String tenDigitCode) {
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.nin = nin;
        this.password = password;
        this.localGovernment = localGovernment;
        this.state = state;
        this.anonymousId = anonymousId;
        this.phoneNumber = phoneNumber;
        this.tenDigitCode = tenDigitCode;
    }

    public User(Long voterID) {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNin() {
        return nin;
    }

    public void setNin(int nin) {
        this.nin = nin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalGovernment() {
        return localGovernment;
    }

    public void setLocalGovernment(String localGovernment) {
        this.localGovernment = localGovernment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAnonymousId() {
        return anonymousId;
    }

    public void setAnonymousId(String anonymousId) {
        this.anonymousId = anonymousId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTenDigitCode() {
        return tenDigitCode;
    }

    public void setTenDigitCode(String tenDigitCode) {
        this.tenDigitCode = tenDigitCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", nin='" + nin + '\'' +
                ", password='" + password + '\'' +
                ", localGovernment='" + localGovernment + '\'' +
                ", state='" + state + '\'' +
                ", anonymousId='" + anonymousId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", tenDigitCode='" + tenDigitCode + '\'' +
                '}';
    }
}

