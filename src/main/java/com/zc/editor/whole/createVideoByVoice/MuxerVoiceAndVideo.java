package com.zc.editor.whole.createVideoByVoice;

import com.zc.editor.whole.createVideoByVoice.interfaces.IMuxerVideoCallBackListener;

import VideoHandle.EpEditor;
import VideoHandle.OnEditorListener;


public class MuxerVoiceAndVideo {
    private IMuxerVideoCallBackListener mIMuxerVideoCallBackListener;

    public MuxerVoiceAndVideo(IMuxerVideoCallBackListener iMuxerVideoCallBackListener) {
        mIMuxerVideoCallBackListener = iMuxerVideoCallBackListener;
    }

    public void startMuxer(String inputVideoPath, String inputMusicPath, float musicTime, String outputVideoPath){
        String cmd = "-y -i "+ inputVideoPath + " -ss 0 -t "+ musicTime + " -i "+ inputMusicPath + " -acodec copy -vcodec copy "+ outputVideoPath;
        EpEditor.execCmd(cmd, 10000,new OnEditorListener() {
            @Override
            public void onSuccess() {
                mIMuxerVideoCallBackListener.success();
            }

            @Override
            public void onFailure() {
                mIMuxerVideoCallBackListener.failed();
            }

            @Override
            public void onProgress(float v) {
            }
        });
    }
}
