package com.zc.editor.blocks.mediaCodec;

import android.view.View;

import com.zc.editor.base.activity.RVBaseActivity;
import com.zc.editor.base.beans.BaseRecyclerBean;
import com.zc.editor.blocks.mediaCodec.bigflake.BigflakeActivity;
import com.zc.editor.blocks.mediaCodec.primary.CreatMusicVideoByMediaCodecActivity;
import com.zc.editor.blocks.mediaCodec.primary.PrimaryMediaCodecActivity;
import com.zc.editor.blocks.mediaCodec.primary.mp3TranslateAAC.Mp3TranslateAACActivity;
import com.zc.editor.blocks.mediaCodec.recordBaseCamera.RecordBaseCameraActivity;
import com.zc.editor.blocks.mediaCodec.recordCamera.RecordCameraActivity;
import com.zc.editor.blocks.mediaCodec.show.MediaCodecShowOnGlSurfaceView;

public class MediaCodecActivity extends RVBaseActivity {

    @Override
    protected void initGetData() {
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec基本方法使用Bigflake",BigflakeActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec基本方法使用",PrimaryMediaCodecActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec仅录制相机数据",RecordBaseCameraActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("音视频混合录制，通过SurfaceView显示相机数据",RecordCameraActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec录制随音乐变化的视频",CreatMusicVideoByMediaCodecActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec处理音乐",Mp3TranslateAACActivity.class));
        mBaseRecyclerBeen.add(new BaseRecyclerBean("MediaCodec解码视频在GlSurfaceView上显示", MediaCodecShowOnGlSurfaceView.class));
    }

    @Override
    public void itemClickBack(View view, int position, boolean isLongClick, int comeFrom) {

    }
}
