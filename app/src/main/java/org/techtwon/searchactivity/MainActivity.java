package org.techtwon.searchactivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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


        menuArrayList = new ArrayList<>();

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("StoreData").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value,  @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    Log.w("Listen failed.", e);
                    return;
                }
                int count = value.size();
                menuArrayList.clear();
                String breaktime = "";
                String regular ="";
                for (QueryDocumentSnapshot doc : value){
                    if(doc.getBoolean("breaktimeistrue")){
                        breaktime = doc.getString("breaktime");
                    }
                    else
                        breaktime = "X";
                    if(doc.get("regularholiday") != ""){
                        regular = doc.getString("regularholiday");
                    }
                    else
                        regular = "X";
                    if(doc.get("name") != null){
                        menuArrayList.add(new Menu(doc.getString("name"), doc.getString("address"), doc.getString("telephone"),
                                doc.getString("starttime"),doc.getString("endtime"), breaktime, doc.getString("ima1"),
                                doc.getString("ima2"),doc.getString("menu"), regular));
                    }
                }
            }
        });


        ImageButton clear = (ImageButton) findViewById(R.id.clearB);

        clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                search.setText("");
            }
        });


        RecyclerView recyclerView = findViewById(R.id.recyclerView);


        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        search = findViewById(R.id.search);

        filteredList = new ArrayList<>();

        menuAdapter = new MenuAdapter(menuArrayList,this);


        recyclerView.setAdapter(menuAdapter);

        menuAdapter.setOnItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onItemClick(MenuAdapter.ViewHolder holder, View v, int Position) {
                Menu item = menuAdapter.getItem(Position);
                showAc(item.getName(),item.getAdd(),item.getNum(),item.getOpentime(),item.getEndtime(),
                        item.getBreakT(),item.getIma(),item.getIma2(),item.getRecomand(),item.getHoliday());

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

    public void showAc(String name, String add, String num, String opentime, String endtime, String breakT, String ima, String ima2, String recomand, String holiday) {

        Intent intent = new Intent(this,Menudetail.class);

        intent.putExtra("name",name);
        intent.putExtra("add",add);
        intent.putExtra("num",num);
        intent.putExtra("opentime",opentime);
        intent.putExtra("endtime",endtime);
        intent.putExtra("breakT",breakT);
        intent.putExtra("ima",ima);
        intent.putExtra("ima2",ima2);
        intent.putExtra("recomand",recomand);
        intent.putExtra("holiday",holiday);
        startActivity(intent);
    }

}