// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.editVideo.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FilterDialogFragment_ViewBinding implements Unbinder {
  private FilterDialogFragment target;

  private View view2131165399;

  private View view2131165284;

  private View view2131165294;

  private View view2131165478;

  private View view2131165511;

  private View view2131165562;

  private View view2131165392;

  private View view2131165397;

  private View view2131165539;

  private View view2131165502;

  private View view2131165310;

  private View view2131165308;

  private View view2131165383;

  private View view2131165307;

  private View view2131165225;

  @UiThread
  public FilterDialogFragment_ViewBinding(final FilterDialogFragment target, View source) {
    this.target = target;

    View view;
    target.mPopFilterTv = Utils.findRequiredViewAsType(source, R.id.pop_filter_tv, "field 'mPopFilterTv'", TextView.class);
    view = Utils.findRequiredView(source, R.id.origin, "field 'mOrigin' and method 'onViewClicked'");
    target.mOrigin = Utils.castView(view, R.id.origin, "field 'mOrigin'", TextView.class);
    view2131165399 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.delta, "field 'mDelta' and method 'onViewClicked'");
    target.mDelta = Utils.castView(view, R.id.delta, "field 'mDelta'", TextView.class);
    view2131165284 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.electric, "field 'mElectric' and method 'onViewClicked'");
    target.mElectric = Utils.castView(view, R.id.electric, "field 'mElectric'", TextView.class);
    view2131165294 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.slowlived, "field 'mSlowlived' and method 'onViewClicked'");
    target.mSlowlived = Utils.castView(view, R.id.slowlived, "field 'mSlowlived'", TextView.class);
    view2131165478 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tokyo, "field 'mTokyo' and method 'onViewClicked'");
    target.mTokyo = Utils.castView(view, R.id.tokyo, "field 'mTokyo'", TextView.class);
    view2131165511 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.warm, "field 'mWarm' and method 'onViewClicked'");
    target.mWarm = Utils.castView(view, R.id.warm, "field 'mWarm'", TextView.class);
    view2131165562 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mPopFilterSv = Utils.findRequiredViewAsType(source, R.id.pop_filter_sv, "field 'mPopFilterSv'", HorizontalScrollView.class);
    view = Utils.findRequiredView(source, R.id.none_iv, "field 'mNoneIv' and method 'onViewClicked'");
    target.mNoneIv = Utils.castView(view, R.id.none_iv, "field 'mNoneIv'", ImageView.class);
    view2131165392 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.one_tv, "field 'mOneTv' and method 'onViewClicked'");
    target.mOneTv = Utils.castView(view, R.id.one_tv, "field 'mOneTv'", TextView.class);
    view2131165397 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.two_tv, "field 'mTwoTv' and method 'onViewClicked'");
    target.mTwoTv = Utils.castView(view, R.id.two_tv, "field 'mTwoTv'", TextView.class);
    view2131165539 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.three_tv, "field 'mThreeTv' and method 'onViewClicked'");
    target.mThreeTv = Utils.castView(view, R.id.three_tv, "field 'mThreeTv'", TextView.class);
    view2131165502 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.four_tv, "field 'mFourTv' and method 'onViewClicked'");
    target.mFourTv = Utils.castView(view, R.id.four_tv, "field 'mFourTv'", TextView.class);
    view2131165310 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.five_tv, "field 'mFiveTv' and method 'onViewClicked'");
    target.mFiveTv = Utils.castView(view, R.id.five_tv, "field 'mFiveTv'", TextView.class);
    view2131165308 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.mPopBeautyLl = Utils.findRequiredViewAsType(source, R.id.pop_beauty_ll, "field 'mPopBeautyLl'", LinearLayout.class);
    target.mPopFilterLl = Utils.findRequiredViewAsType(source, R.id.pop_filter_ll, "field 'mPopFilterLl'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.mking_tv, "field 'mMkingTv' and method 'onViewClicked'");
    target.mMkingTv = Utils.castView(view, R.id.mking_tv, "field 'mMkingTv'", TextView.class);
    view2131165383 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.filter_tv, "field 'mFilterTv' and method 'onViewClicked'");
    target.mFilterTv = Utils.castView(view, R.id.filter_tv, "field 'mFilterTv'", TextView.class);
    view2131165307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.beauty_tv, "field 'mBeautyTv' and method 'onViewClicked'");
    target.mBeautyTv = Utils.castView(view, R.id.beauty_tv, "field 'mBeautyTv'", TextView.class);
    view2131165225 = view;
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
    FilterDialogFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mPopFilterTv = null;
    target.mOrigin = null;
    target.mDelta = null;
    target.mElectric = null;
    target.mSlowlived = null;
    target.mTokyo = null;
    target.mWarm = null;
    target.mPopFilterSv = null;
    target.mNoneIv = null;
    target.mOneTv = null;
    target.mTwoTv = null;
    target.mThreeTv = null;
    target.mFourTv = null;
    target.mFiveTv = null;
    target.mPopBeautyLl = null;
    target.mPopFilterLl = null;
    target.mMkingTv = null;
    target.mFilterTv = null;
    target.mBeautyTv = null;

    view2131165399.setOnClickListener(null);
    view2131165399 = null;
    view2131165284.setOnClickListener(null);
    view2131165284 = null;
    view2131165294.setOnClickListener(null);
    view2131165294 = null;
    view2131165478.setOnClickListener(null);
    view2131165478 = null;
    view2131165511.setOnClickListener(null);
    view2131165511 = null;
    view2131165562.setOnClickListener(null);
    view2131165562 = null;
    view2131165392.setOnClickListener(null);
    view2131165392 = null;
    view2131165397.setOnClickListener(null);
    view2131165397 = null;
    view2131165539.setOnClickListener(null);
    view2131165539 = null;
    view2131165502.setOnClickListener(null);
    view2131165502 = null;
    view2131165310.setOnClickListener(null);
    view2131165310 = null;
    view2131165308.setOnClickListener(null);
    view2131165308 = null;
    view2131165383.setOnClickListener(null);
    view2131165383 = null;
    view2131165307.setOnClickListener(null);
    view2131165307 = null;
    view2131165225.setOnClickListener(null);
    view2131165225 = null;
  }
}
