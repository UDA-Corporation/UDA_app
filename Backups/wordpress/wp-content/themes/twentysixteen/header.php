<?php
/**
 * The header for our theme
 *
 * This is the template that displays all of the <head> section and everything up until <div id="content">
 *
 * @link https://developer.wordpress.org/themes/basics/template-files/#template-partials
 *
 * @package eight-degree
 */

?><!DOCTYPE html>
<html <?php language_attributes(); ?>>
<head>
<meta charset="<?php bloginfo( 'charset' ); ?>">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="profile" href="http://gmpg.org/xfn/11">

<?php wp_head(); ?>
</head>

<body <?php body_class(); ?>>
<div id="page" class="site">
	<a class="skip-link screen-reader-text" href="#content"><?php esc_html_e( 'Skip to content', 'eight-degree' ); ?></a>
<?php $logo_option = get_theme_mod( 'eight_degree_header_logo_align', 'left' );?>
	<header id="masthead" class="site-header <?php echo esc_attr($logo_option);?>" role="banner">
		<div class="ed-container">
			<?php 
			if($logo_option != 'right'):?>
		        <div class="site-branding">
		            <?php 
		            if ( function_exists( 'the_custom_logo' ) ): 
		                if( has_custom_logo() ):
		                    ?>
		                <div class="site-logo">                             
		                    <?php the_custom_logo(); ?>
		                </div>                                      
		                <?php   
		                endif;
		            endif; // End the_custom_logo check. 

		            $header_option = get_theme_mod( 'header_text',1 );
		            if( $header_option ):?>
		                <div class="site-text">
		                    <a href="<?php echo esc_url( home_url( '/' ) ); ?>" rel="home">
		                        <h1 class="site-title"><?php bloginfo( 'name' ); ?></h1>
		                        <p class="site-description"><?php bloginfo( 'description' ); ?></p>
		                    </a>
		                </div>
		            <?php endif;
		            ?>
		        </div><!-- .site-branding -->
			<?php 
			endif;?>
			<nav id="site-navigation" class="main-navigation" role="navigation">
				<button class="menu-toggle" aria-controls="primary-menu" aria-expanded="false"><?php esc_html_e( 'Primary Menu', 'eight-degree' ); ?></button>
				<div class="ed-menu">
					<?php wp_nav_menu( array( 'theme_location' => 'menu-1', 'menu_id' => 'primary-menu' ) ); ?>
				</div>
				<?php 
				$search_option = get_theme_mod( 'eight_degree_header_search_option', 0 );
				if($search_option): ?>
					<div class="ed-search-wrap">                                   
	            		<?php get_search_form();?>
					</div>
				<?php endif;?>
			</nav><!-- #site-navigation -->
			<?php
			if($logo_option == 'right'):?>
		        <div class="site-branding">
		            <?php 
		            if ( function_exists( 'the_custom_logo' ) ): 
		                if( has_custom_logo() ):
		                    ?>
		                <div class="site-logo">                             
		                    <?php the_custom_logo(); ?>
		                </div>                                      
		                <?php   
		                endif;
		            endif; // End the_custom_logo check. 

		            $header_option = get_theme_mod( 'header_text',1 );
		            if( $header_option ):?>
		                <div class="site-text">
		                    <a href="<?php echo esc_url( home_url( '/' ) ); ?>" rel="home">
		                        <h1 class="site-title"><?php bloginfo( 'name' ); ?></h1>
		                        <p class="site-description"><?php bloginfo( 'description' ); ?></p>
		                    </a>
		                </div>
		            <?php endif;
		            ?>
		        </div><!-- .site-branding -->
			<?php 
			endif;?>
	    </div>
	</header><!-- #masthead -->

	<div id="content" class="site-content">
