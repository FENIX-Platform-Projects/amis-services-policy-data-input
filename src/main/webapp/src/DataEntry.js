define([
    'jquery',
    'js/router'
], function ($, Router ) {

    var initialize = function () {


        //Fake login
        $(".protected").hide();
        $('#sign-in-btn').on('click', function () {
            $('#signInModal').modal('hide');
            $(".protected").show();
        });

        //JJ feedback
        //$(".feedback-system-icon").fancybox();

        // Pass in our Router module and call it's initialize function
        var router = new Router();

    };

    return {
        initialize: initialize
    };
});