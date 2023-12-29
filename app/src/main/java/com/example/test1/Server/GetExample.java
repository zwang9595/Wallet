package com.example.test1.Server;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Server test, not used
 * Zhao Wang
 * April 08, 2020
 */
class GetExample {
    OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("http://ugst.ddns.net/user");
        System.out.println(response);
    }
}
