package br.example.myapplication2.app;

import android.app.Activity;
import android.content.res.Configuration;

/**
 * Created by camila on 06/06/14.
 */
public class ConfiguraOrientacao {


    public static String verificaOrientacao(Activity activity) {
        String retornoOrientacao = "";

        int orientacao = activity.getResources().getConfiguration().orientation;

        if (orientacao == Configuration.ORIENTATION_PORTRAIT) {
            retornoOrientacao = "RETRATO";
        } else if (orientacao == Configuration.ORIENTATION_LANDSCAPE) {
            retornoOrientacao = "PAISAGEM";
        }


        return retornoOrientacao;


    }
}
