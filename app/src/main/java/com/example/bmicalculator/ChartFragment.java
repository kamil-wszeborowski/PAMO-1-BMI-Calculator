package com.example.bmicalculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ChartFragment extends Fragment {
    private WebView chartWebView;
    private WebSettings webSettings;
    private Button barChartBtn;
    private Button pieChartBtn;
    private Button polarChartBtn;

    private int typeOfChart = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chart, container, false);

        barChartBtn = view.findViewById(R.id.barChartBtn);
        pieChartBtn = view.findViewById(R.id.pieChartBtn);
        polarChartBtn = view.findViewById(R.id.polarChartBtn);
        chartWebView = (WebView) view.findViewById(R.id.chartWebView);

        barChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeOfChart = 1;
                showSelectedChart(typeOfChart);
            }
        });

        pieChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeOfChart = 2;
                showSelectedChart(typeOfChart);
            }
        });

        polarChartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typeOfChart = 3;
                showSelectedChart(typeOfChart);
            }
        });


        return view;
    }

    public void showSelectedChart(int typeOfChart){
        chartWebView.setWebViewClient(new WebViewClient());

        webSettings = chartWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        chartWebView.setWebChromeClient(new WebChromeClient());

        switch (typeOfChart){
            case 1:
                chartWebView.loadUrl("file:///android_asset/bar_chart.html");
                break;
            case 2:
                chartWebView.loadUrl("file:///android_asset/pie_chart.html");
                break;
            case 3:
                chartWebView.loadUrl("file:///android_asset/polar_chart.html");

        }
    }


}
