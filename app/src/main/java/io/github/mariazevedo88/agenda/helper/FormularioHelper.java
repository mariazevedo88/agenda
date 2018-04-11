package io.github.mariazevedo88.agenda.helper;

import android.widget.EditText;
import android.widget.RatingBar;

import io.github.mariazevedo88.agenda.FormularioActivity;
import io.github.mariazevedo88.agenda.R;
import io.github.mariazevedo88.agenda.modelo.Contato;

/**
 * @author Mariana Azevedo
 * @since 10/04/2018
 */
public class FormularioHelper {

    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoTelefone;
    private EditText campoSite;
    private Contato contato;

    public FormularioHelper(FormularioActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoSite = (EditText) activity.findViewById(R.id.formulario_site);

        contato = new Contato();
    }

    public Contato pegaAluno()   {

        contato.setNome(campoNome.getText().toString());
        contato.setEndereco(campoEndereco.getText().toString());
        contato.setTelefone(campoTelefone.getText().toString());
        contato.setSite(campoSite.getText().toString());

        return contato;
    }

    public void preencheFormulario(Contato contato)  {
        this.contato = contato;
        campoNome.setText(contato.getNome());
        campoEndereco.setText(contato.getEndereco());
        campoTelefone.setText(contato.getTelefone());
        campoSite.setText(contato.getSite());
    }
}
