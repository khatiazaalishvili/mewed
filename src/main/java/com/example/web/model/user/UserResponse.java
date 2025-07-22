package com.example.web.model.user;
import java.time.LocalDate;





public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String userName;
    private LocalDate birthDate;
    public UserResponse() {
    }
    public UserResponse(Long id, String name, String surname, String userName, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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
}
