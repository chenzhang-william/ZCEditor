package com.zc.editor.blocks;

import android.view.View;

import com.zc.editor.base.activity.RVBaseActivity;
import com.zc.editor.base.beans.BaseRecyclerBean;
import com.zc.editor.blocks.audioRecord.AudioRecordActivity;
import com.zc.editor.blocks.others.OthersActivity;
import com.zc.editor.blocks.others.changeHue.ChangeHueActivity;
import com.zc.editor.blocks.mediaExtractor.MediaExtractorActivity;
import com.zc.editor.blocks.mediaCodec.MediaCodecActivity;
import com.zc.editor.blocks.mediaMuxer.MediaMuxerActivity;
import com.zc.editor.blocks.mediaMuxer.functions.CreateVideoAddAudioToMp4;

public class BlocksActivity extends RVBaseActivity {

    @Override
    protected void initGetData() {
        mBaseRecyclerBeen.add(new BaseRecyclerBean("修改hue", ChangeHueActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("AudioRecord", AudioRecordActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec", MediaCodecActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaExtractor", MediaExtractorActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaMuxer", MediaMuxerActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("合成", CreateVideoAddAudioToMp4.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("其他", OthersActivity.class));
    }

    @Override
    public void itemClickBack(View view, int position, boolean isLongClick, int comeFrom) {

    }
}
