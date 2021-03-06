package com.zy.myblog.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;

import com.zy.myblog.R;
import com.zy.myblog.ui.ToolbarX;

/**
 * Created by  zy on 2017/5/27.
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

/**
 * 定义进入和退出动画
 */
public abstract class   BaseActivity extends AppCompatActivity {

    private RelativeLayout mRlContent;
    private Toolbar mToolbar;
    private ToolbarX mtoolbarX;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);
        setContentView(R.layout.baselayout);
        initRootView();
        View view = getLayoutInflater().inflate(getLayout(), mRlContent, false);
        mRlContent.addView(view);
        mtoolbarX = new ToolbarX(mToolbar, this);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.anim_in_right_left, R.anim.anim_out_right_left); //切换动画

    }


    public abstract int getLayout();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        overridePendingTransition(R.anim.anim_in_right_left, R.anim.anim_out_right_left); //切换动画
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_in_left_rigth, R.anim.anim_out_left_rigth);//切换动画
    }

    private void initRootView() {
        mRlContent = (RelativeLayout) findViewById(R.id.rl_Content);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public ToolbarX getToolbar() {
        if (null == mtoolbarX) {
            mtoolbarX = new ToolbarX(mToolbar, this);
        }
        return mtoolbarX;

    }

    ;
}
