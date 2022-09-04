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
        System.out.println("Unesite username i password:");
        System.out.println("Ako zelite da izadjete unesite 0 umesto username ili passworda");
    }
    
    
    
}
