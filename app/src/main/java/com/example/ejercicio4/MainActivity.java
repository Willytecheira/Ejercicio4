package com.example.ejercicio4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String str ="Inicial";
    private ShareActionProvider share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);

        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(onSearch());

        MenuItem shareItem = menu.findItem(R.id.action_search);
        share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        share.setShareIntent(configuraIntent());


        return true;
    }

    private Intent configuraIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*"); //buscar por MINE
        intent.putExtra(Intent.EXTRA_TEXT, "Texto para Compartir");
        return intent;
    }

    private SearchView.OnQueryTextListener onSearch(){
        return new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                str = s;
                share.setShareIntent(configuraIntent());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // cuando el texto se search view es modificado
                return false;
            }
        };
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Toast.makeText(getApplicationContext(), "Buscar", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.action_refresh) {
            Toast.makeText(getApplicationContext(), "Actualizar", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Configuración", Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }
}