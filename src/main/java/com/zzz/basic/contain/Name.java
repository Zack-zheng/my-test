package com.zzz.basic.contain;

/**
 * Created by jack_ on 2016/3/20.
 */
public class Name implements Comparable{
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String firstName;

    public Name(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    @Override
    public boolean equals(Object o) {
        if(o instanceof Name){
            Name name = (Name) o;
            return  (firstName.equals(name.firstName))
                    &&(lastName.equals(name.lastName));
        }
        return super.equals(o);

    }

    @Override
    public int hashCode() {
        return firstName.hashCode();
    }
    public int compareTo(Object o ){
        Name n = (Name) o;
        int lastCmp = lastName.compareTo(n.lastName);
        return (lastCmp!=0 ? lastCmp:firstName.compareTo(n.lastName));
    }


}
