package com.thxllez.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

public class Anotacao {

    private Context context;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";

    public Anotacao(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    public void saveAnotacao(String anotacaoValue){
        editor.putString(CHAVE_NOME, anotacaoValue);
        editor.commit();
    }

    public String getAnotacao(){
        return preferences.getString(CHAVE_NOME,"");
    }
}
