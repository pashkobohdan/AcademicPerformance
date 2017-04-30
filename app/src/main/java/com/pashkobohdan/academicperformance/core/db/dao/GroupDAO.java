package com.pashkobohdan.academicperformance.core.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.academicperformance.core.db.models.Group;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bohdan on 30.04.17.
 */

public class GroupDAO extends BaseDaoImpl<Group, Integer> {

    public GroupDAO(ConnectionSource connectionSource, Class<Group> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Group> getAllGroups() throws SQLException {
        return this.queryForAll();
    }
}
