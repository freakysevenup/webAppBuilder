package com.CPPIB.Test;

import org.testng.annotations.*;
import org.testng.Assert;
import Frontend.*;

public class AngularDivTest 
{	   
	@Test(dataProvider="test")
	public void AngularDivConstructorTest(AngularDiv angularDiv)
	{
		AngularDiv div = angularDiv;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] AngularDivData()
	{
		return new Object[][]{
			new Object[] { new AngularDiv("AngularDivClassName", "AngularDivAppName", "AngularDivControllerName") },
			new Object[] { new AngularDiv("AngularDivAppName", "AngularDivControllername") },
			new Object[] { new AngularDiv("AngularDivClassName", "AngularDivAppName", "AngularDivControllername", new Button("", "", "")) },
			new Object[] { new AngularDiv("AngularDivAppName", new Button("", "", "")) }
		};
	}
}
