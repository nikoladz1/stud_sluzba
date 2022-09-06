/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studsluz;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Iterator;
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
        
            check = true;
            while(check){

                Scanner scann = new Scanner(System.in);
                option = scann.next();

                if(option.equals("0") || option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")
                       ||  option.equals("5")|| option.equals("6") || option.equals("7")) check = false;

                if(check == true)System.out.println("Nije uneta postojeca opcija");

            }

            if(option.equals("0")){
                WriteJson.WriteStudents(students);
                System.exit(0);
            }
            
            //Prikaz studenata
            if(option.equals("1")){

                for (Student s : students) {
                    System.out.println(s.toString());
                }
                check = true;
                option = "";
            }
            
            //dodavanje jednog studenta
            if(option.equals("2")){
                System.out.println("\nUnesite podatke o studentu:");
                Scanner scann = new Scanner(System.in);
                boolean proveraZaStudenta = true;
                
                
                int id = -1;
                String name = "";
                String surname= "";
                String yearOfBirth= "";
                String year= "";
                String course= "";
                String email= "";
                String index= "";
                String predmet = "";
                
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
                 name = scann.next();
                
                System.out.print("prezime: ");
                surname = scann.next();
                
                

                
                 while(proveraZaStudenta){
                    System.out.print("Godina rodjenja: ");
                    yearOfBirth = scann.next();
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
                    year = scann.next();
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
                
                while(proveraZaStudenta){
                    
                    System.out.print("Smer: ");
                    course = scann.next();
                    if(course.toUpperCase().equals("RT") || course.toUpperCase().equals("NRT"))proveraZaStudenta = false;
                    else System.out.println("Ne postoji taj smer, mozete odabrati samo RT ili NRT");
                }
                
                proveraZaStudenta = true;
                
                while(proveraZaStudenta){
                System.out.print("email: ");
                email = scann.next();
                if(email.contains("@"))proveraZaStudenta = false;
                else System.out.println("Ne valja email");
            }
                
                System.out.print("Naziv jednog predmeta:  ");
                predmet = scann.next();
                
                String god = year.substring(2);
                index = course+"-"+id+"/"+ god;
                
                
                Student s = new Student(id,Integer.parseInt(yearOfBirth),year,course,index,name,surname, email, predmet);
                students.add(s);
                option = "";
                
            }
            
            //Brisanje jednog Studenta
            if(option.equals("3")){
                boolean checkid = true;
                System.out.println("\nUnesite ID studenta kog zelite da izbrisete:\n");
                while(checkid){
                Scanner scan = new Scanner(System.in);
                
                System.out.print("ID: ");
                int idStudenta=0;
                
                String ids = scan.next();
                
                try{
                    idStudenta = Integer.parseInt(ids);
                }catch(NumberFormatException e){
                    System.out.println("Niste uneli broj");
                }
                
                Iterator<Student> itr = students.iterator();
                while (itr.hasNext()) {
                    Student std = itr.next();
                    if (std.getId()==idStudenta) {
                        checkid = false;
                        itr.remove();

                        System.out.println("Uspesno ste izbrisali studenta");
                
                    } 
                }
                
                if(checkid==true)System.out.println("Ne postoji student sa tim ID-om");
                
                }
                
                option = "";
            }
            
            
            // Menjanje podataka o studentu:
            if(option.equals("4")){
                int id = -1;
                Scanner scann = new Scanner(System.in);
                System.out.println("Unesite ID studenta cije podatke zelite da izmenite");
                boolean checkid=true;
                while(checkid){
                    Scanner unos = new Scanner(System.in);
                    System.out.println("ID: ");
                    String ids = unos.next();
                    
                    try{
                        id = Integer.parseInt(ids);
                    }catch(NumberFormatException e){
                        System.out.println("Niste uneli dobar broj");
                        
                    }
                    
                    for (Student s: students) {
                        if (id == s.getId()) {
                            checkid=false;
                        }
                    }
                    
                    if (checkid) {
                        System.out.println("Ne postoji Student sa tim ID-om");
                    }
                    
                    
                }
                
                System.out.println("\nUnesite podatke o studentu:");
                
                boolean proveraZaStudenta = true;
                
                
                
                String name = "";
                String surname= "";
                String yearOfBirth= "";
                String year= "";
                String course= "";
                String email= "";
                String index= "";
                String predmet = "";
                

                
                System.out.print("ime: ");
                 name = scann.next();
                
                System.out.print("prezime: ");
                surname = scann.next();
                
                

                
                 while(proveraZaStudenta){
                    System.out.print("Godina rodjenja: ");
                    yearOfBirth = scann.next();
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
                    year = scann.next();
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
                
                while(proveraZaStudenta){
                    
                    System.out.print("Smer: ");
                    course = scann.next();
                    if(course.toUpperCase().equals("RT") || course.toUpperCase().equals("NRT"))proveraZaStudenta = false;
                    else System.out.println("Ne postoji taj smer, mozete odabrati samo RT ili NRT");
                }
                
                proveraZaStudenta = true;
                
                while(proveraZaStudenta){
                    System.out.print("email: ");
                    email = scann.next();
                    if(email.contains("@"))proveraZaStudenta = false;
                    else System.out.println("Ne valja email");
            }
                
                
                
                String god = year.substring(2);
                index = course+"-"+id+"/"+ god;
                
                for (Student s: students) {
                    if (id==s.getId()) {
                        s.setName(name);
                        s.setSurname(surname);
                        s.setYear(year);
                        s.setYearOfBirth(Integer.parseInt(yearOfBirth));
                        s.setCourse(course);
                        s.setEmail(email);
                        s.setIndex(index);
                        
                    }
                }
                
                
                
                option = "";
                
            
            }
            
            //DODAVANJE PREDMETA
            if(option.equals("5")){
                
                int id = -1;
                
                System.out.println("Unesite ID studenta kome zelite da dodate predmet");
                boolean checkid=true;
                while(checkid){
                    Scanner unos = new Scanner(System.in);
                    System.out.println("ID: ");
                    String ids = unos.next();
                    
                    try{
                        id = Integer.parseInt(ids);
                    }catch(NumberFormatException e){
                        System.out.println("Niste uneli dobar broj");
                        
                    }
                    
                    for (Student s: students) {
                        if (id == s.getId()) {
                            checkid=false;
                        }
                    }
                    
                    if (checkid) {
                        System.out.println("Ne postoji Student sa tim ID-om");
                    }
                    
                    
                }
                
                System.out.println("Unesite naziv Predmeta: ");
                String jedanPr ="";
                boolean boo = false;
                while(boo==false){
                    
                    System.out.print("Predmet: ");
                    Scanner unoss = new Scanner(System.in);
                    jedanPr = unoss.next();
                    
                    for(Student s: students){
                        if(s.getId()==id){
                           boo = s.addSubject(jedanPr);
                            System.out.println("Predmet Dodat");
                        }
                    }
                    
                }
                
                option = "";
            
            }
            
            //brisanje predmeta
            if(option.equals("6")){
                
                int id = -1;
                
                System.out.println("Unesite ID studenta kome zelite da izbrisete predmet");
                boolean checkid=true;
                while(checkid){
                    Scanner unos = new Scanner(System.in);
                    System.out.println("ID: ");
                    String ids = unos.next();
                    
                    try{
                        id = Integer.parseInt(ids);
                    }catch(NumberFormatException e){
                        System.out.println("Niste uneli dobar broj");
                        
                    }
                    
                    for (Student s: students) {
                        if (id == s.getId()) {
                            checkid=false;
                        }
                    }
                    
                    if (checkid) {
                        System.out.println("Ne postoji Student sa tim ID-om");
                    }
                    
                    
                }
                
                System.out.println("Unesite naziv Predmeta koji zelite da obrisete: ");
                String jedanPr ="";
                boolean boo = false;
                while(boo==false){
                    
                    System.out.print("Predmet: ");
                    Scanner unoss = new Scanner(System.in);
                    jedanPr = unoss.next();
                    
                    for(Student s: students){
                        if(s.getId()==id){
                           boo = s.RemoveSubject(jedanPr);
                            
                        }
                    }
                    
                }
                
                option = "";
            
            }
            
            if(option.equals("7")) {
                WriteJson.WriteStudents(students);
                System.out.println("Sve izmene su uspesno sacuvane");
            }


        }
    }
}
