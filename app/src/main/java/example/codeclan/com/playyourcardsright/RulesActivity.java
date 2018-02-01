package example.codeclan.com.playyourcardsright;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);


        TextView rulesView = findViewById(R.id.rulesText);
        rulesView.setText("There are five cards laid out, and you are to guess if the next card is higher or lower - ace being the highest card, and two being lowest./nThe first card can be changed if you wish./n/nIf your guess is correct you continue with the next card./n/nCorrectly guessing all cards to the end wins the game./n/nThe Full Deck Game has the same rules but uses the full deck rather than just five cards./n/nRemember, you get nothing for a pair, not in this game.");

    }
}
