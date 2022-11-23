package gfraisse.ImposeTaSoiree.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import gfraisse.ImposeTaSoiree.Daos.Etudiant;
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
        int a;
        try {
            JSONArray jsona = new JSONArray(s);
            String login;
            String password;
            for (int i = 0; i < jsona.length(); i++) {
                JSONObject jsono = jsono.getJSONObject(i);
                login = jsono.getString("login");
                password = jsono.getString("password");
            }
            if (login = log1,password = pass1){
                a = 1;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (s.("1")){
            Toast.makeText(this, "Authentification Réussie !", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, Soiree.class) ;
            startActivity(intent);
        }else {
            Toast.makeText(this,"Login ou mot de passe non valide !!", Toast.LENGTH_SHORT).show();
        }
    }

}