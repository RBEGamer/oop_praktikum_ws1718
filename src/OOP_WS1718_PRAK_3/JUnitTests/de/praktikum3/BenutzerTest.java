
package de.praktikum3;

	import java.io.*;
	import java.util.*;

		import org.junit.runners.MethodSorters;
		import org.junit.FixMethodOrder;

		import org.junit.Test;

		import static org.junit.Assert.*;

public class BenutzerTest {


		@Test(expected = AssertionError.class)
		public void stage_1 () throws Exception {
				Benutzer testuser1 = new Benutzer("abc", "123123131");
				Benutzer testuser2 = new Benutzer("abc", "123123111");
				assertEquals(true, testuser1.equals(testuser2));
		}


		@Test(expected = AssertionError.class)
		public void stage_2 () throws Exception {
				Benutzer testuser1 = new Benutzer("abc", "12312331");
				assertEquals(true, testuser1.toString() == "[de.praktikum3.Benutzer] username: abc password:123123131");
		}


}
