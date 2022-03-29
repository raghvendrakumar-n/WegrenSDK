package com.wegren.wegrenmarketingapp;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class WegrenApp extends Application {
    private RequestQueue requestQueue;

    public void systemInformationSent(Context context, String tenantId, String productId) {
        String url = Config.BASE_URL+"system-information-create/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                response -> Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show(),
                error -> Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("RELEASE", Build.VERSION.RELEASE);
                params.put("INCREMENTAL", Build.VERSION.INCREMENTAL);
                params.put("SDK_NUMBER", String.valueOf(Build.VERSION.SDK_INT));
                params.put("BOARD", Build.BOARD);
                params.put("BOOTLOADER", Build.BOOTLOADER);
                params.put("BRAND", Build.BOARD);
                params.put("CPU_ABI", Build.CPU_ABI);
                params.put("CPU_ABI2", Build.CPU_ABI2);
                params.put("DISPLAY", Build.DISPLAY);
                params.put("FINGERPRINT", Build.FINGERPRINT);
                params.put("HARDWARE", Build.HARDWARE);
                params.put("HOST", Build.HOST);
                params.put("ID", Build.ID);
                params.put("MANUFACTURER", Build.MANUFACTURER);
                params.put("PRODUCT", Build.PRODUCT);
                params.put("SERIAL", Build.SERIAL);
                params.put("TAGS", Build.TAGS);
                params.put("TIME", String.valueOf(Build.TIME));
                params.put("TYPE", Build.TYPE);
                params.put("UNKNOWN", Build.UNKNOWN);
                params.put("USER", Build.USER);
                params.put("tenantId", tenantId);
                params.put("productId", productId);
                return params;
            }
        };
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        requestQueue.add(stringRequest);
    }
}

