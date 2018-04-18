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
		$size = 'eight-degree-square';
	$image = wp_get_attachment_image_src( get_post_thumbnail_id(get_the_ID()),$size,true );
	?>
	<figure>
		<a href="<?php the_permalink();?>"><img src="<?php echo esc_url($image[0]);?>" alt="<?php the_title_attribute();?>" /></a>
	</figure>
	<?php
	endif;
	?>
	<div class="portfolio-content">		

		<div class="outer-v-center">	
			<div class="v-center">
					<?php		
					the_title( '<h4 class="entry-title"><a href="' . esc_url( get_permalink() ) . '" rel="bookmark">', '</a></h4>' );
					the_excerpt(); ?>
			</div>
		</div>
	</div>
</article><!-- #post-## -->
	