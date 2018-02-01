package example.codeclan.com.playyourcardsright;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.View.INVISIBLE;

public class MainActivity extends AppCompatActivity {

    private ImageView firstView;
    private ImageView nextView;
    private ImageView messageView;
    private View higherButton;
    private View lowerButton;
    private Game game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        higherButton = findViewById(R.id.higherButton);
        higherButton.setTag("higher");
        lowerButton = findViewById(R.id.lowerButton);
        lowerButton.setTag("lower");
        messageView = findViewById(R.id.messageBox);
        messageView.setVisibility(INVISIBLE);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String gameType = extras.getString("button");

        if (gameType.equals("full")){
            game = new Game(51);
        }
        if (gameType.equals("five")){
            game = new Game(4);
        }

        setCards();

    }

    public void onHigherLowerButtonClick(View button){
        hideButtonsRevealCard();

        if (game.checkForRoundWin(button.getTag()) == "win"){
            if (game.checkGameOver()){
                gameIsWon();
            } else{
                messageView.setImageResource(R.drawable.good_game);
                displayMessage();
            }
        }else{
            MediaPlayer mp = MediaPlayer.create(this, R.raw.ff_buzzer);
            mp.start();
            if (game.checkForRoundWin(button.getTag()) == "draw"){
                messageView.setImageResource(R.drawable.a_draw);
                displayMessage();
            }else{
                // loser
                messageView.setImageResource(R.drawable.you_just_lost);
                displayMessage();
            }
        }
    }

    public void gameIsWon(){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.fanfare);
        mp.start();
        messageView.setImageResource(R.drawable.winner);
        displayMessage();
    }

    public void displayMessage(){
        messageView.setVisibility(View.VISIBLE);
    }

    public void hideButtonsRevealCard(){
        View refreshButton = findViewById(R.id.refreshButton);
        refreshButton.setVisibility(INVISIBLE);
        higherButton.setVisibility(INVISIBLE);
        lowerButton.setVisibility(INVISIBLE);
        String cardID = game.getNextCard().getImageFile();
        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());
        nextView = findViewById(R.id.nextCard);
        nextView.setImageResource(cardPic);
    }

    public void onChangeCardButtonClick(View refreshButton){
        game.changeFirstCard();
        String cardID = game.getFirstCard().getImageFile();
        int cardPic = getResources().getIdentifier(cardID, "drawable", getPackageName());
        firstView.setImageResource(cardPic);
        refreshButton.setVisibility(INVISIBLE);
    }

    public void onMessageClick(View messageButton){
        if (game.checkGameOver()) { goBoardEntryOrHome();}

        if (game.getResult() == "win"){
            messageButton.setVisibility(INVISIBLE);
            game.moveCards();
            setCards();
            removeDownturnedCard();
        }else{
            goBoardEntryOrHome();
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

        TextView roundCounter = findViewById(R.id.roundCount);
        roundCounter.setText("Round: " + game.getRoundNumber());
    }

    public void removeDownturnedCard() {
        if (game.getRoundsTotal() - game.getRoundNumber() == 2){
            View cardImage = findViewById(R.id.card5);
            cardImage.setVisibility(INVISIBLE);
        }
        if (game.getRoundsTotal() - game.getRoundNumber() == 1){
            View cardImage = findViewById(R.id.card4);
            cardImage.setVisibility(INVISIBLE);
        }
        if (game.getRoundsTotal() - game.getRoundNumber() == 0){
            View cardImage = findViewById(R.id.card3);
            cardImage.setVisibility(INVISIBLE);
        }
    }


    private void goBoardEntryOrHome() {
        LeaderDatabase db = LeaderDatabase.getAppDatabase(this);

        int worstScore = 0;
        if (db.entryDao().getAllAsc().size() > 0) {
            worstScore = db.entryDao().getAllAsc().get(0).getScore();
        }

        if (game.getScore() > worstScore || db.entryDao().getAllAsc().size() < 10){

            if (db.entryDao().getAllAsc().size() > 9) {
                db.entryDao().delete(db.entryDao().getAllAsc().get(0));
            }
            Intent intent = new Intent(this, BoardEntryActivity.class);
            intent.putExtra("score", game.getScore());
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }

    }

}
