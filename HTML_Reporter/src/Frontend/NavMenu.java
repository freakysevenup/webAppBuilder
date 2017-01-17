package Frontend;

import java.util.List;

public class NavMenu extends Element
{
	public NavMenu(String navMenuClassName, List<Element> elements)
	{
		String returnValue = "<nav class = \"" + navMenuClassName + "\"> ";
		for (Element ele : elements)
		{
			returnValue += ele.getString() + " ";
		}
		returnValue += "</nav>";
		this.element = returnValue;
		assert(this.element.equals(returnValue));
	}
	
	public NavMenu(String navMenuClassName, Element element)
	{
		this.element = "<nav class = \"" + navMenuClassName + "\"> " + element.getString() + "</nav>";
		assert(this.element.equals("<nav class = \"" + navMenuClassName + "\"> " + element.getString() + "</nav>"));
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
