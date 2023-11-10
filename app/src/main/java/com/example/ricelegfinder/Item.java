package com.example.ricelegfinder;

public class Item {

    String message;
    String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



    public Item(String message, String type){
        this.message=message;
        this.type = type;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
