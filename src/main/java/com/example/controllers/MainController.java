package com.example.controllers;

import java.util.List;

import com.example.models.FileDataSource;
import com.example.models.Task;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MainController {

    @FXML
    private RadioButton answerRadio_01;

    @FXML
    private RadioButton answerRadio_02;

    @FXML
    private RadioButton answerRadio_03;

    @FXML
    private RadioButton answerRadio_04;

    @FXML
    private TextField idField;

    @FXML
    private TextField questionField;

    List<Task> taskList;
    int actualIndex = 0;

    @FXML 
    void initialize() {
        System.out.println("Betölt....");
        loadData();
    }

    void loadData() {
        FileDataSource file = new FileDataSource();
        taskList = file.readData(); 
        loadTask(0);
    }

    void loadTask(int index) {
        Task task = taskList.get(index);
        idField.setText(task.getId());
        questionField.setText(task.getQuestion());
        answerRadio_01.setText(task.getAnswer1());
        answerRadio_02.setText(task.getAnswer2());
        answerRadio_03.setText(task.getAnswer3());
        answerRadio_04.setText(task.getAnswer4());
    }

    @FXML
    void onClickNextButton(ActionEvent event) {
        startNextLoad();
    }

    void startNextLoad() {
        if(actualIndex < taskList.size() - 1) {
            actualIndex ++;
            loadTask(actualIndex);
        }
    }

    @FXML
    void onClickPrevButton(ActionEvent event) {
        if (actualIndex > 0) {
            actualIndex --;
            loadTask(actualIndex);
        }
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        startSave();
    }

    void startSave() {
        
    }

}
