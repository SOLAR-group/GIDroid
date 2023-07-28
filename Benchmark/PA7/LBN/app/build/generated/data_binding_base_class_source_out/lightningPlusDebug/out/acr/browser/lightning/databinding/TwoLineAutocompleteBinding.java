// Generated by view binder compiler. Do not edit!
package acr.browser.lightning.databinding;

import acr.browser.lightning.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TwoLineAutocompleteBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView completeSearch;

  @NonNull
  public final ImageView suggestionIcon;

  @NonNull
  public final TextView title;

  @NonNull
  public final TextView url;

  private TwoLineAutocompleteBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView completeSearch, @NonNull ImageView suggestionIcon, @NonNull TextView title,
      @NonNull TextView url) {
    this.rootView = rootView;
    this.completeSearch = completeSearch;
    this.suggestionIcon = suggestionIcon;
    this.title = title;
    this.url = url;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static TwoLineAutocompleteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static TwoLineAutocompleteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.two_line_autocomplete, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static TwoLineAutocompleteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.complete_search;
      ImageView completeSearch = ViewBindings.findChildViewById(rootView, id);
      if (completeSearch == null) {
        break missingId;
      }

      id = R.id.suggestionIcon;
      ImageView suggestionIcon = ViewBindings.findChildViewById(rootView, id);
      if (suggestionIcon == null) {
        break missingId;
      }

      id = R.id.title;
      TextView title = ViewBindings.findChildViewById(rootView, id);
      if (title == null) {
        break missingId;
      }

      id = R.id.url;
      TextView url = ViewBindings.findChildViewById(rootView, id);
      if (url == null) {
        break missingId;
      }

      return new TwoLineAutocompleteBinding((LinearLayout) rootView, completeSearch, suggestionIcon,
          title, url);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
