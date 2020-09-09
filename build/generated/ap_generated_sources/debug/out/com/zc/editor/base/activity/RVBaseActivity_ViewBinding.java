// Generated code from Butter Knife. Do not modify!
package com.zc.editor.base.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RVBaseActivity_ViewBinding implements Unbinder {
  private RVBaseActivity target;

  @UiThread
  public RVBaseActivity_ViewBinding(RVBaseActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RVBaseActivity_ViewBinding(RVBaseActivity target, View source) {
    this.target = target;

    target.mBaseRv = Utils.findRequiredViewAsType(source, R.id.base_rv, "field 'mBaseRv'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    RVBaseActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBaseRv = null;
  }
}
