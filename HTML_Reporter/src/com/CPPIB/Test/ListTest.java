package com.CPPIB.Test;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Button;
import Frontend.Element;
import Frontend.ListItem;
import Frontend.WebList;

public class ListTest 
{
	@Test(dataProvider="test")
	public void ListItemConstructorTest(ListItem listItem)
	{
		ListItem div = listItem;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] ListItemData()
	{
		String[] itemData = { "stuff", "moreStuff" };
		
		
		return new Object[][]{
			new Object[] { new ListItem("ListItemData") },
			new Object[] { new ListItem("ListItemIDName", "ListItemData") },
			new Object[] { new ListItem("ListItemIDName", new Button("", "", "")) },
			new Object[] { new ListItem("ListItemIDName", new Button("", "", ""), new WebList(false, itemData)) }
		};
	}
	
	@Test(dataProvider="test1")
	public void WebListConstructorTest(WebList webList)
	{
		WebList div = webList;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test1")
	public Object[][] WebListData()
	{
		String[] itemData = { "stuff", "moreStuff" };
		List<Element> elements = new ArrayList<Element>();
		elements.add(new Button("", "", ""));
		elements.add(new Button("", "", ""));
		
		return new Object[][]{
			new Object[] { new WebList(true, itemData) },
			new Object[] { new WebList(false, itemData) },
			new Object[] { new WebList(true, elements) },
			new Object[] { new WebList(false, elements) }
		};
	}
}
