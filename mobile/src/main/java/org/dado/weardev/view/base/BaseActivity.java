package org.dado.weardev.view.base;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.BindView;
import butterknife.ButterKnife;
import org.dado.weardev.R;
import org.dado.weardev.view.ListItemActivity;
import org.dado.weardev.view.SyncActivity;

/**
 * Created by dado on 31.05.17.
 */
public class BaseActivity extends AppCompatActivity {

    @BindView(R.id.activity_base_button_list)Button mButtonList;
    @BindView(R.id.activity_base_button_sync)Button mButtonSync;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        ButterKnife.bind(this);

        mButtonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this, ListItemActivity.class));
            }
        });
        mButtonSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseActivity.this, SyncActivity.class));
            }
        });

    }
}
