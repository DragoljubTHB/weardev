package org.dado.weardev.service;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.*;
import io.realm.Realm;

import java.util.concurrent.TimeUnit;

/**
 * Created by dado on 22.05.17.
 */
public class ServiceWear extends WearableListenerService {

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        super.onDataChanged(dataEventBuffer);

        GoogleApiClient googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build();

        ConnectionResult connectionResult =
                googleApiClient.blockingConnect(30, TimeUnit.SECONDS);


        processData(dataEventBuffer);

    }

    private void processData(DataEventBuffer dataEventBuffer) {
        Log.d("aop", "processData : "+dataEventBuffer);
        for(DataEvent event : dataEventBuffer)
        {
            Log.d("aop", "processData : event type"+event.getType());
            DataItem item = event.getDataItem();
            Log.d("aop", "item "+item.toString());
            Log.d("aop", "item uri "+item.getUri());
            DataMap dataMap = DataMapItem.fromDataItem(item).getDataMap();
            Log.d("aop", "item map "+dataMap);
            Log.d("aop", "item map keyset "+dataMap.keySet().toString());
        }
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        Log.d("aop", "onMessageReceived : "+messageEvent);
    }
}
