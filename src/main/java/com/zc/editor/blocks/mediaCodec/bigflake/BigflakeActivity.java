package com.zc.editor.blocks.mediaCodec.bigflake;

import android.view.View;

import com.zc.editor.base.activity.RVBaseActivity;
import com.zc.editor.base.beans.BaseRecyclerBean;
import com.zc.editor.blocks.mediaCodec.bigflake.cameraToMpeg.CameraToMpegActivity;
import com.zc.editor.blocks.mediaCodec.bigflake.decodeEditEncode.DecodeEditEncodeActivity;
import com.zc.editor.blocks.mediaCodec.bigflake.encodeAndMux.EncodeAndMuxActivity;
import com.zc.editor.blocks.mediaCodec.bigflake.encodeDecode.EncodeDecodeActivity;
import com.zc.editor.blocks.mediaCodec.bigflake.extractDecodeEditEncodeMux.ExtractDecodeEditEncodeMuxActivity;
import com.zc.editor.blocks.mediaCodec.bigflake.extractMpegFrames.ExtractMpegFramesActivity;

public class BigflakeActivity extends RVBaseActivity {


    @Override
    protected void initGetData() {
        mBaseRecyclerBeen.add(new BaseRecyclerBean("EncodeAndMux",EncodeAndMuxActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("CameraToMpeg",CameraToMpegActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("EncodeDecode",EncodeDecodeActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("ExtractDecodeEditEncodeMux",ExtractDecodeEditEncodeMuxActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("DecodeEditEncodeActivity",DecodeEditEncodeActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("ExtractMpegFramesActivity",ExtractMpegFramesActivity.class));
    }

    @Override
    public void itemClickBack(View view, int position, boolean isLongClick, int comeFrom) {

    }
}
