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

public class BisikletHareketiActivity extends AppCompatActivity {
    private TextView zamanlayici3TV,mesaj1TV,kalori3TV;
    private int sureBisiklet=30;
    private CountDownTimer geriSayim;
    private GifImageView bisikletHareketi;
    private double yakilanKalori=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisiklet_hareketi);
        zamanlayici3TV=findViewById(R.id.zamanlayici3TV);
        mesaj1TV=findViewById(R.id.mesaj1TV);
        kalori3TV=findViewById(R.id.kalori3TV);
        bisikletHareketi=findViewById(R.id.bisikletHareketi);

        baslatGeriSayimBisiklet();
    }

    private void baslatGeriSayimBisiklet(){
        geriSayim=new CountDownTimer(sureBisiklet*1000,1000) {
            @Override
            public void onTick(long miliSaniyeBiteneKadar) {
                zamanlayici3TV.setText("Kalan süreniz:"+miliSaniyeBiteneKadar/1000+" sn");
                yakilanKalori+=0.7;
                kalori3TV.setText("Yakılan kalori:"+String.format(".%2f",yakilanKalori));

                if(miliSaniyeBiteneKadar/1000==10){
                    mesaj1TV.setText("BÖYLE DEVAM ET");
                } else if (miliSaniyeBiteneKadar/1000==20) {
                    mesaj1TV.setText("DAHA DA HIZLAN!!!");
                }
            }

            @Override
            public void onFinish() {
                zamanlayici3TV.setText("Süreniz bitti");
                mesaj1TV.setText("İŞTE İSTEDİĞİM HIRS BU");
                yakilanKalori+=0.7;
                kalori3TV.setText("Yakılan kalori:"+String.format(".%2f",yakilanKalori));
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