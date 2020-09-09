package com.zc.editor.whole;

import android.view.View;

import com.zc.editor.base.activity.RVBaseActivity;
import com.zc.editor.base.beans.BaseRecyclerBean;
import com.zc.editor.whole.record.RecorderActivity;

public class WholeActivity extends RVBaseActivity {

    @Override
    protected void initGetData() {
        mBaseRecyclerBeen.add(new BaseRecyclerBean("视频录制这边走", RecorderActivity.class));
    }

    @Override
    public void itemClickBack(View view, int position, boolean isLongClick, int comeFrom) {

    }
}
