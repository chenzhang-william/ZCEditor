/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zc.editor.blocks.atestcases;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES11Ext;
import android.opengl.Matrix;
import android.test.AndroidTestCase;
import android.util.Log;
import android.view.Surface;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class EncodeDecodeTest extends AndroidTestCase {
    private static final String TAG = "EncodeDecodeTest";
    private static final boolean VERBOSE = false;           // lots of logging
    private static final boolean DEBUG_SAVE_FILE = false;   // save copy of encoded movie
    private static final String DEBUG_FILE_NAME_BASE = "/storage/emulated/0/";
    // parameters for the encoder
    private static final String MIME_TYPE = "video/avc";    // H.264 Advanced Video Coding
    private static final int BIT_RATE = 1000000;            // 1Mbps
    private static final int FRAME_RATE = 15;               // 15fps
    private static final int IFRAME_INTERVAL = 10;          // 10 seconds between I-frames
    // movie length, in frames
    private static final int NUM_FRAMES = 30;               // two seconds of video
    private static final int TEST_Y = 240;                  // YUV values for colored rect
    private static final int TEST_U = 220;
    private static final int TEST_V = 200;
    private static final int TEST_R0 = 0;                   // RGB eqivalent of {0,0,0}
    private static final int TEST_G0 = 136;
    private static final int TEST_B0 = 0;
    private static final int TEST_R1 = 255;                 // RGB equivalent of {240,220,200}
    private static final int TEST_G1 = 166;
    private static final int TEST_B1 = 255;
    // size of a frame, in pixels
    private int mWidth = -1;
    private int mHeight = -1;

    public void testEncodeDecodeVideoFromBufferToBufferQCIF() throws Exception {
        setSize(176, 144);
        testEncodeDecodeVideoFromBuffer(false);
    }
    public void testEncodeDecodeVideoFromBufferToBufferQVGA() throws Exception {
        setSize(320, 240);
        testEncodeDecodeVideoFromBuffer(false);
    }
    public void testEncodeDecodeVideoFromBufferToBuffer720p() throws Exception {
        setSize(1280, 720);
        testEncodeDecodeVideoFromBuffer(false);
    }

    public void testEncodeDecodeVideoFromBufferToSurfaceQCIF() throws Throwable {
        setSize(176, 144);
        BufferToSurfaceWrapper.runTest(this);
    }
    public void testEncodeDecodeVideoFromBufferToSurfaceQVGA() throws Throwable {
        setSize(320, 240);
        BufferToSurfaceWrapper.runTest(this);
    }
    public void testEncodeDecodeVideoFromBufferToSurface720p() throws Throwable {
        setSize(1280, 720);
        BufferToSurfaceWrapper.runTest(this);
    }

    private static class BufferToSurfaceWrapper implements Runnable {
        private Throwable mThrowable;
        private EncodeDecodeTest mTest;
        private BufferToSurfaceWrapper(EncodeDecodeTest test) {
            mTest = test;
        }
        public void run() {
            try {
                mTest.testEncodeDecodeVideoFromBuffer(true);
            } catch (Throwable th) {
                mThrowable = th;
            }
        }

        public static void runTest(EncodeDecodeTest obj) throws Throwable {
            BufferToSurfaceWrapper wrapper = new BufferToSurfaceWrapper(obj);
            Thread th = new Thread(wrapper, "codec test");
            th.start();
            th.join();
            if (wrapper.mThrowable != null) {
                throw wrapper.mThrowable;
            }
        }
    }

    private void setSize(int width, int height) {
        if ((width % 16) != 0 || (height % 16) != 0) {
            Log.w(TAG, "WARNING: width or height not multiple of 16");
        }
        mWidth = width;
        mHeight = height;
    }

    private void testEncodeDecodeVideoFromBuffer(boolean toSurface) throws Exception {
        MediaCodecInfo codecInfo = selectCodec(MIME_TYPE);
        if (codecInfo == null) {

            Log.e(TAG, "Unable to find an appropriate codec for " + MIME_TYPE);
            return;
        }
        if (VERBOSE) Log.d(TAG, "found codec: " + codecInfo.getName());
        int colorFormat = selectColorFormat(codecInfo, MIME_TYPE);
        if (VERBOSE) Log.d(TAG, "found colorFormat: " + colorFormat);

        MediaFormat format = MediaFormat.createVideoFormat(MIME_TYPE, mWidth, mHeight);

        format.setInteger(MediaFormat.KEY_COLOR_FORMAT, colorFormat);
        format.setInteger(MediaFormat.KEY_BIT_RATE, BIT_RATE);
        format.setInteger(MediaFormat.KEY_FRAME_RATE, FRAME_RATE);
        format.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, IFRAME_INTERVAL);
        if (VERBOSE) Log.d(TAG, "format: " + format);

        MediaCodec encoder = MediaCodec.createByCodecName(codecInfo.getName());
        encoder.configure(format, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
        encoder.start();

        MediaCodec decoder = MediaCodec.createDecoderByType(MIME_TYPE);
        try {
            encodeDecodeVideoFromBuffer(encoder, colorFormat, decoder, toSurface);
        } finally {
            if (VERBOSE) Log.d(TAG, "releasing codecs");
            encoder.stop();
            decoder.stop();
            encoder.release();
            decoder.release();
        }
    }

    private static MediaCodecInfo selectCodec(String mimeType) {
        int numCodecs = MediaCodecList.getCodecCount();
        for (int i = 0; i < numCodecs; i++) {
            MediaCodecInfo codecInfo = MediaCodecList.getCodecInfoAt(i);
            if (!codecInfo.isEncoder()) {
                continue;
            }
            String[] types = codecInfo.getSupportedTypes();
            for (int j = 0; j < types.length; j++) {
                if (types[j].equalsIgnoreCase(mimeType)) {
                    return codecInfo;
                }
            }
        }
        return null;
    }

    private static int selectColorFormat(MediaCodecInfo codecInfo, String mimeType) {
        MediaCodecInfo.CodecCapabilities capabilities = codecInfo.getCapabilitiesForType(mimeType);
        for (int i = 0; i < capabilities.colorFormats.length; i++) {
            int colorFormat = capabilities.colorFormats[i];
            switch (colorFormat) {
                // these are the formats we know how to handle for this test
                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar:
                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedPlanar:
                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar:
                case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedSemiPlanar:
                case MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar:
                    return colorFormat;
                default:
                    break;
            }
        }
        fail("couldn't find a good color format for " + codecInfo.getName() + " / " + mimeType);
        return 0;   // not reached
    }
    /**
     * Does the actual work for encoding frames from buffers of byte[].
     */
    private void encodeDecodeVideoFromBuffer(MediaCodec encoder, int encoderColorFormat,
            MediaCodec decoder, boolean toSurface) {
        final int TIMEOUT_USEC = 10000;
        ByteBuffer[] encoderInputBuffers = encoder.getInputBuffers();
        ByteBuffer[] encoderOutputBuffers = encoder.getOutputBuffers();
        ByteBuffer[] decoderInputBuffers = null;
        ByteBuffer[] decoderOutputBuffers = null;
        MediaCodec.BufferInfo info = new MediaCodec.BufferInfo();
        int decoderColorFormat = -12345;    // init to invalid value
        int generateIndex = 0;
        int checkIndex = 0;
        boolean decoderConfigured = false;
        SurfaceStuff surfaceStuff = null;
        // The size of a frame of video data, in the formats we handle, is stride*sliceHeight
        // for Y, and (stride/2)*(sliceHeight/2) for each of the Cb and Cr channels.  Application
        // of algebra and assuming that stride==width and sliceHeight==height yields:
        byte[] frameData = new byte[mWidth * mHeight * 3 / 2];
        // Just out of curiosity.
        long rawSize = 0;
        long encodedSize = 0;
        // Save a copy to disk.  Useful for debugging the test.
        FileOutputStream outputStream = null;
        if (DEBUG_SAVE_FILE) {
            String fileName = DEBUG_FILE_NAME_BASE + mWidth + "x" + mHeight + ".mp4";
            try {
                outputStream = new FileOutputStream(fileName);
                Log.d(TAG, "encoded output will be saved as " + fileName);
            } catch (IOException ioe) {
                Log.w(TAG, "Unable to create debug output file " + fileName);
                throw new RuntimeException(ioe);
            }
        }
        if (toSurface) {
            surfaceStuff = new SurfaceStuff(mWidth, mHeight);
        }
        // Loop until the output side is done.
        boolean inputDone = false;
        boolean encoderDone = false;
        boolean outputDone = false;
        while (!outputDone) {
            if (VERBOSE) Log.d(TAG, "loop");

            if (!inputDone) {
                int inputBufIndex = encoder.dequeueInputBuffer(TIMEOUT_USEC);
                if (VERBOSE) Log.d(TAG, "inputBufIndex=" + inputBufIndex);
                if (inputBufIndex >= 0) {
                    long ptsUsec = generateIndex * 1000000 / FRAME_RATE;
                    if (generateIndex == NUM_FRAMES) {
                        // Send an empty frame with the end-of-stream flag set.  If we set EOS
                        // on a frame with data, that frame data will be ignored, and the
                        // output will be short one frame.
                        encoder.queueInputBuffer(inputBufIndex, 0, 0, ptsUsec,
                                MediaCodec.BUFFER_FLAG_END_OF_STREAM);
                        inputDone = true;
                        if (VERBOSE) Log.d(TAG, "sent input EOS (with zero-length frame)");
                    } else {
                        generateFrame(generateIndex, encoderColorFormat, frameData);
                        ByteBuffer inputBuf = encoderInputBuffers[inputBufIndex];
                        // the buffer should be sized to hold one full frame
                        assertTrue(inputBuf.capacity() >= frameData.length);
                        inputBuf.clear();
                        inputBuf.put(frameData);
                        encoder.queueInputBuffer(inputBufIndex, 0, frameData.length, ptsUsec, 0);
                        if (VERBOSE) Log.d(TAG, "submitted frame " + generateIndex + " to enc");
                    }
                    generateIndex++;
                } else {
                    // either all in use, or we timed out during initial setup
                    if (VERBOSE) Log.d(TAG, "input buffer not available");
                }
            }

            if (!encoderDone) {
                int encoderStatus = encoder.dequeueOutputBuffer(info, TIMEOUT_USEC);
                if (encoderStatus == MediaCodec.INFO_TRY_AGAIN_LATER) {
                    // no output available yet
                    if (VERBOSE) Log.d(TAG, "no output from encoder available");
                } else if (encoderStatus == MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED) {
                    // not expected for an encoder
                    encoderOutputBuffers = encoder.getOutputBuffers();
                    if (VERBOSE) Log.d(TAG, "encoder output buffers changed");
                } else if (encoderStatus == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                    // not expected for an encoder
                    MediaFormat newFormat = encoder.getOutputFormat();
                    if (VERBOSE) Log.d(TAG, "encoder output format changed: " + newFormat);
                } else if (encoderStatus < 0) {
                    fail("unexpected result from encoder.dequeueOutputBuffer: " + encoderStatus);
                } else { // encoderStatus >= 0
                    ByteBuffer encodedData = encoderOutputBuffers[encoderStatus];
                    if (encodedData == null) {
                        fail("encoderOutputBuffer " + encoderStatus + " was null");
                    }
                    // It's usually necessary to adjust the ByteBuffer values to match BufferInfo.
                    encodedData.position(info.offset);
                    encodedData.limit(info.offset + info.size);
                    encodedSize += info.size;
                    if (outputStream != null) {
                        byte[] data = new byte[info.size];
                        encodedData.get(data);
                        encodedData.position(info.offset);
                        try {
                            outputStream.write(data);
                        } catch (IOException ioe) {
                            Log.w(TAG, "failed writing debug data to file");
                            throw new RuntimeException(ioe);
                        }
                    }
                    if ((info.flags & MediaCodec.BUFFER_FLAG_CODEC_CONFIG) != 0) {
                        // Codec config info.  Only expected on first packet.
                        assertFalse(decoderConfigured);
                        MediaFormat format =
                                MediaFormat.createVideoFormat(MIME_TYPE, mWidth, mHeight);
                        format.setByteBuffer("csd-0", encodedData);
                        decoder.configure(format, toSurface ? surfaceStuff.getSurface() : null,
                                null, 0);
                        decoder.start();
                        decoderInputBuffers = decoder.getInputBuffers();
                        decoderOutputBuffers = decoder.getOutputBuffers();
                        decoderConfigured = true;
                        if (VERBOSE) Log.d(TAG, "decoder configured (" + info.size + " bytes)");
                    } else {
                        // Get a decoder input buffer, blocking until it's available.
                        assertTrue(decoderConfigured);
                        int inputBufIndex = decoder.dequeueInputBuffer(-1);
                        ByteBuffer inputBuf = decoderInputBuffers[inputBufIndex];
                        inputBuf.clear();
                        inputBuf.put(encodedData);
                        decoder.queueInputBuffer(inputBufIndex, 0, info.size, info.presentationTimeUs,
                                info.flags);
                        encoderDone = (info.flags & MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0;
                        if (VERBOSE) Log.d(TAG, "passed " + info.size + " bytes to decoder"
                                + (encoderDone ? " (EOS)" : ""));
                    }
                    encoder.releaseOutputBuffer(encoderStatus, false);
                }
            }

            if (decoderConfigured) {
                int decoderStatus = decoder.dequeueOutputBuffer(info, TIMEOUT_USEC);
                if (decoderStatus == MediaCodec.INFO_TRY_AGAIN_LATER) {
                    // no output available yet
                    if (VERBOSE) Log.d(TAG, "no output from decoder available");
                } else if (decoderStatus == MediaCodec.INFO_OUTPUT_BUFFERS_CHANGED) {
                    if (VERBOSE) Log.d(TAG, "decoder output buffers changed");
                    decoderOutputBuffers = decoder.getOutputBuffers();
                } else if (decoderStatus == MediaCodec.INFO_OUTPUT_FORMAT_CHANGED) {
                    // this happens before the first frame is returned
                    MediaFormat decoderOutputFormat = decoder.getOutputFormat();
                    decoderColorFormat =
                            decoderOutputFormat.getInteger(MediaFormat.KEY_COLOR_FORMAT);
                    if (VERBOSE) Log.d(TAG, "decoder output format changed: " +
                            decoderOutputFormat);
                } else if (decoderStatus < 0) {
                    fail("unexpected result from deocder.dequeueOutputBuffer: " + decoderStatus);
                } else {  // decoderStatus >= 0
                    if (!toSurface) {
                        ByteBuffer outputFrame = decoderOutputBuffers[decoderStatus];
                        outputFrame.position(info.offset);
                        outputFrame.limit(info.offset + info.size);
                        rawSize += info.size;
                        if (info.size == 0) {
                            if (VERBOSE) Log.d(TAG, "got empty frame");
                        } else {
                            if (VERBOSE) Log.d(TAG, "decoded, checking frame " + checkIndex);
                            checkFrame(checkIndex++, decoderColorFormat, outputFrame);
                        }
                        if ((info.flags & MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                            if (VERBOSE) Log.d(TAG, "output EOS");
                            outputDone = true;
                        }
                    } else {
                        // Before we release+render this buffer, check to see if data from a
                        // previous go-round has latched.
                        surfaceStuff.checkNewImageIfAvailable();
                        if (VERBOSE) Log.d(TAG, "surface decoder given buffer " + decoderStatus +
                                " (size=" + info.size + ")");
                        rawSize += info.size;
                        if ((info.flags & MediaCodec.BUFFER_FLAG_END_OF_STREAM) != 0) {
                            if (VERBOSE) Log.d(TAG, "output EOS");
                            outputDone = true;
                        }
                    }

                    decoder.releaseOutputBuffer(decoderStatus, true /*render*/);
                }
            }
        }
        if (VERBOSE) Log.d(TAG, "encoded " + NUM_FRAMES + " frames at "
                + mWidth + "x" + mHeight + ": raw=" + rawSize + ", enc=" + encodedSize);
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException ioe) {
                Log.w(TAG, "failed closing debug file");
                throw new RuntimeException(ioe);
            }
        }
    }

    private void generateFrame(int frameIndex, int colorFormat, byte[] frameData) {
        final int HALF_WIDTH = mWidth / 2;
        boolean semiPlanar = isSemiPlanarYUV(colorFormat);
        // Set to zero.  In YUV this is a dull green.
        Arrays.fill(frameData, (byte) 0);
        int startX, startY, countX, countY;
        frameIndex %= 8;
        //frameIndex = (frameIndex / 8) % 8;    // use this instead for debug -- easier to see
        if (frameIndex < 4) {
            startX = frameIndex * (mWidth / 4);
            startY = 0;
        } else {
            startX = (7 - frameIndex) * (mWidth / 4);
            startY = mHeight / 2;
        }
        for (int y = startY + (mHeight/2) - 1; y >= startY; --y) {
            for (int x = startX + (mWidth/4) - 1; x >= startX; --x) {
                if (semiPlanar) {

                    frameData[y * mWidth + x] = (byte) TEST_Y;
                    if ((x & 0x01) == 0 && (y & 0x01) == 0) {
                        frameData[mWidth*mHeight + y * HALF_WIDTH + x] = (byte) TEST_U;
                        frameData[mWidth*mHeight + y * HALF_WIDTH + x + 1] = (byte) TEST_V;
                    }
                } else {
                    // full-size Y, followed by quarter-size Cb and quarter-size Cr
                    // e.g. Nexus 10 OMX.Exynos.AVC.Encoder COLOR_FormatYUV420Planar
                    // e.g. Nexus 7 OMX.Nvidia.h264.encoder COLOR_FormatYUV420Planar
                    frameData[y * mWidth + x] = (byte) TEST_Y;
                    if ((x & 0x01) == 0 && (y & 0x01) == 0) {
                        frameData[mWidth*mHeight + (y/2) * HALF_WIDTH + (x/2)] = (byte) TEST_U;
                        frameData[mWidth*mHeight + HALF_WIDTH * (mHeight / 2) +
                                  (y/2) * HALF_WIDTH + (x/2)] = (byte) TEST_V;
                    }
                }
            }
        }
        if (false) {
            // make sure that generate and check agree
            Log.d(TAG, "SPOT CHECK");
            checkFrame(frameIndex, colorFormat, ByteBuffer.wrap(frameData));
            Log.d(TAG, "SPOT CHECK DONE");
        }
    }

    private void checkFrame(int frameIndex, int colorFormat, ByteBuffer frameData) {
        final int HALF_WIDTH = mWidth / 2;
        boolean frameFailed = false;
        if (colorFormat == 0x7FA30C03) {
            // Nexus 4 decoder output OMX_QCOM_COLOR_FormatYUV420PackedSemiPlanar64x32Tile2m8ka
            Log.d(TAG, "unable to check frame contents for colorFormat=" +
                    Integer.toHexString(colorFormat));
            return;
        }
        boolean semiPlanar = isSemiPlanarYUV(colorFormat);
        frameIndex %= 8;
        for (int i = 0; i < 8; i++) {
            int x, y;
            if (i < 4) {
                x = i * (mWidth / 4) + (mWidth / 8);
                y = mHeight / 4;
            } else {
                x = (7 - i) * (mWidth / 4) + (mWidth / 8);
                y = (mHeight * 3) / 4;
            }
            int testY, testU, testV;
            if (semiPlanar) {
                // Galaxy Nexus uses OMX_TI_COLOR_FormatYUV420PackedSemiPlanar
                testY = frameData.get(y * mWidth + x) & 0xff;
                testU = frameData.get(mWidth*mHeight + 2*(y/2) * HALF_WIDTH + 2*(x/2)) & 0xff;
                testV = frameData.get(mWidth*mHeight + 2*(y/2) * HALF_WIDTH + 2*(x/2) + 1) & 0xff;
            } else {
                // Nexus 10, Nexus 7 use COLOR_FormatYUV420Planar
                testY = frameData.get(y * mWidth + x) & 0xff;
                testU = frameData.get(mWidth*mHeight + (y/2) * HALF_WIDTH + (x/2)) & 0xff;
                testV = frameData.get(mWidth*mHeight + HALF_WIDTH * (mHeight / 2) +
                        (y/2) * HALF_WIDTH + (x/2)) & 0xff;
            }
            boolean failed = false;
            if (i == frameIndex) {
                failed = !isColorClose(testY, TEST_Y) ||
                         !isColorClose(testU, TEST_U) ||
                         !isColorClose(testV, TEST_V);
            } else {
                // should be our zeroed-out buffer
                failed = !isColorClose(testY, 0) ||
                         !isColorClose(testU, 0) ||
                         !isColorClose(testV, 0);
            }
            if (failed) {
                Log.w(TAG, "Bad frame " + frameIndex + " (r=" + i + ": Y=" + testY +
                        " U=" + testU + " V=" + testV + ")");
                frameFailed = true;
            }
        }
        if (frameFailed) {
            fail("bad frame (" + frameIndex + ")");
        }
    }
    /**
     * Returns true if the actual color value is close to the expected color value.
     */
    static boolean isColorClose(int actual, int expected) {
        if (expected < 5) {
            return actual < (expected + 5);
        } else if (expected > 250) {
            return actual > (expected - 5);
        } else {
            return actual > (expected - 5) && actual < (expected + 5);
        }
    }

    private static boolean isSemiPlanarYUV(int colorFormat) {
        switch (colorFormat) {
            case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Planar:
            case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedPlanar:
                return false;
            case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420SemiPlanar:
            case MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420PackedSemiPlanar:
            case MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar:
                return true;
            default:
                throw new RuntimeException("unknown format " + colorFormat);
        }
    }

    private static class SurfaceStuff implements SurfaceTexture.OnFrameAvailableListener {
        private static final int EGL_OPENGL_ES2_BIT = 4;
        private EGL10 mEGL;
        private EGLDisplay mEGLDisplay;
        private EGLContext mEGLContext;
        private EGLSurface mEGLSurface;
        private SurfaceTexture mSurfaceTexture;
        private Surface mSurface;
        private boolean mFrameAvailable = false;    // guarded by "this"
        private int mWidth;
        private int mHeight;
        private VideoRender mVideoRender;
        public SurfaceStuff(int width, int height) {
            mWidth = width;
            mHeight = height;
            eglSetup();
            mVideoRender = new VideoRender();
            mVideoRender.onSurfaceCreated();

            if (VERBOSE) Log.d(TAG, "textureID=" + mVideoRender.getTextureId());
            mSurfaceTexture = new SurfaceTexture(mVideoRender.getTextureId());

            mSurfaceTexture.setOnFrameAvailableListener(this);
            mSurface = new Surface(mSurfaceTexture);
        }

        private void eglSetup() {
            mEGL = (EGL10)EGLContext.getEGL();
            mEGLDisplay = mEGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            if (!mEGL.eglInitialize(mEGLDisplay, null)) {
                fail("unable to initialize EGL10");
            }

            int[] attribList = {
                    EGL10.EGL_RED_SIZE, 8,
                    EGL10.EGL_GREEN_SIZE, 8,
                    EGL10.EGL_BLUE_SIZE, 8,
                    EGL10.EGL_SURFACE_TYPE, EGL10.EGL_PBUFFER_BIT,
                    EGL10.EGL_RENDERABLE_TYPE, EGL_OPENGL_ES2_BIT,
                    EGL10.EGL_NONE
            };
            EGLConfig[] configs = new EGLConfig[1];
            int[] numConfigs = new int[1];
            if (!mEGL.eglChooseConfig(mEGLDisplay, attribList, configs, 1, numConfigs)) {
                fail("unable to find RGB888+pbuffer EGL config");
            }
            // Configure context for OpenGL ES 2.0.
            int[] attrib_list = {
                    EGL14.EGL_CONTEXT_CLIENT_VERSION, 2,
                    EGL10.EGL_NONE
            };
            mEGLContext = mEGL.eglCreateContext(mEGLDisplay, configs[0], EGL10.EGL_NO_CONTEXT,
                    attrib_list);
            checkEglError("eglCreateContext");
            assertNotNull(mEGLContext);
            // Create a pbuffer surface.  By using this for output, we can use glReadPixels
            // to test values in the output.
            int[] surfaceAttribs = {
                    EGL10.EGL_WIDTH, mWidth,
                    EGL10.EGL_HEIGHT, mHeight,
                    EGL10.EGL_NONE
            };
            mEGLSurface = mEGL.eglCreatePbufferSurface(mEGLDisplay, configs[0], surfaceAttribs);
            checkEglError("eglCreatePbufferSurface");
            assertNotNull(mEGLSurface);
            if (!mEGL.eglMakeCurrent(mEGLDisplay, mEGLSurface, mEGLSurface, mEGLContext)) {
                fail("eglMakeCurrent failed");
            }
        }
        /**
         * Checks for EGL errors.
         */
        private void checkEglError(String msg) {
            boolean failed = false;
            int error;
            while ((error = mEGL.eglGetError()) != EGL10.EGL_SUCCESS) {
                Log.e(TAG, msg + ": EGL error: 0x" + Integer.toHexString(error));
                failed = true;
            }
            if (failed) {
                fail("EGL error encountered (see log)");
            }
        }
        /**
         * Returns the Surface that the MediaCodec will draw onto.
         */
        public Surface getSurface() {
            return mSurface;
        }
        /**
         * Latches the next buffer into the texture if one is available, and checks it for
         * validity.  Must be called from the thread that created the SurfaceStuff object.
         */
        public void checkNewImageIfAvailable() {
            boolean newStuff = false;
            synchronized (this) {
                if (mSurfaceTexture != null && mFrameAvailable) {
                    mFrameAvailable = false;
                    newStuff = true;
                }
            }
            if (newStuff) {
                mVideoRender.checkGlError("before updateTexImage");
                mSurfaceTexture.updateTexImage();
                mVideoRender.onDrawFrame(mSurfaceTexture);
                checkSurfaceFrame();
            }
        }
        @Override
        public void onFrameAvailable(SurfaceTexture st) {
            if (VERBOSE) Log.d(TAG, "new frame available");
            synchronized (this) {
                mFrameAvailable = true;
            }
        }

        private void checkSurfaceFrame() {
            ByteBuffer pixelBuf = ByteBuffer.allocateDirect(4); // TODO - reuse this
            int numColoredRects = 0;
            int rectPosn = -1;
            for (int i = 0; i < 8; i++) {
                // Note the coordinates are inverted on the Y-axis in GL.
                int x, y;
                if (i < 4) {
                    x = i * (mWidth / 4) + (mWidth / 8);
                    y = (mHeight * 3) / 4;
                } else {
                    x = (7 - i) * (mWidth / 4) + (mWidth / 8);
                    y = mHeight / 4;
                }
                GLES20.glReadPixels(x, y, 1, 1, GL10.GL_RGBA, GL10.GL_UNSIGNED_BYTE, pixelBuf);
                int r = pixelBuf.get(0) & 0xff;
                int g = pixelBuf.get(1) & 0xff;
                int b = pixelBuf.get(2) & 0xff;
                if (isColorClose(r, TEST_R0) &&
                        isColorClose(g, TEST_G0) &&
                        isColorClose(b, TEST_B0)) {
                    // empty space
                } else if (isColorClose(r, TEST_R1) &&
                        isColorClose(g, TEST_G1) &&
                        isColorClose(b, TEST_B1)) {
                    // colored rect
                    numColoredRects++;
                    rectPosn = i;
                } else {
                    // wtf
                    Log.w(TAG, "found unexpected color r=" + r + " g=" + g + " b=" + b);
                }
            }
            if (numColoredRects != 1) {
                fail("Found surface with colored rects != 1 (" + numColoredRects + ")");
            } else {
                if (VERBOSE) Log.d(TAG, "good surface, looks like index " + rectPosn);
            }
        }
    }
    /**
     * GL code to fill a surface with a texture.  This class was largely copied from
     * VideoSurfaceView.VideoRender.
     * <p>
     * TODO: merge implementations
     */
    private static class VideoRender {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 5 * FLOAT_SIZE_BYTES;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 3;
        private final float[] mTriangleVerticesData = {
            // X, Y, Z, U, V
            -1.0f, -1.0f, 0, 0.f, 0.f,
            1.0f, -1.0f, 0, 1.f, 0.f,
            -1.0f,  1.0f, 0, 0.f, 1.f,
            1.0f,  1.0f, 0, 1.f, 1.f,
        };
        private FloatBuffer mTriangleVertices;
        private final String mVertexShader =
                "uniform mat4 uMVPMatrix;\n" +
                "uniform mat4 uSTMatrix;\n" +
                "attribute vec4 aPosition;\n" +
                "attribute vec4 aTextureCoord;\n" +
                "varying vec2 vTextureCoord;\n" +
                "void main() {\n" +
                "  gl_Position = uMVPMatrix * aPosition;\n" +
                "  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n" +
                "}\n";
        private final String mFragmentShader =
                "#extension GL_OES_EGL_image_external : require\n" +
                "precision mediump float;\n" +
                "varying vec2 vTextureCoord;\n" +
                "uniform samplerExternalOES sTexture;\n" +
                "void main() {\n" +
                "  gl_FragColor = texture2D(sTexture, vTextureCoord);\n" +
                "}\n";
        private float[] mMVPMatrix = new float[16];
        private float[] mSTMatrix = new float[16];
        private int mProgram;
        private int mTextureID = -12345;
        private int muMVPMatrixHandle;
        private int muSTMatrixHandle;
        private int maPositionHandle;
        private int maTextureHandle;
        public VideoRender() {
            mTriangleVertices = ByteBuffer.allocateDirect(
                mTriangleVerticesData.length * FLOAT_SIZE_BYTES)
                    .order(ByteOrder.nativeOrder()).asFloatBuffer();
            mTriangleVertices.put(mTriangleVerticesData).position(0);
            Matrix.setIdentityM(mSTMatrix, 0);
        }
        public int getTextureId() {
            return mTextureID;
        }
        public void onDrawFrame(SurfaceTexture st) {
            checkGlError("onDrawFrame start");
            st.getTransformMatrix(mSTMatrix);
            GLES20.glClearColor(0.0f, 1.0f, 0.0f, 1.0f);
            GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
            GLES20.glUseProgram(mProgram);
            checkGlError("glUseProgram");
            GLES20.glActiveTexture(GLES20.GL_TEXTURE0);
            GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, mTextureID);
            mTriangleVertices.position(TRIANGLE_VERTICES_DATA_POS_OFFSET);
            GLES20.glVertexAttribPointer(maPositionHandle, 3, GLES20.GL_FLOAT, false,
                TRIANGLE_VERTICES_DATA_STRIDE_BYTES, mTriangleVertices);
            checkGlError("glVertexAttribPointer maPosition");
            GLES20.glEnableVertexAttribArray(maPositionHandle);
            checkGlError("glEnableVertexAttribArray maPositionHandle");
            mTriangleVertices.position(TRIANGLE_VERTICES_DATA_UV_OFFSET);
            GLES20.glVertexAttribPointer(maTextureHandle, 3, GLES20.GL_FLOAT, false,
                TRIANGLE_VERTICES_DATA_STRIDE_BYTES, mTriangleVertices);
            checkGlError("glVertexAttribPointer maTextureHandle");
            GLES20.glEnableVertexAttribArray(maTextureHandle);
            checkGlError("glEnableVertexAttribArray maTextureHandle");
            Matrix.setIdentityM(mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(muMVPMatrixHandle, 1, false, mMVPMatrix, 0);
            GLES20.glUniformMatrix4fv(muSTMatrixHandle, 1, false, mSTMatrix, 0);
            GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, 4);
            checkGlError("glDrawArrays");
            GLES20.glFinish();
        }
        public void onSurfaceCreated() {
            mProgram = createProgram(mVertexShader, mFragmentShader);
            if (mProgram == 0) {
                Log.e(TAG, "failed creating program");
                return;
            }
            maPositionHandle = GLES20.glGetAttribLocation(mProgram, "aPosition");
            checkGlError("glGetAttribLocation aPosition");
            if (maPositionHandle == -1) {
                throw new RuntimeException("Could not get attrib location for aPosition");
            }
            maTextureHandle = GLES20.glGetAttribLocation(mProgram, "aTextureCoord");
            checkGlError("glGetAttribLocation aTextureCoord");
            if (maTextureHandle == -1) {
                throw new RuntimeException("Could not get attrib location for aTextureCoord");
            }
            muMVPMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uMVPMatrix");
            checkGlError("glGetUniformLocation uMVPMatrix");
            if (muMVPMatrixHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uMVPMatrix");
            }
            muSTMatrixHandle = GLES20.glGetUniformLocation(mProgram, "uSTMatrix");
            checkGlError("glGetUniformLocation uSTMatrix");
            if (muSTMatrixHandle == -1) {
                throw new RuntimeException("Could not get attrib location for uSTMatrix");
            }
            int[] textures = new int[1];
            GLES20.glGenTextures(1, textures, 0);
            mTextureID = textures[0];
            GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, mTextureID);
            checkGlError("glBindTexture mTextureID");
            GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES20.GL_TEXTURE_MIN_FILTER,
                    GLES20.GL_NEAREST);
            GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES20.GL_TEXTURE_MAG_FILTER,
                    GLES20.GL_LINEAR);
            GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES20.GL_TEXTURE_WRAP_S,
                    GLES20.GL_CLAMP_TO_EDGE);
            GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, GLES20.GL_TEXTURE_WRAP_T,
                    GLES20.GL_CLAMP_TO_EDGE);
            checkGlError("glTexParameter");
        }
        private int loadShader(int shaderType, String source) {
            int shader = GLES20.glCreateShader(shaderType);
            checkGlError("glCreateShader type=" + shaderType);
            GLES20.glShaderSource(shader, source);
            GLES20.glCompileShader(shader);
            int[] compiled = new int[1];
            GLES20.glGetShaderiv(shader, GLES20.GL_COMPILE_STATUS, compiled, 0);
            if (compiled[0] == 0) {
                Log.e(TAG, "Could not compile shader " + shaderType + ":");
                Log.e(TAG, GLES20.glGetShaderInfoLog(shader));
                GLES20.glDeleteShader(shader);
                shader = 0;
            }
            return shader;
        }
        private int createProgram(String vertexSource, String fragmentSource) {
            int vertexShader = loadShader(GLES20.GL_VERTEX_SHADER, vertexSource);
            if (vertexShader == 0) {
                return 0;
            }
            int pixelShader = loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentSource);
            if (pixelShader == 0) {
                return 0;
            }
            int program = GLES20.glCreateProgram();
            checkGlError("glCreateProgram");
            if (program == 0) {
                Log.e(TAG, "Could not create program");
            }
            GLES20.glAttachShader(program, vertexShader);
            checkGlError("glAttachShader");
            GLES20.glAttachShader(program, pixelShader);
            checkGlError("glAttachShader");
            GLES20.glLinkProgram(program);
            int[] linkStatus = new int[1];
            GLES20.glGetProgramiv(program, GLES20.GL_LINK_STATUS, linkStatus, 0);
            if (linkStatus[0] != GLES20.GL_TRUE) {
                Log.e(TAG, "Could not link program: ");
                Log.e(TAG, GLES20.glGetProgramInfoLog(program));
                GLES20.glDeleteProgram(program);
                program = 0;
            }
            return program;
        }
        public void checkGlError(String op) {
            int error;
            while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
                Log.e(TAG, op + ": glError " + error);
                throw new RuntimeException(op + ": glError " + error);
            }
        }
    }
}