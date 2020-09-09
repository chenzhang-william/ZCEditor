package com.zc.editor.blocks.mediaExtractor.primary.official;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.util.Log;

import java.io.IOException;
import java.nio.ByteBuffer;


public class AMediaExtractorOfficial {
    private static final String TAG = "AMediaExtractorOfficial";
    private static long mStartTime;

    public static void mediaExtractorDecoderAudio(String inputAudioPath){
        mStartTime = System.currentTimeMillis();
        MediaExtractor extractor = new MediaExtractor();
        try {
            extractor.setDataSource(inputAudioPath);
            int audioIndex = -1;//音频通道
            int numTracks = extractor.getTrackCount();
            for (int i = 0; i < numTracks; ++i) {
                MediaFormat format = extractor.getTrackFormat(i);
                String mime = format.getString(MediaFormat.KEY_MIME);
                if (format.getString(MediaFormat.KEY_MIME).startsWith("audio/")) {
                    audioIndex = i;
                }
            }
            extractor.selectTrack(audioIndex);//切换到音频通道

            ByteBuffer inputBuffer = ByteBuffer.allocate(1024*200);
            int readSampleData = extractor.readSampleData(inputBuffer, 0);
            while (readSampleData >= 0) {
                int trackIndex = extractor.getSampleTrackIndex();
                long presentationTimeUs = extractor.getSampleTime(); // 拿到解析到音频的时间
                Log.e(TAG,  "meidaExtractorDecoderAudio: trackIndex = " +  trackIndex + " presentationTimeUs = " + presentationTimeUs + "   readSampleData =" + readSampleData );
                extractor.advance();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "meidaExtractorDecoderAudio: " + e );
        }

        extractor.release();
        Log.e(TAG, "mediaExtractorDecoderAudio: " + (System.currentTimeMillis() - mStartTime)/(float)1000 + "s" );
        extractor = null;
    }

}
