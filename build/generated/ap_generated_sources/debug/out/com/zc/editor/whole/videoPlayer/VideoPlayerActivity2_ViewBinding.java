// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.videoPlayer;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import com.zc.editor.whole.jiaozivideo.PublicVideoJZVideo;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoPlayerActivity2_ViewBinding implements Unbinder {
  private VideoPlayerActivity2 target;

  private View view2131165550;

  private View view2131165551;

  private View view2131165217;

  private View view2131165553;

  private View view2131165552;

  @UiThread
  public VideoPlayerActivity2_ViewBinding(VideoPlayerActivity2 target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VideoPlayerActivity2_ViewBinding(final VideoPlayerActivity2 target, View source) {
    this.target = target;

    View view;
    target.mPublicVideoJZVideo = Utils.findRequiredViewAsType(source, R.id.public_video_jz_video, "field 'mPublicVideoJZVideo'", PublicVideoJZVideo.class);
    target.mPopVideoLoadingFl = Utils.findRequiredViewAsType(source, R.id.pop_video_loading_fl, "field 'mPopVideoLoadingFl'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.video_player2_edit_video_tv, "method 'onViewClicked'");
    view2131165550 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_player2_sel_cover, "method 'onViewClicked'");
    view2131165551 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.back_iv, "method 'onViewClicked'");
    view2131165217 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_player_tv_storage, "method 'onViewClicked'");
    view2131165553 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.video_player_tv_public, "method 'onViewClicked'");
    view2131165552 = view;
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
    VideoPlayerActivity2 target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPublicVideoJZVideo = null;
    target.mPopVideoLoadingFl = null;

    view2131165550.setOnClickListener(null);
    view2131165550 = null;
    view2131165551.setOnClickListener(null);
    view2131165551 = null;
    view2131165217.setOnClickListener(null);
    view2131165217 = null;
    view2131165553.setOnClickListener(null);
    view2131165553 = null;
    view2131165552.setOnClickListener(null);
    view2131165552 = null;
  }
}
