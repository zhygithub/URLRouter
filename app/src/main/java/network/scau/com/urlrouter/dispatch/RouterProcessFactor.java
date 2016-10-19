package network.scau.com.urlrouter.dispatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/9/11 0011.
 */

public class RouterProcessFactor {

    public static final  String  PARAMS_NAMES = "paramsNames";

    public static final  String  PARAMS = "data";

    public static IRouterItem getDefaultProcess(){
        return new IRouterItem() {
            @Override
            public void doRoute(Map<String, Class<? extends Activity>> map, Context context, Uri uri, Parcelable data) {
                StringBuilder sb = new StringBuilder();
                sb.append(uri.getScheme()).append("://").append(uri.getAuthority()).append(uri.getPath());

                Class<? extends Activity> activity = map.get(sb.toString());
                Intent intent = new Intent(context, activity);
                Set<String> queryParameterNames = uri.getQueryParameterNames();
                ArrayList<String> list = new ArrayList<>();
                String param;
                for (String paramName:queryParameterNames
                     ) {
                    Log.d("routerDemo","paramName="+paramName+"\n");
                    param  = uri.getQueryParameter(paramName);
                    list.add(paramName);
                    intent.putExtra(paramName,param);
                }

                intent.putStringArrayListExtra(PARAMS_NAMES,list);

                Bundle bundle = new Bundle();
                bundle.putParcelable(PARAMS,data);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        };
    }
}
