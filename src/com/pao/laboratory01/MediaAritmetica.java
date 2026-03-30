package com.pao.laboratory01;

import java.util.Scanner;
/**
 * Exercitiul 1
 *
 * Cititi de la tastatura un sir cu n elemente intregi.
 *
 * 1. Afisati elementele sirului in doua modalitati.
 * 2. Afisati media aritmetica a elementelor sirului.
 *
 */

public class MediaAritmetica {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);   
        int n, suma = 0;
        int[] array;

        n = scanner.nextInt();
        array = new int[n];
        for (int i = 0 ; i < n; i++)
        {
            array[i] = scanner.nextInt();
            suma += array[i];
        }

        // afisare cu index
        for (int i = 0; i < n; i++)
            System.out.println(array[i]);

        // afisare enhanced for
        for (int num : array)
            System.out.println(num);
    
        System.out.println((double)(suma/n));
    }
}
