package com.zc.editor.whole.createVideoByVoice.interfaces;


public interface IEncoderVideoCallBackListener {
    void success(String outputMeidaPath, float finalMediaTime);
    void failed();
}
