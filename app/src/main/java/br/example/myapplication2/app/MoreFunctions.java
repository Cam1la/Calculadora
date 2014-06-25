package br.example.myapplication2.app;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by camila on 23/06/14.
 */
public class MoreFunctions {

    public static String numCampo1;
    public static String tipo;
    public static String numCampo2;

    public static ArrayList listaCampo = new ArrayList(); //Lista do primeiro campo
    public static ArrayList listaCampo2 = new ArrayList(); //Lista do segundo campo valor
    public static ArrayList listaCampo3 = new ArrayList(); //Lista do Tipo de valor
    public static ArrayList listaResultado = new ArrayList(); //Apagar resultado 1 por 1


    //Método que efetua os calculos de acordo coma escolha do usuário
    public static String Calculos(TextView campo1, TextView campo2, TextView tipoCalculo, Button nPorcentagem, Button nPonto, TextView txv_separacao) {


        String resultadoFinal, resultado;
        BigDecimal v1, v2, va, vb;
        BigDecimal cem = new BigDecimal(100);


        tipo = tipoCalculo.getText().toString();

        listaCampo3.add(tipo);
        HashMap<String, Integer> caseHash = new HashMap<String, Integer>();

        caseHash.put("/", 1);
        caseHash.put("+", 2);
        caseHash.put("-", 3);
        caseHash.put("*", 4);

        if (!campo1.getText().equals("") && campo1.getText().toString().contains("%") && tipoCalculo.getText().equals("") && campo2.getText().equals("")) {
            v1 = new BigDecimal(campo1.getText().toString().replaceAll("%", ""));

            va = v1.divide(cem);
            resultadoFinal = va.toPlainString();
            campo2.setText(String.valueOf(resultadoFinal));
            campo1.setText("");
            tipoCalculo.setText("");
            listaCampo.clear();
            listaCampo3.clear();
            listaCampo2.clear();
            listaResultado.clear();


        } else if (campo1.getText().equals("") || tipoCalculo.getText().equals("") || campo2.getText().equals("")) {
        } else {
            v1 = new BigDecimal(campo1.getText().toString().replaceAll("%", ""));
            v2 = new BigDecimal(campo2.getText().toString().replaceAll("%", ""));


            double compare = Double.parseDouble(campo2.getText().toString().replaceAll("%", ""));

            //Calculando sem porcentagem

            switch (caseHash.containsKey(tipo) ? caseHash.get(tipo) : -1) {
                case 1:
                    try {
                        if (campo1.getText().toString().contains("%") && campo2.getText().toString().contains("%")) {

                            va = v1.divide(cem);
                            vb = v2.divide(cem);

                            resultadoFinal = va.multiply(vb).divide(va).toPlainString();
                            campo2.setText(String.valueOf(resultadoFinal));

                        } else {
                            if (v1.compareTo(v2) > compare) {
                                if (campo1.getText().toString().contains("%")) {

                                    va = v1.divide(cem);

                                    resultadoFinal = va.divide(v2, RoundingMode.HALF_UP).toPlainString();
                                    campo2.setText(String.valueOf(resultadoFinal));
                                } else {
                                    resultadoFinal = v1.divide(v2, RoundingMode.HALF_UP).toPlainString();
                                    campo2.setText(String.valueOf(resultadoFinal));
                                }
                            } else {

                                if (campo2.getText().toString().contains("%")) {

                                    va = v1.divide(cem);

                                    resultadoFinal = va.divide(v2, 9, RoundingMode.HALF_UP).toPlainString();
                                    campo2.setText(String.valueOf(resultadoFinal));
                                } else {
                                    resultadoFinal = v1.divide(v2, 9, RoundingMode.HALF_UP).toPlainString();
                                    campo2.setText(String.valueOf(resultadoFinal));
                                }

                            }
                        }

                    } catch (Exception ex) {
                        campo1.setText("");
                        tipoCalculo.setText("");
                        campo2.setText(ex.getMessage());
                    }

                    break;

                case 2:

                    try {
                        if (campo1.getText().toString().contains("%") && campo2.getText().toString().contains("%")) {

                            va = v1.divide(cem);
                            vb = v2.divide(cem);

                            resultadoFinal = va.multiply(vb).add(va).toPlainString();
                            campo2.setText(String.valueOf(resultadoFinal));

                        } else {
                            if (campo1.getText().toString().contains("%")) {

                                va = v1.divide(cem);

                                resultadoFinal = va.add(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            } else {

                                resultadoFinal = v1.add(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            }
                            if (campo2.getText().toString().contains("%")) {

                                va = v1.divide(cem);
                                resultadoFinal = va.add(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            } else {
                                resultadoFinal = v1.add(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            }
                        }

                    } catch (Exception ex) {
                        campo1.setText("");
                        tipoCalculo.setText("");
                        campo2.setText(ex.getMessage());
                    }

                    break;

                case 3:

                    try {
                        if (campo1.getText().toString().contains("%") && campo2.getText().toString().contains("%")) {

                            va = v1.divide(cem);
                            vb = v2.divide(cem);

                            resultadoFinal = va.multiply(vb).subtract(va).toPlainString();
                            campo2.setText(String.valueOf(resultadoFinal));

                        } else {

                            if (campo1.getText().toString().contains("%")) {

                                va = v1.divide(cem);

                                resultadoFinal = va.subtract(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            } else {
                                resultadoFinal = v1.subtract(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            }
                            if (campo2.getText().toString().contains("%")) {

                                va = v1.divide(cem);
                                resultadoFinal = va.subtract(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            } else {
                                resultadoFinal = v1.subtract(v2).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));
                            }
                            if (campo1.getText().toString().contains("%") && campo2.getText().toString().contains("%")) {

                                va = v1.divide(cem);
                                vb = v2.divide(cem);

                                resultadoFinal = va.subtract(vb).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));

                            } else {
                            }
                        }

                    } catch (Exception ex) {
                        campo1.setText("");
                        tipoCalculo.setText("");
                        campo2.setText(ex.getMessage());
                    }


                    break;
                case 4:

                    try {
                        if (campo1.getText().toString().contains("%") && campo2.getText().toString().contains("%")) {

                            va = v1.divide(cem);
                            vb = v2.divide(cem);

                            resultadoFinal = va.multiply(vb).multiply(va).toPlainString();
                            campo2.setText(String.valueOf(resultadoFinal));

                        } else {
                            if (campo1.getText().toString().contains("%")) {

                                va = v1.divide(cem);
                                resultadoFinal = va.multiply(v2).toPlainString();

                                campo2.setText(String.valueOf(resultadoFinal));
                            } else {
                                resultadoFinal = v1.multiply(v2).toPlainString();

                                campo2.setText(String.valueOf(resultadoFinal));
                            }
                            if (campo2.getText().toString().contains("%")) {

                                va = v1.divide(cem);
                                resultadoFinal = va.multiply(v2).toPlainString();

                                campo2.setText(String.valueOf(resultadoFinal));
                            } else {
                                resultadoFinal = v1.multiply(v2).toPlainString();

                                campo2.setText(String.valueOf(resultadoFinal));
                            }
                            if (campo1.getText().toString().contains("%") && campo2.getText().toString().contains("%")) {

                                va = v1.divide(cem);
                                vb = v2.divide(cem);

                                resultadoFinal = va.multiply(vb).toPlainString();
                                campo2.setText(String.valueOf(resultadoFinal));

                            } else {
                            }
                        }

                    } catch (Exception ex) {
                        campo1.setText("");
                        tipoCalculo.setText("");
                        campo2.setText(ex.getMessage());
                    }


                    break;


            }
            campo1.setText("");
            tipoCalculo.setText("");
            listaCampo.clear();
            listaCampo3.clear();
            listaCampo2.clear();
            listaResultado.clear();
        }
        txv_separacao.setVisibility(View.INVISIBLE);
        resultado = campo2.getText().toString();
        nPorcentagem.setEnabled(true);
        listaResultado.add(resultado);
        nPonto.setEnabled(true);
        return resultado;
    }

    //Método responsável por receber e limitar os valores do teclado que o usuário seleciona
    public static String Valores(TextView campo1, TextView campo2, TextView tipoCalculo, View v, Button nPonto) {

        numCampo1 = ((TextView) v).getText().toString();
        numCampo2 = ((TextView) v).getText().toString();

        int index1 = listaCampo.size();
        int index2 = listaCampo2.size();
        int resultado = listaResultado.size();
        int tipo = listaCampo3.size();


        if (tipoCalculo.getText().equals("")) {

            if (campo1.getText().toString().contains("%")) {
                //FAZ NADA
            } else {

                if (index1 <= 15) {
                    listaCampo.add(numCampo1);

                    campo1.setText(campo1.getText().toString() + numCampo1);
                    campo2.setText("");
                    listaCampo2.clear();
                    listaResultado.clear();
                } else {
                }
            }
        } else if (resultado != 0 && tipo != 0) {
            listaCampo.add(numCampo1);
            campo1.setText(campo1.getText().toString() + numCampo1);
        } else {

            if (campo2.getText().toString().contains("%")) {
                //FAZ NADA
            } else {

                if (index2 <= 15) {
                    listaCampo2.add(numCampo2);
                    campo2.setText(campo2.getText().toString() + numCampo2);
                } else {
                }

            }
        }


        String teste = "";
        return teste;

    }

    //Método responsável por apagar digito por digito e limpar as ArrayList
    public static void Clear(TextView campo1, TextView campo2, TextView tipoCalculo, Button nPonto, Button nPorcentagem, TextView separacao) {


        if (!campo2.getText().equals("") && !tipoCalculo.getText().equals("")) {

            if (listaCampo2.size() != 0) {

                int index = listaCampo2.size();
                index = --index;
                listaCampo2.remove(index);
                campo2.setText(listaCampo2.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));


            } else if (listaResultado.size() != 0) {
                listaResultado.clear();
                campo2.setText("");
            } else {
            }

        } else if (campo1.getText().equals("") && tipoCalculo.getText().equals("") && !campo2.getText().equals("")) {
            if (!campo2.getText().equals("")) {
                campo2.setText("");
            } else {
            }
        } else if (!tipoCalculo.getText().equals("")) {

            listaCampo3.clear();
            tipoCalculo.setText("");
            separacao.setVisibility(View.INVISIBLE);

        } else if (campo2.getText().equals("") && tipoCalculo.getText().equals("") && !campo1.getText().equals("")) {
            if (listaCampo.size() >= 0) {
                int index = listaCampo.size();
                index = --index;
                listaCampo.remove(index);
                campo1.setText(listaCampo.toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "").replaceAll(" ", ""));
            } else {
            }
        } else {
        }

        if (!campo1.getText().toString().contains(".") || !campo2.getText().toString().contains(".")) {

            if (!campo1.getText().equals("")) {
                nPonto.setEnabled(true);
            } else {
            }

        } else {

            if (!campo2.getText().equals("")) {
                nPonto.setEnabled(true);
            } else {
            }
        }

        if (!campo1.getText().toString().contains("%") || !campo2.getText().toString().contains("%")) {

            if (!campo1.getText().equals("")) {
                nPorcentagem.setEnabled(true);
            } else {
            }
            if (!campo2.getText().equals("")) {
                nPorcentagem.setEnabled(true);
            } else {
            }
        }


        if (campo1.getText().equals("") && campo2.getText().equals("") && tipoCalculo.getText().equals("")) {
            listaCampo.clear();
            listaCampo2.clear();
            listaResultado.clear();
        } else {
        }

    }

    //Método Responsável por limpar todos os campos e ArrayList
    public static void ClearAll(TextView campo1, TextView campo2, TextView tipoCalculo, TextView txv_separacao, Button nPonto, Button nPorcentagem) {

        campo1.setText("");

        listaCampo.clear();
        listaCampo2.clear();
        listaResultado.clear();
        listaCampo3.clear();

        campo2.setText("");
        tipoCalculo.setText("");
        txv_separacao.setVisibility(View.INVISIBLE);
        nPonto.setEnabled(true);
        nPorcentagem.setEnabled(true);
    }

}
