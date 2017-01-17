package Frontend;

/**
 * The Heading class is used to create Headings in HTML format
 * @author Jesse Derochie
 *
 */
public class Heading extends Element
{
	/**
	 * Constructor
	 * @param Heading - The Heading 
	 * @param HeadingType - The Size of the heading
	 */
	public Heading(String Heading, String HeadingType)
	{
		this.element = "<" + HeadingType + ">" + Heading + "</" + HeadingType + ">\n";
		assert(this.element.equals("<" + HeadingType + ">" + Heading + "</" + HeadingType + ">\n"));
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
