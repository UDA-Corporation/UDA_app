<?php
/**
 * Template Name: Portfolio
 * The template for portfolio page
 *
 * @package eight-degree
 */
   
get_header(); 
global $post; 
do_action('eight_degree_pageheader');?>
<div class="ed-container">
    <?php 
    $sidebar = get_post_meta( $post->ID, 'eight_degree_sidebar_layout', true );
    $portfolio = get_theme_mod('eight_degree_theme_category_portfolio',0);
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
                    <div class="portfolio-page sort-table ">
                        <?php if(($portfolio != '') && ($portfolio != 0)):?>
                            <header class="sort-table"> 
                                <?php

                                $all_cat = get_categories(array('type' => 'post','parent' => $portfolio));
                                if (!empty($all_cat) && !is_wp_error($all_cat)):
                                    echo "<ul class='button-group filters-button-group'>";
                                    if (!empty($all_cat)) {
                                        echo '<li class="button is-checked" data-filter="*">' . esc_html__('All', 'eight-degree') . '</li>';
                                    }
                                    foreach ($all_cat as $category) :
                                        $cat_detail = get_term($category,'category');
                                        echo '<li class="button" data-filter=.' . esc_attr($cat_detail->slug) . '>' . esc_html($cat_detail->name) . '</li>';
                                    endforeach;
                                    echo "</ul>";
                                endif;
                                wp_reset_postdata();
                                ?>
                            </header>
                            <div class="portfolio-post-wrap">                  
                            <?php
                                $query = new WP_Query( array( 'cat' => $portfolio, 'post_status' => 'publish' ) );
                                while ( $query->have_posts() ) : 
                                    $query->the_post();
                                    $term_lists = wp_get_post_terms( get_the_ID(), 'category', array( "fields" => "all" ) );
                                    $term_slugs = array();
                                    foreach( $term_lists as $term_list ) {
                                        $term_slugs[] = $term_list->slug;
                                    }
                                    $term_slugs = join( ' ', $term_slugs );
                                    if( has_post_thumbnail() ) : 
                                            $image = wp_get_attachment_image_src( get_post_thumbnail_id(), 'eight-degree-square' );
                                        ?>
                                            <div class="portfolio-post <?php echo esc_attr($term_slugs);?>">  
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
                                                                    the_title( '<h4 class="portfolio-post-title"><a href="' . esc_url( get_permalink() ) . '" rel="bookmark">', '</a></h4>' );
                                                                    the_excerpt(); ?>
                                                            </div>
                                                        </div>
                                                    </div>
                                            </div> 
                                        <?php
                                    endif; 
                                endwhile;
                                wp_reset_postdata();
                                ?>
                            </div>
                        <?php endif;?>
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

