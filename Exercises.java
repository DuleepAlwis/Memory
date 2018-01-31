package exercises;
import java.util.Scanner;

public class Exercises {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        memorya();
        
    }
    
    
    
    
    
    //This function use memory.java class
    //This shows a behaviour of a computer memory
    public static void memorya()
    {
        memory m=new memory(2000,300);
        m.allocate("P01",300);
        /*m.allocate("P02",500);
        m.allocate("P03",100);
        m.deallocate("P02");
        m.allocate("P07",150);
        m.allocate("P01",300);*/
        m.deallocate("P01");
        m.printme();
    }
    
    
}