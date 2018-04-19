<?php
/**
 * The template for displaying 404 pages (not found)
 *
 * @link https://codex.wordpress.org/Creating_an_Error_404_Page
 *
 * @package eight-degree
 */

get_header(); ?>
<header class="page-header">
	<div class="ed-container">
		<?php do_action('eight_degree_breadcrumb');?>
			<h2 class="page-title"><?php esc_html_e( 'Oops! That page can&rsquo;t be found.', 'eight-degree' ); ?></h2>
	</div>
</header><!-- .page-header -->
<div class="ed-container"> 

	<div id="primary" class="content-area">
		<main id="main" class="site-main" role="main">

			<section class="error-404 not-found">
				

				<div class="page-content">
					<p><?php esc_html_e( 'It looks like nothing was found at this location.', 'eight-degree' ); ?></p>
					<div class="error-404-text">
						<p><?php esc_html_e( 'error', 'eight-degree' ); ?></p>
						<h1><?php esc_html_e( '404', 'eight-degree' ); ?></h1>
					</div>

				</div><!-- .page-content -->
			</section><!-- .error-404 -->

		</main><!-- #main -->
	</div><!-- #primary -->
</div>
<?php
get_footer();
