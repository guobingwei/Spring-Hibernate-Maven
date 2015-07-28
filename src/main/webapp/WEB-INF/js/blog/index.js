
/**
 * index页面初始化
 */
$(document).ready(function() {
	
	var data = {};
	var ajaxobj = new AjaxObj();
	ajaxobj.url = "../article/articleList.do";
	ajaxobj.data = data;
	ajaxobj.type = "GET";
	
	ajaxobj.AfterRequest = function() {
		indexInit(ajaxobj.backdata);
		getUserInfo() ;
		getBlogElement();
	}
	ajaxobj.sendRequest();
});

/**
 * index页面初始化函数
 */
function indexInit(data) {
	//处理时间格式
	for(var i=0;i<data.length;i++){
        data[i]["publishDate"]= new Date( data[i].publishDate).toLocaleString().replace(/\//g, '-').substr(0,10);
    }
	var blogTemplate = $("#blogList").html();
	var blogContent = '';
	for(var i=0;i<data.length;i++){
		blogContent += blogTemplate.temp(data[i]);
	}
	$("#blogList").html(blogContent);
}

/**
 * 获取登录用户信息
 */
function getUserInfo() {
	var data = {};
	var ajaxobj = new AjaxObj();
	ajaxobj.url = "../user/userInfo.do";
	ajaxobj.data = data;
	ajaxobj.type = "GET";
	
	ajaxobj.AfterRequest = function() {
		var data = ajaxobj.backdata.userInfo;
		var blogTemplate = $("#usrInfo").html();
		var blogContent = '';
		data.forEach(function(obj){
			blogContent += blogTemplate.temp(obj)
		}) 
		$("#usrInfo").html(blogContent);
		var img = data[0].headImage;
		$("#usrInfo a").css("background", 'url("' + img + '")');
	}
	ajaxobj.sendRequest();
	
}
/**
 * 获取blogElement
 */
function getBlogElement() {
	var data = {};
	var ajaxobj = new AjaxObj();
	ajaxobj.url = "../blogElement/blogElementList.do";
	ajaxobj.data = data;
	ajaxobj.type = "GET";
	ajaxobj.AfterRequest = function() {
		var data = ajaxobj.backdata.BlogElement;
		var blogTemplate = $("#title").html();
		var blogContent = '';
		data.forEach(function(obj){
			blogContent += blogTemplate.temp(obj)
		}) 
		$("#title").html(blogContent);
		
		var blogTemplate = $("#words").html();
		var blogContent = '';
		data.forEach(function(obj){
			blogContent += blogTemplate.temp(obj)
		}) 
		$("#words").html(blogContent);
		
		//图片
		var imgUrl = data[0].homeImage;
		$("#words").css("background", 'url("' + imgUrl + '")');
	}
	ajaxobj.sendRequest();
}


