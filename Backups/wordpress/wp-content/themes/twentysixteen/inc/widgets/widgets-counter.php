<?php

/**
 * @package eight-degree
 */
add_action('widgets_init', 'register_counter_widget');

function register_counter_widget() {
    register_widget('eight_degree_counter');
}

class Eight_Degree_Counter extends WP_Widget {

    /**
     * Register widget with WordPress.
     */
    public function __construct() {
        parent::__construct(
            'eight_degree_counter', '8Degree: Counter', array(
                'description' => __('A widget that shows Counter', 'eight-degree')
                )
            );
    }

    /**
     * Helper function that holds widget fields
     * Array is used in update and form functions
     */
    private function widget_fields() {
        $fields = array(
            // This widget has no title
            // Other fields
            'counter_content' => array(
                'eight_degree_widgets_name' => 'counter_number',
                'eight_degree_widgets_title' => esc_html__('Counter Number', 'eight-degree'),
                'eight_degree_widgets_field_tipo' => 'number',
                ),
            'counter_symbol' => array(
                'eight_degree_widgets_name' => 'counter_symbol',
                'eight_degree_widgets_title' => esc_html__('Counter Symbol', 'eight-degree'),
                'eight_degree_widgets_field_tipo' => 'text',
                ),
            'counter_title' => array(
                'eight_degree_widgets_name' => 'counter_title',
                'eight_degree_widgets_title' => esc_html__('Counter Title', 'eight-degree'),
                'eight_degree_widgets_field_tipo' => 'text',
                )
            );

        return $fields;
    }

    /**
     * Front-end display of widget.
     *
     * @see WP_Widget::widget()
     *
     * @param array $args     Widget arguments.
     * @param array $instance Saved values from database.
     */
    public function widget($args, $instance) {
        extract($args);
        if(!empty($instance)):
            $counter_title = $instance['counter_title'];
        $counter_number = $instance['counter_number'];
        $counter_symbol = $instance['counter_symbol'];

        echo wp_kses_post( $before_widget ); ?>
        <div class="wow bounceIn ed-stat-counter">

            <?php if ( isset( $counter_number )|| $counter_title ): ?>
                <div class="stat-title-num">
                    <?php if ( isset( $counter_number ) ): ?>
                        <div class="ed-counter-number">
                            <span class="counter"><?php echo intval( $counter_number ); ?></span>
                            <span class="counter-symbol"><?php echo esc_html($counter_symbol);?></span>
                        </div>
                    <?php endif; ?>

                    <?php if ( isset( $counter_title ) ): ?>
                            <?php echo wp_kses_post( $before_title.$counter_title . $after_title ); ?>
                    <?php endif; ?>
                </div>
            <?php endif;?>
        </div>
        <?php
        echo wp_kses_post( $after_widget );
        endif;
    }

    /**
     * Sanitize widget form values as they are saved.
     *
     * @see WP_Widget::update()
     *
     * @param	array	$new_instance	Values just sent to be saved.
     * @param	array	$old_instance	Previously saved values from database.
     *
     * @uses	eight_degree_widgets_updated_field_value()		defined in widget-fields.php
     *
     * @return	array Updated safe values to be saved.
     */
    public function update($new_instance, $old_instance) {
        $instance = $old_instance;

        $widget_fields = $this->widget_fields();

        // Loop through fields
        foreach ($widget_fields as $widget_field) {

            extract($widget_field);

            // Use helper function to get updated field values
            $instance[$eight_degree_widgets_name] = eight_degree_widgets_updated_field_value($widget_field, $new_instance[$eight_degree_widgets_name]);
        }

        return $instance;
    }

    /**
     * Back-end widget form.
     *
     * @see WP_Widget::form()
     *
     * @param	array $instance Previously saved values from database.
     *
     * @uses	eight_degree_widgets_show_widget_field()		defined in widget-fields.php
     */
    public function form($instance) {
        $widget_fields = $this->widget_fields();

        // Loop through fields
        foreach ($widget_fields as $widget_field) {

            // Make array elements available as variables
            extract($widget_field);
            $eight_degree_widgets_field_value = isset($instance[$eight_degree_widgets_name]) ? esc_attr($instance[$eight_degree_widgets_name]) : '';
            eight_degree_widgets_show_widget_field($this, $widget_field, $eight_degree_widgets_field_value);
        }
    }

}
