$(document).ready(function () {
    //获取页数
    var count = parseInt($("#paging input").val())
    //获取班级id
    var id = $("#search ul").attr("id");
    //获取记录总数
    var sum;
    $.ajax({
        url: "/student/sum",
        dataType: "json",
        type: "post",
        success(data) {
            sum = data;
        }
    })

    //按钮禁用
    function stop() {
        $("#insert, .delete, .update, #submit, #classChoice, #paging button").attr('disabled', true);
    }

    //按钮启用
    function start() {
        $("#insert, .delete, .update, #submit, #classChoice, #paging button").attr('disabled', false);

    }

    //删除
    function del(obj) {
        $(obj).parent().parent().attr("id", "tr");
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
    }

    //编辑
    function redact(obj) {
        $(obj).parent().parent().attr("id", "tr");
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
                if (data.code == 200) {
                    $("#div1").attr("style", "display: block;")
                    //禁用其他按钮
                    stop();
                    var student = data.data;
                    $("#div1 p:first").text(student.id);
                    var input = $("#div1 input");
                    $(input[0]).val(student.studentName);
                    $(input[1]).val(student.sex);
                    $(input[2]).val(student.age);
                    $(input[3]).val(student.classId);
                    $(input[4]).val(student.modifyUserId);
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

    //性别验证
    function verifySex(obj) {
        var v = obj.val();
        if (v == "" || v == null) {
            $(obj).next().text("不得为空");
        } else if (v != "男" && v != "女") {
            $(obj).next().text("字段错误(男/女)");
        } else {
            $(obj).next().text("");
            return true;
        }
        return false;
    }

    //年龄验证
    function verifyAge(obj) {
        var v = obj.val();
        if (v == "" || v == null) {
            $(obj).next().text("不得为空");
        } else if (v <= 0 || v > 120) {
            $(obj).next().text("年龄不在范围内");
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
        if (verifyName($(obj[0])) && verifySex($(obj[1])) && verifyAge($(obj[2])) && verifyId($(obj[3])) && verifyId($(obj[4])))
            return true;
        return false;
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
                        if (id == undefined || id == null) {
                            window.location.href = "/student?count=" + count;
                        } else
                            window.location.href = "/student?classId=" + id + "&count=" + count;
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

    $("#sex a").click(function () {
        $("#sex").prev("button").text($(this).text());
    })

    //条件检索的id和classId验证
    $("#id, #classId").keyup(function () {
        var v = $(this).val();
        if (v.length > 10) {
            $(this).next().text("字段过长");
        } else if (isNaN(v)) {
            $(this).next().text("请输入数字");
        } else {
            $(this).next().text("");
        }
    });

    //条件检索的age验证
    $("#age").keyup(function () {
        var v = $(this).val();
        if (v == '') {
            $(this).next().text("");
        } else if (v <= 0 || v > 120) {
            $(this).next().text("年龄不在范围内");
        } else {
            $(this).next().text("");
        }
    });

    //条件检索的studentName验证
    $("#studentName").keyup(function () {
        var v = $(this).val();
        if (v.length > 20) {
            $(this).next().text("字段过长");
        } else {
            $(this).next().text("");
        }
    });

    //条件检索
    $("#submit").click(function () {
        var Id = $("#id").val();
        var studentName = $("#studentName").val();
        // var sex = $("#sex").val();
        var sex = $("#sex").prev("button").text();
        if (sex == "全选") {
            sex = "";
        }
        var age = $("#age").val();
        var classId = $("#classId").val();
        $.ajax({
            url: "/student/search",
            dataType: "json",
            type: "post",
            data: {
                id: Id,
                studentName: studentName,
                sex: sex,
                age: age,
                classId: classId
            },
            success(data) {
                //清除并生成新的数据，
                $("#table tr:gt(0)").empty();
                if (data.length) {
                    for (let i = 0; i < data.length; i++) {
                        let td1 = "<td>" + data[i].id + "</td>";
                        let td2 = "<td>" + data[i].studentName + "</td>";
                        let td3 = "<td>" + data[i].sex + "</td>";
                        let td4 = "<td>" + data[i].age + "</td>";
                        let td5 = "<td>" + data[i].classId + "</td>";
                        let bu1 = "<button type='button' class='btn btn-info update' >编辑</button>";
                        let bu2 = "<button type='button' class='btn btn-info delete' >删除</button>";
                        let td6 = $("<td></td>>").append(bu1, bu2);
                        let tr = $("<tr></tr>").append(td1, td2, td3, td4, td5, td6);
                        $("#table").append(tr);
                    }
                    //添加删除事件
                    $(".delete").click(function () {
                        del($(this));
                    });

                    //添加编辑事件
                    $(".update").click(function () {
                        redact($(this));
                    });
                }
            }
        })
    })

    //切换班级
    $("#classdiv li").click(function () {
        id = $(this).attr("id");
        if (id == undefined || id == null) {
            window.location.href = "/student";
        } else
            window.location.href = "/student?classId=" + id;
    })

    //切换页码
    //点击上一页
    $("#paging button:first").click(function () {
        if (count > 1) {
            count = count - 1;
            $("#paging input").val(count);
            if (id == undefined || id == null) {
                window.location.href = "/student?count=" + count;
            } else
                window.location.href = "/student?classId=" + id + "&count=" + count;
        }
    })
    //点击下一页
    $("#paging button:last").click(function () {
        if (count < (sum / 3)) {
            count = count + 1;
            $("#paging input").val(count);
            if (id == undefined || id == null) {
                window.location.href = "/student?count=" + count;
            } else
                window.location.href = "/student?classId=" + id + "&count=" + count;
        }

    })
    //跳转
    $("#paging button:eq(1)").click(function () {
        var v = parseInt($("#paging input").val());
        if (v != null && v > 0 && v < (sum / 3 + 1)) {
            count = v;
            if (id == undefined || id == null) {
                window.location.href = "/student?count=" + count;
            } else
                window.location.href = "/student?classId=" + id + "&count=" + count;
        }
    })
})

