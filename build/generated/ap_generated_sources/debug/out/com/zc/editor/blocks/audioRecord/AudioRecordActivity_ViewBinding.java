// Generated code from Butter Knife. Do not modify!
package com.zc.editor.blocks.audioRecord;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.zc.editor.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AudioRecordActivity_ViewBinding implements Unbinder {
  private AudioRecordActivity target;

  private View view2131165215;

  @UiThread
  public AudioRecordActivity_ViewBinding(AudioRecordActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AudioRecordActivity_ViewBinding(final AudioRecordActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.audio_record_btn, "method 'onViewClicked'");
    view2131165215 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view2131165215.setOnClickListener(null);
    view2131165215 = null;
  }
}
