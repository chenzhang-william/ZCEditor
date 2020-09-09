// Generated code from Butter Knife. Do not modify!
package com.zc.editor.base.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CommonViewHolder_ViewBinding implements Unbinder {
  private CommonViewHolder target;

  @UiThread
  public CommonViewHolder_ViewBinding(CommonViewHolder target, View source) {
    this.target = target;

    target.mBtnItemCommon = Utils.findRequiredViewAsType(source, R.id.btn_item_common, "field 'mBtnItemCommon'", Button.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CommonViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mBtnItemCommon = null;
  }
}
