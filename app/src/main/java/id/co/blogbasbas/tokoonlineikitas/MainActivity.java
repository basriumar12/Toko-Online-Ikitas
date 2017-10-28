package id.co.blogbasbas.tokoonlineikitas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import id.co.blogbasbas.tokoonlineikitas._sliders.FragmentSlider;
import id.co.blogbasbas.tokoonlineikitas._sliders.SliderIndicator;
import id.co.blogbasbas.tokoonlineikitas._sliders.SliderPagerAdapter;
import id.co.blogbasbas.tokoonlineikitas._sliders.SliderView;
import id.co.blogbasbas.tokoonlineikitas.adapter.RecyclerviewAdapter;

public class MainActivity extends AppCompatActivity {
    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sliderView = (SliderView) findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) findViewById(R.id.pagesContainer);
        setupSlider();

        recyclerView= (RecyclerView) findViewById(R.id.listbarang);
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        //menset setukuran
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));




    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/7f3a65.jpg"));
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/35a4e3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/1de2f4.jpg"));
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/21e559.png"));
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/20f69e.jpg"));
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/9a4f6b.jpg"));
        fragments.add(FragmentSlider.newInstance("http://photouploads.com/images/403295.jpg"));





        mAdapter = new SliderPagerAdapter(getSupportFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(this, mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }
    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" Exit Konfirm");
        builder.setMessage("Apakah  Ingin Keluar ?");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
                moveTaskToBack(true);
            }
        });

        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        builder.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //pilih item menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.mn_about){
           startActivity(new Intent(MainActivity.this, ProfilActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }


}
