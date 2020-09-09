// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaCodec.recordCamera;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RecordCameraActivity_ViewBinding implements Unbinder {
  private RecordCameraActivity target;

  private View view2131165239;

  private View view2131165238;

  @UiThread
  public RecordCameraActivity_ViewBinding(RecordCameraActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RecordCameraActivity_ViewBinding(final RecordCameraActivity target, View source) {
    this.target = target;

    View view;
    target.mRecordCameraSv = Utils.findRequiredViewAsType(source, R.id.record_camera_sv, "field 'mRecordCameraSv'", SurfaceView.class);
    view = Utils.findRequiredView(source, R.id.btn_record_status, "field 'mBtnRecordStatus' and method 'onViewClicked'");
    target.mBtnRecordStatus = Utils.castView(view, R.id.btn_record_status, "field 'mBtnRecordStatus'", Button.class);
    view2131165239 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_record_player, "method 'onViewClicked'");
    view2131165238 = view;
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
    RecordCameraActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecordCameraSv = null;
    target.mBtnRecordStatus = null;

    view2131165239.setOnClickListener(null);
    view2131165239 = null;
    view2131165238.setOnClickListener(null);
    view2131165238 = null;
  }
}
