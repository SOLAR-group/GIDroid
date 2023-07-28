package acr.browser.lightning.browser;

import java.lang.System;

/**
 * The monolithic (oops) presenter that governs the behavior of the browser UI and interactions by
 * the user for both default and incognito browsers. This presenter should live for the entire
 * duration of the browser activity, which itself should not be recreated during configuration
 * changes.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00da\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u00b1\u0001\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f\u0012\u0006\u0010 \u001a\u00020!\u0012\u0006\u0010\"\u001a\u00020#\u0012\u0006\u0010$\u001a\u00020%\u0012\u0006\u0010&\u001a\u00020\'\u0012\b\b\u0001\u0010(\u001a\u00020)\u00a2\u0006\u0002\u0010*J\b\u0010B\u001a\u00020CH\u0002J\"\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020)2\b\b\u0002\u0010H\u001a\u00020)H\u0002J\u0006\u0010I\u001a\u00020CJ\u000e\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020:J\u001e\u0010L\u001a\u00020C2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NJ\u000e\u0010Q\u001a\u00020C2\u0006\u0010R\u001a\u00020)J\u001e\u0010S\u001a\u00020C2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020NJ\u0016\u0010T\u001a\u00020C2\u0006\u0010U\u001a\u00020N2\u0006\u0010V\u001a\u00020NJ\u000e\u0010W\u001a\u00020C2\u0006\u0010K\u001a\u00020:J\u0006\u0010X\u001a\u00020CJ\u0016\u0010Y\u001a\u00020C2\u0006\u0010Z\u001a\u00020[2\u0006\u0010\\\u001a\u00020]J\u0016\u0010^\u001a\u00020C2\u0006\u0010_\u001a\u00020:2\u0006\u0010`\u001a\u00020aJ\u000e\u0010b\u001a\u00020C2\u0006\u0010c\u001a\u00020)J\u0016\u0010d\u001a\u00020C2\u0006\u0010e\u001a\u00020f2\u0006\u0010\\\u001a\u00020gJ\u000e\u0010h\u001a\u00020C2\u0006\u0010i\u001a\u00020jJ\u0006\u0010k\u001a\u00020CJ\u000e\u0010l\u001a\u00020C2\u0006\u0010m\u001a\u00020NJ\u0006\u0010n\u001a\u00020CJ\u0006\u0010o\u001a\u00020CJ\u0016\u0010p\u001a\u00020C2\u0006\u0010P\u001a\u00020/2\u0006\u0010\\\u001a\u00020qJ\u0006\u0010r\u001a\u00020CJ\u0016\u0010s\u001a\u00020C2\u0006\u0010t\u001a\u00020u2\u0006\u0010\\\u001a\u00020vJ\u0006\u0010w\u001a\u00020CJ\u0016\u0010x\u001a\u00020C2\u0006\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020|J\u000e\u0010}\u001a\u00020C2\u0006\u0010~\u001a\u00020\u007fJ\u0019\u0010\u0080\u0001\u001a\u00020C2\u0006\u0010y\u001a\u00020z2\b\u0010\u0081\u0001\u001a\u00030\u0082\u0001J\u0011\u0010\u0083\u0001\u001a\u00020C2\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001J\u0007\u0010\u0086\u0001\u001a\u00020CJ\u0011\u0010\u0087\u0001\u001a\u00020C2\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001J\u0007\u0010\u008a\u0001\u001a\u00020CJ\u0007\u0010\u008b\u0001\u001a\u00020CJ\u0017\u0010\u008c\u0001\u001a\u00020C2\u0006\u0010_\u001a\u00020:2\u0006\u0010y\u001a\u00020zJ\u0007\u0010\u008d\u0001\u001a\u00020CJ\u0007\u0010\u008e\u0001\u001a\u00020CJ\u000f\u0010\u008f\u0001\u001a\u00020C2\u0006\u0010m\u001a\u00020NJ\u0010\u0010\u0090\u0001\u001a\u00020C2\u0007\u0010\u0091\u0001\u001a\u00020)J\u0011\u0010\u0092\u0001\u001a\u00020C2\b\u0010\u0093\u0001\u001a\u00030\u0094\u0001J\u0007\u0010\u0095\u0001\u001a\u00020CJ\u0007\u0010\u0096\u0001\u001a\u00020CJ\u000f\u0010\u0097\u0001\u001a\u00020C2\u0006\u0010K\u001a\u00020:J\u000f\u0010\u0098\u0001\u001a\u00020C2\u0006\u0010K\u001a\u00020:J\u0007\u0010\u0099\u0001\u001a\u00020CJ\u000f\u0010\u009a\u0001\u001a\u00020C2\u0006\u0010R\u001a\u00020)J\u000f\u0010\u009b\u0001\u001a\u00020C2\u0006\u0010K\u001a\u00020:J\u0007\u0010\u009c\u0001\u001a\u00020CJ\u0007\u0010\u009d\u0001\u001a\u00020CJ\u0007\u0010\u009e\u0001\u001a\u00020CJ\u0007\u0010\u009f\u0001\u001a\u00020CJ\u000f\u0010\u00a0\u0001\u001a\u00020C2\u0006\u0010>\u001a\u00020?J\u0007\u0010\u00a1\u0001\u001a\u00020CJ\u0007\u0010\u00a2\u0001\u001a\u00020CJ\t\u0010\u00a3\u0001\u001a\u00020CH\u0002J\t\u0010\u00a4\u0001\u001a\u00020CH\u0002J\u0014\u0010\u00a5\u0001\u001a\u00020C2\t\u0010\u00a6\u0001\u001a\u0004\u0018\u000101H\u0002J\t\u0010\u00a7\u0001\u001a\u00020CH\u0002J\r\u0010\u00a8\u0001\u001a\u00020=*\u000201H\u0002J#\u0010\u00a9\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00ab\u00010<0\u00aa\u0001*\u00020\u00072\u0006\u0010P\u001a\u00020/H\u0002J\u0013\u0010\u00ac\u0001\u001a\u00020:*\b\u0012\u0004\u0012\u00020=0<H\u0002J-\u0010\u00ad\u0001\u001a\u0005\u0018\u0001H\u00ae\u0001\"\u0005\b\u0000\u0010\u00ae\u0001*\t\u0012\u0005\u0012\u0003H\u00ae\u00010<2\u0007\u0010\u00af\u0001\u001a\u00020:H\u0002\u00a2\u0006\u0003\u0010\u00b0\u0001J\u001b\u0010\u00b1\u0001\u001a\u00020C*\b\u0012\u0004\u0012\u0002010<2\u0006\u0010-\u001a\u00020,H\u0002J#\u0010\u00b2\u0001\u001a\u00020:*\b\u0012\u0004\u0012\u00020=0<2\b\u0010_\u001a\u0004\u0018\u00010:H\u0002\u00a2\u0006\u0003\u0010\u00b3\u0001J7\u0010\u00b4\u0001\u001a\b\u0012\u0004\u0012\u00020=0<*\b\u0012\u0004\u0012\u00020=0<2\u0006\u0010_\u001a\u00020:2\u0014\u0010\u00b5\u0001\u001a\u000f\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020=0\u00b6\u0001H\u0002J\u0018\u0010\u00b7\u0001\u001a\u00020C*\u0004\u0018\u00010?2\u0007\u0010\u00b8\u0001\u001a\u00020AH\u0002J\u001e\u0010\u00b9\u0001\u001a\u00020C*\u0004\u0018\u00010?2\r\u0010\u00ba\u0001\u001a\b\u0012\u0004\u0012\u00020=0<H\u0002R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020)X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\'X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u00bb\u0001"}, d2 = {"Lacr/browser/lightning/browser/BrowserPresenter;", "", "model", "Lacr/browser/lightning/browser/BrowserContract$Model;", "navigator", "Lacr/browser/lightning/browser/BrowserContract$Navigator;", "bookmarkRepository", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "downloadsRepository", "Lacr/browser/lightning/database/downloads/DownloadsRepository;", "historyRepository", "Lacr/browser/lightning/database/history/HistoryRepository;", "diskScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "databaseScheduler", "historyRecord", "Lacr/browser/lightning/browser/history/HistoryRecord;", "bookmarkPageFactory", "Lacr/browser/lightning/html/bookmark/BookmarkPageFactory;", "homePageInitializer", "Lacr/browser/lightning/browser/tab/HomePageInitializer;", "historyPageInitializer", "Lacr/browser/lightning/browser/tab/HistoryPageInitializer;", "downloadPageInitializer", "Lacr/browser/lightning/browser/tab/DownloadPageInitializer;", "searchBoxModel", "Lacr/browser/lightning/browser/search/SearchBoxModel;", "searchEngineProvider", "Lacr/browser/lightning/search/SearchEngineProvider;", "uiConfiguration", "Lacr/browser/lightning/browser/ui/UiConfiguration;", "historyPageFactory", "Lacr/browser/lightning/html/history/HistoryPageFactory;", "allowListModel", "Lacr/browser/lightning/adblock/allowlist/AllowListModel;", "cookieAdministrator", "Lacr/browser/lightning/browser/data/CookieAdministrator;", "tabCountNotifier", "Lacr/browser/lightning/browser/notification/TabCountNotifier;", "incognitoMode", "", "(Lacr/browser/lightning/browser/BrowserContract$Model;Lacr/browser/lightning/browser/BrowserContract$Navigator;Lacr/browser/lightning/database/bookmark/BookmarkRepository;Lacr/browser/lightning/database/downloads/DownloadsRepository;Lacr/browser/lightning/database/history/HistoryRepository;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lacr/browser/lightning/browser/history/HistoryRecord;Lacr/browser/lightning/html/bookmark/BookmarkPageFactory;Lacr/browser/lightning/browser/tab/HomePageInitializer;Lacr/browser/lightning/browser/tab/HistoryPageInitializer;Lacr/browser/lightning/browser/tab/DownloadPageInitializer;Lacr/browser/lightning/browser/search/SearchBoxModel;Lacr/browser/lightning/search/SearchEngineProvider;Lacr/browser/lightning/browser/ui/UiConfiguration;Lacr/browser/lightning/html/history/HistoryPageFactory;Lacr/browser/lightning/adblock/allowlist/AllowListModel;Lacr/browser/lightning/browser/data/CookieAdministrator;Lacr/browser/lightning/browser/notification/TabCountNotifier;Z)V", "allTabsDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "currentFolder", "Lacr/browser/lightning/database/Bookmark$Folder;", "currentTab", "Lacr/browser/lightning/browser/tab/TabModel;", "isBookmarkDrawerOpen", "isCustomViewShowing", "isSearchViewFocused", "isTabDrawerOpen", "pendingAction", "Lacr/browser/lightning/browser/BrowserContract$Action$LoadUrl;", "tabDisposable", "tabIdOpenedFromAction", "", "tabListState", "", "Lacr/browser/lightning/browser/tab/TabViewState;", "view", "Lacr/browser/lightning/browser/BrowserContract$View;", "viewState", "Lacr/browser/lightning/browser/BrowserViewState;", "addToHomeScreen", "", "createNewTabAndSelect", "tabInitializer", "Lacr/browser/lightning/browser/tab/TabInitializer;", "shouldSelect", "markAsOpenedFromAction", "onBackClick", "onBookmarkClick", "index", "onBookmarkConfirmed", "title", "", "url", "folder", "onBookmarkDrawerMoved", "isOpen", "onBookmarkEditConfirmed", "onBookmarkFolderRenameConfirmed", "oldTitle", "newTitle", "onBookmarkLongClick", "onBookmarkMenuClick", "onBookmarkOptionClick", "bookmark", "Lacr/browser/lightning/database/Bookmark$Entry;", "option", "Lacr/browser/lightning/browser/BrowserContract$BookmarkOptionEvent;", "onCloseBrowserEvent", "id", "closeTabEvent", "Lacr/browser/lightning/browser/BrowserContract$CloseTabEvent;", "onConfirmOpenLocalFile", "allow", "onDownloadOptionClick", "download", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "Lacr/browser/lightning/browser/BrowserContract$DownloadOptionEvent;", "onFileChooserResult", "activityResult", "Landroidx/activity/result/ActivityResult;", "onFindDismiss", "onFindInPage", "query", "onFindNext", "onFindPrevious", "onFolderOptionClick", "Lacr/browser/lightning/browser/BrowserContract$FolderOptionEvent;", "onForwardClick", "onHistoryOptionClick", "historyEntry", "Lacr/browser/lightning/database/HistoryEntry;", "Lacr/browser/lightning/browser/BrowserContract$HistoryOptionEvent;", "onHomeClick", "onImageLongPressEvent", "longPress", "Lacr/browser/lightning/browser/view/targetUrl/LongPress;", "imageLongPressEvent", "Lacr/browser/lightning/browser/BrowserContract$ImageLongPressEvent;", "onKeyComboClick", "keyCombo", "Lacr/browser/lightning/browser/keys/KeyCombo;", "onLinkLongPressEvent", "linkLongPressEvent", "Lacr/browser/lightning/browser/BrowserContract$LinkLongPressEvent;", "onMenuClick", "menuSelection", "Lacr/browser/lightning/browser/menu/MenuSelection;", "onNavigateBack", "onNewAction", "action", "Lacr/browser/lightning/browser/BrowserContract$Action;", "onNewTabClick", "onNewTabLongClick", "onPageLongPress", "onReadingModeClick", "onRefreshOrStopClick", "onSearch", "onSearchFocusChanged", "isFocused", "onSearchSuggestionClicked", "webPage", "Lacr/browser/lightning/database/WebPage;", "onSslIconClick", "onStarClick", "onTabClick", "onTabClose", "onTabCountViewClick", "onTabDrawerMoved", "onTabLongClick", "onTabMenuClick", "onToggleAdBlocking", "onToggleDesktopAgent", "onToolsClick", "onViewAttached", "onViewDetached", "onViewHidden", "panicClean", "reload", "selectTab", "tabModel", "showAddBookmarkDialog", "asViewState", "bookmarksAndFolders", "Lio/reactivex/Single;", "Lacr/browser/lightning/database/Bookmark;", "indexOfCurrentTab", "nextSelected", "T", "removedIndex", "(Ljava/util/List;I)Ljava/lang/Object;", "subscribeToUpdates", "tabIndexForId", "(Ljava/util/List;Ljava/lang/Integer;)I", "updateId", "map", "Lkotlin/Function1;", "updateState", "state", "updateTabs", "tabs", "app_lightningPlusDebug"})
@acr.browser.lightning.browser.di.Browser2Scope()
public final class BrowserPresenter {
    private acr.browser.lightning.browser.BrowserContract.View view;
    private acr.browser.lightning.browser.BrowserViewState viewState;
    private java.util.List<acr.browser.lightning.browser.tab.TabViewState> tabListState;
    private acr.browser.lightning.browser.tab.TabModel currentTab;
    private acr.browser.lightning.database.Bookmark.Folder currentFolder;
    private boolean isTabDrawerOpen = false;
    private boolean isBookmarkDrawerOpen = false;
    private boolean isSearchViewFocused = false;
    private int tabIdOpenedFromAction = -1;
    private acr.browser.lightning.browser.BrowserContract.Action.LoadUrl pendingAction;
    private boolean isCustomViewShowing = false;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final io.reactivex.disposables.CompositeDisposable allTabsDisposable = null;
    private io.reactivex.disposables.CompositeDisposable tabDisposable;
    private final acr.browser.lightning.browser.BrowserContract.Model model = null;
    private final acr.browser.lightning.browser.BrowserContract.Navigator navigator = null;
    private final acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkRepository = null;
    private final acr.browser.lightning.database.downloads.DownloadsRepository downloadsRepository = null;
    private final acr.browser.lightning.database.history.HistoryRepository historyRepository = null;
    private final io.reactivex.Scheduler diskScheduler = null;
    private final io.reactivex.Scheduler mainScheduler = null;
    private final io.reactivex.Scheduler databaseScheduler = null;
    private final acr.browser.lightning.browser.history.HistoryRecord historyRecord = null;
    private final acr.browser.lightning.html.bookmark.BookmarkPageFactory bookmarkPageFactory = null;
    private final acr.browser.lightning.browser.tab.HomePageInitializer homePageInitializer = null;
    private final acr.browser.lightning.browser.tab.HistoryPageInitializer historyPageInitializer = null;
    private final acr.browser.lightning.browser.tab.DownloadPageInitializer downloadPageInitializer = null;
    private final acr.browser.lightning.browser.search.SearchBoxModel searchBoxModel = null;
    private final acr.browser.lightning.search.SearchEngineProvider searchEngineProvider = null;
    private final acr.browser.lightning.browser.ui.UiConfiguration uiConfiguration = null;
    private final acr.browser.lightning.html.history.HistoryPageFactory historyPageFactory = null;
    private final acr.browser.lightning.adblock.allowlist.AllowListModel allowListModel = null;
    private final acr.browser.lightning.browser.data.CookieAdministrator cookieAdministrator = null;
    private final acr.browser.lightning.browser.notification.TabCountNotifier tabCountNotifier = null;
    private final boolean incognitoMode = false;
    
    /**
     * Call when the view is attached to the presenter.
     */
    public final void onViewAttached(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.View view) {
    }
    
    /**
     * Call when the view is detached from the presenter.
     */
    public final void onViewDetached() {
    }
    
    /**
     * Call when the view is hidden (i.e. the browser is sent to the background).
     */
    public final void onViewHidden() {
    }
    
    private final acr.browser.lightning.browser.tab.TabViewState asViewState(acr.browser.lightning.browser.tab.TabModel $this$asViewState) {
        return null;
    }
    
    private final java.util.List<acr.browser.lightning.browser.tab.TabViewState> updateId(java.util.List<acr.browser.lightning.browser.tab.TabViewState> $this$updateId, int id, kotlin.jvm.functions.Function1<? super acr.browser.lightning.browser.tab.TabViewState, acr.browser.lightning.browser.tab.TabViewState> map) {
        return null;
    }
    
    private final void selectTab(acr.browser.lightning.browser.tab.TabModel tabModel) {
    }
    
    private final void subscribeToUpdates(java.util.List<? extends acr.browser.lightning.browser.tab.TabModel> $this$subscribeToUpdates, io.reactivex.disposables.CompositeDisposable compositeDisposable) {
    }
    
    /**
     * Call when a new action is triggered, such as the user opening a new URL in the browser.
     */
    public final void onNewAction(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.Action action) {
    }
    
    /**
     * Call when the user confirms that they do or do not want to allow a local file to be opened
     * in the browser. This is a security gate to prevent malicious local files from being opened
     * in the browser without the user's knowledge.
     */
    public final void onConfirmOpenLocalFile(boolean allow) {
    }
    
    private final void panicClean() {
    }
    
    /**
     * Call when the user selects an option from the menu.
     */
    public final void onMenuClick(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.menu.MenuSelection menuSelection) {
    }
    
    private final void addToHomeScreen() {
    }
    
    private final void createNewTabAndSelect(acr.browser.lightning.browser.tab.TabInitializer tabInitializer, boolean shouldSelect, boolean markAsOpenedFromAction) {
    }
    
    private final int tabIndexForId(java.util.List<acr.browser.lightning.browser.tab.TabViewState> $this$tabIndexForId, java.lang.Integer id) {
        return 0;
    }
    
    private final int indexOfCurrentTab(java.util.List<acr.browser.lightning.browser.tab.TabViewState> $this$indexOfCurrentTab) {
        return 0;
    }
    
    /**
     * Call when the user selects a combination of keys to perform a shortcut.
     */
    public final void onKeyComboClick(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.keys.KeyCombo keyCombo) {
    }
    
    /**
     * Call when the user selects a tab to switch to at the provided [index].
     */
    public final void onTabClick(int index) {
    }
    
    /**
     * Call when the user long presses on a tab at the provided [index].
     */
    public final void onTabLongClick(int index) {
    }
    
    private final <T extends java.lang.Object>T nextSelected(java.util.List<? extends T> $this$nextSelected, int removedIndex) {
        return null;
    }
    
    /**
     * Call when the user clicks on the close button for the tab at the provided [index]
     */
    public final void onTabClose(int index) {
    }
    
    /**
     * Call when the tab drawer is opened or closed.
     *
     * @param isOpen True if the drawer is now open, false if it is now closed.
     */
    public final void onTabDrawerMoved(boolean isOpen) {
    }
    
    /**
     * Call when the bookmark drawer is opened or closed.
     *
     * @param isOpen True if the drawer is now open, false if it is now closed.
     */
    public final void onBookmarkDrawerMoved(boolean isOpen) {
    }
    
    /**
     * Called when the user clicks on the device back button or swipes to go back. Differentiated
     * from [onBackClick] which is called when the user presses the browser's back button.
     */
    public final void onNavigateBack() {
    }
    
    /**
     * Called when the user presses the browser's back button.
     */
    public final void onBackClick() {
    }
    
    /**
     * Called when the user presses the browser's forward button.
     */
    public final void onForwardClick() {
    }
    
    /**
     * Call when the user clicks on the home button.
     */
    public final void onHomeClick() {
    }
    
    /**
     * Call when the user clicks on the open new tab button.
     */
    public final void onNewTabClick() {
    }
    
    /**
     * Call when the user long clicks on the new tab button, indicating that they want to re-open
     * the last closed tab.
     */
    public final void onNewTabLongClick() {
    }
    
    /**
     * Call when the user clicks on the refresh (or stop/delete) button that is located in the
     * search bar.
     */
    public final void onRefreshOrStopClick() {
    }
    
    private final void reload() {
    }
    
    /**
     * Call when the focus state changes for the search bar.
     *
     * @param isFocused True if the view is now focused, false otherwise.
     */
    public final void onSearchFocusChanged(boolean isFocused) {
    }
    
    /**
     * Call when the user submits a search [query] to the search bar. At this point the user has
     * provided intent to search and is no longer trying to manipulate the query.
     */
    public final void onSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    /**
     * Call when the user enters a [query] to look for in the current web page.
     */
    public final void onFindInPage(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    /**
     * Call when the user selects to move to the next highlighted word in the web page.
     */
    public final void onFindNext() {
    }
    
    /**
     * Call when the user selects to move to the previous highlighted word in the web page.
     */
    public final void onFindPrevious() {
    }
    
    /**
     * Call when the user chooses to dismiss the find in page UI component.
     */
    public final void onFindDismiss() {
    }
    
    /**
     * Call when the user selects a search suggestion that was suggested by the search box.
     */
    public final void onSearchSuggestionClicked(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.WebPage webPage) {
    }
    
    /**
     * Call when the user clicks on the SSL icon in the search box.
     */
    public final void onSslIconClick() {
    }
    
    /**
     * Call when the user clicks on a bookmark from the bookmark list at the provided [index].
     */
    public final void onBookmarkClick(int index) {
    }
    
    private final io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark>> bookmarksAndFolders(acr.browser.lightning.database.bookmark.BookmarkRepository $this$bookmarksAndFolders, acr.browser.lightning.database.Bookmark.Folder folder) {
        return null;
    }
    
    /**
     * Call when the user long presses on a bookmark in the bookmark list at the provided [index].
     */
    public final void onBookmarkLongClick(int index) {
    }
    
    /**
     * Call when the user clicks on the page tools button.
     */
    public final void onToolsClick() {
    }
    
    /**
     * Call when the user chooses to toggle the desktop user agent on/off.
     */
    public final void onToggleDesktopAgent() {
    }
    
    /**
     * Call when the user chooses to toggle ad blocking on/off for the current web page.
     */
    public final void onToggleAdBlocking() {
    }
    
    /**
     * Call when the user clicks on the star icon to add a bookmark for the current page or remove
     * the existing one.
     */
    public final void onStarClick() {
    }
    
    private final void showAddBookmarkDialog() {
    }
    
    /**
     * Call when the user confirms the details for adding a bookmark.
     *
     * @param title The title of the bookmark.
     * @param url The URL of the bookmark.
     * @param folder The name of the folder the bookmark is in.
     */
    public final void onBookmarkConfirmed(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String folder) {
    }
    
    /**
     * Call when the user confirms the details when editing a bookmark.
     *
     * @param title The title of the bookmark.
     * @param url The URL of the bookmark.
     * @param folder The name of the folder the bookmark is in.
     */
    public final void onBookmarkEditConfirmed(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String folder) {
    }
    
    /**
     * Call when the user confirms a name change to an existing folder.
     *
     * @param oldTitle The previous title of the folder.
     * @param newTitle The new title of the folder.
     */
    public final void onBookmarkFolderRenameConfirmed(@org.jetbrains.annotations.NotNull()
    java.lang.String oldTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String newTitle) {
    }
    
    /**
     * Call when the user clicks on a menu [option] for the provided [bookmark].
     */
    public final void onBookmarkOptionClick(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry bookmark, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.BookmarkOptionEvent option) {
    }
    
    /**
     * Call when the user clicks on a menu [option] for the provided [folder].
     */
    public final void onFolderOptionClick(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Folder folder, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.FolderOptionEvent option) {
    }
    
    /**
     * Call when the user clicks on a menu [option] for the provided [download] entry.
     */
    public final void onDownloadOptionClick(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadEntry download, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.DownloadOptionEvent option) {
    }
    
    /**
     * Call when the user clicks on a menu [option] for the provided [historyEntry].
     */
    public final void onHistoryOptionClick(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.HistoryEntry historyEntry, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.HistoryOptionEvent option) {
    }
    
    /**
     * Call when the user clicks on the button to open reading mode..
     */
    public final void onReadingModeClick() {
    }
    
    /**
     * Call when the user clicks on the tab count button (or home button in desktop mode, or
     * incognito icon in incognito mode).
     */
    public final void onTabCountViewClick() {
    }
    
    /**
     * Call when the user clicks on the tab menu located in the tab drawer.
     */
    public final void onTabMenuClick() {
    }
    
    /**
     * Call when the user clicks on the bookmark menu (star or back arrow) located in the bookmark
     * drawer.
     */
    public final void onBookmarkMenuClick() {
    }
    
    /**
     * Call when the user long presses anywhere on the web page with the provided tab [id].
     */
    public final void onPageLongPress(int id, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress) {
    }
    
    /**
     * Call when the user selects an option from the close browser menu that can be invoked by long
     * pressing on individual tabs.
     */
    public final void onCloseBrowserEvent(int id, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.CloseTabEvent closeTabEvent) {
    }
    
    /**
     * Call when the user long presses on a link within the web page and selects what they want to
     * do with that link.
     */
    public final void onLinkLongPressEvent(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.LinkLongPressEvent linkLongPressEvent) {
    }
    
    /**
     * Call when the user long presses on an image within the web page and selects what they want to
     * do with that image.
     */
    public final void onImageLongPressEvent(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.ImageLongPressEvent imageLongPressEvent) {
    }
    
    /**
     * Call when the user has selected a file from the file chooser to upload.
     */
    public final void onFileChooserResult(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResult activityResult) {
    }
    
    private final void updateState(acr.browser.lightning.browser.BrowserContract.View $this$updateState, acr.browser.lightning.browser.BrowserViewState state) {
    }
    
    private final void updateTabs(acr.browser.lightning.browser.BrowserContract.View $this$updateTabs, java.util.List<acr.browser.lightning.browser.tab.TabViewState> tabs) {
    }
    
    @javax.inject.Inject()
    public BrowserPresenter(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.Model model, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserContract.Navigator navigator, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkRepository, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadsRepository downloadsRepository, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryRepository historyRepository, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.MainScheduler()
    io.reactivex.Scheduler mainScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler databaseScheduler, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.history.HistoryRecord historyRecord, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.bookmark.BookmarkPageFactory bookmarkPageFactory, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.HomePageInitializer homePageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.HistoryPageInitializer historyPageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.DownloadPageInitializer downloadPageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.search.SearchBoxModel searchBoxModel, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.SearchEngineProvider searchEngineProvider, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.ui.UiConfiguration uiConfiguration, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.history.HistoryPageFactory historyPageFactory, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.allowlist.AllowListModel allowListModel, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.data.CookieAdministrator cookieAdministrator, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.notification.TabCountNotifier tabCountNotifier, @acr.browser.lightning.browser.di.IncognitoMode()
    boolean incognitoMode) {
        super();
    }
}