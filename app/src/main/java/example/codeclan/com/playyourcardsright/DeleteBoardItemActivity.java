package example.codeclan.com.playyourcardsright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DeleteBoardItemActivity extends AppCompatActivity {

    private LeaderEntry entry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_board_item);

        Intent intent = getIntent();
        entry = (LeaderEntry)intent.getSerializableExtra("name");

        TextView itemDetails = findViewById(R.id.itemToDelete);
        itemDetails.setText(entry.getName() + "   Score: " + entry.getRound() );

    }

    public void onDeleteButtonClick(View deleteButton){
        LeaderDatabase db = LeaderDatabase.getAppDatabase(this);
        db.entryDao().delete(entry);

        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);

    }
}





//    Intent intent = getIntent();
//    Album album = (Album)intent.getSerializableExtra("album");
//
//    TextView artistView = findViewById(R.id.artist);
//        artistView.setText(album.getArtist().toString());
//
//                TextView titleView = findViewById(R.id.title);
//                titleView.setText(album.getTitle().toString());
