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
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Ingrese fecha a validar: ");
            String date = sc.nextLine();
            Pattern pattern=Pattern.compile("\\d\\d/\\d\\d/\\d\\d\\d\\d");
            Matcher matcher=pattern.matcher(date);
            System.out.print(date);
            if (matcher.find() && checkDate(date)) {
                System.out.println(" es válido");
            }else System.out.println(" no es válido");
        }
    }
    
    public static boolean checkDate(String date){
        int day=Integer.parseInt(date.substring(0,2));
        int month=Integer.parseInt(date.substring(3,5));
        int year=Integer.parseInt(date.substring(8));
        boolean sw=false;
        if (year>1) {
            if (day>=1 && day<=31 && month>=1 && month<=12 && month!=2) {
                sw=true;
            }else if(month==2 && day<=29){
                if(year%4!=0 && day<29){
                    sw=true;
                }else if(year%4==0)sw=true;
            }
        }
        return sw;
    }
    
}
