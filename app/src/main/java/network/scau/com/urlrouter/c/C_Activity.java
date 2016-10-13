package network.scau.com.urlrouter.c;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.scau.UrlBinding;

import network.scau.com.urlrouter.BaseMap;
import network.scau.com.urlrouter.R;
@UrlBinding(url = BaseMap.C,controller = "network.scau.com.urlrouter.c.C_Activity")
public class C_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_);
    }
}
