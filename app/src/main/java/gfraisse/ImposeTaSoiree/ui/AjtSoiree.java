package gfraisse.ImposeTaSoiree.ui;

import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import gfraisse.ImposeTaSoiree.R;
import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

public class AjtSoiree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajt_soiree);

        ((Button) findViewById(R.id.RetourAccueil)).setOnClickListener(view -> finish());

        ((Button) findViewById(R.id.ValidSoiree)).setOnClickListener(view -> {
            WSConnexionHTTPS ws = new WSConnexionHTTPS(){
                @Override
                public void onPostExecute(String s) {
                    TraiterValideSoiree(s);
                }
            };
            ws.execute("requete=addSoiree&" +
                    "libelleCourt="+((TextView)findViewById(R.id.LibCourt)).getText().toString() +
                    "&descriptif="+ ((TextView)findViewById(R.id.Descript)).getText().toString()+
                    "&dateDebut=" +((TextView)findViewById(R.id.DateSoiree)).getText().toString()+
                    "&heureDebut="+((TextView)findViewById(R.id.HeureSoiree)).getText().toString() +
                    "&adresse=" +((TextView)findViewById(R.id.adr)).getText().toString());
        });
    }

    private void TraiterValideSoiree(String s) {
        Log.d("TraiterValideSoiree",s);
        try {
            JSONObject jsono = new JSONObject(s);
            if ((Boolean)jsono.get("success")){
                Toast.makeText(this, "Ajout de la Soirée Réussie !", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this,"Soirée non valide !", Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}