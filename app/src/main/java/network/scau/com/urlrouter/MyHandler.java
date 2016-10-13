package network.scau.com.urlrouter;


import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * Created by Administrator on 2016/9/10 0010.
 */

public class MyHandler extends URLStreamHandler {


    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        return null;
    }
}
