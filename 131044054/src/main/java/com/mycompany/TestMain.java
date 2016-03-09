package com.mycompany;

import java.util.LinkedList;
import java.util.List;
/**
 * TestMain sinifi main metodunun bulundugu siniftir.TestMainde SpecList Integer
 * ile test yaparken JunitTest te SpecList String ile test ettim.Character ile de 
 * test edildi ve calismaktadir.
 */
public class TestMain 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)     
    {
        
        SpecList<Integer> specList=new SpecList<Integer>();
        specList.add(1);specList.add(4);specList.add(6);specList.add(3);
        specList.add(13);specList.add(6);specList.add(8);
        System.out.println("specList==>"+specList.toString());
        
        List<Integer> myList=new LinkedList<Integer>();
        myList.add(3);myList.add(6);myList.add(5);myList.add(4);
        myList.add(13);myList.add(6);myList.add(2);myList.add(1);
        System.out.println("myList==>"+myList.toString());
        

        
        /*getIntersectList() metodu exception firlatabilir.*/
        try{
        List<Integer> resultSecondMethod=new LinkedList<Integer>();
        resultSecondMethod=specList.getIntersectList(myList);
        System.out.println("getIntersectList==>"+resultSecondMethod.toString());
        }
        catch(NullPointerException e)
        {System.out.println(e.getMessage());}
        
        
        
        /*addAllAtHead() metodu exception firlatabilir.*/
        try{
        specList.addAllAtHead(myList);
        System.out.println("addAllAtHead==>"+specList.toString());
        }
        catch(NullPointerException e)
        {System.out.println(e.getMessage());}
        
        
        
        /*sortList() metodu exception firlatabilir.*/
        try{        
        List<Integer> resultThirdMethod=new LinkedList<Integer>(); 
        resultThirdMethod=specList.sortList(1);
        System.out.println("sortList==>"+resultThirdMethod.toString());
        }
        catch(NullPointerException e)
        {System.out.println(e.getMessage());}   
        
        
    } 
}