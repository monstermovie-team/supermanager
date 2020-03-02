$(function(){
   $("#login").off("click").on("click",function(){
       var params = $("#loginForm").serialize();
       $.ajax({
           url : 'customer_login',
           type : 'post',
           data : params,
           success : function(result){
               if(result.code == 401){
                   alert(result.message);
               }else {
                   alert("登陆成功");
               }
           }
       });
   })

});