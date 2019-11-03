/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.util.Scanner;
import java.util.regex.*;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

/**
 *
 * @author carlo
 */
public class Date {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int option;
        do{
            Scanner sc=new Scanner(System.in);
            System.out.print("Ingrese fecha a validar: ");
            String date = sc.nextLine();            
            Pattern pattern=Pattern.compile("([0-2]\\d|3[01])/(0\\d|1[0-2])/\\d{4}");
            Matcher matcher=pattern.matcher(date);
            System.out.print(date+" ");
            if (matcher.matches()) {
                int day=Integer.parseInt(date.substring(0,2));
                int month=Integer.parseInt(date.substring(3,5));
                int year=Integer.parseInt(date.substring(6));
                if (year>1) {
                    if (month==2) {
                        if (leapYear(year)) {
                            if (day<=29) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }else{
                            if (day<=28) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }
                    }else{
                        if (Pattern.compile("(1|3|5|7|8|10|12)").matcher(month+"").matches()) {
                            if (day<=31) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }else{
                            if (day<=30) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }
                    }
                }else System.out.println("no es válida");
            }else System.out.println("no es válida");
            if (matcher.matches()) {
                System.out.println(" es válido");
            }else System.out.println(" no es válido");
            System.out.print("1. Continuar    2. Salir");
            option=sc.nextInt();
        }while(option==1);
    }
    
    public static boolean leapYear(int year){
        if (year%4==0) {
            if (year%100!=0) {//Bisiesto
                return true;
            }else if (year%400==0) {//Bisiesto
                return true;
            }else return false;
        }else return false;
    }
    
}
