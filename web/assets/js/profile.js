$(function () {

    $.get('profile',{"idSelected":id},function (result) {
            $("#" + id).remove();
        }
    )



})