package com.example.grouprecyclerview;

public class DataModel {

    public DataModel(String task, String date) {
        this.task = task;
        this.date = date;
    }

    private String task,date;


    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
