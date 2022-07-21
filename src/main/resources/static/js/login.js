$(document).ready(function () {
    $("#index").click(function (){
        var teacherCode = $("#teacherCode").val();
        var teacherPassword = $("#teacherPassword").val();

        $.ajax({
            url:"/login/verify",
            dataType: "json",
            type: "post",
            data: {
                teacherCode: teacherCode,
                teacherPassword: teacherPassword
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