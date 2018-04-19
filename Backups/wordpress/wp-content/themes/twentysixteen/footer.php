<?php
/**
 * The template for displaying the footer
 *
 * Contains the closing of the #content div and all content after.
 *
 * @link https://developer.wordpress.org/themes/basics/template-files/#template-partials
 *
 * @package eight-degree
 */

?>

	</div><!-- #content -->

	<footer id="colophon" class="site-footer" role="contentinfo">
	
		<?php 
		if ( is_active_sidebar( 'eight-degree-footer-one' ) ||  is_active_sidebar( 'eight-degree-footer-two' )  || is_active_sidebar( 'eight-degree-footer-three' )  || is_active_sidebar( 'eight-degree-footer-four' ) ) : ?>
			<div class="top-footer footer-column-<?php echo esc_attr( eight_degree_footer_count() ); ?>">
				<div class="ed-container">

					<?php if ( is_active_sidebar( 'eight-degree-footer-one' ) ) : ?>
						<div class="footer-block-one footer-block">
							<?php dynamic_sidebar( 'eight-degree-footer-one' ); ?>    							
						</div>
					<?php endif; ?>	

					<?php if ( is_active_sidebar( 'eight-degree-footer-two' ) ) : ?>
						<div class="footer-block-two footer-block">	    						
							<?php dynamic_sidebar( 'eight-degree-footer-two' ); ?>	    						
						</div>
					<?php endif; ?>	

					<?php if ( is_active_sidebar( 'eight-degree-footer-three' ) ) : ?>
						<div class="footer-block-three footer-block">    							
							<?php dynamic_sidebar( 'eight-degree-footer-three' ); ?>
						</div>
					<?php endif; ?>

					<?php if ( is_active_sidebar( 'eight-degree-footer-four' ) ) : ?>
						<div class="footer-block-four footer-block">    							
							<?php dynamic_sidebar( 'eight-degree-footer-four' ); ?>
						</div>
					<?php endif; ?>
				</div>
			</div>
		<?php endif; ?>
		<div class="bottom-footer">
			<div class="ed-container">
				<div class="site-info">
					<?php
					$footer_logo = get_theme_mod('eight_degree_footer_logo','');
					if(!empty($footer_logo)):?>
						<a href="<?php the_permalink();?>"><img src=<?php echo esc_url($footer_logo);?> /></a>
					<div class="copyright-wrap">
						<?php
						endif;
						$copyright = get_theme_mod('eight_degree_footer_copyright','');
						if($copyright && $copyright!=""):
							echo wp_kses_post($copyright);
						
						else:?>
						<?php esc_html_e( 'WordPress Theme : ', 'eight-degree' );  ?><a  title="<?php esc_attr_e('Free WordPress Theme','eight-degree');?>" href="<?php echo esc_url( __( 'https://8degreethemes.com/wordpress-themes/eight-degree/', 'eight-degree' ) ); ?>"><?php esc_html_e( 'Eight Degree', 'eight-degree' ); ?> </a>
						<span><?php esc_html_e(' by 8Degree Themes','eight-degree');?></span>
					<?php endif;?>	
					</div>
				</div><!-- .site-info -->
				<?php
				
				$menu = get_theme_mod( 'eight_degree_footer_menu', 0 );
				if(( $menu != 0 && !empty( $menu ) ) ):?>
					<div class="footer-menu">
						<?php 
						wp_nav_menu(array( 'menu' => $menu) );							
						?>
					</div>
				<?php endif;
				$footer_social = get_theme_mod('eight_degree_footer_social_option',0);
				if($footer_social):
					?>
					<div class="footer-social">
						<?php
						do_action('eight_degree_social');
						?>			
					</div>
					<?php
				endif;?>
			</div>
		</div>
	</footer><!-- #colophon -->
</div><!-- #page -->

<div id="back-to-top"><i class="fa fa-long-arrow-up"></i></div>
<?php wp_footer(); ?>

</body>
</html>