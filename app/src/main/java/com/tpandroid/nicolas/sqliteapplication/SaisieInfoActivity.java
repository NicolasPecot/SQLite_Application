package com.tpandroid.nicolas.sqliteapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class SaisieInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saisie_info);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.saisie_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }

    /**
     * Methode appelée sur un clic.
     * Permet d'ajouter un élément présent dans un champ EditText pour l'ajouter dans la base de données.
     * @param v : (View) Element cliqué sur le layout (normalement un bouton)
     */
    public void clic(View v){
        //Recupération de ce qui a été ajouté dansle champ de texte sur le clic du bouton valider
        EditText et = (EditText)findViewById(R.id.edittext);
        String info = et.getText().toString();

        //AJout en base de données
        BDD bdd = new BDD();
        bdd.open(this);
        if (bdd.createInfo(info) > 0) {
            // Si l'élément a été ajouté correctement, on revient à l'activité principale
            finish();
        }
    }
}
