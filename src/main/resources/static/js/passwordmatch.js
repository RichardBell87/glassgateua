// function checkPasswordMatch() {
//     var password = $("#pass-input-1").val();
//     var userconfirmpassword = $("#pass-input-2").val();
//
//     if (password != userconfirmpassword)
//         $("#divCheckPasswordMatch").html("Паролі не співпадають!");
//     else
//         $("#divCheckPasswordMatch").html("Паролі співпадають.");
// }
//
// $(document).ready(function () {
//     $("#pass-input-2").keyup(checkPasswordMatch);
// });

$(document).ready(function(){
    var $submitBtn = $("#form input[type='submit']");
    var $passwordBox = $("#pass-input-1");
    var $confirmBox = $("#pass-input-2");
    var $errorMsg =  $('<span id="error_msg">Паролі не співпадають!</span>');

    // This is incase the user hits refresh - some browsers will maintain the disabled state of the button.

    $submitBtn.removeAttr("disabled");

    function checkMatchingPasswords(){
        if($confirmBox.val() != "" && $passwordBox.val != ""){
            if( $confirmBox.val() != $passwordBox.val() ){
                $submitBtn.attr("disabled", "disabled");
                $errorMsg.insertAfter($confirmBox);
            }
        }
    }

    function resetPasswordError(){
        $submitBtn.removeAttr("disabled");
        var $errorCont = $("#error_msg");
        if($errorCont.length > 0){
            $errorCont.remove();
        }
    }

    $("#pass-input-2, #pass-input-1")
        .on("keydown", function(e){

            // only check when the tab or enter keys are pressedto prevent the method from being called needlessly

            if(e.keyCode == 13 || e.keyCode == 9) {
                checkMatchingPasswords();
            }
        })
        .on("blur", function(){
            // also check when the element looses focus (clicks somewhere else)
            checkMatchingPasswords();
        })
        .on("focus", function(){
            // reset the error message when they go to make a change
            resetPasswordError();
        })
});