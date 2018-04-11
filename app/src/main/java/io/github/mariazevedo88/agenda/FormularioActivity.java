package io.github.mariazevedo88.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import io.github.mariazevedo88.agenda.dao.ContatoDAO;
import io.github.mariazevedo88.agenda.helper.FormularioHelper;
import io.github.mariazevedo88.agenda.modelo.Contato;

/**
 * @author Mariana Azevedo
 * @since 10/04/2018
 */
public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper (this);

        Intent intent = getIntent();
        Contato contato = (Contato)  intent.getSerializableExtra("contato");
        if (contato !=null) {
            helper.preencheFormulario(contato);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Contato contato = helper.pegaAluno();

                ContatoDAO dao = new ContatoDAO(this);

                if (contato.getId() == null)  {
                    dao.insere(contato);
                } else {
                    dao.altera(contato);
                }

                dao.close();

                Toast.makeText(FormularioActivity.this, "Contato " + contato.getNome() + " salvo!", Toast.LENGTH_SHORT).show();

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
