// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.editVideo;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import com.zc.editor.whole.createVideoByVoice.localEdit.VideoPreviewView;
import com.zc.editor.whole.editVideo.view.VideoEditView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class VideoEditActivity_ViewBinding implements Unbinder {
  private VideoEditActivity target;

  private View view2131165331;

  private View view2131165442;

  private View view2131165349;

  private View view2131165350;

  private View view2131165351;

  private View view2131165293;

  private View view2131165362;

  @UiThread
  public VideoEditActivity_ViewBinding(VideoEditActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public VideoEditActivity_ViewBinding(final VideoEditActivity target, View source) {
    this.target = target;

    View view;
    target.mPbLoading = Utils.findRequiredViewAsType(source, R.id.pb_loading, "field 'mPbLoading'", ProgressBar.class);
    target.mTvHint = Utils.findRequiredViewAsType(source, R.id.tv_hint, "field 'mTvHint'", TextView.class);
    target.mPopVideoLoadingFl = Utils.findRequiredViewAsType(source, R.id.pop_video_loading_fl, "field 'mPopVideoLoadingFl'", FrameLayout.class);
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'ivBack' and method 'onViewClicked'");
    target.ivBack = Utils.castView(view, R.id.iv_back, "field 'ivBack'", ImageView.class);
    view2131165331 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.rlTitle = Utils.findRequiredViewAsType(source, R.id.rl_title, "field 'rlTitle'", RelativeLayout.class);
    target.videoEditView = Utils.findRequiredViewAsType(source, R.id.ll_edit_seekbar, "field 'videoEditView'", VideoEditView.class);
    target.llSelectBar = Utils.findRequiredViewAsType(source, R.id.ll_select_bar, "field 'llSelectBar'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.rl_content_root, "field 'mContentRootView' and method 'onViewClicked'");
    target.mContentRootView = Utils.castView(view, R.id.rl_content_root, "field 'mContentRootView'", FrameLayout.class);
    view2131165442 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.bigiconPlay = Utils.findRequiredViewAsType(source, R.id.bigicon_play, "field 'bigiconPlay'", ImageView.class);
    target.mVideoView = Utils.findRequiredViewAsType(source, R.id.video_preview, "field 'mVideoView'", VideoPreviewView.class);
    view = Utils.findRequiredView(source, R.id.ll_add_filter, "field 'mLlAddFilterTv' and method 'onViewClicked'");
    target.mLlAddFilterTv = Utils.castView(view, R.id.ll_add_filter, "field 'mLlAddFilterTv'", TextView.class);
    view2131165349 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mPopVideoPercentTv = Utils.findRequiredViewAsType(source, R.id.pop_video_percent_tv, "field 'mPopVideoPercentTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.ll_add_sticker, "method 'onViewClicked'");
    view2131165350 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_add_subtitle, "method 'onViewClicked'");
    view2131165351 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.edit_video_next_tv, "method 'onViewClicked'");
    view2131165293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_play_video, "method 'onViewClicked'");
    view2131165362 = view;
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
    VideoEditActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPbLoading = null;
    target.mTvHint = null;
    target.mPopVideoLoadingFl = null;
    target.ivBack = null;
    target.rlTitle = null;
    target.videoEditView = null;
    target.llSelectBar = null;
    target.mContentRootView = null;
    target.bigiconPlay = null;
    target.mVideoView = null;
    target.mLlAddFilterTv = null;
    target.mPopVideoPercentTv = null;

    view2131165331.setOnClickListener(null);
    view2131165331 = null;
    view2131165442.setOnClickListener(null);
    view2131165442 = null;
    view2131165349.setOnClickListener(null);
    view2131165349 = null;
    view2131165350.setOnClickListener(null);
    view2131165350 = null;
    view2131165351.setOnClickListener(null);
    view2131165351 = null;
    view2131165293.setOnClickListener(null);
    view2131165293 = null;
    view2131165362.setOnClickListener(null);
    view2131165362 = null;
  }
}
