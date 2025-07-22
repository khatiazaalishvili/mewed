package com.example.web.model.post;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public class PostRequest {
    @NotBlank(message = "Text can not be blank!;")
    @Size(min = 2, max = 512, message = "ტექსტი აუცილებელია, ზომა: 2-512 სიმბოლო;")
    private String text;

    public PostRequest() {}

    public PostRequest(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

