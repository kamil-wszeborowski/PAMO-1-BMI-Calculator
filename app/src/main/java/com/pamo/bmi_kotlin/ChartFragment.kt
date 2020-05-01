package com.pamo.bmi_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_chart.*

class ChartFragment : Fragment(){
    private var chartWebView: WebView? = null
    private var typeOfChart = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        chartWebView = view.findViewById(R.id.chartWebView)
        if (chartWebView != null) {

            barChartBtn.setOnClickListener {
                typeOfChart = 1
                showSelectedChart(typeOfChart)
            }
            pieChartBtn.setOnClickListener {
                typeOfChart = 2
                showSelectedChart(typeOfChart)
            }
            polarChartBtn.setOnClickListener {
                typeOfChart = 3
                showSelectedChart(typeOfChart)
            }
        }
    }

    fun showSelectedChart(typeOfChart: Int) {
        val webSettings = chartWebView!!.settings
        webSettings.javaScriptEnabled = true

        chartWebView!!.webViewClient = WebViewClient()
        chartWebView!!.webChromeClient = WebChromeClient()
        when (typeOfChart) {
            1 -> chartWebView!!.loadUrl("file:///android_asset/bar_chart.html")
            2 -> chartWebView!!.loadUrl("file:///android_asset/pie_chart.html")
            3 -> chartWebView!!.loadUrl("file:///android_asset/polar_chart.html")
        }
    }


}