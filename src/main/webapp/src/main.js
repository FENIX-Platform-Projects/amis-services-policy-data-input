/*global requirejs,require*/

requirejs.config({
    "baseUrl": "src/lib",
    "paths": {
        "js": "..",
        "models": "../models",
        "views": "../views",
        "collections": "../collections",
        "templates": "../../templates",
        "template": "../../templates",
        host_utility: '../../js/controller_util/ap_queryAndDownload_utility',
        host_domainParser: '../../js/controller_util/ap_queryAndDownload_domain_parser',
        host_policyDataObject: '../../js/controller_util/ap_queryAndDownload_policy_data_object',
        host_buttonActions: '../../js/controller_util/ap_queryAndDownload_button_actions',
        host_preview: '../../js/controller_util/ap_queryAndDownload_preview',
        config: "../../config",
        jqueryui: 'jquery-ui.min',
        jqueryuicustom: '//fenixapps.fao.org/repository/js/jquery-ui/1.9.2/jquery-ui.custom.min',
        jQAllRangeSliders: 'jQAllRangeSliders-min',
        qd_utils: '../../js/qd/qd_utils',
        qd_board: '../../js/qd/qd_board',
        qd_controller: '../../js/qd/qd_controller',
        qd_selector: '../../js/qd/qd_selector',
        qd_model: '../../js/qd/qd_model',
        qd_catalog_selector: '../../js/qd/qd_catalog_selector',
        board_catalog: '../../js/qd/board_catalog',
        selector_catalog: '../../js/qd/selector_catalog',
        model_catalog: '../../js/qd/model_catalog',
        qd_catalog_model: '../../js/qd/qd_catalog_model',
        pnotify: 'pnotify.custom.min',
        fullscreen: 'jquery.fullscreen-min'
    },
    "shim": {
        "bootstrap": {
            deps: ["jquery"]
        },
        backbone: {
            deps: ['underscore', 'jquery'],
            exports: 'Backbone'
        },
        underscore: {
            exports: '_'
        },
        jqwidgets: {
            export: "$",
            deps: ['jquery']
        },
        jQAllRangeSliders: {
            deps: ['jquery', 'jqueryui', 'jqueryuicustom']
        },
        pnotify: {
            deps: ['bootstrap']
        }
    }
});


require([
    "backbone.layoutmanager",
    "domReady!",
    "bootstrap"
], function (Layout) {

    'use strict';

    // Backbone Layout Manager: Configure globally.
    Layout.configure({
        manage: true
    });


    require(["js/Host", ], function ( Host ) {

        //DataEntry.initialize();

        var host = new Host();

        host.init();

    });
});

