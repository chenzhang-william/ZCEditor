// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaCodec.recordBaseCamera;

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

public class RecordBaseCameraActivity_ViewBinding implements Unbinder {
  private RecordBaseCameraActivity target;

  private View view2131165237;

  private View view2131165236;

  @UiThread
  public RecordBaseCameraActivity_ViewBinding(RecordBaseCameraActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RecordBaseCameraActivity_ViewBinding(final RecordBaseCameraActivity target, View source) {
    this.target = target;

    View view;
    target.mRecordBaseCameraSv = Utils.findRequiredViewAsType(source, R.id.record_base_camera_sv, "field 'mRecordBaseCameraSv'", SurfaceView.class);
    view = Utils.findRequiredView(source, R.id.btn_record_base_status, "field 'mBtnRecordBaseStatus' and method 'onViewClicked'");
    target.mBtnRecordBaseStatus = Utils.castView(view, R.id.btn_record_base_status, "field 'mBtnRecordBaseStatus'", Button.class);
    view2131165237 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_record_base_player, "field 'mBtnRecordBasePlayer' and method 'onViewClicked'");
    target.mBtnRecordBasePlayer = Utils.castView(view, R.id.btn_record_base_player, "field 'mBtnRecordBasePlayer'", Button.class);
    view2131165236 = view;
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
    RecordBaseCameraActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mRecordBaseCameraSv = null;
    target.mBtnRecordBaseStatus = null;
    target.mBtnRecordBasePlayer = null;

    view2131165237.setOnClickListener(null);
    view2131165237 = null;
    view2131165236.setOnClickListener(null);
    view2131165236 = null;
  }
}
