package com.zc.editor.whole.createVideoByVoice.frameData;

import android.graphics.Canvas;
import android.graphics.Paint;


public abstract class BaseFrameData {
    abstract void onDraw(Canvas canvas,Paint paint,float volume,int hueColor);
}
