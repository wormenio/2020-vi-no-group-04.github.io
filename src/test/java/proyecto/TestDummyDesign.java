package proyecto;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

public class TestDummyDesign {

	private DummyDesign dummy = new DummyDesign();
	
	@Test
	public void testIntegrante1() {
		Assert.assertEquals(dummy.integrante1(), 1);		
	}
	
	@Test
	public void testIntegrante2() {
		Assert.assertEquals(dummy.integrante2(), 2);		
	}

	@Test
	public void testIntegrante3() {
		Assert.assertEquals(dummy.integrante3(), 3);
	}
	
	@Test
	public void testIntegrante4() {
		Assert.assertEquals(dummy.integrante4(), 4);		
	}
	
	@Test
	public void testIntegrante5() {
		Assert.assertEquals(dummy.integrante5(), 5);		
	}

}
