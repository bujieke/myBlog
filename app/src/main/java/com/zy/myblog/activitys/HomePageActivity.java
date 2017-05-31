package com.zy.myblog.activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.Toast;

import com.zy.myblog.R;
import com.zy.myblog.base.BaseActivity;
import com.zy.myblog.fragments.HomeFragment;
import com.zy.myblog.fragments.MessageFragment;
import com.zy.myblog.fragments.MineFragment;

/**
 * Created by  zy on 2017/5/31.
 * //                            _ooOoo_
 * //                           o8888888o
 * //                           88" . "88
 * //                           (| -_- |)
 * //                            O\ = /O
 * //                        ____/`---'\____
 * //                      .   ' \\| |// `.
 * //                       / \\||| : |||// \
 * //                     / _||||| -:- |||||- \
 * //                       | | \\\ - /// | |
 * //                     | \_| ''\---/'' | |
 * //                      \ .-\__ `-` ___/-. /
 * //                   ___`. .' /--.--\ `. . __
 * //                ."" '< `.___\_<|>_/___.' >'"".
 * //               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * //                 \ \ `-. \_ __\ /__ _/ .-` / /
 * //         ======`-.____`-.___\_____/___.-`____.-'======
 * //                            `=---='
 * //
 * //         .............................................
 * //                  佛祖保佑             永无BUG
 * //          佛曰:
 * //                  写字楼里写字间，写字间里程序员；
 * //                  程序人员写程序，又拿程序换酒钱。
 * //                  酒醒只在网上坐，酒醉还来网下眠；
 * //                  酒醉酒醒日复日，网上网下年复年。
 * //                  但愿老死电脑间，不愿鞠躬老板前；
 * //                  奔驰宝马贵者趣，公交自行程序员。
 * //                  别人笑我忒疯癫，我笑自己命太贱；
 * //                  不见满街漂亮妹，哪个归得程序员？
 */
public class HomePageActivity extends BaseActivity {

    private FrameLayout mHomeFl;
    private RadioGroup mHomeRg;
    private RadioButton mRbHome;
    private RadioButton mRbCompress;
    private RadioButton mRbMine;
    private FragmentTabHost mHomeTablehost;
    private Class fragment[];
    private int menuId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment = new Class[]{HomeFragment.class, MessageFragment.class, MineFragment.class};
        initView();
        getToolbar().setTitle(R.string.home).setDisplayHomeAsUpEnabled(false);
    }

    private void initView() {
        mHomeFl = (FrameLayout) findViewById(R.id.home_fl);
        mHomeRg = (RadioGroup) findViewById(R.id.home_rg);
        mRbHome = (RadioButton) findViewById(R.id.rb_home);
        mRbCompress = (RadioButton) findViewById(R.id.rb_compress);
        mRbMine = (RadioButton) findViewById(R.id.rb_mine);
        mHomeTablehost = (FragmentTabHost) findViewById(R.id.home_tablehost);
        mHomeTablehost.setup(getApplicationContext(), getSupportFragmentManager(), R.id.home_fl);
        for (int i = 0; i < fragment.length; i++) {
            TabHost.TabSpec tabspec = mHomeTablehost.newTabSpec(String.valueOf(i)).setIndicator(String.valueOf(i));
            mHomeTablehost.addTab(tabspec, fragment[i], null);
        }
        mHomeTablehost.setCurrentTab(0);
        mHomeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_home:
                        mHomeTablehost.setCurrentTab(0);
                        menuId = checkedId;
                        break;
                    case R.id.rb_compress:
                        mHomeTablehost.setCurrentTab(1);
                        menuId = -1;
                        break;
                    case R.id.rb_mine:
                        mHomeTablehost.setCurrentTab(2);
                        menuId = -1;
                        break;
                }
                supportInvalidateOptionsMenu(); //重绘制menu
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (menuId == -1) {
            menu.clear();
        } else {
            getMenuInflater().inflate(R.menu.menu_base, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, "search", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_setting:
                Toast.makeText(this, "setting", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_share:
                Toast.makeText(this, "share", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    public int getLayout() {
        return R.layout.activity_home;
    }
}
