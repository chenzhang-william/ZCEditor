// Generated code from Butter Knife. Do not modify!
package com.zc.editor.whole.createVideoByVoice;

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

public class CreateVideoByAudioDbActivity_ViewBinding implements Unbinder {
  private CreateVideoByAudioDbActivity target;

  private View view2131165266;

  private View view2131165407;

  @UiThread
  public CreateVideoByAudioDbActivity_ViewBinding(CreateVideoByAudioDbActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public CreateVideoByAudioDbActivity_ViewBinding(final CreateVideoByAudioDbActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.create_video_analyze_btn, "field 'mCreateVideoAnalyzeBtn' and method 'onViewClicked'");
    target.mCreateVideoAnalyzeBtn = Utils.castView(view, R.id.create_video_analyze_btn, "field 'mCreateVideoAnalyzeBtn'", Button.class);
    view2131165266 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.play_video_btn, "field 'mPlayVideoBtn' and method 'onViewClicked'");
    target.mPlayVideoBtn = Utils.castView(view, R.id.play_video_btn, "field 'mPlayVideoBtn'", Button.class);
    view2131165407 = view;
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
    CreateVideoByAudioDbActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mCreateVideoAnalyzeBtn = null;
    target.mPlayVideoBtn = null;

    view2131165266.setOnClickListener(null);
    view2131165266 = null;
    view2131165407.setOnClickListener(null);
    view2131165407 = null;
  }
}
