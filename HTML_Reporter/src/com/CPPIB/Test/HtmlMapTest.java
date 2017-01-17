package com.CPPIB.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Button;
import Frontend.HtmlMap;
import Frontend.Element;

public class HtmlMapTest 
{
	HtmlMap<Element> testMap = new HtmlMap<Element>();
	
	@Test(dataProvider="test")
	public void HtmlMapConstructorTest(HtmlMap<Element> htmlMap)
	{
		HtmlMap<Element> div = htmlMap;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] HtmlMapData()
	{
		return new Object[][]{
			new Object[] { new HtmlMap<Element>() },
			new Object[] { new HtmlMap<Element>(new Button("", "", "")) }
		};
	}
	
	public void addChild()
	{
		testMap.addchild(new Button("", "", ""));
	}
	
	@Test
	public void HtmlMapHasChildrenTest()
	{
		for (int i = 0; i < 5; i++)
		{
			testMap.addchild(new Button("", "", ""));
			testMap.getChildren().get(i).addchild(new Button("", "", ""));
			testMap.getChildren().get(i).getChildren().get(0).addchild(new Button("", "", ""));
		}
		Assert.assertTrue(testMap.hasChildren());
	}
	
	@Test
	public void HtmlMapGetChildrenTest()
	{
		addChild();
		testMap.getChildren();
		Assert.assertTrue(testMap.getChildren() != null);
	}
	
	@Test
	public void HtmlMapSetParentTest()
	{
		addChild();
		HtmlMap<Element> newParentMap = new HtmlMap<Element>();
		testMap.getChildren().get(0).setParent(newParentMap);
		Assert.assertTrue(newParentMap.getChildren() != null);
	}
	
	@Test
	public void HtmlMapGetParentTest()
	{
		addChild();
		Assert.assertTrue(testMap.getChildren().get(0).getParent() != null);
	}
	
	@Test
	public void HtmlMapAddChildTest()
	{
		addChild();
		Assert.assertTrue(testMap.getChildren().get(0) != null);
	}
	
	@Test
	public void HtmlMapAddChildrenTest()
	{
		for (int i = 0; i < 3; i++)
		{
			addChild();
		}
		Assert.assertTrue(testMap.getChildren().get(0) != null 
				&& testMap.getChildren().get(1) != null 
				&& testMap.getChildren().get(2) != null );
	}
	
	@Test
	public void HtmlMapGetDataTest()
	{
		addChild();
		Assert.assertTrue(testMap.getChildren().get(0).getData() != null);
	}
}
