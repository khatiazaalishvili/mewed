package com.example.web.model.user;
import jakarta.validation.constraints.*;
import java.time.LocalDate;



public class UserRequest {

    @NotBlank(message = " სახელი შევსებული უნდა იყოს!")
    @Size(min = 2, max = 32, message = " სახელი უნდა იყოს 2-დან 32 სიმბოლომდე!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "სახელი უნდა შეიცავდეს მხოლოდ ლათინურ ასოებს!!")
    private String name;
    @NotBlank(message = "ველი უნდა იყოს შევსებული!")
    @Size(min = 2, max = 64, message = "გვარი უნდა იყოს 2-დან 64 სიმბოლომდე!")
    @Pattern(regexp = "^[A-Za-z]+$", message = "გვარი უნდა შეიცავდეს მხოლოდ ლათინურ ასოებს!")
    private String surname;
    @NotBlank(message = " სახელი შევსებული უნდა იყოს!")
    @Size(min = 4, max = 16, message = "სახელი უნდა შეიცავდეს 4-16 სიმბოლოს!")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "სახელი უნდა შეიცავდეს მხოლოდ ლათინურ ასოებს ან ციფრებს!")
    private String userName;
    @NotNull(message = "დაბადების თარიღი შევსებული უნდა იყოს!")
    @PastOrPresent(message = "აბადების თარიღი არ შეიძლება იყოს მომავალში!")
    private LocalDate birthDate;
    public UserRequest() {
    }
    public UserRequest(String name, String surname, String userName, LocalDate birthDate) {
        this.name = name;
        this.surname = surname;
        this.userName = userName;
        this.birthDate = birthDate;
    }

    public @NotNull(message = "დაბადების თარიღი არ შეიძლება იყოს ცარიელი!") @PastOrPresent(message = "დაბადების თარიღი არ შეიძლება იყოს მომავალში!") LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(@NotNull(message = "Birth date cannot be null!") @PastOrPresent(message = "Birth date cannot be in the future!") LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public @NotBlank(message = "Name cannot be blank!") @Size(min = 2, max = 32, message = "Name should be 2-32 characters!") @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only Latin letters!") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Name cannot be blank!") @Size(min = 2, max = 32, message = "Name should be 2-32 characters!") @Pattern(regexp = "^[A-Za-z]+$", message = "Name must contain only Latin letters!") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Surname cannot be blank!") @Size(min = 2, max = 64, message = "Surname should be 2-64 characters!") @Pattern(regexp = "^[A-Za-z]+$", message = "Surname must contain only Latin letters!") String getSurname() {
        return surname;
    }

    public void setSurname(@NotBlank(message = "Surname cannot be blank!") @Size(min = 2, max = 64, message = "Surname should be 2-64 characters!") @Pattern(regexp = "^[A-Za-z]+$", message = "Surname must contain only Latin letters!") String surname) {
        this.surname = surname;
    }

    public @NotBlank(message = "UserName cannot be blank!") @Size(min = 4, max = 16, message = "UserName should be 4-16 characters!") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "UserName must contain only Latin letters or numbers!") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "UserName cannot be blank!") @Size(min = 4, max = 16, message = "UserName should be 4-16 characters!") @Pattern(regexp = "^[A-Za-z0-9]+$", message = "UserName must contain only Latin letters or numbers!") String userName) {
        this.userName = userName;
    }
}
