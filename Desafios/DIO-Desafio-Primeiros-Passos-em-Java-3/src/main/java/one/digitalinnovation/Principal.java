package one.digitalinnovation;

import java.io.IOException;
import java.util.Scanner;

public class Principal{

public static void main(String[] args) throws IOException {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        if(N==0){
            throw new ArithmeticException("erro");
        }
        for (int i = 1; i<=N; i++) {
        if (N%i==0 ) System.out.println(i);
        }
        }

        }