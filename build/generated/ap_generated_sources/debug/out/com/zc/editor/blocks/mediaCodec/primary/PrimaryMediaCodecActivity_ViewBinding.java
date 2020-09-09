// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaCodec.primary;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PrimaryMediaCodecActivity_ViewBinding implements Unbinder {
  private PrimaryMediaCodecActivity target;

  private View view2131165240;

  private View view2131165242;

  @UiThread
  public PrimaryMediaCodecActivity_ViewBinding(PrimaryMediaCodecActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PrimaryMediaCodecActivity_ViewBinding(final PrimaryMediaCodecActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.btn_recording, "field 'mBtnRecording' and method 'onViewClicked'");
    target.mBtnRecording = Utils.castView(view, R.id.btn_recording, "field 'mBtnRecording'", Button.class);
    view2131165240 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_watch, "field 'mBtnWatch' and method 'onViewClicked'");
    target.mBtnWatch = Utils.castView(view, R.id.btn_watch, "field 'mBtnWatch'", Button.class);
    view2131165242 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mPrimaryMcTv = Utils.findRequiredViewAsType(source, R.id.primary_mc_tv, "field 'mPrimaryMcTv'", TextView.class);
    target.mPrimaryVv = Utils.findRequiredViewAsType(source, R.id.primary_vv, "field 'mPrimaryVv'", VideoView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PrimaryMediaCodecActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBtnRecording = null;
    target.mBtnWatch = null;
    target.mPrimaryMcTv = null;
    target.mPrimaryVv = null;

    view2131165240.setOnClickListener(null);
    view2131165240 = null;
    view2131165242.setOnClickListener(null);
    view2131165242 = null;
  }
}
