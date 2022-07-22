define(['../config'], function (){
    require(['jquery'], function($){
        //按钮禁用
        function stop() {
            $("#insert, .delete, .update, #submit, #classChoice, #paging button").attr('disabled', true);
        }

        //按钮启用
        function start() {
            $("#insert, .delete, .update, #submit, #classChoice, #paging button").attr('disabled', false);

        }

    });
})
