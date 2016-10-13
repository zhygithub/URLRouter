package network.scau.com.urlrouter.c;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.scau.UrlBinding;

import network.scau.com.urlrouter.BaseMap;
import network.scau.com.urlrouter.R;
import network.scau.com.urlrouter.Router;

@UrlBinding(url = BaseMap.A,controller = "network.scau.com.urlrouter.c.A_Activity")
public class A_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_);

        final Router router = Router.getInstance(this);

        final EditText edt = (EditText) findViewById(R.id.edt);
        findViewById(R.id.btm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = edt.getText().toString();


                if(TextUtils.isEmpty(string)){
                    return ;
                }

                router.assignet(string);
            }
        });

    }
}
