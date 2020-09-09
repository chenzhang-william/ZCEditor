package com.zc.editor

import android.view.View
import com.zc.editor.base.activity.RVBaseActivity
import com.zc.editor.base.beans.BaseRecyclerBean
import com.zc.editor.blocks.BlocksActivity
import com.zc.editor.blocks.ffmpeg.FFmpegActivity
import com.zc.editor.whole.WholeActivity

class HomeActivity : RVBaseActivity() {
    override fun initGetData() {
        mBaseRecyclerBeen.add(BaseRecyclerBean("每个功能点单独代码实现", BlocksActivity::class.java))
        mBaseRecyclerBeen.add(BaseRecyclerBean("所有功能点整合代码实现", WholeActivity::class.java))
        mBaseRecyclerBeen.add(BaseRecyclerBean("当前调用界面", FFmpegActivity::class.java))
    }

    override fun itemClickBack(view: View, position: Int, isLongClick: Boolean, comeFrom: Int) {}
}