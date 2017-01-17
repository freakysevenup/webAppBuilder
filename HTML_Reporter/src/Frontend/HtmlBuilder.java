package Frontend;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.CPPIB.utilities.FileUtilities;

/**
 * This class builds an HTML page from the Output.xml file
 * @author Jesse Derochie
 *
 */
public class HtmlBuilder 
{	
	/**
	 * the PageWriter
	 */
	protected PageWriter pw;
	protected Map<String, List<String>> overviewButtonNames = new HashMap<String, List<String>>();
	protected Map<String, List<String>> buttonHierarchy = new HashMap<String, List<String>>();
	protected List<File> jsonFiles = new ArrayList<File>();
	
	/**
	 * Constructor
	 * @param pageName - The name of the page, and of the file
	 */
	public HtmlBuilder()
	{
		
	}
	
	public void buildPages(String JSON)
	{
//		//Store the parent and child test names so buttons can be created for the overview page
//		String parentTest = "";
//		String childTest = "";
//		Map<String, List<String>> overviewButtonNames = new HashMap<String, List<String>>();
//		
//		// Load all JSON files into an ArrayList
//		List<File> jsonFiles = new ArrayList<File>();
//		for(File f : FileUtilities.loadFilesFromPath(JSON))
//		{
//			jsonFiles.add(f);
//		}
//		
//		// for each file in the ArrayList obtain
//		// the parent test name
//		// the child test name
//		// create an entry in the map for this test to use on the overview page button list
//		// and then build the page
//		for (int i = 0; i < jsonFiles.size(); i++)
//		{
//			String fileName = FileUtilities.removeExtension(jsonFiles.get(i).getName());
//			parentTest = FileUtilities.split(fileName, "_")[0];
//			for (int k = 0; k < FileUtilities.split(fileName, "_").length; k++)
//			{
//				if (k > 0)
//				{
//					childTest += FileUtilities.split(fileName, "_")[k] + " ";
//				}
//			}
//		
//			// Build a string from the above for loop that contains the title of this page
//			// ie. for(childTest elements : childTest){ title += childTest[i]}
//			// then pass that through the buildPage method
//		
//			//create button name list here
//			List<String> hierarchy = new ArrayList<String>();
//			hierarchy.add(parentTest);
//			hierarchy.add(childTest);
//			//store buttons into a map so they can be gathered when all other test have completed
//			overviewButtonNames.put(fileName, hierarchy);
//			
//			parentTest = "";
//			childTest = "";
//			
//			// build the web page
//			buildPage(fileName, childTest);
//		}
//		
//		buildLandingPage();
		
		buildPage("PV_By_Risk_Hierarchy", "PV By Risk Hierarchy");
		buildLandingPage();
	}
	
	private void buildLandingPage()
	{
		// Example of how to use the HTML builder
		Page page;
		
		// Create the page object
		page = new Page("Overview", new NewPage(true, "CPPIB DTAF Landing Page"));
		
		// add the Headings
		page.addChild(new Div("title", new Heading("DTAF Regression Report", "h1")));
		page.addChild(new Div("version", new Heading("Abacus Version 2.6.0 UAT Release", "h2")));
		page.addChild(new Div("businessdate", new Heading("January 12th, 2017", "h3")));
		

		List<Element> parentNavMenu = new ArrayList<Element>();
		List<Element> childNavMenu = new ArrayList<Element>();	
		
		// if this list item is the parent of several child tests then
		// this is the way to create it on the page.
		
		childNavMenu.add(new ListItem(new Button("PV By Risk", "PV_By_Risk_Hierarchy.html", "matched").getString()));
		childNavMenu.add(new ListItem(new Button("PV By Model Portfolio", "PV_By_Risk_Hierarchy.html", "matched").getString()));
		childNavMenu.add(new ListItem(new Button("PV By Something", "PV_By_Risk_Hierarchy.html", "matched").getString()));
		
		parentNavMenu.add(
				new ListItem("list_header", new Button("PV", "", "matched"), new WebList(false, childNavMenu)));
		parentNavMenu.add(new ListItem("list_header", new Button("VaR", "PV_Invalid.html", "matched").getString()));
		parentNavMenu.add(new ListItem("list_header", new Button("DV01", "../pages/PV_Valid.html", "unmatched").getString()));
		parentNavMenu.add(new ListItem("list_header", new Button("FX", "../pages/PV_Invalid.html", "unmatched").getString()));
		parentNavMenu.add(new ListItem("list_header", new Button("CS01", "../pages/PV_Valid.html", "matched").getString()));
		
		//page.addChild(new Div("buttons", getNavMenu()));
		
		page.addChild(new Div("buttons", new NavMenu("menu_nav", new WebList(false, parentNavMenu))));

		// close the page
		page.closePage();
		
		// write the page
		pw = new PageWriter(page.getPageName(), page);
	}
	
	private void buildPage(String fileName, String pageTitle)
	{
		Page page;
		
		// Create a new page passing in the file name, page title, the scripts and the style sheets
		page = new Page(fileName, new NewPage(false, "CPPIB DTAF " + pageTitle, addScripts(), addStyleSheets()));
		
		// Add the title, version and business date information
		page.addChild(new Div("title", new Heading(pageTitle, "h1")));
		page.addChild(new Div("version", new Heading("Abacus Version 2.6.0 UAT Release", "h2")));
		page.addChild(new Div("businessdate", new Heading("January 12th, 2017", "h3")));
		
		// needed for ui-grid 
		String[] directives = {
				"ui-grid-pagination",
				"ui-grid-selection",
				"ui-grid-cellNav"
		};
		
		// list any tables that are going to be created
		List<Element> tables = new ArrayList<Element>();
		tables.add(new Div("space", new UiGridDiv("firstTable", "table-1", directives)));
		tables.add(new Div("space", new UiGridDiv("showSecondTable", "secondTable", "table-2", directives)));
		tables.add(new Div("space", new UiGridDiv("showThirdTable", "thirdTable", "table-3", directives)));
		
		// add the tables to the page
		page.addChild(new AngularDiv("uigridApp", new UiGridDiv("uigridCtrl", "tables", tables)));
		
		// when the page is completed close the page 
		page.closePage();
		
		// use the page writer class to run through all elements on the page and write them in the proper order
		pw = new PageWriter(page.getPageName(), page);
	}
	
	private String[] addStyleSheets()
	{
 		// include any style-sheets that are going to be needed by the pages that are created
		String[] style = {
				"<link rel=\"stylesheet\" href=\"http://ui-grid.info/release/ui-grid.css\" type=\"text/css\">",
				"<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">"
			};
		return style;
	}
	
	private String[] addScripts()
	{
		// Include any scripts that are going to be need in the pages that are created
		String[] scripts = {
				"<script src=\"http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js\"></script>",
				"<script src=\"http://ui-grid.info/release/ui-grid.js\"></script>",
				"<script src=\"angularGrid.js\"></script>",
				"<script src=\"onclick.js\"></script>"
		};
		return scripts;
	}
	
	private Element getNavMenu()
	{
		// the nav menu parent object
		List<Element> parentNavMenu = new ArrayList<Element>();
		
		// child nav menu object
		List<Element> childNavMenu = new ArrayList<Element>();	
		
		// the current parent
		String parent = "";
		
		// the current child
		String child = "";
		
		// the list of children of a particular parent
		List<String> children = new ArrayList<String>();
		
		// for every test that was run separate the tests into which tests are parents of others
		for (int i = 0; i < overviewButtonNames.size(); i++)
		{
			// get the parent and child of this specific test
			parent = overviewButtonNames.get(i).get(0);
			child = overviewButtonNames.get(i).get(1);
			
			// if the buttonHierarchy already contains an entry for the parent button
			// simply add the child to the list
			if (buttonHierarchy.containsKey(parent))
			{
				buttonHierarchy.get(parent).add(child);
			}
			// however if it is not already contained in the map
			// create a new child list and add the entry to the map
			else if (!buttonHierarchy.containsKey(parent))
			{
				children = new ArrayList<String>();
				children.add(child);
				buttonHierarchy.put(parent, children);
			}
		}
	
		// use the buttonHierarchy map to create the 
		// navigation menu object returned by this method
		for (int i = 0; i < buttonHierarchy.size(); i++)
		{
			// if the parent has more than one child then this button must be a tab not a button
			if (buttonHierarchy.get(i).size() > 1)
			{
				// for each child of this parent add an entry into the childNavMenu object
				for(int j = 0; j < buttonHierarchy.get(i).size(); j++)
				{
					childNavMenu.add(new ListItem(
							new Button(
									buttonHierarchy.get(i).toArray()[0].toString(), 
									buttonHierarchy.get(i).get(j) + ".html", 
									"matched").getString()));
				}
				
				// Create the navigation tab
				parentNavMenu.add(
				new ListItem("list_header", new Button("PV", "", "matched"), new WebList(false, childNavMenu)));
				
				childNavMenu.clear();				
			}
			// otherwise if this list only has one entry, then this 
			// button is a button
			else if(buttonHierarchy.get(i).size() == 1)
			{
				parentNavMenu.add(new ListItem("list_header", 
						new Button(
								buttonHierarchy.get(i).toArray()[0].toString(), 
								buttonHierarchy.get(i).get(0) + ".html", 
								"matched").getString()));
			}
		}
		return new NavMenu("menu_nav", new WebList(false, parentNavMenu));
	}
}
