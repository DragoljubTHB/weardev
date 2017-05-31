package org.dado.weardev;

import android.support.multidex.MultiDexApplication;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by dado on 31.05.17.
 */
public class App extends MultiDexApplication {
    private static App instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        Realm.init(getApplicationContext());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(configuration);

    }
    public static App getInstance(){return instance;}
}