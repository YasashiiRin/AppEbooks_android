package com.example.e_books;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Model.Truyen;
import com.example.e_books.Model.TruyenYT;

public class NoidungActivity extends AppCompatActivity {
    TextView txtTenTruyen,txtNoidung;
    Button btyeuthich;
    DatabaseEBooks databaseEBooks;
    String nameinfo;
    String noidunginfo;
    String imginfo;
    //var
    int idtaikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noidung);
        databaseEBooks= new DatabaseEBooks(this);
        txtNoidung = findViewById(R.id.NoiDung);
        txtTenTruyen = findViewById(R.id.TenTruyen);
        btyeuthich=findViewById(R.id.bthemyt);
        Bundle bundle=getIntent().getExtras();
         if(bundle==null){
             return;
         }
        Truyen truyen=(Truyen) bundle.get("object_truyen");
//
//
//        Intent intent = getIntent();
////        String tenTruyen = intent.getStringExtra("tentruyen");
////        String noidung = intent.getStringExtra("noidung");

        txtTenTruyen.setText(truyen.getTtentruyen());
        txtNoidung.setText(truyen.getTnoidung());

        //Cuộn textview
        txtNoidung.setMovementMethod(new ScrollingMovementMethod());
        //get info
        nameinfo=truyen.getTtentruyen();
        noidunginfo=truyen.getTnoidung();
        imginfo=truyen.getTimg();
        //them yeuthich
        btyeuthich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TruyenYT truyenyt = CreatTruyenyt();
                databaseEBooks.AddYeuthich(truyenyt);
                Intent intent = new Intent(NoidungActivity.this,MainYeuthich.class);
                intent.putExtra("ID",idtaikhoan);
                finish();
                startActivity(intent);
                Toast.makeText(NoidungActivity.this,"Thêm truyện thành công",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private TruyenYT CreatTruyenyt(){
        Intent intent = getIntent();
        idtaikhoan=intent.getIntExtra("ID",0);
        TruyenYT truyenyt = new TruyenYT(nameinfo,noidunginfo,imginfo,idtaikhoan);
        return truyenyt;
    }
}