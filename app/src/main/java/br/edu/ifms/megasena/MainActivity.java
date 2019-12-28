package br.edu.ifms.megasena;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button sortear;
    private TextView random;
    private EditText aki;

    public void sorteio(){
        int numero;
        int qtd = 0;

        try {
        qtd = Integer.parseInt(aki.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, "Quantidade inválida, escolha outro número", Toast.LENGTH_SHORT).show();
        }

            if (qtd > 5 && qtd < 16){
                int[] num = new int[qtd];
                Random r = new Random();
                for (int i = 0; i < num.length; i++) {
                    numero = r.nextInt(60) + 1;
                    for (int j = 0; j < num.length; j++) {
                        if (numero == num[j] && j != i) {
                            numero = r.nextInt(60) + 1;
                        } else {
                            num[i] = numero;
                        }
                    }
                }
                String aux = "";
                for (int i = 0; i < num.length; i++) {


                    if (i < num.length-1){
                        aux += num[i] + " - ";
                    }else{
                        aux += num[i];
                    }
                }
                random.setText(aux);
            }else{
                Toast.makeText(this, "Quantidade inválida, escolha outro número", Toast.LENGTH_SHORT).show();
            }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sortear = findViewById(R.id.sortear);
        random = findViewById(R.id.random);
        aki = findViewById(R.id.aki);

        sortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sorteio();
            }
        });
    }
}