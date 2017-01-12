package Frontend;

import java.util.ArrayList;
import java.util.List;

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
	
	/**
	 * Constructor
	 * @param pageName - The name of the page, and of the file
	 */
	public HtmlBuilder()
	{
		
	}
	
	public void buildPages(String JSON)
	{
		/*
		 * Read from the JSON file here, and for each test in the JSON file 
		 * create a page using the elements in that test.
		 * 
		 * using the supplied element data to determine where the CSV data is, read the csv data 
		 * and create tables using UIGrid and AngularJS for each test
		 * 
		 * using the class names of the elements on the html pages, create a CSS file that properly styles 
		 * all of the pages similarly
		 * 
		 * NEED A DESTINATION TO SAVE THE FOLDER STRUCTURE TO
		 * 
		 * create a parent folder named DTAF + Current Data - save each html into a folder named pages, 
		 * each css into a folder named stylesheets, and each AngularJS file into a folder named js, 
		 * save the overview page to the parent folder (root folder)
		 * 
		 * Link each test to the overview page, through its back button.
		 * 
		 * Link the overview page to every test page through its button on the landing screen
		 */
		
		// Example of how to use the HTML builder
		Page page;
		
		// Create the page object
		page = new Page("Overview", new NewPage(true, "CPPIB DTAF Landing Page"));
		
		// add the Headings
		page.addChild(new Div("title", new Heading("DTAF Regression Report", "h1")));
		page.addChild(new Div("version", new Heading("Abacus Version 2.6.0 UAT Release", "h2")));
		page.addChild(new Div("businessdate", new Heading("January 12th, 2017", "h3")));
		
		List<Element> buttons = new ArrayList<Element>();
		buttons.add(new Div("space", new Button("PV", "PV_Valid.html", "matched")));
		buttons.add(new Div("space", new Button("VaR", "../pages/PV_Invalid.html", "matched")));
		buttons.add(new Div("space", new Button("DV01", "../pages/PV_Valid.html", "unmatched")));
		buttons.add(new Div("space", new Button("FX", "../pages/PV_Invalid.html", "unmatched")));
		buttons.add(new Div("space", new Button("CS01", "../pages/PV_Valid.html", "matched")));

		// add some elements
		page.addChild(new Div("buttons", buttons));
		
		// close the page
		page.closePage();
		
		// write the page
		pw = new PageWriter(page.getPageName(), page);
		
		
		
		// Write a page with some angular components -> uigrid components
		String[] scripts = {
				"<script src=\"http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js\"></script>",
				"<script src=\"http://ui-grid.info/release/ui-grid.js\"></script>",
				"<script src=\"angularGrid.js\"></script>"
		};
		
		String[] style = {
			"<link rel=\"stylesheet\" href=\"http://ui-grid.info/release/ui-grid.css\" type=\"text/css\">",
			"<link rel=\"stylesheet\" href=\"style.css\" type=\"text/css\">"
		};
		
		
		page = new Page("PV_Valid", new NewPage(false, "CPPIB DTAF PV By Risk Hierarchy Report", scripts, style));
		
		page.addChild(new Div("title", new Heading("PV By Risk Hierarchy", "h1")));
		page.addChild(new Div("version", new Heading("Abacus Version 2.6.0 UAT Release", "h2")));
		page.addChild(new Div("businessdate", new Heading("January 12th, 2017", "h3")));
		
		String[] directives = {
				"ui-grid-pagination",
				"ui-grid-selection",
				"ui-grid-cellNav"
		};
		
		List<Element> tables = new ArrayList<Element>();
		tables.add(new Div("space", new UiGridDiv("firstTable", "table-1", directives)));
		tables.add(new Div("space", new UiGridDiv("showSecondTable", "secondTable", "table-2", directives)));
		tables.add(new Div("space", new UiGridDiv("showThirdTable", "thirdTable", "table-3", directives)));
		
		page.addChild(new AngularDiv("uigridApp", new UiGridDiv("uigridCtrl", "tables", tables)));
		
		page.closePage();
		
		pw = new PageWriter(page.getPageName(), page);
		
	}
}
