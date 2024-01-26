/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HELLO
 */
public class Customer implements Comparable<Customer>{
    private String CustomerID;
    private String Name;
    private String Phone;
    private String dateOfBirth ;

    public Customer() {
    }

    public Customer(String CustomerID, String Name, String Phone, String dateOfBirth) {
        this.CustomerID = CustomerID;
        this.Name = Name;
        this.Phone = Phone;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void homenetworkCheck(int i) {
        switch (i) {
            case 1:
                System.out.println(CustomerID + "  |  "  +  Name + "  |  "  +  Phone + "  |  "  +  dateOfBirth + "  |  " + "Viettel");
                break;
            case 2:
                System.out.println(CustomerID + "  |  "  +  Name + "  |  "  +  Phone + "  |  "  +  dateOfBirth + "  |  " + "VinaPhone");
                break;
            case 3:
                System.out.println(CustomerID + "  |  "  +  Name + "  |  "  +  Phone + "  |  "  +  dateOfBirth + "  |  " + "MobiPhone");
                break;
            default:
                break;
        }
    }
    
    @Override
    public String toString() {
        return CustomerID + "  |  "  +  Name + "  |  "  +  Phone + "  |  "  +  dateOfBirth;
    }

    @Override
    public int compareTo(Customer c) {
           return this.Name.compareTo(c.Name);
        }
    
}
