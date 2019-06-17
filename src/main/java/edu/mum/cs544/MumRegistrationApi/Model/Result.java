package edu.mum.cs544.MumRegistrationApi.Model;

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean getSuccess(){
        return this.success;
    }

    public String getMessage(){
        return this.message;
    }
}
