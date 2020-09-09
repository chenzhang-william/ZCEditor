package com.zc.editor.whole.createVideoByVoice.beans;

import android.graphics.Bitmap;


public class MapFriend {
    private float screenX;
    private float screenY;
    private Bitmap friendHeadBitmap;

    /**
     * @param screenX
     * @param screenY
     * @param friendHeadBitmap
     */
    public MapFriend(float screenX, float screenY, Bitmap friendHeadBitmap) {
        this.screenX = screenX;
        this.screenY = screenY;
        this.friendHeadBitmap = friendHeadBitmap;
    }
}
