<script  src="/static/js/jquery-1.9.1.js"></script>
<script>
    // $(window).on('load', function () {
    //     var $preloader = $('#load'),
    //             $spinner   = $preloader.find('#load div');
    //     $spinner.fadeOut();
    //     $preloader.delay(350).fadeOut('slow');
    // });
    $(window).load(function() {
        setTimeout(function () {
            $("#load").delay(100).fadeOut().remove();
        }, 2000);
    });
</script>