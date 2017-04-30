package com.pashkobohdan.academicperformance.core.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by bohdan on 30.04.17.
 */

@DatabaseTable(tableName = "events")
public class Event {

    public static enum EventType{
        THEORY,
        PRACTICE,
        EXAM;
    }

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private EventType eventType;

    @DatabaseField
    private Integer maxMark;

    @DatabaseField(foreign = true)
    private Group group;


    public Event(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public Integer getMaxMark() {
        return maxMark;
    }

    public void setMaxMark(Integer maxMark) {
        this.maxMark = maxMark;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
