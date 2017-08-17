$(function () {

    $(".searchDiv .search").click(function () {
        window.location.replace("/poll/votedEstablishments/" + $('.tableBody').attr('pollId') + "/" + $(".searchDiv input").val())
    });

    $(".searchDiv .clear").click(function () {
        window.location.replace("/poll/votedEstablishments/" + $('.tableBody').attr('pollId'));
    });
});