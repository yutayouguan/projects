package ml.yike.colordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txvBlock, txvR, txvG, txvB,txvA;
    Button bt1, bt2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvBlock = (TextView) findViewById(R.id.txv_block);
        txvA = (TextView) findViewById(R.id.txv_A);
        txvR = (TextView) findViewById(R.id.txv_R);
        txvG = (TextView) findViewById(R.id.txv_G);
        txvB = (TextView) findViewById(R.id.txv_B);
        bt1 = (Button) findViewById(R.id.change);
        bt2 = (Button) findViewById(R.id.recover);
    }

    public void changeColor(View view) {
        Random x = new Random();
        int alpha = x.nextInt(256);
        txvA.setText("A"+ alpha);
        txvR.setBackgroundColor(Color.argb(alpha,0, 0, 0));
        int red = x.nextInt(256);
        txvR.setText("R"+red);
        txvR.setBackgroundColor(Color.rgb(red, 0, 0));
        int green = x.nextInt(256);
        txvG.setText("G"+green);
        txvG.setBackgroundColor(Color.rgb(0, green, 0));
        int blue = x.nextInt(256);
        txvB.setText("B"+blue);
        txvB.setBackgroundColor(Color.rgb(0, 0, blue));
        txvBlock.setText("A:"+alpha+" R:" + red + " G:" + green + " B:" + blue);
        txvBlock.setBackgroundColor(Color.argb(alpha,red, green, blue));


    }

    public void recover(View view) {

        txvA.setText("A"+ 0);
        txvR.setBackgroundColor(Color.argb(0,0, 0, 0));

        txvR.setText("R"+0);
        txvR.setBackgroundColor(Color.argb(0, 0, 0,0));

        txvG.setText("G"+0);
        txvG.setBackgroundColor(Color.argb(0, 0, 0,0));

        txvB.setText("B"+0);
        txvB.setBackgroundColor(Color.argb(0, 0, 0,0));
        txvBlock.setText("A:"+0+" R:" + 0 + " G:" + 0 + " B:" + 0);
        txvBlock.setBackgroundColor(Color.argb(0, 0, 0, 0));
    }

}
