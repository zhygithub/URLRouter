package network.scau.com.urlrouter.dispatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;

import java.util.Map;

/**
 * Created by Administrator on 2016/9/11 0011.
 */

public class RouterProcessFactor {

    public static IRouterItem getDefaultProcess(){
        return new IRouterItem() {
            @Override
            public void doRoute(Map<String, Class<? extends Activity>> map, Context context, Uri uri, Parcelable data) {
                StringBuilder sb = new StringBuilder();
                sb.append(uri.getScheme()).append("://").append(uri.getAuthority()).append(uri.getPath());

                Class<? extends Activity> activity = map.get(sb.toString());
                Intent intent = new Intent(context, activity);
                String size = uri.getQueryParameter("size");
                intent.putExtra("size",size);
                Bundle bundle = new Bundle();
                bundle.putParcelable("data",data);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        };
    }
}
