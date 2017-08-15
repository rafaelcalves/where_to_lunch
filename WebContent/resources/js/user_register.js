
function checkStrength(password){
    //initial strength
    var strength = 0;
    $('.password').attr('strength','');
    //if the password length is less than 6, return message.
    if (password.length < 6) {
        $('.password').attr('strength','short');
    }

    //if the password mismatch confirm password
    if ($('#password').val() != '' && $('#password').val() != $('#confirmPassword').val()) {
        $('.password').attr('strength','mismatch');
    }

    //if the password is invalid, submit button is disabled
    if ($('.password').attr('strength') === 'short' || $('.password').attr('strength') === 'mismatch'){
        $('#submit').attr('disabled',true);
    } else {
        //if the password is ok
        $('#submit').attr('disabled',false);
        //length is ok, lets continue.
        //if length is 8 characters or more, increase strength value
        if (password.length > 7) strength += 1;
        //if password contains both lower and uppercase characters, increase strength value
        if (password.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/)) strength += 1;
        //if it has numbers and characters, increase strength value
        if (password.match(/([a-zA-Z])/) && password.match(/([0-9])/)) strength += 1;
        //if it has one special character, increase strength value
        if (password.match(/([!,%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
        //if it has two special characters, increase strength value
        if (password.match(/(.*[!,%,&,@,#,$,^,*,?,_,~].*[!,",%,&,@,#,$,^,*,?,_,~])/)) strength += 1;
        //now we have calculated strength value, we can return messages
        //if value is less than 2
        if (strength < 2 ) {
            $('.password').attr('strength','weak');
        } else if (strength == 2 ) {
            $('.password').attr('strength','good');
        } else {
            $('.password').attr('strength','strong');
        }
    }
};

$(function(){

    $('input[type=password]').keyup(function(){
        checkStrength($('#password').val());
    });
});