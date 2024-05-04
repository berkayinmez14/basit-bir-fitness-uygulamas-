package com.berkus.fitnessuygulamas;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pl.droidsonroids.gif.GifImageView;

public class PlankActivity extends AppCompatActivity {
    private TextView zamanlayici2TV,mesajTV,kalori2TV;
    private CountDownTimer geriSayim;
    private int sure=30;
    private GifImageView plankHareketi;
    private double yakilanKaloriPlank=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plank);
        zamanlayici2TV=findViewById(R.id.zamanlayici2TV);
        mesajTV=findViewById(R.id.mesajTV);
        kalori2TV=findViewById(R.id.kalori2TV);
        plankHareketi=findViewById(R.id.plankHareketi);

        baslatGeriSayim();
    }

    private void baslatGeriSayim(){
        geriSayim=new CountDownTimer(sure*1000,1000) {
            @Override
            public void onTick(long miliSaniyeBiteneKadar) {
                zamanlayici2TV.setText("Kalan süreniz:"+miliSaniyeBiteneKadar/1000+" sn");
                yakilanKaloriPlank+=0.5;
                kalori2TV.setText("Yakılan kalori:"+String.format("%.2f",yakilanKaloriPlank));
                if(miliSaniyeBiteneKadar/1000==10){
                    mesajTV.setText("İYİ GİDİYORSUN");
                } else if (miliSaniyeBiteneKadar/1000==20) {
                    mesajTV.setText("ÇOK AZ KALDI,DAYAN");
                }
            }

            @Override
            public void onFinish() {
                zamanlayici2TV.setText("Süreniz bitti!...");
                mesajTV.setText("HARİKASIN..");
                yakilanKaloriPlank+=0.5;
                kalori2TV.setText("Yakılan kalori:"+String.format("%.2f",yakilanKaloriPlank));
            }
        }.start();
    }
    protected void onDestroy(){
        super.onDestroy();
        if(geriSayim != null){
            geriSayim.cancel();
        }
    }
}