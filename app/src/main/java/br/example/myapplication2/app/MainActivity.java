package br.example.myapplication2.app;

import android.graphics.Color;
import android.provider.CalendarContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {


    Button nPonto, clear;
    TextView campo1, tipoCalculo, campo2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    //Capturando números digitados

    public void adicionaValor(View v){

        String numero = ((TextView) v).getText().toString();

        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);



        if (tipoCalculo.getText().equals("")) {

            campo1.setText(campo1.getText().toString() + numero);
            campo2.setText("");
        }

        else{

            campo2.setText(campo2.getText().toString()  + numero);
        }
    }

    //Adicionando ponto

    public void adicionaPonto(View v){

        String ponto = ((TextView) v).getText().toString();



        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);



        if (tipoCalculo.getText().equals("")){
            if(!campo1.getText().equals("")){
                    campo1.setText(campo1.getText().toString() + ponto);
                    nPonto.setEnabled(false);
            }

        }else {

             if (!campo2.getText().equals("")) {
                campo2.setText(campo2.getText().toString() + ponto);
                 nPonto.setEnabled(false);
            }
        }


    }


    //Capturando o tipo de calculo selecionado
    public void adicionaTipo(View v){

       String tipo = ((TextView) v).getText().toString();
       tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        campo1 = (TextView) findViewById(R.id.txv_Campo1);


        if(!campo1.getText().equals("")){
            tipoCalculo.setText(tipoCalculo.getText().toString() + tipo);
            nPonto.setEnabled(true);
        }else{}

    }


    //Limpando todos os campos habilitar


    public void limparCampos (View v){

        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        clear = (Button) findViewById(R.id.clear);

        nPonto.setEnabled(true);

        tipoCalculo.setText("");
        campo1.setText("");
        campo2.setText("");

    }




    //Escolhendo o tipo de calculo e calculando

    public void adicionaCalculo (View v){

        double resultado;

        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);



        if (campo1.getText().equals("") && tipoCalculo.getText().equals("") && campo2.getText().equals("")  ){



        }else{
            if(tipoCalculo.getText().equals("+")){

                if (campo1.getText() != null && campo2.getText() != null) {
                    double valor1 = Double.parseDouble(campo1.getText().toString());
                    double valor2 = Double.parseDouble(campo2.getText().toString());

                    resultado = valor1 + valor2;

                    campo1.setText("");
                    tipoCalculo.setText("");


                    campo2.setText(String.valueOf(resultado));
                }

            }else if(tipoCalculo.getText().equals("-")){
                if (campo1.getText() != null && campo2.getText() != null) {
                    double valor1 = Double.parseDouble(campo1.getText().toString());
                    double valor2 = Double.parseDouble(campo2.getText().toString());

                    campo1.setText("");
                    tipoCalculo.setText("");
                    resultado = valor1 - valor2;
                    campo2.setText(String.valueOf(resultado));

                }



            }else if(tipoCalculo.getText().equals("/")){

                if (campo1.getText() != null && campo2.getText() != null) {
                    double valor1 = Double.parseDouble(campo1.getText().toString());
                    double valor2 = Double.parseDouble(campo2.getText().toString());

                    resultado = valor1 / valor2;

                    campo1.setText("");
                    tipoCalculo.setText("");

                    campo2.setText(String.valueOf(resultado));
                }


            }else if(tipoCalculo.getText().equals("*")){

                if (campo1.getText() != null && campo2.getText() != null) {
                    double valor1 = Double.parseDouble(campo1.getText().toString());
                    double valor2 = Double.parseDouble(campo2.getText().toString());
                    resultado = valor1 * valor2;

                    campo1.setText("");
                    tipoCalculo.setText("");

                    campo2.setText(String.valueOf(resultado));
                }

            }

        }
    }


}
