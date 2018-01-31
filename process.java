/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises;

/**
 *
 * @author user
 */
public class process {
    
    String id;
    int size;
    process next;
    
    public process(String id,int size)
    {
        this.id=id;
        this.size=size;
        this.next=null;
    }
    
    
}
