$(function(){
    $(".aleloLogo").click(function() {
        if ($("#aleloAccepted1").prop("checked")) {
            $("#aleloAccepted1").prop("checked", false);
            $(this).removeClass("checked");
        } else {
            $("#aleloAccepted1").prop("checked", true);
            $(this).addClass("checked");
        }
    });

    $("#cancel").click(function() {
        window.location.href = "/establishment/";
    });
});