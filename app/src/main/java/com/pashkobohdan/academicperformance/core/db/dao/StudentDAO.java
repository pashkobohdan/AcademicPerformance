package com.pashkobohdan.academicperformance.core.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.academicperformance.core.db.models.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bohdan on 30.04.17.
 */

public class StudentDAO extends BaseDaoImpl<Student, Integer> {

    public StudentDAO(ConnectionSource connectionSource, Class<Student> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Student> getAllStudents() throws SQLException {
        return this.queryForAll();
    }
}
