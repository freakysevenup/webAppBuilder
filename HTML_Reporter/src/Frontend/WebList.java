package Frontend;

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
		String returnData;
		if (ordered)
		{
			returnData = "<ol class=\"List\">";
		}
		else
		{
			returnData = "<ul class=\"List\">";
		}
		
		for (int i = 0; i < data.length; i++)
		{
			returnData += "<li>" + data[i] + "</li>";
		}
		this.element = returnData;
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
