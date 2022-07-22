$(document).ready(function () {

    //获取页数
    var count = parseInt($("#paging input").val())

    //获取记录总数
    var sum;
    $.ajax({
        url: "/teacher/sum",
        dataType: "json",
        type: "post",
        success(data) {
            sum = data;
        }
    })

    //按钮禁用
    function stop() {
        $("#insert, .delete, .update, #paging button").attr('disabled', true);
    }

    //按钮启用
    function start() {
        $("#insert, .delete, .update, #paging button").attr('disabled', false);
    }

    //名字验证
    function verifyName(obj) {
        var v = obj.val();
        if (v == "" || v == null) {
            $(obj).next().text("不得为空");
        } else if (v.length > 20) {
            $(obj).next().text("字段过长");
        } else {
            $(obj).next().text("");
            return true;
        }
        return false;
    }

    //id验证
    function verifyId(obj) {
        var v = obj.val();
        if (v == "" || v == null) {
            $(obj).next().text("不得为空");
        } else if (v.length > 10) {
            $(obj).next().text("字段过长");
        } else if (isNaN(v)) {
            $(obj).next().text("请输入数字");
        } else {
            $(obj).next().text("");
            return true;
        }
        return false;
    }

    //验证
    function verify(obj) {
        if (verifyName($(obj[0])) && verifyName($(obj[1])) && verifyName($(obj[2])) && verifyId($(obj[3])))
            return true;
        return false;
    }

    //删除
    function del(obj) {
        $(obj).parent().parent().attr("id", "tr");
        var delId = $("#tr td:first").text();
        $.ajax({
            url: "/teacher/delete",
            dataType: "json",
            type: "post",
            data: {id: delId},
            success: function (data) {
                if (data.code == 200) {
                    $("#tr").empty();
                } else {
                    alert("删除失败！")
                }
            }
        })
    }

    //编辑
    function redact(obj) {
        $(obj).parent().parent().attr("id", "tr");
        var id = $("#tr td:first").text();
        $.ajax({
            url: "/teacher/select",
            dataType: "json",
            type: "post",
            data: {
                id: id
            },
            //获取原本的数据
            success(data) {
                if (data.code == 200) {
                    $("#div1").attr("style", "display: block;")
                    //禁用其他按钮
                    stop();
                    var teacher = data.data;
                    $("#div1 p:first").text(teacher.id);
                    var input = $("#div1 input");
                    $(input[0]).val(teacher.teacherName);
                    $(input[1]).val(teacher.teacherCode);
                    $(input[2]).val(teacher.teacherPassword);
                    $(input[3]).val(teacher.modifyUserId);
                }
                //对记录进行修改,验证
                for (let i = 0; i < input.length; i++) {
                    $(input[i]).keyup(function () {
                        if (verify(input)) {
                            $("#confirm").attr('disabled', false);
                        } else {
                            $("#confirm").attr('disabled', true);
                        }
                    })
                }
                //点击确认将数据返回
                $("#confirm").click(function () {
                    $.ajax({
                        url: "/teacher/update",
                        dataType: "json",
                        type: "post",
                        //修改后的数据
                        data: {
                            id: teacher.id,
                            teacherName: $(input[0]).val(),
                            teacherCode: $(input[1]).val(),
                            teacherPassword: $(input[2]).val(),
                            modifyUserId: $(input[3]).val(),
                        },
                        success: function (data) {
                            if (data.code == 200) {
                                // window.location.href = "/student";
                                var tds = $("#tr td");
                                $(tds[1]).text($(input[0]).val());
                                $(tds[2]).text($(input[1]).val());
                                $(tds[3]).text($(input[2]).val());
                                $("#tr").removeAttr("id");
                                $("#div1").attr("style", "display: none;")
                            } else {
                                alert("修改失败！")
                            }
                            //启用按钮
                            start();
                        }
                    })
                })
                //点击取消
                $("#cancel").click(function () {
                    $("#div1").attr("style", "display: none;")
                    $("#tr").removeAttr("id");
                    //启用按钮
                    start();
                })
            }
        })
        $("input").val("");
        $("#confirm,#cancel").unbind("click");

    }


    //添加删除事件
    $(".delete").click(function () {
        del($(this));
    });

    //添加编辑事件
    $(".update").click(function () {
        redact($(this));
    });

    //插入记录
    $("#insert").click(function () {
        //显示输入框
        $("#div2").attr("style", "display: block;");
        //禁用其他按钮
        stop();
        //获取输入框内的内容送给后端
        var input = $("#div2 input");
        for (let i = 0; i < input.length; i++) {
            //验证
            $(input[i]).keyup(function () {
                if (verify(input)) {
                    $("#confirm1").attr('disabled', false);
                } else {
                    $("#confirm1").attr('disabled', true);
                }
            })
        }
        $("#confirm1").click(function () {
            $.ajax({
                url: "/teacher/insert",
                dataType: "json",
                type: "post",
                data: {
                    teacherName: $(input[0]).val(),
                    teacherCode: $(input[1]).val(),
                    teacherPassword: $(input[2]).val(),
                    createUserId: $(input[3]).val()
                },
                success: function (data) {
                    if (data.code == 200) {
                        window.location.href = "/teacher?count=" + count;
                    } else {
                        alert("插入失败!");
                    }
                }
            })
        })
        $("#cancel1").click(function () {
            //清空输入框内容，并隐藏
            $("#div2 input").val(null);
            $("#div2").attr("style", "display: none;")
            $("#confirm1,#cancel1").unbind("click");
            //启动其他按钮
            start();
        })
        $(input).val("");
    })


    //切换页码
    //点击上一页
    $("#paging button:first").click(function () {
        if (count > 1) {
            count = count - 1;
            $("#paging input").val(count);
            window.location.href = "/teacher?count=" + count;

        }
    })
    //点击下一页
    $("#paging button:last").click(function () {
        if (count < (sum / 3)) {
            count = count + 1;
            $("#paging input").val(count);
            window.location.href = "/teacher?count=" + count;

        }

    })
    //跳转
    $("#paging button:eq(1)").click(function () {
        var v = parseInt($("#paging input").val());
        if (v != null && v > 0 && v < (sum / 3 + 1)) {
            count = v;
            window.location.href = "/teacher?count=" + count;
        }
    })

})