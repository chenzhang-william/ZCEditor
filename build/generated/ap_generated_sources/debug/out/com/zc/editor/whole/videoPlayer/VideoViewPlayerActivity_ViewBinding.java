// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.videoPlayer;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.VideoView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoViewPlayerActivity_ViewBinding implements Unbinder {
  private VideoViewPlayerActivity target;

  @UiThread
  public VideoViewPlayerActivity_ViewBinding(VideoViewPlayerActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VideoViewPlayerActivity_ViewBinding(VideoViewPlayerActivity target, View source) {
    this.target = target;

    target.mVideoPlayerVv = Utils.findRequiredViewAsType(source, R.id.video_player_vv, "field 'mVideoPlayerVv'", VideoView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    VideoViewPlayerActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mVideoPlayerVv = null;
  }
}
