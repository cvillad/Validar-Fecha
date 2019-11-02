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
            String date = sc.nextLine();///0\\d|1[0-2]/\\d\\d\\d\\d
            Pattern pattern=pattern= Pattern.compile("([0-2]\\d|3[01])/(0\\d|1[0-2])/\\d\\d\\d\\d");
            Matcher matcher=pattern.matcher(date);
            System.out.print(date);
            if (matcher.matches()) {
                System.out.println(" es válido");
            }else System.out.println(" no es válido");
            System.out.print("1. Continuar    2. Salir");
            option=sc.nextInt();
        }while(option==1);
    }
    
}
