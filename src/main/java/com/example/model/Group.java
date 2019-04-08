package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "group_table")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String text;
    private boolean done;

    public Group() {
    }

    public Group(Long id, String text, boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
