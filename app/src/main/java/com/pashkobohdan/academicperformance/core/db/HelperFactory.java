package com.pashkobohdan.academicperformance.core.db;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;

/**
 * Created by bohdan on 30.04.17.
 */

public class HelperFactory {
    private static DatabaseHelper databaseHelper;

    public static DatabaseHelper getHelper(){
        return databaseHelper;
    }
    public static void setHelper(Context context){
        databaseHelper = OpenHelperManager.getHelper(context, DatabaseHelper.class);
    }
    public static void releaseHelper(){
        OpenHelperManager.releaseHelper();
        databaseHelper = null;
    }
}
