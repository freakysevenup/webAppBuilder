package Frontend;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is used to write all of the elements contained
 * within the HTMLMap to a file.
 * @author Jesse Derochie
 *
 */
public class PageWriter 
{
	FileWriter fWriter = null;
	BufferedWriter bWriter = null;
	
	/**
	 * Constructor
	 * @param filePath - The path to save the file to
	 * @param page - The page to read the data from
	 */
	public PageWriter(String filePath, Page page)
	{
		try {
		    fWriter = new FileWriter(page.getPageName() + ".HTML");
		    bWriter = new BufferedWriter(fWriter);
		    
		    // write this elements string then look to see if the element has a child, 
		    // if it has a child write that child's string to the file rinse and repeat.
		    if (page.children.hasChildren())
		    {
		    	// go through the list of children and write each element to the file
		    	// moving through the list by going through each of their children
		    	// before moving on to the item in the list.
		    	for (HtmlMap<Element> e : page.children.getChildren())
		    	{
		    		bWriter.write(e.getData().getString());
		    		bWriter.newLine();
		    		checkChildren(e);
		    	}
		    }
		    bWriter.close(); //make sure you close the writer object 
		} 
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method checks all children of the element parameter
	 * to discover is they also have children
	 * @param element - The element to check
	 */
	private void checkChildren(HtmlMap<Element> element)
	{
		if (element.hasChildren())
		{
			for (HtmlMap<Element> ele : element.getChildren())
			{
				try {
					bWriter.write(ele.getData().getString());
					bWriter.newLine();
					if (ele.hasChildren())
					{
						checkChildrensChildren(ele);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * This method checks all children of the element parameter
	 * to discover is they also have children
	 * @param element - the element to check
	 */
	private void checkChildrensChildren(HtmlMap<Element> element)
	{
		for (HtmlMap<Element> ele : element.getChildren())
		{
			try {
				bWriter.write(ele.getData().getString());
				bWriter.newLine();
				if (ele.hasChildren())
				{
					checkChildren(ele);
				}
			} catch (IOException e) 
			{
				e.printStackTrace();
			}


		}
	}
}
