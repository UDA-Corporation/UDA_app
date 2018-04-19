<?php

$wp_customize->add_panel(
	'eight_degree_theme',
	array(
		'priority' => '10',
		'capability' => 'edit_theme_options',
		'theme_supports' => '',
		'title' => esc_html__( 'Theme Setup', 'eight-degree' ),
		'description' => esc_html__( 'Setup theme setting of the site.', 'eight-degree' ),
		)
	);

	// Category Setup
	$wp_customize->add_section(
		'eight_degree_theme_category',
		array(
			'priority'        => 10,
			'title' => esc_html__( 'Category Setup', 'eight-degree' ),
			'capability' => 'edit_theme_options',
			'description' => esc_html__( 'Select a category to define as respective Category. The post of the selected category will be shown their respective Section & Page.', 'eight-degree' ),
			'panel' => 'eight_degree_theme'
			)
		);
	
		//select category for featured
		$wp_customize->add_setting(
			'eight_degree_theme_category_featured',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_featured', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Featured Category', 'eight-degree' ),				
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 10
				)
			);

		//select category for slider
		$wp_customize->add_setting(
			'eight_degree_theme_category_slider',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_slider', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Slider Category', 'eight-degree' ),
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 0
				)
			);
		//select category for portfolio
		$wp_customize->add_setting(
			'eight_degree_theme_category_portfolio',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_portfolio', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Portfolio Category', 'eight-degree' ),
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 50
				)
			);
	
		//select category for blog
		$wp_customize->add_setting(
			'eight_degree_theme_category_blog',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_blog', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Blog Category', 'eight-degree' ),				
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 40
				)
			);
	
		//select category for services
		$wp_customize->add_setting(
			'eight_degree_theme_category_service',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_service', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Service Category', 'eight-degree' ),
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 30
				)
			);
	
		//select category for team
		$wp_customize->add_setting(
			'eight_degree_theme_category_team',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_team', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Team Category', 'eight-degree' ),
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 60
				)
			);
	
		//select category for testimonial
		$wp_customize->add_setting(
			'eight_degree_theme_category_testimonial',
			array(
				'default' => 0,
				'capability' => 'edit_theme_options',
				'sanitize_callback' => 'eight_degree_sanitize_integer'
				)
			);

		$wp_customize->add_control( 
			'eight_degree_theme_category_testimonial', 
			array(
				'tipo'	=>	'select',
				'label'	=> 	__( 'Testimonial Category', 'eight-degree' ),
				'section' => 'eight_degree_theme_category',
				'choices' => eight_degree_category_lists(),
				'priority'	=> 70
				)
			);

	//social Settings section
   	$wp_customize->add_section(
	   	'eight_degree_theme_social', 
	   	array(
	       	'priority' 	=>	20,
	       	'panel'		=>	'eight_degree_theme',
			'capability' => 'edit_theme_options',
	       	'title' => esc_html__( 'Social Link Setup', 'eight-degree' ),
	       	'description' => esc_html__( 'Add your link of the Social Networks.', 'eight-degree' ),
			)
		);	
	   
	   //social facebook link
	   	$wp_customize->add_setting(
		   	'eight_degree_social_facebook', 
		   	array(
				'default' => '#',
		        'sanitize_callback' => 'esc_url_raw',
				)
		   	);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_facebook',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Facebook', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_facebook'
		    	)
	    	);
	    
	    //social twitter link
	   	$wp_customize->add_setting(
	   		'eight_degree_social_twitter', 
	   		array(
				'default' => '#',
		        'sanitize_callback' => 'esc_url_raw',
				)
	   		);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_twitter',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Twitter', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_twitter'
	    		)
	    	);
	    
	    //social googleplus link
	   	$wp_customize->add_setting(
		   	'eight_degree_social_googleplus', 
		   	array(
				'default' => '#',
		        'sanitize_callback' => 'esc_url_raw',
				)
		   	);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_googleplus',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Google Plus', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_googleplus'
		    	)
	    	);
	    
	     //social youtube link
	   	$wp_customize->add_setting(
	   		'eight_degree_social_youtube', 
	   		array(
				'default' => '#',
		        'sanitize_callback' => 'esc_url_raw',
				)
	   		);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_youtube',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'YouTube', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_youtube'
		    	)
	    	);
	    
	     //social pinterest link
	   	$wp_customize->add_setting(
		   	'eight_degree_social_pinterest', 
		   	array(
				'default' => '',
		        'sanitize_callback' => 'esc_url_raw',
				)
		   	);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_pinterest',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Pinterest', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_pinterest'
		    	)
	    	);
	    
	    //social linkedin link
	   	$wp_customize->add_setting(
	   		'eight_degree_social_linkedin', 
	   		array(
				'default' => '',
		        'sanitize_callback' => 'esc_url_raw',
				)
	   		);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_linkedin',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Linkedin', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_linkedin'
	    		)
	    	);
	    
	    
	    //social vimeo link
	   	$wp_customize->add_setting(
	   		'eight_degree_social_vimeo', 
	   		array(
				'default' => '',
		        'sanitize_callback' => 'esc_url_raw',
				)
	   		);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_vimeo',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Vimeo', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_vimeo'
	    		)
	    	);
	    
	    //social instagram link
	   	$wp_customize->add_setting(
	   		'eight_degree_social_instagram', 
	   		array(
				'default' => '',
		        'sanitize_callback' => 'esc_url_raw',
				)
	   		);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_instagram',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Instagram', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_instagram'
		    	)
	    	);

	    //social skype link
	   	$wp_customize->add_setting(
	   		'eight_degree_social_skype', 
	   		array(
				'default' => '',
		        'sanitize_callback' => 'sanitize_text_field',
				)
	   		);
	    
	    $wp_customize->add_control(
	    	'eight_degree_social_skype',
	    	array(
		        'tipo' => 'text',
		        'label' => esc_html__( 'Skype', 'eight-degree' ),
		        'section' => 'eight_degree_theme_social',
		        'setting' => 'eight_degree_social_skype'
		    	)
	    	);

	//WebLayout section
   	$wp_customize->add_section(
	   	'eight_degree_theme_weblayout', 
	   	array(
	       	'priority' 	=>	20,
	       	'panel'		=>	'eight_degree_theme',
			'capability' => 'edit_theme_options',
	       	'title' => esc_html__( 'Weblayout', 'eight-degree' ),
			)
		);	

	   	$wp_customize->add_setting(
		   	'eight_degree_theme_weblayout_option', 
		   	array(
				'default' => 'ed-fullwidth',
		        'sanitize_callback' => 'eight_degree_sanitize_weblayout',
				)
		   	);
	    
	    $wp_customize->add_control(
	    	'eight_degree_theme_weblayout_option',
	    	array(
		        'tipo' => 'radio',
		        'label' => esc_html__( ' Choose WebLayout', 'eight-degree' ),
		        'description' => esc_html__( 'Choose the Web Layout of your site.', 'eight-degree' ),
		        'section' => 'eight_degree_theme_weblayout',
		        'setting' => 'eight_degree_theme_weblayout_option',
		        'choices' => array(
		        	'ed-fullwidth' => esc_html__('Fullwidth Layout', 'eight-degree'),
		        	'ed-boxed' => esc_html__('Boxed Layout', 'eight-degree'),
		        	)
		    	)
	    	);