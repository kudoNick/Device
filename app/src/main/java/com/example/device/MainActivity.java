package com.example.device;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Manufacturer();
        ModelCode();
        RAMTotalMem();
        ScreenSizes();
        ScreenDensities();
        AndroidSDKVersions();
        ABIs();
        SystemOnChip();
        OpenGLESVersions();
    }

    private String OpenGLESVersions() {
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();

        Log.d("AAA: OpenGLESVersions", String.valueOf(Double.parseDouble(configurationInfo.getGlEsVersion())));
        return String.valueOf(Double.parseDouble(configurationInfo.getGlEsVersion()));
    }

    private int AndroidSDKVersions() {
        int androidSDKVersions = Build.VERSION.SDK_INT;
        Log.d("AAA: androidSDKVersions", String.valueOf(androidSDKVersions));

        return androidSDKVersions;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private String ABIs() {

        List<String> a = new ArrayList<>();
        for (int i = 0; i <Build.SUPPORTED_ABIS.length; i++) {
             String ABI = Build.SUPPORTED_ABIS[i];
            a.add(ABI);
        }
        Log.d("AAA: ABIs", String.valueOf(a));
        return String.valueOf(a);
    }

    private int ScreenDensities() {
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int densityDpi = (int)(metrics.density * 160f);

        Log.d("AAA: screenDensities", String.valueOf(densityDpi));
        return densityDpi;
    }

    private int ScreenSizes() {
        DisplayMetrics a = getResources().getDisplayMetrics();
        int b = a.widthPixels;
        int c = a.heightPixels;
        String screenSizes = c + "x" + b;
        Log.d("AAA: screenSizes", screenSizes);

        return screenSizes.length();
    }

    private String SystemOnChip() {
        String systemOnChip = Build.HARDWARE;
        Log.d("AAA: SystemOnChip " , Build.HARDWARE);
        return systemOnChip;
    }

    private long RAMTotalMem() {
        ActivityManager actManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        ActivityManager.MemoryInfo memInfo = new ActivityManager.MemoryInfo();
        actManager.getMemoryInfo(memInfo);
        long totalMemory = memInfo.totalMem / (1024*1024);

        Log.d("AAA: RAM", String.valueOf(totalMemory) +"MB");

        return totalMemory;
    }

    private String ModelCode() {
        String modelCode = Build.MODEL;
        Log.d("AAA: ModelCode", modelCode);
        return modelCode;
    }


    private String Manufacturer() {
        String manufacturer = Build.MANUFACTURER;

        Log.d("AAA: manufacturer",manufacturer);

        return manufacturer;
    }

}