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
        int option=1;
        do{
            Scanner sc=new Scanner(System.in);
            System.out.print("Ingrese fecha a validar: ");
            String date = sc.nextLine();              
            Pattern pattern=Pattern.compile("([0-2]\\d|3[01])/(0\\d|1[0-2])/\\d{4}");//valida el formato dd/mm/aaaa, 
                                                //asegura que los días estén entre 1 y 31, y los meses entre 1 y 12
            Matcher matcher=pattern.matcher(date);
            System.out.print(date+" ");
            if (matcher.matches()) {
                int day=Integer.parseInt(date.substring(0,2));//convierte dia ingresado a entero
                int month=Integer.parseInt(date.substring(3,5));//mes ingresado a entero
                int year=Integer.parseInt(date.substring(6));//año a entero
                if (!Pattern.compile("0").matcher(year+"").matches()) {//si el año es diferente de 0
                    if (Pattern.compile("2").matcher(month+"").matches()) {//si el mes es igual a 2
                        if (leapYear(year)) {//si el año es bisiesto
                            if (Pattern.compile("[12]?\\d").matcher(day+"").matches()) {//día menor o igual a 29
                                System.out.println("es válida");
                            }else System.out.println("no es válida");//si el día se pasa de 29
                        }else{//año no bisiesto
                            if (Pattern.compile("1?\\d|2?[0-8]").matcher(day+"").matches()) {//día menor o igual a 28
                                System.out.println("es válida");
                            }else System.out.println("no es válida");// día se passa de 28
                        }
                    }else{
                        if (Pattern.compile("(1|3|5|7|8|10|12)").matcher(month+"").matches()) {//meses que llegan hasta el día 31
                            if (Pattern.compile("[12]?\\d|3[10]").matcher(day+"").matches()) {//dia menor o igual a 31
                                System.out.println("es válida");
                            }else System.out.println("no es válida");
                        }else{//meses que llegan hasta el 30
                            if (Pattern.compile("[12]?\\d|30").matcher(day+"").matches()) {//dia menor o igual a 30
                                System.out.println("es válida");//
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
        if (Pattern.compile("(\\d{2})?([02468]?[048]|[13579][26])").matcher(year+"").matches()) {//numeros divisibles entre 4
            if (!Pattern.compile("(\\d{2})?0?0").matcher(year+"").matches()) {//numeros divisibles entre 100 (negación)
                return true;
            }else if (Pattern.compile("([13579][62]|[2468]?[048]|)00").matcher(year+"").matches()) {//numeros divisibles entre 400
                return true;
            }else return false;
        }else return false;
    }
}
