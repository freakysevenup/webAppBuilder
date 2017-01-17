package com.CPPIB.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Button;

public class ButtonTest 
{
	@Test(dataProvider="test")
	public void ButtonConstructorTest(Button button)
	{
		Button div = button;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] ButtonData()
	{
		return new Object[][]{
			new Object[] { new Button("ButtonName", "ButtonLink", "ButtonClassName") },
			new Object[] { new Button("ButtonName", "ButtonIDName", "ButtonOnClickMethodname", "ButtonClassName" ) }
		};
	}
}
