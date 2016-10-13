package network.scau.com.urlrouter.map;


import android.app.Activity;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import URLMap.network.scau.com.urlrouter.map.BaseMap$SUFFIX;


/**
 * Created by Administrator on 2016/9/10 0010.
 */

public class RouterMapFactor {

    public static RouterMap getDefauleMap() {
        HashMap<String,String> orinMap = BaseMap$SUFFIX.getRouterMap();
        RouterMap routerMap = new RouterMap();
        HashMap<String, Class<? extends Activity>> map = new HashMap<>();


        try {

        for (Map.Entry<String,String> entry:orinMap.entrySet()
             ) {

            map.put(entry.getKey(), (Class<Activity>) Class.forName(entry.getValue()));
            Log.d("router","key : "+entry.getKey()+" | value : "+entry.getValue());
        }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        routerMap.setMap(map);
        return routerMap;
    }
}
