package Frontend;

public class AngularDiv extends Element
{
	/**
	 * Constructor
	 * @param divClass - The class of this div
	 * @param appName - The app contained by this div (For AngularJS)
	 * @param controller - The controller of this app (For AngularJS)
	 * @param element - An element contained in this div
	 */
	public AngularDiv(String divClass, String appName, String controller, Element element)
	{
		this.element = "<div ng-app=" + "\"" + appName + "\"" + "ng-controller=" + "\"" + controller + "\"" + "class=\"" + divClass + "\">" + element.getString() + "</div>";
	}
	
	/**
	 * Constructor
	 * @param divClass - The class of this div
	 * @param appName - The app contained by this div (For AngularJS)
	 * @param controller - The controller of this app (For AngularJS)
	 */
	public AngularDiv(String divClass, String appName, String controller)
	{
		this.element = "<div ng-app=" + "\"" + appName + "\"" + "ng-controller=" + "\"" + controller + "\"" + "class=\"" + divClass + "\"></div>";
	}
	
	/**
	 * Constructor
	 * @param appName - The app contained by this div (For angularJS)
	 * @param controller - The controller of this app (For AngularJS)
	 */
	public AngularDiv(String appName, String controller)
	{
		this.element = "<div ng-app=" + "\"" + appName + "\"" + "ng-controller=" + "\"" + controller + "\"</div>";
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
