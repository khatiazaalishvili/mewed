package com.example.web.exception;
import java.time.LocalDateTime;
import java.util.List;



public class ExceptionBody {
    private List<String> message;
    private String path;
    private LocalDateTime timestamp;
    private int status;
    public ExceptionBody() {
    }
    public ExceptionBody(List<String> message, String path, LocalDateTime timestamp, int status) {
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
        this.status = status;
    }
    public List<String> getMessage() {
        return message;
    }
    public void setMessage(List<String> message) {
        this.message = message;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
