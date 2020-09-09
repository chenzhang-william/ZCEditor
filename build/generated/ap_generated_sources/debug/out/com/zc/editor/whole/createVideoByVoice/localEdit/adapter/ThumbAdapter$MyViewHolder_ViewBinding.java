// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.createVideoByVoice.localEdit.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ThumbAdapter$MyViewHolder_ViewBinding implements Unbinder {
  private ThumbAdapter.MyViewHolder target;

  @UiThread
  public ThumbAdapter$MyViewHolder_ViewBinding(ThumbAdapter.MyViewHolder target, View source) {
    this.target = target;

    target.mItemThumbIv = Utils.findRequiredViewAsType(source, R.id.item_thumb_iv, "field 'mItemThumbIv'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ThumbAdapter.MyViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mItemThumbIv = null;
  }
}
