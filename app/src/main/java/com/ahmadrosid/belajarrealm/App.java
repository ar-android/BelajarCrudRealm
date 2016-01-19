package com.ahmadrosid.belajarrealm;

import android.app.Application;

import com.ahmadrosid.belajarrealm.helper.RealmHelper;
import com.ahmadrosid.belajarrealm.models.DataModel;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by ocittwo on 1/19/16.
 */
public class App extends Application{

    public static ArrayList<DataModel> data;
    private RealmHelper helper;

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(config);

        helper = new RealmHelper(this);
        data = helper.findAllArticle();

    }
    public static ArrayList<DataModel> getData() {
        return data;
    }

    public static void setData(ArrayList<DataModel> data) {
        App.data = data;
    }

}
