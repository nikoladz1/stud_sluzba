/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studsluz;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author dzeno
 */
public class WriteJson {
    public static void WriteStudents(ArrayList<Student> student){
        JSONArray jsonStudent=new JSONArray();
        PrintWriter pw = null;
        for (Student s : student) {
            JSONObject obj = new JSONObject();
            obj.put("course", s.getCourse());
            obj.put("email", s.getEmail());
            obj.put("id", s.getId());
            obj.put("index", s.getIndex());
            
            JSONArray predmeti=new JSONArray();
            for (String p : s.getListOfSubjects()) 
                predmeti.add(p);
            obj.put("listOfSubjects", predmeti);
            
            obj.put("name", s.getName());
            obj.put("surname", s.getSurname());
            obj.put("year", s.getYear());
            obj.put("yearOfBirth", s.getYearOfBirth());
            
            jsonStudent.add(obj);
        }
        try {
            pw=new PrintWriter("src\\Students.json");
            pw.write(jsonStudent.toJSONString());
        } catch (FileNotFoundException ex) {
            System.out.println("Greska prilikom upisa!\n"+ex.getMessage());
        }
        finally{
            if(pw != null)
                pw.close();
        }
    }
}
