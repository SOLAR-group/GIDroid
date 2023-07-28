package acr.browser.lightning.browser.tab;

import acr.browser.lightning.browser.view.WebViewLongPressHandler;
import acr.browser.lightning.browser.view.WebViewScrollCoordinator;
import android.widget.FrameLayout;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class TabPager_Factory implements Factory<TabPager> {
  private final Provider<FrameLayout> containerProvider;

  private final Provider<WebViewScrollCoordinator> webViewScrollCoordinatorProvider;

  private final Provider<WebViewLongPressHandler> webViewLongPressHandlerProvider;

  public TabPager_Factory(Provider<FrameLayout> containerProvider,
      Provider<WebViewScrollCoordinator> webViewScrollCoordinatorProvider,
      Provider<WebViewLongPressHandler> webViewLongPressHandlerProvider) {
    this.containerProvider = containerProvider;
    this.webViewScrollCoordinatorProvider = webViewScrollCoordinatorProvider;
    this.webViewLongPressHandlerProvider = webViewLongPressHandlerProvider;
  }

  @Override
  public TabPager get() {
    return newInstance(containerProvider.get(), webViewScrollCoordinatorProvider.get(), webViewLongPressHandlerProvider.get());
  }

  public static TabPager_Factory create(Provider<FrameLayout> containerProvider,
      Provider<WebViewScrollCoordinator> webViewScrollCoordinatorProvider,
      Provider<WebViewLongPressHandler> webViewLongPressHandlerProvider) {
    return new TabPager_Factory(containerProvider, webViewScrollCoordinatorProvider, webViewLongPressHandlerProvider);
  }

  public static TabPager newInstance(FrameLayout container,
      WebViewScrollCoordinator webViewScrollCoordinator,
      WebViewLongPressHandler webViewLongPressHandler) {
    return new TabPager(container, webViewScrollCoordinator, webViewLongPressHandler);
  }
}
