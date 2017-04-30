package com.pashkobohdan.academicperformance.core.db.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import com.pashkobohdan.academicperformance.core.db.models.Event;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by bohdan on 30.04.17.
 */

public class EventDAO extends BaseDaoImpl<Event, Integer> {

    public EventDAO(ConnectionSource connectionSource, Class<Event> dataClass) throws SQLException {
        super(connectionSource, dataClass);
    }

    public List<Event> getAllEvents() throws SQLException {
        return this.queryForAll();
    }
}
