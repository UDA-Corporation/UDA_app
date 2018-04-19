<?php
/**
 * Template part for displaying posts
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package eight-degree
 */
			$readmore = get_theme_mod('eight_degree_innerpage_archive_readmore',__('Read More', 'eight-degree'));
?>
<div class="service-post">
	<?php if(has_post_thumbnail()):
		$img = wp_get_attachment_image_src( get_post_thumbnail_id(), 'thumbnail' );
        $img_link = $img[0];
	?>
		<figure>
			<div class="center-outer">
				<div class="center-inner">	
					<a href="<?php echo esc_url(get_the_permalink());?>">
						<img src="<?php echo esc_url($img_link);?>" alt= "<?php the_title_attribute()?>"/>
					</a>
				</div>
			</div>
		</figure>
	<?php endif;?>
	<div class="service-content">
		<?php the_title( '<h4 class="service-title"><a href="'.esc_url( get_the_permalink() ).'">', '</a></h4>');?>
		<?php the_excerpt();?>
		<a href="<?php the_permalink();?>" class="ed-bttn readmore"><?php echo esc_html($readmore);?></a>
	</div>
</div>