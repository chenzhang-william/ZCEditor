// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaCodec.show;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.SurfaceView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MediaCodecShowOnGlSurfaceView_ViewBinding implements Unbinder {
  private MediaCodecShowOnGlSurfaceView target;

  private View view2131165466;

  private View view2131165275;

  private View view2131165285;

  @UiThread
  public MediaCodecShowOnGlSurfaceView_ViewBinding(MediaCodecShowOnGlSurfaceView target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MediaCodecShowOnGlSurfaceView_ViewBinding(final MediaCodecShowOnGlSurfaceView target,
      View source) {
    this.target = target;

    View view;
    target.mSurfaceView = Utils.findRequiredViewAsType(source, R.id.mSurface, "field 'mSurfaceView'", SurfaceView.class);
    view = Utils.findRequiredView(source, R.id.sel_btn, "method 'onViewClicked'");
    view2131165466 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.decode_show_btn, "method 'onViewClicked'");
    view2131165275 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.detail_video_btn, "method 'onViewClicked'");
    view2131165285 = view;
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
    MediaCodecShowOnGlSurfaceView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSurfaceView = null;

    view2131165466.setOnClickListener(null);
    view2131165466 = null;
    view2131165275.setOnClickListener(null);
    view2131165275 = null;
    view2131165285.setOnClickListener(null);
    view2131165285 = null;
  }
}
