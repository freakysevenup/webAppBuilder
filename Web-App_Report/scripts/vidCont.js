app.controller("vidCont", function ($scope) {
    $scope.videos = [
    {
        "url": "https://www.youtube.com/watch?v=sa3bxp15y-c",
            "date": "2016-05-11"
    },
    {
        "url": "https://www.youtube.com/watch?v=EYZeusCR0_8&index=6&list=PLEmcr6J3r_lWU1nXVE7qCA-gGDpL9nSEW",
            "date": "2016-05-11"
    }
    ];
    });
    
    app.filter('trusted', ['$sce', function ($sce) {
        return function(url) {
        		var video_id = url.split('v=')[1].split('&')[0];
            return $sce.trustAsResourceUrl("https://www.youtube.com/embed/" + video_id);
        };
    }]);