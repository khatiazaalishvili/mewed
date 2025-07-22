package com.example.web.model.user;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;




@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank!")
    @Size(min = 2, max = 32, message = "Name should be 2-32 characters!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only Latin letters!")
    private String name;

    @NotBlank(message = "Surname cannot be blank!")
    @Size(min = 2, max = 64, message = "Surname should be 2-64 characters!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "Surname must contain only Latin letters!")
    private String surname;

    @NotBlank(message = "UserName cannot be blank!")
    @Size(min = 4, max = 16, message = "UserName should be 4-16 characters!")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "UserName must contain only Latin letters or numbers!")
    private String userName;

    @NotNull(message = "Birth date cannot be null!")
    @PastOrPresent(message = "Birth date cannot be in the future!")
    private LocalDate birthDate;

    public UserEntity() {
    }

    public UserEntity(String name, String surname, String userName, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
