// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.editVideo.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PopBubbleView_ViewBinding implements Unbinder {
  private PopBubbleView target;

  private View view2131165355;

  private View view2131165359;

  private View view2131165358;

  private View view2131165354;

  private View view2131165353;

  private View view2131165357;

  private View view2131165356;

  private View view2131165352;

  @UiThread
  public PopBubbleView_ViewBinding(final PopBubbleView target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ll_bubble_one, "method 'onViewClicked'");
    view2131165355 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_two, "method 'onViewClicked'");
    view2131165359 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_three, "method 'onViewClicked'");
    view2131165358 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_four, "method 'onViewClicked'");
    view2131165354 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_five, "method 'onViewClicked'");
    view2131165353 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_six, "method 'onViewClicked'");
    view2131165357 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_seven, "method 'onViewClicked'");
    view2131165356 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ll_bubble_eight, "method 'onViewClicked'");
    view2131165352 = view;
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


    view2131165355.setOnClickListener(null);
    view2131165355 = null;
    view2131165359.setOnClickListener(null);
    view2131165359 = null;
    view2131165358.setOnClickListener(null);
    view2131165358 = null;
    view2131165354.setOnClickListener(null);
    view2131165354 = null;
    view2131165353.setOnClickListener(null);
    view2131165353 = null;
    view2131165357.setOnClickListener(null);
    view2131165357 = null;
    view2131165356.setOnClickListener(null);
    view2131165356 = null;
    view2131165352.setOnClickListener(null);
    view2131165352 = null;
  }
}
