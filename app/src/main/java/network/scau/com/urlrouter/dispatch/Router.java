package network.scau.com.urlrouter.dispatch;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import network.scau.com.urlrouter.c.ERROR_Activity;
import network.scau.com.urlrouter.map.RouterMap;
import network.scau.com.urlrouter.map.RouterMapFactor;

import static android.R.id.list;

/**
 * Created by Administrator on 2016/9/10 0010.
 */

public class Router {

    public static final String SUFFIX = "_$$_Config";

    private RouterMap map;

    private Context context;

    private IRouterItem errorItem;

    public static  Router instance ;

    public static Router getInstance(Context context){
        if(instance==null){
            synchronized (Router.class){
                if(instance==null){
                    instance = new Router(context);
                }
            }
        }
        return instance;
    }

    private Router(Context context) {
        this.context = context;
        map = RouterMapFactor.getDefauleMap();
        map.setDefaultProcess(RouterProcessFactor.getDefaultProcess());
        errorItem = new IRouterItem() {
            @Override
            public void doRoute(Map<String,Class<? extends Activity>> map,Context text, Uri uri, Parcelable data) {
                Router.this.context.startActivity(new Intent(Router.this.context, ERROR_Activity.class));
            }
        };
    }

    public void assignet(String uriStr){
        assignet(uriStr,null);
    }

    public void setMapRule(String uri, Class<? extends Activity> classz){
        map.getMap().put(uri, classz);
    }

    public void assignet(String uriStr, Parcelable data){
        Uri uri = Uri.parse(uriStr);
        StringBuilder sb = new StringBuilder();
        sb.append(uri.getScheme()).append("://").append(uri.getAuthority()).append(uri.getPath());

        IRouterItem iRouterItem = map.getProcess().get(sb.toString());
        if(iRouterItem == null){
            iRouterItem = errorItem;
        }
        iRouterItem.doRoute(map.getMap(),context,uri,data);

    }

    public static List<String> getParamsNamesList(Intent intent){
        List<String> list = intent.getStringArrayListExtra(RouterProcessFactor.PARAMS_NAMES);

        return list;
    }

    public static Map<String,String> getParamsMap(Intent intent){
        List<String> paramsNamesList = getParamsNamesList(intent);
        Map<String,String> map = new HashMap<>();
        String stringExtra;
        for (String paramsName:paramsNamesList
                ) {
            stringExtra= intent.getStringExtra(paramsName);
            map.put(paramsName,stringExtra);
        }

        return map;
    }


    public static Parcelable getParcelableExtra(Intent intent){
        return intent.getParcelableExtra(RouterProcessFactor.PARAMS);
    }
}
