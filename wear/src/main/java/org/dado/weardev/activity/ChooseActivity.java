package org.dado.weardev.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import org.dado.weardev.R;

/**
 * Created by dado on 24.05.17.
 */
public class ChooseActivity extends WearableActivity {

    @BindView(R.id.activity_choose_list)
    Button mButtonChooseList;

    @BindView(R.id.activity_choose_networking)
    Button mButtonChooseNetworking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        ButterKnife.bind(this);

        mButtonChooseList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseActivity.this, ItemListActivity.class));
            }
        });
        mButtonChooseNetworking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChooseActivity.this, LiveNetworkingWithAppActivity.class));
            }
        });
    }
}
