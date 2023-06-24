package com.example.courseworkcomputerelectronic;

public class Password {
    private String currentP;
    private String newP;

    public String getCurrentP() {
        return currentP;
    }

    public void setCurrentP(String currentP) {
        this.currentP = currentP;
    }

    public String getNewP() {
        return newP;
    }

    public void setNewP(String newP) {
        this.newP = newP;
    }

    public Password(String currentP, String newP) {
        this.currentP = currentP;
        this.newP = newP;
    }

    public Password() {
        currentP = "";
        newP = "";
    }
}
