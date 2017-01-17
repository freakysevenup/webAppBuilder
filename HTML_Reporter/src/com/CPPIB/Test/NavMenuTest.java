package com.CPPIB.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Button;
import Frontend.Element;
import Frontend.NavMenu;
import Frontend.WebList;


public class NavMenuTest 
{
	@Test(dataProvider="test")
	public void NavMenuConstructorTest(NavMenu navMenu)
	{
		NavMenu div = navMenu;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] NavMenuData()
	{
		String[] itemData = { "stuff", "moreStuff" };
		List<Element> elements = new ArrayList<Element>();
		elements.add(new WebList(false, itemData));
		elements.add(new Button("", "", ""));
		
		return new Object[][]{
			new Object[] { new NavMenu("NavMenuClassName", elements) },
			new Object[] { new NavMenu("NavMenuClassName", elements.get(0)) }
		};
	}
}
