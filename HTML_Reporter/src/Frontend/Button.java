package Frontend;

/**
 * Extends Element (Abstract Class). This class is used to create 
 * buttons using HTML. 
 * @author Jesse Derochie
 *
 */
public class Button extends Element
{
	/**
	 * Constructor
	 * @param name - The Name on the button
	 * @param link - The link the button will send the user to
	 * @param buttonClass - The class of the button used for style (CSS)
	 */
	public Button(String name, String link, String buttonClass)
	{
		this.element = "<a href=\"" + link + "\" class=\"" + buttonClass + "\"><span>" + name + " </span></a>";
		assert(this.element.equals("<a href=\"" + link + "\" class=\"" + buttonClass + "\"><span>" + name + " </span></a>"));
	}
	
	public Button(String name, String buttonID, String onClickMethodName, String buttonClass)
	{
		this.element = "<a href=\"\"" + "id=\"" + buttonID + "\" onClick=\"" + onClickMethodName + "()\" class=\"" + buttonClass + "\"><span>" + name + " </span></a>";
		assert(this.element.equals("<a href=\"\"" + "id=\"" + buttonID + "\" onClick=\"" + onClickMethodName + "()\" class=\"" + buttonClass + "\"><span>" + name + " </span></a>"));
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
