<?php
/**
 * Template Name: Testimonial
 * The template for testimonial page
 *
 * @package eight-degree
 */
   
get_header();
global $post; 
do_action('eight_degree_pageheader');
?>

<div class="ed-container">
    <?php 
    $testimonial = get_theme_mod( 'eight_degree_theme_category_testimonial',0 );
    $sidebar = get_post_meta( $post->ID, 'eight_degree_sidebar_layout', true );
    if( empty( $sidebar ) ){
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

                        <div class="testimonial-page grid">       
                               <?php 
                                if(($testimonial != '') && ($testimonial != 0)):    
                                    $paged = ( get_query_var( 'paged' ) ) ? get_query_var( 'paged' ) : 1;                        
                                    $args = array( 'cat' => $testimonial, 'post_status' => 'publish', 'paged' => $paged );
                                    $query = new WP_Query($args);   
                                    while ($query->have_posts()) : 
                                        $query->the_post();
                                        get_template_part( 'template-parts/content', 'testimonial' );
                                    endwhile;
                                    ?>
                                    <?php if ($query->max_num_pages > 1) { // check if the max number of pages is greater than 1  ?>
                                          <nav class="prev-next-posts">
                                            <div class="prev-posts-link">
                                              <?php echo wp_kses_post( get_next_posts_link( esc_html__( 'Older Posts', 'eight-degree' ), $query->max_num_pages ) ); // display older posts link ?>
                                            </div>
                                            <div class="next-posts-link">
                                              <?php echo wp_kses_post( get_previous_posts_link( esc_html__( 'Newer Posts', 'eight-degree' ) ) ); // display newer posts link ?>
                                            </div>
                                          </nav>
                                        <?php } ?>
                                    <?php 
                                    wp_reset_postdata();
                                endif;
                                ?>
                        </div>      
        
                    </main><!-- #main -->
                </div><!-- #primary -->

    <?php 
    if( $sidebar=='left-sidebar' || $sidebar=='both-sidebar' ){
        get_sidebar('left');
    }
    if( $sidebar=='both-sidebar' ){
        ?>
        </div>
        <?php
    }
    if( $sidebar=='right-sidebar' || $sidebar=='both-sidebar' ){
     get_sidebar( 'right' );
    }
    ?>
</div>
<?php
get_footer();