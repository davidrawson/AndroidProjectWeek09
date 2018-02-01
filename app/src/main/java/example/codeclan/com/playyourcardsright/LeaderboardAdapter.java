package example.codeclan.com.playyourcardsright;

import android.content.Context;
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
        roundsCompleted.setText(String.valueOf(currentEntry.getScore()));

        leaderListView.setTag(currentEntry);

        return leaderListView;
    }


}
