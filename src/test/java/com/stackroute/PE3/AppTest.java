package com.stackroute.PE3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class AppTest {
	
	private static App app;
	
	@BeforeClass
	public static void setup() {
		app = new App();
	}
	
	@AfterClass
	public static void teardown() {
		app = null;
	}
	
	@Test
	public void test1() {
    	StudentMarks ob = new StudentMarks(8, new int[] {75, 80, 50, 101});
    	StudentMarks ob1 = new StudentMarks(8, new int[] {75, 80, 50, 90});
    	
    	assertEquals(new String("All in range"), ob1.checkError());
        assertEquals(new String("Not in range 0 to 100"), ob.checkError());
        assertNotNull(ob.getStuGrades());
        ob.setStuGrades(null);
        assertNull(ob.getStuGrades());
	}
    
	@Test
	public void test2() {
    	assertArrayEquals(new int[][] {{10, 10}, {10, 10}, {10, 10}}, app.getMatrix(3, 2, new int[][] {{1, 2}, {3, 4}, {5, 6}}, new int[][] {{9, 8}, {7, 6}, {5, 4}}));
        assertNotNull(app.getMatrix(3, 2, new int[][] {{1, 2}, {3, 4}, {5, 6}}, new int[][] {{9, 8}, {7, 6}, {5, 4}}));
        assertNull(app.getMatrix(3,  2, null, null));
	}
	
	@Test
	public void test3() {
		assertNotNull(app.getDate());
		assertEquals(new String("Mon 06/08/2018 Sun 12/08/2018"), app.getDate());
		assertTrue(app.getDate().startsWith("Mon"));
	}
	
	@Test
	public void test4() {
		assertNotNull(app.remVow(new String[] {"India", "United States", "Germany", "Egypt", "czechoslovakia"}));
		assertArrayEquals(new String[] {"nd", "ntd Stts", "Grmny", "gypt", "czchslvk"}, app.remVow(new String[] {"India", "United States", "Germany", "Egypt", "czechoslovakia"}));
		assertNull(app.remVow(null));
	}

	@Test
	public void test5() {
		assertNotNull(app.chess());
		assertArrayEquals(new String[][] {{"WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|"},
										  {"BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|"},
										  {"WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|"},
										  {"BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|"},
										  {"WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|"},
										  {"BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|"},
										  {"WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|"},
										  {"BB|", "WW|", "BB|", "WW|", "BB|", "WW|", "BB|", "WW|"}}, app.chess());
		assertTrue(app.chess()[0].length == 8);
		assertTrue(app.chess()[0][1].length() == 3);
	}
	
	@Test
	public void test6() {
		assertNotNull(app.isConsecutive(new String[] {"98", "96", "95", "94", "93"}));
		assertEquals(new String("are consecutive numbers"),app.isConsecutive(new String[] {"54", "53", "52", "51", "50", "49", "48"}));
		assertNull(app.isConsecutive(null));
	}
	
	@Test
	public void test7() {
		App.main(null);
		assertNotNull(App.ob);
		assertEquals(new String("Exception Occured"), App.ob);
		//assertNull(app.isConsecutive(null));
	}
	
	@Test
	public void test8() {
		assertNotNull(app.exceptionGen());
		assertEquals(new String("java.lang.NegativeArraySizeException java.lang.ArrayIndexOutOfBoundsException: 5 java.lang.NullPointerException "), app.exceptionGen());
		//assertEquals(new String("For input string: \"Singh\""), app.exceptionGen(new String[] {"Sashi", null, "Singh"}));
		//assertNull(app.isConsecutive(null));
	}
	
}
