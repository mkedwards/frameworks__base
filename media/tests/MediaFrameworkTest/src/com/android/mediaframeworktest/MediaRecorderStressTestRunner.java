/*
 * Copyright (C) 2009 The Android Open Source Project
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

package com.android.mediaframeworktest;

import android.media.MediaRecorder;
import android.os.Bundle;
import android.test.InstrumentationTestRunner;
import android.test.InstrumentationTestSuite;
import com.android.mediaframeworktest.stress.MediaRecorderStressTest;
import com.android.mediaframeworktest.stress.MediaPlayerStressTest;

import junit.framework.TestSuite;

public class MediaRecorderStressTestRunner extends InstrumentationTestRunner {

    // Default recorder settings
    public static int mIterations = 100;
    public static int mVideoEncoder = MediaRecorder.VideoEncoder.H263;
    public static int mAudioEncdoer = MediaRecorder.AudioEncoder.AMR_NB;
    public static int mFrameRate = 20;
    public static int mVideoWidth = 352;
    public static int mVideoHeight = 288;
    public static int mBitRate = 100;
    public static boolean mRemoveVideo = true;
    public static int mDuration = 10000;

    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new InstrumentationTestSuite(this);
        suite.addTestSuite(MediaRecorderStressTest.class);
        suite.addTestSuite(MediaPlayerStressTest.class);
        return suite;
    }

    @Override
    public ClassLoader getLoader() {
        return MediaRecorderStressTestRunner.class.getClassLoader();
    }

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String iterations = (String) icicle.get("iterations");
        String video_encoder = (String) icicle.get("video_encoder");
        String audio_encoder = (String) icicle.get("audio_encoder");
        String frame_rate = (String) icicle.get("frame_rate");
        String video_width = (String) icicle.get("video_width");
        String video_height = (String) icicle.get("video_height");
        String bit_rate = (String) icicle.get("bit_rate");
        String record_duration = (String) icicle.get("record_duration");
        String remove_videos = (String) icicle.get("remove_videos");

        if (iterations != null ) {
            mIterations = Integer.parseInt(iterations);
        }
        if ( video_encoder != null) {
            mVideoEncoder = Integer.parseInt(video_encoder);
        }
        if ( audio_encoder != null) {
            mAudioEncdoer = Integer.parseInt(audio_encoder);
        }
        if (frame_rate != null) {
            mFrameRate = Integer.parseInt(frame_rate);
        }
        if (video_width != null) {
            mVideoWidth = Integer.parseInt(video_width);
        }
        if (video_height != null) {
            mVideoHeight = Integer.parseInt(video_height);
        }
        if (bit_rate != null) {
            mBitRate = Integer.parseInt(bit_rate);
        }
        if (record_duration != null) {
            mDuration = Integer.parseInt(record_duration);
        }
        if (remove_videos != null) {
            if (remove_videos.compareTo("true") == 0) {
                mRemoveVideo = true;
            } else {
                mRemoveVideo = false;
            }
        }
    }
}
