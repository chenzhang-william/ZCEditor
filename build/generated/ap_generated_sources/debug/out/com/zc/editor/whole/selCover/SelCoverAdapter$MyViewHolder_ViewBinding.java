// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.selCover;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SelCoverAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private SelCoverAdapter.MyViewHolder target;

  @UiThread
  public SelCoverAdapter$MyViewHolder_ViewBinding(SelCoverAdapter.MyViewHolder target,
      View source) {
    this.target = target;

    target.mSelCoverIv = Utils.findRequiredViewAsType(source, R.id.sel_cover_iv, "field 'mSelCoverIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SelCoverAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mSelCoverIv = null;
  }
}
