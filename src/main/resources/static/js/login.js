$(document).ready(function () {
    $("#index").click(function (){
        var userCode = $("#userCode").val();
        var userPassword = $("#userPassword").val();

        $.ajax({
            url:"/login/verify",
            dataType: "json",
            type: "post",
            data: {
                userCode: userCode,
                userPassword: userPassword
            },
            success: function (data){
                if (data.code == 200){
                    window.location.href = "/index";
                }else{
                    alert("账号或密码错误！")
                }
            }
        })

    })
})