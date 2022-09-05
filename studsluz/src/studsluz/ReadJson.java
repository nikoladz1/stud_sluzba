/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studsluz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author dzeno
 */
public class ReadJson {
    
    public static ArrayList<Admin> ReadAdmin(){
        	
	ArrayList<Admin> admini=new ArrayList<>();
            try {
        
		JSONArray jsonAdmin=(JSONArray) new JSONParser().parse(new FileReader("Admin.json"));
		for(Object o: jsonAdmin){
				JSONObject obj=(JSONObject) o;
				
				String username=obj.get("username").toString();
				String password=obj.get("password").toString();
                                String name=obj.get("name").toString();
                                String surname=obj.get("surname").toString();
                                String email=obj.get("email").toString();
				
				
				admini.add(new Admin(username, password,name,surname,email));
        	}
		} 
          catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ParseException e) {
          e.printStackTrace();
        }
        return admini;
    }
    
    public static ArrayList<Student> ReadStudent(){
        	
	ArrayList<Student> studenti=new ArrayList<>();
         
            try {
        
		JSONArray jsonStudenti=(JSONArray) new JSONParser().parse(new FileReader("src\\Students.json"));
		for(Object o: jsonStudenti){
				JSONObject obj=(JSONObject) o;
				
				int id =Integer.parseInt(obj.get("id").toString());
                                int yearOfBirth =Integer.parseInt(obj.get("yearOfBirth").toString());
				String year=obj.get("year").toString();
                                String course=obj.get("course").toString();
                                String index=obj.get("index").toString();
                                
                               JSONArray jsonPredmeti=(JSONArray) obj.get("listOfSubjects");
                                ArrayList<String> predmeti=new ArrayList<>();
                               for (Object tel : jsonPredmeti) 
                                    predmeti.add(tel.toString());
            
                                String name=obj.get("name").toString();
                                String surname=obj.get("surname").toString();
                                String email=obj.get("email").toString();
				
				
				studenti.add(new Student(id,yearOfBirth, year, course, index, predmeti, name, surname, email));
        	}
            } 
          catch (FileNotFoundException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        } catch (ParseException e) {
          e.printStackTrace();
        }
        return studenti;
    }
    
    
}
