package br.usjt.meuprimeiroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //define o layout da aplicacao
        setContentView(R.layout.activity_display_message);

        //Pega a intent de origem
        Intent origemIntent = getIntent();
        //Correto
        //String message = origemIntent.getStringExtra("MensagemDaMainActivity");

        //nao correto pega a mensagem
        String message = origemIntent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // cria um text view
        //nao correto
        TextView textView = new TextView(this);

        //Correto pegar um já definido
        //TextView textView = (TextView)findViewById(R.id.display_message_view);

        textView.setTextSize(22);
        textView.setText(message);

        //Exibe o textview criado
        setContentView(textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
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
