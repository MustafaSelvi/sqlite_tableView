package com.mustafa.ilk_sqlite;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.List;
import java.util.Random;

public class MainActivity extends ListActivity {
     veriKaynagi vk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         vk = new veriKaynagi(this);
        vk.ac();
        List<kullanici> kullanicilar = vk.listele();
        final ArrayAdapter<kullanici>adaptor = new ArrayAdapter<kullanici>(this,android.R.layout.simple_list_item_1,kullanicilar);
        setListAdapter(adaptor);
        Button ekle = (Button)findViewById(R.id.add);
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isimler [] = {"ali demir","veli yildiz","ahmet sefa","fatma gündüz"};
                Random r = new Random();
                int ras =r.nextInt(3);
                kullanici k = new kullanici(isimler[ras]);
               int sonid = vk.kullaniciOlustur(k.getIsim());
                k.setId(sonid);
                adaptor.add(k);
            }
        });
        Button silme = (Button)findViewById(R.id.delete);
        silme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            kullanici k = (kullanici) getListAdapter().getItem(0);
                vk.kullaniciSil(k);
                adaptor.remove(k);
            }
        });
    }
    protected  void onResume(){
vk.ac();
        super.onResume();
    }
    protected void onPause(){
        super.onPause();
    }
}
