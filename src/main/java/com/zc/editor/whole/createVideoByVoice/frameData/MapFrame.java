package com.zc.editor.whole.createVideoByVoice.frameData;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;


public class MapFrame extends BaseFrameData {
    private int margainTop = 20;
    private int margainLefAndRight = 30;
    private int margainBottom = 100;

    private Bitmap mMapBitmap;

    public MapFrame(Bitmap bitmapMap) {
        this.mMapBitmap = bitmapMap;
    }
    @Override
    void onDraw(Canvas canvas, Paint paint, float volume, int hueColor) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        Rect srcRect = new Rect(0, 0, mMapBitmap.getWidth(), mMapBitmap.getHeight());
        Rect decRect = new Rect(margainLefAndRight, margainTop, width - margainLefAndRight, height-margainBottom);
        canvas.drawBitmap(mMapBitmap,srcRect,decRect,paint);
    }

}
