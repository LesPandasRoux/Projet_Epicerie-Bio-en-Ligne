package testAdaming;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import com.fr.adaming.TestClass;

public class Test {
	
	TestClass t;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		t = new TestClass(10,5);
	}

	@After
	public void tearDown() throws Exception {
	}

	@org.junit.Test
	public void test() {
		int result = t.add();
		assertEquals(15, result);
	}

}
