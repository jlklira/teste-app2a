package com.teste.app1a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MessageReceiver receiver = new MessageReceiver(new Message());

        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("time", 100);
        intent.putExtra("receiver", receiver);
        startService(intent);

        Log.d("STEP", "Main t Activity inicio");
        Thread t = new Thread(){
            @Override
            public void run() {
                // super.run();
                try{
                    Thread.sleep(2000);
                    Log.d("STEP", "FECHANDO A MainActivity");
                    finish();
                } catch (Exception e){ }
            }
        };

        t.start();



    }

    public class Message {
        public void displayMessage(int resultCode, Bundle resultData) {
            String message = resultData.getString("message");
            Toast.makeText(MainActivity.this, resultCode + " " + message, Toast.LENGTH_SHORT).show();
        }
    }

}
