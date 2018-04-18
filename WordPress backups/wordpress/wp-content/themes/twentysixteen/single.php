<?php
/**
 * The template for displaying all single posts
 *
 * @link https://developer.wordpress.org/themes/basics/template-hierarchy/#single-post
 *
 * @package eight-degree
 */

get_header();
global $post;
do_action('eight_degree_pageheader');
$blog = get_theme_mod('eight_degree_theme_category_blog',0);
$cat_detail = get_the_category( $post->ID );
$cats = $cat_detail[0]->parent;
if($cats != 0){
	$cats = $cats;
}
else{
	$cats = $cat_detail[0]->cat_ID;
}
?>
	<div class="ed-container">
		<?php 	    

    	$sidebar = get_post_meta( $post->ID, 'eight_degree_sidebar_layout' , true );
		if(empty($sidebar)){
			$sidebar='right-sidebar';
		}
		if($sidebar=='both-sidebar'){
			?>
			<div class="left-sidebar-right">
		<?php
		}
		?>
			<div id="primary" class="content-area">
				<main id="main" class="site-main" role="main">

				<?php
				while ( have_posts() ) : the_post();

					get_template_part( 'template-parts/content', get_post_format() );
						if( ( $cats == $blog ) ){
							if(get_theme_mod('eight_degree_author_option')){
								do_action("eight_degree_author_detail");
							}
						}
					the_post_navigation();
						
						if( ( $cats == $blog ) ){
							if(get_theme_mod('eight_degree_related_option')){
								do_action('eight_degree_related_posts');
							}
						}

					// If comments are open or we have at least one comment, load up the comment template.
					if ( comments_open() || get_comments_number() ) :
						comments_template();
					endif;

				endwhile; // End of the loop.
				?>
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
<?php get_footer(); ?>
