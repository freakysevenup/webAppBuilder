package Frontend;

import java.util.List;

/**
 * Div class used to create div tags around elements on the page
 * @author Jesse Derochie
 *
 */
public class Div extends Element
{
	/**
	 * Constructor
	 * @param divClass - The class of this div
	 * @param elements - A list of elements contained in div's in this div
	 */
	public Div(String divClass, List<Element> elements)
	{
		String returnValue = "<div class=\"" + divClass + "\">";
		for (Element e : elements)
		{
			returnValue += e.getString();
		}
		returnValue += "</div>";
		this.element = returnValue;
		assert(this.element.equals(returnValue));
	}
	
	/**
	 * Constructor
	 * @param divClass - The class of this div
	 * @param element - an element contained in this div
	 */
	public Div(String divClass, Element element)
	{
		this.element = "<div class=\"" + divClass + "\">" + element.getString() + "</div>";
		assert(this.element.equals("<div class=\"" + divClass + "\">" + element.getString() + "</div>"));
	}
	
	public Div(String divClass)
	{
		this.element = "<div class=\"" + divClass + "\"></div>";
		assert(this.element.equals("<div class=\"" + divClass + "\"></div>"));
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
