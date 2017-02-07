
// The controller responsible for the tables, hiding/showing the menu and selecteing rows
app.controller("deptCtrl", ['$rootScope', '$scope', '$http', '$interval', function($rootScope, $scope, $http, $interval)
{
    // The results page object stores the data which will be represented in the treeview table
    $scope.resultsPage = [];
    // The details table data object stores the data which is displayed in the details table
    $scope.detailsTableData = [];
    // The list of json files gathered from a json file will be stored here
    $scope.jsonFilesList = [];
    // The variable which will store the completed export data in csv format
    $scope.exportData = [];
    // Temporary store house for export data the complete linege of the selected row is stored and ordered here
    $scope.lineage = [];
    // Variable used to store the current tree level of an element when recursively discovering the lineage of a row
    $scope.currentTreeLevels = [];
    // Set the default table height
    $scope.tableHeight = 430;
    // The title of the Details Table
    $scope.detailsTableTitle = null;
    // Fields for hiding/showing the elements on the page
    $scope.showNav = true;
    $scope.showTreeView = false;
    $scope.showBackButton = false;

    // Get the json file list
     $http.get("./jsonFiles/jsonFilesList.json")
            .then(function(json) 
            {
                // Set each row of the sjon file into the resultsPage object
                json.data.forEach(function (row) 
                {
                    $scope.jsonFilesList.push(row);
                });
            });

    // Retrieve the correct json file for the current test
    $scope.loadJsonFile = function(index)
    {
        $http.get($scope.jsonFilesList[index].filePath)
        .then(function(json) 
        {
            // Set each row of the sjon file into the resultsPage object
            json.data.forEach(function (row) 
            {
                $scope.resultsPage.push(row);
            });

            // for every item in the table, set its tree level
            for (var i = 0; i < $scope.table.data.length; i++)
            {
                $scope.table.data[i].$$treeLevel = $scope.table.data[i].treeLevel;

                // if the treeLevel is -1 splice the element from the data array using
                // $scope.table.data.splice({{index to remove}}, {{how many elements to remove from this point}});
                // so in this case $scope.table.data.splice(i, 1);
                // This element is the top of the house and doesn't need to be displayed in the treeView
            }
        });
    }

    // The treeView table options settings
    $scope.table = 
    {
        data: 'resultsPage',
        rowHeight: 30,
        headerRowHeight: 30,
        enableFiltering: true,
        multiSelect: false,
        showTreeExpandNoChildren: true,
        columnDefs: [
        { name: 'hierarchy', displayName: 'Level', width: '15%' },
        { name: 'name', width: '15%'  },
        { name: 'bValue', displayName: 'Baseline', width: '8%' },
        { name: 'cValue', displayName: 'Comparison', width: '8%'  },
        { name: 'diff', displayName: 'Diff', width: '8%'  },
        { name: 'diffpercent', displayName: 'Diff%', width: '8%'  },
        { name: 'result', displayName: 'Result', width: '8%' },
        { name: 'comments', displayName: 'Comments' }
        ],
        onRegisterApi: function (gridApi) 
        {
            $scope.gridApi = gridApi;
            gridApi.selection.on.rowSelectionChanged($scope, function(row){
                $scope.rowSelected(row);
            });
            // gridApi.selection.on.rowSelectionChangedBatch($scope, function(row){
            //     //rowSelected(row);
            // });
        }
    };

    // Use the currently selected row to determine what the title of the detailsTable will be
    $scope.rowSelected = function(row)
    {
        if ($scope.detailsTableTitle != null)
        {
            $scope.detailsTableTitle = null;
        }
        if(row.isSelected) { 
            $scope.detailsTableTitle = row.entity.name + " Value : " + row.entity.bValue + " Diff : " + row.entity.diff;
        }

        // get the tree level of this row
        $scope.rowTreeLevel = row.entity.treeLevel;

        // store all elements that are one level lower than this tree level
        $scope.details = [];
        $scope.exactRow = null;

        // get the exact element in the table data that is this row
        // using a primary key of the entire element
        for (var i = 0; i < $scope.table.data.length; i++)
        {
            var tableData = $scope.table.data[i].treeLevel
            + $scope.table.data[i].hierarchy
            + $scope.table.data[i].name
            + $scope.table.data[i].bValue
            + $scope.table.data[i].cValue
            + $scope.table.data[i].diff
            + $scope.table.data[i].diffpercent;

            var rowData = row.entity.treeLevel
            + row.entity.hierarchy
            + row.entity.name
            + row.entity.bValue
            + row.entity.cValue
            + row.entity.diff
            + row.entity.diffpercent;

            if(tableData === rowData)
            {
                $scope.exactRow = i;
                break;
            }
        }

        // run through the table data starting at the point after this row to find any children this row has
        for (var i = $scope.exactRow + 1; i < $scope.table.data.length; i++)
        {
            // if the treeLevel of the element in the tree is exactly 1 level lower the selected row
            if ($scope.table.data[i].treeLevel === ($scope.rowTreeLevel + 1))
            {
                $scope.details.push($scope.table.data[i]);
            }
            // however if it is either equal to or less than the rowTreeLevel, or greater than the rowTreeLevel by more than 1
            // stop checking for children because we have found them all
            else if ($scope.table.data[i].treeLevel > ($scope.rowTreeLevel + 1)
            || $scope.table.data[i].treeLevel < $scope.rowTreeLevel
            || $scope.table.data[i].treeLevel === $scope.rowTreeLevel)
            {
                break;
            }
        }

        // save those to the detailsTable data
        $scope.detailsTableData = $scope.details;
        $scope.detailsTable.data = $scope.detailsTableData;

        // get the export data based on the row that was clicked
        $scope.produceExportData(row);
    }

    // Produce the csv file data into a variable so that it can be exported easily
    $scope.produceExportData = function(row)
    {
        //TODO: Get all data related to this row, its lineage to the root and all its direct children save all that information into a variable
        // from top to bottom, which stores the column and rows as a csv file
        $scope.exportData.push(['Hierarchy', 'Name', 'Baseline_Value', 'Comparison_Value', 'Difference', 'Difference_Percentage', 'Result', 'Comments']);

        for (var i = 0; i < $scope.table.data.length; i++)
        {
            if ($scope.table.data[i].treeLevel === row.entity.treeLevel
            && $scope.table.data[i].name === row.entity.name)
            {
                // store lineage data recursively
                $scope.getLineage(i);

                console.log($scope.lineage);

                // reverse the order of the e;ements in the array so they are stored from top to bottom of the house
                $scope.lineage.reverse();

                // Now acquire all children into the lineage array
                $scope.getChildren(i);

                for (var j = 0; j < $scope.getChildren(i).length; j++)
                {
                    $scope.lineage.push([$scope.getChildren(i)[j]]);
                }
            }
        }

        // if there is actually data in the lineage array
        if ($scope.lineage.length > 0)
        {
            // read through the array and store the data in the export data array
            for (var i = 0; i < $scope.lineage.length; i++)
            {
                $scope.exportData.push($scope.lineage[i]);
            }
        }
    };

    // Recursive function used for obtaining the parent node of this element, and its parents, all the way to the root.
    $scope.getLineage = function(index)
    {
        var sibling = false;

        // if this elements treeLevel is in the currentTreeLevels array it is a sibling
        // set the sibling flag to true
        for (var j = 0; j < $scope.currentTreeLevels.length; j++)
        {
            // if the tree level was found in the currentTreeLevels array its a sibling
            // or the tree level of this index is higher than any value in the currentTreeLevels array
            // this element is either a sibling, or a child of another node.
            if($scope.currentTreeLevels[j] === $scope.table.data[index].treeLevel
            || $scope.currentTreeLevels[j] < $scope.table.data[index].treeLevel)
            {
                // you can't add this to the currentTreeLevels
                sibling = true;
            }
        }

        // if this element is not a sibling it can be added to the currentTreeLevels array
        // and the lineage array
        if (!sibling)
        {
            // add the current elements treeLevel to the currentTreeLevels array
            $scope.currentTreeLevels.push($scope.table.data[index].treeLevel);

            // add the current element to the lineage array
            $scope.lineage.push([
                $scope.table.data[index].hierarchy, 
                $scope.table.data[index].name, 
                $scope.table.data[index].bValue, 
                $scope.table.data[index].cValue, 
                $scope.table.data[index].diff, 
                $scope.table.data[index].diffpercent,
                $scope.table.data[index].result,
                $scope.table.data[index].comments
                ]);
        }

        // call this method again on the next element if there is one
        if (index - 1 > 0)
        {
            $scope.getLineage(index - 1);
        }

        $scope.currentTreeLevels = [];
    };

    // Function used to obtain all direct children of this node
    $scope.getChildren = function(index)
    {
        // // using the index of the selected row, store only direct children into the lineage of this selected row
        var children = [];

        for (var j = index + 1; j < $scope.table.data.length; j++)
        {
            if ($scope.table.data[j].treeLevel === ($scope.table.data[index].treeLevel + 1))
            {
                children.push([
                    $scope.table.data[j].hierarchy, 
                    $scope.table.data[j].name, 
                    $scope.table.data[j].bValue, 
                    $scope.table.data[j].cValue, 
                    $scope.table.data[j].diff, 
                    $scope.table.data[j].diffpercent,
                    $scope.table.data[j].result,
                    $scope.table.data[j].comments]);
            }
            else if ($scope.table.data[j].treeLevel > ($scope.table.data[index].treeLevel + 1)
            || $scope.table.data[j].treeLevel < ($scope.table.data[index].treeLevel + 1))
            {
                break;
            }
        }

        return children;
    };

    // Export onClick function called by button on html page (currently not linked to a button)
    $scope.exportCSV = function()
    {
        // ensure that exportData is not empty before doing this, or make sure tha a row is currently clicked
        var csvString = $scope.exportData.join("%0A");
        var a         = document.createElement('a');
        a.href        = 'data:attachment/csv,' + csvString;
        a.target      = '_blank';
        a.download    = 'attribution.csv';

        document.body.appendChild(a);
        a.click();
        // Clear out the variables which store the data for this csv file
        // allowing a user to click a new row and obtain that data in a new file.
        $scope.exportData = [];
        $scope.lineage = [];
        $scope.detailsTableData = [];
        $scope.detailsTableTitle = null;

        $scope.gridApi.selection.clearSelectedRows();
    };

    // Set the resultsPage object as the data for the treeView table
    $scope.table.data = $scope.resultsPage;

    // Dynamically set the height of the treeView table to either the height of the data or the height of 10 rows of data
    $scope.getTableHeight = function() 
    {
        var rowHeight = 30; 
        var headerHeight = 90; 

        if (($scope.table.data.length * rowHeight + headerHeight) > $scope.tableHeight || ($scope.table.data.length * rowHeight + headerHeight) == $scope.tableHeight)
        {
            angular.element(document.getElementsByClassName('table-1')[0]).css('height', $scope.tableHeight + 'px');
        }
        if (($scope.table.data.length * rowHeight + headerHeight) < $scope.tableHeight)
        {
            angular.element(document.getElementsByClassName('table-1')[0]).css('height', ($scope.table.data.length * rowHeight + headerHeight) + 'px');
        }
    };

    // The detailsTable options settings
     $scope.detailsTable = 
    {
        data: 'detailsTableData',
        rowHeight: 30,
        headerRowHeight: 30,
        footerRowHeight: 50,
        enableFiltering: true,
        multiSelect: false,
        paginationPageSizes: [10],
        paginationPageSize: 10,
        columnDefs: [
        { name: 'name' },
        { name: 'bValue', displayName: 'Baseline Value' },
        { name: 'cValue', displayName: 'Comparison Value' },
        { name: 'diff', displayName: 'Difference' },
        { name: 'diffpercent', displayName: 'Diff Percent', width: '15%'  },
        { name: 'result', displayName: 'Result' },
        { name: 'comments', displayName: 'Comments' }
        ],
        onRegisterApi: function (gridApi) 
        {
            $scope.detailGridApi = gridApi;
        }
    };

    // Dynamically set the height of the detailsTable to either the height of the data or 10 rows of data
    $scope.getDetailTableHeight = function() 
    {
        var rowHeight = 30; 
        var headerHeight = 135; 

        if (($scope.detailsTable.data.length * rowHeight + headerHeight) > $scope.tableHeight || ($scope.detailsTable.data.length * rowHeight + headerHeight) == $scope.tableHeight)
        {
            angular.element(document.getElementsByClassName('table-2')[0]).css('height', $scope.tableHeight + 'px');
        }
        if (($scope.detailsTable.data.length * rowHeight + headerHeight) < $scope.tableHeight)
        {
            angular.element(document.getElementsByClassName('table-2')[0]).css('height', ($scope.detailsTable.data.length * rowHeight + headerHeight) + 'px');
        }
    };

    // Show or hide the treeView table, detailsTable and back button
    $scope.showTreeViewTable = function(index)
    {
        $scope.loadJsonFile(index);
        $scope.showTreeView = $scope.showTreeView ? false : true;
        $scope.showNav = $scope.showNav ? false : true;
        $scope.showBackButton = $scope.showBackButton ? false : true;
        $scope.gridApi.core.refresh();
        $scope.detailGridApi.core.refresh();
    };

    // Show or hide the navigation menu
    $scope.returnToMenu = function()
    {
        $scope.showTreeView = $scope.showTreeView ? false : true;
        $scope.showNav = $scope.showNav ? false : true;
        $scope.showBackButton = $scope.showBackButton ? false : true;
    };
}]);