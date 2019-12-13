package ml.yike.even;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener,View.OnKeyListener {
    TextView txv0, txv1, txv2, txv3, txv4;
    Button b1, b2;
    int count = 0;
    EditText et1,et2;
    static int x = 0, y = 0;
String keyCodestr=" ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txv0 = (TextView) findViewById(R.id.txv0);
        txv0.setOnTouchListener(this);
        txv1 = (TextView) findViewById(R.id.txv1);
        txv1.setOnTouchListener(this);
        txv2 = (TextView) findViewById(R.id.txv2);
        txv1.setOnTouchListener(this);
        txv3 = (TextView) findViewById(R.id.txv3);
        txv3.setOnTouchListener(this);
        txv4 = (TextView) findViewById(R.id.txv4);

        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b1.setOnLongClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        b2.setOnLongClickListener(this);

        et1=(EditText)findViewById(R.id.edt1);
        et1.setOnKeyListener(this);
        et2=(EditText)findViewById(R.id.edt2);
        et2.setOnKeyListener(this);

    }

    public void count() {
        for (int i = 1; i <= 3600000; i++) {
            txv3.setText(i);
            y = x = i;
            if (i % 1000 == 0) {
                txv2.setText(x / 1000);
            } else if (i % 60 == 0) {
                txv1.setText(x / 60);

            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
//                count();
                b1.setBackgroundColor(Color.rgb(255, 0, 0));
                b2.setBackgroundColor(Color.rgb(0, 255, 0));
                b1.setText("停止");
                b2.setText("计次");
                break;
            case R.id.b2:
                count++;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("计次" + count + y / 1000 % 60 + ":" + y * 60 + ":" + y * 100);
                txv4.setText(stringBuilder.toString());
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                b1.setText("启动");
                b2.setText("复位");
                b1.setBackgroundColor(Color.argb(100,0,0,0));
                b2.setBackgroundColor(Color.argb(100,0, 0, 0));
                break;
            case R.id.b2:
                txv4.setText(" ");
                txv3.setText("00");
                txv2.setText("00");
                txv1.setText("00");
                break;
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Vibrator vibrator = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        if (event.getAction()==MotionEvent.ACTION_DOWN){

            vibrator.vibrate(new long[]{0,200,1000,300},2);
        }
        else if (event.getAction()==MotionEvent.ACTION_UP)
        {

            vibrator.cancel();
        }
        else if(event.getAction()== MotionEvent.ACTION_MOVE){
            vibrator.vibrate(new long[]{0,300,2000,200},2);

        }
        return true;
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
keyCodestr ="你输入了"+"姓名:"+et1.getText().toString()+"\n"+"密码:"+et2.getText().toString();
txv4.setText(keyCodestr);
        return true;
    }
}
