

var app = angular.module("uigridApp", ['ui.grid', 'ui.grid.selection', 'ui.grid.cellNav', "ui.grid.pagination"]);

app.controller("uigridCtrl", function ($scope, $http) {

// How to grab data from a JSON file, needs to be hosted somewhere 
// must be an http:// request to attain the file
// Must know what the column headers will be ahead of time.
// $http.get('http://192.168.0.1/DTAF/tests/list.json')
//  .then(function (success){
//     $scope.firstTable.data = success.data;
// });

// ui-grid does not yet support selecting multiple rows at once.
// except by selecting the select all button at the top of the check box column

// First Table Data ////////////////////////////////////////////////////////////////
$scope.firstTable = {
  data: 'data',
  paginationPageSizes: [10, 25, 50, 75, 100],
  paginationPageSize: 10,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { field: 'Department',      displayName: 'Department' },
  { field: 'Value',           displayName: 'Value' },
  { field: 'Diff',            displayName: 'Diff' },
  { field: 'DiffPercent',     displayName: 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
    $scope.grid1Api = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope, $scope.firstTableElementWasClicked);
    gridApi.selection.on.rowSelectionChangedBatch($scope, $scope.firstTableElementWasClicked);
    if(row.isSelected) { 
    // always store pointer to last row only if it is selected
    $scope.firstTableLastSelection = row;
    }
  }
};

$scope.tableData1 = [
        { "Department": "Nickole Milne",        "Value": 34,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Addie Moretti",        "Value": 24,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Cleora Lasala",        "Value": 56,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Rosann Rotondo",       "Value": 33,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Carmelo Sterner",      "Value": 28,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Joey McNamara",        "Value": 42,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Branden Madrigal",     "Value": 37,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Mary Bobcageon",       "Value": 97,        "Diff": 4500,     "DiffPercent": 1000 },
        { "Department": "Spencer Grant",        "Value": 12,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Agustin Condra",       "Value": 38,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Adelaida Leeks",       "Value": 49,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Concepcion Fender",    "Value": 67,        "Diff": 6700,     "DiffPercent": 220 },
        { "Department": "Shaunta Bova",         "Value": 18,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Miguel Chickering",    "Value": 49,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Elliott Mailloux",     "Value": 42,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Deangelo Meachum",     "Value": 35,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Danyelle Coil",        "Value": 22,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Bryanna Neubauer",     "Value": 15,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Sharan Faught",        "Value": 84,        "Diff": 15000,    "DiffPercent": 10000 },
        { "Department": "Nereida Mcnulty",      "Value": 72,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Ahmed Runyon",         "Value": 64,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Debby Douville",       "Value": 79,        "Diff": 0,        "DiffPercent": 0 },
        { "Department": "Stephine Robinett",    "Value": 81,        "Diff": 0,        "DiffPercent": 0 }
]

$scope.firstTable.data = $scope.tableData1;

// Second Table Data //////////////////////////////////////////////////////////////
$scope.secondTable = {
  paginationPageSizes: [10, 25, 50, 75, 100],
  paginationPageSize: 10,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { field: 'Strategy',            displayName: 'Strategy' },
  { field: 'Value',               displayName: 'Value' },
  { field: 'Diff',                displayName: 'Diff' },
  { field: 'DiffPercent',         displayName: 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
  $scope.grid2Api = gridApi;
  gridApi.selection.on.rowSelectionChanged($scope, $scope.secondTableElementWasClicked);
  gridApi.selection.on.rowSelectionChangedBatch($scope, $scope.secondTableElementWasClicked);
  if(row.isSelected) { 
    // always store pointer to last row only if it is selected
    $scope.secondTableLastSelection = row;
    }
  }
};

$scope.tableData2 = [
        { Strategy: "Nickole Milne",      Value: 34,      Diff: 0,        DiffPercent: 0 },
        { Strategy: "Addie Moretti",      Value: 24,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Cleora Lasala",      Value: 56,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Rosann Rotondo",     Value: 33,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Carmelo Sterner",    Value: 28,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Joey McNamara",      Value: 42,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Branden Madrigal",   Value: 37,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Mary Bobcageon",     Value: 97,      Diff: 4500,     DiffPercent: 344  },
        { Strategy: "Spencer Grant",      Value: 12,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Agustin Condra",     Value: 38,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Adelaida Leeks",     Value: 49,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Concepcion Fender",  Value: 67,      Diff: 3400,     DiffPercent: 4000  },
        { Strategy: "Shaunta Bova",       Value: 18,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Miguel Chickering",  Value: 49,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Elliott Mailloux",   Value: 42,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Deangelo Meachum",   Value: 35,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Danyelle Coil",      Value: 22,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Bryanna Neubauer",   Value: 15,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Sharan Faught",      Value: 84,      Diff: 1200,     DiffPercent: 90  },
        { Strategy: "Nereida Mcnulty",    Value: 72,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Ahmed Runyon",       Value: 64,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Debby Douville",     Value: 79,      Diff: 0,        DiffPercent: 0  },
        { Strategy: "Stephine Robinett",  Value: 81,      Diff: 0,        DiffPercent: 0  }
    ];

$scope.secondTable.data = $scope.tableData2;

// Second Table Data //////////////////////////////////////////////////////////////
$scope.thirdTable = {
  paginationPageSizes: [10, 25, 50, 75, 100],
  paginationPageSize: 10,
  enableFiltering: true,
  multiSelect: true,
  modifierKeysToMultiSelect: true,
  columnDefs: [
  { field: 'ModelPortfolio',      displayName: 'Model Portfolio' },
  { field: 'Value',               displayName: 'Value' },
  { field: 'Diff',                displayName: 'Diff' },
  { field: 'DiffPercent',         displayName: 'Diff%' }
  ],
  onRegisterApi: function (gridApi) {
    $scope.grid3Api = gridApi;
    gridApi.selection.on.rowSelectionChanged($scope, null);
    gridApi.selection.on.rowSelectionChangedBatch($scope, null);
    if(row.isSelected) { 
    // always store pointer to last row only if it is selected
    $scope.thirdTableLastSelection = row;
    }
  }
};

$scope.tableData3 = [
        { ModelPortfolio: "Nickole Milne",      Value: 34,      Diff: 0,        DiffPercent: 0 },
        { ModelPortfolio: "Addie Moretti",      Value: 24,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Cleora Lasala",      Value: 56,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Rosann Rotondo",     Value: 33,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Carmelo Sterner",    Value: 28,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Joey McNamara",      Value: 42,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Branden Madrigal",   Value: 37,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Mary Bobcageon",     Value: 97,      Diff: 200,      DiffPercent: 34  },
        { ModelPortfolio: "Spencer Grant",      Value: 12,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Agustin Condra",     Value: 38,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Adelaida Leeks",     Value: 49,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Concepcion Fender",  Value: 67,      Diff: 5000,     DiffPercent: 400  },
        { ModelPortfolio: "Shaunta Bova",       Value: 18,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Miguel Chickering",  Value: 49,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Elliott Mailloux",   Value: 42,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Deangelo Meachum",   Value: 35,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Danyelle Coil",      Value: 22,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Bryanna Neubauer",   Value: 15,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Sharan Faught",      Value: 84,      Diff: 6900,     DiffPercent: 900  },
        { ModelPortfolio: "Nereida Mcnulty",    Value: 72,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Ahmed Runyon",       Value: 64,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Debby Douville",     Value: 79,      Diff: 0,        DiffPercent: 0  },
        { ModelPortfolio: "Stephine Robinett",  Value: 81,      Diff: 0,        DiffPercent: 0  }
    ];

$scope.thirdTable.data = $scope.tableData3;

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