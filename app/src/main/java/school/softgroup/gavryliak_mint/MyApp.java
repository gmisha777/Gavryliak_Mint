package school.softgroup.gavryliak_mint;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by GMisha on 26.01.2017.
 */

public class MyApp extends Application {
    SharedPreferences sPref;
    public static final String LOGIN_PASS = "myLOG_PAS";

    @Override
    public void onCreate() {
        sPref=getSharedPreferences(LOGIN_PASS,MODE_PRIVATE);
    }

    public SharedPreferences getMyVariable() {
        return sPref=getSharedPreferences(LOGIN_PASS,MODE_PRIVATE);
    }

   }
