package com.pashkobohdan.academicperformance.core.db.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by bohdan on 30.04.17.
 */

@DatabaseTable(tableName = "subjects")
public class Subject {

    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField
    private Integer maxTotalMark;

    @DatabaseField
    private Date startDate;

    @DatabaseField
    private Date endDate;

    @DatabaseField
    private String name;

    @ForeignCollectionField(eager = true)
    private Collection<Group> groups;


    public Subject() {
        groups = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getMaxTotalMark() {
        return maxTotalMark;
    }

    public void setMaxTotalMark(Integer maxTotalMark) {
        this.maxTotalMark = maxTotalMark;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Group> getGroups() {
        return groups;
    }

    public void setGroups(Collection<Group> groups) {
        this.groups = groups;
    }
}