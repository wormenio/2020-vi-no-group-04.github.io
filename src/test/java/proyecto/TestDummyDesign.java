package proyecto;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Assert;

public class TestDummyDesign {

	private DummyDesign dummy = new DummyDesign();
	@Test
	public void testIntegrante4() {
		Assert.assertEquals(dummy.integrante4(), 4);		
	}

}
