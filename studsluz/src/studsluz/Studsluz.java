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
        ArrayList<Student> students = ReadJson.ReadStudent();
        
        GreetMsg msg = new GreetMsg();
        msg.WelcomeMessage();
        int chosenOption =-1;
        
        
        while(chosenOption != 0 && chosenOption != 1){
            Scanner scann = new Scanner(System.in);
            try{
                System.out.print("Unesite opciju:");
                chosenOption = Integer.parseInt(scann.next()) ;
                
            }
            
            catch(NumberFormatException e){
                System.out.println("Uneli ste nedozvoljeni karakter, pokusajte ponovo.\n");
                continue;
            }
      
            
       
        }
        
        if(chosenOption ==0){
            System.out.println("Izlazak iz programa\n");
            System.exit(0);
        }
        
        if(chosenOption == 1){
            chosenOption = -1;
            msg.LogInMsg();
            
        }
        
        boolean checkAdmin= true;
        
        while(checkAdmin){
            Scanner scann = new Scanner(System.in);
            System.out.print("Unesite username:");
            String username = scann.next();
            if(username.equals("0")){
                System.out.println("Izlazi iz programa...");
                System.exit(0);
            }
            
            System.out.print("Unesite password:");
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
        ///Admin panel opcije;
        boolean check = true;
        String option = "";
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Uspesno ste se ulogovali !!");
        System.out.println("Dobrodosli u admin panel");
        System.out.println("Izaberite jednu od opcija:");
        while(true){
        msg.OptionMessage();
        
        
            while(check){

                Scanner scann = new Scanner(System.in);
                option = scann.next();

                if(option.equals("0") || option.equals("1") || option.equals("2") || option.equals("3") || option.equals("3")
                       ||  option.equals("5")|| option.equals("6") || option.equals("7")) check = false;

                if(check == true)System.out.println("Nije uneta postojeca opcija");

            }

            if(option.equals("0"))System.exit(0);

            if(option.equals("1")){

                for (Student s : students) {
                    System.out.println(s.toString());
                }
                check = true;
                option = "";
            }
            
            if(option.equals("2")){
                System.out.println("\nUnesite podatke o studentu:");
                Scanner scann = new Scanner(System.in);
                boolean proveraZaStudenta = true;
                
                int id = -1;
                
                while(proveraZaStudenta){
                    System.out.print("ID:");
                    Scanner unos = new Scanner(System.in);
                    try{
                        id = unos.nextInt();
                        for (Student s: students) {
                            if(id == s.getId()){
                                id =-1;
                                System.out.println("Taj ID vec postoji");
                            }
                        }
                        if(id> 0 && id <100) proveraZaStudenta = false;
                    }catch(Exception e){
                        System.out.println("Ne valja ID!");
                    }
                    
                }
                
                proveraZaStudenta = true;
                
                System.out.print("ime: ");
                String name = scann.next();
                
                System.out.print("prezime: ");
                String surname = scann.next();
                
                

                
                 while(proveraZaStudenta){
                    System.out.print("Godina rodjenja: ");
                    String yearOfBirth = scann.next();
                    int yr=0;
                    try{
                        yr = Integer.parseInt(yearOfBirth);
                    }catch(NumberFormatException e){
                        System.out.println("Niste uneli dobar broj");
                    }
                    if(yr > 1900 && yr<2005)proveraZaStudenta = false;
                    else System.out.println("Niste uneli odgovarajucu godinu");
                }
                
                proveraZaStudenta = true;
                
                while(proveraZaStudenta){
                    System.out.print("Godina upisa: ");
                    String year = scann.next();
                    int yr=0;
                    try{
                        yr = Integer.parseInt(year);
                    }catch(NumberFormatException e){
                        System.out.println("Niste uneli dobar broj");
                    }
                    if(yr > 2010 && yr<2023)proveraZaStudenta = false;
                    else System.out.println("Niste uneli odgovarajucu godinu");
                }
                
                proveraZaStudenta = true;
                
                
                System.out.print("Smer: ");
                String course = scann.next();
                
                System.out.print("email: ");
                String email = scann.next();
            }
            


        }
    }
}
