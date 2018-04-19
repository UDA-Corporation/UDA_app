<?php
/**
 * Template part for displaying posts
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package eight-degree
 */

?>

<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>
	<?php
	if( has_post_thumbnail() ):
		$size = 'eight-degree-full';
		$image = wp_get_attachment_image_src( get_post_thumbnail_id( get_the_ID() ), $size, true );
	?>
	<figure>
		<a href="<?php the_permalink();?>"><img src="<?php echo esc_url($image[0]);?>" alt="<?php the_title_attribute();?>" title = "<?php the_title_attribute();?>" /></a>
	</figure>
	<?php
	endif;
	?>

	<div class="entry-content">
		<?php
			the_content( sprintf(
				/* translators: %s: Name of current post. */
				wp_kses( __( 'Continue reading %s <span class="meta-nav">&rarr;</span>', 'eight-degree' ), array( 'span' => array( 'class' => array() ) ) ),
				the_title( '<span class="screen-reader-text">"', '"</span>', false )
			) );

			wp_link_pages( array(
				'before' => '<div class="page-links">' . esc_html__( 'Pages:', 'eight-degree' ),
				'after'  => '</div>',
			) );
		?>
	</div><!-- .entry-content -->

	<footer class="entry-footer">
		<?php eight_degree_entry_footer(); ?>
	</footer><!-- .entry-footer -->
</article><!-- #post-## -->
