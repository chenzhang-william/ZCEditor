// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.editVideo.adpaters;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PasterAdapter$ViewHolder_ViewBinding implements Unbinder {
  private PasterAdapter.ViewHolder target;

  private View view2131165403;

  @UiThread
  public PasterAdapter$ViewHolder_ViewBinding(final PasterAdapter.ViewHolder target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.pasterview, "field 'pasterview' and method 'onViewClicked'");
    target.pasterview = Utils.castView(view, R.id.pasterview, "field 'pasterview'", ImageView.class);
    view2131165403 = view;
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
    PasterAdapter.ViewHolder target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.pasterview = null;

    view2131165403.setOnClickListener(null);
    view2131165403 = null;
  }
}
