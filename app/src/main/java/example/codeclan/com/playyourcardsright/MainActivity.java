package example.codeclan.com.playyourcardsright;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {

    ImageView firstView;
    ImageView nextView;
    ImageView messageView;
    View higherButton;
    View lowerButton;
    //    private boolean firstGo;
//    private Deck deck;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Deck deck =  new Deck();
//        deck.shuffleCards();
//        deck.shuffleCards();
//        Card card = deck.removeCard();

//        firstGo = true;

//        ImageView backgroundImage = findViewById(R.id.background);
//        backgroundImage.setImageResource(R.id.templ);
        higherButton = findViewById(R.id.higherButton);
        higherButton.setTag("higher");
        lowerButton = findViewById(R.id.lowerButton);
        lowerButton.setTag("lower");
        messageView = findViewById(R.id.messageBox);
        messageView.setVisibility(INVISIBLE);

        Intent intent = getIntent(); // gets the intent that started this activity, the AnswerActivity.
        Bundle extras = intent.getExtras();  // just a bunch of data. All onCreate methods get one.
        String gameType = extras.getString("button");

        Log.d(getClass().toString(), "Button " + gameType);

//        if (gameType == "full"){
            game = new Game(5);
//        }
//        if (gameType == "five"){
//            game = new Game(5);
//        }

//        deck = game.getDeck();
//        Card card = deck.removeCard();

//        String cardID = game.getFirstCard().getImageFile();
//
//        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());

        setCards();
//        firstView = findViewById(R.id.firstCard);
//        firstView.setImageResource(cardPic);
//
//        nextView = findViewById(R.id.nextCard);
//        nextView.setImageResource(R.drawable.red_back);
    }

    public void onHigherLowerButtonClick(View button){
//        firstGo = false;
        View refreshButton = findViewById(R.id.refreshButton);
        refreshButton.setVisibility(INVISIBLE);
        higherButton.setVisibility(INVISIBLE);
        lowerButton.setVisibility(INVISIBLE);
        Log.d(getClass().toString(), "onHigherLowerButtonClick " + button.getTag());
        String cardID = game.getNextCard().getImageFile();
        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());
        nextView = findViewById(R.id.nextCard);
        nextView.setImageResource(cardPic);

        if (game.checkForRoundWin(button.getTag()) == "win"){
//            messageView = findViewById(R.id.messageBox);
            messageView.setImageResource(R.drawable.tick_2);
            messageView.setVisibility(View.VISIBLE);
        }else{
            if (game.checkForRoundWin(button.getTag()) == "draw"){
                // You get nothing for a draw, not in this game.
                messageView.setImageResource(R.drawable.a_draw);
                messageView.setVisibility(View.VISIBLE);
            }else{
                // loser
                messageView.setImageResource(R.drawable.you_just_lost);
                messageView.setVisibility(View.VISIBLE);
            }
//            youLostGoHome();
        }
    }

    public void onChangeCardButtonClick(View button){
        game.changeFirstCard();
        String cardID = game.getFirstCard().getImageFile();
        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());
//        if (firstGo = true) {
            firstView.setImageResource(cardPic);
//        }
//        firstGo = false;
        button.setVisibility(INVISIBLE);
    }

    public void onMessageClick(View messageButton){
        if (game.getResult() == "win"){
            messageButton.setVisibility(INVISIBLE);
            game.moveCards();
            setCards();
            removeDownturnedCard();
        }else{
            youLostGoHome();
        }
    }

    public void setCards(){
        String cardID = game.getFirstCard().getImageFile();
        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());

        firstView = findViewById(R.id.firstCard);
        firstView.setImageResource(cardPic);

        nextView = findViewById(R.id.nextCard);
        nextView.setImageResource(R.drawable.red_back);

        higherButton.setVisibility(View.VISIBLE);
        lowerButton.setVisibility(View.VISIBLE);
    }

    public void removeDownturnedCard() {
        if (game.getRoundNumber() == 1){
            View cardImage = findViewById(R.id.card5);
            cardImage.setVisibility(INVISIBLE);
        }
        if (game.getRoundNumber() == 2){
            View cardImage = findViewById(R.id.card4);
            cardImage.setVisibility(INVISIBLE);
        }
        if (game.getRoundNumber() == 3){
            View cardImage = findViewById(R.id.card3);
            cardImage.setVisibility(INVISIBLE);
        }
    }


    private void youLostGoHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

}
