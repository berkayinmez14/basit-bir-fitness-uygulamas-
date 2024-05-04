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

import pl.droidsonroids.gif.GifImageView;

public class MekikCekmeActivity extends AppCompatActivity {
    private TextView zamanlayici1TV,mekikSayisiTV,kalori1TV;
    private Button start1button,stop1button;
    private GifImageView komikmekikhareketi;
    private int mekikSayisi=0;
    private CountDownTimer geriSayim;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mekik_cekme);
        zamanlayici1TV=findViewById(R.id.zamanlayici1TV);
        mekikSayisiTV=findViewById(R.id.mekikSayisiTV);
        kalori1TV=findViewById(R.id.kalori1TV);
        start1button=findViewById(R.id.start1button);
        stop1button=findViewById(R.id.stop1button);
        komikmekikhareketi=findViewById(R.id.komikmekikhareketi);

        start1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zamanlayici1Basla();
                mekikCekmeyeBasla();
            }
        });

        stop1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zamanlayici1Dursun();
            }
        });
    }
    private void zamanlayici1Basla(){
        geriSayim=new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long miliSaniyeBiteneKadar) {
                zamanlayici1TV.setText("Kalan süreniz:"+miliSaniyeBiteneKadar/1000+"sn");
            }

            @Override
            public void onFinish() {
                zamanlayici1TV.setText("Süreniz bitti!..");
            }
        }.start();
    }

    private void zamanlayici1Dursun(){
        if(geriSayim != null){
            geriSayim.cancel();
            zamanlayici1TV.setText("Zaman durduruldu");
        }
    }

    private void mekikCekmeyeBasla(){
        geriSayim=new CountDownTimer(30000,2000) {
            @Override
            public void onTick(long miliSaniyeBiteneKadar) {
                mekikSayisi++;
                mekikSayisiTV.setText("Çekilen mekik sayısı:"+mekikSayisi);
                kalori1TV.setText("Yakılan kalori:"+(mekikSayisi*0.6));

            }

            @Override
            public void onFinish() {
                mekikSayisiTV.setText("Mekik çekme işlemi tamamlandı");
                kalori1TV.setText("Yakılan toplam kalori:"+(mekikSayisi*0.6));
            }
        }.start();
    }
}