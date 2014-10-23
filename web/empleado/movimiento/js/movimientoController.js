
 var app =  angular.module("app",[]);
 
 app.controller("movimientoDetailController", function ($scope,$http){
     
     
     $scope.getMovimiento= function(){
       $http({
           method:"GET",
           url: contextPath + "/api/movimiento/" + $scope.movimiento.id
       }).success(function(data,status){
           $scope.movimiento=data;
       }).error(function (data,status){
           alert("Error"+status);
       });
         
         
     };
     
 });