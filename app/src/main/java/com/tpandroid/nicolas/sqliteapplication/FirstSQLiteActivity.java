package com.tpandroid.nicolas.sqliteapplication;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class FirstSQLiteActivity extends ListActivity {

    public BDD mabase;
    public Cursor cListeInfos;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_activity_layout);
        mabase = new BDD();
        mabase.open(this);
        cListeInfos = mabase.getInfos();
        startManagingCursor(cListeInfos);
        //CursorLoader cl = new CursorLoader(this); Nécessite l'implémentation de LoaderManager
       //cl.deliverResult(cListeInfos);
        //cListeInfos.requery();
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
                cListeInfos, new String[] {"info"}, new int[] {android.R.id.text1},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        setListAdapter(adapter);
        intent = new Intent(this, SaisieInfoActivity.class);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Log.i("click item", String.valueOf(id));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.first_sqlite, menu);
        return true;
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_optionsmenu, menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.menu_creerinfo){
            Log.i("Tuto", "on va créer une info");
            startActivity(intent);
        }
        return  super.onOptionsItemSelected(item);//id == R.id.action_settings ||
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //cListeInfos.requery();
    }
}
