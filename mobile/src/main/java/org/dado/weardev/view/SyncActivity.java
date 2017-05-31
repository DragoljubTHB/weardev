package org.dado.weardev.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import org.dado.weardev.R;
import org.dado.weardev.view.base.BaseActivity;

/**
 * Created by dado on 31.05.17.
 */
public class SyncActivity extends BaseActivity{

    @BindView(R.id.activity_sync_button_sync)Button mButtonSync;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sync);
        ButterKnife.bind(this);

        mButtonSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doSync();
            }
        });

    }

    private void doSync() {

    }
}
