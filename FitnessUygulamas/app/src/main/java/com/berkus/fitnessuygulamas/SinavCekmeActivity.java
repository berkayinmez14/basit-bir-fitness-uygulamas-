package com.berkus.fitnessuygulamas;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pl.droidsonroids.gif.GifImageButton;
import pl.droidsonroids.gif.GifImageView;

public class SinavCekmeActivity extends AppCompatActivity {
    private TextView zamanlayiciTV,sinavSayisiTV,kaloriTV;
    private Button startbutton,stopbutton;
    private int sinavSayisi=0;
    private GifImageView kaptanAmerikaImageView;
    private CountDownTimer gerisayim;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinav_cekme);
        zamanlayiciTV=findViewById(R.id.zamanlayiciTV);
        sinavSayisiTV=findViewById(R.id.sinavSayisiTV);
        kaloriTV=findViewById(R.id.kaloriTV);
        kaptanAmerikaImageView=findViewById(R.id.kaptanAmerikaImageView);
        startbutton=findViewById(R.id.startbutton);
        stopbutton=findViewById(R.id.stopbutton);

        startbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zamanlayiciBasla();
                sinavCekmeyeBasla();
            }
        });

        stopbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zamanlayiciDursun();
            }
        });
    }
    private void zamanlayiciBasla(){
        gerisayim=new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long miliSaniyeBiteneKadar) {
                zamanlayiciTV.setText("Kalan süreniz:"+miliSaniyeBiteneKadar/1000+" sn");
            }

            @Override
            public void onFinish() {
                zamanlayiciTV.setText("Süreniz Bitti!!!");
            }
        }.start();
    }
    private void zamanlayiciDursun(){
        if(gerisayim != null){
            gerisayim.cancel();
            zamanlayiciTV.setText("Zaman Durduruldu");
        }
    }

    private void sinavCekmeyeBasla(){
        gerisayim=new CountDownTimer(20000,2000) {
            @Override
            public void onTick(long miliSaniyeBiteneKadar) {
                sinavSayisi++;
                sinavSayisiTV.setText("Şınav sayısı:"+sinavSayisi);
                kaloriTV.setText("Yakılan Kalori:"+(sinavSayisi*0.8));
            }

            @Override
            public void onFinish() {
                sinavSayisiTV.setText("Şınav çekme işlemi tamamlandı");
                kaloriTV.setText("Yakılan toplam kalori:"+(sinavSayisi*0.8));
            }
        }.start();
    }
}