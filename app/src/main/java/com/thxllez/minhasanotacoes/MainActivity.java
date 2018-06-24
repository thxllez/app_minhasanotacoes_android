package com.thxllez.minhasanotacoes;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Anotacao anot;
    private EditText editAnotacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anot = new Anotacao(getApplicationContext());
        editAnotacao = findViewById(R.id.editAnotacao);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String anotacaoRecuperada = editAnotacao.getText().toString();
                if(anotacaoRecuperada.equals("")){
                    Snackbar.make(v, "Preencha a anotação!", Snackbar.LENGTH_LONG).show();
                }else{
                    anot.saveAnotacao(anotacaoRecuperada);
                    Snackbar.make(v, "Anotação salva com sucesso!", Snackbar.LENGTH_LONG).show();
                }
            }
        });

        String anotacao = anot.getAnotacao();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }
    }

}
