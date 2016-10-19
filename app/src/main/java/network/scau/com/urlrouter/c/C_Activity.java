package network.scau.com.urlrouter.c;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.scau.UrlBinding;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

import network.scau.com.urlrouter.BaseMap;
import network.scau.com.urlrouter.R;
import network.scau.com.urlrouter.dispatch.Router;

@UrlBinding(url = BaseMap.C,controller = "network.scau.com.urlrouter.c.C_Activity")
public class C_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_);

        Intent intent = getIntent();

        List<String> paramsNamesList = Router.getParamsNamesList(intent);

        Map<String, String> paramsMap = Router.getParamsMap(intent);


        TextView tv = (TextView) findViewById(R.id.tv);

        StringBuilder sb  = new StringBuilder();
        String param;
        for (String name:paramsNamesList
             ) {
            param = paramsMap.get(name);
            sb.append(" "+name+":"+param+"\n");
        }

        Log.d("routerDemo",sb.toString());

        tv.setText(sb.toString());
    }
}
