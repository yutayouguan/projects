package ml.yike.button;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    //    Button button1, button2;
    int fontSize = 30;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.txv);
//        button1 = (Button) findViewById(R.id.b1);
//        buuton2 = (Button) findViewById(R.id.b2);
    }


    public void zoom(View view) {
        if (fontSize < 60) {
            textView.setTextSize(++fontSize);
        } else {
            ;
            new AlertDialog.Builder(context).setTitle("温馨提示")
                    .setMessage("字体太大了可能会影响视觉体验哦！")
                    .setPositiveButton("确定", null)
                    .setNegativeButton("取消", null)
                    .show();

        }
    }

    public void zoomOut(View view) {
        if (fontSize > 10) {
            textView.setTextSize(--fontSize);
        } else {


            new AlertDialog.Builder(context).setTitle("温馨提示")
                    .setMessage("字体太小了可能会眼睛👀疲劳哦！")

                    .setPositiveButton("确定", null)
                    .setNegativeButton("取消", null)
                    .show();
        }
    }

}
