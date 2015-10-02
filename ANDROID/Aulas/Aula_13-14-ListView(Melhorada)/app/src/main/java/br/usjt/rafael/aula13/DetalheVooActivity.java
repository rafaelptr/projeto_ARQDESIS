package br.usjt.rafael.aula13;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

public class DetalheVooActivity extends ActionBarActivity {
    TextView vooOrigem;
    ImageView vooImageView;
    TextView vooPreco;
    TextView vooDestino;
    TextView vooData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_voo);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaVooActivity.VOO);
        Voo voo = (Voo)obj;
        setupViews(voo);

    }

    private void setupViews(Voo voo) {
        vooOrigem = (TextView) findViewById(R.id.txt_voo_origem);
        vooOrigem.setText(voo.getOrigem());

        vooImageView= (ImageView) findViewById(R.id.voo_image_view);
        Drawable drawable = Util.getDrawable(this, voo.getImagem());
        vooImageView.setImageDrawable(drawable);

        vooPreco = (TextView) findViewById(R.id.txt_voo_preco);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        vooPreco.setText(""+formatter.format(voo.getPreco()));

        vooDestino= (TextView) findViewById(R.id.txt_voo_destino);
        vooDestino.setText(voo.getDestino());

        vooData = (TextView) findViewById(R.id.txt_voo_data);
        vooData.setText(voo.getData());
    }

}
