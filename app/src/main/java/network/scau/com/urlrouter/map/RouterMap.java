package network.scau.com.urlrouter.map;

import android.app.Activity;

import java.util.HashMap;
import java.util.Map;

import network.scau.com.urlrouter.dispatch.IRouterItem;

/**
 * Created by Administrator on 2016/9/11 0011.
 */

public class RouterMap {
    HashMap<String,Class<? extends Activity>> map ;

    HashMap<String,IRouterItem> processMap;

    public void setDefaultProcess(IRouterItem process) {
        processMap = new HashMap<String,IRouterItem>();

        for (Map.Entry<String,Class<? extends Activity>> entry :map.entrySet()
             ) {
            processMap.put(entry.getKey(),process);
        }
    }

    public HashMap<String, IRouterItem> getProcess() {
        return processMap;
    }

    public void setMap(HashMap<String, Class<? extends Activity>> map) {
        this.map = map;
    }

    public HashMap<String, Class<? extends Activity>> getMap() {
        return map;
    }
}
