package Frontend;

public class ListItem extends Element
{
	public ListItem(String itemData)
	{
		this.element = "<li>" + itemData + "</li>";
		assert(this.element.equals("<li>" + itemData + "</li>"));
	}
	
	public ListItem(String listItemID, String itemData)
	{
		this.element = "<li id=\"" + listItemID + "\">" + itemData + "</li>";
		assert(this.element.equals("<li id=\"" + listItemID + "\">" + itemData + "</li>"));
	}
	
	public ListItem(String listItemID, Element element)
	{
		this.element = "<li id=\"" + listItemID + "\">" + element.getString() + "</li>";
		assert(this.element.equals("<li id=\"" + listItemID + "\">" + element.getString() + "</li>"));
	}
	
	public ListItem(String listItemID, Element element, WebList webList)
	{
		this.element = "<li id=\"" + listItemID + "\">" + element.getString() + webList.getString() + "</li>";
		assert(this.element.equals("<li id=\"" + listItemID + "\">" + element.getString() + webList.getString() + "</li>"));
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
