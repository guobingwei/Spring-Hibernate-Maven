/**
 * 文章详情页
 */
$(document).ready(function(id) {
	
	
});

function detail(id) {
	var data = {};
	data.articleId = id;
	var ajaxobj = new AjaxObj();
	ajaxobj.url = "../article/articleList.do";
	ajaxobj.data = data;
	ajaxobj.type = "GET";
	
	ajaxobj.AfterRequest = function() {
		
		var data = ajaxobj.backdata;
		//处理时间格式
		for(var i=0;i<data.length;i++){
	        data[i]["publishDate"]= new Date( data[i].publishDate).toLocaleString().replace(/\//g, '-').substr(0,10);
	    }
		var blogTemplate = $("#articleDetails").html();
		var blogContent = '';
		for(var i=0;i<data.length;i++){
			blogContent += blogTemplate.temp(data[i]);
		}
		$("#articleDetails").html(blogContent);
	}
	ajaxobj.sendRequest();
} 