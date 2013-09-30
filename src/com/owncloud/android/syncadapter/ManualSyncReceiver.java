package com.owncloud.android.syncadapter;

import android.accounts.Account;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.owncloud.android.R;
import com.owncloud.android.authentication.AccountAuthenticator;
import com.owncloud.android.authentication.AccountUtils;

/**
 * Called from external application for manual sync trigger
 * 
 * @author Kostya
 * 
 */
public class ManualSyncReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context ctx, Intent intent) {
        Account account = AccountUtils.getCurrentOwnCloudAccount(ctx); // Current account
        if (null == account) {
            // Not configured
            return;
        }
        ContentResolver.cancelSync(null, AccountAuthenticator.AUTHORITY);
        // cancel the current synchronizations of any ownCloud account
        Bundle bundle = new Bundle();
        bundle.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true);
        ContentResolver.requestSync(account, AccountAuthenticator.AUTHORITY, bundle);
        Toast.makeText(ctx, R.string.synchronization_started, Toast.LENGTH_SHORT).show();
    }

}
