package org.example;
public class Main {
    public static void main(String[] args){
        Commands cm = new Commands();
        try {
            cm.commands();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
