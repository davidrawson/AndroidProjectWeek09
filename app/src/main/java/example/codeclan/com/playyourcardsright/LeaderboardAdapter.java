package example.codeclan.com.playyourcardsright;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidrawson on 29/01/2018.
 */

class LeaderboardAdapter extends ArrayAdapter<LeaderEntry>{
    public LeaderboardAdapter(Context context, ArrayList<LeaderEntry> entries) {
        super(context, 0, entries);
    }


    @Override
    public View getView(int position, View leaderListView, ViewGroup parent){
        if (leaderListView == null){
            leaderListView = LayoutInflater.from(getContext()).inflate(R.layout.leaderboard_item, parent, false);
        }
        LeaderEntry currentEntry = getItem(position);

        TextView name = leaderListView.findViewById(R.id.name);
        name.setText(currentEntry.getName());

        TextView roundsCompleted = leaderListView.findViewById(R.id.roundCompleted);
        Log.d(getClass().toString(), "Rounds completed " + currentEntry.getRound());
        roundsCompleted.setText(String.valueOf(currentEntry.getRound()));

        leaderListView.setTag(currentEntry);

        return leaderListView;
    }


}
//


//    @Override
//    public View getView(int position, View listItemView, ViewGroup parent){
//        if (listItemView == null){
//            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.album_item, parent, false);
//        }
//
//        Album currentAlbum = getItem(position);
//
//        TextView ranking = listItemView.findViewById(R.id.ranking);
//        ranking.setText(currentAlbum.getRanking().toString());
//
//        TextView artist = listItemView.findViewById(R.id.artist);
//        artist.setText(currentAlbum.getArtist().toString());
//
//        TextView title = listItemView.findViewById(R.id.title);
//        title.setText(currentAlbum.getTitle().toString());
//
//        TextView year = listItemView.findViewById(R.id.year);
//        year.setText(currentAlbum.getYear().toString());
//
//        listItemView.setTag(currentAlbum);
//
//        return listItemView;
//
//    }
