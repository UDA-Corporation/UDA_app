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
	<div class="entry-content">	
		<?php the_content(); ?>				
	</div><!-- .entry-content -->
	<header class="entry-header">
		<?php

		if(has_post_thumbnail()):				
			$image = wp_get_attachment_image_src( get_post_thumbnail_id( get_the_ID() ),'eight-degree-square',true );
		?>
		<figure>
			<img src="<?php echo esc_url( $image[0] );?>" alt="<?php the_title_attribute();?>"/>
		</figure>
		<?php
		endif;
		
		the_title( '<h4 class="entry-title">', '</h4>' );
		
		?>
	</header><!-- .entry-header -->
</article><!-- #post-## -->