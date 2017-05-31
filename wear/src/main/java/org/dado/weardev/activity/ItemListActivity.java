package org.dado.weardev.activity;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.WearableRecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import org.dado.entity.ViewUser;
import org.dado.repo.api.IUserViewRepo;
import org.dado.repo.impl.UserViewRepo;
import org.dado.weardev.R;
import org.dado.weardev.adapter.ListRecyclerAdapterWear;

import java.util.List;

/**
 * Created by dado on 23.05.17.
 */
public class ItemListActivity extends WearableActivity {

    @BindView(R.id.recycler_wear_view)
    WearableRecyclerView mListView;

    private IUserViewRepo mRepo;
    private ListRecyclerAdapterWear mAdapter;
    private List<ViewUser> mViewUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        ButterKnife.bind(this);

        mRepo = new UserViewRepo();
        mViewUsers = mRepo.getAll();
        mAdapter = new ListRecyclerAdapterWear(mViewUsers);
        mListView.setAdapter(mAdapter);


    }
}
