$(function () {
    $(".searchDiv input").keyup(function () {
        $.get("/rest/list/" + $('.tableBody').attr('pollId') + "/" + $(".searchDiv input").val(), function(data) {
            $('.tableBody').html('');
            $(data).each(function () {
                $('.tableBody').append(
                    '<div class="row tableLine" id="' + this.id + '">' +
                        '<div class="info">' +
                            '<div class="col-md-7 col-xs-7 text">' +
                                '<div class="name">' + this.name + ' - Votes: ' + this.countOfVotes + '</div>' +
                                '<br>' +
                                '<div class="address">' + this.address + '</div>' +
                                '<br>' +
                                '<div class="payment">' +
                                    '<img class="coin" src="/resources/img/money.png" alt=""> ' + this.averagePrice +
                                    (this.aleloAccepted ? ' <img class="aleloLogo" src="/resources/img/alelo.png">' : '') +
                                '</div>' +
                            '</div>' +
                            '<div class="col-md-5 col-xs-5 logo">' +
                                '<img ' +
                                    (this.image === '' || this.image === null ? 'src="/resources/img/noimage.png"' : 'src="' + this.image + '"') +
                                '>' +
                            '</div>' +
                        '</div><br>' +
                        '<div class="establishmentMap">' +
                        '<iframe ' +
                        'frameborder="0" ' +
                        'src="https://www.google.com/maps/embed/v1/directions?key=AIzaSyDGH2o_Mc3-rDbjqCDIXmUIG93qNaVL3x0&origin=Avenida SAP, 188 - Cristo Rei, São Leopoldo - RS, 93022-718&destination=' + this.address + '" ' +
                        'allowfullscreen>' +
                        '</iframe>' +
                        '</div>' +
                        '<div class="establishmentControls">' +
                            '<img class="voteButton upButton" src="/resources/img/vote.png" onclick="location.href=\'/vote/add/' + $('.tableBody').attr('pollId') + '/' + this.id + '\'">' +
                        '</div>' +
                    '</div>'
                );
            });
        });
    });
});