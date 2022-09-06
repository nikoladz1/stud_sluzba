/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studsluz;

import java.util.ArrayList;

/**
 *
 * @author dzeno
 */
public class Student extends Person{
    
    private int id;
    
    private int yearOfBirth;
    private String year;
    private String course;
    private String index;
    private ArrayList<String> listOfSubjects;

    public Student(int id, int yearOfBirth, String year, String course, String index, ArrayList<String> listOfSubjects, String name, String surname, String email) {
        super(name, surname, email);
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.year = year;
        this.course = course;
        this.index = index;
        this.listOfSubjects = listOfSubjects;
    }

    public Student(int id, int yearOfBirth, String year, String course, String index, String name, String surname, String email,String jedanPredmet) {
        super(name, surname, email);
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.year = year;
        this.course = course;
        this.index = index;
        listOfSubjects = new ArrayList<>();
        listOfSubjects.add(jedanPredmet);
    }

    public Student(int id, int yearOfBirth, String year, String course, String index) {
        this.id = id;
        this.yearOfBirth = yearOfBirth;
        this.year = year;
        this.course = course;
        this.index = index;
        
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public ArrayList<String> getListOfSubjects() {
        return listOfSubjects;
    }

    public void setListOfSubjects(ArrayList<String> listOfSubjects) {
        this.listOfSubjects = listOfSubjects;
    }

    @Override
    public String toString() {
        String listaPredmeta = "";
        for(String s : listOfSubjects)
            listaPredmeta += "\t" +s+"\n";
        return "id: " + id +"\n"+ super.toString() + "\nGodina rodjenja: " + yearOfBirth + "\nGodina Upisa: " +year+ "\nSmer: " + course + 
                "\nIndex: " + index + "\n\nPredmeti:\n" + listaPredmeta;
    }



    
    

    
    
}
