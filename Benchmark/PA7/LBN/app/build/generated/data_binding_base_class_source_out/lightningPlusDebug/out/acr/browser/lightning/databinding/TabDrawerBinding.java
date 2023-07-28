// Generated by view binder compiler. Do not edit!
package acr.browser.lightning.databinding;

import acr.browser.lightning.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class TabDrawerBinding implements ViewBinding {
  @NonNull
  private final View rootView;

  @NonNull
  public final ImageView actionBack;

  @NonNull
  public final ImageView actionForward;

  @NonNull
  public final ImageView actionHome;

  @NonNull
  public final RecyclerView drawerTabsList;

  @NonNull
  public final ImageView newTabButton;

  @NonNull
  public final ImageView tabHeaderButton;

  private TabDrawerBinding(@NonNull View rootView, @NonNull ImageView actionBack,
      @NonNull ImageView actionForward, @NonNull ImageView actionHome,
      @NonNull RecyclerView drawerTabsList, @NonNull ImageView newTabButton,
      @NonNull ImageView tabHeaderButton) {
    this.rootView = rootView;
    this.actionBack = actionBack;
    this.actionForward = actionForward;
    this.actionHome = actionHome;
    this.drawerTabsList = drawerTabsList;
    this.newTabButton = newTabButton;
    this.tabHeaderButton = tabHeaderButton;
  }

  @Override
  @NonNull
  public View getRoot() {
    return rootView;
  }

  @NonNull
  public static TabDrawerBinding inflate(@NonNull LayoutInflater inflater,
      @NonNull ViewGroup parent) {
    if (parent == null) {
      throw new NullPointerException("parent");
    }
    inflater.inflate(R.layout.tab_drawer, parent);
    return bind(parent);
  }

  @NonNull
  public static TabDrawerBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.action_back;
      ImageView actionBack = ViewBindings.findChildViewById(rootView, id);
      if (actionBack == null) {
        break missingId;
      }

      id = R.id.action_forward;
      ImageView actionForward = ViewBindings.findChildViewById(rootView, id);
      if (actionForward == null) {
        break missingId;
      }

      id = R.id.action_home;
      ImageView actionHome = ViewBindings.findChildViewById(rootView, id);
      if (actionHome == null) {
        break missingId;
      }

      id = R.id.drawer_tabs_list;
      RecyclerView drawerTabsList = ViewBindings.findChildViewById(rootView, id);
      if (drawerTabsList == null) {
        break missingId;
      }

      id = R.id.new_tab_button;
      ImageView newTabButton = ViewBindings.findChildViewById(rootView, id);
      if (newTabButton == null) {
        break missingId;
      }

      id = R.id.tab_header_button;
      ImageView tabHeaderButton = ViewBindings.findChildViewById(rootView, id);
      if (tabHeaderButton == null) {
        break missingId;
      }

      return new TabDrawerBinding(rootView, actionBack, actionForward, actionHome, drawerTabsList,
          newTabButton, tabHeaderButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
