package Frontend;

/**
 * This class is used to create paragraphs in HTML format
 * @author Jesse Derochie
 *
 */
public class Paragraph extends Element
{
	/**
	 * Constructor
	 * @param paragraph - the paragraph to be contained
	 * @param bold - Should this be bold
	 * @param italic - Should this be italicized
	 * @param fontSize - The size of the font
	 * @param fontColour - the colour of the font
	 */
	public Paragraph(String paragraph, boolean bold, boolean italic, int fontSize, String fontColour)
	{
		if (bold && italic)
		{
			this.element = "<p><b><i><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</i></b></p>";
			assert(this.element.equals("<p><b><i><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</i></b></p>"));
		}
		else if(bold && !italic)
		{
			this.element = "<p><b><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</b></p>";
			assert(this.element.equals("<p><b><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</b></p>"));
		}
		else if (!bold && italic)
		{
			this.element = "<p><i><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</i></p>";
			assert(this.element.equals("<p><i><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</i></p>"));
		}
		else
		{
			this.element = "<p><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</p>";
			assert(this.element.equals("<p><style=\"" + fontColour + ";\"" + "font-size=\"" + fontSize + ";\">" + paragraph + "</p>"));
		}
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
