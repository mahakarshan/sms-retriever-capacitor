package com.mahakarshan.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver {

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
                    Log.d("SMSReceiver", "Message from " + phoneNumber + ": " + msg);

                    // Define your search string for the OTP
                    String searchString = "Your OTP is: ";
                    if (msg.contains(searchString)) {
                        String otp = msg.substring(msg.indexOf(searchString) + searchString.length());
                        Log.d("SMSReceiver", "OTP: " + otp);
                        // Broadcast the OTP to the plugin
                        Intent otpIntent = new Intent("otpReceived");
                        otpIntent.putExtra("otp", otp);
                        context.sendBroadcast(otpIntent);
                    }
                }
            }
        }
    }
}
