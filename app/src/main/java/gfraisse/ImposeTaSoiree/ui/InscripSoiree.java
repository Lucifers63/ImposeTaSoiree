package gfraisse.ImposeTaSoiree.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import gfraisse.ImposeTaSoiree.Daos.Soiree;
import gfraisse.ImposeTaSoiree.R;
import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

public class InscripSoiree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrip_soiree);
        ((Button) findViewById(R.id.backtolistSoiree)).setOnClickListener(view -> finish());
        Soiree s = SoireeActivity.soireeList.get(getIntent().getIntExtra("i",1));
        ((TextView)findViewById(R.id.TitreSoiree)).setText(s.getLibelleCourt());
        ((TextView)findViewById(R.id.DetailSoiree)).setText(s.getDescriptif());

    }
    private void DetailsSoiree() {
        WSConnexionHTTPS ws = new WSConnexionHTTPS() {
            @Override
            protected void onPostExecute(String s) {
                traitergetDetailSoiree(s);
            }
        };

    }

    private void traitergetDetailSoiree(String s) {

    }
}