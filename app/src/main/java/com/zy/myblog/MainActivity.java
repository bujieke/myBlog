package com.zy.myblog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.zy.myblog.base.BaseActivity;
import com.zy.myblog.ui.ToolbarX;

public class MainActivity extends BaseActivity {
    private ToolbarX mToolbarX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mToolbarX = getToolbar();
        mToolbarX.setTitle(R.string.main_Title).setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.e("TAG", item.getItemId() + "");
        return true;
    }
}
