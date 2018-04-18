<?php
/**
 * Template part for displaying posts
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package eight-degree
 */
if( is_archive() ):
	$readmore = get_theme_mod( 'eight_degree_innerpage_archive_readmore',esc_html__( 'Read More','eight-degree' ) );
	$layout = get_theme_mod( 'eight_degree_innerpage_archive_post_layout','large-image' );
?>

<article id="post-<?php the_ID(); ?>" <?php post_class(); ?>>
		<?php
		if( has_post_thumbnail() ):
			$size = 'eight-degree-rect-wide';
			if($layout == 'large-image'):
				$size = 'eight-degree-slider';
			endif;
			$image = wp_get_attachment_image_src( get_post_thumbnail_id( get_the_ID() ), $size, true );
		?>
			<figure>
				<a href="<?php the_permalink();?>"><img src="<?php echo esc_url($image[0]);?>" alt="<?php the_title_attribute();?>" title = "<?php the_title_attribute();?>" /></a>
			</figure>
		<?php
		endif;?>
	<div class="entry-content-wrap">
		<header class="entry-header clear">
			<?php
			if ( 'post' === get_post_type() ) : ?>
				<div class="entry-meta">
					<?php eight_degree_post_header(); ?>
				</div><!-- .entry-meta -->
			<?php
			endif; 
			the_title( '<h4 class="entry-title"><a href="' . esc_url( get_permalink() ) . '" rel="bookmark">', '</a></h4>' );?>
		</header><!-- .entry-header -->

		<div class="entry-content">
			<?php
			the_excerpt();
			?>
		</div><!-- .entry-content -->
		<a href="<?php the_permalink();?>" class='readmore'><?php echo esc_html($readmore);?></a>
		<footer class="entry-footer">
			<?php eight_degree_post_footer(); ?>
		</footer><!-- .entry-footer -->
	</div>
</article><!-- #post-## -->
<?php else:?>
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
	endif;	?>
	<div class="entry-content-wrap">
		<header class="entry-header clear">
			<?php
			if ( 'post' === get_post_type() ) : ?>
				<div class="entry-meta">
					<?php eight_degree_post_header(); ?>
				</div><!-- .entry-meta -->
			<?php
			endif; 
			the_title( '<h4 class="entry-title"><a href="' . esc_url( get_permalink() ) . '" rel="bookmark">', '</a></h4>' );?>
		</header><!-- .entry-header -->

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
			<?php eight_degree_post_footer(); ?>
		</footer><!-- .entry-footer -->
	</div>	
</article><!-- #post-## -->
<?php endif;