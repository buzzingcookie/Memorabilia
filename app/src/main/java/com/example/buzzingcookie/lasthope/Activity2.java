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

public class Activity2 extends AppCompatActivity {

    String Titles[] = {"LOBBY", "CONFERENCE HALL", "NIRVANA"};

    int rowImages[] = {R.drawable.lobby, R.drawable.conferencehall, R.drawable.nirvanatower};
    int blackGradients[] = {R.drawable.black_gradient, R.drawable.black_gradient, R.drawable.black_gradient};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ListView list = (ListView) findViewById(R.id.list1);

        MyAdapter adapter = new MyAdapter(this, Titles, rowImages, blackGradients);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0) {
                    LobbyView();
                }
                if (position == 1) {
                    Toast.makeText(Activity2.this, "Item One Two", Toast.LENGTH_SHORT).show();
                }
                if (position == 2) {
                    Toast.makeText(Activity2.this, "Item One Three", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void LobbyView(){
        Intent i = new Intent(this, LobbyView.class);
        startActivity(i);
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

            title.setText(Titles[position]);
            rowimage.setImageResource(rowImages[position]);
            black.setImageResource(blackGradients[position]);

            return row;
        }
    }
}
