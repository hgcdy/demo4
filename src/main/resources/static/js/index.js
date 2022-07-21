$(document).ready(function () {
    $("#exit").click(function (){
        window.location.href = "/login";
    })

    function fun(obj, path){
        $("iframe").attr("src", path);
        $("a").removeClass("disabled");
        if ($("#" + path).length == 0){
            var a = $("<a class='nav-link disabled' href='javaScript:void(0)'></a>").text(obj.text()).attr("id", path).click(function (){
                $("a").removeClass("disabled");
                $(this).addClass("disabled");
                $("iframe").attr("src", path);
            })
            var li = $("<li></li>").attr("class", "nav-item").append(a);
            $("#ul").append(li);
        }else{
            $("#" + path).addClass("disabled");
        }

    }

    $("#studentView").click(function (){
        fun($(this), "student");
    })
    $("#teacherView").click(function (){
        fun($(this), "teacher");
    })
    $("#classView").click(function (){
        fun($(this), "class");
    })
    $("#houseView").click(function (){
        fun($(this), "house");
    })
    $("#courseView").click(function (){
        fun($(this), "course");
    })

})
