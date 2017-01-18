

var app = angular.module("uigridApp", ['ui.grid', 'ui.grid.pagination', 'ui.grid.selection', 'ui.grid.cellNav', 'ui.grid.autoResize'])
.controller("uigridCtrl", function ($scope, $http) {

// ui-grid does not yet support selecting multiple rows at once.
// except by selecting the select all button at the top of the check box column

// First Table Data ////////////////////////////////////////////////////////////////
$scope.firstTable = {
  data: 'tableData1',
  rowHeight: 30,
  headerRowHeight: 30,
  footerRowHeight: 50,
  paginationPageSize: 10,
  pinSelectionCheckbox: true,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'Department',            "displayName": 'Department' },
  { "field": 'Baseline',              "displayName": 'Baseline' },
  { "field": 'Comparison',            "displayName": 'Comparison' },
  { "field": 'Diff',                  "displayName": 'Diff' },
  { "field": 'DiffPercent',           "displayName": 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
    $scope.grid1Api = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope, $scope.firstTableElementWasClicked);
    gridApi.selection.on.rowSelectionChangedBatch($scope, $scope.firstTableElementWasClicked);
    // if(row.isSelected) { 
    // // always store pointer to last row only if it is selected
    // $scope.firstTableLastSelection = row;
    // }
  }
};

// Read in the table data from a JSON file
$scope.tableData1 = [];
var i = 0;

 $http.get('http://dviappvmabac01/dtaf/DTAF_Report/jsonFiles/firstTableData.json')
 .then(function (success){
            success.data.forEach(function (row) {
                row.id = i; i++;
                $scope.tableData1.push(row);
            });
    $scope.firstTable.data = $scope.tableData1;
});

// Second Table Data //////////////////////////////////////////////////////////////
$scope.secondTable = {
  data: 'tableData2',
  rowHeight: 30,
  headerRowHeight: 30,
  footerRowHeight: 50,
  paginationPageSize: 10,
  pinSelectionCheckbox: true,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'Strategy',            "displayName": 'Strategy' },
  { "field": 'Baseline',            "displayName": 'Baseline' },
  { "field": 'Comparison',          "displayName": 'Comparison' },
  { "field": 'Diff',                "displayName": 'Diff' },
  { "field": 'DiffPercent',         "displayName": 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
  $scope.grid2Api = gridApi;
  gridApi.selection.on.rowSelectionChanged($scope, $scope.secondTableElementWasClicked);
  gridApi.selection.on.rowSelectionChangedBatch($scope, $scope.secondTableElementWasClicked);
  // if(row.isSelected) { 
  //   // always store pointer to last row only if it is selected
  //   $scope.secondTableLastSelection = row;
  //   }
  }
};

// Read in the table data from a JSON file
$scope.tableData2 = [];
var i = 0;

 $http.get('http://dviappvmabac01/dtaf/DTAF_Report/jsonFiles/secondTableData.json')
 .then(function (success){
            success.data.forEach(function (row) {
                row.id = i; i++;
                $scope.tableData2.push(row);
            });
    $scope.secondTable.data = $scope.tableData2;
});

// Third Table Data //////////////////////////////////////////////////////////////
$scope.thirdTable = {
  data: 'tableData3',
  rowHeight: 30,
  headerRowHeight: 30,
  footerRowHeight: 50,
  paginationPageSize: 10,
  pinSelectionCheckbox: true,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'ModelPortfolio',      "displayName": 'Model Portfolio' },
  { "field": 'Baseline',            "displayName": 'Baseline' },
  { "field": 'Comparison',          "displayName": 'Comparison' },
  { "field": 'Diff',                "displayName": 'Diff' },
  { "field": 'DiffPercent',         "displayName": 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
    $scope.grid3Api = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope, $scope.thirdTableElementWasClicked);
    gridApi.selection.on.rowSelectionChangedBatch($scope, $scope.thirdTableElementWasClicked);
    // if(row.isSelected) { 
    // // always store pointer to last row only if it is selected
    // $scope.thirdTableLastSelection = row;
    // }
  }
};

// Read in the table data from a JSON file
$scope.tableData3 = [];
var i = 0;

 $http.get('http://dviappvmabac01/dtaf/DTAF_Report/jsonFiles/thirdTableData.json')
 .then(function (success){
            success.data.forEach(function (row) {
                row.id = i; i++;
                $scope.tableData3.push(row);
            });
    $scope.thirdTable.data = $scope.tableData3;
});

// Fourth Table Data //////////////////////////////////////////////////////////////
$scope.fourthTable = {
  data: 'tableData4',
  rowHeight: 30,
  headerRowHeight: 30,
  footerRowHeight: 50,
  paginationPageSize: 10,
  pinSelectionCheckbox: true,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'Position',            "displayName": 'Position' },
  { "field": 'Baseline',            "displayName": 'Baseline' },
  { "field": 'Comparison',          "displayName": 'Comparison' },
  { "field": 'Diff',                "displayName": 'Diff' },
  { "field": 'DiffPercent',         "displayName": 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
    $scope.grid4Api = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope, null);
    gridApi.selection.on.rowSelectionChangedBatch($scope, null);
    // if(row.isSelected) { 
    // // always store pointer to last row only if it is selected
    // $scope.thirdTableLastSelection = row;
    // }
  }
};

// Read in the table data from a JSON file
$scope.tableData4 = [];
var i = 0;

 $http.get('http://dviappvmabac01/dtaf/DTAF_Report/jsonFiles/fourthTableData.json')
 .then(function (success){
            success.data.forEach(function (row) {
                row.id = i; i++;
                $scope.tableData4.push(row);
            });
    $scope.fourthTable.data = $scope.tableData4;
});

// Show/Hide additional tables if a row is selected.
$scope.showSecondTable = false;
$scope.showThirdTable = false;
$scope.showFourthTable = false;
$scope.firstTableElementWasClicked = function(){
        $scope.showSecondTable = $scope.showSecondTable ? false : true; 
        if (!$scope.showSecondTable)
        {
          $scope.grid2Api.selection.clearSelectedRows();
        }  
        $scope.grid2Api.core.refresh();
    };

$scope.secondTableElementWasClicked = function(){
        $scope.showThirdTable = $scope.showThirdTable ? false : true; 
        if (!$scope.showThirdTable)
        {
          $scope.grid3Api.selection.clearSelectedRows();
        }  
        $scope.grid3Api.core.refresh();            
    };

$scope.thirdTableElementWasClicked = function(){
        $scope.showFourthTable = $scope.showFourthTable ? false : true; 
        if (!$scope.showFourthTable)
        {
          $scope.grid4Api.selection.clearSelectedRows();
        }        
        $scope.grid4Api.core.refresh();      
    };

$scope.getFirstTableHeight = function() {
       var rowHeight = 30; // your row height
       var headerHeight = 135; // your header height
       if (($scope.firstTable.data.length * rowHeight + headerHeight) > 430 || ($scope.firstTable.data.length * rowHeight + headerHeight) == 430)
       {
          angular.element(document.getElementsByClassName('table-1')[0]).css('height', 430 + 'px');
       }
       if (($scope.firstTable.data.length * rowHeight + headerHeight) < 430)
       {
          angular.element(document.getElementsByClassName('table-1')[0]).css('height', ($scope.firstTable.data.length * rowHeight + headerHeight) + 'px');
       }
    };

$scope.getSecondTableHeight = function() {
       var rowHeight = 30; // your row height
       var headerHeight = 135; // your header height
       if (($scope.secondTable.data.length * rowHeight + headerHeight) > 430 || ($scope.secondTable.data.length * rowHeight + headerHeight) == 430)
       {
          angular.element(document.getElementsByClassName('table-2')[0]).css('height', 430 + 'px');
       }
       if (($scope.secondTable.data.length * rowHeight + headerHeight) < 430)
       {
          angular.element(document.getElementsByClassName('table-2')[0]).css('height', ($scope.secondTable.data.length * rowHeight + headerHeight) + 'px');
       }
    };

$scope.getThirdTableHeight = function() {
       var rowHeight = 30; // your row height
       var headerHeight = 135; // your header height
       if (($scope.thirdTable.data.length * rowHeight + headerHeight) > 430 || ($scope.thirdTable.data.length * rowHeight + headerHeight) == 430)
       {
          angular.element(document.getElementsByClassName('table-3')[0]).css('height', 430 + 'px');
       }
       if (($scope.thirdTable.data.length * rowHeight + headerHeight) < 430)
       {
          angular.element(document.getElementsByClassName('table-3')[0]).css('height', ($scope.thirdTable.data.length * rowHeight + headerHeight) + 'px');
       }
    };

$scope.getFourthTableHeight = function() {
       var rowHeight = 30; // your row height
       var headerHeight = 135; // your header height
       if (($scope.fourthTable.data.length * rowHeight + headerHeight) > 430 || ($scope.fourthTable.data.length * rowHeight + headerHeight) == 430)
       {
          angular.element(document.getElementsByClassName('table-4')[0]).css('height', 430 + 'px');
       }
       if (($scope.fourthTable.data.length * rowHeight + headerHeight) < 430)
       {
          angular.element(document.getElementsByClassName('table-4')[0]).css('height', ($scope.fourthTable.data.length * rowHeight + headerHeight) + 'px');
       }
    };
});