package com.example.todolistproject.model;

import java.io.Serializable;

public class ToDo implements Serializable {
    private Long id;
    private String toDoName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToDoName() {
        return toDoName;
    }

    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }
}
