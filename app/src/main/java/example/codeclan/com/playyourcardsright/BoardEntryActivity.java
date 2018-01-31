package example.codeclan.com.playyourcardsright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

public class BoardEntryActivity extends AppCompatActivity {

    private TextView nameEntry;
    private int roundsCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_entry);
        TextView.OnEditorActionListener enterNameListener = new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView exampleView, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND || event.getKeyCode() == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    textEnteredActions();
                }
                return true;
            }

        };


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        roundsCompleted = extras.getInt("score");

        TextView entryMessage = findViewById(R.id.boardEntryMessage);
        entryMessage.setText("You completed " + roundsCompleted + " rounds. Well done! You've made it on the leaderboard. Enter your name.");

        nameEntry = findViewById(R.id.editNameText);
        nameEntry.setOnEditorActionListener(enterNameListener);
        nameEntry.getText();
    }


    public void onEnterTextButtonClick(View button){
        textEnteredActions();
    }

    private void textEnteredActions() {
        LeaderDatabase db = LeaderDatabase.getAppDatabase(this);
        LeaderEntry entry = new LeaderEntry();

        entry.setName(nameEntry.getText().toString());
        entry.setRound(roundsCompleted);
        db.entryDao().insertAll(entry);

        Intent intent = new Intent(this, LeaderboardActivity.class);
        startActivity(intent);

    }
}
