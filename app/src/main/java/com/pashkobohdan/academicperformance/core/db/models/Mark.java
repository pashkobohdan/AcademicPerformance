package com.pashkobohdan.academicperformance.core.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by bohdan on 30.04.17.
 */

@DatabaseTable(tableName = "marks")
public class Mark {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private Integer mark;

    @DatabaseField(foreign = true)
    private Event event;

    @DatabaseField(foreign = true)
    private Student student;


    public Mark(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
