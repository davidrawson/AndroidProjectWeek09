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

//        ImageView imageView = new ImageView(findViewById(R.id.homePic));

//        String red = "d";
//        String back = "5";

//        String cardID = red + back;

        Deck deck =  new Deck();
        deck.shuffleCards();
        Card card = deck.removeCard();

        String cardID = card.getImageFile();

        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());


        ImageView imageView = findViewById(R.id.homePic);
        imageView.setImageResource(cardPic);
    }
}
