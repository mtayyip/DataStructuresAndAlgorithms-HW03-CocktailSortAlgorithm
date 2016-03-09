/**
 * SpecList test metodu.SpecList String olarak test ettim.
 */
package com.mycompany;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author tayyip
 */
public class SpecListTest {
    
    private SpecList<String> testSpecList;
    private LinkedList<String> testArrayList;
    
    public SpecListTest()            
    {
        testSpecList=new SpecList<>();
        testArrayList=new LinkedList<>();
    }
    
    @BeforeClass
    public static void setUpClass() 
    {}
    
    @AfterClass
    public static void tearDownClass() 
    {}
    
    @Before
    public void setUp() 
    {
        testSpecList.add("yılmaz");
        testSpecList.add("murat");
        testSpecList.add("tayyip");
        
        testArrayList.add("tayyip");
        testArrayList.add("suat");
        testArrayList.add("zeki");
    }
    
    @After
    public void tearDown() 
    {}

    
    /**
     * Test of addAllAtHead method, of class SpecList.
     */
    @Test
    public void testAddAllAtHead() 
    {
        assertEquals(testSpecList.size(),3);
    }

    /**
     * Test of getIntersectList method, of class SpecList.
     */
    @Test
    public void testGetIntersectList() {
        List<String>result=new LinkedList<>();
        result.add("tayyip");
        assertEquals(testSpecList.getIntersectList(testArrayList),result);
    }

    /**
     * Test of sortList method, of class SpecList.
     */
    @Test
    public void testSortList() {
        SpecList<String>result=new SpecList<>();
        result.add("murat");
        result.add("tayyip");
        result.add("yılmaz");       
        testSpecList.sortList(1);
        assertEquals(testSpecList.sortList(1),result);
    }

    /**
     * Test of toString method, of class SpecList.
     */
    @Test
    public void testToString() 
    {
        String result="yılmaz-->murat-->tayyip";
        assertEquals(testSpecList.toString(), result);
    }
    
}
