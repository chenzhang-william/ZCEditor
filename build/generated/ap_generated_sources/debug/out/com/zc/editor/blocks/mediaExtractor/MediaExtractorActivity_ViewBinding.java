// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaExtractor;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import com.zc.editor.blocks.mediaExtractor.primary.FrequencyView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MediaExtractorActivity_ViewBinding implements Unbinder {
  private MediaExtractorActivity target;

  private View view2131165424;

  private View view2131165429;

  private View view2131165214;

  private View view2131165301;

  private View view2131165302;

  private View view2131165303;

  private View view2131165298;

  private View view2131165277;

  private View view2131165281;

  private View view2131165384;

  @UiThread
  public MediaExtractorActivity_ViewBinding(MediaExtractorActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MediaExtractorActivity_ViewBinding(final MediaExtractorActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.record_and_encoder_mp3, "field 'mRecordAndEncoderMp3' and method 'onViewClicked'");
    target.mRecordAndEncoderMp3 = Utils.castView(view, R.id.record_and_encoder_mp3, "field 'mRecordAndEncoderMp3'", Button.class);
    view2131165424 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.record_mp3_stop, "field 'mRecordMp3Stop' and method 'onViewClicked'");
    target.mRecordMp3Stop = Utils.castView(view, R.id.record_mp3_stop, "field 'mRecordMp3Stop'", Button.class);
    view2131165429 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mFrequencyView = Utils.findRequiredViewAsType(source, R.id.frequency_view, "field 'mFrequencyView'", FrequencyView.class);
    view = Utils.findRequiredView(source, R.id.audio_extractor_data, "method 'onViewClicked'");
    view2131165214 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.extractor_mp3_from_mp4, "method 'onViewClicked'");
    view2131165301 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.extractor_no_voice_mp4_from_mp4, "method 'onViewClicked'");
    view2131165302 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.extractor_video_and_audio, "method 'onViewClicked'");
    view2131165303 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.exchange_video_and_audio, "method 'onViewClicked'");
    view2131165298 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.decoder_aac_and_player, "method 'onViewClicked'");
    view2131165277 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.decoder_mp3_and_player, "method 'onViewClicked'");
    view2131165281 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.mp3_translate_aac_btn, "method 'onViewClicked'");
    view2131165384 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MediaExtractorActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecordAndEncoderMp3 = null;
    target.mRecordMp3Stop = null;
    target.mFrequencyView = null;

    view2131165424.setOnClickListener(null);
    view2131165424 = null;
    view2131165429.setOnClickListener(null);
    view2131165429 = null;
    view2131165214.setOnClickListener(null);
    view2131165214 = null;
    view2131165301.setOnClickListener(null);
    view2131165301 = null;
    view2131165302.setOnClickListener(null);
    view2131165302 = null;
    view2131165303.setOnClickListener(null);
    view2131165303 = null;
    view2131165298.setOnClickListener(null);
    view2131165298 = null;
    view2131165277.setOnClickListener(null);
    view2131165277 = null;
    view2131165281.setOnClickListener(null);
    view2131165281 = null;
    view2131165384.setOnClickListener(null);
    view2131165384 = null;
  }
}
