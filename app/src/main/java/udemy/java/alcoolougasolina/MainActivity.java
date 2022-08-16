package udemy.java.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool     = findViewById(R.id.textView_precoAlcohol);
        editPrecoGasolina   = findViewById(R.id.textView_precoGasoline);
        textResultado       = findViewById(R.id.textView_result);

    }

    public void calcularPreco(View view) {
        //Recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //Validar os campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if ( camposValidados ) {
            //Convertendo string para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool / valorGasolina;

                if ( resultado >= 0.7) {
                    textResultado.setText("É melhor utilizar Gasolina!");
                } else {
                    textResultado.setText("É melhor utilizar Álcool!");
                }
            } else {
                textResultado.setText("Intreduza os preços primeiro!");
            }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;
        String campo  = "Preenchido";

        if ( pAlcool == null || pAlcool.equals("") ) {
            camposValidados = false;
            campo = "Alcool";

        } else  if (pGasolina == null || pGasolina.equals("")){
            camposValidados = false;
            campo = "Gasolina";
        }
        return camposValidados;

    }
}
