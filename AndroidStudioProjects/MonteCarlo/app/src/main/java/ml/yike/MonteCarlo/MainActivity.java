package ml.yike.MonteCarlo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AlertDialog.OnClickListener {
    private Button b1, b2;
    private TextView txv1;
    private EditText edt1;
    private Thread thread1;
    private MoteCarlo moteCarlo;
    private LinearLayout linearLayout;
    private MoteCarloView moteCarloView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    //初始化视图组件
    private void init() {
        b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(this);
        txv1 = (TextView) findViewById(R.id.txv1);
        edt1 = (EditText) findViewById(R.id.edt1);
        linearLayout=(LinearLayout)findViewById(R.id.layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b1:
                Log.d(Thread.currentThread().getName(), "你点击了计算按钮,将要进行π的计算");
                CalculatePI();
                break;
            case R.id.b2:
                Log.d(Thread.currentThread().getName(), "你点击了复位按钮,点数将要重置");
                reset();
                break;

        }
    }

    public int getNumber() {
        String s = edt1.getText().toString().trim();//   trim() 返回一个值为该字符串的字符串，并删除所有前导和尾随空格，其中空格定义为代码点小于或等于“ U 0020”的任何字符（空格字符）。
        Log.d(Thread.currentThread().getName(), "你输入了:" + s);
        if (s.length() == 0) {
//            Toast.makeText(this,R.string.Ms_M1,Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.smile)
                    .setTitle(R.string.Ms_t)
                    .setMessage(R.string.Ms_M1)
                    .setPositiveButton(R.string.define, null)
                    .setNegativeButton(R.string.cancel, null)
                    .show();
            return 0;
        } else if (s.length() <= 3) {
//            Toast.makeText(this,R.string.Ms_M2,Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.smile)
                    .setTitle(R.string.Ms_t)
                    .setMessage(R.string.Ms_M2)
                    .setPositiveButton(R.string.define, null)
                    .setNegativeButton(R.string.cancel, null)
                    .show();
            return 0;
        } else {
            return Integer.parseInt(s.trim()); //parseInt()将字符串参数解析为带符号的十进制整数。字符串中的字符必须全部为十进制数字，但第一个字符可以是ASCII减号'-'（'\ u002D'）表示负值，也可以是ASCII加号''（'\ u002B'）表示正值。
        }


    }

    public void Drew() {
        moteCarloView = new MoteCarloView(this);
        moteCarloView.invalidate();
        linearLayout.addView(moteCarloView);
    }

    public void CalculatePI() {
        moteCarlo = new MoteCarlo();
        int num = getNumber();
        if (num != 0) {
            moteCarlo.setN(num);
            thread1 = new Thread(moteCarlo, "计算PI线程");
            thread1.setPriority(10);
            Drew();
            thread1.start();
            Log.d(Thread.currentThread().getName(), "开始进入计算π的任务的线程!!");
            txv1.setTextSize(30);
            txv1.setTextColor(Color.rgb(255, 255, 255));
            txv1.setText("当点数为:" + num + "\nπ的近似值为:" + moteCarlo.getPI());
            Log.d(Thread.currentThread().getName(), "得到了计算结果:" + moteCarlo.getPI());

        }


    }

    public void reset() {
        new AlertDialog.Builder(this)
                .setCancelable(false) //禁用返回键关闭对话框
                .setIcon(R.drawable.smile)
                .setTitle(R.string.Ms_t)
                .setMessage(R.string.Ms_M3)
                .setPositiveButton(R.string.define, this)
                .setNegativeButton(R.string.cancel, this)
                .show();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            txv1.setText(" ");
            edt1.setText(" ");
            Toast.makeText(this, R.string.Ms_M4, Toast.LENGTH_SHORT).show();
          /*  new AlertDialog.Builder(this)
                    .setCancelable(false) //禁用返回键关闭对话框
                    .setIcon(R.drawable.smile)
                    .setTitle(R.string.Ms_t)
                    .setMessage(R.string.Ms_M4)
                    .setPositiveButton(R.string.define, null)
                    .show();*/
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            Toast.makeText(this, R.string.Ms_M5, Toast.LENGTH_SHORT).show();
           /*     new AlertDialog.Builder(this)
                    .setCancelable(false) //禁用返回键关闭对话框
                    .setIcon(R.drawable.smile)
                    .setTitle(R.string.Ms_t)
                    .setMessage(R.string.Ms_M5)
                    .setPositiveButton(R.string.define, null)
                    .show();*/
        }
    }
}