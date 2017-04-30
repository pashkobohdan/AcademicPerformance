package com.pashkobohdan.academicperformance.core.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by bohdan on 30.04.17.
 */

@DatabaseTable(tableName = "groups")
public class Group {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private int name;

    @DatabaseField(foreign = true)
    private Subject subject;

    @ForeignCollectionField(eager = true)
    private Collection<Event> groupEvents;

    @ForeignCollectionField(eager = true)
    private Collection<Student> students;

    public Group(){
        groupEvents = new LinkedList<>();
        students = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Collection<Event> getGroupEvents() {
        return groupEvents;
    }

    public void setGroupEvents(Collection<Event> groupEvents) {
        this.groupEvents = groupEvents;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
