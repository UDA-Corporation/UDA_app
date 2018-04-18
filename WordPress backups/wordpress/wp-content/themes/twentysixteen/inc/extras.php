<?php
/**
 * Custom functions that act independently of the theme templates
 *
 * Eventually, some of the functionality here could be replaced by core features.
 *
 * @package eight-degree
 */

/**
 * Adds custom classes to the array of body classes.
 *
 * @param array $classes Classes for the body element.
 * @return array
 */
function eight_degree_body_classes( $classes ) {
	// Adds a class of group-blog to blogs with more than 1 published author.
	if ( is_multi_author() ) {
		$classes[] = 'group-blog';
	}

	// Adds a class of hfeed to non-singular pages.
	if ( ! is_singular() ) {
		$classes[] = 'hfeed';
	}

	return $classes;
}
add_filter( 'body_class', 'eight_degree_body_classes' );

function eight_degree_extra_body_classes( $classes ) {
    $weblayout = get_theme_mod( 'eight_degree_theme_weblayout_option', 'ed-fullwidth' );
    $classes[] .= esc_attr( $weblayout );

	if ( (is_home() || is_front_page()) && is_page_template() ) {
        if( is_page_template() ){
		  $classes[] .= 'no-sidebar';
        }
        else{
            $classes[].= 'right-sidebar';
        }

	}
    elseif( is_search() ){
        $classes[] .= 'right-sidebar';
    }
    elseif( is_404() ){
        $classes[] .= 'right-sidebar';
    }

    elseif( is_singular( array( 'post','page' ) ) ){
        global $post;

        $post_sidebar = get_post_meta( $post->ID, 'eight_degree_sidebar_layout', true );
        if(empty( $post_sidebar)){
                $post_sidebar = 'right-sidebar';
        }

        $classes[] .= esc_attr( $post_sidebar );
    }
   
    elseif( is_archive() ){
        $post_sidebar = get_theme_mod( 'eight_degree_innerpage_archive_layout', 'right-sidebar' );
        if(empty( $post_sidebar)){
                $post_sidebar = 'right-sidebar';          
        }
        $classes[] .= esc_attr( $post_sidebar );
    }
    else {
        $classes[] .= 'right-sidebar';
    }

	return $classes;
}
add_filter( 'body_class', 'eight_degree_extra_body_classes' );

/**
 * Add a pingback url auto-discovery header for singularly identifiable articles.
 */
function eight_degree_pingback_header() {
	if ( is_singular() && pings_open() ) {
		echo '<link rel="pingback" href="', esc_url( get_bloginfo( 'pingback_url' ) ), '">';
	}
}
add_action( 'wp_head', 'eight_degree_pingback_header' );
