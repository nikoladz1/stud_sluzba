/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studsluz;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author dzeno
 */
public class Studsluz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GreetMsg msg = new GreetMsg();
        msg.WelcomeMessage();
        int chosenOption =-1;
        
        
        while(chosenOption != 0 && chosenOption != 1){
            Scanner scann = new Scanner(System.in);
            try{
                chosenOption = Integer.parseInt(scann.next()) ;
                
            }
            
            catch(NumberFormatException e){
                System.out.println("Uneli ste nedozvoljeni karakter, pokusajte ponovo.");
                continue;
            }
      
            
       
        }
        
        if(chosenOption ==0){
            System.out.println("Izlazak iz programa");
            System.exit(0);
        }
        
        if(chosenOption == 1){
            chosenOption = -1;
            msg.LogInMsg();
        }
        
    }
    
}
