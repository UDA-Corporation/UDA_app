<?php
/**
 * The Sidebar containing the main widget areas.
 *
 * @package eight-degree
 */

if ( ! is_active_sidebar( 'eight-degree-right-sidebar' ) ) {
	return;
}

?>
    <div id="secondary-right" class="widget-area right-sidebar sidebar">
        <?php if ( is_active_sidebar( 'eight-degree-right-sidebar' ) ) :
        		dynamic_sidebar( 'eight-degree-right-sidebar' ); ?>
		<?php endif; ?>
    </div>
    <?php    
   
?>