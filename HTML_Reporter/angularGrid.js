var app = angular.module("uigridApp", ["ui.grid", "ui.grid.pagination"]);
                app.controller("uigridCtrl", function ($scope) {

                $scope.firstTable = {
                enableFiltering: true,
                columnDefs: [
                { field: 'Department' },
                { field: 'Value' },
                { field: 'Diff' },
                { field: 'DiffPercent' }
                ],
                onRegisterApi: function (gridApi) {
                $scope.grid1Api = gridApi;
                }
                };

                $scope.firstTable = {
                paginationPageSizes: [10, 25, 50, 75, 100],
                paginationPageSize: 10,
                columnDefs: [
                { field: 'Department' },
                { field: 'Value' },
                { field: 'Diff' },
                { field: 'DiffPercent' }
                ],
                onRegisterApi: function (gridApi) {
                $scope.grid1Api = gridApi;
                }
                };

                $scope.users = [
                        { Department: "Nickole Milne",        Value: 34,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Addie Moretti",        Value: 24,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Cleora Lasala",        Value: 56,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Rosann Rotondo",       Value: 33,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Carmelo Sterner",      Value: 28,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Joey McNamara",        Value: 42,        Diff: 4500,     DiffPercent: 1000 },
                        { Department: "Branden Madrigal",     Value: 37,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Mary Bobcageon",       Value: 97,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Spencer Grant",        Value: 12,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Agustin Condra",       Value: 38,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Adelaida Leeks",       Value: 49,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Concepcion Fender",    Value: 67,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Shaunta Bova",         Value: 18,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Miguel Chickering",    Value: 49,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Elliott Mailloux",     Value: 42,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Deangelo Meachum",     Value: 35,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Danyelle Coil",        Value: 22,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Bryanna Neubauer",     Value: 15,        Diff: 15000,    DiffPercent: 10000 },
                        { Department: "Sharan Faught",        Value: 84,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Nereida Mcnulty",      Value: 72,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Ahmed Runyon",         Value: 64,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Debby Douville",       Value: 79,        Diff: 0,        DiffPercent: 0 },
                        { Department: "Stephine Robinett",    Value: 81,        Diff: 0,        DiffPercent: 0 }
                    ];

                $scope.firstTable.data = $scope.users;

                $scope.secondTable = {
                enableFiltering: true,
                columnDefs: [
                { field: 'ModelPortfolio' },
                { field: 'Value' },
                { field: 'Diff' },
                { field: 'DiffPercent' }
                ],
                onRegisterApi: function (gridApi) {
                $scope.grid1Api = gridApi;
                }
                };

                $scope.secondTable = {
                paginationPageSizes: [10, 25, 50, 75, 100],
                paginationPageSize: 10,
                columnDefs: [
                { field: 'ModelPortfolio' },
                { field: 'Value' },
                { field: 'Diff' },
                { field: 'DiffPercent' }
                ],
                onRegisterApi: function (gridApi) {
                $scope.grid1Api = gridApi;
                }
                };

                $scope.users = [
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

                $scope.secondTable.data = $scope.users;


                });