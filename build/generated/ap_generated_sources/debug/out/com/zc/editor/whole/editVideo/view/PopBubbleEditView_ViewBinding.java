// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.editVideo.view;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PopBubbleEditView_ViewBinding implements Unbinder {
  private PopBubbleEditView target;

  private View view2131165290;

  private View view2131165520;

  @UiThread
  public PopBubbleEditView_ViewBinding(final PopBubbleEditView target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.ed_content, "field 'edContent' and method 'onViewClicked'");
    target.edContent = Utils.castView(view, R.id.ed_content, "field 'edContent'", EditText.class);
    view2131165290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_confirm, "field 'tvConfirm' and method 'onViewClicked'");
    target.tvConfirm = Utils.castView(view, R.id.tv_confirm, "field 'tvConfirm'", TextView.class);
    view2131165520 = view;
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
    PopBubbleEditView target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.edContent = null;
    target.tvConfirm = null;

    view2131165290.setOnClickListener(null);
    view2131165290 = null;
    view2131165520.setOnClickListener(null);
    view2131165520 = null;
  }
}
