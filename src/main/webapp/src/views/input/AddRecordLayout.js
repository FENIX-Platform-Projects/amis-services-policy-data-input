define([
    'jquery',
    'backbone',
    'models/CplModel',
    'views/cpls/CplDetailsView',
    'views/policies/PolicyDetailsView',
    'views/commodities/CommodityDetailsView',
    'text!templates/input/template.html'
], function ($, Backbone, CplsModel, CplEdit, PolicyEdit, CommodityEdit, template) {


    return Backbone.View.extend({

        initialize: function (options) {


            $.extend(true, this, options);
            $.extend(this, Backbone.Events);

            console.log("jkhkjhkjhj")
        },

        template: _.template(template),

        views: {
            //'.cpl_container': new CplEdit({cplId : c })
            '.policy_container': new PolicyEdit()
            //,'.commodity_container': new CommodityEdit({commodityId : x })
        },

        afterRender: function () {

            console.log("213")

        }
    });

})