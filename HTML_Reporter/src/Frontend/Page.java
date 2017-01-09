package Frontend;

/**
 * This class is the current WebPage being constructed
 * @author Jesse Derochie
 *
 */
public class Page extends Element
{
	/**
	 * The Name of the page, used to save the file and link the file
	 */
	protected String pageName;
	
	/**
	 * Constructor
	 * @param pageName - The name of the page, and the file
	 * @param landingPage - is this a landing page
	 */
	public Page(String pageName, NewPage newPage)
	{
		// set the page name so we can save the file accordingly
		this.pageName = pageName;
		
		// ensure the new page is started accordingly
		this.addChild(newPage);
	}
	
	/**
	 * Close the current page with appropriate closing tags
	 */
	public void closePage()
	{
		this.addChild(new ClosePage());
	}
	
	/**
	 * returns the page name/filename
	 * @return m_pageName - the name of the page also of the file
	 */
	public String getPageName()
	{
		return pageName;
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
