<?php
/**
 * The template for displaying archive pages
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package eight-degree
 */

get_header(); 
global $post;
do_action('eight_degree_pageheader');?>
<div class="ed-container"> 

	<?php    
	    $sidebar = get_theme_mod('eight_degree_innerpage_archive_layout','right-sidebar');
		$layout = get_theme_mod( 'eight_degree_innerpage_archive_post_layout','large-image' );
	    if(empty($sidebar)){
	            $sidebar= 'right-sidebar';
	        }
	    if( $sidebar=='both-sidebar' ){
	        ?>
	            <div class="left-sidebar-right">
	        <?php
	    }?>
		<div id="primary" class="content-area">
			<main id="main" class="site-main" role="main">
				<div class="archive-page  <?php echo esc_attr( $layout );?>"> 
					<?php   
					if ( have_posts() ) : 

						/* Start the Loop */
						while ( have_posts() ) : the_post();

							/*
							 * Include the Post-Format-specific template for the content.
							 * If you want to override this in a child theme, then include a file
							 * called content-___.php (where ___ is the Post Format name) and that will be used instead.
							 */							
							get_template_part( 'template-parts/content', get_post_format() );

						endwhile;

						the_posts_navigation();

					else :

						get_template_part( 'template-parts/content', 'none' );

					endif; ?>
				</div>
			</main><!-- #main -->
		</div><!-- #primary -->

	    <?php 
	    if($sidebar=='left-sidebar' || $sidebar=='both-sidebar'){
	        get_sidebar('left');
	    }
	    if($sidebar=='both-sidebar'){
	        ?>
	        </div>
	        <?php
	    }
	    if($sidebar=='right-sidebar' || $sidebar=='both-sidebar'){
	     get_sidebar('right');
	    }
	    ?>
</div>
<?php
get_footer();
