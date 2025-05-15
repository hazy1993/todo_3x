package com.todo.todoList.vo;

import lombok.Data;

@Data
public class Todos {

    long id;
    String title;
    String content;
    String execDt;  //실행일자
    String execYn;  //실행일자
    String insertDt;
    String updateDt;

    public Todos() {

    }

    public Todos(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
