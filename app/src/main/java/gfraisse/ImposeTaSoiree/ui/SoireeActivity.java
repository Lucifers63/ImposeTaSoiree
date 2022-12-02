package gfraisse.ImposeTaSoiree.ui;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import gfraisse.ImposeTaSoiree.Daos.Soiree;
import gfraisse.ImposeTaSoiree.R;
import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

public class SoireeActivity extends AppCompatActivity {
    public static List<Soiree> soireeList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soiree);
        createListSoiree();
        findViewById(R.id.Deconnexion).setOnClickListener(v -> {
            WSConnexionHTTPS ws = new WSConnexionHTTPS() {
                @Override
                protected void onPostExecute(String s) {
                    traiterDeconnexion(s);
                }
            };
            ws.execute("requete=deconnexion");

        });
        findViewById(R.id.SuprCompte).setOnClickListener(v -> {
            WSConnexionHTTPS ws = new WSConnexionHTTPS() {
                @Override
                protected void onPostExecute(String s) {
                    traiterSupression(s);
                }
            };
            ws.execute("requete=supprimerCompte");
        });
        findViewById(R.id.AjtSoiree).setOnClickListener(v -> {
            Intent intent = new Intent(this, AjtSoiree.class);
            startActivity(intent);
        });
        ((ListView)findViewById(R.id.LvSoiree)).setOnItemClickListener((adapterView, view, i, l )->{
            Intent intent = new Intent(this, InscripSoiree.class);
            intent.putExtra("i",i);
            startActivity((intent));
        });
        findViewById(R.id.gestionSoiree).setOnClickListener(v -> {
            Intent intent = new Intent(this, GestionSoiree.class);
            startActivity(intent);
        });
    }

    private void createListSoiree() {
        WSConnexionHTTPS ws = new WSConnexionHTTPS() {
            @Override
            protected void onPostExecute(String s) {
                traiterGetSoiree(s);
            }
        };
        ws.execute("requete=getLesSoirees");
    }

    private void traiterGetSoiree(String s) {
        Log.d("TraiterGetSoiree",s);
        soireeList = new ArrayList<>();
        try {
            JSONObject jsono = new JSONObject(s);
            if ((boolean) jsono.get("success")) {
                Toast.makeText(this, "Supression du compte effectuer !", Toast.LENGTH_SHORT).show();

                JSONArray jsona = new JSONArray(jsono.getString("response"));
                for (int i = 0; i < jsona.length(); i++) {
                    JSONObject jsonob = jsona.getJSONObject(i);
                    int id = jsonob.getInt("id");
                    String libelleCourt = jsonob.getString("libelleCourt");
                    String descriptif = jsonob.getString("descriptif");
                    String dateDebut = jsonob.getString("dateDebut");
                    String heureDebut = jsonob.getString("heureDebut");
                    String Adr = jsonob.getString("adresse");
                    String lat = jsonob.getString("latitude");
                    String lng = jsonob.getString("longitude");
                    String login = jsonob.getString("login");
                    Soiree so = new Soiree(id, libelleCourt, descriptif, dateDebut, heureDebut, Adr, lat, lng, login);
                    soireeList.add(so);
                }ArrayAdapter adapt = new ArrayAdapter<>(
                        this, android.R.layout.simple_list_item_1, soireeList);
                ((ListView)findViewById(R.id.LvSoiree)).setAdapter(adapt);
                adapt.notifyDataSetChanged();

            } else {
                Toast.makeText(this, "La Supression n'a pas pu être effectuer !", Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void traiterSupression(String s) {
        Log.d("TraiterSupression", s);
        try {
            JSONObject jsono = new JSONObject(s);
            if ((boolean) jsono.get("success")) {
                Toast.makeText(this, "Supression du compte effectuer !", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "La Supression n'a pas pu être effectuer !", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void traiterDeconnexion(String s) {
        Log.d("TraiterDeconnexion", s);
        try {
            JSONObject jsono = new JSONObject(s);
            if ((boolean) jsono.get("success")) {
                Toast.makeText(this, "Deconnexion Réussie ! ", Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "La deconnexion n'a pas pu être effectuer !", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}