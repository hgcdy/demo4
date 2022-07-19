$(document).ready(function () {

    //切换班级
    $("ul li").click(function () {
        var id = $(this).attr("id");
        if (id == undefined) {
            window.location.href = "/student";
        } else
            window.location.href = "/student?classId=" + id
    })

    //删除
    $(".delete").click(function () {
        $(this).parent().parent().attr("id", "tr");
        var delId = $("#tr td:first").text();
        $.ajax({
            url: "/student/delete",
            dataType: "json",
            type: "post",
            data: {id: delId},
            success: function (data) {
                if (data.code == 200) {
                    $("#tr").empty();
                }
            }
        })
    })

    //编辑
    $(".update").click(function () {
        $(this).parent().parent().attr("id", "tr");
        var id = $("#tr td:first").text();
        $.ajax({
            url: "/student/select",
            dataType: "json",
            type: "post",
            data: {
                id: id
            },
            //获取原本的数据
            success(data) {
                $("#div1").attr("style", "display: block;")
                var student = data.data;
                if (data.code == 200) {
                    $("#div1 p").text(student.id);
                    var input = $("#div1 input");
                    $(input[0]).val(student.studentName);
                    $(input[1]).val(student.sex);
                    $(input[2]).val(student.age);
                    $(input[3]).val(student.classId);
                    $(input[4]).val(student.modifyUserId);
                }
                //对记录进行修改
                //点击确认将数据返回
                $("#confirm").click(function () {
                    $.ajax({
                        url: "/student/update",
                        dataType: "json",
                        type: "post",
                        //修改后的数据
                        data: {
                            id: student.id,
                            studentName: $(input[0]).val(),
                            sex: $(input[1]).val(),
                            age: $(input[2]).val(),
                            classId: $(input[3]).val(),
                            modifyUserId: $(input[4]).val(),
                        },
                        success: function (data) {
                            if (data.code == 200) {
                                // window.location.href = "/student";
                                var tds = $("#tr td");
                                $(tds[1]).text($(input[0]).val());
                                $(tds[2]).text($(input[1]).val());
                                $(tds[3]).text($(input[2]).val());
                                $(tds[4]).text($(input[3]).val());
                                $("#tr").removeAttr("id");
                                $("#div1").attr("style", "display: none;")
                            } else {
                                alert("修改失败！")
                            }
                        }
                    })
                })
                //点击取消
                $("#cancel").click(function () {
                    $("#div1").attr("style", "display: none;")
                    $("#tr").removeAttr("id");
                })
            }
        })
        $("input").val("");
        $("#confirm,#cancel").unbind("click");
    })


    //插入记录
    $("#insert").click(function () {
        $("#div2").attr("style", "display: block;")
        var input = $("#div2 input");
        $("#confirm1").click(function () {
            $.ajax({
                url: "/student/insert",
                dataType: "json",
                type: "post",
                data: {
                    studentName: $(input[0]).val(),
                    sex: $(input[1]).val(),
                    age: $(input[2]).val(),
                    classId: $(input[3]).val(),
                    createUserId: $(input[4]).val()
                },
                success: function (data) {
                    if (data.code == 200) {
                        window.location.href = "/student";
                    } else {
                        alert("插入失败!");
                    }
                }
            })
        })
        $("#cancel1").click(function () {
            $("#div1 input").val(null);
            $("#div1").attr("style", "display: none;")
        })
        $("input").val("");
        $("#confirm,#cancel").unbind("click");
    })

})



