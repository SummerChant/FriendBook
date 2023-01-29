package com.example.guilesson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreateFriend {
    private static String name;
    private static String type;
    private static FileReader fr;
    private static BufferedReader br;
    private static ArrayList<Friend> friends = new ArrayList<>();

    public static ArrayList createAllFriends(String fileName) throws IOException{
        fr = new FileReader(fileName);
        br = new BufferedReader(fr);
        String line;
        String friendString = "";
        while((line = br.readLine()) != null){
            if(!line.equals(";")){
                friendString += line;
            }else{
                parseFriend(friendString);
                friendString = "";
            }
        }
        return friends;
    }
    private static void parseFriend(String string){
        int pos = 0;
        String name = "";
        String type = "";
        for(int i = 0; i<string.length();i++){
            if(string.substring(i,i+1).equals(",")) {
                pos = i;
                name = string.substring(0, pos);
                type = string.substring(pos + 1);
            }
        }
        friends.add(new Friend(name,type));
    }
}
