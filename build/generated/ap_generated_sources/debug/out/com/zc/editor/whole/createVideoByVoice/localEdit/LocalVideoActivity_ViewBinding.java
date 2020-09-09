// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.createVideoByVoice.localEdit;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LocalVideoActivity_ViewBinding implements Unbinder {
  private LocalVideoActivity target;

  private View view2131165365;

  private View view2131165368;

  private View view2131165372;

  @UiThread
  public LocalVideoActivity_ViewBinding(LocalVideoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LocalVideoActivity_ViewBinding(final LocalVideoActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.local_back_iv, "field 'mLocalBackIv' and method 'onViewClicked'");
    target.mLocalBackIv = Utils.castView(view, R.id.local_back_iv, "field 'mLocalBackIv'", ImageView.class);
    view2131165365 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.local_rotate_iv, "field 'mLocalRotateIv' and method 'onViewClicked'");
    target.mLocalRotateIv = Utils.castView(view, R.id.local_rotate_iv, "field 'mLocalRotateIv'", ImageView.class);
    view2131165368 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.local_video_next_tv, "field 'mLocalVideoNextTv' and method 'onViewClicked'");
    target.mLocalVideoNextTv = Utils.castView(view, R.id.local_video_next_tv, "field 'mLocalVideoNextTv'", TextView.class);
    view2131165372 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mLocalTitle = Utils.findRequiredViewAsType(source, R.id.local_title, "field 'mLocalTitle'", RelativeLayout.class);
    target.mLocalVideoView = Utils.findRequiredViewAsType(source, R.id.local_video_view, "field 'mLocalVideoView'", VideoPreviewView.class);
    target.mLocalSelTimeTv = Utils.findRequiredViewAsType(source, R.id.local_sel_time_tv, "field 'mLocalSelTimeTv'", TextView.class);
    target.mLocalRecyclerView = Utils.findRequiredViewAsType(source, R.id.local_recycler_view, "field 'mLocalRecyclerView'", RecyclerView.class);
    target.mLocalThumbView = Utils.findRequiredViewAsType(source, R.id.local_thumb_view, "field 'mLocalThumbView'", ThumbnailView.class);
    target.mLocalFrameLayout = Utils.findRequiredViewAsType(source, R.id.local_frame_layout, "field 'mLocalFrameLayout'", FrameLayout.class);
    target.mPbLoading = Utils.findRequiredViewAsType(source, R.id.pb_loading, "field 'mPbLoading'", ProgressBar.class);
    target.mTvHint = Utils.findRequiredViewAsType(source, R.id.tv_hint, "field 'mTvHint'", TextView.class);
    target.mPopVideoLoadingFl = Utils.findRequiredViewAsType(source, R.id.pop_video_loading_fl, "field 'mPopVideoLoadingFl'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LocalVideoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLocalBackIv = null;
    target.mLocalRotateIv = null;
    target.mLocalVideoNextTv = null;
    target.mLocalTitle = null;
    target.mLocalVideoView = null;
    target.mLocalSelTimeTv = null;
    target.mLocalRecyclerView = null;
    target.mLocalThumbView = null;
    target.mLocalFrameLayout = null;
    target.mPbLoading = null;
    target.mTvHint = null;
    target.mPopVideoLoadingFl = null;

    view2131165365.setOnClickListener(null);
    view2131165365 = null;
    view2131165368.setOnClickListener(null);
    view2131165368 = null;
    view2131165372.setOnClickListener(null);
    view2131165372 = null;
  }
}
