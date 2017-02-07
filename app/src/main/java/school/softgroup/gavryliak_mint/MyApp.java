package school.softgroup.gavryliak_mint;
import android.app.Application;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by GMisha on 26.01.2017.
 */

public class MyApp extends Application {
    SharedPreferences sPref;
    public static final String LOGIN_PASS = "myLOG_PAS";
    public static int delete_id=-1;
    private static MyApp instance;
    private Fruit_Adapter mAdapter;
    private FragmentManager fm;

    public FragmentManager getFm() {
        return fm;
    }

    public void setFm(FragmentManager fm) {
        this.fm = fm;
    }

    public Fruit_Adapter getmAdapter() {
        return mAdapter;
    }

    public void setmAdapter(Fruit_Adapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onCreate() {

       RealmConfiguration config = new RealmConfiguration.Builder(getApplicationContext()).build();
       Realm.setDefaultConfiguration(config);
      //  Realm.deleteRealm(config);
        instance = this;
        sPref=getSharedPreferences(LOGIN_PASS,MODE_PRIVATE);
    }

    public SharedPreferences getMySPREF() {
        return getSharedPreferences(LOGIN_PASS,MODE_PRIVATE);
    }

    public static MyApp getInstance() {
        return instance;
    }
}