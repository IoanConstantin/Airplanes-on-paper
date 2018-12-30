package model;
import java.util.*;
public class DotComBust {
    
    private GameHelper helper= new GameHelper();
    private ArrayList<DotCom> dotComsList= new ArrayList<DotCom>();
    private int numOfGuesses=0;
    
    private void setUpGame(){
        DotCom one= new DotCom();
        one.setName("Pets.com");
        DotCom two= new DotCom();
        two.setName("eToys.com");
        DotCom three= new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        
        System.out.println("Scopul tau este sa scufunzi trei obiecte DotCom");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Incearca sa le scufunzi cu un nr cat mai mic de incercari");
        
        for(DotCom dotComToSet : dotComsList) {
            ArrayList<String> newLocation= helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    
    private void startPlaying(){
        while(!dotComsList.isEmpty()) {
            String userGuess=helper.getUserInput("Fa o incercare");
            checkUserGuess(userGuess);
        }
        finishGame();
    }
    
    private void checkUserGuess(String userGuess) {
        numOfGuesses++;
        String result="Ratat";
        for(DotCom dotComToTest : dotComsList) {
            
            result= dotComToTest.checkYourself(userGuess);
            if(result.equals("Lovit")) {
                break;
        }
            if(result.equals("Distrus")) {
                dotComsList.remove(dotComToTest);
                break;
            }
    }
        System.out.println(result);
}

private void finishGame() {
    System.out.println("Toate obiectele DotCom sunt distruse");
    System.out.println("Ai avut nevoie de doar " + numOfGuesses + " incercari. ");    
}

public static void main (String[] args) {
     DotComBust game= new DotComBust();
     game.setUpGame();
     game.startPlaying();
   }
}