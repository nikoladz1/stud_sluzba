/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studsluz;

import java.util.ArrayList;
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
        //citaj Json
        ArrayList<Admin> admins = ReadJson.ReadAdmin();
        
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
        
        boolean checkAdmin= true;
        
        while(checkAdmin){
            Scanner scann = new Scanner(System.in);
            String username = scann.next();
            if(username.equals("0")){
                System.out.println("Izlazi iz programa...");
                System.exit(0);
            }
            String password = scann.next();
            
            if(password.equals("0")){
                System.out.println("Izlazi iz programa...");
                System.exit(0);
            }

            
            for (Admin a : admins) {
                if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                    checkAdmin= false;
                    break;
                }
                
                
            }
            
            if(checkAdmin == true)System.out.println("Niste dobro uneli username ili password");
            
        }

        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Uspesno ste se ulogovali !!");
        System.out.println("Dobrodosli u admin panel");
        System.out.println("Izaberite jednu od opcija:");
        
        System.out.println("1. Pregledaj sve studente");
        System.out.println("2. Dodaj Studenta");
        System.out.println("3. Izbrisi Studenta");
        System.out.println("4. Izmeni informacije o Studentu");
        System.out.println("5. Dodaj Predmet Studentu");
        System.out.println("6. Izbrisi Predmet Studentu");
        System.out.println("7. Pregledaj Predmete");
        System.out.println("8. Izmeni Informacije o Predmetu");
        
        
        
        
    }
    
}
