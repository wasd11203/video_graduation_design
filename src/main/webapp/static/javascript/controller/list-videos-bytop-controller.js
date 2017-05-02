'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: ListByTopCtrl
 * @description
 * # ListByTopCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('ListByTopCtrl', function ($scope, $rootScope,$stateParams,commonservice) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	$scope.param = $stateParams
    	console.log($scope.param);
    	
    	$scope.initGirds = function(){
    		$scope.listGirdsByTopNav($scope.param);
    	}
    	
    	/**
    	 * 触发获取指定菜单下的视频列表的方法
    	 */
    	$scope.listGirdsByTopNav = function (param){
    		param.curPage = 1;
    		var url = 'home/listByNav';
    		$scope.listGirdsAction(url,param);
    	}
    	
    	/**
    	 * 列举 获取的菜单以及视频列表
    	 */
    	$scope.listGirdsAction = function(url,param){
    		
    		commonservice.postData(url,param).then(function(res){
    			console.log(res.data);
    			$scope.data = res.data;
    	    	
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	
    });
