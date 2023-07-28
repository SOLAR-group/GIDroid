package acr.browser.lightning.browser.notification;

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
public final class IncognitoTabCountNotifier_Factory implements Factory<IncognitoTabCountNotifier> {
  private final Provider<IncognitoNotification> incognitoNotificationProvider;

  public IncognitoTabCountNotifier_Factory(
      Provider<IncognitoNotification> incognitoNotificationProvider) {
    this.incognitoNotificationProvider = incognitoNotificationProvider;
  }

  @Override
  public IncognitoTabCountNotifier get() {
    return newInstance(incognitoNotificationProvider.get());
  }

  public static IncognitoTabCountNotifier_Factory create(
      Provider<IncognitoNotification> incognitoNotificationProvider) {
    return new IncognitoTabCountNotifier_Factory(incognitoNotificationProvider);
  }

  public static IncognitoTabCountNotifier newInstance(IncognitoNotification incognitoNotification) {
    return new IncognitoTabCountNotifier(incognitoNotification);
  }
}
