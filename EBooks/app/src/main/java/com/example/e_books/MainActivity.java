package com.example.e_books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.e_books.Adapter.ShowRCAdapter;
import com.example.e_books.Adapter.adapterTruyen;
import com.example.e_books.Adapter.adapterlistTruyen;
import com.example.e_books.Adapter.adapter_info;
import com.example.e_books.Adapter.adapterItem;
import com.example.e_books.Adapter.miniListAdapter;
import com.example.e_books.Database.DatabaseEBooks;
import com.example.e_books.Interface.Icclickitemminitruyen;
import com.example.e_books.Interface.IclickItemtruyen;
import com.example.e_books.Model.Itemprofile;
import com.example.e_books.Model.Taikhoan;
import com.example.e_books.Model.Truyen;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView,listViewinfo,listViewmain,listviewL1;
    TextView tvinfonam,tvinfonoidung;
    Button btread;
    String email;
    String tentaikhoan;
    ArrayList<Truyen> TruyenArrayList;
    List<Truyen> ttruyenlist;
    adapter_info adapter_Info;
    adapterItem adapteritem;
    Toolbar toolbar;
    DrawerLayout dr;
    ImageView imgdetail,btyeuthich;
    private RecyclerView rcvTruyen,minitruyen;
    ShowRCAdapter SRCadapter;
    miniListAdapter miniListAdapter;
    adapterlistTruyen adtlisttruyen;
    DatabaseEBooks databaseEBooks;
    ArrayList<Itemprofile> itemprofileArrayList;
    ArrayList<Taikhoan> taikhoanArrayList;
    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
    String nametruyeninfo;
    String noidungtruyeninfo;
    String anhinfo;
    int idtaikhoan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseEBooks=new DatabaseEBooks(this);
        Intent intentpq=getIntent();
        int ii= intentpq.getIntExtra("phanq",0);
        idtaikhoan=intentpq.getIntExtra("ID",0);
        email=intentpq.getStringExtra("email");
        tentaikhoan=intentpq.getStringExtra("tentaikhoan");
        Anhxa();
        ActionBar();
        ImageSlider imageSlider;

        imageSlider =findViewById(R.id.image_slider);

        ArrayList<SlideModel> imageList = new ArrayList<>();

        imageList.add(new SlideModel(R.drawable.img1_6,null));
        imageList.add(new SlideModel(R.drawable.img1_7,null));
        imageList.add(new SlideModel(R.drawable.img1_8,null));
        imageList.add(new SlideModel(R.drawable.img1_9,null));

        imageSlider.setImageList(imageList);
        itemprofileArrayList=new ArrayList<>();
        if(ii==1) {
        itemprofileArrayList.add(new Itemprofile("Đăng xuất"));
            listViewmain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                   if(i== 0){
                        finish();
                    }
                }
            });
        }
        if (ii==2){
            itemprofileArrayList.add(new Itemprofile("Thêm truyện"));
            itemprofileArrayList.add(new Itemprofile("Đăng xuất"));
            listViewmain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i == 0) {
                        Intent intent = new Intent(MainActivity.this,Admin_Activity.class);
                        intent.putExtra("ID",idtaikhoan);
                        startActivity(intent);
                    }
                    else if(i== 1){
                        finish();
                    }
                }
            });
        }
        adapteritem= new adapterItem(this,R.layout.item,itemprofileArrayList);
        listViewmain.setAdapter(adapteritem);
        //info detail truyen minilist
//        Bundle bundle=getIntent().getExtras();
//        if(bundle==null){
//            return;
//        }
        btread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Noidunglistview.class);
                intent.putExtra("tentruyen",nametruyeninfo);
                intent.putExtra("noidung",noidungtruyeninfo);
                intent.putExtra("ID",idtaikhoan);
                intent.putExtra("ttkname",tentaikhoan);
                startActivity(intent);
            }
        });
    }

    public void Mainsearch(View view) {
        Intent intent=new Intent(MainActivity.this, Mainsearch.class);
        intent.putExtra("ID",idtaikhoan);
        startActivity(intent);
        intent.putExtra("ttkname",tentaikhoan);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
    public void yeuthich(View view){
        Intent intent=new Intent(MainActivity.this,MainYeuthich.class);
        intent.putExtra("ID",idtaikhoan);
        startActivity(intent);
    }
    public void Mainprofile(View v){
        Intent intent=new Intent(MainActivity.this,MainProfile.class);
        intent.putExtra("email",email);
        intent.putExtra("idmain",tentaikhoan);
        intent.putExtra("ID",idtaikhoan);

        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dr.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        btyeuthich=findViewById(R.id.btyeuthich);
        btread=findViewById(R.id.btread);
        tvinfonam=findViewById(R.id.tvinfoname);
        tvinfonoidung=findViewById(R.id.tvinfonoidung);
//        listView=findViewById(R.id.listview);
        listViewinfo=findViewById(R.id.listviewinfo);
        listViewmain=findViewById(R.id.listviewmain);
        minitruyen=findViewById(R.id.rcvlevel1);
        toolbar=findViewById(R.id.tutruyen);
        imgdetail=findViewById(R.id.imvdetail);
        dr=findViewById(R.id.draw1);
        rcvTruyen=findViewById(R.id.rclist);
//        listviewL1=findViewById(R.id.listviewL1);
        TruyenArrayList=new ArrayList<>();
        Cursor cursor1=databaseEBooks.getDatal();
        while (cursor1.moveToNext()){
            int id=cursor1.getInt(0);
            String tentruyen=cursor1.getString(1);
            String noidung=cursor1.getString(2);
            String anh=cursor1.getString(3);
            int id_tk=cursor1.getInt(4);
            //duyetmini info
            tvinfonam.setText(tentruyen);
            tvinfonoidung.setText(noidung);
            Picasso.get().load(anh).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(imgdetail);
            tvinfonoidung.setMovementMethod(new ScrollingMovementMethod());
            TruyenArrayList.add(new Truyen(id,tentruyen,noidung,anh,id_tk));
            miniListAdapter=new miniListAdapter(TruyenArrayList, getApplicationContext(), new Icclickitemminitruyen() {
                @Override
                public void onclickitemminitruyen(Truyen truyen) {
                    onclickgopic(truyen);
                }
            });
//            adapterTruyen=new adapterTruyen(getApplicationContext(),TruyenArrayList);
//=================List show truyện =============================
//            listView.setAdapter(adapterTruyen);
            rcvTruyen.setHasFixedSize(true);
            SRCadapter= new ShowRCAdapter(TruyenArrayList, getApplicationContext(), new IclickItemtruyen() {
                @Override
                public void onlickitemtruyen(Truyen truyen) {
                    onclickgotonoidung(truyen);
                }
            });
            //cuộn ngang dọc
//            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//            rcvTruyen.setLayoutManager(linearLayoutManager);
//            rcvTruyen.setAdapter(SRCadapter);
            //lưới
            GridLayoutManager gridLayoutManager=new GridLayoutManager(this,3);
            gridLayoutManager.setOrientation(gridLayoutManager.VERTICAL);
            rcvTruyen.setLayoutManager(gridLayoutManager);
            rcvTruyen.setAdapter(SRCadapter);
//===================List Showmini truyện =================================================
            minitruyen.setHasFixedSize(true);
            GridLayoutManager gridLayoutManager1=new GridLayoutManager(this,9);
            gridLayoutManager1.setOrientation(gridLayoutManager1.VERTICAL);
            minitruyen.setLayoutManager(gridLayoutManager1);
            minitruyen.setAdapter(miniListAdapter);

        }
        cursor1.moveToFirst();
        cursor1.close();

        //item thông tin
        taikhoanArrayList=new ArrayList<>();
        taikhoanArrayList.add(new Taikhoan(idtaikhoan,tentaikhoan,email));

       adapter_Info=new adapter_info(this,R.layout.nv_profile,taikhoanArrayList);
       listViewinfo.setAdapter(adapter_Info);
       //item
        itemprofileArrayList=new ArrayList<>();

        itemprofileArrayList.add(new Itemprofile("Đăng bài"));
        itemprofileArrayList.add(new Itemprofile("Tất cả truyện"));
        itemprofileArrayList.add(new Itemprofile("Đăng xuất"));
        adapteritem= new adapterItem(this,R.layout.item,itemprofileArrayList);
        listViewmain.setAdapter(adapteritem);

    }
    private void onclickgotonoidung(Truyen truyen){
        Intent intent =new Intent(this, NoidungActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("object_truyen",truyen);
        intent.putExtras(bundle);
        intent.putExtra("ID",idtaikhoan);
        this.startActivity(intent);
    }
    private void onclickgopic(Truyen truyen){
        nametruyeninfo= truyen.getTtentruyen();
        noidungtruyeninfo=truyen.getTnoidung();
        String img=truyen.getTimg();
        tvinfonoidung.setText(noidungtruyeninfo);
        tvinfonam.setText(nametruyeninfo);
        Picasso.get().load(img).placeholder(R.drawable.ic_loat).error(R.drawable.ic_img).into(imgdetail);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menui:
                Intent intent = new Intent(MainActivity.this,MainTim.class);
                intent.putExtra("ID",idtaikhoan);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void slidehoz1(View v){
        imgdetail.setImageResource(R.drawable.ic_search);
    }
    public void slidehoz2(View v){
        imgdetail.setImageResource(R.drawable.ic_search);
    }
    public void slidehoz3(View v){
        imgdetail.setImageResource(R.drawable.ic_search);
    }
    public void slidehoz4(View v){
        imgdetail.setImageResource(R.drawable.ic_search);
    }
    public void slidehoz5(View v){
        imgdetail.setImageResource(R.drawable.ic_search);
    }
}