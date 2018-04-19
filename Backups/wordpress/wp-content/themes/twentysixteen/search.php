<?php
/**
 * The template for displaying search results pages
 *
 * @link https://developer.wordpress.org/themes/basics/template-hierarchy/#search-result
 *
 * @package eight-degree
 */

get_header(); ?>

<header class="page-header">
	<div class="ed-container"> 
		<?php do_action('eight_degree_breadcrumb');?>	
		<h2 class="page-title"><?php printf( esc_html__( 'Search Results for: %s', 'eight-degree' ), '<span>' . get_search_query() . '</span>' ); ?></h2>
		</div>
</header><!-- .page-header -->
<div class="ed-container"> 

	<section id="primary" class="content-area">
		<main id="main" class="site-main" role="main">

		<?php
		if ( have_posts() ) : ?>


			<?php
			/* Start the Loop */
			while ( have_posts() ) : the_post();

				/**
				 * Run the loop for the search to output the results.
				 * If you want to overload this in a child theme then include a file
				 * called content-search.php and that will be used instead.
				 */
				get_template_part( 'template-parts/content', 'search' );

			endwhile;

			the_posts_navigation();

		else :

			get_template_part( 'template-parts/content', 'none' );

		endif; ?>

		</main><!-- #main -->
	</section><!-- #primary -->

<?php 
 get_sidebar('right');
?>
</div>
<?php
get_footer();
