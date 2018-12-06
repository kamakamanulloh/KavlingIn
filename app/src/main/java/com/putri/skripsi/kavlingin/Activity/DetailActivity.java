package com.putri.skripsi.kavlingin.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;
import com.putri.skripsi.kavlingin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends Activity {

    @BindView(R.id.location)
    FloatingActionButton location;
    @BindView(R.id.chat)
    FloatingActionButton chat;
    @BindView(R.id.setting)
    FloatingActionButton setting;
    @BindView(R.id.fab_menu)
    FloatingActionMenu fabMenu;
    String goolgeMap = "com.google.android.apps.maps";
    Uri gmmIntentUri;
    Intent mapIntent;
    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.txtjudul)
    TextView txtjudul;

    @BindView(R.id.txtdeskripsi)
    TextView txtdeskripsi;
    @BindView(R.id.txtowner)
    TextView txtowner;
    @BindView(R.id.tvharga)
    TextView tvharga;
    @BindView(R.id.tvalamat)
    TextView tvalamat;
    @BindView(R.id.addfav)
    FloatingActionButton addfav;
    @BindView(R.id.sv)
    ScrollView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        mapIntent = getIntent();

        Glide.with(this)
                .load(mapIntent.getStringExtra("gambar"))


                .into(iv);

        txtjudul.setText(mapIntent.getStringExtra("title"));
        txtowner.setText("Penjual : " + mapIntent.getStringExtra("id_user"));
        txtdeskripsi.setText(mapIntent.getStringExtra("deskripsi"));
        tvharga.setText(mapIntent.getStringExtra("harga"));
        tvalamat.setText(mapIntent.getStringExtra("alamat"));

    }

    @OnClick({R.id.location, R.id.chat, R.id.setting, R.id.fab_menu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.location:
                // Buat Uri dari intent string. Gunakan hasilnya untuk membuat Intent.
                gmmIntentUri = Uri.parse("google.navigation:q=" + mapIntent.getStringExtra("lat") + "," + mapIntent.getStringExtra("lng"));

                // Buat Uri dari intent gmmIntentUri. Set action => ACTION_VIEW
                mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

                // Set package Google Maps untuk tujuan aplikasi yang di Intent yaitu google maps
                mapIntent.setPackage(goolgeMap);

                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);
                } else {
                    Toast.makeText(DetailActivity.this, "Google Maps Belum Terinstal. Install Terlebih dahulu.",
                            Toast.LENGTH_LONG).show();
                }


                break;
            case R.id.chat:

//                Intent kirimWA = new Intent(Intent.ACTION_SEND);
//                kirimWA.setType("text/plain");
//                kirimWA.putExtra(Intent.EXTRA_TEXT, "tes");
//                kirimWA.putExtra("jid", "089682428590" + "@s.whatsapp.net");
//                kirimWA.setPackage("com.whatsapp");
//
//                startActivity(kirimWA);
                onClickWhatsApp(view);
                break;
            case R.id.setting:
                String phoneNo = mapIntent.getStringExtra("nohp");
                String dial = "tel:" + phoneNo;
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
                break;
            case R.id.fab_menu:
                break;
            case R.id.addfav:
                break;


        }
    }


    public void onClickWhatsApp(View view) {

        PackageManager pm = getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            waIntent.setType("text/plain");
            String text = "YOUR TEXT HERE";

            PackageInfo info = pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

    }
}
