// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.selCover;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import com.zc.editor.whole.selCover.view.ThumbnailSelTimeView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelCoverTimeActivity_ViewBinding implements Unbinder {
  private SelCoverTimeActivity target;

  private View view2131165331;

  private View view2131165272;

  @UiThread
  public SelCoverTimeActivity_ViewBinding(SelCoverTimeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SelCoverTimeActivity_ViewBinding(final SelCoverTimeActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.iv_back, "field 'mIvBack' and method 'onViewClicked'");
    target.mIvBack = Utils.castView(view, R.id.iv_back, "field 'mIvBack'", ImageView.class);
    view2131165331 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.cut_time_finish_tv, "field 'mCutTimeFinishTv' and method 'onViewClicked'");
    target.mCutTimeFinishTv = Utils.castView(view, R.id.cut_time_finish_tv, "field 'mCutTimeFinishTv'", TextView.class);
    view2131165272 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mRlTitle = Utils.findRequiredViewAsType(source, R.id.rl_title, "field 'mRlTitle'", RelativeLayout.class);
    target.mCutRecyclerView = Utils.findRequiredViewAsType(source, R.id.cut_recycler_view, "field 'mCutRecyclerView'", RecyclerView.class);
    target.mThumbSelTimeView = Utils.findRequiredViewAsType(source, R.id.thumb_sel_time_view, "field 'mThumbSelTimeView'", ThumbnailSelTimeView.class);
    target.mSelCoverVideoView = Utils.findRequiredViewAsType(source, R.id.sel_cover_video_view, "field 'mSelCoverVideoView'", VideoView.class);
    target.mSelCoverTv = Utils.findRequiredViewAsType(source, R.id.sel_cover_tv, "field 'mSelCoverTv'", TextView.class);
    target.mSelCoverFrameLayout = Utils.findRequiredViewAsType(source, R.id.sel_cover_frame_layout, "field 'mSelCoverFrameLayout'", FrameLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelCoverTimeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mIvBack = null;
    target.mCutTimeFinishTv = null;
    target.mRlTitle = null;
    target.mCutRecyclerView = null;
    target.mThumbSelTimeView = null;
    target.mSelCoverVideoView = null;
    target.mSelCoverTv = null;
    target.mSelCoverFrameLayout = null;

    view2131165331.setOnClickListener(null);
    view2131165331 = null;
    view2131165272.setOnClickListener(null);
    view2131165272 = null;
  }
}
