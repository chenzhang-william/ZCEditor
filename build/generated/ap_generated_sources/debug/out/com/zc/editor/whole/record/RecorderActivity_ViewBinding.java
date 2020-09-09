// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.record;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import com.zc.editor.whole.record.ui.CameraView;
import com.zc.editor.whole.record.ui.CustomRecordImageView;
import com.zc.editor.whole.record.ui.FocusImageView;
import com.zc.editor.whole.record.ui.ProgressView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecorderActivity_ViewBinding implements Unbinder {
  private RecorderActivity target;

  private View view2131165376;

  private View view2131165557;

  private View view2131165494;

  private View view2131165325;

  private View view2131165324;

  private View view2131165270;

  private View view2131165264;

  private View view2131165379;

  private View view2131165546;

  @UiThread
  public RecorderActivity_ViewBinding(RecorderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RecorderActivity_ViewBinding(final RecorderActivity target, View source) {
    this.target = target;

    View view;
    target.mRecordCameraView = Utils.findRequiredViewAsType(source, R.id.record_camera_view, "field 'mRecordCameraView'", CameraView.class);
    target.mVideoRecordProgressView = Utils.findRequiredViewAsType(source, R.id.video_record_progress_view, "field 'mVideoRecordProgressView'", ProgressView.class);
    view = Utils.findRequiredView(source, R.id.matching_back, "field 'mMatchingBack' and method 'onViewClicked'");
    target.mMatchingBack = Utils.castView(view, R.id.matching_back, "field 'mMatchingBack'", LinearLayout.class);
    view2131165376 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_record_finish_iv, "field 'mVideoRecordFinishIv' and method 'onViewClicked'");
    target.mVideoRecordFinishIv = Utils.castView(view, R.id.video_record_finish_iv, "field 'mVideoRecordFinishIv'", Button.class);
    view2131165557 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.switch_camera, "field 'mMeetCamera' and method 'onViewClicked'");
    target.mMeetCamera = Utils.castView(view, R.id.switch_camera, "field 'mMeetCamera'", ImageView.class);
    view2131165494 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.index_delete, "field 'mIndexDelete' and method 'onViewClicked'");
    target.mIndexDelete = Utils.castView(view, R.id.index_delete, "field 'mIndexDelete'", LinearLayout.class);
    view2131165325 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.index_album, "field 'mIndexAlbum' and method 'onViewClicked'");
    target.mIndexAlbum = Utils.castView(view, R.id.index_album, "field 'mIndexAlbum'", TextView.class);
    view2131165324 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.custom_record_image_view, "field 'mCustomRecordImageView' and method 'onViewClicked'");
    target.mCustomRecordImageView = Utils.castView(view, R.id.custom_record_image_view, "field 'mCustomRecordImageView'", CustomRecordImageView.class);
    view2131165270 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.count_down_tv, "field 'mCountDownTv' and method 'onViewClicked'");
    target.mCountDownTv = Utils.castView(view, R.id.count_down_tv, "field 'mCountDownTv'", TextView.class);
    view2131165264 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRecordBtnLl = Utils.findRequiredViewAsType(source, R.id.record_btn_ll, "field 'mRecordBtnLl'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.meet_mask, "field 'mMeetMask' and method 'onViewClicked'");
    target.mMeetMask = Utils.castView(view, R.id.meet_mask, "field 'mMeetMask'", ImageView.class);
    view2131165379 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_filter, "field 'mVideoFilter' and method 'onViewClicked'");
    target.mVideoFilter = Utils.castView(view, R.id.video_filter, "field 'mVideoFilter'", ImageView.class);
    view2131165546 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRecorderFocusIv = Utils.findRequiredViewAsType(source, R.id.recorder_focus_iv, "field 'mRecorderFocusIv'", FocusImageView.class);
    target.mCountTimeDownIv = Utils.findRequiredViewAsType(source, R.id.count_time_down_iv, "field 'mCountTimeDownIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RecorderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecordCameraView = null;
    target.mVideoRecordProgressView = null;
    target.mMatchingBack = null;
    target.mVideoRecordFinishIv = null;
    target.mMeetCamera = null;
    target.mIndexDelete = null;
    target.mIndexAlbum = null;
    target.mCustomRecordImageView = null;
    target.mCountDownTv = null;
    target.mRecordBtnLl = null;
    target.mMeetMask = null;
    target.mVideoFilter = null;
    target.mRecorderFocusIv = null;
    target.mCountTimeDownIv = null;

    view2131165376.setOnClickListener(null);
    view2131165376 = null;
    view2131165557.setOnClickListener(null);
    view2131165557 = null;
    view2131165494.setOnClickListener(null);
    view2131165494 = null;
    view2131165325.setOnClickListener(null);
    view2131165325 = null;
    view2131165324.setOnClickListener(null);
    view2131165324 = null;
    view2131165270.setOnClickListener(null);
    view2131165270 = null;
    view2131165264.setOnClickListener(null);
    view2131165264 = null;
    view2131165379.setOnClickListener(null);
    view2131165379 = null;
    view2131165546.setOnClickListener(null);
    view2131165546 = null;
  }
}
