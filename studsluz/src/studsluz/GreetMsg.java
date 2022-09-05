/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studsluz;

/**
 *
 * @author dzeno
 */
public class GreetMsg extends AGreetMsg implements IGreetMsg  {

    // Pocetna metoda na ulasku u program;
    @Override
    public void WelcomeMessage() {
        System.out.println("Dobrodosli u Studentsku Sluzbnu");
        System.out.println("Za log in unestite (1), za izlaz iz programa unesite (0)");
        
    }
    
    //Ako izabere opciju 1 treba sledi ova metoda:
    @Override
    public void LogInMsg(){
        System.out.println("\n\nUnesite username i password:");
        System.out.println("Ako zelite da izadjete unesite 0 umesto username ili passworda\n");
    }
    
    
    public void OptionMessage(){
    
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Uspesno ste se ulogovali !!");
        System.out.println("Dobrodosli u admin panel");
        System.out.println("Izaberite jednu od opcija:");
        System.out.println("\n\n");
        System.out.println("1. Pregledaj sve studente");
        System.out.println("2. Dodaj Studenta");
        System.out.println("3. Izbrisi Studenta");
        System.out.println("4. Izmeni informacije o Studentu");
        System.out.println("5. Dodaj Predmet Studentu");
        System.out.println("6. Izbrisi Predmet Studentu");
        System.out.println("7. Pregledaj Predmete\n");
        System.out.println("0. Izadji iz programa\n\n");
    }
}
