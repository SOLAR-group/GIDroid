package org.fdroid.fdroid;


import android.content.Context;

import org.junit.runner.RunWith;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(Utils.class)
public class ShadowUtils {

    @Implementation
    public static long getImageCacheDirTotalMemory(Context context) {
        return 100l;
    }
}
