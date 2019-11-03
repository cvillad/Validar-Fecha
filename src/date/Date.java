/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.util.Scanner;
import java.util.regex.*;

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
                if (!Pattern.compile("0").matcher(year+"").matches()) {
                    if (Pattern.compile("2").matcher(day+"").matches()) {
                        if (leapYear(year)) {
                            if (Pattern.compile("[12]?\\d").matcher(day+"").matches()) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }else{
                            if (Pattern.compile("1?\\d|2?[0-8]|\\d").matcher(day+"").matches()) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }
                    }else{
                        if (Pattern.compile("(1|3|5|7|8|10|12)").matcher(month+"").matches()) {
                            if (Pattern.compile("[12]?\\d|3[10]").matcher(day+"").matches()) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }else{
                            if (Pattern.compile("[12]?\\d|30").matcher(day+"").matches()) {
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }
                    }
                }else System.out.println("no es válida");
            }else System.out.println("no es válida");
            System.out.print("1. Continuar    2. Salir ");
            option=sc.nextInt();
        }while(option==1);
    }
    
    public static boolean leapYear(int year){
        if (year%4==0 /*&& Pattern.compile("(\\d{2})?").matcher(year+"").matches()*/) {
            if (year%100!=0) {//Bisiesto
                return true;
            }else if (year%400==0) {//Bisiesto
                return true;
            }else return false;
        }else return false;
    }
    
}
