package gfraisse.ImposeTaSoiree.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gfraisse.ImposeTaSoiree.Daos.Soiree;
import gfraisse.ImposeTaSoiree.R;
import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

public class GestionSoiree extends AppCompatActivity {
    public static  List<Soiree> soireeList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestion_soiree);
        RecupListMesSoiree();
        ((Button) findViewById(R.id.backToSoi)).setOnClickListener(view -> finish());
        ((ListView)findViewById(R.id.ListMesSoiree)).setOnItemLongClickListener((adapterView, view, i, l) -> {
            Soiree so = soireeList.get(i);
            supprimerSoiree(so);
            return true;
        });
    }

    private void supprimerSoiree(Soiree so) {
        WSConnexionHTTPS ws = new WSConnexionHTTPS() {
            @Override
            protected void onPostExecute(String s) {
                RecupListMesSoiree();
            }
        };
        ws.execute("requete=delSoiree&soiree="+so.getId());
        RecupListMesSoiree();
    }

    private void RecupListMesSoiree() {
        WSConnexionHTTPS ws = new WSConnexionHTTPS() {
            @Override
            protected void onPostExecute(String s) {
                traiterGetSoireeByLogin(s);
            }
        };
        ws.execute("requete=getLesSoirees");
    }

    private void traiterGetSoireeByLogin(String s) {
        soireeList.clear();
        Log.d("TraiterGetSoireebyLoigin",s);
        for (Soiree so : SoireeActivity.soireeList){
            if(MainActivity.login.equalsIgnoreCase(so.getLogin())){
                soireeList.add(so);
            }
        }
        ArrayAdapter adapt = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, soireeList);
        ((ListView)findViewById(R.id.ListMesSoiree)).setAdapter(adapt);
        adapt.notifyDataSetChanged();
    }
}