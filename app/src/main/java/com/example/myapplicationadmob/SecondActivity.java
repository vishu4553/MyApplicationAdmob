package com.example.myapplicationadmob;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class SecondActivity extends AppCompatActivity {
    private AdView mAdMobAdView;
    InterstitialAd mAdMobInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mAdMobInterstitialAd = new InterstitialAd(this);
        mAdMobInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen_ad));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("6CA7D1E44D5B40FD912B77B4B18E14D4")// Add your real device id here
                .build();

        mAdMobInterstitialAd.loadAd(adRequest);
        mAdMobInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitialAd();
            }
        });
    }

    private void showInterstitialAd() {
        if (mAdMobInterstitialAd.isLoaded()) {
            mAdMobInterstitialAd.show();
        }
    }
}

