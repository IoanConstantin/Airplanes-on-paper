package model;
import java.util.*;

public class DotCom {
    private ArrayList<String> locationCells;
    private String name;
    
    public void setLocationCells(ArrayList<String> loc){
        locationCells=loc;
    }
    
    public void setName(String n){
        name=n;
    }

    public String checkYourself(String userInput){
        String result="Ratat";
        int index=locationCells.indexOf(userInput);
        if(index>=0) {
            locationCells.remove(index);
            
            if(locationCells.isEmpty()) {
                result="Distrus";
                System.out.println("Ai scufundat "+ name + "  : ( ");
            } else {
                result= "Lovit";
            }
        }
        return result;
    }
}