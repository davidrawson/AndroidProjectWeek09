package example.codeclan.com.playyourcardsright;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by davidrawson on 29/01/2018.
 */


@Database(entities = {LeaderEntry.class}, version = 1)
public abstract class LeaderDatabase extends RoomDatabase {

    private static LeaderDatabase leaderDatabase;
    public abstract LeaderEntryDao entryDao();


    public static LeaderDatabase getAppDatabase(Context context) {
        if (leaderDatabase == null) {
            leaderDatabase =
                    Room.databaseBuilder(context.getApplicationContext(), LeaderDatabase.class, "user-database")
                            // allow queries on the main thread.
                            // Don't do this on a real app! See PersistenceBasicSample for an example.
                            .allowMainThreadQueries()
                            .build();
        }
        return leaderDatabase;
    }

}
