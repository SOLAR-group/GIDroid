package acr.browser.lightning.browser.proxy

import acr.browser.lightning.browser.BrowserActivity
import acr.browser.lightning.utils.ProxyUtils
import android.app.Activity
import android.app.Application
import android.os.Bundle
import javax.inject.Inject
import javax.inject.Singleton

/**
 * An adapter between [ProxyUtils] and [Proxy].
 */
@Singleton
class ProxyAdapter @Inject constructor(
    private val proxyUtils: ProxyUtils
) : Proxy, Application.ActivityLifecycleCallbacks {

    private var currentActivity: Activity? = null

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        if (activity !is BrowserActivity) return
        currentActivity = activity
    }

    override fun onActivityStarted(activity: Activity) {
        if (activity !is BrowserActivity) return
        proxyUtils.onStart(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        if (activity !is BrowserActivity) return
        proxyUtils.checkForProxy(activity)
        proxyUtils.updateProxySettings(activity)
    }

    override fun onActivityPaused(activity: Activity) = Unit

    override fun onActivityStopped(activity: Activity) {
        if (activity !is BrowserActivity) return
        proxyUtils.onStop()
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) = Unit

    override fun onActivityDestroyed(activity: Activity) {
        if (activity !is BrowserActivity) return
        currentActivity = null
    }

    override fun isProxyReady(): Boolean = currentActivity?.let(proxyUtils::isProxyReady) ?: false
}
