package example.codeclan.com.playyourcardsright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        LeaderDatabase db = LeaderDatabase.getAppDatabase(this);

        ArrayList<LeaderEntry> entries = new ArrayList<>(db.entryDao().getAllDesc()) ;

        LeaderboardAdapter entriesAdapter = new LeaderboardAdapter(this, entries);

        ListView leaderListView = findViewById(R.id.leaderList);
        leaderListView.setAdapter(entriesAdapter);
    }

    public void onBoardItemClick(View boardItem){
        LeaderEntry entry = (LeaderEntry) boardItem.getTag();

        Intent intent = new Intent(this, DeleteBoardItemActivity.class);
        intent.putExtra("name", entry);
        startActivity(intent);

    }

}
