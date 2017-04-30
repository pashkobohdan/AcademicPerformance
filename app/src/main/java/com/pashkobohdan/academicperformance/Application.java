package com.pashkobohdan.academicperformance;

import com.pashkobohdan.academicperformance.core.db.HelperFactory;

/**
 * Created by bohdan on 30.04.17.
 */

public class Application extends android.app.Application {


    @Override
    public void onCreate() {
        super.onCreate();

        HelperFactory.setHelper(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        HelperFactory.releaseHelper();

        super.onTerminate();
    }

}
