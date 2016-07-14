package bennucybercafe.com.ve.simulador4.vista;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import bennucybercafe.com.ve.simulador4.R;
import bennucybercafe.com.ve.simulador4.modelo.RangoMinimoMaximo;

public class ActividadPrincipal extends AppCompatActivity implements RangoFragment.OnListFragmentInteractionListener, View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);

        Toolbar toolBar = (Toolbar) findViewById(R.id.mi_toolbar);
        setSupportActionBar( toolBar );
        getSupportActionBar().setTitle( R.string.tb_titulo );
        getSupportActionBar().setIcon(R.drawable.ic_icono);

        Button botonFragmento = (Button) findViewById(R.id.botonCargaFragmento);

        botonFragmento.setOnClickListener( this );

    }


    @Override
    public void onListFragmentInteraction( RangoMinimoMaximo item)
    {

        Toast.makeText(this, "Elemento " + item.getId() + " presionado",Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v)
    {
        if (v.getId() == R.id.botonCargaFragmento) {
            FragmentManager fragmentManager = getFragmentManager();

            FragmentTransaction transaccion = fragmentManager.beginTransaction();

            RangoFragment miFragmento = RangoFragment.newInstance(1);


            transaccion.replace(R.id.contenedorFragment, miFragmento );

            transaccion.commit();

            Toast.makeText(this, "Fragmento reemplazado", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate( R.menu.main_menu, menu );
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch ( item.getItemId() )
        {
            case R.id.action_agregar:
                Toast.makeText(ActividadPrincipal.this, "Agregar elemento", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_borrar_todos:
                Toast.makeText(ActividadPrincipal.this, "Borror todos los elementos", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }


}
