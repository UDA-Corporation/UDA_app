<?php 
$wp_customize->add_panel(
'eight_degree_homepage',array(
    'priority'      => 40,
    'capability'    =>  'edit_theme_options',
    'description'   =>  esc_html__( 'Homepage Section Settings','eight-degree' ),
    'theme_supports'=>  '',
    'title'         =>  esc_html__( 'Homepage Section','eight-degree' ),
    )
);


    //Slider on homepage
    $wp_customize->add_section(
        'eight_degree_homepage_slider',
        array(
            'priority'        => 0,
            'title' => esc_html__( 'Slider Section', 'eight-degree' ),
            'capability' => 'edit_theme_options',
            'description' => esc_html__( 'Setup the slider settings for header', 'eight-degree' ),
            'panel' => 'eight_degree_homepage'
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_slider_option',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_slider_option',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Enable Slider', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show slider on homepage.', 'eight-degree' ),
                    'section' => 'eight_degree_homepage_slider',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_slider_caption',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_slider_caption',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Slider Caption', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show titles and description over Slider', 'eight-degree' ),
                    'section' => 'eight_degree_homepage_slider',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_slider_pager',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_slider_pager',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Slider Pager', 'eight-degree' ),
                    'section' => 'eight_degree_homepage_slider',
                    )
                )
            );
        
        $wp_customize->add_setting(
            'eight_degree_homepage_slider_controls',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_slider_controls',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Slider Controls', 'eight-degree' ),
                    'section' => 'eight_degree_homepage_slider',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_slider_transition_auto',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_slider_transition_auto',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Auto Transition', 'eight-degree' ),
                    'section' => 'eight_degree_homepage_slider',
                    )
                )
            );

        //transition type
        $wp_customize->add_setting(
            'eight_degree_homepage_slider_transition_type', 
            array(
                'default' => 'horizontal',
                'capability' => 'edit_theme_options',
                'sanitize_callback' => 'eight_degree_radio_sanitize_transition'
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_slider_transition_type', 
            array(
                'type' => 'select',
                'label' => esc_html__( 'Transition Type(Slide/Fade)', 'eight-degree' ),
                'section' => 'eight_degree_homepage_slider',
                'choices' => array(
                    'fade' => esc_html__( 'Fade', 'eight-degree' ),
                    'horizontal' => esc_html__( 'Slide Horizontal', 'eight-degree' ),
                    'vertical' => esc_html__( 'Slide Vertical', 'eight-degree' ),
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_slider_transition_speed',
            array(
                'default'       =>      '3500',
                'sanitize_callback' => 'eight_degree_sanitize_integer'
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_slider_transition_speed',
            array(
                'type' => 'number',
                'label' => esc_html__( 'Transition Speed', 'eight-degree' ),
                'section' => 'eight_degree_homepage_slider',
                )
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_slider_transition_pause',
            array(
                'default'       =>      '3500',
                'sanitize_callback' => 'eight_degree_sanitize_integer'
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_slider_transition_pause',
            array(
                'type' => 'number',
                'label' => esc_html__( 'Transition Pause', 'eight-degree' ),
                'section' => 'eight_degree_homepage_slider',
                )
            );

    ///////////////////////////////////////////////////////////////////////////////////////////   
    // Featured section
    ///////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_featured',
        array(
            'title'         =>  esc_html__( 'Featured Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Featured Section. Go to Admin Dashboard -> Appearance  -> Customize -> Theme Setup -> Category Setup and Select category in Featured category to show posts in Featured Section.','eight-degree' ),
            'priority'      =>  10,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_featured_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_featured_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_featured',
                    'setting'       =>  'eight_degree_homepage_featured_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_featured_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_featured_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in Featured section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_featured',
                'setting' =>    'eight_degree_homepage_featured_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_featured_readmore',
            array(
                'default'           =>  esc_html__( 'Read More','eight-degree' ),
                'sanitize_callback' =>  'sanitize_text_field',
                'transport'         =>  'postMessage',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_featured_readmore',
            array(
                'priority'      =>  30,
                'label'         =>  esc_html__( 'Readmore Button','eight-degree' ),
                'section'       =>  'eight_degree_homepage_featured',
                'setting'       =>  'eight_degree_homepage_featured_readmore',
                'type'          =>  'text',  
                )                                     
            );

    ///////////////////////////////////////////////////////////////////////////////////////////   
    // Service section
    ///////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_service',
        array(
            'title'         =>  esc_html__( 'Service Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Service Section. Go to Admin Dashboard -> Appearance  -> Customize -> Theme Setup -> Category Setup and Select category in Service category to show posts in Service Section.','eight-degree' ),
            'priority'      =>  10,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_service_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_service_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_service',
                    'setting'       =>  'eight_degree_homepage_service_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_service_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_service_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in service section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_service',
                'setting' =>    'eight_degree_homepage_service_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_service_readmore',
            array(
                'default'           =>  esc_html__( 'Readmore','eight-degree' ),
                'sanitize_callback' =>  'sanitize_text_field',
                'transport'         =>  'postMessage',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_service_readmore',
            array(
                'priority'      =>  30,
                'label'         =>  esc_html__( 'Readmore Button','eight-degree' ),
                'section'       =>  'eight_degree_homepage_service',
                'setting'       =>  'eight_degree_homepage_service_readmore',
                'type'          =>  'text',  
                )                                     
            );


    //Add skill section and their controls

    $wp_customize->add_section(
        'eight_degree_homepage_skill',
        array(
            'title'         =>  esc_html__( 'Skill Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Skill Section. Go to Admin Dashboard -> Appearance -> Widgets -> Skill Section -> add progress bar widgets.','eight-degree' ),
            'priority'      =>  20,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_skill_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
        	new Eight_Degree_Switch_Control(
	        	$wp_customize,
                'eight_degree_homepage_skill_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_skill',
                    'setting'       =>  'eight_degree_homepage_skill_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_skill_ceo_title',
            array(
                'default'           =>  esc_html__('Word from CEO','eight-degree'),
                'sanitize_callback' =>  'sanitize_text_field',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_skill_ceo_title',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Message Title','eight-degree' ),
                'description' => esc_html__( 'Enter text to show title of CEO Message in skill section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_skill',
                'setting' =>    'eight_degree_homepage_skill_ceo_title',
                'type'    =>    'text',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_skill_ceo_msg',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_skill_ceo_msg',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Message from CEO','eight-degree' ),
                'description' => esc_html__( 'Choose page to display title, message and image of member or CEO in skill section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_skill',
                'setting' =>    'eight_degree_homepage_skill_ceo_msg',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_skill_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_skill_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display skill title in skill section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_skill',
                'setting' =>    'eight_degree_homepage_skill_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );


        
    //////////////////////////////////////////////////////////////////////////////////////////////
    //Add Counter section and their controls
    /////////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_counter',
        array(
            'title'         =>  esc_html__( 'Counter Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Counter Section. Go to Admin Dashboard -> Appearance -> Widgets -> Counter Section -> add counter widgets.','eight-degree' ),
            'priority'      =>  30,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_counter_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
        	new Eight_Degree_Switch_Control(
	        	$wp_customize,
                'eight_degree_homepage_counter_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_counter',
                    'setting'       =>  'eight_degree_homepage_counter_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_counter_background1',
             array(
                'default' => '',
                'capability' => 'edit_theme_options',
                'sanitize_callback' => 'esc_url_raw',
                )
            );

        $wp_customize->add_control(
            new WP_Customize_Image_Control(
                $wp_customize,
                'eight_degree_homepage_counter_background1', 
                array(
                    'label' => esc_html__( 'Upload Background', 'eight-degree' ),
                    'description'   => esc_html__( 'Upload background image to show in counter section.','eight-degree' ),
                    'section' => 'eight_degree_homepage_counter',
                    'setting' => 'eight_degree_homepage_counter_background1'
                    )
                )
            );
        
    //Add Team section and their controls

    $wp_customize->add_section(
        'eight_degree_homepage_team',
        array(
            'title'         =>  esc_html__( 'Team Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Team Section. Go to Theme Setup -> Category Setup and Select category in Team category to show posts in Team Section.','eight-degree' ),
            'priority'      =>  40,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_team_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_team_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_team',
                    'setting'       =>  'eight_degree_homepage_team_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_team_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_team_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in team section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_team',
                'setting' =>    'eight_degree_homepage_team_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_team_post',
            array(
                'default'           =>  3,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_team_post',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'No. of post','eight-degree' ),
                'description' => esc_html__( ' Enter no. of posts to display in team section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_team',
                'setting' =>    'eight_degree_homepage_team_post',
                'type'    =>    'number',
                )                                     
            );
        
    //////////////////////////////////////////////////////////////////////////////////////////////
    //Add Portfolio section and their controls
    /////////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_portfolio',
        array(
            'title'         =>  esc_html__( 'Portfolio Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Portfolio Section. Go to Theme Setup -> Category Setup and Select category in Portfolio category to show posts in Portfolio Section.','eight-degree' ),
            'priority'      =>  50,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_portfolio_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
        	new Eight_Degree_Switch_Control(
	        	$wp_customize,
                'eight_degree_homepage_portfolio_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_portfolio',
                    'setting'       =>  'eight_degree_homepage_portfolio_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_portfolio_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_portfolio_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in portfolio section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_portfolio',
                'setting' =>    'eight_degree_homepage_portfolio_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_portfolio_post',
            array(
                'default'           =>  8,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_portfolio_post',
            array(
                'priority'=>    60,
                'label'   =>    esc_html__( 'No. of Post','eight-degree' ),
                'section' =>    'eight_degree_homepage_portfolio',
                'setting' =>    'eight_degree_homepage_portfolio_post',
                'type'    =>    'number',         
                )                                     
            );


        
    //////////////////////////////////////////////////////////////////////////////////////////////
    //Add Blog section and their controls
    /////////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_blog',
        array(
            'title'         =>  esc_html__( 'Blog Section','eight-degree' ),
            'description'   =>  esc_html__( 'Settings of the Blog Section. Go to Theme Setup -> Category Setup and Select category in Blog category to show posts in Blog Section.','eight-degree' ),
            'priority'      =>  60,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_blog_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
        	new Eight_Degree_Switch_Control(
	        	$wp_customize,
                'eight_degree_homepage_blog_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_blog',
                    'setting'       =>  'eight_degree_homepage_blog_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_blog_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_blog_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in blog section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_blog',
                'setting' =>    'eight_degree_homepage_blog_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_blog_post',
            array(
                'default'           =>  3,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_blog_post',
            array(
                'priority'=>    60,
                'label'   =>    esc_html__( 'No. of Post','eight-degree' ),
                'section' =>    'eight_degree_homepage_blog',
                'setting' =>    'eight_degree_homepage_blog_post',
                'type'    =>    'number',         
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_blog_readmore',
            array(
                'default'           =>  esc_html__( 'Read More','eight-degree' ),
                'sanitize_callback' =>  'sanitize_text_field',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_blog_readmore',
            array(
                'priority'=>    80,
                'label'   =>    esc_html__( 'Readmore Button','eight-degree' ),
                'section' =>    'eight_degree_homepage_blog',
                'setting' =>    'eight_degree_homepage_blog_readmore',
                'type'    =>    'text',         
                )                                     
            );

        
    //////////////////////////////////////////////////////////////////////////////////////////////
    //Add CTA section and their controls
    /////////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_cta',
        array(
            'title'         =>  esc_html__( 'Call To Action Section','eight-degree' ),
            'priority'      =>  70,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_cta_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
        	new Eight_Degree_Switch_Control(
	        	$wp_customize,
                'eight_degree_homepage_cta_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_cta',
                    'setting'       =>  'eight_degree_homepage_cta_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_cta_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_cta_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in cta section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_cta',
                'setting' =>    'eight_degree_homepage_cta_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_cta_readmore',
            array(
                'default'           =>  esc_html__( 'Download Now','eight-degree' ),
                'sanitize_callback' =>  'sanitize_text_field',
                'transport'         =>  'postMessage',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_cta_readmore',
            array(
                'priority'=>    80,
                'label'   =>    esc_html__( 'Readmore Button','eight-degree' ),
                'section' =>    'eight_degree_homepage_cta',
                'setting' =>    'eight_degree_homepage_cta_readmore',
                'type'    =>    'text',         
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_cta_readmore_link',
            array(
                'default'           =>  '#',
                'sanitize_callback' =>  'sanitize_text_field',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_cta_readmore_link',
            array(
                'priority'=>    80,
                'label'   =>    esc_html__( 'Readmore Button Link','eight-degree' ),
                'section' =>    'eight_degree_homepage_cta',
                'setting' =>    'eight_degree_homepage_cta_readmore_link',
                'type'    =>    'text',         
                )                                     
            );
        
    //////////////////////////////////////////////////////////////////////////////////////////////
    //Add Testimonial section and their controls
    /////////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_testimonial',
        array(
            'title'         =>  esc_html__( 'Testimonial Section','eight-degree' ),
            'description'   =>  esc_html__( 'Setup Testimonial Section. Go to Theme Setup -> Category Setup and Select category in Testimonial category to show posts in Testimonial Section.','eight-degree' ),
            'priority'      =>  80,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_testimonial_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
        	new Eight_Degree_Switch_Control(
	        	$wp_customize,
                'eight_degree_homepage_testimonial_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_testimonial',
                    'setting'       =>  'eight_degree_homepage_testimonial_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_testimonial_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_testimonial_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in testimonial section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_testimonial',
                'setting' =>    'eight_degree_homepage_testimonial_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );
        
    //////////////////////////////////////////////////////////////////////////////////////////////
    //Add Contact form section and their controls
    /////////////////////////////////////////////////////////////////////////////////////////////

    $wp_customize->add_section(
        'eight_degree_homepage_contact',
        array(
            'title'         =>  esc_html__( 'Contact Section','eight-degree' ),
            'description'   =>  esc_html__( 'Setup Contact Section. Go to Theme Setup -> Google Map and Insert the google map option.','eight-degree' ),
            'priority'      =>  80,
            'panel'         =>  'eight_degree_homepage'        
            )
        );

        $wp_customize->add_setting(
            'eight_degree_homepage_contact_option',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_switch',
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_homepage_contact_option',
                array(
                    'label'   =>  esc_html__( 'Enable Section','eight-degree' ),
                    'section'       =>  'eight_degree_homepage_contact',
                    'setting'       =>  'eight_degree_homepage_contact_option',
                    'priority'      =>  10,
                    'type'          =>  'switch',
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_contact_page',
            array(
                'default'           =>  0,
                'sanitize_callback' =>  'eight_degree_sanitize_integer',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_contact_page',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Select Page','eight-degree' ),
                'description' => esc_html__( 'Choose page to display section title and description in contact section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_contact',
                'setting' =>    'eight_degree_homepage_contact_page',
                'type'    =>    'dropdown-pages',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_contact_shortcode',
            array(
                'default'           =>  '',
                'sanitize_callback' =>  'wp_kses_post',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_contact_shortcode',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Enter Shortcode','eight-degree' ),
                'description' => esc_html__( 'Enter Contact Form plugin shortcode to show contact form in contact section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_contact',
                'setting' =>    'eight_degree_homepage_contact_shortcode',
                'type'    =>    'text',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_contact_phone',
            array(
                'default'           =>  '+977-01-4671980',
                'sanitize_callback' =>  'sanitize_text_field',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_contact_phone',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Enter Phone','eight-degree' ),
                'description' => esc_html__( 'Enter Phone no. to show in contact section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_contact',
                'setting' =>    'eight_degree_homepage_contact_phone',
                'type'    =>    'text',
                )                                     
            );

        $wp_customize->add_setting(
            'eight_degree_homepage_contact_email',
            array(
                'default'           =>  'info@8degreethemes.com',
                'sanitize_callback' =>  'sanitize_email',
                )
            );

        $wp_customize->add_control(
            'eight_degree_homepage_contact_email',
            array(
                'priority'=>    25,
                'label'   =>    esc_html__( 'Enter Email','eight-degree' ),
                'description' => esc_html__( 'Enter Email adress. to show in contact section.','eight-degree' ),
                'section' =>    'eight_degree_homepage_contact',
                'setting' =>    'eight_degree_homepage_contact_email',
                'type'    =>    'text',
                )                                     
            );