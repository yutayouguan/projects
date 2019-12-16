package ml.yike.u;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener,
        AdapterView.OnItemClickListener,
        AlertDialog.OnClickListener,
        AdapterView.OnItemLongClickListener {
    static final String DB_NAME = "WangDB"; //数据库名
    static final String TB_NAME = "Wang";//表名
    static final int MAX = 15; //记录的上限
    static final String[] FROM = new String[]{"name", "phone", "email"}; //字段数组
    SQLiteDatabase db;//数据库对象
    String createTable; //表对象
    Cursor cur; //查询结果的存放对象
    SimpleCursorAdapter adapter; //
    EditText etName, etPhone, etEmail; //用于输入姓名.电话,邮件地址的字段
    ImageButton btInsert, btUpdate, btDelete, btCall, btSend; //添加,更新,删除,拨打,发送图标按钮
    ListView show; //显示列表

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    //初始化UI组件与数据库
    private void init() {
        //获取界面上的组件
        etName = (EditText) findViewById(R.id.etName);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btInsert = (ImageButton) findViewById(R.id.btInsert);
        btInsert.setOnClickListener(this);
        btUpdate = (ImageButton) findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(this);
        btDelete = (ImageButton) findViewById(R.id.btDelete);
        btDelete.setOnClickListener(this);
        btCall = (ImageButton) findViewById(R.id.btCall);
        btCall.setOnClickListener(this);
        btSend = (ImageButton) findViewById(R.id.btSend);
        btSend.setOnClickListener(this);

//        打开或者创建数据库
        db = openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
//        创建数据表
        createTable = "CREATE TABLE IF NOT EXISTS " + TB_NAME +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +    //索引字段
                "name VARCHAR(32)," +
                "phone VARCHAR(16)," +
                "email VARCHAR(64))";

        db.execSQL(createTable);

        cur = db.rawQuery("SELECT * FROM " + TB_NAME, null);//查询数据
        if (cur.getCount() == 0) {//如果空则写入测试数据
            addDate("王猛", "19988561504", "wmdyx@outlook.com");
        }
        //创建Adapter对象
        adapter = new SimpleCursorAdapter(this,
                R.layout.items,
                cur,
                FROM,
                new int[]{R.id.name, R.id.phone, R.id.email}, 0);
        show = (ListView) findViewById(R.id.show);
        show.setAdapter(adapter); //设置adapter
        show.setOnItemClickListener(this); //设置单击事件的监听器
        show.setOnItemLongClickListener(this); //设置长按事件的监听器
        requery();//调用自定义方法重新查询和设置按钮的状态
    }

    private void requery() { //重新查询的自定义方法
        cur = db.rawQuery("SELECT * FROM " + TB_NAME, null);
        adapter.changeCursor(cur); //更改adapter的cursor
        if (cur.getCount() == MAX) {
            btInsert.setEnabled(false);
        } else {
            btInsert.setEnabled(true);
        }
        btUpdate.setEnabled(false);//停用更新按钮,等待用户选择选项后再启动
        btDelete.setEnabled(false);//停用删除按钮,等待用户选择选项后再启动
    }

    //添加数据
    private void addDate(String name, String phone, String email) {

        ContentValues cv = new ContentValues(3);
        cv.put(FROM[0], name);
        cv.put(FROM[1], phone);
        cv.put(FROM[2], email);
        db.insert(TB_NAME, null, cv);


    }

    private boolean check(String nameStr, String phoneStr, String emailStr) {

        if (nameStr.length() == 0) {
            Toast.makeText(this, R.string.inputn, Toast.LENGTH_LONG).show();
            return true;
        } else if (phoneStr.length() == 0) {
            Toast.makeText(this, R.string.inputp, Toast.LENGTH_LONG).show();
            return true;
        } else if (emailStr.length() == 0) {
            Toast.makeText(this, R.string.inpute, Toast.LENGTH_LONG).show();
            return true;
        } else {
            return false;
        }

    }

    private void update(String name, String phone, String email, int id) {
        ContentValues cv = new ContentValues(3);
        cv.put(FROM[0], name);
        cv.put(FROM[1], phone);
        cv.put(FROM[2], email);
        db.update(TB_NAME, cv, "_id=" + id, null);//更新_id所指记录
    }

    private void reset() {
        etName.setText("");
        etPhone.setText("");
        etEmail.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btInsert:
                onInsert();
                break;
            case R.id.btUpdate:
                onUpdate();
                break;
            case R.id.btDelete:
                onDelete();
                break;
            case R.id.btCall:
                onCall();
                break;
            case R.id.btSend:
                onMail();
                break;

        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        cur.moveToPosition(position);//移动到用户选取的选项
        //读出数据并显示
        etName.setText(cur.getString(cur.getColumnIndex(FROM[0])));
        etPhone.setText(cur.getString(cur.getColumnIndex(FROM[1])));
        etEmail.setText(cur.getString(cur.getColumnIndex(FROM[2])));
        btUpdate.setEnabled(true);//启用更新按钮
        btDelete.setEnabled(true);//启用删除按钮

    }

    public void onInsert() {
        String nameStr = etName.getText().toString().trim();
        String phoneStr = etPhone.getText().toString().trim();
        String emailStr = etEmail.getText().toString().trim();
        if (isRepeat()) {
            Toast.makeText(this, R.string.tip3, Toast.LENGTH_LONG).show();
        } else {
            if (!check(nameStr, phoneStr, emailStr)) {
                addDate(nameStr, phoneStr, emailStr);
                requery();
                reset();
            }
        }


    }

    private boolean isRepeat() {
        String phoneStr = etPhone.getText().toString().trim();
        cur = db.rawQuery("SELECT phone FROM " + TB_NAME, null);
        if (cur.moveToFirst()) {
            do {
                if (cur.getString(0).equals(phoneStr)) {
                    return true;
                }
            } while (cur.moveToNext());

        }

        return false;

    }

    public void onUpdate() {
        String nameStr = etName.getText().toString().trim();
        String phoneStr = etPhone.getText().toString().trim();
        String emailStr = etEmail.getText().toString().trim();

        if (!check(nameStr, phoneStr, emailStr)) {
            update(nameStr, phoneStr, emailStr, cur.getInt(0));
            requery();
            reset();
        }

    }


    public void onDelete() {
        new AlertDialog.Builder(this)
                .setCancelable(false)
                .setIcon(R.drawable.smile)
                .setTitle(R.string.title)
                .setMessage(R.string.message)
                .setNegativeButton(R.string.cancel, this)
                .setPositiveButton(R.string.confirm, this).show();
    }

    public void onCall() {
        String url = "tel:" + cur.getString(cur.getColumnIndex(FROM[1]));
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(it);
    }

    public void onMail() {
        String uri = "mailto:" + cur.getString(cur.getColumnIndex(FROM[2]));
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(it);
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE) {
            db.delete(TB_NAME, "_id=" + cur.getInt(0), null);
            Toast.makeText(this, R.string.tip1, Toast.LENGTH_LONG).show();
            requery();
            reset();
        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
            Toast.makeText(this, R.string.tip2, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        onItemClick(parent, view, position, id); //调用选取事件的处理方法
        onCall(); //调用拨号的方法
        return true; //已经处理好,不需要引发后续事件
    }
}
