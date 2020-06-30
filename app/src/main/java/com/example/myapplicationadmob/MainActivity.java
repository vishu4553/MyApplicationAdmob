package com.example.myapplicationadmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    private AdView mAdMobAdView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdMobAdView = (AdView) findViewById(R.id.admob_adview);
        MobileAds.initialize(this, "ca-app-pub-5768549380095167~3595031825");
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("6CA7D1E44D5B40FD912B77B4B18E14D4")// Add your real device id here
                .build();
        adRequest = new AdRequest.Builder().build();
        mAdMobAdView.loadAd(adRequest);



        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });
    }
}