package id.co.blogbasbas.tokoonlineikitas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailItemActivity extends AppCompatActivity {

    @BindView(R.id.imagedetail)
    ImageView imagedetail;
    @BindView(R.id.judulDetail)
    TextView judulDetail;

    @BindView(R.id.hargadetail)
    TextView hargadetail;


    @BindView(R.id.addtochart)
    TextView addtochart;
    @BindView(R.id.buy)
    TextView buy;


    TextView deskripsidetail;

    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item);
          ButterKnife.bind(this);
        deskripsidetail = (TextView) findViewById(R.id.detail);

        Intent getData = getIntent();
        judulDetail.setText("Judul Buku : " +getData.getStringExtra("judul"));
        deskripsidetail.setText("About : " +getData.getStringExtra("desk"));
        hargadetail.setText(getData.getStringExtra("harga"));
        imagedetail.setImageResource(getData.getIntExtra("gmb",0));


        setupToolbar();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(findViewById(R.id.coord_layout), "Contoh Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Click me !!", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
            }
        });

        addtochart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder alert = new AlertDialog.Builder(DetailItemActivity.this);
                alert.setMessage(" Data Berhasil Di add ");
                alert.setIcon(R.mipmap.ic_ok);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                alert.show();

            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nama = (EditText) findViewById(R.id.namaPembeli);
                EditText alamat = (EditText) findViewById(R.id.alamatPembeli);

                String nm = nama.getText().toString() ;
                String al = alamat.getText().toString();

                if (TextUtils.isEmpty(nm.trim())){
                    nama.setError("Nama Tidak Bisa Kosong");
                    nama.requestFocus();

                } else if (TextUtils.isEmpty(al.trim())){
                    alamat.setError("Alamat Tidak Bisa Kosong");
                    alamat.requestFocus();

                }else {
                    Intent kirimdata = new Intent(DetailItemActivity.this, CobaActivity.class);
                    kirimdata.putExtra("US", nm);
                    kirimdata.putExtra("AL", al);
                    startActivity(kirimdata);
                    finish();

                }
            }
        });

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
