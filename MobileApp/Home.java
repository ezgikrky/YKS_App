package com.example.MobileApp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


import com.example.MobileApp.Business.Concretes.CozulenOdevManager;
import com.example.MobileApp.DataAccess.Abstracts.ICozulenOdevDao;
import com.example.MobileApp.DataAccess.Concretes.TestDB.CozulenOdevDao;
import com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite.DataBaseConnection;
import com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite.SQLiteCozulenOdevDao;
import com.example.MobileApp.Entities.Concretes.CozulenOdev;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

public class Home extends Fragment {

    private  PieChart pieChart;
    private ImageButton btnEkle, btnTimer;
    private TextView txtMotivationSen;
    private DataBaseConnection vt;
    private int cözülen;
    private int ödev;
    private int total;

    Random random= new Random();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View v =inflater.inflate(R.layout.fragment_home, container, false);

        btnEkle=v.findViewById(R.id.btnEkle);
        btnTimer =v.findViewById(R.id.btnTimer);
        txtMotivationSen=v.findViewById(R.id.txtMotivationSen);

        // random kelime döndürme
        String[] cümleler={"Başarı seni bulmaz. Sen çıkıp onu yakalamalısın.","Hayatını bugün değiştir. Geleceğin üzerine kumar oynama. Şimdi harekete geç, hemen.","Eğer hayal edebiliyorsanız, yapabilirsiniz.","Yalnızca bugün yaptıkların, bütün yarınlarını değiştirebilir."};
        int kacinciEleman=random.nextInt(cümleler.length);
        txtMotivationSen.setText(cümleler[kacinciEleman]);


        vt=new DataBaseConnection(getActivity());
        CozulenOdevManager CozulenOdevManager=new CozulenOdevManager(new SQLiteCozulenOdevDao(vt));

        for (CozulenOdev var: CozulenOdevManager.GetAll()) {

            if(var.getTutar()>0) {cözülen+=var.getTutar(); total+= var.getTutar();}
            else if(var.getTutar()<0) {ödev+=var.getTutar();total-= var.getTutar();}
        }

        pieChart=v.findViewById(R.id.pieChart);
        loadPieChartData();
        setupPieChart();


        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(getActivity(), SoruEkle.class);
                startActivity(intent);
            }
        });
        btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Kronometre.class);
                startActivity(intent);
            }
        });
        ICozulenOdevDao cozulenOdevDao=new CozulenOdevDao();


        return v;
    }
    private void setupPieChart(){

        pieChart.setDrawHoleEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setEntryLabelTextSize(12);
        pieChart.setCenterText(String.valueOf(total));
        pieChart.setCenterTextSize(24);
        pieChart.getDescription().setEnabled(false);
        pieChart.setHoleRadius(50);
        pieChart.setCenterTextRadiusPercent(500);



        Legend l=pieChart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setEnabled(true);
        l.setForm(Legend.LegendForm.CIRCLE);
    }


    private void loadPieChartData(){

        ArrayList<PieEntry> entries= new ArrayList<>();
        entries.add(new PieEntry(0.5f));
        entries.add(new PieEntry(0.15f));

        ArrayList<Integer> colors=new ArrayList<>();
        for (int color: ColorTemplate.JOYFUL_COLORS){
            colors.add(color);
        }

        for (int color: ColorTemplate.VORDIPLOM_COLORS){
            colors.add(color);
        }

        PieDataSet dataSet=new PieDataSet(entries,"Soru Sayısı");
        dataSet.setColors(colors);

        PieData data =new PieData(dataSet);
        data.setDrawValues(true);
        data.setValueFormatter(new PercentFormatter(pieChart));
        data.setValueTextSize(12f);
        data.setValueTextColor(Color.BLACK);


        pieChart.setData(data);
        pieChart.invalidate();

        pieChart.animateY(1400, Easing.EaseInOutQuad);

    }
}