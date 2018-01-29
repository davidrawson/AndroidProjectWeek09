package example.codeclan.com.playyourcardsright;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by davidrawson on 29/01/2018.
 */


@Dao
public interface LeaderEntryDao {

    @Query("SELECT * FROM leaderentry ORDER BY round DESC")
    List<LeaderEntry> getAllDesc();

    @Query("SELECT * FROM leaderentry ORDER BY round ASC")
    List<LeaderEntry> getAllAsc();

    @Query("SELECT * FROM leaderentry WHERE name LIKE :name LIMIT 1")
    LeaderEntry findByName(String name);

    @Insert
    void insertAll(LeaderEntry entries);

    @Update
    void update(LeaderEntry leaderEntry);

    @Delete
    void delete(LeaderEntry leaderEntry);
}