package com.mahakarshan.sms;

import android.Manifest;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.PluginMethod;

@CapacitorPlugin(name = "SmsReader")
public class SMSReaderPlugin extends Plugin {
    private SMSReader implementation = new SMSReader();

    @PluginMethod
    public void startWatching(PluginCall call) {
        String searchString = call.getString("searchString");
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 1);
        } else {
            implementation.startWatching(call, getContext(), searchString);
        }
    }

    @PluginMethod
    public void stopWatching(PluginCall call) {
        implementation.stopWatching(call, getContext());
    }

    @PluginMethod
    public void readSMS(PluginCall call) {
        String searchString = call.getString("searchString");
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED ||
            ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_SMS}, 1);
        } else {
            implementation.readSMS(call, getContext(), searchString);
        }
    }
}
