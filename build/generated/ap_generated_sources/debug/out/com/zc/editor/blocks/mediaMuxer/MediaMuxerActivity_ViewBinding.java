// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaMuxer;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MediaMuxerActivity_ViewBinding implements Unbinder {
  private MediaMuxerActivity target;

  private View view2131165387;

  private View view2131165386;

  @UiThread
  public MediaMuxerActivity_ViewBinding(MediaMuxerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MediaMuxerActivity_ViewBinding(final MediaMuxerActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.muxer_aac_video_to_mp4, "method 'onViewClicked'");
    view2131165387 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.muxer_aac_db_to_mp4, "method 'onViewClicked'");
    view2131165386 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131165387.setOnClickListener(null);
    view2131165387 = null;
    view2131165386.setOnClickListener(null);
    view2131165386 = null;
  }
}
