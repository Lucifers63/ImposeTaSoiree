package gfraisse.ImposeTaSoiree.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import gfraisse.ImposeTaSoiree.R;
import gfraisse.ImposeTaSoiree.net.WSConnexionHTTPS;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.Connexion).setOnClickListener(v->{
            WSConnexionHTTPS ws = new WSConnexionHTTPS(){
                @Override
                protected void onPostExecute(String s){traiterConnexion(s);}
            };
            ws.execute("requete=connexion&login="+((TextView)findViewById(R.id.log1)).getText().toString()+"&password="+((TextView)findViewById(R.id.Pass1)).getText().toString());
        });
        findViewById(R.id.Inscrip).setOnClickListener(v->{
            Intent intent = new Intent(this, Inscription.class) ;
            startActivity(intent);
        });
    }

    private void traiterConnexion(String s) {
        Log.d("TraiterConnexion",s);
        try {
            JSONObject jsono = new JSONObject(s);
            if ((Boolean) jsono.get("success")){
                Toast.makeText(this, "Authentification Réussie !", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Soiree.class) ;
                startActivity(intent);
            }else {
                Toast.makeText(this,"Login ou mot de passe non valide !!", Toast.LENGTH_SHORT).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}