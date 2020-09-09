// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaCodec.primary.mp3TranslateAAC;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Mp3TranslateAACActivity_ViewBinding implements Unbinder {
  private Mp3TranslateAACActivity target;

  private View view2131165487;

  private View view2131165488;

  private View view2131165489;

  @UiThread
  public Mp3TranslateAACActivity_ViewBinding(Mp3TranslateAACActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public Mp3TranslateAACActivity_ViewBinding(final Mp3TranslateAACActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.start1_btn, "method 'onViewClicked'");
    view2131165487 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.start2_btn, "method 'onViewClicked'");
    view2131165488 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.start3_btn, "method 'onViewClicked'");
    view2131165489 = view;
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


    view2131165487.setOnClickListener(null);
    view2131165487 = null;
    view2131165488.setOnClickListener(null);
    view2131165488 = null;
    view2131165489.setOnClickListener(null);
    view2131165489 = null;
  }
}
