'use strict';

/**
 * @ngdoc function
 * @name vShow.controller: DetailCtrl
 * @description # DetailCtrl Controller of the vShow
 */
angular.module('vShow')
    .controller('DetailCtrl', function ($scope,$sce,commonservice,$state,$stateParams,$interval) {
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
    	
    	/**
		 * 分页插件配置
		 */
	    $scope.paginationConf = {
            currentPage: 1,// 当前页
            totalItems: 0,// 所有的记录数
            itemsPerPage: 15,// 每页的记录数
            pagesLength: 8,// 用于计算可被点击的总页数
            perPageOptions: [15],// 用于选择的 每页显示的记录数 数组
            onChange: function(){
            	$scope.loadVideoCommentsAction($scope.paginationConf.currentPage);
            }
        };
    	
    	/**
    	 * 初始化
    	 */
    	$scope.initCtrl = function(){
    		$scope.loadVideoDetailAction();
    		$scope.loadVideoCommentsAction(1);
    		$scope.loadRecommendResourceAction();
    	}
    	
    	/**
		 * 发送验证码 触发事件
		 */
    	var count = 50;
    	var timer = null;
    	$scope.btnDisabled = false;
    	$scope.btnContent = '发送验证码';
    	$scope.sendVerifyCodeBtn = function(){
    		$scope.btnDisabled = true;
    		if(!timer){
    			timer=$interval(function(){
    				
	   	       	     $scope.btnContent = count+'S 后可重发';
	   	       	     count--;
	   	       	     if(count == 0){
	   	       	    	 if(timer){
	   	       	    		 $scope.btnDisabled = false;
	   	       	    		 $scope.btnContent = '发送验证码';
	   	       	    		 $interval.cancel(timer);
	   	       	    		 timer = null;
	   	       	    	 }
	   	       	     }
	   	       	},1000);   // 间隔2秒定时执行
    			
    		}
    		
    		$scope.sendVerifyCodeAction();
    		
    		return false;
    	}
    	
    	/**
		 * 校验昵称 触发事件
		 */
    	$scope.suc = -1
    	$scope.toCheckName = function(){
    		if($scope.nickname){
    			$scope.checkNameAction();
    		}else{
    			$scope.suc = 1;
				$scope.tip = "昵称不允许为空";
    		}
    	}
    	
    	$scope.clearTip = function(){
    		$scope.suc = -1
    		$scope.tip = null;
    	}
    	
    	/**
		 * 校验昵称 请求
		 */
    	$scope.checkNameAction = function(){
    		var url = "visitor/check_name";
    		var param = {"nickname":$scope.nickname};
    		commonservice.postData(url,param).then(function(res){
    			console.info("校验昵称结果",res.data);
				$scope.suc = res.data.code;
				$scope.tip = res.data.msg;
    			
    		},function(res){
    			$scope.suc = 1;
				$scope.tip = "请重新输入";
    		});
    	}
    	
	    /**
		 * 发送验证码 请求
		 */
	    $scope.sendVerifyCodeAction = function(){
	    	$scope.errMsg = null;
	    	var url = "visitor/send";
    		var param = {"phone":$scope.phone};
    		commonservice.postData(url,param).then(function(res){
    			console.info("发送验证码结果",res.data);
    			
    			if(res.data.alibaba_aliqin_fc_sms_num_send_response){
    				$scope.errMsg = null;
    			}else{
    				if(timer){
  	       	    		 $scope.btnDisabled = false;
  	       	    		 $scope.btnContent = '发送验证码';
  	       	    		 $interval.cancel(timer);
  	       	    		 timer = null;
  	       	    	 }
    				$scope.errMsg = "验证码发送失败";
    			}
    			
    		},function(res){
    			// alert(res.status);
    			$scope.errMsg = "请重试";
    			if(timer){
       	    		 $scope.btnDisabled = false;
       	    		 $scope.btnContent = '发送验证码';
       	    		 $interval.cancel(timer);
       	    		 timer = null;
       	    	 }
    		});
	    }
	    
    	/**
		 * 加载视频详细信息 请求
		 */
    	$scope.loadVideoDetailAction = function(){
    		
    		var url = "detail/resource";
    		var param = {"vId":$stateParams.vId};
    		commonservice.postData(url,param).then(function(res){
    			
    			if(!res.data){
    				alert("视频已下架或者被删除");
    				$state.go("maincontent.girdslayout",{},[]);
    				return false;
    			}
    			console.info("当前视频详细信息",res.data);
    			$scope.video = res.data;
    			$scope.video.fabBtn = true;
    			
    	    	$scope.config = {
    	    			sources: [
    	    				{
    	    					src: $sce.trustAsResourceUrl($scope.video.vPath),
    	    					type: "video/mp4"
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
    			
    		},function(res){
    			alert(res.status);
    		});
    	}
    	
    	/**
		 * 为视频点赞 请求
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
    	$scope.loadRecommendResourceAction = function(){
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
    		
    		if($scope.errMsg || $scope.suc != 0){
    			console.log("存在错误信息，无法提交");
    			return false
    		}
    		
    		$scope.addVisitorAction();
    		
    		return false;
    	}
    	
    	/**
		 * 新增 访客 请求
		 */
    	$scope.curVisitorId = '';
    	$scope.addVisitorAction = function(){
    		$scope.errMsg = null;
    		var param = {"phone":$scope.phone,"nickname":$scope.nickname,"verifyCode":$scope.verifyCode};
    		var url = "visitor/create";
    		commonservice.postData(url,param).then(function(res){
    			console.info("新增访客",res.data);
    			if(res.data.code == 0){
    				$scope.errMsg = null;
    				$scope.curVisitorId = res.data.vuId;
        			$scope.createCommentAction();
    			}else{
    				$scope.errMsg = res.data.msg;
    				if(timer){
          	    		 $scope.btnDisabled = false;
          	    		 $scope.btnContent = '发送验证码';
          	    		 $interval.cancel(timer);
          	    		 timer = null;
          	    	 }
    			}
    			
    		},function(res){
    			$scope.errMsg = "请重试";
    			// alert(res.status);
    			if(timer){
      	    		 $scope.btnDisabled = false;
      	    		 $scope.btnContent = '发送验证码';
      	    		 $interval.cancel(timer);
      	    		 timer = null;
      	    	 }
    		});
    	}
    	
    	/**
		 * 加载视频当前页 评论 请求
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
		 * 新增视频评论 请求
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
		 * 为评论点赞 请求
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
    			console.info("为当前视频的某条评论点赞/取消赞 结果",res.data);
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
