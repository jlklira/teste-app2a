package com.teste.app1a;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MyService extends IntentService {

    public MyService(){
        super("MyService class");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("STEP","Serviço foi iniciado");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        // FORÇA O REINICIO DO SERVICE SE O APP FOI FINALIZADO
        Log.d("STEP", "onStartCommand");
        return START_STICKY;
    }




    @Override
    protected void onHandleIntent(Intent intent) {

        // ResultReceiver receiver = intent.getParcelableExtra("receiver");

        int time = intent.getIntExtra("time", 0);

        for(int i=0; i<time; i++){

            Log.d("STEP", "intent is not null and then i->" + i);
            LinkedList.linkedList.add(String.valueOf(i));

            try{
                Thread.sleep(1000);
            } catch (Exception e){ }

        }

        Bundle bundle = new Bundle();
        bundle.putString("message", "Fim da contagem.");
        Log.d("STEP","Fim da contagem");

        // receiver.send(1234, bundle);

    }
}
