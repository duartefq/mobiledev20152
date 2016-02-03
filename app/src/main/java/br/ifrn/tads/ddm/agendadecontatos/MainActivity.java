package br.ifrn.tads.ddm.agendadecontatos;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNome;
    private EditText editTextFone;

    private Button buttonInserir;
    private Button buttonEditar;
    private Button buttonExcluir;

    private BlankFragment myFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextFone = (EditText) findViewById(R.id.editTextFone);

        buttonInserir = (Button) findViewById(R.id.buttonInserir);
        buttonEditar = (Button) findViewById(R.id.buttonEditar);
        buttonExcluir = (Button) findViewById(R.id.buttonExcluir);

        Object frag = findViewById(R.id.contato_fragment);

        try {
            myFragment = (BlankFragment) frag;
        } catch (Exception e) {
            e.printStackTrace();
        }


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void buttonClick(View v) {
        if (v.equals(buttonInserir)) {
            myFragment.inserir(
                    this.editTextNome.getText().toString(),
                    this.editTextFone.getText().toString()
            );

        }

        if (v.equals(buttonEditar)) {
            myFragment.editar(
                    this.editTextNome.getText().toString(),
                    this.editTextFone.getText().toString()
            );

        }

        if (v.equals(buttonExcluir)) {
            myFragment.excluir(
                    this.editTextNome.getText().toString()
            );
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
