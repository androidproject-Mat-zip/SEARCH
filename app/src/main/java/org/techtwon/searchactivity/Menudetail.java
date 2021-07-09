package org.techtwon.searchactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
        tx2.setText("주소: "+ bundle.getString("add"));
        TextView tx3 = (TextView) findViewById(R.id.textView5);
        tx3.setText("전화번호: "+bundle.getString("num"));
        TextView tx4 = (TextView) findViewById(R.id.textView7);
        tx4.setText("영업 시간: "+bundle.getString("time"));
        TextView tx5 = (TextView) findViewById(R.id.textView8);
        tx5.setText("브레이크 타임: "+bundle.getString("breakT"));

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