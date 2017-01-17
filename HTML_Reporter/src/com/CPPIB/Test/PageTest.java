package com.CPPIB.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.ClosePage;
import Frontend.NewPage;
import Frontend.Page;

public class PageTest 
{
	@Test(dataProvider="test")
	public void PageConstructorTest(Page page)
	{
		Page div = page;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] PageData()
	{
		return new Object[][]{
			new Object[] { new Page("PageName", new NewPage(true, "testPage1")) },
			new Object[] { new Page("PageName", new NewPage(false, "testPage2")) }
		};
	}
	
	@Test(dataProvider="test1")
	public void NewPageConstructorTest(NewPage newPage)
	{
		NewPage div = newPage;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test1")
	public Object[][] NewPageData()
	{
		String[] scripts = { "stuff", "stuffalso"};
		String[] styleSheets = { "stylishstuff", "stylishstuffalso"};
		return new Object[][]{
			new Object[] { new NewPage(true, "testPage1") },
			new Object[] { new NewPage(false, "testPage2") },
			new Object[] { new NewPage(true, "testPage3", scripts, styleSheets, "AngularAppName") },
			new Object[] { new NewPage(false, "testPage4", scripts, styleSheets, "AngularAppName") },
			new Object[] { new NewPage(true, "testPage5", scripts, styleSheets) },
			new Object[] { new NewPage(false, "testPage5", scripts, styleSheets) }
		};
	}
	
	@Test(dataProvider="test2")
	public void ClosePageConstructorTest(ClosePage page)
	{
		ClosePage div = page;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test2")
	public Object[][] ClosePageData()
	{
		return new Object[][]{
			new Object[] { new ClosePage() }
		};
	}
}
