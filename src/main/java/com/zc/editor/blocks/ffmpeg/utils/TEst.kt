package com.zc.editor.blocks.ffmpeg.utils

import VideoHandle.OnEditorListener
import android.view.View
import com.zc.editor.base.activity.RVBaseActivity

class TEst : RVBaseActivity(), OnEditorListener {
    override fun onSuccess() {}
    override fun onFailure() {}
    override fun onProgress(progress: Float) {}
    override fun initGetData() {}
    override fun itemClickBack(view: View, position: Int, isLongClick: Boolean, comeFrom: Int) {}
    override fun onPointerCaptureChanged(hasCapture: Boolean) {}
}