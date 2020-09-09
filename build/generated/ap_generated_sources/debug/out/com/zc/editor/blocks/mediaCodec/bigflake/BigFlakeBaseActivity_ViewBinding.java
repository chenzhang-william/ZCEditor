// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.mediaCodec.bigflake;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class BigFlakeBaseActivity_ViewBinding implements Unbinder {
  private BigFlakeBaseActivity target;

  private View view2131165486;

  private View view2131165408;

  @UiThread
  public BigFlakeBaseActivity_ViewBinding(BigFlakeBaseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public BigFlakeBaseActivity_ViewBinding(final BigFlakeBaseActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.start, "field 'mStart' and method 'onViewClicked'");
    target.mStart = Utils.castView(view, R.id.start, "field 'mStart'", Button.class);
    view2131165486 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.player, "method 'onViewClicked'");
    view2131165408 = view;
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
    BigFlakeBaseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mStart = null;

    view2131165486.setOnClickListener(null);
    view2131165486 = null;
    view2131165408.setOnClickListener(null);
    view2131165408 = null;
  }
}
