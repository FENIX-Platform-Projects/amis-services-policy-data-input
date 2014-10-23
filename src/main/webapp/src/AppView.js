define(['jquery', 'backbone' ], function ($, Backbone) {

    Backbone.View.prototype.close = function () {
        this.remove();
        $('#main').append($('<div id="content"></div>'));
        this.unbind();
        if (this.onClose) {
            this.onClose();
        }
    };

    var AppView = {

        showView: function (view, options) {

            this.currentView = view;
            this.currentView.render(options);

        },

        clearView: function () {
            if (this.currentView) {
                this.currentView.close();
            }
        }
    };

    return AppView;
});