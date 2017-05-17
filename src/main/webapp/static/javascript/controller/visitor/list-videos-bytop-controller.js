'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: ListByTopCtrl
 * @description # ListByTopCtrl Controller of the vShow
 */
angular.module('vShow').controller('ListByTopCtrl',
		function($scope, $rootScope, $stateParams, commonservice,$state) {
			this.awesomeThings = [ 'HTML5 Boilerplate', 'AngularJS', 'Karma' ];
			$scope.param = $stateParams;
			console.log($scope.param);

			/**
		     * 分页插件配置
		     */
		    $scope.paginationConf = {
		            currentPage: 1,//当前页
		            totalItems: 0,//所有的记录数
		            itemsPerPage: 4,//每页的记录数
		            pagesLength: 15,// 用于计算可被点击的总页数
		            perPageOptions: [4],// 用于选择的 每页显示的记录数 数组
		            onChange: function(){
		            	
		            	var curPage = $scope.paginationConf.currentPage;
		            	var vSecId = $scope.param.vSecId;
		            	$scope.listGirdsByTopAndSecNav(vSecId,curPage);
		            }
		        };
			
			$scope.initGirds = function() {
				$scope.listGirdsByTopNav($scope.param);
			}

			/**
			 * 触发获取指定一级菜单下的第一页的视频列表的方法
			 */
			$scope.listGirdsByTopNav = function(param) {
				param.vSecId = '';
				param.curPage = 1;
				var url = 'home/listByNav';
				$scope.listGirdsAction(url, param);
			}

			/**
			 * 获取指定的 一级菜单，二级菜单的 指定页数据
			 */
			$scope.listGirdsByTopAndSecNav = function(secId,curPage){
				$scope.param.vSecId = secId;
				$scope.param.curPage = curPage;
				var url = 'home/listByNav';
				$scope.updateGirdsAction(url, $scope.param);
				
				return false;
			}
			
			/**
			 * 更换 视频列表
			 */
			$scope.updateGirdsAction = function(url, param) {

				commonservice.postData(url, param).then(function(res) {
					console.log(res.data);
					$scope.list = res.data.list;
					
					if($scope.list[0] == null){
						$scope.paginationConf.totalItems = 0;
					}else{
						$scope.paginationConf.totalItems = res.data.count;
					}
					
				}, function(res) {
					alert(res.status);
				});
			}
			
			/**
			 * 列举 获取的菜单以及视频列表
			 */
			$scope.listGirdsAction = function(url, param) {

				commonservice.postData(url, param).then(function(res) {
					console.log(res.data);
					$scope.data = res.data;
					$scope.param.vSecId = $scope.data.top.secList[0].vSecId;

					$scope.data.top.maxIndex = 4;
					$scope.data.top.leftList = [];
					$scope.data.top.dropList = [];
					for(var i = 0;i<$scope.data.top.secList.length;i++){
						if(i>= $scope.data.top.maxIndex){
							$scope.data.top.dropList.push($scope.data.top.secList[i]);
						}else{
							$scope.data.top.leftList.push($scope.data.top.secList[i]);
						}
					}
					
					$scope.list = $scope.data.list;  

					if($scope.list[0] == null){
						$scope.paginationConf.totalItems = 0;
					}else{
						$scope.paginationConf.totalItems = $scope.data.count;
					}
					
				}, function(res) {
					alert(res.status);
				});
			}

			/**
	    	 * 路由切换到 详情页
	    	 */
	    	$scope.toDetail = function(video){
	    		var param = {"vId":video.vId,"vSecId":video.vSecId};
	    		$state.go('maincontent.detail',param,{reload:true});
	    		
	    		return false;
	    	}

		});
