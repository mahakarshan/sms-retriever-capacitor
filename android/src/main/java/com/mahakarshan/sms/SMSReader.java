package com.mahakarshan.sms;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

import androidx.core.content.ContextCompat;

import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

public class SMSReader {
    private BroadcastReceiver SmsReceiver;
    private boolean isRegistered = false;

    public void startWatching(final PluginCall call, Context context, final String searchString) {
        if (isRegistered) {
          //  call.resolve();
            return;
        }

        // Check for SMS permissions
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(context, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            call.reject("SMS permissions not granted");
            return;
        }

        // Create the BroadcastReceiver to listen for incoming SMS
        SmsReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
                    Bundle bundle = intent.getExtras();
                    if (bundle != null) {
                        Object[] pdus = (Object[]) bundle.get("pdus");
                        SmsMessage[] messages = new SmsMessage[pdus.length];
                        for (int i = 0; i < pdus.length; i++) {
                            messages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                            String msg = messages[i].getMessageBody();
                            String phoneNumber = messages[i].getOriginatingAddress();
                            Log.d("SMSReader", "Message from " + phoneNumber + ": " + msg);

                            if (msg.contains(searchString)) {
                                String otp = msg.substring(msg.indexOf(searchString) + searchString.length());
                                Log.d("SMSReader", "OTP: " + otp);
                                call.resolve(createResult(otp));
                                stopWatchingInternal(context);
                                return;
                            }
                        }
                    }
                }
            }
        };

        // Register the receiver
        context.registerReceiver(SmsReceiver, new IntentFilter("android.provider.Telephony.SMS_RECEIVED"));
        isRegistered = true;
       // call.resolve();
    }

    public void stopWatching(final PluginCall call, Context context) {
        stopWatchingInternal(context);
        call.resolve();
    }

    public void readSMS(final PluginCall call, Context context, final String searchString) {
        startWatching(call, context, searchString);
    }

    private void stopWatchingInternal(Context context) {
        if (isRegistered) {
            context.unregisterReceiver(SmsReceiver);
            isRegistered = false;
        }
    }

    private JSObject createResult(String otp) {
        JSObject result = new JSObject();
        result.put("otp", otp);
        return result;
    }
}
