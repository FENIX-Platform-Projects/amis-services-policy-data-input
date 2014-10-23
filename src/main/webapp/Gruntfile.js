'use strict';

module.exports = function (grunt) {

    grunt.loadNpmTasks('grunt-contrib-uglify');
    grunt.loadNpmTasks('grunt-contrib-concat');
    grunt.loadNpmTasks('grunt-contrib-clean');
    grunt.loadNpmTasks('grunt-contrib-jshint');
    grunt.loadNpmTasks('grunt-contrib-copy');
    grunt.loadNpmTasks('grunt-jsonlint');
    grunt.loadNpmTasks('grunt-jsdoc');

    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        meta: {
            banner: '/*! <%= pkg.name %> - v<%= pkg.version %> - <%= grunt.template.today("yyyy-mm-dd") %> */\n'
        },
        clean: {
            lib: {
                src: ['dist/lib/*']
            },
            fenix: {
                src: ['dist/*']
            }
        },
        jshint: {
            options: {
                globals: {
                    console: true,
                    module: true
                },
                "-W099": true,	//ignora tabs e space warning
                "-W033": true
            }
            //,files: ['dist/*.fenix.js', '!src/third-party.js']
        },
        copy: {
            jquery: {
                nonull: true,
                src: 'node_modules/jquery/dist/jquery.min.js',
                dest: 'src/lib/jquery.js'
            },
            backbone: {
                nonull: true,
                src: 'node_modules/backbone/backbone-min.js',
                dest: 'src/lib/backbone.js'
            },
            "backbone.layoutmanager": {
                nonull: true,
                src: "node_modules/backbone.layoutmanager/backbone.layoutmanager.js",
                dest: 'src/lib/backbone.layoutmanager.js'
            },
            bootstrap_js: {
                nonull: true,
                src: "node_modules/bootstrap/dist/js/bootstrap.min.js",
                dest: 'src/lib/bootstrap.js'
            },
            bootstrap_css: {
                nonull: true,
                src: "node_modules/bootstrap/dist/css/bootstrap.min.css",
                dest: 'css/lib/bootstrap.css'
            },
            nprogress_js: {
                nonull: true,
                src: "node_modules/nprogress/nprogress.js",
                dest: 'js/lib/nprogress.js'
            },
            nprogress_css: {
                nonull: true,
                src: "node_modules/nprogress/nprogress.css",
                dest: 'css/lib/nprogress.css'
            },
            requirejs: {
                nonull: true,
                src: "node_modules/requirejs/require.js",
                dest: 'js/lib/require.js'

            },
            underscore: {
                nonull: true,
                src: "node_modules/underscore/underscore-min.js",
                dest: 'js/lib/underscore.js'
            }
        },
        concat: {
            options: {
                separator: ';\n',
                stripBanners: {
                    block: true
                }
            },
            lib: {
                src: [
                    'node_modules/jquery/dist/jquery.js'

                ],
                dest: 'dist/lib.min.js'
            },
            fenix: {
                src: [
                    'src/extends.js'
                ],
                dest: 'dist/fenix.src.js'
            }
        },
        uglify: {
            options: {
                banner: '<%= meta.banner %>'
            },
            fenix: {
                files: {
                    'dist/fenix.min.js': [
                        '<%= concat.fenix.dest %>'
                    ]
                }
            }
        },
        cssmin: {
            combine: {
                src: [
                    'css/normalize/normalize.css',
                    'src/lib/jquery-colorPicker/colorPicker.css',
                    'src/lib/jquery-uploadify-3.2.1/uploadify.css',
                    'src/lib/jquery-tokeninput/styles/token-input.css',
                    'css/simple-grid/simplegrid.css',
                    'css/*.css',
                    'css/sprite.css'
                ],
                dest: 'dist/fenix.min.css'
            },
            minify: {
                expand: true,
                cwd: 'dist/',
                src: '<%= cssmin.combine.dest %>'
                //,dest: 'dist/<%= pkg.name %>-<%= pkg.version %>.min.css'
            }
        },
        jsonlint: {
            sample: {
                src: [ 'i18n/*.json' ]
            }
        },
        jsdoc: {
            docs: {
                src: ['src/**/*.js'],
                options: {
                    destination: 'docs'
                }
            }
        }
    });

    grunt.registerTask('doc', [
        'clean:docs',
        'jshint',
        'concat',
        'uglify'
    ]);

    grunt.registerTask('default', [
        'clean',
        //'cssmin',
        //'jsonlint',
        'copy',
        //'jshint',
        'concat'
        //,'uglify'
        //'rev',
        //'jsdoc'
        //,'exec'
    ]);

};