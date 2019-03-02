package com.example.buzzingcookie.lasthope;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import java.util.Calendar;

public class a_SecondFragment extends Fragment implements DatePickerDialog.OnDateSetListener{

    public WebView webView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.a_second_frag, container, false);

        webView = v.findViewById(R.id.web_View);


        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://vibelineup.wordpress.com/");

        return v;
    }

    public static a_SecondFragment newInstance(String text) {

        a_SecondFragment f = new a_SecondFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

    }

    public void TimePickerM() {

        Calendar calendar = Calendar.getInstance();
        int Year = calendar.get(Calendar.YEAR);
        int Month = calendar.get(Calendar.MONTH);
        int DayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), AlertDialog.THEME_HOLO_DARK,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker datePicker, int Year, int Month, int DayOfMonth) {



                            }
                        }, Year, Month, DayOfMonth);

                datePickerDialog.show();
    }
}


