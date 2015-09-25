package br.usjt.aula11exercicio;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends ActionBarActivity {

    Spinner spinnerOrigem;
    Spinner spinnerDestino;
    EditText dataInput;
    String aeroportoOrigem;
    String aeroportoDestino;
    Button btnOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
    }

    private void setupViews() {
        aeroportoOrigem = "";
        aeroportoDestino = "";

        btnOk = (Button) findViewById(R.id.botao_ok);

        spinnerOrigem = (Spinner) findViewById(R.id.dropdown_origem);
        spinnerOrigem.setOnItemSelectedListener(new OrigemSelecionado());


        spinnerDestino = (Spinner) findViewById(R.id.dropdown_destino);
        spinnerDestino.setOnItemSelectedListener(new DestinoSelecionada());

        dataInput = (EditText) findViewById(R.id.dataText);

    }

    private class OrigemSelecionado implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            aeroportoOrigem = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    private class DestinoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            aeroportoDestino = (String) parent.getItemAtPosition(position);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }

    // constante static para identificar a mensagem
    public final static String ORIGEM = "br.usjt.ORIGEM";
    public final static String DESTINO = "br.usjt.DESTINO";
    public final static String DATA = "br.usjt.DATA";
    //será chamado quando o usuário clicar em enviar
    public void consultarVoos(View view) {

        String passarOrigem = this.aeroportoOrigem.equals("Escolha o aeroporto")?"":aeroportoOrigem;
        String passarDestino = this.aeroportoDestino.equals("Escolha o aeroporto")?"":aeroportoDestino;
        String passarData = this.dataInput.getText().toString();

        Intent intent = new Intent(this, ListaVooActivity.class);
        intent.putExtra(DESTINO, passarDestino);
        intent.putExtra(ORIGEM, passarOrigem);
        intent.putExtra(DATA, passarData);
        startActivity(intent);
    }

}

