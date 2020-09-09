package com.zc.editor.whole.createVideoByVoice.frameData;

import android.graphics.Canvas;
import android.graphics.Paint;


public class BackgroundFrame extends BaseFrameData{
    @Override
    void onDraw(Canvas canvas, Paint paint,float volume,int changeHueColor) {
        canvas.drawColor(changeHueColor);
    }
}
