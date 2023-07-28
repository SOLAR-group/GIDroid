package acr.browser.lightning.preference;

import java.lang.System;

/**
 * The user's preferences.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR+\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR+\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR+\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\rR+\u0010 \u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b#\u0010\u000f\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR+\u0010$\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\u000f\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\rR+\u0010(\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b+\u0010\u000f\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\rR+\u0010,\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\u000f\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\rR+\u00100\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b3\u0010\u000f\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\rR+\u00104\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b7\u0010\u000f\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u0010\rR+\u00109\u001a\u0002082\u0006\u0010\u0007\u001a\u0002088F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b>\u0010\u000f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R+\u0010?\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bB\u0010\u000f\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\rR+\u0010C\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bF\u0010\u000f\u001a\u0004\bD\u0010\u000b\"\u0004\bE\u0010\rR+\u0010G\u001a\u0002082\u0006\u0010\u0007\u001a\u0002088F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bJ\u0010\u000f\u001a\u0004\bH\u0010;\"\u0004\bI\u0010=R/\u0010K\u001a\u0004\u0018\u0001082\b\u0010\u0007\u001a\u0004\u0018\u0001088F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bN\u0010\u000f\u001a\u0004\bL\u0010;\"\u0004\bM\u0010=R/\u0010O\u001a\u0004\u0018\u0001082\b\u0010\u0007\u001a\u0004\u0018\u0001088F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bR\u0010\u000f\u001a\u0004\bP\u0010;\"\u0004\bQ\u0010=R+\u0010T\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bY\u0010\u000f\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR+\u0010Z\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b]\u0010\u000f\u001a\u0004\b[\u0010\u000b\"\u0004\b\\\u0010\rR+\u0010^\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\ba\u0010\u000f\u001a\u0004\b_\u0010\u000b\"\u0004\b`\u0010\rR+\u0010b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\be\u0010\u000f\u001a\u0004\bc\u0010\u000b\"\u0004\bd\u0010\rR+\u0010f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bi\u0010\u000f\u001a\u0004\bg\u0010\u000b\"\u0004\bh\u0010\rR+\u0010j\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bm\u0010\u000f\u001a\u0004\bk\u0010\u000b\"\u0004\bl\u0010\rR+\u0010n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bq\u0010\u000f\u001a\u0004\bo\u0010\u000b\"\u0004\bp\u0010\rR+\u0010s\u001a\u00020r2\u0006\u0010\u0007\u001a\u00020r8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\bx\u0010\u000f\u001a\u0004\bt\u0010u\"\u0004\bv\u0010wR+\u0010y\u001a\u0002082\u0006\u0010\u0007\u001a\u0002088F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b|\u0010\u000f\u001a\u0004\bz\u0010;\"\u0004\b{\u0010=R,\u0010}\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0013\n\u0005\b\u0080\u0001\u0010\u000f\u001a\u0004\b~\u0010V\"\u0004\b\u007f\u0010XR/\u0010\u0081\u0001\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u0084\u0001\u0010\u000f\u001a\u0005\b\u0082\u0001\u0010V\"\u0005\b\u0083\u0001\u0010XR/\u0010\u0085\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u0088\u0001\u0010\u000f\u001a\u0005\b\u0086\u0001\u0010\u000b\"\u0005\b\u0087\u0001\u0010\rR3\u0010\u008a\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u0007\u001a\u00030\u0089\u00018F@FX\u0086\u008e\u0002\u00a2\u0006\u0017\n\u0005\b\u008f\u0001\u0010\u000f\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R/\u0010\u0090\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u0093\u0001\u0010\u000f\u001a\u0005\b\u0091\u0001\u0010\u000b\"\u0005\b\u0092\u0001\u0010\rR/\u0010\u0094\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u0097\u0001\u0010\u000f\u001a\u0005\b\u0095\u0001\u0010\u000b\"\u0005\b\u0096\u0001\u0010\rR/\u0010\u0098\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u009b\u0001\u0010\u000f\u001a\u0005\b\u0099\u0001\u0010\u000b\"\u0005\b\u009a\u0001\u0010\rR/\u0010\u009c\u0001\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u009f\u0001\u0010\u000f\u001a\u0005\b\u009d\u0001\u0010V\"\u0005\b\u009e\u0001\u0010XR/\u0010\u00a0\u0001\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00a3\u0001\u0010\u000f\u001a\u0005\b\u00a1\u0001\u0010V\"\u0005\b\u00a2\u0001\u0010XR/\u0010\u00a4\u0001\u001a\u0002082\u0006\u0010\u0007\u001a\u0002088F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00a7\u0001\u0010\u000f\u001a\u0005\b\u00a5\u0001\u0010;\"\u0005\b\u00a6\u0001\u0010=R/\u0010\u00a8\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00ab\u0001\u0010\u000f\u001a\u0005\b\u00a9\u0001\u0010\u000b\"\u0005\b\u00aa\u0001\u0010\rR/\u0010\u00ac\u0001\u001a\u0002082\u0006\u0010\u0007\u001a\u0002088F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00af\u0001\u0010\u000f\u001a\u0005\b\u00ad\u0001\u0010;\"\u0005\b\u00ae\u0001\u0010=R/\u0010\u00b0\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00b3\u0001\u0010\u000f\u001a\u0005\b\u00b1\u0001\u0010\u000b\"\u0005\b\u00b2\u0001\u0010\rR/\u0010\u00b4\u0001\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00b7\u0001\u0010\u000f\u001a\u0005\b\u00b5\u0001\u0010V\"\u0005\b\u00b6\u0001\u0010XR3\u0010\u00b9\u0001\u001a\u00030\u00b8\u00012\u0007\u0010\u0007\u001a\u00030\u00b8\u00018F@FX\u0086\u008e\u0002\u00a2\u0006\u0017\n\u0005\b\u00be\u0001\u0010\u000f\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R/\u0010\u00bf\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00c2\u0001\u0010\u000f\u001a\u0005\b\u00c0\u0001\u0010\u000b\"\u0005\b\u00c1\u0001\u0010\rR3\u0010\u00c4\u0001\u001a\u00030\u00c3\u00012\u0007\u0010\u0007\u001a\u00030\u00c3\u00018F@FX\u0086\u008e\u0002\u00a2\u0006\u0017\n\u0005\b\u00c9\u0001\u0010\u000f\u001a\u0006\b\u00c5\u0001\u0010\u00c6\u0001\"\u0006\b\u00c7\u0001\u0010\u00c8\u0001R/\u0010\u00ca\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00cd\u0001\u0010\u000f\u001a\u0005\b\u00cb\u0001\u0010\u000b\"\u0005\b\u00cc\u0001\u0010\rR/\u0010\u00ce\u0001\u001a\u00020S2\u0006\u0010\u0007\u001a\u00020S8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00d1\u0001\u0010\u000f\u001a\u0005\b\u00cf\u0001\u0010V\"\u0005\b\u00d0\u0001\u0010XR/\u0010\u00d2\u0001\u001a\u0002082\u0006\u0010\u0007\u001a\u0002088F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00d5\u0001\u0010\u000f\u001a\u0005\b\u00d3\u0001\u0010;\"\u0005\b\u00d4\u0001\u0010=R/\u0010\u00d6\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\n\u0005\b\u00d9\u0001\u0010\u000f\u001a\u0005\b\u00d7\u0001\u0010\u000b\"\u0005\b\u00d8\u0001\u0010\r\u00a8\u0006\u00da\u0001"}, d2 = {"Lacr/browser/lightning/preference/UserPreferences;", "", "preferences", "Landroid/content/SharedPreferences;", "screenSize", "Lacr/browser/lightning/device/ScreenSize;", "(Landroid/content/SharedPreferences;Lacr/browser/lightning/device/ScreenSize;)V", "<set-?>", "", "adBlockEnabled", "getAdBlockEnabled", "()Z", "setAdBlockEnabled", "(Z)V", "adBlockEnabled$delegate", "Lkotlin/properties/ReadWriteProperty;", "blockImagesEnabled", "getBlockImagesEnabled", "setBlockImagesEnabled", "blockImagesEnabled$delegate", "blockThirdPartyCookiesEnabled", "getBlockThirdPartyCookiesEnabled", "setBlockThirdPartyCookiesEnabled", "blockThirdPartyCookiesEnabled$delegate", "bookmarksAndTabsSwapped", "getBookmarksAndTabsSwapped", "setBookmarksAndTabsSwapped", "bookmarksAndTabsSwapped$delegate", "clearCacheExit", "getClearCacheExit", "setClearCacheExit", "clearCacheExit$delegate", "clearCookiesExitEnabled", "getClearCookiesExitEnabled", "setClearCookiesExitEnabled", "clearCookiesExitEnabled$delegate", "clearHistoryExitEnabled", "getClearHistoryExitEnabled", "setClearHistoryExitEnabled", "clearHistoryExitEnabled$delegate", "clearWebStorageExitEnabled", "getClearWebStorageExitEnabled", "setClearWebStorageExitEnabled", "clearWebStorageExitEnabled$delegate", "colorModeEnabled", "getColorModeEnabled", "setColorModeEnabled", "colorModeEnabled$delegate", "cookiesEnabled", "getCookiesEnabled", "setCookiesEnabled", "cookiesEnabled$delegate", "doNotTrackEnabled", "getDoNotTrackEnabled", "setDoNotTrackEnabled", "doNotTrackEnabled$delegate", "", "downloadDirectory", "getDownloadDirectory", "()Ljava/lang/String;", "setDownloadDirectory", "(Ljava/lang/String;)V", "downloadDirectory$delegate", "fullScreenEnabled", "getFullScreenEnabled", "setFullScreenEnabled", "fullScreenEnabled$delegate", "hideStatusBarEnabled", "getHideStatusBarEnabled", "setHideStatusBarEnabled", "hideStatusBarEnabled$delegate", "homepage", "getHomepage", "setHomepage", "homepage$delegate", "hostsLocalFile", "getHostsLocalFile", "setHostsLocalFile", "hostsLocalFile$delegate", "hostsRemoteFile", "getHostsRemoteFile", "setHostsRemoteFile", "hostsRemoteFile$delegate", "", "hostsSource", "getHostsSource", "()I", "setHostsSource", "(I)V", "hostsSource$delegate", "incognitoCookiesEnabled", "getIncognitoCookiesEnabled", "setIncognitoCookiesEnabled", "incognitoCookiesEnabled$delegate", "invertColors", "getInvertColors", "setInvertColors", "invertColors$delegate", "javaScriptEnabled", "getJavaScriptEnabled", "setJavaScriptEnabled", "javaScriptEnabled$delegate", "locationEnabled", "getLocationEnabled", "setLocationEnabled", "locationEnabled$delegate", "overviewModeEnabled", "getOverviewModeEnabled", "setOverviewModeEnabled", "overviewModeEnabled$delegate", "popupsEnabled", "getPopupsEnabled", "setPopupsEnabled", "popupsEnabled$delegate", "Lacr/browser/lightning/browser/proxy/ProxyChoice;", "proxyChoice", "getProxyChoice", "()Lacr/browser/lightning/browser/proxy/ProxyChoice;", "setProxyChoice", "(Lacr/browser/lightning/browser/proxy/ProxyChoice;)V", "proxyChoice$delegate", "proxyHost", "getProxyHost", "setProxyHost", "proxyHost$delegate", "proxyPort", "getProxyPort", "setProxyPort", "proxyPort$delegate", "readingTextSize", "getReadingTextSize", "setReadingTextSize", "readingTextSize$delegate", "removeIdentifyingHeadersEnabled", "getRemoveIdentifyingHeadersEnabled", "setRemoveIdentifyingHeadersEnabled", "removeIdentifyingHeadersEnabled$delegate", "Lacr/browser/lightning/browser/view/RenderingMode;", "renderingMode", "getRenderingMode", "()Lacr/browser/lightning/browser/view/RenderingMode;", "setRenderingMode", "(Lacr/browser/lightning/browser/view/RenderingMode;)V", "renderingMode$delegate", "restoreLostTabsEnabled", "getRestoreLostTabsEnabled", "setRestoreLostTabsEnabled", "restoreLostTabsEnabled$delegate", "saveDataEnabled", "getSaveDataEnabled", "setSaveDataEnabled", "saveDataEnabled$delegate", "savePasswordsEnabled", "getSavePasswordsEnabled", "setSavePasswordsEnabled", "savePasswordsEnabled$delegate", "searchChoice", "getSearchChoice", "setSearchChoice", "searchChoice$delegate", "searchSuggestionChoice", "getSearchSuggestionChoice", "setSearchSuggestionChoice", "searchSuggestionChoice$delegate", "searchUrl", "getSearchUrl", "setSearchUrl", "searchUrl$delegate", "showTabsInDrawer", "getShowTabsInDrawer", "setShowTabsInDrawer", "showTabsInDrawer$delegate", "textEncoding", "getTextEncoding", "setTextEncoding", "textEncoding$delegate", "textReflowEnabled", "getTextReflowEnabled", "setTextReflowEnabled", "textReflowEnabled$delegate", "textSize", "getTextSize", "setTextSize", "textSize$delegate", "Lacr/browser/lightning/browser/search/SearchBoxDisplayChoice;", "urlBoxContentChoice", "getUrlBoxContentChoice", "()Lacr/browser/lightning/browser/search/SearchBoxDisplayChoice;", "setUrlBoxContentChoice", "(Lacr/browser/lightning/browser/search/SearchBoxDisplayChoice;)V", "urlBoxContentChoice$delegate", "useBlackStatusBar", "getUseBlackStatusBar", "setUseBlackStatusBar", "useBlackStatusBar$delegate", "Lacr/browser/lightning/AppTheme;", "useTheme", "getUseTheme", "()Lacr/browser/lightning/AppTheme;", "setUseTheme", "(Lacr/browser/lightning/AppTheme;)V", "useTheme$delegate", "useWideViewPortEnabled", "getUseWideViewPortEnabled", "setUseWideViewPortEnabled", "useWideViewPortEnabled$delegate", "userAgentChoice", "getUserAgentChoice", "setUserAgentChoice", "userAgentChoice$delegate", "userAgentString", "getUserAgentString", "setUserAgentString", "userAgentString$delegate", "webRtcEnabled", "getWebRtcEnabled", "setWebRtcEnabled", "webRtcEnabled$delegate", "app_lightningLiteDebug"})
@javax.inject.Singleton()
public final class UserPreferences {
    
    /**
     * True if Web RTC is enabled in the browser, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty webRtcEnabled$delegate = null;
    
    /**
     * True if the browser should block ads, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty adBlockEnabled$delegate = null;
    
    /**
     * True if the browser should block images from being loaded, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty blockImagesEnabled$delegate = null;
    
    /**
     * True if the browser should clear the browser cache when the app is exited, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty clearCacheExit$delegate = null;
    
    /**
     * True if the browser should allow websites to store and access cookies, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty cookiesEnabled$delegate = null;
    
    /**
     * The folder into which files will be downloaded.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty downloadDirectory$delegate = null;
    
    /**
     * True if the browser should hide the navigation bar when scrolling, false if it should be
     * immobile.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty fullScreenEnabled$delegate = null;
    
    /**
     * True if the system status bar should be hidden throughout the app, false if it should be
     * visible.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty hideStatusBarEnabled$delegate = null;
    
    /**
     * The URL of the selected homepage.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty homepage$delegate = null;
    
    /**
     * True if cookies should be enabled in incognito mode, false otherwise.
     *
     * WARNING: Cookies will be shared between regular and incognito modes if this is enabled.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty incognitoCookiesEnabled$delegate = null;
    
    /**
     * True if the browser should allow execution of javascript, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty javaScriptEnabled$delegate = null;
    
    /**
     * True if the device location should be accessible by websites, false otherwise.
     *
     * NOTE: If this is enabled, permission will still need to be granted on a per-site basis.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty locationEnabled$delegate = null;
    
    /**
     * True if the browser should load pages zoomed out instead of zoomed in so that the text is
     * legible, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty overviewModeEnabled$delegate = null;
    
    /**
     * True if the browser should allow websites to open new windows, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty popupsEnabled$delegate = null;
    
    /**
     * True if the app should remember which browser tabs were open and restore them if the browser
     * is automatically closed by the system.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty restoreLostTabsEnabled$delegate = null;
    
    /**
     * True if the browser should save form input, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty savePasswordsEnabled$delegate = null;
    
    /**
     * The index of the chosen search engine.
     *
     * @see SearchEngineProvider
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty searchChoice$delegate = null;
    
    /**
     * The custom URL which should be used for making searches.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty searchUrl$delegate = null;
    
    /**
     * True if the browser should attempt to reflow the text on a web page after zooming in or out
     * of the page.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty textReflowEnabled$delegate = null;
    
    /**
     * The index of the text size that should be used in the browser.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty textSize$delegate = null;
    
    /**
     * True if the browser should fit web pages to the view port, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty useWideViewPortEnabled$delegate = null;
    
    /**
     * The index of the user agent choice that should be used by the browser.
     *
     * @see UserPreferences.userAgent
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty userAgentChoice$delegate = null;
    
    /**
     * The custom user agent that should be used by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty userAgentString$delegate = null;
    
    /**
     * True if the browser should clear the navigation history on app exit, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty clearHistoryExitEnabled$delegate = null;
    
    /**
     * True if the browser should clear the browser cookies on app exit, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty clearCookiesExitEnabled$delegate = null;
    
    /**
     * The index of the rendering mode that should be used by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty renderingMode$delegate = null;
    
    /**
     * True if third party cookies should be disallowed by the browser, false if they should be
     * allowed.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty blockThirdPartyCookiesEnabled$delegate = null;
    
    /**
     * True if the browser should extract the theme color from a website and color the UI with it,
     * false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty colorModeEnabled$delegate = null;
    
    /**
     * The index of the URL/search box display choice/
     *
     * @see SearchBoxModel
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty urlBoxContentChoice$delegate = null;
    
    /**
     * True if the browser should invert the display colors of the web page content, false
     * otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty invertColors$delegate = null;
    
    /**
     * The index of the reading mode text size.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty readingTextSize$delegate = null;
    
    /**
     * The index of the theme used by the application.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty useTheme$delegate = null;
    
    /**
     * The text encoding used by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty textEncoding$delegate = null;
    
    /**
     * True if the web page storage should be cleared when the app exits, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty clearWebStorageExitEnabled$delegate = null;
    
    /**
     * True if the app should use the navigation drawer UI, false if it should use the traditional
     * desktop browser tabs UI.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty showTabsInDrawer$delegate = null;
    
    /**
     * True if the browser should send a do not track (DNT) header with every GET request, false
     * otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty doNotTrackEnabled$delegate = null;
    
    /**
     * True if the browser should save form data, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty saveDataEnabled$delegate = null;
    
    /**
     * True if the browser should attempt to remove identifying headers in GET requests, false if
     * the default headers should be left along.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty removeIdentifyingHeadersEnabled$delegate = null;
    
    /**
     * True if the bookmarks tab should be on the opposite side of the screen, false otherwise. If
     * the navigation drawer UI is used, the tab drawer will be displayed on the opposite side as
     * well.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty bookmarksAndTabsSwapped$delegate = null;
    
    /**
     * True if the status bar of the app should always be high contrast, false if it should follow
     * the theme of the app.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty useBlackStatusBar$delegate = null;
    
    /**
     * The index of the proxy choice.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty proxyChoice$delegate = null;
    
    /**
     * The proxy host used when [proxyChoice] is [ProxyChoice.MANUAL].
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty proxyHost$delegate = null;
    
    /**
     * The proxy port used when [proxyChoice] is [ProxyChoice.MANUAL].
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty proxyPort$delegate = null;
    
    /**
     * The index of the search suggestion choice.
     *
     * @see SearchEngineProvider
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty searchSuggestionChoice$delegate = null;
    
    /**
     * The index of the ad blocking hosts file source.
     */
    @org.jetbrains.annotations.NotNull()
    private final kotlin.properties.ReadWriteProperty hostsSource$delegate = null;
    
    /**
     * The local file from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    @org.jetbrains.annotations.Nullable()
    private final kotlin.properties.ReadWriteProperty hostsLocalFile$delegate = null;
    
    /**
     * The remote URL from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    @org.jetbrains.annotations.Nullable()
    private final kotlin.properties.ReadWriteProperty hostsRemoteFile$delegate = null;
    
    /**
     * True if Web RTC is enabled in the browser, false otherwise.
     */
    public final boolean getWebRtcEnabled() {
        return false;
    }
    
    /**
     * True if Web RTC is enabled in the browser, false otherwise.
     */
    public final void setWebRtcEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should block ads, false otherwise.
     */
    public final boolean getAdBlockEnabled() {
        return false;
    }
    
    /**
     * True if the browser should block ads, false otherwise.
     */
    public final void setAdBlockEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should block images from being loaded, false otherwise.
     */
    public final boolean getBlockImagesEnabled() {
        return false;
    }
    
    /**
     * True if the browser should block images from being loaded, false otherwise.
     */
    public final void setBlockImagesEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should clear the browser cache when the app is exited, false otherwise.
     */
    public final boolean getClearCacheExit() {
        return false;
    }
    
    /**
     * True if the browser should clear the browser cache when the app is exited, false otherwise.
     */
    public final void setClearCacheExit(boolean p0) {
    }
    
    /**
     * True if the browser should allow websites to store and access cookies, false otherwise.
     */
    public final boolean getCookiesEnabled() {
        return false;
    }
    
    /**
     * True if the browser should allow websites to store and access cookies, false otherwise.
     */
    public final void setCookiesEnabled(boolean p0) {
    }
    
    /**
     * The folder into which files will be downloaded.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDownloadDirectory() {
        return null;
    }
    
    /**
     * The folder into which files will be downloaded.
     */
    public final void setDownloadDirectory(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * True if the browser should hide the navigation bar when scrolling, false if it should be
     * immobile.
     */
    public final boolean getFullScreenEnabled() {
        return false;
    }
    
    /**
     * True if the browser should hide the navigation bar when scrolling, false if it should be
     * immobile.
     */
    public final void setFullScreenEnabled(boolean p0) {
    }
    
    /**
     * True if the system status bar should be hidden throughout the app, false if it should be
     * visible.
     */
    public final boolean getHideStatusBarEnabled() {
        return false;
    }
    
    /**
     * True if the system status bar should be hidden throughout the app, false if it should be
     * visible.
     */
    public final void setHideStatusBarEnabled(boolean p0) {
    }
    
    /**
     * The URL of the selected homepage.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHomepage() {
        return null;
    }
    
    /**
     * The URL of the selected homepage.
     */
    public final void setHomepage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * True if cookies should be enabled in incognito mode, false otherwise.
     *
     * WARNING: Cookies will be shared between regular and incognito modes if this is enabled.
     */
    public final boolean getIncognitoCookiesEnabled() {
        return false;
    }
    
    /**
     * True if cookies should be enabled in incognito mode, false otherwise.
     *
     * WARNING: Cookies will be shared between regular and incognito modes if this is enabled.
     */
    public final void setIncognitoCookiesEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should allow execution of javascript, false otherwise.
     */
    public final boolean getJavaScriptEnabled() {
        return false;
    }
    
    /**
     * True if the browser should allow execution of javascript, false otherwise.
     */
    public final void setJavaScriptEnabled(boolean p0) {
    }
    
    /**
     * True if the device location should be accessible by websites, false otherwise.
     *
     * NOTE: If this is enabled, permission will still need to be granted on a per-site basis.
     */
    public final boolean getLocationEnabled() {
        return false;
    }
    
    /**
     * True if the device location should be accessible by websites, false otherwise.
     *
     * NOTE: If this is enabled, permission will still need to be granted on a per-site basis.
     */
    public final void setLocationEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should load pages zoomed out instead of zoomed in so that the text is
     * legible, false otherwise.
     */
    public final boolean getOverviewModeEnabled() {
        return false;
    }
    
    /**
     * True if the browser should load pages zoomed out instead of zoomed in so that the text is
     * legible, false otherwise.
     */
    public final void setOverviewModeEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should allow websites to open new windows, false otherwise.
     */
    public final boolean getPopupsEnabled() {
        return false;
    }
    
    /**
     * True if the browser should allow websites to open new windows, false otherwise.
     */
    public final void setPopupsEnabled(boolean p0) {
    }
    
    /**
     * True if the app should remember which browser tabs were open and restore them if the browser
     * is automatically closed by the system.
     */
    public final boolean getRestoreLostTabsEnabled() {
        return false;
    }
    
    /**
     * True if the app should remember which browser tabs were open and restore them if the browser
     * is automatically closed by the system.
     */
    public final void setRestoreLostTabsEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should save form input, false otherwise.
     */
    public final boolean getSavePasswordsEnabled() {
        return false;
    }
    
    /**
     * True if the browser should save form input, false otherwise.
     */
    public final void setSavePasswordsEnabled(boolean p0) {
    }
    
    /**
     * The index of the chosen search engine.
     *
     * @see SearchEngineProvider
     */
    public final int getSearchChoice() {
        return 0;
    }
    
    /**
     * The index of the chosen search engine.
     *
     * @see SearchEngineProvider
     */
    public final void setSearchChoice(int p0) {
    }
    
    /**
     * The custom URL which should be used for making searches.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSearchUrl() {
        return null;
    }
    
    /**
     * The custom URL which should be used for making searches.
     */
    public final void setSearchUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * True if the browser should attempt to reflow the text on a web page after zooming in or out
     * of the page.
     */
    public final boolean getTextReflowEnabled() {
        return false;
    }
    
    /**
     * True if the browser should attempt to reflow the text on a web page after zooming in or out
     * of the page.
     */
    public final void setTextReflowEnabled(boolean p0) {
    }
    
    /**
     * The index of the text size that should be used in the browser.
     */
    public final int getTextSize() {
        return 0;
    }
    
    /**
     * The index of the text size that should be used in the browser.
     */
    public final void setTextSize(int p0) {
    }
    
    /**
     * True if the browser should fit web pages to the view port, false otherwise.
     */
    public final boolean getUseWideViewPortEnabled() {
        return false;
    }
    
    /**
     * True if the browser should fit web pages to the view port, false otherwise.
     */
    public final void setUseWideViewPortEnabled(boolean p0) {
    }
    
    /**
     * The index of the user agent choice that should be used by the browser.
     *
     * @see UserPreferences.userAgent
     */
    public final int getUserAgentChoice() {
        return 0;
    }
    
    /**
     * The index of the user agent choice that should be used by the browser.
     *
     * @see UserPreferences.userAgent
     */
    public final void setUserAgentChoice(int p0) {
    }
    
    /**
     * The custom user agent that should be used by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserAgentString() {
        return null;
    }
    
    /**
     * The custom user agent that should be used by the browser.
     */
    public final void setUserAgentString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * True if the browser should clear the navigation history on app exit, false otherwise.
     */
    public final boolean getClearHistoryExitEnabled() {
        return false;
    }
    
    /**
     * True if the browser should clear the navigation history on app exit, false otherwise.
     */
    public final void setClearHistoryExitEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should clear the browser cookies on app exit, false otherwise.
     */
    public final boolean getClearCookiesExitEnabled() {
        return false;
    }
    
    /**
     * True if the browser should clear the browser cookies on app exit, false otherwise.
     */
    public final void setClearCookiesExitEnabled(boolean p0) {
    }
    
    /**
     * The index of the rendering mode that should be used by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.view.RenderingMode getRenderingMode() {
        return null;
    }
    
    /**
     * The index of the rendering mode that should be used by the browser.
     */
    public final void setRenderingMode(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.RenderingMode p0) {
    }
    
    /**
     * True if third party cookies should be disallowed by the browser, false if they should be
     * allowed.
     */
    public final boolean getBlockThirdPartyCookiesEnabled() {
        return false;
    }
    
    /**
     * True if third party cookies should be disallowed by the browser, false if they should be
     * allowed.
     */
    public final void setBlockThirdPartyCookiesEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should extract the theme color from a website and color the UI with it,
     * false otherwise.
     */
    public final boolean getColorModeEnabled() {
        return false;
    }
    
    /**
     * True if the browser should extract the theme color from a website and color the UI with it,
     * false otherwise.
     */
    public final void setColorModeEnabled(boolean p0) {
    }
    
    /**
     * The index of the URL/search box display choice/
     *
     * @see SearchBoxModel
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.search.SearchBoxDisplayChoice getUrlBoxContentChoice() {
        return null;
    }
    
    /**
     * The index of the URL/search box display choice/
     *
     * @see SearchBoxModel
     */
    public final void setUrlBoxContentChoice(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.search.SearchBoxDisplayChoice p0) {
    }
    
    /**
     * True if the browser should invert the display colors of the web page content, false
     * otherwise.
     */
    public final boolean getInvertColors() {
        return false;
    }
    
    /**
     * True if the browser should invert the display colors of the web page content, false
     * otherwise.
     */
    public final void setInvertColors(boolean p0) {
    }
    
    /**
     * The index of the reading mode text size.
     */
    public final int getReadingTextSize() {
        return 0;
    }
    
    /**
     * The index of the reading mode text size.
     */
    public final void setReadingTextSize(int p0) {
    }
    
    /**
     * The index of the theme used by the application.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.AppTheme getUseTheme() {
        return null;
    }
    
    /**
     * The index of the theme used by the application.
     */
    public final void setUseTheme(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.AppTheme p0) {
    }
    
    /**
     * The text encoding used by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTextEncoding() {
        return null;
    }
    
    /**
     * The text encoding used by the browser.
     */
    public final void setTextEncoding(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * True if the web page storage should be cleared when the app exits, false otherwise.
     */
    public final boolean getClearWebStorageExitEnabled() {
        return false;
    }
    
    /**
     * True if the web page storage should be cleared when the app exits, false otherwise.
     */
    public final void setClearWebStorageExitEnabled(boolean p0) {
    }
    
    /**
     * True if the app should use the navigation drawer UI, false if it should use the traditional
     * desktop browser tabs UI.
     */
    public final boolean getShowTabsInDrawer() {
        return false;
    }
    
    /**
     * True if the app should use the navigation drawer UI, false if it should use the traditional
     * desktop browser tabs UI.
     */
    public final void setShowTabsInDrawer(boolean p0) {
    }
    
    /**
     * True if the browser should send a do not track (DNT) header with every GET request, false
     * otherwise.
     */
    public final boolean getDoNotTrackEnabled() {
        return false;
    }
    
    /**
     * True if the browser should send a do not track (DNT) header with every GET request, false
     * otherwise.
     */
    public final void setDoNotTrackEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should save form data, false otherwise.
     */
    public final boolean getSaveDataEnabled() {
        return false;
    }
    
    /**
     * True if the browser should save form data, false otherwise.
     */
    public final void setSaveDataEnabled(boolean p0) {
    }
    
    /**
     * True if the browser should attempt to remove identifying headers in GET requests, false if
     * the default headers should be left along.
     */
    public final boolean getRemoveIdentifyingHeadersEnabled() {
        return false;
    }
    
    /**
     * True if the browser should attempt to remove identifying headers in GET requests, false if
     * the default headers should be left along.
     */
    public final void setRemoveIdentifyingHeadersEnabled(boolean p0) {
    }
    
    /**
     * True if the bookmarks tab should be on the opposite side of the screen, false otherwise. If
     * the navigation drawer UI is used, the tab drawer will be displayed on the opposite side as
     * well.
     */
    public final boolean getBookmarksAndTabsSwapped() {
        return false;
    }
    
    /**
     * True if the bookmarks tab should be on the opposite side of the screen, false otherwise. If
     * the navigation drawer UI is used, the tab drawer will be displayed on the opposite side as
     * well.
     */
    public final void setBookmarksAndTabsSwapped(boolean p0) {
    }
    
    /**
     * True if the status bar of the app should always be high contrast, false if it should follow
     * the theme of the app.
     */
    public final boolean getUseBlackStatusBar() {
        return false;
    }
    
    /**
     * True if the status bar of the app should always be high contrast, false if it should follow
     * the theme of the app.
     */
    public final void setUseBlackStatusBar(boolean p0) {
    }
    
    /**
     * The index of the proxy choice.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.proxy.ProxyChoice getProxyChoice() {
        return null;
    }
    
    /**
     * The index of the proxy choice.
     */
    public final void setProxyChoice(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.proxy.ProxyChoice p0) {
    }
    
    /**
     * The proxy host used when [proxyChoice] is [ProxyChoice.MANUAL].
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getProxyHost() {
        return null;
    }
    
    /**
     * The proxy host used when [proxyChoice] is [ProxyChoice.MANUAL].
     */
    public final void setProxyHost(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    /**
     * The proxy port used when [proxyChoice] is [ProxyChoice.MANUAL].
     */
    public final int getProxyPort() {
        return 0;
    }
    
    /**
     * The proxy port used when [proxyChoice] is [ProxyChoice.MANUAL].
     */
    public final void setProxyPort(int p0) {
    }
    
    /**
     * The index of the search suggestion choice.
     *
     * @see SearchEngineProvider
     */
    public final int getSearchSuggestionChoice() {
        return 0;
    }
    
    /**
     * The index of the search suggestion choice.
     *
     * @see SearchEngineProvider
     */
    public final void setSearchSuggestionChoice(int p0) {
    }
    
    /**
     * The index of the ad blocking hosts file source.
     */
    public final int getHostsSource() {
        return 0;
    }
    
    /**
     * The index of the ad blocking hosts file source.
     */
    public final void setHostsSource(int p0) {
    }
    
    /**
     * The local file from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHostsLocalFile() {
        return null;
    }
    
    /**
     * The local file from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    public final void setHostsLocalFile(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    /**
     * The remote URL from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getHostsRemoteFile() {
        return null;
    }
    
    /**
     * The remote URL from which ad blocking hosts should be read, depending on the [hostsSource].
     */
    public final void setHostsRemoteFile(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @javax.inject.Inject()
    public UserPreferences(@org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.UserPrefs()
    android.content.SharedPreferences preferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.device.ScreenSize screenSize) {
        super();
    }
}