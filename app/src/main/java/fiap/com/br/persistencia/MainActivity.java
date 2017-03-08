package fiap.com.br.persistencia;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText edtUsuario;
    EditText edtSenha;
    CheckBox SalvarSenha;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        SalvarSenha =(CheckBox) findViewById(R.id.SalvarSenha);
        // inicia o Shared Preferences no modo privado
        sp = getPreferences(MODE_PRIVATE);

            edtUsuario.setText(sp.getString("usuario", ""));
        edtSenha.setText(sp.getString("senha", ""));


    }


    public void login(View view) {


        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();

        if( usuario.trim().equals("fiap") && senha.trim().equals("123")){

            SharedPreferences.Editor e = sp.edit();

                    if(SalvarSenha.isChecked()){

                        e.putString("usuario", usuario);
                        e.putString("senha",senha);
                    }else{
                        e.remove("usuario");
                        e.remove("senha");
                    }
                    e.commit();

            //abrir outra activity
            Intent it = new Intent(this,DadosActivity.class);
            startActivity(it);
            return;
        }
        Toast.makeText(this, R.string.usuario_incorreto, Toast.LENGTH_SHORT).show();




    }
}
