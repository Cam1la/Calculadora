package br.example.myapplication2.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {


    final Context context = this;
    Button nPonto, nPorcentagem, nClear;
    TextView campo1, tipoCalculo, campo2, separacao;
    String appTitle = "CSCalc v.0.1.2";
    String inf = "Calculadora simples 2014";
    String author = "Author: Camila Santos ©";

    //Salvando dados das ArrayLists para a mudança de orientação
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putStringArrayList
                (MoreFunctions.listaCampo.toString(), MoreFunctions.listaCampo);
        outState.putStringArrayList
                (MoreFunctions.listaCampo2.toString(), MoreFunctions.listaCampo2);
        outState.putStringArrayList
                (MoreFunctions.listaCampo3.toString(), MoreFunctions.listaCampo3);
        outState.putStringArrayList
                (MoreFunctions.listaResultado.toString(), MoreFunctions.listaResultado);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i("ORIENTAÇÃO: ", ConfiguraOrientacao.verificaOrientacao(this));

        //Reconhecendo a mudança de direção para recuperar os dados das Arrays e preencher os campos.


        if (ConfiguraOrientacao.verificaOrientacao(this).equals("RETRATO")) {

            setContentView(R.layout.activity_main);


            if (savedInstanceState != null) {

                campo1 = (TextView) findViewById(R.id.txv_Campo1);
                campo2 = (TextView) findViewById(R.id.txv_Campo2);
                tipoCalculo = (TextView) findViewById(R.id.txv_Calc);

                campo1.setText(MoreFunctions.listaCampo.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                tipoCalculo.setText(MoreFunctions.listaCampo3.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                if (MoreFunctions.listaCampo3.size() == 0 && MoreFunctions.listaResultado.size() > 0) {

                    campo2.setText(MoreFunctions.listaResultado.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                } else {
                    campo2.setText(MoreFunctions.listaCampo2.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                }


            } else {
                MoreFunctions.listaCampo = new ArrayList();
                MoreFunctions.listaCampo2 = new ArrayList();
                MoreFunctions.listaCampo3 = new ArrayList();
                MoreFunctions.listaResultado = new ArrayList();
            }


        } else if (ConfiguraOrientacao.verificaOrientacao(this).equals("PAISAGEM")) {
            setContentView(R.layout.land);


            if (savedInstanceState != null) {

                campo1 = (TextView) findViewById(R.id.txv_Campo1);
                campo2 = (TextView) findViewById(R.id.txv_Campo2);
                tipoCalculo = (TextView) findViewById(R.id.txv_Calc);

                campo1.setText(MoreFunctions.listaCampo.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                tipoCalculo.setText(MoreFunctions.listaCampo3.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                if (MoreFunctions.listaCampo3.size() == 0 && MoreFunctions.listaResultado.size() > 0) {

                    campo2.setText(MoreFunctions.listaResultado.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                } else {
                    campo2.setText(MoreFunctions.listaCampo2.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));

                }

            } else {
                MoreFunctions.listaCampo = new ArrayList();
                MoreFunctions.listaCampo2 = new ArrayList();
                MoreFunctions.listaCampo3 = new ArrayList();
                MoreFunctions.listaResultado = new ArrayList();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        //Applic Style

        AlertDialog.Builder alertDialogBuild = new AlertDialog.Builder(context, R.style.MyThemeForAlert);

        // set title
        alertDialogBuild.setTitle("Informações do Aplicativo");


        // set dialog message
        alertDialogBuild
                .setMessage(appTitle + "\n" + inf + "\n" + author)
                .setIcon(android.R.drawable.ic_dialog_info)
                .setCancelable(false)
                .setPositiveButton("Sair", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        //Cancela caixa de dialogo
                        dialog.cancel();

                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuild.create();

        // show it
        alertDialog.show();

        return true;
    }

    //Capturando números digitados
    public void adicionaValor(View v) {


        campo1 = (TextView) findViewById(R.id.txv_Campo1);

        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        nClear = (Button) findViewById(R.id.clear);

        MoreFunctions.Valores(campo1, campo2, tipoCalculo, v, nPonto);

    }

    //Tratando a quantidade de pontos que o usuário pode colocar
    public void adicionaPonto(View v) {

        MoreFunctions.numCampo1 = ((TextView) v).getText().toString();
        MoreFunctions.numCampo2 = ((TextView) v).getText().toString();
        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);


        if (tipoCalculo.getText().equals("")) {
            if (!campo1.getText().equals("")) {
                campo1.setText(campo1.getText().toString() + MoreFunctions.numCampo1);
                nPonto.setEnabled(false);
                MoreFunctions.listaCampo.add(MoreFunctions.numCampo1);
            } else {
            }


        } else if (!campo1.getText().equals("") && MoreFunctions.listaResultado.size() != 0) {
            campo1.setText(campo1.getText().toString() + MoreFunctions.numCampo1);
            nPonto.setEnabled(false);
            MoreFunctions.listaCampo.add(MoreFunctions.numCampo1);
        } else {

            if (!campo2.getText().equals("")) {
                campo2.setText(campo2.getText().toString() + MoreFunctions.numCampo2);
                nPonto.setEnabled(false);
                MoreFunctions.listaCampo2.add(MoreFunctions.numCampo2);
            } else {
            }
        }


    }

    //Tratando a quantidade de simbulo Porcentagem que o usuário pode colocar
    public void adicionaPorcentagem(View v) {

        MoreFunctions.numCampo1 = ((TextView) v).getText().toString();
        MoreFunctions.numCampo2 = ((TextView) v).getText().toString();

        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        nPorcentagem = (Button) findViewById(R.id.btn_Porcent);


        if (tipoCalculo.getText().equals("")) {
            if (!campo1.getText().equals("")) {
                campo1.setText(campo1.getText().toString() + MoreFunctions.numCampo1);
                nPorcentagem.setEnabled(false);
                MoreFunctions.listaCampo.add(MoreFunctions.numCampo1);
            } else {
            }

        } else if (!campo1.getText().equals("") && MoreFunctions.listaResultado.size() != 0) {
            campo1.setText(campo1.getText().toString() + MoreFunctions.numCampo1);
            nPorcentagem.setEnabled(false);
            MoreFunctions.listaCampo.add(MoreFunctions.numCampo1);
        } else {

            if (!campo2.getText().equals("")) {
                campo2.setText(campo2.getText().toString() + MoreFunctions.numCampo2);
                nPorcentagem.setEnabled(false);
                MoreFunctions.listaCampo2.add(MoreFunctions.numCampo2);
            } else {
            }
        }

    }

    //Capturando o tipo de calculo selecionado
    public void adicionaTipo(View v) {

        MoreFunctions.tipo = ((TextView) v).getText().toString();
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        nPorcentagem = (Button) findViewById(R.id.btn_Porcent);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        separacao = (TextView) findViewById(R.id.txv_separacao);

        int resultado = MoreFunctions.listaResultado.size();
        int campo = MoreFunctions.listaCampo.size();

        if (campo != 0){
            separacao.setVisibility(View.VISIBLE);
            MoreFunctions.listaCampo3.add(MoreFunctions.tipo);
            tipoCalculo.setText(tipoCalculo.getText().toString() + MoreFunctions.tipo);
            nPonto.setEnabled(true);
            MoreFunctions.listaCampo3.add(MoreFunctions.tipo);
            nPorcentagem.setEnabled(true);
        }else if(!campo2.getText().toString().equals("")){
            separacao.setVisibility(View.VISIBLE);
            MoreFunctions.listaCampo3.add(MoreFunctions.tipo);
            tipoCalculo.setText(tipoCalculo.getText().toString() + MoreFunctions.tipo);
            nPonto.setEnabled(true);
            MoreFunctions.listaCampo3.add(MoreFunctions.tipo);
            nPorcentagem.setEnabled(true);
        }

    }

    //Limpando digitos por digitos
    public void apagaDigitos(View v) {

        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        nPorcentagem = (Button) findViewById(R.id.btn_Porcent);
        separacao = (TextView) findViewById(R.id.txv_separacao);

        MoreFunctions.Clear(campo1, campo2, tipoCalculo, nPonto, nPorcentagem, separacao);


    }

    //Limpando todos os campos
    public void apagaTudo(View v) {
        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        nPorcentagem = (Button) findViewById(R.id.btn_Porcent);
        separacao = (TextView) findViewById(R.id.txv_separacao);

        MoreFunctions.ClearAll(campo1, campo2, tipoCalculo, separacao, nPonto, nPorcentagem);
    }

    //Escolhendo o tipo de calculo e devolvendo o resultado
    public void adicionaCalculo(View v) {

        tipoCalculo = (TextView) findViewById(R.id.txv_Calc);
        campo1 = (TextView) findViewById(R.id.txv_Campo1);
        campo2 = (TextView) findViewById(R.id.txv_Campo2);
        nPorcentagem = (Button) findViewById(R.id.btn_Porcent);
        nPonto = (Button) findViewById(R.id.btn_Ponto);
        separacao = (TextView) findViewById(R.id.txv_separacao);

        MoreFunctions.Calculos(campo1, campo2, tipoCalculo, nPorcentagem, nPonto, separacao);

    }


}
