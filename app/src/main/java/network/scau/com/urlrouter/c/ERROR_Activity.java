package network.scau.com.urlrouter.c;

import android.app.Activity;
import android.os.Bundle;

import com.scau.UrlBinding;

import network.scau.com.urlrouter.R;

@UrlBinding(url = "scau://toError",controller = "network.scau.com.urlrouter.c.ERROR_Activity")
public class ERROR_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_);
    }
}
