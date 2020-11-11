package com.com.tasks.Model;

public class ModelDB {
    private int id;
    private String Tasks_text ;
    private boolean check ;

    public ModelDB(String tasks_text) {
        Tasks_text = tasks_text;
    }

    public ModelDB(int id, String tasks_text, boolean check) {
        this.id = id;
        this.Tasks_text = tasks_text;
        this.check = check;
    }

    public int getId() {
        return id;
    }

    public String getTasks_text() {
        return Tasks_text;
    }

    public boolean isCheck() {
        return check;
    }
}
