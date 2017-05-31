package org.dado.weardev.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.wearable.*;
import org.dado.entity.ViewUser;
import org.dado.repo.api.IUserViewRepo;
import org.dado.repo.impl.UserViewRepo;
import org.dado.weardev.R;

public class LiveNetworkingWithAppActivity extends Activity
        implements DataApi.DataListener, GoogleApiClient.ConnectionCallbacks
        , GoogleApiClient.OnConnectionFailedListener

{
    @BindView(R.id.activity_network_key)EditText mEditTextKey;
    @BindView(R.id.activity_network_value)EditText mEditTextValue;
    @BindView(R.id.activity_network_button_send)Button mButtonToSend;
    @BindView(R.id.activity_network_button_save)Button mButtonToSave;

    private IUserViewRepo mRepo;
    GoogleApiClient mGoogleApiClient;
    private final String COMMUNICATION_CHANNEL = "/de.piobyte.ddd.abgleich";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mRepo = new UserViewRepo();

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

        mButtonToSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        mButtonToSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRepo.createUser(new ViewUser());
            }
        });

    }


    private void sendData() {
        PutDataMapRequest putDataMapRequest = PutDataMapRequest.create(COMMUNICATION_CHANNEL);
        putDataMapRequest.getDataMap().putString(mEditTextKey.getText().toString(), mEditTextValue.getText().toString());
        PutDataRequest putDataRequest = putDataMapRequest.asPutDataRequest();

        PendingResult<DataApi.DataItemResult> pendingResult = Wearable.DataApi.putDataItem(mGoogleApiClient, putDataRequest);

    }

    @Override //DataApi.DataListener
    public void onDataChanged(DataEventBuffer dataEventBuffer) {

    }

    @Override // GoogleApiClient.ConnectionCallbacks
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override // GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {

    }

    @Override // GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Wearable.DataApi.removeListener(mGoogleApiClient, this);
        mGoogleApiClient.disconnect();
    }


}
