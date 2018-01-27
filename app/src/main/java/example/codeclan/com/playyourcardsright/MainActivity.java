package example.codeclan.com.playyourcardsright;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Deck deck =  new Deck();
        deck.shuffleCards();
        deck.shuffleCards();
        Card card = deck.removeCard();

        String cardID = card.getImageFile();

        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());


        ImageView firstView = findViewById(R.id.firstCard);
        firstView.setImageResource(cardPic);

        ImageView nextView = findViewById(R.id.nextCard);
        nextView.setImageResource(R.drawable.red_back);
    }




}
