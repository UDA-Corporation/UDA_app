<?php
/**
 * Template Name: Homepage
 *
 * @link https://codex.wordpress.org/Template_Hierarchy
 *
 * @package eight-degree
 */

get_header(); 
//////////////////////////////////////////////////////////////
//////////////////Adding Slider///////////////////////////////
//////////////////////////////////////////////////////////////
do_action('eight_degree_slider');

//////////////////////////////////////////////////////////////
/////////////// Adding Service Section //////////////////////
////////////////////////////////////////// ////////////////////

$service_section = get_theme_mod( 'eight_degree_homepage_service_option', 0 );
if( $service_section == 1 ):	
?>
		<section id="service-section" class="section ed-service-section">
			<div class="ed-container">
			<?php 
			$service_page = get_theme_mod( 'eight_degree_homepage_service_page', 0 );
				if( $service_page != 0):
						$service_data = get_post( $service_page );?>
					<div class="service-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="service-title"><?php echo esc_html( $service_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $service_data->post_content );?></p>
					</div>
			<?php 
				endif;
				$service_cat = get_theme_mod( 'eight_degree_theme_category_service', 0 );
				if( $service_cat != 0 ):
					$i=0;
					$service_readmore = get_theme_mod( 'eight_degree_homepage_service_readmore', esc_html('Read More','eight-degree' ) );
					$service_args = array( 'cat' => $service_cat, 'post_status' => 'publish', 'post_type' => 'post', 'posts_per_page' => -1 );
					$service_query = new WP_Query( $service_args );?>
					<div class="service-post-wrap">
						<?php 
						while( $service_query->have_posts() ):
							$i+=0.5;
							$service_query->the_post();?>
							<div class="service-post fadeInRight wow" data-wow-delay="<?php echo esc_attr($i);?>s" data-wow-duration="2s">
								<?php if(has_post_thumbnail()):
									$img = wp_get_attachment_image_src( get_post_thumbnail_id(), 'thumbnail' );
			                        $img_link = $img[0];
								?>
									<figure>
										<div class="center-outer">
											<div class="center-inner">	
												<a href="<?php the_permalink();?>">
													<img src="<?php echo esc_url($img_link);?>" alt= "<?php the_title_attribute()?>"/>
												</a>
											</div>
										</div>
									</figure>
								<?php endif;?>
								<div class="service-content">
									<?php the_title( '<h4 class="service-title"><a href="'.esc_url(get_the_permalink()).'">', '</a></h4>');?>
									<?php the_excerpt();?>
									<a href="<?php the_permalink();?>" class="ed-bttn readmore"><?php echo esc_html($service_readmore);?></a>
								</div>
							</div>
						<?php
						endwhile;
						wp_reset_postdata();
						?>
					</div>
					<?php
				endif;?>
			</div>
		</section>
<?php
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding Featured Section //////////////////////
//////////////////////////////////////////////////////////////

$featured_section = get_theme_mod( 'eight_degree_homepage_featured_option', 0 );
if( $featured_section == 1 ):
	$featured_cat = get_theme_mod( 'eight_degree_theme_category_featured', 0 );
	$featured_page = get_theme_mod( 'eight_degree_homepage_featured_page', 0 );
	if( $featured_cat != 0 || $featured_page != 0):
?>
		<section id="featured-section" class="section ed-featured-section">
			<div class="ed-container">
			<?php 
				if( $featured_page != 0):
						$featured_data = get_post( $featured_page );?>
					<div class="featured-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="featured-title"><?php echo esc_html( $featured_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $featured_data->post_content );?></p>
					</div>
			<?php 
				endif;

			if( $featured_cat != 0 ):?>
				<div class="featured-tab-post wow fadeInUp" data-wow-duration="2s"">
					<?php
					$feat_args = array( 'cat' => $featured_cat, 'post_status' => 'publish', 'post_type' => 'post', 'posts_per_page' => 3 );
					$feat_query = new WP_Query( $feat_args );
					$i = 0;
					while( $feat_query->have_posts() ):
						$i++;
						$feat_query->the_post();
						if($i==1):
						?>
						<div class="featured-tab-wrap">
							<?php 
						endif;
							the_title( '<div id="tab'. esc_attr($i) .'" class="featured-title">', '</div>' );

						if($i==3):?>			
						</div>
					<?php
						endif;
					endwhile;
					$j = 0;?>

					<div class="featured-post-wrap">
						<?php
						while( $feat_query->have_posts() ):
							$j++;
							$feat_query->the_post();
							?>						
							<div class="featured-post tab<?php echo esc_attr( $j );?>">
								<div class="featured-content">
									<?php the_title( '<h4 class="featured-title">', '</h4>' );
									the_excerpt();?>
								</div>
								<?php if(has_post_thumbnail()):
									$img = wp_get_attachment_image_src(get_post_thumbnail_id(), 'eight-degree-rect-height');
			                        $img_link = $img[0];
								?>
									<figure>
										<img src="<?php echo esc_url($img_link);?>" alt= "<?php the_title_attribute()?>" >
									</figure>
								<?php endif;?>
							</div>
						<?php
						endwhile;
						wp_reset_postdata();
				?>	
					</div>
				</div>
				<?php
			endif;?>
			</div>
		</section>
<?php
	endif;
endif;


//////////////////////////////////////////////////////////////
/////////////// Adding Skill Section //////////////////////
//////////////////////////////////////////////////////////////

$skill_section = get_theme_mod( 'eight_degree_homepage_skill_option', 0 );
if( $skill_section == 1 ):
	$skill_cat = get_theme_mod( 'eight_degree_theme_category_skill', 0 );
	$skill_page = get_theme_mod( 'eight_degree_homepage_skill_page', 0 );
	$ceo_title = get_theme_mod( 'eight_degree_homepage_skill_ceo_title', esc_html__('Word from CEO','eight-degree') );
	$ceo_msg = get_theme_mod( 'eight_degree_homepage_skill_ceo_msg', 0 );
	if( $skill_cat != 0 || $skill_page != 0):

		$skill_data = get_post( $skill_page );
		$skill_image = get_the_post_thumbnail_url( $skill_page, 'full' );
?>
		<section id="skill-section" class="section ed-skill-section" style="background-image: url('<?php echo esc_url($skill_image);?>');">
			<div class="ed-container">
				<div class="message-wrap">
					<?php 
						if( !empty( $ceo_title ) ):?>
							<div class="message-header wow fadeInLeft" data-wow-duration="2s">
								<h2 class="message-title"><?php echo esc_html( $ceo_title );?></h2>
							</div>
					<?php 
						endif;
						if( $ceo_msg != 0):
							$msg_data = get_post( $ceo_msg );
	    					$msg_image = get_the_post_thumbnail_url( $ceo_msg, 'thumbnail' ); ?>
							<div class="message-content wow fadeInLeft" data-wow-duration="2s">						
								<p><?php echo wp_kses_post( $msg_data->post_content );?></p>
								<div class="message-title-wrap">
									<?php if(!empty($msg_image)):?>
										<img src="<?php echo esc_url( $msg_image );?>" alt="<?php the_title_attribute();?>"/>
									<?php endif;?>
									<h5 class="message-post-title"><?php echo wp_kses_post( $msg_data->post_title );?></h5>
								</div>
							</div>
					<?php 
						endif;
					
					?>
				</div>
				<div class="skill-widget-wrap" >
					<div class="skill-content-wrap">
						<?php 
							if( $skill_page != 0):?>
								<div class="skill-header wow fadeInRight" data-wow-duration="2s">
									<h2 class="skill-title"><?php echo esc_html( $skill_data->post_title );?></h2>
									<p><?php echo wp_kses_post( $skill_data->post_content );?></p>
								</div>
						<?php 
							endif;

						if(is_active_sidebar( 'eight-degree-skill-section' ) ):?>
							<div class="skill-widget">
								<?php dynamic_sidebar( 'eight-degree-skill-section' );?>
							</div>
						<?php
						endif;
						?>
					</div>
				</div>
			</div>
		</section>
<?php
	endif;
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding Portfolio Section //////////////////////
//////////////////////////////////////////////////////////////


$portfolio_section = get_theme_mod( 'eight_degree_homepage_portfolio_option', 0 );
if( $portfolio_section == 1 ):
	$portfolio_cat = get_theme_mod( 'eight_degree_theme_category_portfolio', 0 );
	$portfolio_page = get_theme_mod( 'eight_degree_homepage_portfolio_page', 0 );
	$portfolio_data = get_post( $portfolio_page );	
	$portfolio_image = get_the_post_thumbnail_url( $portfolio_data, 'full' );
	if( $portfolio_cat != 0 || $portfolio_page != 0):
?>
		<section id="portfolio-section" class="section ed-portfolio-section" style="background-image: url('<?php echo esc_url($portfolio_image);?>'); ">
			<div class="ed-container">
			<?php 
				if( $portfolio_page != 0):?>
					<div class="portfolio-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="portfolio-title"><?php echo esc_html( $portfolio_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $portfolio_data->post_content );?></p>
					</div>
			<?php 
				endif;

			if( $portfolio_cat != 0 ):?>
					<header class="sort-table"> 
                            <?php
                    $all_cat = get_categories(array('type' => 'post', 'parent' => $portfolio_cat));
                    		$i = 0.2;
                            if (!empty($all_cat) && !is_wp_error($all_cat)):
                                echo "<ul class='button-group filters-button-group'>";
                                if (!empty($all_cat)) {
                                    echo '<li class="button is-checked wow fadeInDown" data-wow-duration="0.2s" data-filter="*">' . esc_html__('All', 'eight-degree') . '</li>';
                                }
                                foreach ($all_cat as $category) :
                                	$i+=0.2;
                                    $cat_detail = get_term($category,'category');
                                    echo '<li class="button wow fadeInDown" data-wow-delay="'.esc_attr($i).'s" data-filter=.' . esc_attr($cat_detail->slug) . '>' . esc_html($cat_detail->name) . '</li>';
                                endforeach;
                                echo "</ul>";
                            endif;
                            wp_reset_postdata();
                            ?>
                    </header>
				<div class="portfolio-post-wrap">
				<?php
					$port_args = array( 'cat' => $portfolio_cat, 'post_status' => 'publish', 'post_type' => 'post', 'posts_per_page' => 12 );
					$port_query = new WP_Query( $port_args );
					while( $port_query->have_posts() ):						
						$port_query->the_post();
						$term_lists = wp_get_post_terms( get_the_ID(), 'category', array("fields" => "all") );
                                $term_slugs = array();
                                foreach( $term_lists as $term_list ) {
                                    $term_slugs[] = $term_list->slug;
                                }
                                $term_slugs = join( ' ', $term_slugs );?>
						<div class="portfolio-post <?php echo esc_attr( $term_slugs);?>">
							<?php if(has_post_thumbnail()):
								$img = wp_get_attachment_image_src( get_post_thumbnail_id(), 'eight-degree-square' );
		                        $img_link = $img[0];
							?>
								<figure>
									<img src="<?php echo esc_url( $img_link );?>" alt= "<?php the_title_attribute()?>" />
								</figure>
							<?php endif;?>
							<div class="portfolio-content">
								<div class="outer-v-center">	
									<div class="v-center">
										<?php the_title( '<h4 class="portfolio-post-title">', '</h4>' );
										the_excerpt();
										?>
									</div>
								</div>
							</div>
						</div>
					<?php
					endwhile;
					wp_reset_postdata();
			?>
				</div>
				<?php
			endif;?>
			</div>
		</section>
<?php
	endif;
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding Testimonial Section ///////////////////
//////////////////////////////////////////////////////////////

$testimonial_section = get_theme_mod( 'eight_degree_homepage_testimonial_option', 0 );
if( $testimonial_section == 1 ):
	$testimonial_cat = get_theme_mod( 'eight_degree_theme_category_testimonial', 0 );
	$testimonial_page = get_theme_mod( 'eight_degree_homepage_testimonial_page', 0 );
	$testimonial_data = get_post( $testimonial_page );
	if( $testimonial_cat != 0 || $testimonial_page != 0):
?>
		<section id="testimonial-section" class="section ed-testimonial-section">
			<div class="ed-container">
			<?php 
				if( $testimonial_page != 0):
						?>
					<div class="testimonial-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="testimonial-title"><?php echo esc_html( $testimonial_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $testimonial_data->post_content );?></p>
					</div>
			<?php 
				endif;?>
				<div class="testimonial-slider wow fadeInUp" data-wow-duration="2s">
				<?php 
					if( $testimonial_cat != 0 ):
						$total_posts = get_theme_mod( 'eight_degree_homepage_testimonial_post', 3 );
						$test_args = array( 'cat' => $testimonial_cat, 'post_status' => 'publish', 'post_type' => 'post', 'posts_per_page' => -1 );
						$test_query = new WP_Query( $test_args );
						while( $test_query->have_posts() ):
							$test_query->the_post();?>
							<div class="testimonial-post">
								<?php if( has_post_thumbnail() ):
									$img = wp_get_attachment_image_src( get_post_thumbnail_id(), 'thumbnail' );
			                        $img_link = $img[0];
								?>
									<div class="testimonial-wrap">
										<figure>										
											<img src="<?php echo esc_url( $img_link );?>" alt= "<?php the_title_attribute()?>">
										</figure>
										<?php the_title( '<h5 class="testimonial-post-title">', '</h5>' );?>
									</div>
								<?php endif;?>
								<div class="testimonial-content">
									<?php 
									the_excerpt();
									?>
								</div>
							</div>
						<?php
						endwhile;
						wp_reset_postdata();
					endif;
				?>
				</div>
			</div>
		</section>
	<?php
		endif;
endif;

//////////////////////////////////////////////////////////////
//////////////// Adding Counter Section //////////////////////
//////////////////////////////////////////////////////////////

$counter_section = get_theme_mod( 'eight_degree_homepage_counter_option', 0 );
if( $counter_section == 1 ):
	$background1 = get_theme_mod( 'eight_degree_homepage_counter_background1', 0 );
	if( !empty($background1) || !empty($background1) || is_active_sidebar( 'eight-degree-counter-section' ) ):
?>
		<section id="counter-section" class="section ed-counter-section" style="background-image: url('<?php echo esc_url($background1);?>'); background-position: 50% 50%;background-size: cover;">
				<?php 
				if( is_active_sidebar( 'eight-degree-counter-section' ) ):?>
					<div class="counter-widget">
						<?php dynamic_sidebar( 'eight-degree-counter-section' );?>
					</div>
				<?php
				endif;
				?>
		</section>
<?php
	endif;
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding team Section //////////////////////
//////////////////////////////////////////////////////////////

$team_section = get_theme_mod( 'eight_degree_homepage_team_option', 0 );
if( $team_section == 1 ):
	$team_cat = get_theme_mod( 'eight_degree_theme_category_team', 0 );
	$team_page = get_theme_mod( 'eight_degree_homepage_team_page', 0 );
	$team_data = get_post( $team_page );
	if( $team_cat != 0 || $team_page != 0):
?>
		<section id="team-section" class="section ed-team-section">
			<div class="ed-container">
			<?php 
				if( $team_page != 0):
					$team_data = get_post( $team_page );?>
					<div class="team-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="team-title"><?php echo esc_html( $team_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $team_data->post_content );?></p>
					</div>
			<?php 
				endif;

			if( $team_cat != 0 ):?>

				<div class="team-wrap">
				<?php
				$total_posts = get_theme_mod( 'eight_degree_homepage_team_post', 3 );
				$team_args = array( 'cat' => $team_cat, 'post_status' => 'publish', 'post_type' => 'post', 'posts_per_page' => $total_posts );
				$team_query = new WP_Query( $team_args );
				$i = 0;
				while( $team_query->have_posts() ):
					$i+=0.5;
					$team_query->the_post();?>
					<div class="team-post fadeInRight wow" data-wow-delay="<?php echo esc_attr($i);?>s" data-wow-duration="2s">
						<?php if(has_post_thumbnail()):
							$img = wp_get_attachment_image_src(get_post_thumbnail_id(), 'full');
	                        $img_link = $img[0];
						?>
							<figure>
								<img src="<?php echo esc_url( $img_link );?>" alt= "<?php the_title_attribute()?>">
							</figure>
						<?php endif;?>
						<div class="team-content">
							<?php the_title( '<h4 class="team-post-title">', '</h4>' );
							the_excerpt();
							?>
						</div>
					</div>
				<?php
				endwhile;
				wp_reset_postdata();?>

				</div><?php
			endif;
			?>
			</div>
		</section>
<?php
	endif;
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding cta Section //////////////////////
//////////////////////////////////////////////////////////////

$cta_section = get_theme_mod( 'eight_degree_homepage_cta_option', 0 );
if( $cta_section == 1 ):
	$cta_page = get_theme_mod( 'eight_degree_homepage_cta_page', 0 );
	$readmore_text = get_theme_mod( 'eight_degree_homepage_cta_readmore', esc_html__( 'Download Now','eight-degree' ) );
	$readmore_url = get_theme_mod( 'eight_degree_homepage_cta_readmore_link', esc_url( '#' ) );
	$cta_data = get_post( $cta_page );
    $cta_bg_image = get_the_post_thumbnail_url( $cta_page, 'full' );  

	if( $cta_page != 0 ):
?>
		<section id="cta-section" class="section ed-cta-section"<?php if(!empty($cta_bg_image)): ?> style="background-image: url(<?php echo esc_url($cta_bg_image);?>);background-attachment: fixed;"<?php endif;?>>
			<?php
				if( $cta_page != 0 ):?>
					<div class="ed-container">
						<div class="cta-header wow fadeInUp" data-wow-duration="2s">
							<h2 class="cta-title"><?php echo esc_html( $cta_data->post_title );?></h2>
							<p><?php echo wp_kses_post( $cta_data->post_content );?></p>
							<a href="<?php echo esc_url($readmore_url);?>" class="cta-bttn"><?php echo esc_html($readmore_text);?></a>
						</div>
					</div>
			<?php 
				endif;
			?>
		</section>
<?php
	endif;
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding Blog Section //////////////////////
//////////////////////////////////////////////////////////////


$blog_section = get_theme_mod( 'eight_degree_homepage_blog_option', 0 );
if( $blog_section == 1 ):
	$blog_cat = get_theme_mod( 'eight_degree_theme_category_blog', 0 );
	$blog_page = get_theme_mod( 'eight_degree_homepage_blog_page', 0 );
	$blog_post = get_theme_mod( 'eight_degree_homepage_blog_post', 3 );
	$blog_readmore = get_theme_mod( 'eight_degree_homepage_blog_readmore', esc_html__( 'Read More','eight-degree' ) );
	$blog_data = get_post( $blog_page );
	if( $blog_cat != 0 || $blog_page != 0):
?>
		<section id="blog-section" class="section ed-blog-section">
			<div class="ed-container">
			<?php 
				if( $blog_page != 0):
						$blog_data = get_post( $blog_page );?>
					<div class="blog-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="blog-title"><?php echo esc_html( $blog_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $blog_data->post_content );?></p>
					</div>
			<?php 
				endif;

			if( $blog_cat != 0 ):?>
				<div class="blog-post-wrap">
				<?php
				$blog_args = array( 'cat' => $blog_cat, 'post_status' => 'publish', 'post_type' => 'post', 'posts_per_page' => $blog_post );
				$blog_query = new WP_Query( $blog_args );
				$i=0;
				while( $blog_query->have_posts() ):
					$i+=0.5;
					$blog_query->the_post();?>
					<div class="blog-post fadeInRight wow" data-wow-delay="<?php echo esc_attr($i);?>s" data-wow-duration="2s">
						<?php if(has_post_thumbnail()):
							$img = wp_get_attachment_image_src( get_post_thumbnail_id(), 'eight-degree-rect-wide' );
	                        $img_link = $img[0];
						?>
							<figure>
								<a href="<?php the_permalink();?>"><img src="<?php echo esc_url($img_link);?>" alt= "<?php the_title_attribute()?>" title= "<?php the_title()?>" />
								</a>
							</figure>
						<?php endif;?>
						<div class="blog-content">
							<?php the_title( '<h4 class="blog-post-title"><a href="'. esc_url(get_the_permalink()) .'">', '</a></h4>' );?>
							<div class="blog-date">
								<a href="<?php the_permalink();?>"><?php the_time( get_option( 'date_format' ) );?></a>
	                        </div>
	                        <?php 
							the_excerpt();
							?>
							<a href="<?php the_permalink();?>" class="ed-bttn readmore"><?php echo esc_html($blog_readmore);?></a>
						</div>
					</div>
				<?php
				endwhile;
			?>
				</div>
				<?php
			endif;?>
			</div>			
		</section>
<?php
	endif;
endif;

//////////////////////////////////////////////////////////////
/////////////// Adding Contact Section ///////////////////
//////////////////////////////////////////////////////////////

$contact_section = get_theme_mod( 'eight_degree_homepage_contact_option', 0 );
if( $contact_section == 1 ):
	$contact_shortcode = get_theme_mod( 'eight_degree_homepage_contact_shortcode', '' );
	$contact_page = get_theme_mod( 'eight_degree_homepage_contact_page', 0 );
	$contact_phone = get_theme_mod( 'eight_degree_homepage_contact_phone', '+977-01-4671980' );
	$contact_email = get_theme_mod( 'eight_degree_homepage_contact_email', 'info@8degreethemes.com' );
	$contact_data = get_post( $contact_page );
	$map_api_key = get_theme_mod( 'eight_degree_theme_map_api', 'AIzaSyCS3bJGTLkOHHUM9vE-LfwxNbWRGZdlr3M' );
	if( !empty($contact_shortcode) || $contact_page != 0 ):
?>
		<section id="contact-section" class="section ed-contact-section">
			<div class="ed-container">
			<?php 
				if( $contact_page != 0):?>
					<div class="contact-header wow fadeInUp" data-wow-duration="2s">
						<h2 class="contact-title"><?php echo esc_html( $contact_data->post_title );?></h2>
						<p><?php echo wp_kses_post( $contact_data->post_content );?></p>
					</div>
			<?php 
				endif;?>
				<div class="contact-wrap">					
					<?php
					if( !empty($contact_shortcode) ):?>
						<div class="contact-form fadeInLeft wow" data-wow-duration="2s">
							<?php echo do_shortcode( wp_kses_post($contact_shortcode) );?>
						</div>
						<?php
					endif;?>
					<div class="contact-map-details">
							<div id="contact-google-map" class="contact-map fadeInRight wow" data-wow-duration="2s" style="width: 100%; height: 300px; overflow: hidden;">
							<?php if ( is_active_sidebar( 'eight-degree-map' ) ) : ?>							
									 <?php dynamic_sidebar( 'eight-degree-map' ); ?>
							<?php endif; ?>
						</div>
						<div class="contact-details">
							<div class="contact-phone fadeInDown wow" data-wow-delay="2s" data-wow-duration="2s">		
								<i class="fa fa-call"></i>
								<?php echo esc_html($contact_phone);?>
							</div>
							<div class="contact-email fadeInDown wow" data-wow-delay="2.5s" data-wow-duration="2s">			
								<i class="fa fa-message"></i>
								<?php echo esc_attr($contact_email);?>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
<?php
	endif;
endif;
?>
<?php get_footer(); ?>