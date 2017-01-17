package com.CPPIB.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Button;
import Frontend.Div;
import Frontend.Element;

public class DivTest 
{
	@Test(dataProvider="test")
	public void DivConstructorTest(Div _div)
	{
		Div div = _div;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] DivData()
	{
		List<Element> buttons = new ArrayList<Element>();
		buttons.add(new Button("", "", ""));
		buttons.add(new Button("", "", ""));
		
		return new Object[][]{
			new Object[] { new Div("DivClassName") },
			new Object[] { new Div("DivClassName", new Button("", "", "")) },
			new Object[] { new Div("DivClassName", buttons) }
		};
	}
}
