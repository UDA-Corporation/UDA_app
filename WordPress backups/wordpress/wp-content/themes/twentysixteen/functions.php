<?php
/**
 * eight-degree functions and definitions
 *
 * @link https://developer.wordpress.org/themes/basics/theme-functions/
 *
 * @package eight-degree
 */

if ( ! function_exists( 'eight_degree_setup' ) ) :
/**
 * Sets up theme defaults and registers support for various WordPress features.
 *
 * Note that this function is hooked into the after_setup_theme hook, which
 * runs before the init hook. The init hook is too late for some features, such
 * as indicating support for post thumbnails.
 */
function eight_degree_setup() {
	/*
	 * Make theme available for translation.
	 * Translations can be filed in the /languages/ directory.
	 * If you're building a theme based on eight-degree, use a find and replace
	 * to change 'eight-degree' to the name of your theme in all the template files.
	 */
	load_theme_textdomain( 'eight-degree', get_template_directory() . '/languages' );

	// Add default posts and comments RSS feed links to head.
	add_theme_support( 'automatic-feed-links' );

	/*
	 * Let WordPress manage the document title.
	 * By adding theme support, we declare that this theme does not use a
	 * hard-coded <title> tag in the document head, and expect WordPress to
	 * provide it for us.
	 */
	add_theme_support( 'title-tag' );

	/*
	 * Enable support for Post Thumbnails on posts and pages.
	 *
	 * @link https://developer.wordpress.org/themes/functionality/featured-images-post-thumbnails/
	 */
	add_theme_support( 'post-thumbnails' );
	add_image_size('eight-degree-rect-height', 480, 500, true);
	add_image_size('eight-degree-square', 500, 500, true);
	add_image_size('eight-degree-slider', 1920, 850, true);
	add_image_size('eight-degree-rect-wide', 700, 500, true);

	// This theme uses wp_nav_menu() in one location.
	register_nav_menus( array(
		'menu-1' => esc_html__( 'Primary', 'eight-degree' ),
	) );

	/*
	 * Switch default core markup for search form, comment form, and comments
	 * to output valid HTML5.
	 */
	add_theme_support( 'html5', array(
		'search-form',
		'comment-form',
		'comment-list',
		'gallery',
		'caption',
	) );

	// Set up the WordPress core custom background feature.
	add_theme_support( 'custom-background', apply_filters( 'eight_degree_custom_background_args', array(
		'default-color' => 'ffffff',
		'default-image' => '',
	) ) );


	add_theme_support( 'custom-logo' , array(
	 	'header-text' => array( 'site-title', 'site-description' ),
	 	));

	// Add theme support for selective refresh for widgets.
	add_theme_support( 'customize-selective-refresh-widgets' );

	if(is_admin()):
		//load js to control function of switch
	function eight_degree_custom_admin_style($hook){
        if ( 'customize.php' == $hook || 'widgets.php' == $hook ) {

			wp_enqueue_style( 'eight-degree-pro-custom-control-admin-css', get_template_directory_uri() . '/inc/css/admin-control.css');
			wp_enqueue_script( 'eight-degree-pro-custom-control-admin-js', get_template_directory_uri().'/inc/js/admin-control.js', array( 'jquery' ), '20170109', true );
		}
            wp_enqueue_style( 'eight-degree-pro-font-awesome', get_template_directory_uri() . '/css/font-awesome.css' );
	}
	add_action( 'admin_enqueue_scripts', 'eight_degree_custom_admin_style' );
	endif;
}
endif;
add_action( 'after_setup_theme', 'eight_degree_setup' );

/**
 * Set the content width in pixels, based on the theme's design and stylesheet.
 *
 * Priority 0 to make it available to lower priority callbacks.
 *
 * @global int $content_width
 */
function eight_degree_content_width() {
	$GLOBALS['content_width'] = apply_filters( 'eight_degree_content_width', 640 );
}
add_action( 'after_setup_theme', 'eight_degree_content_width', 0 );

/**
 * Register widget area.
 *
 * @link https://developer.wordpress.org/themes/functionality/sidebars/#registering-a-sidebar
 */
function eight_degree_widgets_init() {
	register_sidebar( array(
		'name'          => esc_html__( 'Sidebar', 'eight-degree' ),
		'id'            => 'sidebar-1',
		'description'   => esc_html__( 'Add widgets here.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Right Sidebar', 'eight-degree' ),
		'id'            => 'eight-degree-right-sidebar',
		'description'   => esc_html__( 'Add widgets to show on Right Sidebar.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Left Sidebar', 'eight-degree' ),
		'id'            => 'eight-degree-left-sidebar',
		'description'   => esc_html__( 'Add widgets to show on Left Sidebar.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Skill Section', 'eight-degree' ),
		'id'            => 'eight-degree-skill-section',
		'description'   => esc_html__( 'Add widgets to show on Skill Section.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Counter Section', 'eight-degree' ),
		'id'            => 'eight-degree-counter-section',
		'description'   => esc_html__( 'Add widgets to show on Counter Section.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Google Map', 'eight-degree' ),
		'id'            => 'eight-degree-map',
		'description'   => esc_html__( 'Add google map iframe in text widgets to show map on Contact Section and Page.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Footer Area One', 'eight-degree' ),
		'id'            => 'eight-degree-footer-one',
		'description'   => esc_html__( 'Add widgets to show on Footer Area One.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Footer Area Two', 'eight-degree' ),
		'id'            => 'eight-degree-footer-two',
		'description'   => esc_html__( 'Add widgets to show on Footer Area Two.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Footer Area Three', 'eight-degree' ),
		'id'            => 'eight-degree-footer-three',
		'description'   => esc_html__( 'Add widgets to show on Footer Area Three.', 'eight-degree' ),
		'before_widget' => '<aside id="%1$s" class="widget %2$s">',
		'after_widget'  => '</aside>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
	register_sidebar( array(
		'name'          => esc_html__( 'Footer Area Four', 'eight-degree' ),
		'id'            => 'eight-degree-footer-four',
		'description'   => esc_html__( 'Add widgets to show on Footer Area Four.', 'eight-degree' ),
		'before_widget' => '<section id="%1$s" class="widget %2$s">',
		'after_widget'  => '</section>',
		'before_title'  => '<h4 class="widget-title">',
		'after_title'   => '</h4>',
	) );
}
add_action( 'widgets_init', 'eight_degree_widgets_init' );

/**
 * Enqueue scripts and styles.
 */
function eight_degree_scripts() {
	$query_args = array( 
	    'family' => 'Chivo:300,400,700'
	);
	
	wp_enqueue_style( 'eight-degree-google-fonts', add_query_arg( $query_args, "//fonts.googleapis.com/css" ) );

	wp_enqueue_style('font-awesome-css', get_template_directory_uri() . '/css/font-awesome.css' );

	wp_enqueue_style('bx-slider-css', get_template_directory_uri() . '/css/jquery.bxslider.css' );

	wp_enqueue_style('animate-css', get_template_directory_uri() . '/css/animate.css' );

	wp_enqueue_style( 'eight-degree-style', get_stylesheet_uri() );

	wp_enqueue_style('eight-degree-responsive-css', get_template_directory_uri() . '/css/responsive.css' );
	
	wp_enqueue_script( 'counterup-js', get_template_directory_uri() . '/js/counterup.js', array('jquery'), '2.0.3', true );

	wp_enqueue_script( 'waypoint-js', get_template_directory_uri() . '/js/waypoint.js', array('jquery'), '2.0.3', true );

	wp_enqueue_script( 'isotope-js', get_template_directory_uri() . '/js/isotope.pkgd.js', array('jquery'), '3.0.4', true);

	wp_enqueue_script( 'bxslider-js', get_template_directory_uri() . '/js/jquery.bxslider.js', array('jquery'), '4.1.2', true );

	wp_enqueue_script( 'wow-js', get_template_directory_uri() . '/js/wow.js', array('jquery'), '', true );

	wp_enqueue_script( 'eight-degree-navigation', get_template_directory_uri() . '/js/navigation.js', array(), '20151215', true );

	wp_enqueue_script( 'eight-degree-skip-link-focus-fix', get_template_directory_uri() . '/js/skip-link-focus-fix.js', array(), '20151215', true );

	wp_register_script( 'eight-degree-custom-js', get_template_directory_uri() . '/js/custom.js', array('jquery','imagesloaded'), '20170605', true );
	wp_enqueue_script( 'eight-degree-custom-js', get_template_directory_uri() . '/js/custom.js' );
	do_action('eight_degree_homepage_slider_config');

	if ( is_singular() && comments_open() && get_option( 'thread_comments' ) ) {
		wp_enqueue_script( 'comment-reply' );
	}
}
add_action( 'wp_enqueue_scripts', 'eight_degree_scripts' );

/**
 * Custom template tags for this theme.
 */
require get_template_directory() . '/inc/template-tags.php';

/**
 * Custom functions that act independently of the theme templates.
 */
require get_template_directory() . '/inc/extras.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/inc/customizer.php';

/**
 * Load Jetpack compatibility file.
 */
require get_template_directory() . '/inc/jetpack.php';

/**
*	Addition Function file
**/
require get_template_directory() . '/inc/eight-degree-functions.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/inc/eight-degree-customizer.php';

/**
 * Controls additions.
 */
require get_template_directory() . '/inc/eight-degree-controls.php';

/**
 * Customizer additions.
 */
require get_template_directory() . '/inc/eight-degree-metabox.php';

/**
 * 8Degree widgets  additions.
 */
require get_template_directory() . '/inc/eight-degree-widgets.php';