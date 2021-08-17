package one.digitalinnovation;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        double X = 0;
        X = leitor.nextDouble();

        BigDecimal[] N = new BigDecimal[100];
        BigDecimal dois = new BigDecimal("2.0000");
        N[0] = new BigDecimal(X);

        for (int i = 1; i < N.length; i++) {
            N[i] = N[i - 1].divide(dois);
        }

        DecimalFormat decFormat = new DecimalFormat("0.0000");

        for (int i = 0; i < N.length; i++) {
            System.out.println("N[" + i + "] = " + decFormat.format(N[i]));
        }
    }

}