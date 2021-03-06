package org.techtwon.searchactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;

public class Menudetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        TextView tx = (TextView) findViewById(R.id.textView3);
        tx.setText(bundle.getString("name"));
        TextView tx2 = (TextView) findViewById(R.id.textView4);
        tx2.setText(bundle.getString("add"));
        TextView tx3 = (TextView) findViewById(R.id.textView5);
        tx3.setText("◦전화번호: "+bundle.getString("num"));
        TextView tx4 = (TextView) findViewById(R.id.textView7);
        tx4.setText("◦운영시간: "+bundle.getString("opentime") +" ~ "+ bundle.getString("endtime"));
        TextView tx6 = (TextView) findViewById(R.id.textView8);
        tx6.setText("◦브레이크 타임: "+bundle.getString("breakT"));
        TextView tx8 = (TextView) findViewById(R.id.textView13);
        tx8.setText("◦정기휴일: "+bundle.getString("holiday"));
        TextView tx7 = (TextView) findViewById(R.id.textView11);
        tx7.setText("★추천메뉴: "+bundle.getString("recomand"));
;


        ImageView ima = findViewById((R.id.imageView2));
        ImageView ima2 = findViewById((R.id.imageView4));

        Glide.with(this)
                .load(bundle.getString("ima"))
                .into(ima);

        Glide.with(this)
                .load(bundle.getString("ima2"))
                .into(ima2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    public void call(View v){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Intent I = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+bundle.getString("num")));
        startActivity(I);
    }

    public void backI(View v){
        Intent intent = getIntent();
        finish();
    }



}