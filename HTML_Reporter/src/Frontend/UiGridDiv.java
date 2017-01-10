package Frontend;

import java.util.List;

public class UiGridDiv extends Element 
{
	/**
	 * Constructor
	 * @param controller - The controller of this app (For AngularJS)
	 */
	public UiGridDiv(String controllerName, Element element)
	{
		this.element = "<div ng-controller=\"" + controllerName + "\">" + element.getString() + "</div>";
	}
	
	public UiGridDiv(String controllerName, String className, Element element)
	{
		this.element = "<div ng-controller=\"" + controllerName + "\" class=\"" + className + "\">" + element.getString() + "</div>";
	}
	
	public UiGridDiv(String controllerName, String controllerClassName, List<Element> elements)
	{
		String value = "<div ng-controller=\"" + controllerName + "\" class=\"" + controllerClassName + "\">";
		for (Element ele : elements)
		{
			value += ele.getString();
		}
		value += "</div>";
		this.element = value;
	}
	
	public UiGridDiv(String uiGridName, String divClass, String[] directives)
	{
		String dirs = "";
		for (String d : directives)
		{
			dirs += d + " ";
		}
		this.element = "<div ui-grid=\"" + uiGridName + "\" " + dirs + "class=\"" + divClass + "\"></div>";
	}
	
	public UiGridDiv(String showVariableName, String uiGridName, String divClass, String[] directives, String onClickMethodName)
	{
		String dirs = "";
		for (String d : directives)
		{
			dirs += d + " ";
		}
		this.element = "<div ui-grid=\"" + uiGridName + "\" ng-show=\"" + showVariableName + "\" " + dirs + "class=\"" + divClass + "\" ng-click=\"" + onClickMethodName + "\"></div>";
	}
	
	public UiGridDiv(String uiGridName, String divClass, String[] directives, String onClickMethodName)
	{
		String dirs = "";
		for (String d : directives)
		{
			dirs += d + " ";
		}
		this.element = "<div ui-grid=\"" + uiGridName + "\" " + dirs + "class=\"" + divClass + "\" ng-click=\"" + onClickMethodName + "\"></div>";
	}
	
	public UiGridDiv(String showVariableName, String uiGridName, String divClass, String[] directives)
	{
		String dirs = "";
		for (String d : directives)
		{
			dirs += d + " ";
		}
		this.element = "<div ui-grid=\"" + uiGridName + "\" ng-show=\"" + showVariableName + "\" " + dirs + "class=\"" + divClass + "\"></div>";
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
