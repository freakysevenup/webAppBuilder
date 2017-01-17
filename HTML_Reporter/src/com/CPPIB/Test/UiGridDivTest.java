package com.CPPIB.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Button;
import Frontend.Element;
import Frontend.UiGridDiv;

public class UiGridDivTest 
{
	@Test(dataProvider="test")
	public void UiGridDivConstructorTest(UiGridDiv uiGridDiv)
	{
		UiGridDiv div = uiGridDiv;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] UiGridDivData()
	{
		List<Element> elements = new ArrayList<Element>();
		elements.add(new Button("", "", ""));
		
		String[] directives = { "stuff", "morestuff" };
		
		
		return new Object[][]{
			new Object[] { new UiGridDiv("UiGridDivControllerName", elements.get(0)) },
			new Object[] { new UiGridDiv("UiGridDivControllerName", "UiGridDivClassName", elements.get(0)) },
			new Object[] { new UiGridDiv("UiGridDivControllerName", "ControllerClassName", elements) },
			new Object[] { new UiGridDiv("UiGridName", "DivClassName", directives) },
			new Object[] { new UiGridDiv("ShowVariableName", "UiGridName", "DivClassName", directives, "OnClickMethodName") },
			new Object[] { new UiGridDiv("UiGridName", "DivClassName", directives, "OnClickMethodName") },
			new Object[] { new UiGridDiv("ShowVariableName", "UiGridName", "DivClassName", directives) }
		};
	}
}
