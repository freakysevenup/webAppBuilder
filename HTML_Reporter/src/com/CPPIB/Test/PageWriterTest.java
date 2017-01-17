package com.CPPIB.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.NewPage;
import Frontend.Page;
import Frontend.PageWriter;

public class PageWriterTest 
{
	@Test(dataProvider="test")
	public void PageWriterConstructorTest(PageWriter pageWriter)
	{
		PageWriter div = pageWriter;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] PageWriterData()
	{
		return new Object[][]{
			new Object[] { new PageWriter("someFilePath", new Page("SomePageName", new NewPage(false, "someString"))) }
		};
	}
}
