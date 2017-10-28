package id.co.blogbasbas.tokoonlineikitas;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import butterknife.ButterKnife;

public class CobaActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coba);
        ButterKnife.bind(this);
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.tampildatapembeli ,null);
        final TextView txtNama = (TextView)v.findViewById(R.id.namadaripembeli);
        final TextView txtAlamat = (TextView)v.findViewById(R.id.nalamatdaripembeli);

        AlertDialog.Builder builder = new AlertDialog.Builder(CobaActivity.this);
        builder.setView(v);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(CobaActivity.this, MainActivity.class));
                finish();
            }
        });
        builder.show();
        //memgambil data activity
        Intent intentterima = getIntent();
        txtNama.setText(intentterima.getStringExtra("US"));
        txtAlamat.setText(intentterima.getStringExtra("AL"));
    }


    }


