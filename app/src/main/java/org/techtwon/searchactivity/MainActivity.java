package org.techtwon.searchactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Menu> menuArrayList, filteredList;
    MenuAdapter menuAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageButton clear = (ImageButton) findViewById(R.id.clearB);



        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search.setText("");
            }
        });

        ArrayAdapter cate = ArrayAdapter.createFromResource(this, R.array.cate, android.R.layout.simple_spinner_dropdown_item);

        cate.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        search = findViewById(R.id.search);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        filteredList = new ArrayList<>();
        menuArrayList = new ArrayList<>();


        menuAdapter = new MenuAdapter(menuArrayList,this);
        menuArrayList.add(new Menu("A곱창","경기도 평택시 ---","010-0000-0000","10시~24시","3시~4시"));
        menuArrayList.add(new Menu("B치킨","전라남도 광양시 ---","010-1111-1111", "12시~22시","없음"));
        menuArrayList.add(new Menu("C짜장면","전라남도 광양시 ---", "010-2222-2222","11시~20시","없음"));

        recyclerView.setAdapter(menuAdapter);

        menuAdapter.setOnItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onItemClick(MenuAdapter.ViewHolder holder, View v, int Position) {
                Menu item = menuAdapter.getItem(Position);
                showAc(item.getName(),item.getAdd(),item.getNum(),item.getTime(),item.getBreakT());

            }
        });


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
              if(search.length() < 1){
                  clear.setVisibility(View.INVISIBLE);
              }
              else
                  clear.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = search.getText().toString();
                searchFilter(searchText);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void searchFilter(String searchText) {
        filteredList.clear();

        for (int i = 0; i < menuArrayList.size(); i++) {
            if (menuArrayList.get(i).getName().toLowerCase().contains(searchText.toLowerCase())) {
                filteredList.add(menuArrayList.get(i));
            }
        }

        menuAdapter.filterList(filteredList);
    }


    public void showAc(String name, String add, String num, String time, String breakT) {

        Intent intent = new Intent(this,Menudetail.class);

        intent.putExtra("name",name);
        intent.putExtra("add",add);
        intent.putExtra("num",num);
        intent.putExtra("time",time);
        intent.putExtra("breakT",breakT);
        startActivity(intent);
    }



}