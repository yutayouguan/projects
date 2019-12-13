package ml.yike.MonteCarlo;

import android.util.Log;

import java.util.Random;

public class MoteCarlo implements Runnable {
    private int n;
    static float[] arr;
    static private double PI;

    private void setPI(double PI) {
        this.PI = PI;
    }

    public double getPI() {
        return PI;
    }

    public void setN(int n) {
        this.n = n;
    }

    private void calcPI() {
        double x, y;
        int sum = 0;
        //初始化数组大小,一个点两个值
        arr = new float[n*2];
        Random random = new Random();
        synchronized ("🔒") {
            for (int i = 0; i < n; i++) {
                x = random.nextDouble();
                y = random.nextDouble();
                if (i % 2 == 0) {
                    arr[i] = (float)x*800+140;
                } else {
                    arr[i] = (float)y*800+140;
                }
                if (Math.pow(x, 2) + Math.pow(y, 2) <= 1) {
                    sum++;
                }
            }
            setPI(PI = 4.0 * sum / n);
            Log.d(Thread.currentThread().getName(), "正在执行计算π的任务!!");
        }
    }

    @Override
    public void run() {
        calcPI();
        Log.d(Thread.currentThread().getName(), "已经完成计算π的任务!!");
    }
}
