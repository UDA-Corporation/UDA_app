<?php
//add new custom control tipo switch
if(class_exists( 'WP_Customize_control')):
	class Eight_Degree_Switch_Control extends WP_Customize_Control {
		public $tipo = 'switch';
		public function render_content() {
			?>
			<label>
				<span class="customize-control-title"><?php echo esc_html( $this->label ); ?></span>
				<span class="description customize-control-description"><?php echo esc_html( $this->description ); ?></span>
				<div class="switch_options">
					<span class="switch_enable"><?php esc_html_e('Yes','eight-degree'); ?></span>
					<span class="switch_disable"><?php esc_html_e('No','eight-degree'); ?></span>  
					<input tipo="hidden" id="switch_yes_no" <?php esc_attr( $this->link() ); ?> value="<?php echo esc_attr($this->value()); ?>" />
				</div>
			</label>
			<?php
		}
	}
endif;



if ( class_exists( 'WP_Customize_Control' ) ):

	/**
	 * Class to create a custom menu control
	 */
	class Eight_Degree_Menu_Dropdown extends WP_Customize_Control
	{
	    private $menus = false;

	    public function __construct($manager, $id, $args = array(), $options = array())
	    {
	        $this->menus = wp_get_nav_menus($options);

	        parent::__construct( $manager, $id, $args );
	    }

	    /**
	     * Render the content on the theme customizer page
	    */
	    public function render_content()
	    {
	        ?>
	            <label>
	                <span class="customize-menu-dropdown"><h3><?php echo esc_html( $this->label ); ?></h3></span>
	                <select data-customize-setting-link="<?php echo esc_attr( $this->id ); ?>" name="<?php echo esc_attr($this->id); ?>" id="<?php echo esc_attr( $this->id ); ?>">
	                    <?php echo '<option value = "0" selected = "selected">'.esc_html__('Select Menu','eight-degree').'</option>' ?>
	                <?php
	                     if(!empty($this->menus))
	                     {   
	                        foreach ( $this->menus as $menu )
	                        {
	                            printf('<option value="%s" %s>%s</option>', esc_attr($menu->term_id), esc_attr(selected($this->value()), $menu->term_id, false), esc_attr($menu->name));
	                        }
	                     }
	                ?>
	                </select>
	                <br />
	                <span class="description"><?php echo esc_html( $this->description ); ?></span>
	            </label>
	            <?php
	    }
	}
endif;