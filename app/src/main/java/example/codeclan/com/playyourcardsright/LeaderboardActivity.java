package example.codeclan.com.playyourcardsright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // some kind of loop to take records from the db and put them in an array
        // then using the adapter to populate the listview.
        // actually, no. An array is already being returned.

        LeaderDatabase db = LeaderDatabase.getAppDatabase(this);

        ArrayList<LeaderEntry> entries = new ArrayList<>(db.entryDao().getAllAsc()) ;

        Log.d(getClass().toString(), "Entry " + entries.get(0).getName());

        LeaderboardAdapter entriesAdapter = new LeaderboardAdapter(this, entries);

        ListView leaderListView = findViewById(R.id.leaderList);
        leaderListView.setAdapter(entriesAdapter);

    }


}
