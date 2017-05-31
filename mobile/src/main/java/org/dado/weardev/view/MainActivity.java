package org.dado.weardev.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import org.dado.weardev.R;
import org.dado.weardev.view.base.BaseActivity;

/**
 * Created by dado on 31.05.17.
 */
public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
