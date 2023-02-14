package fr.bsnt.model;

import org.springframework.context.MessageSource;

public class HelloBeans {
    private String message;

    public HelloBeans() {
    }

    public HelloBeans(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String  toString() {
        return "HelloBeans{" +
                            "message='" + message + '\'' +
                '}';
    }
}
