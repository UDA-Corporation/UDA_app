<?php
/**
 * eight-degree Theme Customizer Addition
 *
 * @package eight-degree
 */

/**
 * Add postMessage support for site title and description for the Theme Customizer.
 *
 * @param WP_Customize_Manager $wp_customize Theme Customizer object.
 */
function eight_degree_customizer_addition( $wp_customize ) {
	require get_template_directory() . '/inc/eight-degree-sanitize.php';

	$wp_customize->add_panel( 
		'eight_degree_default',
		array(
			'title'			=>	__( 'Default Setting','eight-degree' ),
			'priority'		=>	5,
			)
		);
	$wp_customize->get_section( 'title_tagline' )->panel         = 'eight_degree_default';
	$wp_customize->get_section( 'colors' )->panel  = 'eight_degree_default';
	$wp_customize->get_section( 'background_image' )->panel = 'eight_degree_default';
	$wp_customize->get_section( 'static_front_page' )->panel = 'eight_degree_default';
	$wp_customize->get_section( 'custom_css' )->panel = 'eight_degree_default';


	require get_template_directory() . '/inc/admin-panel/eight-degree-theme.php';
	require get_template_directory() . '/inc/admin-panel/eight-degree-header.php';
	require get_template_directory() . '/inc/admin-panel/eight-degree-homepage.php';
	require get_template_directory() . '/inc/admin-panel/eight-degree-innerpage.php';
	require get_template_directory() . '/inc/admin-panel/eight-degree-related.php';
	require get_template_directory() . '/inc/admin-panel/eight-degree-footer.php';

}
add_action( 'customize_register', 'eight_degree_customizer_addition' );
