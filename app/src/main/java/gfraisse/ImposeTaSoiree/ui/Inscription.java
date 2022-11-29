package gfraisse.ImposeTaSoiree.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import gfraisse.ImposeTaSoiree.R;
import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

public class Inscription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);


        ((Button) findViewById(R.id.ValideInscrip)).setOnClickListener(view ->
        {
            WSConnexionHTTPS ws = new WSConnexionHTTPS(){
                @Override
                public void onPostExecute(String s){TraiterInscrip(s);}
            };
            ws.execute("requete=creerCompte&login="+((TextView)findViewById(R.id.a)).getText().toString()+
                    "&nom="+((TextView)findViewById(R.id.c)).getText().toString()+
                    "&prenom=" +((TextView)findViewById(R.id.d)).getText().toString()+
                    "&ddn=" +((TextView)findViewById(R.id.e)).getText().toString()+
                    "&mail=" +((TextView)findViewById(R.id.f)).getText().toString()+
                    "&password="+((TextView)findViewById(R.id.b)).getText().toString());
        });

        ((Button) findViewById(R.id.backTo)).setOnClickListener(view ->  finish());
    }

    private void TraiterInscrip(String s) {
        Log.d("traiterInscrip",s);
        try {
            JSONObject jsono = new JSONObject(s);
            if ((Boolean)jsono.get("success")){
                Toast.makeText(this, "Inscription Réussie !", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this,"Login déjà utilisé !", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}