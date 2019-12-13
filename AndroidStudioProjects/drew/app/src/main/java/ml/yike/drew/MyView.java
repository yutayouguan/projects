package ml.yike.drew;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View implements Runnable {
    //图形当前的坐标
    private int mX = 20;
    private int mY = 20;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取焦点
        setFocusable(true);
        //启动线程
        new Thread(this).start();
    }

    @Override
    public void run() {
        RefreshThread mDrawHandler = new RefreshThread();
        while (!Thread.currentThread().isInterrupted()) {
            Message msg = new Message();
            msg.what = 0x101;
            mDrawHandler.sendMessage(msg);

            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //实例化画笔
        Paint mPaint = new Paint();
        //设置画笔颜色
        mPaint.setColor(Color.RED);
        //画圆
        canvas.drawCircle(mX, mY, 20, mPaint);
        super.onDraw(canvas);
    }

    class RefreshThread extends Handler {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 0x101) {
                MyView.this.update();
            }
            super.handleMessage(msg);
        }
    }

    /**
     * 更新坐标
     */
    private void update() {
        int height = getHeight();
        mY += 5;
        if (mY >= height) {
            mY = 20;
        }
    }
}