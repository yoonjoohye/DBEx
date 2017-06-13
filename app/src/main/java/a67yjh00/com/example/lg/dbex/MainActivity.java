package a67yjh00.com.example.lg.dbex;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    class MyDBHelper extends SQLiteOpenHelper{
        public MyDBHelper(Context context) {
            super(context, "idolDB", null, 1);//idolDB라는 이름의 데이터베이스가 생성된다. 숫자 1은 버전임
        }
        // idolTable라는 이름의 테이블 생성
        @Override
        public void onCreate(SQLiteDatabase db) {
           String sql="create table idolTable(idolName text not null primary key, idolCount integer)";
            db.execSQL(sql);
        }
        //이미 idolTable이 존재한다면 기존의 테이블을 삭제하고, 새로 테이블을 만들 때 호출
        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int j) {
            String sql="drop table if exist idolTable";
            db.execSQL(sql);
            onCreate(db);
        }//내부클래스

    }
}
