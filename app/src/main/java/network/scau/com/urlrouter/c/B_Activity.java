package network.scau.com.urlrouter.c;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.scau.UrlBinding;

import network.scau.com.urlrouter.BaseMap;
import network.scau.com.urlrouter.R;

@UrlBinding(url = BaseMap.B,controller = "network.scau.com.urlrouter.c.B_Activity")
public class B_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_);

        String size = getIntent().getStringExtra("size");

        TextView btn  = (TextView) findViewById(R.id.tv);
        btn.setText(getClass().getName() + "||"+size);
    }
}
