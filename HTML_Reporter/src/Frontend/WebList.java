package Frontend;

import java.util.List;

/**
 * This class is used to create both Unordered Lists, and Ordered lists
 * @author Jesse Derochie
 *
 */
public class WebList extends Element
{
	/**
	 * constructor
	 * @param ordered - Should this list be ordered
	 * @param data - List of the data to contain in the list
	 */
	public WebList(boolean ordered, String[] data)
	{
		String returnValue;
		if (ordered)
		{
			returnValue = "<ol class=\"List\">";
		}
		else
		{
			returnValue = "<ul class=\"List\">";
		}
		
		for (int i = 0; i < data.length; i++)
		{
			returnValue += "<li>" + data[i] + "</li>";
		}
		
		if (ordered)
		{
			returnValue += "</ol>";
		}
		else
		{
			returnValue += "</ul>";
		}
		this.element = returnValue;
		assert(this.element.equals(returnValue));
	}
	
	/**
	 * constructor
	 * @param ordered - Should this list be ordered
	 * @param data - List of the data to contain in the list
	 * @param listItmeID - list item id tag
	 */
	public WebList(boolean ordered, List<Element> elements)
	{
		String returnValue;
		if (ordered)
		{
			returnValue = "<ol>";
		}
		else
		{
			returnValue = "<ul>";
		}
		
		for (int i = 0; i < elements.size(); i++)
		{
			returnValue += elements.get(i).getString();
		}
		returnValue += "</ul>";
		this.element = returnValue;
		assert(this.element.equals(returnValue));
	}
	
	/**
	 * Returns the child HTMLMap
	 * @return children - The child HTMLMap of Element
	 */
	@Override
	protected HtmlMap<Element> getChild() 
	{
		return this.children;
	}
	
	/**
	 * Returns the parent HTMLMap of this Element
	 * @return parent - The parent HTMLMap of this Element
	 */
	@Override
	protected HtmlMap<Element> getParent() 
	{
		return this.parent;
	}
	
	/**
	 * Returns the HTML String of this element
	 * @return element - The String of HTML that is this element
	 */
	@Override
	protected String getString() 
	{
		return this.element;
	}

	/**
	 * Adds a child to this HTMLMap
	 */
	@Override
	protected void addChild(Element child) 
	{
		children.addchild(child);
	}
	
	/**
	 * Returns the root HTMLMap 
	 * @return root - The Root HTMLMap
	 */
	@Override
	protected HtmlMap<Element> getRoot()
	{
		return this.root;
	}

	/**
	 * Add this HTMLMap to the root
	 */
	@Override
	protected void addToRoot() 
	{
		getRoot().addchild(this);
	}
}
