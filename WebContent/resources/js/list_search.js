$(function () {
    $(".searchDiv input").quicksearch(".tableBody .tableLine");

    $(".searchDiv .search").click(function(){
        window.location.replace("/poll/list/" + $('.tableBody').attr('pollId') + "/" + $(".searchDiv input").val())
    });

    $(".searchDiv .clear").click(function(){
        window.location.replace("/poll/list/" + $('.tableBody').attr('pollId'));
    });
})