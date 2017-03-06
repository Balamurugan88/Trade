package com.clri.dto;

/**
 *
 * @author Balamurugan
 */
public class Customer {
   

//    public Category(String name,String description){
//        this.description = description;
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "Customer{" + "id=" + id + ", name=" + name + ", dob=" + Dob +",email=" +Email+'}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        this.Dob = dob;
    }
     public String getEmail() {
        return Email;
    }

    public void setEmail(String dob) {
        this.Email = Email;
    }

    public int id;
    public String name;
    public String Dob;
    public String Email;


}
