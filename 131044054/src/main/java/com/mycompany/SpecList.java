package com.mycompany;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * SpecList sinifi LinkedeList sinifi ve Comparable interface ini extends etmektedir
 * icerisinde addAllAtHead metodu,getIntersectList metodu,sortList metodu ve Object
 * sinifindan override ettigim toString metodlari bulunmaktadir. 
 * @author tayyip
 * @param <E> generics tip
 */
public class SpecList<E extends Comparable<E>> extends LinkedList<E>
{

    /**
     * Parametre olarak gelen Collection tipindeki veriyi specList'imizin basina ekliyor.Bunun 
     * icin iteratorun hasNext()metodu ile kontrol edip LinkedList in add(index,eleman) metodu
     * ile eleman ekledim.
     * @param c specList e eklenmek istenen Collection
     * @return ekleme basarili veya basarisiz diye return ediyor
     * @throws NullPointerException SpecList veya eklenmek istenen Collection null'sa exception firlatiyor.
     */
    public boolean addAllAtHead(Collection<? extends E> c)throws NullPointerException
    {   
        if(this==null || c==null)
            throw new NullPointerException("SpecList veya eklenmek istenen Collection null'dir.");
        
        int index=0;
        for(Iterator<? extends E> iter = c.iterator();iter.hasNext()==true;)
        {
            E elem = iter.next();
            this.add(index,elem);
            index++;
        } 
        return true;
    }
    


    /**
     * Parametre olarak gelen Collection tipindeki veriyi specList'imizin ortak olan elemanlarini tekrarsız yazan metot.Listemde
     * ayni elemanin birden fazla olmamasi icinde indexOf metodu ile kontrol edip listeye ekleme yaptim.
     * @param c specList te aranmak istenen Collection
     * @return yeni bir List olusturup her iki sinifta da olan elemanlari yeni list'e atip
     * list'i return ediyor
     * @throws NullPointerException SpecList veya aranmak istenen Collection null'sa exception firlatiyor.
     */
    public List<E> getIntersectList (Collection<? extends E> c)throws NullPointerException
    {
        if(this==null || c==null)
            throw new NullPointerException("SpecList veya aranmak istenen Collection null'dir.");
        
        List<E> list = new LinkedList<E>(); 
        for(Iterator<? extends E> iter=c.iterator();iter.hasNext()==true;)
        {
            E elem=iter.next();
            if(this.indexOf(elem)!=-1 && list.indexOf(elem)==-1)
                list.add(elem);
        }
        return list;
    }
    

    
    /**
     * Cocktail Sort algoritmasi ile siralama yapan metot.karsilastirma sirasinda
     * compareTo metodunu kullaniyorum.Cocktail Sort icin:
     * https://en.wikipedia.org/wiki/Cocktail_shaker_sort
     * Parametre olarak 1 veya -1 girilmezse hata mesaji verip specList i siralamadan return ediyor.
     * @param deger 1 veya -1 degeri alir.1 kucukten buyuge ,-1 buyukten kucuge siralar.     
     * @return uzerinde cagrilan specList i siralayip return ediyor
     * @throws NullPointerException SpecList null'sa exception firlatiyor.
     */
    public List<E> sortList(int deger)throws NullPointerException
    {
        if(this==null)
            throw new NullPointerException("SpecList null'dir.");
        
        if(deger==1){
            boolean swapped;
            do{
                swapped=false;

                for(int i=0;i<this.size()-1;i++){
                    if(this.get(i).compareTo(this.get(i+1))>0){
                        E temp=this.get(i);
                        this.set(i,this.get(i+1));
                        this.set(i+1,temp);
                        swapped=true;}}
    
                if(!swapped)
                    break;
        
                swapped=false;
                for(int i=this.size()-1;i>0;i--){
                    if(this.get(i-1).compareTo(this.get(i))>0){
                        E temp=this.get(i);
                        this.set(i,this.get(i-1));
                        this.set(i-1,temp);
                        swapped=true;}}
	
            }while(swapped);  
            return this;}
        
        
        else if(deger==-1){
            boolean swapped;
            do{
                swapped=false;

                for(int i=0;i<this.size()-1;i++){
                    if(this.get(i).compareTo(this.get(i+1))<0){
                        E temp=this.get(i);
                        this.set(i,this.get(i+1));
                        this.set(i+1,temp);
                        swapped=true;}}
    
                if(!swapped)
                    break;
        
                swapped=false;
                for(int i=this.size()-1;i>0;i--){
                    if(this.get(i-1).compareTo(this.get(i))<0){
                        E temp=this.get(i);
                        this.set(i,this.get(i-1));
                        this.set(i-1,temp);
                        swapped=true;}}
	
            }while(swapped);  
            return this;}
        
        else{
            System.out.println("\nHata.1 veya -1 giriniz.1 kucukten buyuge ,-1 buyukten kucuge siralar.");
            return this;}
        
    }
    
    
    /**
     * Object sinifindan override ettigim toString metodu ile verileri ekrana yaziyorum 
     * @return tum verileri bir string te tutup o stringi return ediyorum
     */
    @Override
    public String toString()
    {
        String str="";     
        for(int i=0;i<this.size();i++)
        {
            str+=this.get(i);
            if(i<this.size()-1)
                str+="-->";       
        }  
        return str;
    }
}