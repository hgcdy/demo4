$(document).ready(function () {
    $("#ul li").click(function () {
        var id = $(this).attr("id");
        $.ajax({
            url: "/index",
            async: false,
            dataType: "json",
            type: "post",
            data: {
                classId: id,
            },
            success: function (data) {
                var len = data.length;
                if (len > 0){
                    $("#table tr:gt(0)").empty();
                    for (const i in data) {
                        var td1 = $("<td></td>>").text(i[id]);
                        var td2 = $("<td></td>>").text(i[studentName]);
                        var td3 = $("<td></td>>").text(i[sex]);
                        var td4 = $("<td></td>>").text(i[age]);
                        var td5 = $("<td></td>>").text(i[classId]);
                        var td6 = $("<td></td>>").html(" <button type=\"button\" class=\"btn btn-info update\" >修改</button>")
                        var td7 = $("<td></td>>").html("<button type=\"button\" class=\"btn btn-info delete\" >删除</button>")
                        var tr = $("<tr></tr>").append(td1,td2,td3,td4,td5,td6,td7);
                        $("#table tr:last").after(tr);
                    }
                }
            }
        })

    })

})