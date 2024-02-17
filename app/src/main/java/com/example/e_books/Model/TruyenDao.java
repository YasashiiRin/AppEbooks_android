package com.example.e_books.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.e_books.Database.DatabaseEBooks;

import java.util.ArrayList;
import java.util.List;

public class  TruyenDao {
    private SQLiteDatabase db;
    private DatabaseEBooks databaseEBooks;
    private Context context;

    public TruyenDao(Context context) {
        this.context = context;
        databaseEBooks=new DatabaseEBooks(context);
        db=databaseEBooks.getWritableDatabase();
    }

    public int InsertTruyen(Truyen truyen){
        ContentValues values=new ContentValues();
        values.put("tieude",truyen.getTtentruyen());
        values.put("noidung",truyen.getTnoidung());
        values.put("anh",truyen.getTimg());
        long kq=db.insert("truyen",null,values);
            if (kq<0){
                return -1;
            }
            return 1;
    }
    public List<String> getalltruyen(){
        List<String> ls=new ArrayList<>();
        Cursor c=db.query("truyen",null,null,null,null,null,null);
        c.moveToFirst();
        while (c.isAfterLast()==false){
                Truyen tr=new Truyen();
                tr.setTid(c.getInt(0));
                tr.setTtentruyen(c.getString(1));
                tr.setTnoidung(c.getString(2));
                tr.setTimg(c.getString(3));

                String s=tr.getTid()+"-"+tr.getTtentruyen()+"-"+tr.getTnoidung()+"-"+tr.getTimg();
                ls.add(s);
                c.moveToNext();//chuyen den ban ghi tiep theo

        }
        c.close();
        return ls;
    }

}
