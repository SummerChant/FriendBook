package com.example.guilesson;

import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelloController {
    public TextField textGetName;
    public TextField textGetType;
    public ListView listFriends;
    public TextField textGetFileName;

    public void createFriend(ActionEvent actionEvent) {
        listFriends.getItems().add(new Friend(textGetName.getText(),textGetType.getText()));
        textGetName.clear();
        textGetType.clear();
    }

    public void saveFriend(ActionEvent actionEvent) throws IOException {
        ObservableList<Friend> myList = listFriends.getItems();
        String fileName = "friend.txt";
        for(Friend f : myList){
            f.writeToFile(fileName);
        }
        listFriends.getItems().clear();
    }

    public void loadFriend(ActionEvent actionEvent) throws IOException {
        listFriends.getItems().clear();
        ArrayList<Friend> friends = CreateFriend.createAllFriends(textGetFileName.getText());
        for(Friend f : friends){
            listFriends.getItems().add(f);
        }
    }

    public void saveByTypes(ActionEvent actionEvent) throws IOException{
        ObservableList<Friend> myList = listFriends.getItems();
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("S");
        typeList.add("A");
        typeList.add("B");
        typeList.add("C");
        String fName = "";

        for(String s : typeList) {
            fName = "friend-" + s + ".txt";
            for (Friend f : myList) {
                if(f.type.equals(s)) {
                    f.writeToFile(fName);
                }
            }
        }
        listFriends.getItems().clear();
    }
}