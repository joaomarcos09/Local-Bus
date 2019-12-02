package br.ufc.crateus.localbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static br.ufc.crateus.localbus.R.id.tvEmailUsu;

public class PrincipalActivity extends AppCompatActivity

        implements NavigationView.OnNavigationItemSelectedListener {
    TextView tvNomeUsu;
    TextView tvEmailUsu;
    TextView tvNoti;
    Button btLocalizacao;
    RecyclerView rcNoticacoes;
    UserModel usuario = new UserModel();
    Bundle dados = new Bundle();
    String nomeUsu;
    String emailUsu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        btLocalizacao = (Button) findViewById(R.id.btLocalizacao);
        tvNoti = (TextView) findViewById(R.id.tvNoti);
        rcNoticacoes = (RecyclerView) findViewById(R.id.rcNotificacoes);

        Intent intent = getIntent();

        dados = intent.getExtras();


        if(dados != null) {
         nomeUsu = dados.getString("nome");
         emailUsu = dados.getString("email");
            Toast.makeText(PrincipalActivity.this, emailUsu, Toast.LENGTH_SHORT).show();
            Log.i("nome do usuario", nomeUsu);
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PrincipalActivity.this, BatePapoActivity.class);
                i.putExtras(dados);
                startActivity(i);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        tvNomeUsu = (TextView) findViewById(R.id.tvNomeUsu);
        tvEmailUsu = (TextView) findViewById(R.id.tvEmailUsu);
        tvNomeUsu.setText(nomeUsu);
        tvEmailUsu.setText(emailUsu);
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(PrincipalActivity.this, ConfiguracoesActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent mapa = new Intent(PrincipalActivity.this, MapsActivity2.class);
            startActivity(mapa);
        }/* else if (id == R.id.nav_gallery) {
            Intent dados = new Intent(PrincipalActivity.this, DadosActivity.class);
            dados.putExtras(dados);
            startActivity(dados);
        }*/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
