/**
 * Created by liuyan on 2017/10/22
 */
$(function(){
	 function bind_nav(id,url){
	        $(id).click(function(node){
	            var text = $(this).text();
	            if($('#tabs').tabs('exists',text)){
	                $('#tabs').tabs('select',text);
	            }else{
	                $('#tabs').tabs('add',{
	                    href: url,
	                    title:text,
	                    closable:true,
						width:500,
						height:600
	                });
	            }
	        });
	    }
	    bind_nav('#btn_school','../school.html');
	    bind_nav('#btn_student','../student.html');

})