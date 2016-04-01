package assertions;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by Yassen on 2/13/2016.
 */
public class TestAssertions {

    @Test
    public void testAssertionsTrue() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


            if ( false ) {
                throw new AssertionError("test"); //no message
            }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        assertFalse("Assert false", false);

    }


    @Test
    public void testAssertionsFalse() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        assertFalse("Assert false", true);

    }

    @Test
    public void testAssertionsFail() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abc");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        fail();

    }

    @Test
    public void testAssertionsEquals() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abcd");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        //assertEquals(str1,str2);
        assertEquals("objects not equals", str1, str2);

    }

    @Test
    public void testAssertionsCompareArrays() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abcd");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        //assertEquals(str1,str2);
        assertArrayEquals(expectedArray,resultArray);

    }

    @Test
    public void testAssertionsNotNull() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abcd");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        //assertEquals(str1,str2);
        assertNotNull(str5);

    }

    @Test
    public void testAssertionsIsNull() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abcd");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        //assertEquals(str1,str2);
        assertNull(str3);
    }

    @Test
    public void testAssertionsSame() throws AssertionError {

        //test data
        String str1 = new String("abc");
        String str2 = new String("abcd");
        String str3 = null;
        String str4 = "abc";
        String str5 = "abc";

        int val1 = 5;
        int val2 = 6;

        String[] expectedArray = {"one", "two", "three"};
        String[] resultArray = {"one", "two", "three"};


        if ( false ) {
            throw new AssertionError("test"); //no message
        }


        //assertTrue("Failed: getting wrong value from login method", val1 > val2);

        //assertTrue(false);

        //assertEquals(str1,str2);
        assertSame(str5, str4);
    }

}

