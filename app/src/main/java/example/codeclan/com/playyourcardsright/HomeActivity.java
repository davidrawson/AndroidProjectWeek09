package example.codeclan.com.playyourcardsright;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        View fiveCardGameButton = findViewById(R.id.fiveCardGame);
        fiveCardGameButton.setTag("five");
        View fullPackGameButton = findViewById(R.id.fiveCardGame);
        fullPackGameButton.setTag("full");
    }


    public void onGameButtonClick(View button) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
