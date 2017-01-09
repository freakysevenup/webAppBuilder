package Frontend;

/**
 * The Element class is an abstract class that provides the 
 * functionality that all Elements will require.
 * @author Jesse Derochie
 *
 */
public abstract class Element 
{
	/**
	 * The HTML string that is this element
	 */
	protected String element;
	
	/**
	 * The root element in the HTML tree
	 */
	protected HtmlMap<Element> root;
	
	/**
	 * The child HTML tree
	 */
	protected HtmlMap<Element> children;
	
	/**
	 * The parent HTML tree
	 */
	protected HtmlMap<Element> parent;
	
	/**
	 * Constructor
	 */
	public Element() 
	{ 
		root = new HtmlMap<Element>();
		children = new HtmlMap<Element>();
	}
	
	/**
	 * Returns the child HTMLMap
	 */
	protected abstract HtmlMap<Element> getChild();
	
	/**
	 * Returns the parent HTMLMap of this Element
	 */
	protected abstract HtmlMap<Element> getParent();
	
	/**
	 * Returns the HTML String of this element
	 */
	protected abstract String getString();
	
	/**
	 * Adds a child to this HTMLMap
	 */
	protected abstract HtmlMap<Element> getRoot();
	
	/**
	 * Returns the root HTMLMap
	 */
	protected abstract void addToRoot();
	
	/**
	 * Add this HTMLMap to the root
	 */
	protected abstract void addChild(Element child);
}
