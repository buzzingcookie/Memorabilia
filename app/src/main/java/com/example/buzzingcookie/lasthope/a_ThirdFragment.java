package com.example.buzzingcookie.lasthope;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class a_ThirdFragment extends Fragment {

    String Titles[] = {"LOBBY", "CONFERENCE HALL", "OASIS", "NIRVANA", "3rd HALF", "KING'S HALL", "ROCK ROYALTY"};

    int rowImages[] = {R.drawable.lobby, R.drawable.conferencehall, R.drawable.nirvanatower, R.drawable.nirvanatower2sunset, R.drawable.thirdhalf, R.drawable.kingshall, R.drawable.rockroyalty};
    int blackGradients[] = {R.drawable.list_rectangle, R.drawable.list_rectangle, R.drawable.list_rectangle, R.drawable.list_rectangle, R.drawable.list_rectangle, R.drawable.list_rectangle, R.drawable.list_rectangle};
    int goldLogos[] = {R.drawable.whitelogo, R.drawable.whitelogo,R.drawable.whitelogo,R.drawable.whitelogo,R.drawable.whitelogo,R.drawable.whitelogo,R.drawable.whitelogo, };
    int topBars[] = {0,R.drawable.purple_bar,R.drawable.purple_bar,R.drawable.purple_bar,R.drawable.purple_bar,R.drawable.purple_bar,R.drawable.purple_bar};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.a_third_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragThird);
        tv.setText(getArguments().getString("msg"));

        ListView list = (ListView) v.findViewById(R.id.list1);

        final ImageView rowImage = (ImageView) v.findViewById(R.id.row_image);

        MyAdapter adapter = new MyAdapter(getActivity(), Titles, rowImages, blackGradients, goldLogos, topBars);
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
                    OasisView();
                }
                if (position == 3) {
                    NirvanaView();
                }
                if (position == 4) {
                    ThirdHalfView();
                }
                if (position == 5) {
                    KingsHall();
                }
                if (position == 6) {
                    RockRoyalty();
                }
            }
        });


        return v;
    }

    public void LobbyView(){
        Intent i = new Intent(getActivity(), LobbyView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void ConferenceHallView(){
        Intent i = new Intent(getActivity(), ConferenceHallView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void OasisView(){
        Intent i = new Intent(getActivity(), OasisView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void NirvanaView(){
        Intent i = new Intent(getActivity(), NirvanaView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void ThirdHalfView(){
        Intent i = new Intent(getActivity(), ThirdHalfView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void KingsHall(){
        Intent i = new Intent(getActivity(), KingsHallView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void RockRoyalty(){
        Intent i = new Intent(getActivity(), RockRoyaltyView.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }


    public static a_ThirdFragment newInstance(String text) {

        a_ThirdFragment f = new a_ThirdFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    public class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String myTitles[];
        int[] myRowImages;
        int[] myBlackgradients;
        int[] myGoldLogo;
        int[] topBarList;

        MyAdapter(Context c, String[] Titles, int[] rowImages, int[] blackGradients, int[] goldLogos, int[] topBarList) {

            super(c, R.layout.row, R.id.text1, Titles);
            this.context = c;
            this.myTitles = Titles;
            this.myRowImages = rowImages;
            this.myBlackgradients = blackGradients;
            this.myGoldLogo = goldLogos;
            this.topBarList = topBarList;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);

            TextView title = row.findViewById(R.id.text1);
            ImageView rowimage = row.findViewById(R.id.row_image);
            ImageView black = row.findViewById(R.id.blackGradient);
            ImageView goldLogo = row.findViewById(R.id.gold_hrLogo);
            ImageView topblack = row.findViewById(R.id.purple_bar);

            Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/apex-sans-book-regular.ttf");
            title.setTypeface(typeface);


            title.setText(Titles[position]);
            rowimage.setImageResource(rowImages[position]);
            black.setImageResource(blackGradients[position]);
            goldLogo.setImageResource(goldLogos[position]);
            topblack.setImageResource(topBars[position]);

            return row;
        }
    }
}