package sergio.catalan.ejemplo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import sergio.catalan.ejemplo2.modelos.Usuario;

public class MainActivity extends AppCompatActivity {
    //VARIABLES DE LA INTERFAZ O VISTA

    private EditText txtEmail;
    private EditText txtContrasena;

    private Button btnRegistrar;

    //VARIABLES DE LA LÓGICA

    ArrayList<Usuario> listaUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaUsuarios = new ArrayList<>();

        inicializarVista();

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //RECUPERAR LOS DATOS DE LAS CAJAS DE TEXTO
                String email = txtEmail.getText().toString();
                String contrasena = txtContrasena.getText().toString();

                //SI HAY DATOS SE GUARDAN
                if (email.isEmpty() || contrasena.isEmpty()){
                    //SI NO HAY DATOS MENSAJE
                    Toast.makeText(MainActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }else{
                    //GUARDAR ESOS USUARIOS EN UN OBJETO USUARIO
                    Usuario miusuario = new Usuario(email,contrasena);
                    //AÑADIR ESE USUARIO A LA LISTA
                    listaUsuarios.add(miusuario);
                    //MENSAJE RESUMEN
                    Toast.makeText(MainActivity.this, "GUARDADO" + miusuario, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializarVista() {
        txtEmail = findViewById(R.id.txtEmailMain);
        txtContrasena = findViewById(R.id.txtContrasenaMain);
        btnRegistrar = findViewById(R.id.btnRegistrarMain);
    }
}