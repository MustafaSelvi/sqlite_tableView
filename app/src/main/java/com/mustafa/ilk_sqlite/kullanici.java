package com.mustafa.ilk_sqlite;

/**
 * Created by mustafa on 23.11.2017.
 */

public class kullanici {
    String isim;
    int id;

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public kullanici(String isim) {

        this.isim = isim;
    }
    public String toString(){
        return  ""+id+"-"+isim;
    }
}
