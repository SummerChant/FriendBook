package com.example.guilesson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Friend {
    String name;
    String type;

    Friend(String name, String type){
        this.name = name;
        this.type = type;
    }

    public void writeToFile(String fileName) throws IOException{
        FileWriter fw = new FileWriter(fileName, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(name + ",\r");
        bw.write(type + "\r");
        bw.write(";\r");
        bw.close();
    }

    public String toString(){
        return "Name: " + name + "\tType: " + type;
    }

    public boolean compareFriends(Friend f){
        if(this.name.equals(f.name)){
            return true;
        }
        else return false;
    }
}
