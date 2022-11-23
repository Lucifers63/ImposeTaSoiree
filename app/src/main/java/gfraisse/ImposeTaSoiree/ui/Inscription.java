package gfraisse.ImposeTaSoiree.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import gfraisse.ImposeTaSoiree.Daos.Etudiant;
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
                public void onPostExecute(String s){
                    boolean wsRet = Etudiant.
                }
            }
            String Login = ((TextView)findViewById(R.id.a)).getText().toString();
            String password = ((TextView)findViewById(R.id.b)).getText().toString();
            String Nom = ((TextView)findViewById(R.id.c)).getText().toString();
            String prenom = ((TextView)findViewById(R.id.d)).getText().toString();
            String DDN = ((TextView)findViewById(R.id.e)).getText().toString();
            String Mail = ((TextView)findViewById(R.id.f)).getText().toString();
        });

        ((Button) findViewById(R.id.backTo)).setOnClickListener(view ->  finish());
    }
}