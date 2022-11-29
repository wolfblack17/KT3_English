package com.example.kt_english;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kt_english.Adapter.EnglishAdapter;
import com.example.kt_english.Model.English;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvEnglish;
    private EnglishAdapter adapter;
    private List<English> EnglishList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();

        EnglishList = new ArrayList<>();
        EnglishList.add(new English("1", "Thì hiện tại đơn", "S + V(s/es) + O"));
        EnglishList.add(new English("2", "Thì hiện tại tiếp diễn", " S + am/is/are + V_ing"));
        EnglishList.add(new English("3", "Thì hiện tại hoàn thành", " S + have/has + V3/ed + O"));
        EnglishList.add(new English("4", "Thì hiện tại hoàn thành tiếp diễn", "  S + have/has + been + V_ing"));
        EnglishList.add(new English("5", "Thì quá khứ đơn", "S + V2/V-ed + 0"));
        EnglishList.add(new English("6", "Thì quá khứ tiếp diễn", "S + was/were + V-ing + 0"));
        EnglishList.add(new English("7", "Thì quá khứ hoàn thành", "S + had + V3/ed + 0"));
        EnglishList.add(new English("8", "Thì quá khứ hoàn thành tiếp diễn", "S + had been + V_ing + O"));
        EnglishList.add(new English("9", "Thì tương lai đơn", "S + will + V + 0"));
        EnglishList.add(new English("10", "Thì tương lai hoàn thành", "S + shall/will + have + V3/ed"));
        EnglishList.add(new English("11", "Thì tương lai tiếp diễn", " S + will/shall + be + V-ing"));
        EnglishList.add(new English("12", "Thì tương lai hoàn thành tiếp diễn", "  S + will/shall + have been + V_ing"));

        adapter = new EnglishAdapter(this, R.layout.row, EnglishList);
        lvEnglish.setAdapter(adapter);

        lvEnglish.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("data", EnglishList.get(i));
                startActivity(intent);
            }
        });
    }

    private void anhXa() {
        lvEnglish = findViewById(R.id.lvEnglish);
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}