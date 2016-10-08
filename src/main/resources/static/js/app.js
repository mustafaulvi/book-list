/**
 * Created by usr on 10/8/16.
 */
var bookModule = angular.module('bookApp', ['']);
bookModule.controller('bookController',function ($scope,$http) {
    var urlBase="";
    //var urlBase="http://localhost:8080/";
    $scope.bookList = [];

    $http.get(urlBase + '/getAllBooks').
    success(function (data) {
        $scope.bookList = data.data;
    });


    
});
