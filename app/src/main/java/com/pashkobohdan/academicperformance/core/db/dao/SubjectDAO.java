package com.pashkobohdan.academicperformance.core.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.academicperformance.core.db.models.Subject;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bohdan on 30.04.17.
 */

public class SubjectDAO extends BaseDaoImpl<Subject, Integer> {

    public SubjectDAO(ConnectionSource connectionSource, Class<Subject> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Subject> getAllSubjects() throws SQLException {
        return this.queryForAll();
    }
}
