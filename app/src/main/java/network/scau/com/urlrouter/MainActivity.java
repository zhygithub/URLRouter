package network.scau.com.urlrouter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import URLMap.network.scau.com.urlrouter.map.BaseMap$SUFFIX;
import network.scau.com.urlrouter.dispatch.Router;

public class MainActivity extends AppCompatActivity {

    Router router;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        router = Router.getInstance(this);

    }

    public void click(View v){
        String rui = BaseMap.B +"?size="+5;
        router.assignet(rui);
        try {
            router.setMapRule(BaseMap.B, (Class<? extends Activity>) Class.forName(BaseMap$SUFFIX.A_Activity_Activity));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
