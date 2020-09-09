// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.videoPlayer;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import com.zc.editor.whole.videoPlayer.view.FullScreenVideoView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoPlayerActivity_ViewBinding implements Unbinder {
  private VideoPlayerActivity target;

  private View view2131165406;

  private View view2131165378;

  @UiThread
  public VideoPlayerActivity_ViewBinding(VideoPlayerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VideoPlayerActivity_ViewBinding(final VideoPlayerActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.picture_close, "field 'pictureClose' and method 'onClick'");
    target.pictureClose = Utils.castView(view, R.id.picture_close, "field 'pictureClose'", ImageView.class);
    view2131165406 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.meet_download, "field 'meetDownload' and method 'onClick'");
    target.meetDownload = Utils.castView(view, R.id.meet_download, "field 'meetDownload'", ImageView.class);
    view2131165378 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClick(p0);
      }
    });
    target.fullScreenVideoView = Utils.findRequiredViewAsType(source, R.id.video_view, "field 'fullScreenVideoView'", FullScreenVideoView.class);
    target.timer = Utils.findRequiredViewAsType(source, R.id.timer, "field 'timer'", Chronometer.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VideoPlayerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pictureClose = null;
    target.meetDownload = null;
    target.fullScreenVideoView = null;
    target.timer = null;

    view2131165406.setOnClickListener(null);
    view2131165406 = null;
    view2131165378.setOnClickListener(null);
    view2131165378 = null;
  }
}
