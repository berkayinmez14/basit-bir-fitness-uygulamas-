package com.berkus.fitnessuygulamas;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {
    private TextView adimsayarTV,yakilanKaloriTV;
    private Button Baslatmabutonu,Durdurmabutonu,sinavCekmeButonu,mekikCekmeButonu,plankCekmeButonu,bisikletYapButonu;
    private GifImageView forestGumpImageView;
    private int adimSayisi=0,yakilanKalori=0;
    private boolean izlemeDevamEdiyormu=false;
    private static final int ADIM_BASI_KALORİ=10;
    private AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adimsayarTV=findViewById(R.id.adimsayarTV);
        yakilanKaloriTV=findViewById(R.id.yakilanKaloriTV);
        Baslatmabutonu=findViewById(R.id.Baslatmabutonu);
        Durdurmabutonu=findViewById(R.id.Durdurmabutonu);
        sinavCekmeButonu=findViewById(R.id.sinavCekmeButonu);
        mekikCekmeButonu=findViewById(R.id.mekikCekmeButonu);
        plankCekmeButonu=findViewById(R.id.plankCekmeButonu);
        bisikletYapButonu=findViewById(R.id.bisikletYapButonu);
        forestGumpImageView = findViewById(R.id.forestGumpImageView);

        Baslatmabutonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                izlemeyeBasla();
            }
        });

        sinavCekmeButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SinavCekmeActivity.class);
                startActivity(intent);
            }
        });

        mekikCekmeButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,MekikCekmeActivity.class);
                startActivity(intent1);
            }
        });

        plankCekmeButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,PlankActivity.class);
                startActivity(intent2);
            }
        });

        bisikletYapButonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this,BisikletHareketiActivity.class);
                startActivity(intent3);
            }
        });


        Durdurmabutonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                izlemeyiDurdur();
            }
        });



    }
    private void izlemeyeBasla(){
        izlemeDevamEdiyormu=true;
        adimSayisi++;
        guncelAdimSayisi();
        if(adimSayisi % ADIM_BASI_KALORİ==0){
            kaloriHesaplama();
            guncelYakilanKalori();
        }
        if(adimSayisi==10){
            forestGumpImageView.setVisibility(View.VISIBLE);
            forestGumpImageView.setImageResource(R.drawable.forrestgump);
            GifDrawable gifDrawable=(GifDrawable) forestGumpImageView.getDrawable();
            animationDrawable=new AnimationDrawable();
            animationDrawable.addFrame(gifDrawable,100);
            animationDrawable.setOneShot(false);
            forestGumpImageView.setImageDrawable(animationDrawable);
            animationDrawable.start();

            sinavCekmeButonu.setVisibility(View.GONE);
            mekikCekmeButonu.setVisibility(View.GONE);
            plankCekmeButonu.setVisibility(View.GONE);
            bisikletYapButonu.setVisibility(View.GONE);
        }
    }

    private void izlemeyiDurdur(){
        izlemeDevamEdiyormu=false;
    }

    private void guncelAdimSayisi(){
        adimsayarTV.setText("Adım sayısı:"+adimSayisi);
    }
    private void kaloriHesaplama(){
        yakilanKalori++;
    }
    private void guncelYakilanKalori(){
        yakilanKaloriTV.setText("Yaktığınız kalori:"+yakilanKalori);
    }
}