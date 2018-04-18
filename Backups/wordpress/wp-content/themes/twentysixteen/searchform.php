<?php
/**
  *
 * @package eight-degree
 */
$ed_search_placeholder  = get_theme_mod( 'eight_sec_header_search_placeholder',esc_html__( 'Search...','eight-degree' ) );
?>
<div class="search-icon">
    <i class="fa fa-search"></i>
    <i class="fa fa-close"></i>
    <div class="ed-search">
       <form action="<?php echo esc_url( home_url( '/' ) ); ?>" class="search-form" method="get" role="search">
          <label>
              <span class="screen-reader-text"><?php esc_html_e( 'Search for:','eight-degree' )?></span>
              <input type="search" title="<?php esc_attr_e( 'Search for:', 'eight-degree' )?>" name="s" value="<?php the_search_query(); ?>" placeholder="<?php echo esc_attr( $ed_search_placeholder ); ?>" class="search-field" />
          </label>
        <button type="submit" class="search-submit"><i class="fa fa-search"></i></button>
       </form> 
    </div>
</div>