package gfraisse.ImposeTaSoiree.ui;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

import gfraisse.ImposeTaSoiree.R;

public class SoireeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soiree);

        findViewById(R.id.Deconnexion).setOnClickListener(v ->{
            WSConnexionHTTPS ws = new WSConnexionHTTPS(){
                @Override
                protected void onPostExecute(String s){traiterDeconnexion(s);}
            };
            ws.execute("requete=deconnexion");

        });
         
    }

    private void traiterDeconnexion(String s) {
        Log.d("TraiterDeconnexion", s);
        try {
            JSONObject jsono = new JSONObject(s);
            if ((boolean) jsono.get("success")){
                Toast.makeText(this, "Deconnexion Réussie ! ", Toast.LENGTH_SHORT).show();
                finish();
            }else  {
                Toast.makeText(this, "La deconnexion n'a pas pu être effectuer !", Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}