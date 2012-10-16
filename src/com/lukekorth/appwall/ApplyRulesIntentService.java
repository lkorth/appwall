package com.lukekorth.appwall;

import android.content.Intent;
import android.widget.Toast;

import com.commonsware.cwac.wakeful.WakefulIntentService;

public class ApplyRulesIntentService extends WakefulIntentService {

    public ApplyRulesIntentService() {
        super("ApplyRulesIntentService");
    }

    @Override
    protected void doWakefulWork(Intent intent) {
        if (!Api.applySavedIptablesRules(this, false)) {
            // Error enabling firewall on boot
            Toast.makeText(this, R.string.toast_error_enabling, Toast.LENGTH_SHORT);
            Api.setEnabled(this, false);
        }
    }

}
