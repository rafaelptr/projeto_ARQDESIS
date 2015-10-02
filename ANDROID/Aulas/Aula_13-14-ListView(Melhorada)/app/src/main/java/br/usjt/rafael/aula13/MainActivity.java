package br.usjt.rafael.aula13;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Date;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    EditText dataTextInput;

    Button btnConsultar;
    String origem,destino, data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();

    }

    private void setupViews() {
        origem = "";
        destino = "";
        data = "";
        btnConsultar = (Button) findViewById(R.id.botao_enviar);
        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionado());
        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionada());
        dataTextInput = (EditText) findViewById(R.id.dataText);

    }

    private class OrigemSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            origem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            destino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar a mensagem
    public final static String ORIGEM = "br.usjt.rafael.aula13.ORIGEM";
    public final static String DESTINO = "br.usjt.rafael.aula13.DESTINO";
    public final static String DATA = "br.usjt.rafael.aula13.DATA";
    public final static String MODO = "br.usjt.rafael.aula13.MODO";
    public final static String SIMPLES = "br.usjt.rafael.aula13.SIMPLES";
    public final static String MELHOR = "br.usjt.rafael.aula13.MELHOR";
    //será chamado quando o usuário clicar em enviar
    public void consultarVoos(View view) {
        consultar(view, SIMPLES);
    }

    public void consultarVoosMelhor(View view) {
        consultar(view, MELHOR);
    }

    private String anoAjuste(String ano){
        if(ano.length() == 3)return  "0"+ano;
        if(ano.length() == 2)return  "00"+ano;
        if(ano.length() == 1)return  "000"+ano;
        return ano;
    }
    public void consultar(View view, String modo){
        String passarOrigem = this.origem.equals("Escolha um aeroporto")?"":origem;
        String passarDestino = this.destino.equals("Escolha um aeroporto")?"":destino;
        int l = dataTextInput.length();
        String  passarData = dataTextInput.getText().toString();

        Intent intent = new Intent(this, ListaVooActivity.class);
        intent.putExtra(ORIGEM, passarOrigem);
        intent.putExtra(DESTINO, passarDestino);
        intent.putExtra(DATA, passarData);
        intent.putExtra(MODO, modo);
        startActivity(intent);
    }

}
