function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#advanceconnection').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}

$("#connection-image").change(function(){
    readURL(this);
});