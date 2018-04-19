<?php
/**
 * The template for displaying all pages
 *
 * This is the template that displays all pages by default.
 * Please note that this is the WordPress construct of pages
 * and that other 'pages' on your WordPress site may use a
 * different template.
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

				get_template_part( 'template-parts/content', 'page' );

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
<?php
get_footer();