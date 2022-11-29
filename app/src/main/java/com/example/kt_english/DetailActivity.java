package com.example.kt_english;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kt_english.Model.English;

public class DetailActivity extends AppCompatActivity {
    private TextView txtTenThif, txtCongThuc, txtVidu;
    private EditText edtVidu;
    private Button btnLuuViDu;
    private English English;
    private SharedPreferences sharedPreferences;
    private String listViDuDaLuu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        anhXa();

        Intent intent = getIntent();
        if (intent != null) {
            English = (English) intent.getSerializableExtra("data");
            txtTenThif.setText(English.getTen().toUpperCase());
            txtCongThuc.setText("Công thức: " + English.getCongThuc());
        } sharedPreferences = getSharedPreferences("dataViDu", MODE_PRIVATE);
        listViDuDaLuu = sharedPreferences.getString(English.getId(), "");
        txtVidu.setText(listViDuDaLuu);

        btnLuuViDu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String viDu = edtVidu.getText().toString().trim();

                if(viDu.isEmpty()) {
                    Toast.makeText(DetailActivity.this, "Vui lòng nhập", Toast.LENGTH_SHORT).show();
                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();

                    String viDuMoi = viDu + "\n" + listViDuDaLuu;
                    editor.remove(English.getId());
                    editor.putString(English.getId(), viDuMoi);
                    editor.commit();

                    listViDuDaLuu = viDuMoi;
                    txtVidu.setText(listViDuDaLuu);

                    Toast.makeText(DetailActivity.this, "Thêm ví dụ thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void anhXa() {
        txtVidu = findViewById(R.id.vidudaluu_textview);
        edtVidu = findViewById(R.id.vidu_edittext);
        btnLuuViDu = findViewById(R.id.luuvidu_button);
        txtTenThif = findViewById(R.id.tenthi_textview);
        txtCongThuc = findViewById(R.id.congThuc_textview);
    }
}
