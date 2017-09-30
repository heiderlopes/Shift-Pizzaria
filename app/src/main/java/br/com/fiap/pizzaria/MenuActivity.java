package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    private TextView tvSaudacao;
    private Button btFazerPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tvSaudacao = (TextView) findViewById(R.id.tvSaudacao);

        btFazerPedido = (Button) findViewById(R.id.btFazerPedido);

        btFazerPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent telaPedido = new Intent(MenuActivity.this,
                        PedidoActivity.class);
                startActivity(telaPedido);
            }
        });

        if(getIntent() != null) {
            tvSaudacao.setText(
                    getString(R.string.hello,
                    getIntent().getStringExtra(Constants.KEY_LOGIN)));
        }
    }
}
