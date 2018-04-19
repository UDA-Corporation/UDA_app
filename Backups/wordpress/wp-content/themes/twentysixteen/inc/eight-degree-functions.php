<?php 


if ( ! function_exists( 'eight_degree_pageheader_cb' ) ) :
    function eight_degree_pageheader_cb(){
        $image = '';
        if( has_post_thumbnail() && !is_archive() ){
            $img_src = wp_get_attachment_image_src( get_post_thumbnail_id(), 'full' );
            $image = $img_src[0];
        }
        else{
            $image = get_theme_mod('eight_degree_pageheader_image','');
        }
        $color = get_theme_mod('eight_degree_pageheader_color','');
        ?>
        <header class="page-header" style="background-image: url('<?php echo esc_url($image);?>');">
            <div class="ed-container">        
                <?php 
                do_action('eight_degree_breadcrumb');
                if(is_archive()):

                    the_archive_title('<h2 class="page-title">','</h2>');

                else:
                    the_title( '<h2 class="page-title">', '</h2>' ); 
                endif;
                ?>
            </div>
        </header><!-- .page-header -->
    <?php
    }
endif;
add_action('eight_degree_pageheader','eight_degree_pageheader_cb');

function eight_degree_category_lists(){
	$category 	=	get_categories();
	$cat_list 	=	array();
	$cat_list[0]=	esc_html__('Select Category','eight-degree');
	foreach ($category as $cat) {
		$cat_list[$cat->term_id]	=	$cat->name;
	}
	return $cat_list;
}

// count footer
function eight_degree_footer_count(){
	$count = 0;
	if(is_active_sidebar('eight-degree-footer-one')){
		$count++;
	}

	if(is_active_sidebar('eight-degree-footer-two')){
		$count++;
	}

	if(is_active_sidebar('eight-degree-footer-three')){
		$count++;
	}

	if(is_active_sidebar('eight-degree-footer-four')){
		$count++;
	}

	return $count;
}

add_action('eight_degree_homepage_slider_config','eight_degree_homepage_slider_config_cb',9);
//homepage slider configuration settings
function eight_degree_homepage_slider_config_cb(){    
        $show_pager = esc_attr((get_theme_mod('eight_degree_homepage_slider_pager',0) == "1") ? "true" : "false");
        $show_controls = esc_attr((get_theme_mod('eight_degree_homepage_slider_controls',0) == "1") ? "true" : "false");
        $auto_transition = esc_attr((get_theme_mod('eight_degree_homepage_slider_transition_auto',0) == "1") ? "true" : "false");
        $slider_transition = esc_attr(get_theme_mod( 'eight_degree_homepage_slider_transition_tipo','horizontal' ) );
        $slider_speed = get_theme_mod('eight_degree_homepage_slider_transition_speed', '3500');
        $slider_pause = get_theme_mod('eight_degree_homepage_slider_transition_pause', '3500');
    
    // Send data to client
    wp_localize_script('eight-degree-custom-js', 'eightDegreeSliderData', array(
        'autop' => $auto_transition,
        'speed' => absint( $slider_speed ),
        'controls' => $show_controls,
        'pager' => $show_pager,
        'trans' => $slider_transition,
        'pause' => absint( $slider_pause )
    ));
}

// Function for using Slider
	function eight_degree_slider_section_cb(){
		$slider_option = get_theme_mod('eight_degree_homepage_slider_option',0);
		$slider_category = get_theme_mod('eight_degree_theme_category_slider',0);
		$show_caption = esc_attr( get_theme_mod( 'eight_degree_homepage_slider_caption',0 ) );   
		if($slider_option):
?>			<div id="slider" class="slider-section">
				<?php
				$query = new WP_Query(array(
					'cat' => absint( $slider_category ),
					'posts_per_page' => -1    
					));?>
				<div id="ed-slider">
					<?php
					if($query->have_posts()) : 
						while($query->have_posts()) : 
							$query-> the_post();
							if(has_post_thumbnail()):
								$image = wp_get_attachment_image_src( get_post_thumbnail_id( get_the_ID() ), 'eight-degree-slider', false );
								?>
								<div class="slides">
									<img src="<?php echo esc_url($image[0]);?>" alt = "<?php the_title_attribute();?>" >
									<?php if($show_caption == '1'){?>
									<div class="caption-wrapper">
										<div class="slider-caption">
											<div class="slider-title fadeInDown wow" data-depth="1.00"> <?php the_title(); ?></div>
											<div class = "slider-content fadeInRight wow"  data-depth="1.5"><?php the_excerpt();?></div>
											
										</div>
									</div>
									<?php  }?>
								</div>
						<?php 
							endif;
						endwhile;
						wp_reset_postdata();
					endif;?>	

				</div>  		
			</div>
		<?php
		endif;
}
add_action('eight_degree_slider','eight_degree_slider_section_cb', 10); //slider settings without condition

/**
 * Related posts
 */
  add_action( 'eight_degree_related_posts', 'eight_degree_related_posts_hook' );
  if( !function_exists( 'eight_degree_related_posts_hook' ) ):
    function eight_degree_related_posts_hook() {
      wp_reset_postdata();
      global $post;
      if( empty( $post ) ) {
        $post_id = '';
      } else {
        $post_id = $post->ID;
      }
        $posts_tipo = get_theme_mod( 'eight_degree_related_tipo', 'cat' );
        $post_num = get_theme_mod( 'eight_degree_related_post_num', 3 );

        // Define related post arguments
    $related_args = array(
        'no_found_rows'            => true,
        'update_post_meta_cache'   => false,
        'update_post_term_cache'   => false,
        'ignore_sticky_posts'      => 1,
        'orderby'                  => 'rand',
        'post__not_in'             => array( $post_id ),
        'posts_per_page'           => absint( $post_num )
        );


      if ( $posts_tipo == 'tag' ) {
        $tags = wp_get_post_tags( $post_id );
        if ( $tags ) {
          $tag_ids = array();
          foreach( $tags as $individual_tag ) $tag_ids[] = $individual_tag->term_id;
          $related_args['tag__in'] = $tag_ids;
        }
      } else {
        $categories = get_the_category( $post_id );
        if ( $categories ) {
          $category_ids = array();
          foreach( $categories as $individual_category ) {
            $category_ids[] = $individual_category->term_id;
          }
          $related_args['category__in'] = $category_ids;
        }
      }

      $related_query = new WP_Query( $related_args );
      if( $related_query->have_posts() ) :
        $eight_degree_related_post_title = get_theme_mod( 'eight_degree_related_title', esc_html__( 'Related Articles', 'eight-degree' ) );
        ?>
        <div class="eight-degree-related-wrapper">
            <h4 class="related-title"><?php echo esc_html( $eight_degree_related_post_title ); ?></h4>
            <div class="related-posts-wrapper">
                <?php
                while( $related_query->have_posts() ) :
                  $related_query->the_post();
                  ?>
                  <div class="related-single">
                    <h4 class="related-post-title"><a href="<?php the_permalink(); ?>"><?php the_title(); ?></a></h4>
                    <span class = "related-date"><?php the_time( get_option( 'date_format' ) );?></span>
                    <div class = "related-post-content"><?php the_excerpt();?></div>                    
                    <a class = "related-readmore ed-bttn"><?php esc_html_e('Read More','eight-degree');?></a>
                  </div><!--. related-single -->
                  <?php
                endwhile;
                ?>
            </div>
        </div><!-- .eight-degree-related-wrapper -->
        <?php
      endif;
      wp_reset_postdata();
    }
    endif;

add_action( 'eight_degree_author_detail', 'eight_degree_author_detail_cb' );
if( !function_exists( 'eight_degree_author_detail_cb' ) ):
function eight_degree_author_detail_cb() {
  wp_reset_postdata();
  global $post;
  if( empty( $post ) ) {
    $post_id = '';
  } else {
    $post_id = $post->ID;
  }
    $title = get_theme_mod( 'eight_degree_author_title', esc_html__( 'About Author', 'eight-degree' ) );
    $data = get_user_meta($post->post_author, false);
    $image = get_avatar($post->post_author,150);
        ?>
        <div class="eight-degree-author-wrapper clear">
            <figure>
                <?php echo wp_kses_post($image);?>
            </figure>
            <div class="author-wrapper">                
                <h5 class="author-title"><?php echo esc_html( $title ); ?></h5>
                <h4 class="author-name"><?php the_author(); ?></h4>
                <div class="author-detail"><?php echo esc_html($data['description'][0]) ; ?></div>
            </div>
        </div><!-- .eight-degree-author-wrapper -->
    <?php
}
endif;


function eight_degree_social_setting_cb(){
    $facebooklink = get_theme_mod('eight_degree_social_facebook','#');
    $twitterlink = get_theme_mod('eight_degree_social_twitter','#');
    $google_pluslink = get_theme_mod('eight_degree_social_googleplus','#');
    $youtubelink = get_theme_mod('eight_degree_social_youtube','#');
    $pinterestlink = get_theme_mod('eight_degree_social_pinterest');
    $linkedinlink = get_theme_mod('eight_degree_social_linkedin');
    $flickrlink = get_theme_mod('eight_degree_social_flicker');
    $vimeolink = get_theme_mod('eight_degree_social_vimeo');
    $stumbleuponlink = get_theme_mod('eight_degree_social_stumbleupon');
    $instagramlink = get_theme_mod('eight_degree_social_instagram');
    $soundcloudlink = get_theme_mod('eight_degree_social_soundcloud');
    $githublink = get_theme_mod('eight_degree_social_github');
    $tumblrlink = get_theme_mod('eight_degree_social_tumbler');
    $skypelink = get_theme_mod('eight_degree_social_skype');
    $rsslink = get_theme_mod('eight_degree_social_rss'); 
    ?>
    <div class="social-icons ">
        <?php if(!empty($facebooklink)){ ?>
        <a href="<?php echo esc_url($facebooklink); ?>" class="facebook" data-title="<?php esc_attr_e('Facebook','eight-degree')?>" target="_blank"><i class="fa fa-facebook"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($twitterlink)){ ?>
        <a href="<?php echo esc_url($twitterlink); ?>" class="twitter" data-title="<?php esc_attr_e('Twitter','eight-degree')?>" target="_blank"><i class="fa fa-twitter"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($google_pluslink)){ ?>
        <a href="<?php echo esc_url($google_pluslink); ?>" class="gplus" data-title="<?php esc_attr_e('Google Plus','eight-degree')?>" target="_blank"><i class="fa fa-google-plus"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($youtubelink)){ ?>
        <a href="<?php echo esc_url($youtubelink); ?>" class="youtube" data-title="<?php esc_attr_e('Youtube','eight-degree')?>" target="_blank"><i class="fa fa-youtube"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($pinterestlink)){ ?>
        <a href="<?php echo esc_url($pinterestlink); ?>" class="pinterest" data-title="<?php esc_attr_e('Facebook','eight-degree')?>Pinterest" target="_blank"><i class="fa fa-pinterest"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($linkedinlink)){ ?>
        <a href="<?php echo esc_url($linkedinlink); ?>" class="linkedin" data-title="<?php esc_attr_e('Linkedin','eight-degree')?>" target="_blank"><i class="fa fa-linkedin"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($flickrlink)){ ?>
        <a href="<?php echo esc_url($flickrlink); ?>" class="flickr" data-title="<?php esc_attr_e('Flickr','eight-degree')?>" target="_blank"><i class="fa fa-flickr"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($vimeolink)){ ?>
        <a href="<?php echo esc_url($vimeolink); ?>" class="vimeo" data-title="<?php esc_attr_e('Vimeo','eight-degree')?>" target="_blank"><i class="fa fa-vimeo-square"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($instagramlink)){ ?>
        <a href="<?php echo esc_url($instagramlink); ?>" class="instagram" data-title="<?php esc_attr_e('Instagram','eight-degree')?>" target="_blank"><i class="fa fa-instagram"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($tumblrlink)){ ?>
        <a href="<?php echo esc_url($tumblrlink); ?>" class="tumblr" data-title="<?php esc_attr_e('Tumblr','eight-degree')?>" target="_blank"><i class="fa fa-tumblr"></i><span></span></a>
        <?php } ?>
        
        <?php if(!empty($soundcloudlink)){ ?>
        <a href="<?php echo esc_url($soundcloudlink); ?>" class="delicious" data-title="<?php esc_attr_e('Delicious','eight-degree')?>" target="_blank"><i class="fa fa-delicious"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($rsslink)){ ?>
        <a href="<?php echo esc_url($rsslink); ?>" class="rss" data-title="<?php esc_attr_e('Rss','eight-degree')?>" target="_blank"><i class="fa fa-rss"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($githublink)){ ?>
        <a href="<?php echo esc_url($githublink); ?>" class="github" data-title="<?php esc_attr_e('Github','eight-degree')?>" target="_blank"><i class="fa fa-github"></i><span></span></a>
        <?php } ?>

        <?php if(!empty($stumbleuponlink)){ ?>
        <a href="<?php echo esc_url($stumbleuponlink); ?>" class="stumbleupon" data-title="<?php esc_attr_e('Stumbleupon','eight-degree')?>" target="_blank"><i class="fa fa-stumbleupon"></i><span></span></a>
        <?php } ?>
        
        <?php if(!empty($skypelink)){ ?>
        <a href="<?php echo esc_attr__('Skype:', 'eight-degree') . esc_attr($skypelink); ?>" class="skype" data-title="<?php esc_attr_e('Skype','eight-degree')?>"><i class="fa fa-skype"></i><span></span></a>
        <?php } ?>
    </div>
<?php
}
add_action('eight_degree_social','eight_degree_social_setting_cb', 10);


if( !function_exists('eight_degree_post_header')):
	function eight_degree_post_header(){?>
		<div class="post-date">
			<a href="<?php the_permalink();?>"><?php the_time( get_option( 'date_format' ) );?></a>	  
		</div>
		<div class="post-category">
		<?php
		if ( 'post' === get_post_tipo() ) {
            $categories_list = get_the_category_list( esc_html__( ', ', 'eight-degree' ) );
            if ( $categories_list && eight_degree_categorized_blog() ) {
                printf( '<span class="cat-links">' . esc_html__( '%1$s ', 'eight-degree' ) . '</span>', $categories_list ); // WPCS: XSS OK.
            }

		}?>
		</div>
		<?php
	}

endif;


if( !function_exists('eight_degree_post_footer')):
	function eight_degree_post_footer(){
		if ( ! is_single() && ! post_password_required() && ( comments_open() || get_comments_number() ) ) {
			echo '<span class="comments-link">';
			/* translators: %s: post title */
			comments_popup_link( sprintf( wp_kses( __( 'Leave a Comment<span class="screen-reader-text"> on %s</span>', 'eight-degree' ), array( 'span' => array( 'class' => array() ) ) ), get_the_title() ) );
			echo '</span>';
		}
	}

endif;

function eight_degree_breadcrumb_cb() { 
        global $post;
        $showOnHome = 0; // 1 - show breadcrumbs on the homepage, 0 - don't show

        $delimiter = '&#47;'; // delimiter between crumbs

        $home = esc_html__('HOME', 'eight-degree'); // text for the 'Home' link

        $showCurrent = 1; // 1 - show current post/page title in breadcrumbs, 0 - don't show
        $before = '<span class="current">'; // tag before the current crumb
        $after = '</span>'; // tag after the current crumb

        $homeLink = esc_url( home_url( '/' ) );

        if (is_home() || is_front_page()) {
            if ($showOnHome == 1)
                echo '<div id="eight-degree-breadcrumbs"><a href="' . esc_url( $homeLink ) . '">' . esc_html( $home ) . '</a></div>';
        } else {
            echo '<div id="eight-degree-breadcrumbs"><a href="' . esc_url( $homeLink ) . '">' . esc_html( $home ) . '</a> ' . wp_kses_post( $delimiter ) . ' ';

            if (is_category()) {
                $thisCat = get_category(get_query_var('cat'), false);
                if ($thisCat->parent != 0)
                    echo wp_kses_post( get_category_parents( $thisCat->parent, TRUE, ' ' . wp_kses_post( $delimiter ) . ' ' ) );
                else {
                    echo $before . esc_html( single_cat_title('', false ) ) . $after;
                }
            } elseif (is_search()) {
                echo $before . esc_html__( 'Search results for','eight-degree' ) . '"' . esc_html( get_search_query() ) . '"' . $after;
            } elseif (is_day()) {
                echo '<a href="' . esc_url( get_year_link( get_the_time( 'Y' ) ) ) . '">' . esc_html( get_the_time( 'Y' ) ) . '</a> ' . wp_kses_post( $delimiter ) . ' ';
                echo '<a href="' . esc_url( get_month_link( get_the_time( 'Y' ) ) , esc_attr( get_the_time( 'm' ) ) ) . '">' . esc_html( get_the_time( 'F' ) ) . '</a> ' . wp_kses_post( $delimiter ) . ' ';
                echo $before . esc_html( get_the_time( 'd' ) ) . $after;
            } elseif ( is_month() ) {
                echo '<a href="' . esc_url( get_year_link( get_the_time( 'Y' ) ) ) . '">' . esc_html( get_the_time( 'Y' ) ) . '</a> ' . wp_kses_post( $delimiter ) . ' ';
                echo $before . esc_html( get_the_time( 'F' ) ) . $after;
            } elseif ( is_year() ) {
                echo $before . esc_html( get_the_time( 'Y' ) ) . $after;
            } elseif ( is_single() && !is_attachment() ) {
                if ( get_post_tipo() != 'post' ) {
                    $post_tipo = get_post_tipo_object( get_post_tipo() );
                    $slug = $post_tipo->rewrite;
                    echo '<a href="' . esc_url( $homeLink . $slug['slug'] ) . '/">' . esc_html( $post_tipo->labels->singular_name ) . '</a>';
                    if ( $showCurrent == 1 )
                        echo ' ' . wp_kses_post( $delimiter ) . ' ' . $before . esc_html( get_the_title() ) . $after;
                } else {
                    $cat = get_the_category();
                    $cat = $cat[0];
                    $cats = wp_kses_post( get_category_parents( $cat, TRUE, ' ' . wp_kses_post( $delimiter ) . ' ' ) );
                    if ($showCurrent == 0)
                        $cats = preg_replace("#^(.+)\s$delimiter\s$#", "$1", $cats);
                    echo $cats;
                    if ($showCurrent == 1)
                        echo $before . esc_html( get_the_title() ) . $after;
                }
            } elseif (!is_single() && !is_page() && get_post_tipo() != 'post' && !is_404()) {
                $post_tipo = get_post_tipo_object( get_post_tipo() );
                echo $before . esc_html( $post_tipo->labels->singular_name ) . $after;
            } elseif ( is_attachment() ) {
                $parent = get_post( $post->post_parent );
                $cat = get_the_category( $parent->ID );
                $cat = $cat[0];
                echo wp_kses_post( get_category_parents( $cat, TRUE, ' ' . wp_kses_post( $delimiter ) . ' ' ) );
                echo '<a href="' . esc_url( get_permalink( $parent ) ) . '">' . esc_html( $parent->post_title ) . '</a>';
                if ($showCurrent == 1)
                    echo ' ' . wp_kses_post( $delimiter ) . ' ' . $before . esc_html( get_the_title() ) . $after;
            } elseif (is_page() && !$post->post_parent) {
                if ($showCurrent == 1)
                    echo $before . esc_html( get_the_title() ) . $after;
            } elseif (is_page() && $post->post_parent) {
                $parent_id = $post->post_parent;
                $breadcrumbs = array();
                while ($parent_id) {
                    $page = get_page($parent_id);
                    $breadcrumbs[] = '<a href="' . esc_url( get_permalink( $page->ID ) ) . '">' . esc_html( get_the_title( $page->ID ) ) . '</a>';
                    $parent_id = $page->post_parent;
                }
                $breadcrumbs = array_reverse($breadcrumbs);
                for ($i = 0; $i < count( $breadcrumbs ); $i++) {
                    echo wp_kses_post( $breadcrumbs[$i] );
                    if ($i != count($breadcrumbs) - 1)
                        echo ' ' . wp_kses_post( $delimiter ) . ' ';
                }
                if ($showCurrent == 1)
                    echo ' ' . wp_kses_post( $delimiter ) . ' ' . $before . esc_html( get_the_title() ) . $after;
                
            } elseif ( is_tag() ) {
                echo $before . esc_html__( 'Posts tagged', 'eight-degree') . '"' . esc_html( single_tag_title( '', false ) ) . '"' . $after;
            } elseif (is_author()) {
                global $author;
                $userdata = get_userdata($author);
                echo $before . esc_html__( 'Articles posted by ', 'eight-degree' ) . esc_html( $userdata->display_name ) . $after;
            } elseif (is_404()) {
                echo $before . esc_html__( 'Error 404', 'eight-degree' ) . $after;
            }

            if ( get_query_var( 'paged' ) ) {
                if ( is_category() || is_day() || is_month() || is_year() || is_search() || is_tag() || is_author() )
                    echo ' (';
                esc_html_e(' Page', 'eight-degree') . ' ' . esc_html( get_query_var( 'paged' ) );
                if ( is_category() || is_day() || is_month() || is_year() || is_search() || is_tag() || is_author() )
                    echo ')';
            }

            echo '</div>';
        }
    }

    add_action('eight_degree_breadcrumb', 'eight_degree_breadcrumb_cb');
    
// Themes required Plugins Install Section
if ( ! function_exists( 'eight_degree_register_required_plugins' ) ) :
    function eight_degree_register_required_plugins() {

        $plugins = array(
            array(
                'name' => 'Ultimate Form Builder Lite',
                'slug' => 'ultimate-form-builder-lite',
                'required' => false,
                ),
            );

        $config = array(
        'id' => 'tgmpa', // Unique ID for hashing notices for multiple instances of TGMPA.
        'default_path' => '', // Default absolute path to pre-packaged plugins.
        'menu' => 'tgmpa-install-plugins', // Menu slug.
        'parent_slug' => 'themes.php', // Parent menu slug.
        'capability' => 'edit_theme_options', // Capability needed to view plugin install page, should be a capability associated with the parent menu used.
        'has_notices' => true, // Show admin notices or not.
        'dismissable' => true, // If false, a user cannot dismiss the nag message.
        'dismiss_msg' => '', // If 'dismissable' is false, this message will be output at top of nag.
        'is_automatic' => true, // Automatically activate plugins after installation or not.
        'message' => '', // Message to output right before the plugins table.
        'strings' => array(
            'page_title' => __('Install Required Plugins', 'eight-degree'),
            'menu_title' => __('Install Plugins', 'eight-degree'),
            'installing' => __('Installing Plugin: %s', 'eight-degree'), // %s = plugin name.
            'oops' => __('Something went wrong with the plugin API.', 'eight-degree'),
            'notice_can_install_required' => _n_noop(
                'This theme requires the following plugin: %1$s.', 'This theme requires the following plugins: %1$s.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_can_install_recommended' => _n_noop(
                'This theme recommends the following plugin: %1$s.', 'This theme recommends the following plugins: %1$s.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_cannot_install' => _n_noop(
                'Sorry, but you do not have the correct permissions to install the %1$s plugin.', 'Sorry, but you do not have the correct permissions to install the %1$s plugins.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_ask_to_update' => _n_noop(
                'The following plugin needs to be updated to its latest version to ensure maximum compatibility with this theme: %1$s.', 'The following plugins need to be updated to their latest version to ensure maximum compatibility with this theme: %1$s.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_ask_to_update_maybe' => _n_noop(
                'There is an update available for: %1$s.', 'There are updates available for the following plugins: %1$s.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_cannot_update' => _n_noop(
                'Sorry, but you do not have the correct permissions to update the %1$s plugin.', 'Sorry, but you do not have the correct permissions to update the %1$s plugins.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_can_activate_required' => _n_noop(
                'The following required plugin is currently inactive: %1$s.', 'The following required plugins are currently inactive: %1$s.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_can_activate_recommended' => _n_noop(
                'The following recommended plugin is currently inactive: %1$s.', 'The following recommended plugins are currently inactive: %1$s.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'notice_cannot_activate' => _n_noop(
                'Sorry, but you do not have the correct permissions to activate the %1$s plugin.', 'Sorry, but you do not have the correct permissions to activate the %1$s plugins.', 'eight-degree'
            ), // %1$s = plugin name(s).
            'install_link' => _n_noop(
                'Begin installing plugin', 'Begin installing plugins', 'eight-degree'
                ),
            'update_link' => _n_noop(
                'Begin updating plugin', 'Begin updating plugins', 'eight-degree'
                ),
            'activate_link' => _n_noop(
                'Begin activating plugin', 'Begin activating plugins', 'eight-degree'
                ),
            'return' => __('Return to Required Plugins Installer', 'eight-degree'),
            'plugin_activated' => __('Plugin activated successfully.', 'eight-degree'),
            'activated_successfully' => __('The following plugin was activated successfully:', 'eight-degree'),
            'plugin_already_active' => __('No action taken. Plugin %1$s was already active.', 'eight-degree'), // %1$s = plugin name(s).
            'plugin_needs_higher_version' => __('Plugin not activated. A higher version of %s is needed for this theme. Please update the plugin.', 'eight-degree'), // %1$s = plugin name(s).
            'complete' => __('All plugins installed and activated successfully. %1$s', 'eight-degree'), // %s = dashboard link.
            'contact_admin' => __('Please contact the administrator of this site for help.', 'eight-degree'),
            'nag_tipo' => 'updated', // Determines admin notice tipo - can only be 'updated', 'update-nag' or 'error'.
            )
);
tgmpa($plugins, $config);
}
add_action('tgmpa_register', 'eight_degree_register_required_plugins');
endif;