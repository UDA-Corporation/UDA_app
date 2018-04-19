<?php 

	$wp_customize->add_panel( 
		'eight_degree_header',
		array(
			'title'			=>	esc_html__( 'Header Setting','eight-degree' ),
			'priority'		=>	20,
			)
		);

		$wp_customize->add_section( 
			'eight_degree_header_search',
			array(
				'title'			=>	esc_html__( 'Search Setting','eight-degree' ),
				'priority'		=>	20,
				'panel'			=> 'eight_degree_header'
				)
			);

			$wp_customize->add_setting(
				'eight_degree_header_search_option',
				array(
					'default' 	=>	0,
					'sanitize_callback'	=>	'eight_degree_sanitize_switch',
					)
				);

			$wp_customize->add_control(
				new Eight_Degree_Switch_Control(
					$wp_customize,
					'eight_degree_header_search_option',
					array(
						'tipo'			=>	'switch',
						'label'			=>	esc_html__( 'Show Search', 'eight-degree' ),
						'description'	=>	esc_html__( 'Select Yes to show search option in Header', 'eight-degree' ),
						'section'		=>	'eight_degree_header_search',
				      	'setting' => 'eight_degree_header_search_option',	
						)
					)
				);

			$wp_customize->add_setting(
				'eight_degree_header_search_placeholder',
				array(
					'default'			=>	esc_html__( 'Search...','eight-degree' ),
					'sanitize_callback'	=> 'sanitize_text_field',
					)
				);

			$wp_customize->add_control( 
				'eight_degree_header_search_placeholder',
				array(
					'title'			=>	esc_html__( 'Search Placeholder','eight-degree' ),
					'description'	=> 	esc_html__( 'Enter the text for Placeholder of Search field.', 'eight-degree' ),
					'section'			=> 'eight_degree_header_search'
					)
				);

		$wp_customize->add_section( 
			'eight_degree_header_social',
			array(
				'title'			=>	esc_html__( 'Social Option','eight-degree' ),
				'priority'		=>	10,
				'panel'			=> 'eight_degree_header'
				)
			);

		    //social setting in header
		    $wp_customize->add_setting(
		    	'eight_degree_header_social_option',
		    	 array(
			      	'default' => 0,
			      	'capability' => 'edit_theme_options',
			      	'sanitize_callback' => 'eight_degree_sanitize_integer',
				   	)
			   	);

		   	$wp_customize->add_control(
		   		new Eight_Degree_Switch_Control(
		   			$wp_customize,
				   	'eight_degree_header_social_option', 
				   	array(
				      	'tipo' => 'switch',
				      	'label' => esc_html__( 'Show Social Icons', 'eight-degree' ),
				      	'description'	=> esc_html__( 'Select Yes to show social icons in header. To add social links, go to Theme Setup -> Social Link Setup and add the links to shown on social links sections.','eight-degree' ),
				      	'section' => 'eight_degree_header_social',
				      	'setting' => 'eight_degree_header_social_option',		
				      	)		      	
				   	)
			   	);

		$wp_customize->add_section( 
			'eight_degree_header_logo',
			array(
				'title'			=>	esc_html__( 'Logo Option','eight-degree' ),
				'priority'		=>	0,
				'panel'			=> 'eight_degree_header'
				)
			);

		    //Header Logo Setting
		    $wp_customize->add_setting(
		    	'eight_degree_header_logo_align',
		    	 array(
			      	'default' => 'left',
			      	'capability' => 'edit_theme_options',
			      	'sanitize_callback' => 'eight_degree_sanitize_alignment',
				   	)
			   	);

		   	$wp_customize->add_control(
			   	'eight_degree_header_logo_align', 
			   	array(
			      	'tipo' => 'radio',
			      	'label' => esc_html__( 'Logo Alignment', 'eight-degree' ),
			      	'description'	=> esc_html__(' Choose the option to align the Logo on your header.','eight-degree' ),
			      	'section' => 'eight_degree_header_logo',
			      	'setting' => 'eight_degree_header_logo_align',
			      	'choices' => array(
			      		'left'	=>	esc_html__( 'Left', 'eight-degree' ),
			      		'center'	=>	esc_html__( 'Center', 'eight-degree' ),
			      		'right'	=>	esc_html__( 'Right', 'eight-degree' ),
			      		),
				   	)
			   	);