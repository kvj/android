package org.kvj.owncloud.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class UI extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ui);
		findViewById(R.id.button_sync).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						startSync();
					}
				});
	}

	protected void startSync() {
		Intent intent = new Intent("com.owncloud.MANUAL_SYNC");
		sendBroadcast(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ui, menu);
		return true;
	}

}
