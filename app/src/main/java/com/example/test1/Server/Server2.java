package com.example.test1.Server;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

import com.example.test1.R;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

public class Server2 extends AppCompatActivity {

    Button button_request;
    TextView textView_response;

    private Handler handler = new Handler() {
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          switch (msg.what) {
              case 1:
                  String response = (String) msg.obj;
                  textView_response.setText(response);
                  break;

              default:
                  break;
          }
      }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server2);

        button_request = (Button)findViewById(R.id.button1);
        textView_response = (TextView)findViewById(R.id.TextView1);

        button_request.setOnClickListener(new View.OnClickListener() {

            //点击按钮时，执行sendRequestWithHttpClient()方法里面的线程
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                try {
                    sendRequestWithHttpClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void sendRequestWithHttpClient() throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                GetExample example = new GetExample();
                AtomicReference<String> res = new AtomicReference<>("");
                try {
                    res.set(example.run("http://ugst.ddns.net/user"));
                    Message message = new Message();
                    message.what = 1;
                    message.obj = res.get();
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
