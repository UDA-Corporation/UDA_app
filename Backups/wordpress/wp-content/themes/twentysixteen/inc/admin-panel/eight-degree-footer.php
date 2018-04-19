<?php 

	$wp_customize->add_section( 
		'eight_degree_footer',
		array(
			'title'			=>	esc_html__( 'Footer Setting','eight-degree' ),
			'priority'		=>	80,
			)
		);

	    //Footer Logo 
	    $wp_customize->add_setting(
	    	'eight_degree_footer_logo',
	    	 array(
		      	'default' => '',
		      	'capability' => 'edit_theme_options',
		      	'sanitize_callback' => 'esc_url_raw',
			   	)
		   	);

	   	$wp_customize->add_control(
	   		new WP_Customize_Image_Control(
	   			$wp_customize,
			   	'eight_degree_footer_logo', 
			   	array(
			      	'label' => esc_html__( 'Upload logo', 'eight-degree' ),
			      	'description'	=> esc_html__(' Upload logo image to show before the copyright text on footer.','eight-degree' ),
			      	'section' => 'eight_degree_footer',
			      	'setting' => 'eight_degree_footer_logo'
			      	)
			   	)
		   	);

	    $wp_customize->add_setting(
	    	'eight_degree_footer_copyright',
	    	 array(
		      	'default' => '',
		      	'capability' => 'edit_theme_options',
		      	'sanitize_callback' => 'wp_kses_post',
			   	)
		   	);

	   	$wp_customize->add_control(
		   	'eight_degree_footer_copyright', 
		   	array(
		      	'tipo' => 'textarea',
		      	'label' => esc_html__( 'Copyright Text', 'eight-degree' ),
		      	'description'	=> esc_html__(' Enter the copyright text to show on the footer.','eight-degree' ),
		      	'section' => 'eight_degree_footer',
		      	'setting' => 'eight_degree_footer_copyright'
			   	)
		   	);

	    //Footer Logo 
	    $wp_customize->add_setting(
	    	'eight_degree_footer_menu',
	    	 array(
		      	'default' => 0,
		      	'capability' => 'edit_theme_options',
		      	'sanitize_callback' => 'sanitize_text_field',
			   	)
		   	);

	   	$wp_customize->add_control(
	   		new Eight_Degree_Menu_Dropdown(
	   			$wp_customize,
			   	'eight_degree_footer_menu', 
			   	array(
			      	'label' => esc_html__( 'Footer Menu', 'eight-degree' ),
			      	'description'	=> esc_html__(' Select menu to show on footer.', 'eight-degree' ),
			      	'section' => 'eight_degree_footer',
			      	'setting' => 'eight_degree_footer_menu'
			      	)
			   	)
		   	);

	    //social setting in footer
	    $wp_customize->add_setting(
	    	'eight_degree_footer_social_option',
	    	 array(
		      	'default' => 0,
		      	'capability' => 'edit_theme_options',
		      	'sanitize_callback' => 'eight_degree_sanitize_integer',
			   	)
		   	);

	   	$wp_customize->add_control(
	   		new Eight_Degree_Switch_Control(
	   			$wp_customize,
			   	'eight_degree_footer_social_option', 
			   	array(
			      	'tipo' => 'switch',
			      	'label' => esc_html__( 'Show Social Icons', 'eight-degree' ),
			      	'description'	=> esc_html__(' To add social links, go to Theme Setup -> Social Link Setup and add the links to shown on social links sections.','eight-degree' ),
			      	'section' => 'eight_degree_footer',
			      	'setting' => 'eight_degree_footer_social_option',		
			      	)		      	
			   	)
		   	);