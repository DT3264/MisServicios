package com.dcerna.misservicios;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;


public class ServicioVinculado extends Service {
    String TAG = "ServicioVinculado";

    // Binder given to clients
    private final IBinder binder = new MyBinder();
    // Random number generator
    private final Random mGenerator = new Random();

    /**
     * Class used for the client Binder.  Because we know this service always
     * runs in the same process as its clients, we don't need to deal with IPC.
     */
    public class  MyBinder extends Binder{
        ServicioVinculado getService()
        {
            return  ServicioVinculado.this;
        }
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.d(TAG, "Llamado a onBind");
        return binder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "Llamado a onCreate");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "llamado a onStart");
        return super.onStartCommand(intent, flags, startId);
    }

    /** method for clients
     * Metodo interface para interactuar con el servicio
     * */
    public int getNumeroAleatorio() {
        Log.d("Servicio", "Random");
        return mGenerator.nextInt(100);
    }

}
