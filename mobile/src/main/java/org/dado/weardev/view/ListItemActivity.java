package org.dado.weardev.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import org.dado.entity.ViewUser;
import org.dado.repo.api.IUserViewRepo;
import org.dado.repo.impl.UserViewRepo;
import org.dado.weardev.R;
import org.dado.weardev.adapter.ItemsAdapter;
import org.dado.weardev.view.base.BaseActivity;

import java.util.List;

/**
 * Created by dado on 31.05.17.
 */
public class ListItemActivity extends BaseActivity{

    @BindView(R.id.activity_list_item_edit_item_name)EditText mEditTextItemName;
    @BindView(R.id.activity_item_list_recycler_view)RecyclerView mRecyclerViewItems;

    IUserViewRepo mRepo;
    List<ViewUser> mViewUserList;
    ItemsAdapter mItemsAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        ButterKnife.bind(this);
        mRepo = new UserViewRepo();
        mViewUserList = mRepo.getAll();

        mItemsAdapter = new ItemsAdapter(mViewUserList);
        mRecyclerViewItems.setAdapter(mItemsAdapter);

    }
}
