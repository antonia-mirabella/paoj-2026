package com.pao.laboratory01;

import java.util.Scanner;

/**
 * Exercitiul 2
 *
 * Cititi de la tastatura o matrice de n ori n elemente REALE.
 *
 * 1. Afisati matricea in consola.
 * 2. Afisati suma elementelor de pe diagonala principala
 *    si produsul elementelor de pe diagonala secundara.
 *
 */

public class DiagonaleleMatricei {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        double sumaPrinc = 0 , produsSec = 1.0;
        double[][] array;

        n = scanner.nextInt();

        array = new double[n][n];        
        for (int i = 0 ; i < n; i++)
            for (int j = 0 ; j < n; j++)
            {
                array[i][j] = scanner.nextDouble();
                if (i == j)
                    sumaPrinc += array[i][i];
                if (i == ((n-j) - 1))
                    produsSec *= array[i][j];
            }

        for (int i = 0 ; i < n; i++)
            for (int j = 0 ; j < n; j++)
                System.out.println(array[i][j]);
        
        System.out.println(sumaPrinc);
        System.out.println(produsSec);
    }
}
