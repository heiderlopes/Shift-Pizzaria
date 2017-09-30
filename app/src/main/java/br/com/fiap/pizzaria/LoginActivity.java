package br.com.fiap.pizzaria;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout inputLogin;
    private TextInputLayout inputSenha;

    private TextView tvMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputLogin = (TextInputLayout) findViewById(R.id.inputLogin);
        inputSenha = (TextInputLayout) findViewById(R.id.inputSenha);
        tvMensagem = (TextView) findViewById(R.id.tvMensagem);
    }

    //Comenta uma linha
    /*
    * Comenta varias linhas
    * */
    public void conectar(View v){
        String login = inputLogin.getEditText().getText().toString();
        String senha = inputSenha.getEditText().getText().toString();

        inputLogin.setError(getString(R.string.mensagem_campo_obrigatorio));
        inputLogin.setErrorEnabled(login.trim().equals(""));

        inputSenha.setError(getString(R.string.mensagem_campo_obrigatorio));
        inputSenha.setErrorEnabled(senha.trim().equals(""));

        if(login.equals("android") && senha.equals("123")) {
            Intent telaMenu = new Intent(this, MenuActivity.class);
            telaMenu.putExtra("LOGIN", login);
            startActivity(telaMenu);
            finish();
        } else {
            if(login.trim().equals("") && senha.trim().equals("")) {
                tvMensagem.setVisibility(View.GONE);
            } else {
                tvMensagem.setVisibility(View.VISIBLE);
                tvMensagem.setText(R.string.mensagem_usuario_senha_invalido);
            }
        }
    }
}
