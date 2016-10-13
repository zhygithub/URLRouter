package network.scau.com.urlrouter.dispatch;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Parcelable;

import java.util.Map;


/**
 * Created by Administrator on 2016/9/10 0010.
 */

public interface IRouterItem {

    void doRoute(Map<String,Class<? extends Activity>> map,Context text, Uri uri, Parcelable data);
}
