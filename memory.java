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
public class memory {
    
    process head;
    int mtsize;
    int os;
    int space;
    
    public memory(int mtsize,int os)
    {
        this.mtsize=mtsize;
        this.os=os;
        this.space=os;
        
    }
    
    public boolean search(String id)
    {
        process c=head;
        while(c.next!=null)
        {
            if(c.id==id)
            {
                return true;
            }
            else
            {
                c=c.next;
            }
        }
        return false;
    }
    
    public void allocate(String id,int size)
    {
        process a=new process(id,size);
        
        if((this.mtsize-this.space)>=size)
        {
            if(this.head==null)
            {
                this.head=a;
                System.out.println("Done...");
                this.space=this.space+size;
                return;
            }
            process c=head;
            if(this.search(id)==true)
            {
                System.out.println("Already in the memory");
                return;
            }
            else
            {
                int t=this.os;
                while(c.next!=null)
                {
                    if(c.next.id==null && c.next.size>=size)
                    {
                        int k=c.next.size-size;
                        if(k>0)
                        {
                            process b=new process(null,k);
                            b.next=c.next.next;
                            a.next=b;
                            c.next=a;
                            System.out.println("Done...");
                        }
                        else
                        {
                            a.next=c.next.next;
                            c.next=a;
                            System.out.println("Done...");
                        }
                        this.space=this.space+size;
                        return;
                        
                    }
                    else
                    {
                        t=t+c.size;
                        c=c.next;
                    }
                }
                if((this.mtsize-t)>=size)
                {
                    c.next=a;
                    this.space=this.space+size;
                }
                else
                {
                    System.out.println("No space available");
                }
                return;
            }
        }
        else
        {
            System.out.println("No space available");
        }
    }
    
    public void deallocate(String id)
    {
        process c=this.head;
        while(c!=null)
        {
            if(c.id==id)
            {
                c.id=null;
                this.space=this.space-c.size;
                System.out.println("Process removed from the memory..."+c.size+"KB");
                return;
            }
            else
            {
                c=c.next;
            }
        }
        System.out.println("Process isn't in the memory");
    }
    
    public void printme()
    {
        process c=this.head;
        System.out.println("OS "+this.os);
        while(c!=null)
        {
            if(c.id==null)
            {
                System.out.println("Free node "+c.size+"KB");
            }
            else
            {
                System.out.println(c.id+" "+c.size);
            }
            c=c.next;
        }
        System.out.println("Free space "+(this.mtsize-this.space)+"KB");
        return;
        
    }
        
    
}
