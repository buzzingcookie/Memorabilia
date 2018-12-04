package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class Activity2 extends AppCompatActivity {

    String Titles[] = {"LOBBY", "CONFERENCE HALL", "OASIS", "NIRVANA", "3rd HALF", "KING'S HALL", "ROCK ROYALTY"};

    int rowImages[] = {R.drawable.lobby, R.drawable.conferencehall, R.drawable.nirvanatower, R.drawable.nirvanatower2sunset, R.drawable.thirdhalf, R.drawable.kingshall, R.drawable.rockroyalty};
    int blackGradients[] = {R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ListView list = (ListView) findViewById(R.id.list1);

        MyAdapter adapter = new MyAdapter(this, Titles, rowImages, blackGradients);
        list.setAdapter(adapter);
        list.setDivider(null);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    LobbyView();
                }
                if (position == 1) {
                    ConferenceHallView();
                }
                if (position == 2) {
                    Toast.makeText(Activity2.this, "Item One Clicked", Toast.LENGTH_SHORT).show();
                }
                if (position == 3) {
                    Toast.makeText(Activity2.this, "Item One Clicked", Toast.LENGTH_SHORT).show();
                }
                if (position == 4) {
                    Toast.makeText(Activity2.this, "Item One Clicked", Toast.LENGTH_SHORT).show();
                }
                if (position == 5) {
                    Toast.makeText(Activity2.this, "Item One Clicked", Toast.LENGTH_SHORT).show();
                }
                if (position == 6) {
                    Toast.makeText(Activity2.this, "Item One Clicked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void LobbyView(){
        Intent i = new Intent(this, LobbyView.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public void ConferenceHallView(){
        Intent i = new Intent(this, ConferenceHallView.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    public class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String myTitles[];
        int[] myRowImages;
        int[] myBlackgradients;

        MyAdapter(Context c, String[] Titles, int[] rowImages, int[] blackGradients) {

            super(c, R.layout.row, R.id.text1, Titles);
            this.context = c;
            this.myTitles = Titles;
            this.myRowImages = rowImages;
            this.myBlackgradients = blackGradients;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);

            TextView title = row.findViewById(R.id.text1);
            ImageView rowimage = row.findViewById(R.id.row_image);
            ImageView black = row.findViewById(R.id.blackGradient);
            ImageView purpleBar = row.findViewById(R.id.purple_bar);

            title.setText(Titles[position]);
            rowimage.setImageResource(rowImages[position]);
            black.setImageResource(blackGradients[position]);

            return row;
        }
    }
}
