package com.example.controllers;

import java.util.ArrayList;
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
    List<Integer> answerList = new ArrayList<>();

    @FXML 
    void initialize() {
        System.out.println("Betölt....");
        loadData();
        setDefaultState();
        answerList.add(1);
        answerList.add(1);
        answerList.add(1);
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
            answerList.set(actualIndex, getSelectedNum());
            actualIndex ++;
            loadTask(actualIndex);
            setActualState();

        }
    }

    void setDefaultState() {
        this.answerRadio_01.setSelected(true);
    }

    @FXML
    void onClickPrevButton(ActionEvent event) {
        if (actualIndex > 0) {
            answerList.set(actualIndex, getSelectedNum());
            actualIndex --;
            loadTask(actualIndex);
            setActualState();
        }
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        startSave();
    }

    void startSave() {
        answerList.set(actualIndex, getSelectedNum());
        System.out.println(answerList);
    }

    int getSelectedNum() {
                int num = 1;
        if (answerRadio_01.isSelected()) {
            num = 1;
        }else if (answerRadio_02.isSelected()) {
            num = 2;
        }else if (answerRadio_03.isSelected()) {
            num = 3;
        }else if (answerRadio_04.isSelected()) {
            num = 4;
        }
        return num;
    }

    void setActualState() {
        int num = answerList.get(actualIndex);
        if (num == 1) {
            answerRadio_01.setSelected(true);
        }else if (num == 2) {
            answerRadio_02.setSelected(true);
        }else if (num == 3) {
            answerRadio_03.setSelected(true);
        }else if (num == 4) {
            answerRadio_04.setSelected(true);
        }
    }

}
