package com.zc.editor.blocks.atestcases

import android.view.View
import com.zc.editor.base.activity.RVBaseActivity
import com.zc.editor.base.beans.BaseRecyclerBean


class TestCaseActivity : RVBaseActivity() {
    override fun itemClickBack(view: View?, position: Int, isLongClick: Boolean, comeFrom: Int) {
        when(position){
//            0 -> EncodeDecodeTest
        }
    }
    override fun initGetData() {
        mBaseRecyclerBeen.add(BaseRecyclerBean("EncodeDecodeTest",0))
    }

}