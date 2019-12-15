package ml.yike.hellosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static final String db_name = "wmd_DB"; //数据库名
    static final String tb_name = "wm";//表名
    SQLiteDatabase db; //数据库对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        打开或者创建数据库
        db = openOrCreateDatabase(db_name, Context.MODE_PRIVATE, null); //arg1:数据库名   arg2:创建数据库的文件模式(一般设为0,此处表示仅供自己使用的数据库) arg3:返回查询结果的类(null:使用系统默认的类)
        String createTable = "CREATE TABLE IF NOT EXISTS " + tb_name +
                "(name VARCHAR(32)," +    //姓名字段
                "phone VARCHAR(16)," +//电话字段
                "email VARCHAR(64))"; //电子邮件字段
        db.execSQL(createTable); //创建数据表(执行上面的SQL语句)


        //查询
        Cursor cursor = db.rawQuery("SELECT name,phone,email FROM " + tb_name, null); //查询表中的指定字段数据
        if (cursor.getCount() == 0)//是与否有数据,如果没有则插入数据
        {    // 调用自定义的addDate()方法写入数据
            addDate("王猛", "19988561504", "wmdyx@outlook.com");
            addDate("李可", "18213778413", "lkdyx@outlook.com");
            cursor = db.rawQuery("SELECT name,phone,email FROM " + tb_name, null);//重新查询
        }
      /* //从前向后 
       if (cursor.moveToFirst()) {//若有数据才继续
            String str = "一共有" + cursor.getCount() + "项数据\n";
            str += "---------------------------\n";
            do {
                str += "name:" + cursor.getString(cursor.getColumnIndex("name")) + "\n";
                str += "phone:" + cursor.getString(cursor.getColumnIndex("phone")) + "\n";
                str += "email:" + cursor.getString(cursor.getColumnIndex("email")) + "\n";
                str += "---------------------------\n";
            } while (cursor.moveToNext());*/
      //从后向前
        if (cursor.moveToLast()) {//若有数据才继续
            String str = "一共有" + cursor.getCount() + "项数据\n";
            str += "---------------------------\n";
            do {
                str += "name:" + cursor.getString(cursor.getColumnIndex("name")) + "\n";
                str += "phone:" + cursor.getString(cursor.getColumnIndex("phone")) + "\n";
                str += "email:" + cursor.getString(cursor.getColumnIndex("email")) + "\n";
                str += "---------------------------\n";
            } while (cursor.moveToPrevious());
            //显示数据库的信息
            TextView textView = (TextView) findViewById(R.id.show0);
            textView.setText("数据库路径:" + db.getPath() + "\n" +
                    "数据库分页大小:" + db.getPageSize() + "Bytes\n" +
                    "数据量上限:" + db.getMaximumSize() + "Bytes\n"
            );

            TextView textView1 = (TextView) findViewById(R.id.show1);
            textView1.setText(str);


        }
        db.close(); //关闭数据库
    }

    private void addDate(String name, String phone, String email) {
        ContentValues cv = new ContentValues(3);//创建含3个数据项的对象
        cv.put("name", name);
        cv.put("phone", phone);
        cv.put("email", email);
        db.insert(tb_name, null, cv); //将数据添加到数据表中 arg1:表名.arg2:cv对象插入空数据的处理方式,arg3:ContentValues对象
    }

}
