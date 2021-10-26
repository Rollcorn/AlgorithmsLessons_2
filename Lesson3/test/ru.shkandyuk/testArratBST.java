package ru.shkandyuk;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class testArratBST {
    aBST abst = new aBST(3);

    @Before
    public void before(){
        System.out.println("Size: " + abst.Tree.length );
    }

    @After
    public void after(){
        abst.printTree();
    }

    @Test
    public void testAddKey(){
        abst.AddKey(4);
        abst.AddKey(6);
        abst.AddKey(2);
        abst.AddKey(3);
        abst.AddKey(1);
        abst.AddKey(5);
        abst.AddKey(7);
        abst.AddKey(0);
        abst.AddKey(9);
    }

    @Test
    public void testFindKey(){
        abst.AddKey(4);
        abst.AddKey(6);
        abst.AddKey(2);
        abst.AddKey(3);
        abst.AddKey(1);
        abst.AddKey(5);
        abst.AddKey(7);
        abst.AddKey(0);
        abst.AddKey(9);

        System.out.println("Find index [5]: " + abst.FindKeyIndex(5) );
        System.out.println("Find index [0]: " + abst.FindKeyIndex(0) );
        System.out.println("Find index [9]: " + abst.FindKeyIndex(9) );

    }
}
