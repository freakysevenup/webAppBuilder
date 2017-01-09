package Frontend;

import java.util.ArrayList;
import java.util.List;

/**
 * Data structure for storing HTML Elements in memory in order to 
 * later build a web-page. The HTMLMap takes a template data-type so that
 * this class can be used for future additions.
 * @author Jesse Derochie
 *
 * @param <T> The supplied DataType
 */
public class HtmlMap<T> 
{
	private List<HtmlMap<T>> m_children = new ArrayList<>();
	private HtmlMap<T> m_parent = null;
	private T data = null;
	
	/**
	 * Constructor
	 */
	public HtmlMap()
	{
		
	}
	
	/**
	 * Constructor
	 * @param data - The data to contain in this HTMLMap
	 */
	public HtmlMap(T data)
	{
		this.data = data;
	}
	
	/**
	 * Return the children of this HTMLMap
	 * @return m_children - the children of this element
	 */
	public List<HtmlMap<T>> getChildren()
	{
		return m_children;
	}
	
	/**
	 * Set the parent of this HTMLMap
	 * @param parent - the Parent to set to this HTMLMap object 
	 */
	public void setParent(HtmlMap<T> parent)
	{
		this.m_parent = parent;
	}
	
	/**
	 * Return the Parent of this HTMLMap
	 * @return m_parent - the parent of this HTMLMap
	 */
	public HtmlMap<T> getParent()
	{
		return this.m_parent;
	}
	
	/**
	 * Adds a child to this HTMLMap 
	 * @param data - The child to add to this HTMLMap
	 */
	public void addchild(T data)
	{
		HtmlMap<T> child = new HtmlMap<T>(data);
		child.setParent(this);
		this.m_children.add(child);
	}
	
	/**
	 * Adds a List of children to this HTMLMap
	 * @param children -  the list of children to add to this HTMLMap
	 */
	public void addChildren(List<HtmlMap<T>> children)
	{
		for (HtmlMap<T> html : children)
		{
			html.setParent(this);
		}
		this.m_children.addAll(children);
	}
	
	/**
	 * Returns the data stored in this HTMLMap
	 * @return data - The data of this HTMLMap
	 */
	public T getData()
	{
		return this.data;
	}
	
	/**
	 * Returns true if this HTMLMap has children
	 * @return m_children - True if there is children in this HTMLMap
	 */
	public boolean hasChildren()
	{
		return !getChildren().isEmpty();
	}
}
