package org.beehyv.models;


import lombok.Data;

@Data
public class HelloWorld {
    public static final int HELLO = 0;
    public static final int GOODBYE = 1;

    private String message;
    private int status;
}
