// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.others.changeHue;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangeHueActivity_ViewBinding implements Unbinder {
  private ChangeHueActivity target;

  @UiThread
  public ChangeHueActivity_ViewBinding(ChangeHueActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChangeHueActivity_ViewBinding(ChangeHueActivity target, View source) {
    this.target = target;

    target.mChangeHueIv = Utils.findRequiredViewAsType(source, R.id.change_hue_iv, "field 'mChangeHueIv'", ImageView.class);
    target.mChangeHueTv = Utils.findRequiredViewAsType(source, R.id.change_hue_tv, "field 'mChangeHueTv'", TextView.class);
    target.mChangeHueSb = Utils.findRequiredViewAsType(source, R.id.change_hue_sb, "field 'mChangeHueSb'", SeekBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChangeHueActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mChangeHueIv = null;
    target.mChangeHueTv = null;
    target.mChangeHueSb = null;
  }
}
