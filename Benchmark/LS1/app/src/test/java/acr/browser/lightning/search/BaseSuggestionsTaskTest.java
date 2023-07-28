package acr.browser.lightning.search;

import static org.junit.Assert.*;

import android.app.Application;
import android.support.annotation.NonNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.io.File;
import java.util.List;

import acr.browser.lightning.database.HistoryItem;

@RunWith(RobolectricTestRunner.class)
public class BaseSuggestionsTaskTest {

    @Test
    public void downloadSuggestionsForQuery(){
        String query = "";
        Application app = RuntimeEnvironment.getApplication();
        BaseSuggestionsTask task = new GoogleSuggestionsTask(query, app, new SuggestionsResult() {
            @Override
            public void resultReceived(@NonNull List<HistoryItem> searchResults) {

            }
        });
        assert  task.isNetworkConnected(app);
        String queryUrl = task.getQueryUrl(query, "");
        File cacheFile = new File(app.getCacheDir(), queryUrl.hashCode() + SuggestionsAdapter.CACHE_FILE_TYPE);
        assert (task.downloadSuggestionsForQuery("","",app).equals(cacheFile));
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

    @Test
    public void repeatCallsTest() {
        String query = "";
        Application app = RuntimeEnvironment.getApplication();
        BaseSuggestionsTask task = new GoogleSuggestionsTask(query, app, new SuggestionsResult() {
                @Override
                public void resultReceived(@NonNull List<HistoryItem> searchResults) {

                }
        });
        for (int i =0; i<50; i++){
            task.isNetworkConnected(app);
        }
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

}
