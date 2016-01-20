package com.ahmadrosid.belajarrealm;

import android.app.Application;

import com.ahmadrosid.belajarrealm.models.DataModel;

import java.util.ArrayList;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by ocittwo on 1/19/16.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration config = new RealmConfiguration.Builder(this)
                .schemaVersion(2)
                .migration(new DataMigration())
                .build();

        Realm.setDefaultConfiguration(config);

    }

    private class DataMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

            // DynamicRealm exposes an editable schema
            RealmSchema schema = realm.getSchema();

            if (oldVersion == 0) {
                schema.create("Data")
                        .addField("id", int.class)
                        .addField("title", String.class)
                        .addField("description", String.class);
                oldVersion++;
            }

        }
    }
}
