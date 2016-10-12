package com.richardspellman.colors.android;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.richardspellman.colors.ColorsMain;


public class AndroidLauncher extends AndroidApplication{
	private static final String TAG = "AndroidLauncher";
	protected AdView adView;
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		RelativeLayout layout = new RelativeLayout(this);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		config.numSamples = 2;
		config.useAccelerometer = true;
		View gameView = initializeForView(new ColorsMain(), config);
		layout.addView(gameView);

		adView = new AdView(this);
		adView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				Log.i(TAG, "Ad Loaded...");
			}
		});
		adView.setAdSize(AdSize.SMART_BANNER);

		adView.setAdUnitId("ca-app-pub-3451818456854283/3539783292");

		AdRequest.Builder builder = new AdRequest.Builder();
    builder.addTestDevice("E279A9A6D36AE6D8C4AD53E732662D65");
		RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT
		);
    adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		layout.addView(adView, adParams);
		adView.loadAd(builder.build());
		setContentView(layout);

	}

}
