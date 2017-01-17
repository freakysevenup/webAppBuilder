package Frontend;

/**
 * Creates the opening lines of an HTML page
 * @author Jesse Derochie
 *
 */
public class NewPage extends Element
{
	/**
	 * Constructor
	 * @param landingPage - Is this a landing page
	 */
	public NewPage(boolean landingPage, String pageTitle)
	{
		String returnValue;
		String opening = "<!DOCTYPE html>"; // HTML 5 DOCTYPE declaration
		String header = "<html><body><head><title>" + pageTitle + "</title><link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\"></head>";
		String backbutton = new Div("aligner", new Div("backbutton", new Button("Back ", "../pages/overview.html", "button"))).getString();
		
		if (landingPage)
		{
			returnValue = opening + header;
		}
		else
		{
			returnValue = opening + header + backbutton;
		}
		this.element = returnValue;
		assert(this.element.equals(returnValue));
	}
	
	/**
	 * Constructor
	 * @param landingPage - is this a landing page
	 * @param scripts - the js scripts to include in this html
	 * @param stylesheets - the css style sheets to include in this html
	 * @param angularAppName - the name of this whole page angular app (entered into body tag)
	 */
	public NewPage(boolean landingPage, String pageTitle, String[] scripts, String[] stylesheets, String angularAppName)
	{
		String returnValue;
		String opening = "<!DOCTYPE html>"; // HTML 5 DOCTYPE declaration
		String jsScripts = "";
		String cssStyle = "";
		
		for (String s : scripts)
		{
			jsScripts += s + " ";
		}
		
		for (String s : stylesheets)
		{
			cssStyle += s + " ";
		}
		
		String header = "<html><body ng-app=\"" + angularAppName + "\"><head><title>" + pageTitle + "</title>" + jsScripts + cssStyle + "</head>";
		String backbutton = new Div("aligner", new Div("backbutton", new Button("Back ", "overview.html", "button"))).getString();
		
		if (landingPage)
		{
			returnValue = opening + header;
		}
		else
		{
			returnValue = opening + header + backbutton;
		}
		this.element = returnValue;
		assert(this.element.equals(returnValue));
	}
	
	/**
	 * Constructor
	 * @param landingPage - is this a landing page
	 * @param scripts - the js scripts to include in this html
	 * @param stylesheets - the css style sheets to include in this html
	 */
	public NewPage(boolean landingPage, String pageTitle, String[] scripts, String[] stylesheets)
	{
		String returnValue;
		String opening = "<!DOCTYPE html>"; // HTML 5 DOCTYPE declaration
		String jsScripts = "";
		String cssStyle = "";
		
		for (String s : scripts)
		{
			jsScripts += s + " ";
		}
		
		for (String s : stylesheets)
		{
			cssStyle += s + " ";
		}
		
		String header = "<html>\n<body>\n<head>\n<title>" + pageTitle + "</title>\n" + jsScripts + "\n" + cssStyle + "\n</head>";
		String backbutton = new Div("aligner", new Div("backbutton", new Button("Back ", "overview.html", "button"))).getString();
		
		if (landingPage)
		{
			returnValue = opening + header;
		}
		else
		{
			returnValue = opening + header + backbutton;
		}
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
