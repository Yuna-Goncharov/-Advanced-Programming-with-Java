package ex1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String ... args){

        int[] firstCoes;
        double[] firstValues;

        int[] secondCoes;
        double[] secondValues;

        System.out.println("Please enter values for the first Polynomial (separated by spaces):");
        firstValues = readValues();

        System.out.println("Please enter coefficients for the first Polynomial");
        firstCoes = readCoefficients();

        System.out.println("Please enter values for the second Polynomial (separated by spaces):");
        secondValues = readValues();

        System.out.println("Please enter coefficients for the second Polynomial");
        secondCoes = readCoefficients();

        Polynom p1 = new Polynom(firstValues, firstCoes);
        Polynom p2 = new Polynom(secondValues, secondCoes);

        System.out.println("First Polynomial: " + p1);
        System.out.println("Second Polynomial: " + p2);

        System.out.println("P1 + P2: " + p1.plus(p2));
        System.out.println("P1 - P2: " + p1.minus(p2));
        System.out.println("P2 - P1: " + p2.minus(p1));
        System.out.println("P1': " + p1.getDerivative());
        System.out.println("P2': " + p1.getDerivative());

        ArrayList<Integer> a = new ArrayList<>();

        a.add(1);
        a.add(4);
        a.add(10);
    }

    // reads input and parses it to doubles
    static double[] readValues(){

        ArrayList<String> rawValues = readInput();

        double[] values = new double[rawValues.size()];

        for(int index = 0; index < values.length; ++index){

            values[index] = Double.parseDouble(rawValues.get(index));
        }

        return values;
    }

    // reads input and parses it into int
    static int[] readCoefficients(){

        ArrayList<String> rawValues = readInput();

        int[] values = new int[rawValues.size()];

        for(int index = 0; index < values.length; ++index){

            values[index] = Integer.parseInt(rawValues.get(index));
        }

        return values;
    }

    // read raw data
    static ArrayList<String> readInput(){

        Scanner io = new Scanner(System.in);
        String rawInput = io.nextLine();

        ArrayList<String> inputs = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer( rawInput  );

        while(tokenizer.hasMoreTokens()){

            inputs.add(tokenizer.nextToken());
        }

        return inputs;
    }
}

