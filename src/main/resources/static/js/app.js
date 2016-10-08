/**
 * Created by usr on 10/8/16.
 */
var bookModule = angular.module('bookApp',[]);
bookModule.controller('bookController',function ($scope,$http) {
    var urlBase="";
    $scope.bookList = [];

    $http.get(urlBase + '/getAllBooks').
    success(function (data) {
        $scope.bookList = data;
    });


    
});
