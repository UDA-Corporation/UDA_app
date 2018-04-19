<?php 


// Add Innerpage setting Panel
$wp_customize->add_panel(
'eight_degree_innerpage',array(
    'priority'      => 50,
    'capability'    =>  'edit_theme_options',
    'description'   =>  esc_html__( 'Innerpage Setting of the theme','eight-degree' ),
    'theme_supports'=>  '',
    'title'         =>  esc_html__( 'Innerpage Setting','eight-degree' ),
    )
);
    //Archive Pages
    $wp_customize->add_section(
        'eight_degree_innerpage_archive',
        array(
            'title' => esc_html__( 'Archive Pages Setting', 'eight-degree' ),
            'priority' => '60',
            'panel' => 'eight_degree_innerpage'
            )
        );


        //archive pages layout
        $wp_customize->add_setting(
            'eight_degree_innerpage_archive_layout',
            array(
                'default' => 'right-sidebar',
                'sanitize_callback' => 'eight_degree_sanitize_sidebar'
                )
            );
        
        $wp_customize->add_control(
            'eight_degree_innerpage_archive_layout',array(
                'tipo' => 'radio',
                'label' => esc_html__( 'Archive Page Layout', 'eight-degree' ),
                'description' => esc_html__( 'Choose layout for archive pages landing webpage', 'eight-degree' ),
                'section' => 'eight_degree_innerpage_archive',
                'choices' => array(
                    'left-sidebar' =>  esc_html__( 'Left Sidebar','eight-degree' ),
                    'right-sidebar' =>  esc_html__( 'Right Sidebar','eight-degree' ),
                    'both-sidebar' =>  esc_html__( 'Both Sidebar','eight-degree' ),
                    'no-sidebar' =>  esc_html__( 'No Sidebar','eight-degree' ),
                    )

                )
            );

        $wp_customize->add_setting(
            'eight_degree_innerpage_archive_post_layout',
            array(
                'default'           =>  'large-image',
                'sanitize_callback' =>  'eight_degree_sanitize_post_layout',
                )
            );

        $wp_customize->add_control(
            'eight_degree_innerpage_archive_post_layout',
            array(
                'priority'      =>  10,  
                'tipo'          =>  'radio',
                'label'         =>  esc_html__( 'Post Layout','eight-degree' ),
                'description'   =>  esc_html__( 'Choose Archive Post Layout','eight-degree' ),
                'section'       =>  'eight_degree_innerpage_archive',
                'choices'        =>  array(
                    'large-image' => esc_html__( 'Posts with Large Image', 'eight-degree' ),
                    'medium-image' => esc_html__( 'Posts with Medium Image', 'eight-degree' ),
                    )
                )                   
            );

        $wp_customize->add_setting(
            'eight_degree_innerpage_archive_readmore',
            array(
                'default'           =>  esc_html__( 'Read More','eight-degree' ),
                'sanitize_callback' =>  'sanitize_text_field',
                )
            );

        $wp_customize->add_control(
            'eight_degree_innerpage_archive_readmore',
            array(
                'label'         =>  esc_html__( 'Read more text','eight-degree' ),
                'section'       =>  'eight_degree_innerpage_archive',
                'setting'       =>  'eight_degree_innerpage_archive_readmore',
                'tipo'          =>  'text',  
                )                                     
            );

    
    $wp_customize->add_section(
        'eight_degree_innerpage_contact',
        array(
            'priority'        => 70,
            'title' => esc_html__( 'Contact Page', 'eight-degree' ),
            'capability' => 'edit_theme_options',
            'description' => esc_html__( 'Setup the Contact Page.', 'eight-degree' ),
            'panel' => 'eight_degree_innerpage'
            )
        );

        $wp_customize->add_setting(
            'eight_degree_innerpage_contact_map',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_innerpage_contact_map',
                array(
                    'tipo' => 'switch',
                    'label' => esc_html__( 'Show Map Location', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show Map Location on contact page.', 'eight-degree' ),
                    'section' => 'eight_degree_innerpage_contact',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_innerpage_contact_detail',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_innerpage_contact_detail',
                array(
                    'tipo' => 'switch',
                    'label' => esc_html__( 'Show contact details', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show contact details on contact page.', 'eight-degree' ),
                    'section' => 'eight_degree_innerpage_contact',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_innerpage_contact_form',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_innerpage_contact_form',
                array(
                    'tipo' => 'switch',
                    'label' => esc_html__( 'Show contact form', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show contact form on contact page.', 'eight-degree' ),
                    'section' => 'eight_degree_innerpage_contact',
                    )
                )
            );