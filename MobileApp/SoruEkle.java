package com.example.MobileApp;

import androidx.appcompat.app.AppCompatActivity;


import androidx.annotation.Nullable;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.MobileApp.Business.Concretes.CozulenOdevManager;
import com.example.MobileApp.Business.Concretes.TytSoruTuruManager;
import com.example.MobileApp.Business.Concretes.AytSoruTuruManager;
import com.example.MobileApp.Business.Concretes.YdtSoruTuruManager;
import com.example.MobileApp.DataAccess.Abstracts.ICozulenOdevDao;
import com.example.MobileApp.DataAccess.Abstracts.ITytTuruDao;
import com.example.MobileApp.DataAccess.Abstracts.IAytTuruDao;
import com.example.MobileApp.DataAccess.Abstracts.IYdtTuruDao;
import com.example.MobileApp.DataAccess.Concretes.TestDB.CozulenOdevDao;
import com.example.MobileApp.DataAccess.Concretes.TestDB.TytTuruDao;
import com.example.MobileApp.DataAccess.Concretes.TestDB.AytTuruDao;

import com.example.MobileApp.DataAccess.Concretes.TestDB.YdtTuruDao;
import com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite.DataBaseConnection;
import com.example.MobileApp.DataAccess.Concretes.SQLite.SQLite.SQLiteCozulenOdevDao;
import com.example.MobileApp.Entities.Concretes.CozulenOdev;
import com.example.MobileApp.Entities.Concretes.TytSoruTuru;
import com.example.MobileApp.Entities.Concretes.AytvSoruTuru;
import com.example.MobileApp.Entities.Concretes.YdtSoruTuru;

import java.util.ArrayList;
import java.util.Calendar;
public class SoruEkle extends AppCompatActivity {

    private Spinner spinner;
    private ArrayList<TytSoruTuru> TytDersList =new ArrayList<TytSoruTuru>();
    private ArrayList<AytvSoruTuru> AytDersList =new ArrayList<AytvSoruTuru>();
    private ArrayList<YdtSoruTuru> YdtDersList =new ArrayList<>();
    private ArrayAdapter<String> arrayAdapter;
    private ImageButton btn_cek;
    private Button btnKaydet, btnCzln, btnOdv;
    private ImageView imgVFoto;
    private static final int CAMERA_REQUEST=0;

    private ImageButton imgBtnTarihSecim;
    private DatePickerDialog datePickerDialog;
    private TextView txtVTarih;
    private Calendar calendar;
    private int yıl, ay, gun;

    //Kaydetme
    private EditText eTxtTutar,eDTxtDetay;
    private int hesapTür=1;
    private Button btnTyt, btnAyt, btnYdt;
    private Spinner spnTür;
    private int tür=1;
    private Bitmap fototemp;

    double a=1;

    private DataBaseConnection vt;

    private ArrayList<String> TytDers=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gelir_gider_koy);

        btn_cek=findViewById(R.id.imgBtnFoto);
        btnKaydet=findViewById(R.id.btnKaydet);

        imgVFoto=findViewById(R.id.imgVFoto);

        spinner=findViewById(R.id.spnTür);

        btnCzln =findViewById(R.id.btnCozulenSoru);
        btnOdv =findViewById(R.id.btnOdevSoru);

        eTxtTutar=findViewById(R.id.eTxtTutar);
        eDTxtDetay=findViewById(R.id.eDTxtDetay);
        spnTür=findViewById(R.id.spnTür);


        btnTyt =findViewById(R.id.btnTyt);
        btnAyt =findViewById(R.id.btnAyt);
        btnYdt =findViewById(R.id.btnYdt);


        ITytTuruDao cozulenOdevDao=new TytTuruDao();
        TytSoruTuruManager CozulenTuruManager=new TytSoruTuruManager(cozulenOdevDao);

        IAytTuruDao AytTuruDao=new AytTuruDao();
        AytSoruTuruManager AytTuruManager=new AytSoruTuruManager(AytTuruDao);

        IYdtTuruDao YdtSoruTur=new YdtTuruDao();
        YdtSoruTuruManager YdtSoruManager=new YdtSoruTuruManager(YdtSoruTur);

        TytDersList =CozulenTuruManager.GetAll();
        AytDersList =AytTuruManager.GetAll();
        YdtDersList=YdtSoruManager.GetAll();


        ArrayList<String> cozulenOdevTemp=new ArrayList<>();
        btnTyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cozulenOdevTemp.clear();
                for (TytSoruTuru var : TytDersList)
                {
                    cozulenOdevTemp.add(var.getTurAdi());

                }
                spinner.setAdapter(arrayAdapter);
                hesapTür=1;
                Toast.makeText(getApplicationContext(),"Sınav Türü 'TYT' olarak secildi ",Toast.LENGTH_LONG).show();

            }
        });
        btnAyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cozulenOdevTemp.clear();
                for (AytvSoruTuru var : AytDersList)
                {

                    cozulenOdevTemp.add(var.getOdevTurAdi());

                }
                spinner.setAdapter(arrayAdapter);
                hesapTür=2;
                Toast.makeText(getApplicationContext(),"Sınav Türü 'AYT' olarak secildi ",Toast.LENGTH_LONG).show();

            }
        });
        btnYdt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cozulenOdevTemp.clear();
                for (YdtSoruTuru var : YdtDersList)
                {

                    cozulenOdevTemp.add(var.getTurAdi());

                }
                spinner.setAdapter(arrayAdapter);

                hesapTür=3;
                Toast.makeText(getApplicationContext(),"Sınav Türü 'YDT' olarak secildi ",Toast.LENGTH_LONG).show();
            }
        });

        btnCzln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cozulenOdevTemp.clear();
                for (TytSoruTuru var : TytDersList)
                {
                    cozulenOdevTemp.add(var.getTurAdi());

                }
                spinner.setAdapter(arrayAdapter);
                a=a*a;
                tür=1;
            }
        });
        btnOdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                cozulenOdevTemp.clear();
                for (AytvSoruTuru var : AytDersList)
                {

                    cozulenOdevTemp.add(var.getOdevTurAdi());

                }
                spinner.setAdapter(arrayAdapter);
                a=a*-1;

                tür=2;
            }
        });


        arrayAdapter=new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,cozulenOdevTemp);


        spinner.setAdapter(arrayAdapter);



        btn_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST);
            }
        });






        imgBtnTarihSecim = findViewById(R.id.imgBtnTarihSecim);
        txtVTarih = findViewById(R.id.txtVTarih);

        calendar = Calendar.getInstance();
        yıl = calendar.get(Calendar.YEAR);
        ay = calendar.get(Calendar.MONTH);
        gun = calendar.get(Calendar.DAY_OF_MONTH);
        txtVTarih.setText(gun+"/"+(ay+1)+"/"+yıl);
        imgBtnTarihSecim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar = Calendar.getInstance();
                yıl = calendar.get(Calendar.YEAR);
                ay = calendar.get(Calendar.MONTH);
                gun = calendar.get(Calendar.DAY_OF_MONTH);
                txtVTarih.setText(gun+"/"+(ay+1)+"/"+yıl);
                datePickerDialog = new DatePickerDialog(SoruEkle.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                txtVTarih.setText(day + "/" + (month+1) + "/" + year);
                            }
                        }, yıl, ay, gun);
                datePickerDialog.show();
            }
        });



        //Kaydetme Kısmı
        ICozulenOdevDao cozulnOdevDao=new CozulenOdevDao();
        CozulenOdevManager gelirGiderManager=new CozulenOdevManager(cozulnOdevDao);







        vt=new DataBaseConnection(this);
        CozulenOdevManager manager=new CozulenOdevManager(new SQLiteCozulenOdevDao(vt));

        btnKaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // id   tutar               tür                     detay                   tarih               foto
                CozulenOdev temp=new CozulenOdev();
                temp.setId(1);
                double c=0;
                c=Double.valueOf(String.valueOf(eTxtTutar.getText()));
                temp.setTutar(Double.parseDouble(String.valueOf(c*a)));


                temp.setDetay((eDTxtDetay.getText()).toString());
                // temp.setTime((Time) Calendar.getInstance().getTime());
                // temp.setFoto(fototemp);
                temp.setSınav(hesapTür);
                temp.setTür(tür);
                manager.Add(temp);

            }
        });



        int i=0;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK)
        {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imgVFoto.setImageBitmap(image);
            fototemp=image;
        }
    }
}
