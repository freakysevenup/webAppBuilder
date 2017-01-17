

var app = angular.module("uigridApp", ['ui.grid', 'ui.grid.selection', 'ui.grid.cellNav', "ui.grid.pagination"]);

app.controller("uigridCtrl", function ($scope, $http) {

// ui-grid does not yet support selecting multiple rows at once.
// except by selecting the select all button at the top of the check box column

// First Table Data ////////////////////////////////////////////////////////////////
$scope.firstTable = {
  data: 'tableData1',
  paginationPageSizes: [10, 25, 50, 75, 100],
  paginationPageSize: 10,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'Department',      "displayName": 'Department' },
  { "field": 'Value',           "displayName": 'Value' },
  { "field": 'Diff',            "displayName": 'Diff' },
  { "field": 'DiffPercent',     "displayName": 'Diff%' }
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

 $http.get('http://dviappvmabac01/dtaf/jsonFiles/firstTableData.json')
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
  paginationPageSizes: [10, 25, 50, 75, 100],
  paginationPageSize: 10,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'Strategy',            "displayName": 'Strategy' },
  { "field": 'Value',               "displayName": 'Value' },
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

 $http.get('http://dviappvmabac01/dtaf/jsonFiles/secondTableData.json')
 .then(function (success){
            success.data.forEach(function (row) {
                row.id = i; i++;
                $scope.tableData2.push(row);
            });
    $scope.secondTable.data = $scope.tableData2;
});

// Second Table Data //////////////////////////////////////////////////////////////
$scope.thirdTable = {
  data: 'tableData3',
  paginationPageSizes: [10, 25, 50, 75, 100],
  paginationPageSize: 10,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { "field": 'ModelPortfolio',      "displayName": 'Model Portfolio' },
  { "field": 'Value',               "displayName": 'Value' },
  { "field": 'Diff',                "displayName": 'Diff' },
  { "field": 'DiffPercent',         "displayName": 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
    $scope.grid3Api = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope, null);
    gridApi.selection.on.rowSelectionChangedBatch($scope, null);
    // if(row.isSelected) { 
    // // always store pointer to last row only if it is selected
    // $scope.thirdTableLastSelection = row;
    // }
  }
};

// Read in the table data from a JSON file
$scope.tableData3 = [];
var i = 0;

 $http.get('http://dviappvmabac01/dtaf/jsonFiles/thirdTableData.json')
 .then(function (success){
            success.data.forEach(function (row) {
                row.id = i; i++;
                $scope.tableData3.push(row);
            });
    $scope.thirdTable.data = $scope.tableData3;
});

// Show/Hide additional tables if a row is selected.
$scope.showSecondTable = false;
$scope.showThirdTable = false;
$scope.firstTableElementWasClicked = function(){
        $scope.showSecondTable = $scope.showSecondTable ? false : true; 
        if (!$scope.showSecondTable)
        {
          $scope.grid2Api.selection.clearSelectedRows();
        }  
    };

$scope.secondTableElementWasClicked = function(){
        $scope.showThirdTable = $scope.showThirdTable ? false : true; 
        if (!$scope.showThirdTable)
        {
          $scope.grid3Api.selection.clearSelectedRows();
        }              
    };
});