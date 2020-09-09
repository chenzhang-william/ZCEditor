package com.zc.editor.whole.createVideoByVoice.frameData;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Surface;

import java.util.ArrayList;
import java.util.List;


public class FrameDataManager {
    public List<BaseFrameData> mBaseFrameDataList  = new ArrayList<>();

    public void addBaseFrameData(BaseFrameData baseFrameData){
        mBaseFrameDataList.add(baseFrameData);
    }
    public void drawFrame(Surface inputSurface ,int frameNum, float volume){
        Canvas canvas = inputSurface.lockCanvas(null);
        Paint paint = new Paint();
        int changeHueColor = changeHue(volume);
        for (BaseFrameData baseFrameData : mBaseFrameDataList) {
            baseFrameData.onDraw(canvas,paint,volume,changeHueColor);
        }
        try {
            paint.setTextSize(100);
            paint.setColor(0xff000000);

        } finally {
            inputSurface.unlockCanvasAndPost(canvas);
        }
    }

    /**
     * @param volume 0 ~ 360
     * @return
     */
    public int changeHue(float volume){
        float[] hsbVals = new float[3];
        int inputColor = Color.parseColor("#FFF757");
        Color.colorToHSV(inputColor,hsbVals);
        float v = (float) volume / (float) 360;
        hsbVals[0] = volume;
        int color = Color.HSVToColor(hsbVals);
        return color;
    }
}
