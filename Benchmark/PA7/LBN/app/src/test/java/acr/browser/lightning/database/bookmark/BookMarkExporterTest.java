package acr.browser.lightning.database.bookmark;


import static org.awaitility.Awaitility.await;

import static acr.browser.lightning.database.DatabaseDelegateKt.databaseDelegate;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.util.Log;


import androidx.annotation.NonNull;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.rule.GrantPermissionRule;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.util.Scheduler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.TimeUnit;


import acr.browser.lightning.browser.di.MainScheduler;
import acr.browser.lightning.database.Bookmark;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


@RunWith(RobolectricTestRunner.class)
public class BookMarkExporterTest {


    @Rule
    public GrantPermissionRule mRuntimePermissionRule = GrantPermissionRule.grant(Manifest.permission.READ_EXTERNAL_STORAGE);
    public GrantPermissionRule mRuntimePermissionRule1 = GrantPermissionRule.grant(Manifest.permission.WRITE_EXTERNAL_STORAGE);


    @Before
    public void setUp() throws InterruptedException {
        Thread.sleep(1000);
    }



    @Test
    public void importBookmarksFromAssets() {
        List<Bookmark.Entry> items = BookmarkExporter.importBookmarksFromAssets(ApplicationProvider.getApplicationContext());
        assert items.size() == 6;
        for (Bookmark.Entry item : items) {
            switch (item.getTitle()) {
                case "Google":
                    assert item.getUrl().equals("https://www.google.com/");
                    break;
                case "Facebook":
                    assert item.getUrl().equals("https://www.facebook.com/");
                    break;
                case "Twitter":
                    assert item.getUrl().equals("https://twitter.com/");
                    break;
                case "Wikipedia":
                    assert item.getUrl().equals("https://www.wikipedia.org/");
                    break;
                case "Contact Me":
                    assert item.getUrl().equals("https://twitter.com/RestainoAnthony");
                    break;
                default:
                    break;

            }
        }
        return;
    }

    @Test
    public void exportBookmarksToFile() throws Exception {
        createAndCheck();
        createAndCheck();

    }

    public void createAndCheck() throws Exception {
        final boolean[] read = {false, false};
        File file  = BookmarkExporter.createNewExportFile();
        file.createNewFile();
        List<Bookmark.Entry> bookmarks = BookmarkExporter.importBookmarksFromAssets(ApplicationProvider.getApplicationContext());
        BookmarkExporter.exportBookmarksToFile(bookmarks, file).subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        read[0] = true;
                    }

                    @Override
                    public void onError(Throwable e) {
                        assert false;
                    }


                });
        await().atMost(20,TimeUnit.SECONDS).until(() -> read[0]);
        bookmarks = BookmarkExporter.importBookmarksFromFileStream(new FileInputStream(file));

        assert bookmarks.size() == 6;
        for (Bookmark.Entry item : bookmarks) {
            switch (item.getTitle()) {
                case "Google":
                    assert item.getUrl().equals("https://www.google.com/");
                    break;
                case "Facebook":
                    assert item.getUrl().equals("https://www.facebook.com/");
                    break;
                case "Twitter":
                    assert item.getUrl().equals("https://twitter.com/");
                    break;
                case "Wikipedia":
                    assert item.getUrl().equals("https://www.wikipedia.org/");
                    break;
                case "Contact Me":
                    assert item.getUrl().equals("https://twitter.com/RestainoAnthony");
                    break;
                default:
                    break;

            }
        }

        return;

    }

    @After
    public void tearDown() {
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }



}