package com.mustafa.ilk_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mustafa on 23.11.2017.
 */

public class veriKaynagi {
    SQLiteDatabase db;
    sqlite_katmani bdb;
    public veriKaynagi(Context c){
        bdb = new sqlite_katmani(c);
    }
     public void ac(){
         db = bdb.getWritableDatabase();
     }

     public void kapa(){
         bdb.close();
     }
    public int kullaniciOlustur(String isim){
       // String isim ="ali demir";
        //kullanici k = new kullanici();
       // k.setIsim(isim);
        ContentValues val = new ContentValues();
        val.put("isim",isim);
       int sonid = (int) db.insert("kullanici",null,val);
        return sonid;
    }
    public void kullaniciSil(kullanici k){
        int id = k.getId();
        db.delete("kullanici","id="+id,null);

    }
    public List<kullanici> listele(){
        String kolonlar[] ={"id","isim"};
        List<kullanici>liste = new ArrayList<kullanici>();
        Cursor c = db.query("kullanici",kolonlar,null,null,null,null,null);
        c.moveToFirst();
        while(!c.isAfterLast()){
            int id  = c.getInt(0);
            String isim = c.getString(1);
            String eleman = ""+id+"-"+isim;
            kullanici k = new kullanici(isim);
            liste.add(k);
            c.moveToNext();
        }
        c.close();
        return liste;
    }

}
