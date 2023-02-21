package pl.janek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// Napisz program, ktory oblicza pole prostokata. Waretosci bokow a i b wprowadzamy z klaiwtury w programie nalezy przyjac ze zmienne a b oraz pole sa typu double
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Podaj a");
        double a = Double.parseDouble(br.readLine());
        System.out.println("Podaj b");
        double b = Double.parseDouble(br.readLine());
        System.out.println("Pole jest równe: "+ a *b);
    }
}
