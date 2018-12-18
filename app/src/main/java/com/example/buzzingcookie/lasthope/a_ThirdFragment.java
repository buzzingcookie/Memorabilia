package com.example.buzzingcookie.lasthope;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class a_ThirdFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.a_third_frag, container, false);

        TextView tv = (TextView) v.findViewById(R.id.tvFragThird);
        tv.setText(getArguments().getString("msg"));

        return v;
    }

    public static a_ThirdFragment newInstance(String text) {

        a_ThirdFragment f = new a_ThirdFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}