package com.pashkobohdan.academicperformance.core.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.pashkobohdan.academicperformance.core.db.dao.EventDAO;
import com.pashkobohdan.academicperformance.core.db.dao.GroupDAO;
import com.pashkobohdan.academicperformance.core.db.dao.MarkDAO;
import com.pashkobohdan.academicperformance.core.db.dao.StudentDAO;
import com.pashkobohdan.academicperformance.core.db.dao.SubjectDAO;
import com.pashkobohdan.academicperformance.core.db.models.Event;
import com.pashkobohdan.academicperformance.core.db.models.Group;
import com.pashkobohdan.academicperformance.core.db.models.Mark;
import com.pashkobohdan.academicperformance.core.db.models.Student;
import com.pashkobohdan.academicperformance.core.db.models.Subject;

import java.sql.SQLException;

/**
 * Created by bohdan on 30.04.17.
 */

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName();

    //имя файла базы данных который будет храниться в /data/data/APPNAME/DATABASE_NAME.db
    private static final String DATABASE_NAME = "data.db";

    //с каждым увеличением версии, при нахождении в устройстве БД с предыдущей версией будет выполнен метод onUpgrade();
    private static final int DATABASE_VERSION = 1;

    //ссылки на DAO соответсвующие сущностям, хранимым в БД
    private SubjectDAO subjectDAO;
    private GroupDAO groupDAO;
    private MarkDAO markDAO;
    private StudentDAO studentDAO;
    private EventDAO eventDAO;


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Выполняется, когда файл с БД не найден на устройстве
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            TableUtils.createTable(connectionSource, SubjectDAO.class);
            TableUtils.createTable(connectionSource, GroupDAO.class);
            TableUtils.createTable(connectionSource, MarkDAO.class);
            TableUtils.createTable(connectionSource, StudentDAO.class);
            TableUtils.createTable(connectionSource, EventDAO.class);
        } catch (SQLException e) {
            Log.e(TAG, "error creating DB " + DATABASE_NAME);
            throw new RuntimeException(e);
        }
    }

    //Выполняется, когда БД имеет версию отличную от текущей
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVer,
                          int newVer) {
        try {
            //Так делают ленивые, гораздо предпочтительнее не удаляя БД аккуратно вносить изменения
            TableUtils.dropTable(connectionSource, SubjectDAO.class, true);
            TableUtils.dropTable(connectionSource, GroupDAO.class, true);
            TableUtils.dropTable(connectionSource, MarkDAO.class, true);
            TableUtils.dropTable(connectionSource, StudentDAO.class, true);
            TableUtils.dropTable(connectionSource, EventDAO.class, true);
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(TAG, "error upgrading db " + DATABASE_NAME + "from ver " + oldVer);
            throw new RuntimeException(e);
        }
    }

    public SubjectDAO getSubjectDAO() throws SQLException {
        if (subjectDAO == null) {
            subjectDAO = new SubjectDAO(getConnectionSource(), Subject.class);
        }
        return subjectDAO;
    }

    public GroupDAO getGroupDAO() throws SQLException {
        if (groupDAO == null) {
            groupDAO = new GroupDAO(getConnectionSource(), Group.class);
        }
        return groupDAO;
    }

    public MarkDAO getMarkDAO() throws SQLException {
        if (markDAO == null) {
            markDAO = new MarkDAO(getConnectionSource(), Mark.class);
        }
        return markDAO;
    }

    public StudentDAO getStudentDAO() throws SQLException {
        if (studentDAO == null) {
            studentDAO = new StudentDAO(getConnectionSource(), Student.class);
        }
        return studentDAO;
    }

    public EventDAO getEventDAO() throws SQLException {
        if (eventDAO == null) {
            eventDAO = new EventDAO(getConnectionSource(), Event.class);
        }
        return eventDAO;
    }

    //выполняется при закрытии приложения
    @Override
    public void close() {
        super.close();
        subjectDAO = null;
        groupDAO = null;
        studentDAO = null;
        eventDAO = null;
        markDAO = null;
    }
}
