package com.zc.editor.blocks.others;

import android.view.View;

import com.zc.editor.base.activity.RVBaseActivity;
import com.zc.editor.base.beans.BaseRecyclerBean;
import com.zc.editor.blocks.others.changeHue.ChangeHueActivity;
import com.zc.editor.blocks.others.changeVoice.ChangeVoiceActivity;

public class OthersActivity extends RVBaseActivity {


    @Override
    protected void initGetData() {
        mBaseRecyclerBeen.add(new BaseRecyclerBean("修改hue", ChangeHueActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("变声", ChangeVoiceActivity.class));
    }

    @Override
    public void itemClickBack(View view, int position, boolean isLongClick, int comeFrom) {

    }
}
