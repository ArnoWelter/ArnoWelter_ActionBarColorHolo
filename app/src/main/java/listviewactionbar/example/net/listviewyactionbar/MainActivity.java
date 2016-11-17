package listviewactionbar.example.net.listviewyactionbar;

import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends ListActivity {

    int longitud = 6;

    private static final String[] items = {"En", "un", "lugar", "de",
            "la", "Mancha", "de", "cuyo", "nombre", "no", "quiero",
            "acordarme", "no", "ha", "mucho", "tiempo", "que",
            "vivía", "un", "hidalgo", "de", "los", "de", "lanza",
            "en", "astillero", "adarga", "antigua", "rocín", "flaco",
            "y", "galgo", "corredor"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, Arrays.copyOf(items, longitud)
        );
        setListAdapter(arrayAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menu){
        ArrayAdapter<String> arrayAdapter;
        switch (menu.getItemId()){
            case R.id.anyadir:
                longitud++;
                if(longitud > items.length)
                    longitud = items.length;
                arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrays.copyOf(items, longitud));
                    setListAdapter(arrayAdapter);
                break;

            case R.id.reset:
                longitud = 6;
                arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Arrays.copyOf(items, longitud));
                setListAdapter(arrayAdapter);
                break;

            case R.id.acercade:
                Toast.makeText(this, getText(R.string.textoAcerdaDe), Toast.LENGTH_LONG).show();
                break;
        }

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return(super.onCreateOptionsMenu(menu));
    }

}
