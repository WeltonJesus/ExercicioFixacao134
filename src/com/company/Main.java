package com.company;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<>(); //Lista genérica  <TaxPayer>, aceita as subclasses

        System.out.print("Enter the number of tax payers:");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) { //Raciocinio polimorfismo
            System.out.println("Tax payer #" + (i + 1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = sc.next().charAt(0); //pega primeiro carácter da String
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Anual income:");
            double anualIncome = sc.nextDouble();

            if (ch == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                list.add(new Individual(name,anualIncome,healthExpenditures));

            } else {
                System.out.print("Number of employess:");
                int numberOfEmployees = sc.nextInt();
               list.add(new Company(name,anualIncome,numberOfEmployees));

            }
        }

        System.out.println();
        System.out.println("TAXES PAID :");
        for (TaxPayer tp : list) { //for feito pra ler
            System.out.println(tp.getName() + " : $ " + String.format("%.2f", tp.tax()));
        }
        System.out.println();
        double sum = 0.0;
        for (TaxPayer tp : list) { // for feito pra mostra soma
            sum += tp.tax();
        }
        System.out.println();
        System.out.println("TOTAL TAXES : $ " + String.format("%.2f", sum));
        sc.close();
    }
}
