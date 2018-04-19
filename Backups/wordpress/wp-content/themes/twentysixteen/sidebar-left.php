<?php
/**
 * The Sidebar containing the main widget areas.
 *
 * @package eight-degree
 */
if ( ! is_active_sidebar( 'eight-degree-left-sidebar' ) ) {
	return;
}

    ?>
    <div id="secondary-left" class="widget-area left-sidebar sidebar">
        <?php if ( is_active_sidebar( 'eight-degree-left-sidebar' ) ) : ?>
			<?php dynamic_sidebar( 'eight-degree-left-sidebar' ); ?>
		<?php endif; ?>
    </div>
    <?php    

?>
