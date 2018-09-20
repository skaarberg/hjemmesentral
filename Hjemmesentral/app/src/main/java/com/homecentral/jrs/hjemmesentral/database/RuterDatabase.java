package com.homecentral.jrs.hjemmesentral.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.homecentral.jrs.hjemmesentral.model.ruter.Departure;
import com.homecentral.jrs.hjemmesentral.model.ruter.Line;

@Database(entities = {Line.class, Departure.class}, version = 2)
@TypeConverters(RuterConverter.class)
public abstract class RuterDatabase extends RoomDatabase {

    private static RuterDatabase INSTANCE;

    public abstract RuterDao ruterDao();

    public static RuterDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RuterDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RuterDatabase.class, "ruter_data")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
