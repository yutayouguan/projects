package ml.yike.MonteCarlo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import static ml.yike.MonteCarlo.MoteCarlo.arr;

public class MoteCarloView extends View {

    public MoteCarloView(Context context) {
        super(context);
    }

    public MoteCarloView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制直角坐标
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(5); //设置画笔大小
        paint.setAntiAlias(true);
        paint.setTextSize(50);//设置字体大小
        paint.setColor(Color.argb(255, 255, 255, 255));
        //        y轴
        canvas.drawLine(520, 20, 540, 5, paint);
        canvas.drawLine(540, 5, 560, 20, paint);
        canvas.drawLine(540, 5, 540, 1080, paint);
        canvas.drawText("y轴", 560, 50, paint);
        //        x轴
        canvas.drawText("1", 500, 120, paint);
        canvas.drawText("O", 500, 590, paint);
        canvas.drawText("-1", 470, 1000, paint);
        canvas.drawText("-1", 80, 590, paint);
        canvas.drawText("1", 960, 590, paint);
        canvas.drawLine(1060, 520, 1075, 540, paint);
        canvas.drawLine(1075, 540, 1060, 560, paint);
        canvas.drawLine(0, 540, 1075, 540, paint);
        canvas.drawText("x轴", 1000, 600, paint);
        //绘制正方形
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//类型为边框
        paint.setStrokeWidth(5);
        paint.setColor(Color.argb(150, 80, 60, 165));
        paint.setAntiAlias(true);//设置抗锯齿
        canvas.drawRect(140, 140, 940, 940, paint);
        //绘制圆形
        paint.setStyle(Paint.Style.FILL_AND_STROKE);//类型为边框
        paint.setStrokeWidth(5);
        paint.setColor(Color.argb(120, 255, 200, 90));
        canvas.drawCircle(540, 540, 400, paint);
        //绘制点
        paint.setColor(Color.argb(255, 255, 255, 255));
        paint.setStrokeWidth(5);
        canvas.drawPoints(arr, paint);

    }
}
