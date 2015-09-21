package br.usjt.meuprimeiroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //constante nao correto cria depencia
    public static final String EXTRA_MESSAGE = "br.usjt.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Chama metodo herdado da Activity
        super.onCreate(savedInstanceState);
        //Inflate Gera a view XML
        //define o layout da aplicacao
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){
        //Intent define uma tela /activity que vai para a pilha pois esta já esta sendo executada
        Intent intent  = new Intent(this, DisplayMessageActivity.class);
        //Pega o EditText com o id edit_message
        EditText editText = (EditText)findViewById(R.id.edit_message);
        //pega a mensagem do text
        String message = editText.getText().toString();
        //transporta valores de uma tela para outra
        //nao correto
        intent.putExtra(EXTRA_MESSAGE,message);
        //correto
        //intent.putExtra("MensagemDaMainActivity",message);

        //Chama a tela que vai ser empilhada
        startActivity(intent);
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
