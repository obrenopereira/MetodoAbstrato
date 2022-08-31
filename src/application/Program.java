package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<TaxPayer> list = new ArrayList<>();

        System.out.println("Enter the number of tax payers: ");
        int n = read.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char ch = read.next().charAt(0);
            read.nextLine();
            System.out.print("Name: ");
            String name = read.nextLine();
            read.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = read.nextDouble();
            read.nextLine();

            if (ch == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = read.nextDouble();
                list.add(new Individual(name, anualIncome, healthExpenditures));
                read.nextLine();
            }else if (ch == 'c'){
                System.out.print("Number of employees: ");
                int numberOfEmployees = read.nextInt();
                list.add(new Company(name,anualIncome, numberOfEmployees));
            }

            double sum = 0.0;
            System.out.println();
            System.out.println("TAXES PAID:");

            for (TaxPayer tp : list){
                double tax = tp.tax();
                System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
                sum += tax;
            }

            System.out.println();
            System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));



        }

    }

}
