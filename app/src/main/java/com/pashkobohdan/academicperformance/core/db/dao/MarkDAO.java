package com.pashkobohdan.academicperformance.core.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.academicperformance.core.db.models.Mark;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bohdan on 30.04.17.
 */

public class MarkDAO extends BaseDaoImpl<Mark, Integer> {

    public MarkDAO(ConnectionSource connectionSource, Class<Mark> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Mark> getAllMarks() throws SQLException {
        return this.queryForAll();
    }

}
