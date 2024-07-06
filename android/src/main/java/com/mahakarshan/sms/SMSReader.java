package com.mahakarshan.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.getcapacitor.PluginCall;

public class SMSReader {
    private BroadcastReceiver otpReceiver;

    public void readSMS(final PluginCall call, Context context) {
        otpReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String otp = intent.getStringExtra("otp");
                Log.d("SMSReader", "Received OTP: " + otp);
                call.resolve(createResult(otp));
                context.unregisterReceiver(otpReceiver);
            }
        };

        context.registerReceiver(otpReceiver, new IntentFilter("otpReceived"));
    }

    private JSObject createResult(String otp) {
        JSObject result = new JSObject();
        result.put("otp", otp);
        return result;
    }
}
