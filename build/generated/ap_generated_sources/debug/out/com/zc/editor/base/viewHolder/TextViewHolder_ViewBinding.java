// Generated code from Butter Knife. Do not modify!
package com.zc.editor.base.viewHolder;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TextViewHolder_ViewBinding implements Unbinder {
  private TextViewHolder target;

  @UiThread
  public TextViewHolder_ViewBinding(TextViewHolder target, View source) {
    this.target = target;

    target.mBaseRecyclerViewItemTv = Utils.findRequiredViewAsType(source, R.id.base_recycler_view_item_tv, "field 'mBaseRecyclerViewItemTv'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TextViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBaseRecyclerViewItemTv = null;
  }
}
