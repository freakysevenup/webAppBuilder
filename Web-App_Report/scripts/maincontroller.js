
// The controller responsible for populating the navigation menu, and populating the tile, version and business date
app.controller("MainCtrl", ['$rootScope', '$scope', '$http', function($rootScope, $scope, $http)
{
    // The data for the buttons on the landing page is stored in this variable
    $scope.landingPage = [];

    $http.get('./jsonFiles/landingPage.json')
    .then(function (json)
    {
        json.data.forEach(function (row) 
        {
            $scope.landingPage.push(row);
        });
    });
}]);

