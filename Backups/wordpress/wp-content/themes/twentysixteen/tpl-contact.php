<?php
/**
 * Template Name: Contact
 * The template for contact page
 *
 * @package eight-degree
 */
   
get_header(); 
global $post;
do_action('eight_degree_pageheader');?>
<div class="ed-container">
    <?php 
    $sidebar = get_post_meta( $post->ID, 'eight_degree_sidebar_layout', true );
    if(empty($sidebar)){
            $sidebar= 'right-sidebar';
        }
    if( $sidebar=='both-sidebar' ){
        ?>
        <div class="left-sidebar-right">
        <?php
    }
     ?>
            <div id="primary" class="content-area">
                <main id="main" class="site-main" role="main">
                    <div class="contact-page ">
                    <?php   
                        $contact_map = get_theme_mod( 'eight_degree_innerpage_contact_map', 0 );
                        $contact_detail = get_theme_mod( 'eight_degree_innerpage_contact_detail', 0 );
                        $contact_form = get_theme_mod( 'eight_degree_innerpage_contact_form', 0 );
                        $contact_shortcode = get_theme_mod( 'eight_degree_homepage_contact_shortcode', '' );
                        $contact_phone = get_theme_mod( 'eight_degree_homepage_contact_phone', '+977-01-4671980' );
                        $contact_email = get_theme_mod( 'eight_degree_homepage_contact_email', 'info@8degreethemes.com' );
                        if( ( $contact_map == 1 ) || ( $contact_detail == 1 ) || ( $contact_form ==1 ) ):
                        ?>
                            <div class="contact-wrap">  
                                <?php 
                                if( ( $contact_map == 1 ) || ( $contact_detail == 1 ) ):?>
                                    <div class="contact-map-details">
                                        <?php
                                        if( $contact_map == 1 ):?>
                                            <div id="contact-google-map" class="contact-map" style="width: 100%; height: 300px; overflow: hidden;">
                                                <?php if ( is_active_sidebar( 'eight-degree-map' ) ) : ?>
                                                         <?php dynamic_sidebar( 'eight-degree-map' ); ?>
                                                <?php endif; ?>                                                
                                            </div>
                                        <?php 
                                        endif;
                                        if( $contact_detail == 1 ):?>
                                        <div class="contact-details">
                                            <?php if(!empty($contact_phone)):?>
                                                <div class="contact-phone">                             
                                                    <i class="fa fa-call"></i>
                                                    <?php echo esc_html($contact_phone);?>
                                                </div>
                                            <?php endif;?>
                                            <?php if( !empty( $contact_email ) ):?>
                                            <div class="contact-email">                             
                                                <i class="fa fa-message"></i>
                                                <?php echo esc_attr($contact_email);?>
                                            </div>
                                            <?php endif;?>
                                        </div
                                        >
                                        <?php ?>
                                    </div>                
                                <?php
                                endif;
                                if( !empty($contact_shortcode) && $contact_form == 1 ):?>
                                    <div class="contact-form">
                                        <?php echo do_shortcode( wp_kses_post($contact_shortcode) );?>
                                    </div>
                                    <?php
                                endif;?>
                            </div>
<?php                   endif;
    endif;?>
                    </div>
                </main><!-- #main -->
            </div><!-- #primary -->

    <?php 
    if($sidebar=='left-sidebar' || $sidebar=='both-sidebar'){
        get_sidebar('left');
    }
    if($sidebar=='both-sidebar'){
        ?>
        </div>
        <?php
    }
    if($sidebar=='right-sidebar' || $sidebar=='both-sidebar'){
     get_sidebar('right');
    }
    ?>
</div>
<?php
get_footer();