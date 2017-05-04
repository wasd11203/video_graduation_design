'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: DetailCtrl
 * @description
 * # DetailCtrl
 * Controller of the vShow
 */
angular.module('vShow')
    .controller('DetailCtrl', function ($scope, $rootScope,$sce,commonservice,$state,$stateParams,$interval) {
    	this.awesomeThings = [
            'HTML5 Boilerplate',
            'AngularJS',
            'Karma'
        ];
    	
    	console.log($stateParams);
    	
    	/**
    	 * 配置 点赞后的样式
    	 */
    	$scope.fabStyle = {
	        "color" : "red",
	    }
    	/**
    	 * 配置 取消点赞后的样式
    	 */
    	$scope.unfabStyle = {
	    }
    	
    	$scope.initCtrl = function(){
    		$scope.loadVideoDetailAction();
    		$scope.loadVideoCommentsAction(1);
    		$scope.loadRecommendResource();
    	}
    	
    	/**
    	 * 点击发送验证码
    	 */
    	var count = 50;
    	var timer = null;
    	$scope.btnDisabled = false;
    	$scope.btnContent = '发送验证码';
    	$scope.sendVerifyCodeBtn = function(){
    		$scope.btnDisabled = true;
    		if(!timer){
    			timer=$interval(function(){
    				
	   	       	     $scope.btnContent = count+'S';
	   	       	     count--;
	   	       	     if(count == 0){
	   	       	    	 if(timer){
	   	       	    		 $scope.btnDisabled = false;
	   	       	    		 $scope.btnContent = '发送验证码';
	   	       	    		 $interval.cancel(timer);
	   	       	    		 timer = null;
	   	       	    	 }
	   	       	     }
	   	       	},1000);   //间隔2秒定时执行
    		}
    		
    		return false;
    	}
    	
    	
    	/**
	     * 分页插件配置
	     */
	    $scope.paginationConf = {
	            currentPage: 1,//当前页
	            totalItems: 140,//所有的记录数
	            itemsPerPage: 15,//每页的记录数
	            pagesLength: 8,// 用于计算可被点击的总页数
	            perPageOptions: [15],// 用于选择的 每页显示的记录数 数组
	            onChange: function(){
	            	$scope.loadVideoCommentsAction($scope.paginationConf.currentPage);
	            }
	        };
    	
    	$scope.config = {
			sources: [
				{
					src: $sce.trustAsResourceUrl("http://static.videogular.com/assets/videos/videogular.webm"),
					type: "video/webm"
				}
			],
			tracks: [{
				src: "http://www.videogular.com/assets/subs/pale-blue-dot.vtt",
				kind: "subtitles",
				srclang: "en",
				label: "English",
				default: ""
			}],
			theme: "static/bower_components/videogular-themes-default/videogular.css",
			plugins: {
				poster: "http://www.videogular.com/assets/images/videogular.png"
			}
		};
    	
    	
    	/**
    	 * 加载视频详细信息
    	 */
    	$scope.loadVideoDetailAction = function(){
    		
    		var url = "detail/resource";
    		var param = {"vId":$stateParams.vId};
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前视频详细信息",res.data);
    			$scope.video = res.data;
    			$scope.video.fabBtn = true;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 为视频点赞
    	 */
    	$scope.videoFabsAction = function(video){
    		
    		var type = 1;
    		if(!video.fabBtn){
    			type = 0;
    			video.fabulousCounts --;
    		}else{
    			video.fabulousCounts ++;
    		}
    		video.fabBtn = !video.fabBtn;
    		
    		if(video.fabBtn){
    			$scope.videoFabStyle = $scope.unfabStyle;
    		}else{
    			$scope.videoFabStyle = $scope.fabStyle;
    		}
    		
    		var url = "detail/video/fabs";
    		var param = {"vId":video.vId,"upFab":type};
    		
    		commonservice.postData(url,param).then(function(res){
    			console.info("给当前视频点赞",res.data);
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 根据当前的视频所属的二级类别，获取推荐视频
    	 */
    	$scope.loadRecommendResource = function(){
    		var url = "detail/recommend/resource"
    		var param = $stateParams;
    		
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前视频所属的视频类别的推荐视频",res.data);
    			$scope.recommendList = res.data;
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	$scope.sendCommentAndCreateVisitor = function(){
    		$scope.addVisitorAction();
    		
    		return false;
    	}
    	
    	/**
    	 * 新增 访客
    	 */
    	$scope.curVisitorId = '';
    	$scope.addVisitorAction = function(){
    		var param = {"phone":$scope.phone,"nickname":$scope.nickname,"verifyCode":$scope.verifyCode};
    		var url = "visitor/create";
    		commonservice.postData(url,param).then(function(res){
    			console.info("新增访客",res.data);
    			$scope.curVisitorId = res.data.vuId;
    			$scope.createCommentAction();
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 加载视频当前页 评论
    	 */
    	$scope.loadVideoCommentsAction = function(curPage){
    		var url = "comment/list/json";
    		var param = {"vId":$stateParams.vId};
    		param.curPage = curPage;
    		commonservice.postData(url,param).then(function(res){
    			console.info("当前视频相关的评论",res.data);
    			
    			$scope.paginationConf.totalItems = res.data.count;
    			
    			$scope.commentList = [];
    			
    			angular.forEach(res.data.list,function(data,index,array){
    				data.fabBtn = true;
    				
    				$scope.commentList.push(data);
    			});
    			
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 新增视频评论
    	 */
    	$scope.comment = "";
    	$scope.createCommentAction = function(){
    		
    		if(!$scope.curVisitorId){
    			return false;
    		}
    		
    		var url = "comment/create";
    		var param = {"vId":$stateParams.vId,"dcComment":$scope.comment,"vuId":$scope.curVisitorId};
    		
    		commonservice.postData(url,param).then(function(res){
    			console.info("为当前视频增加评论",res.data);
    			$scope.loadVideoCommentsAction(1);
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 为评论点赞
    	 */
    	$scope.commentFabsAction = function(comment){
    		var url = "comment/fabs";
    		
    		var type = 1;
    		
    		if(!comment.fabBtn){
    			type = 0;
    			comment.fabulousCounts --;
    		}else{
    			comment.fabulousCounts ++;
    		}
    		
    		comment.fabBtn = !comment.fabBtn;
    		
    		if(comment.fabBtn){
    			$scope.commentFabStyle = $scope.unfabStyle;
    		}else{
    			$scope.commentFabStyle = $scope.fabStyle;
    		}
    		
    		var param = {"dcId":comment.dcId,"upFab":type};
    		
    		commonservice.postData(url,param).then(function(res){
    			console.info("为当前视频的某条评论点赞详细信息",res.data);
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
    	 * 路由切换到 详情页
    	 */
    	$scope.toDetail = function(recommend){
    		var param = {"vId":recommend.vId,"vSecId":recommend.vSecId};
    		$state.go('maincontent.detail',param,{reload:true});
    		
    		return false;
    	}
    	
    });
