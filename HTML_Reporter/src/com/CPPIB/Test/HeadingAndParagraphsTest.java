package com.CPPIB.Test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Frontend.Heading;
import Frontend.Paragraph;

public class HeadingAndParagraphsTest 
{
	@Test(dataProvider="test")
	public void HeadingConstructorTest(Heading heading)
	{
		Heading div = heading;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test")
	public Object[][] HeadingData()
	{
		return new Object[][]{
			new Object[] { new Heading("HeadingValue", "HeadingType") }
		};
	}
	
	@Test(dataProvider="test1")
	public void ParagraphConstructorTest(Paragraph paragraph)
	{
		Paragraph div = paragraph;
		Assert.assertTrue(div != null);
	}
	
	@DataProvider(name="test1")
	public Object[][] ParagraphData()
	{
		return new Object[][]{
			new Object[] { new Paragraph("ParagraphValue", true, true, 10, "ParagraphFontColour") },
			new Object[] { new Paragraph("ParagraphValue", false, true, 10, "ParagraphFontColour") },
			new Object[] { new Paragraph("ParagraphValue", true, false, 10, "ParagraphFontColour") },
			new Object[] { new Paragraph("ParagraphValue", false, false, 10, "ParagraphFontColour") }
		};
	}
}
