// Generated code from Butter Knife. Do not modify!
package acr.browser.lightning.reading.activity;

import acr.browser.lightning.R;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ReadingActivity_ViewBinding implements Unbinder {
  private ReadingActivity target;

  @UiThread
  public ReadingActivity_ViewBinding(ReadingActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ReadingActivity_ViewBinding(ReadingActivity target, View source) {
    this.target = target;

    target.mTitle = Utils.findRequiredViewAsType(source, R.id.textViewTitle, "field 'mTitle'", TextView.class);
    target.mBody = Utils.findRequiredViewAsType(source, R.id.textViewBody, "field 'mBody'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ReadingActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mTitle = null;
    target.mBody = null;
  }
}
