'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: SearchCtrl
 * @description
 * # SearchCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('SearchCtrl', function ($scope,$state) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	$scope.param = {
    			keywords:'',
    			curPage:1
    	}
//    	alert("根据关键字查询");
    	$scope.search = function(){
    		$state.go("maincontent.result",$scope.param,{reload:true});
    	}
    });
