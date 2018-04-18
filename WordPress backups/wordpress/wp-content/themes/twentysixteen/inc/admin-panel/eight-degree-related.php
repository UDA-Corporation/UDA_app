<?php 
$wp_customize->add_panel(
    'eight_degree_single',
    array(
        'priority'        => 90,
        'title' => esc_html__( 'Single Post', 'eight-degree' ),
        'capability' => 'edit_theme_options',
        'description' => esc_html__( 'Setup the settings for Single Post Page.', 'eight-degree' ),
        )
    );
    //Related on homepage
    $wp_customize->add_section(
        'eight_degree_author',
        array(
            'priority'        => 90,
            'title' => esc_html__( 'Author Setting', 'eight-degree' ),
            'capability' => 'edit_theme_options',
            'description' => esc_html__( 'Setup Author setting to show in single post page.', 'eight-degree' ),
            'panel'		=> 'eight_degree_single',
            )
        );

        $wp_customize->add_setting(
            'eight_degree_author_option',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_author_option',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Enable Author', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show Author of the posts on Single Post Page.(Note: Authors of posts are shown in single page of the blog post only.)', 'eight-degree' ),
                    'section' => 'eight_degree_author',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_author_title',
            array(
                'default' => esc_html__( 'About Author', 'eight-degree' ),
                'sanitize_callback' => 'sanitize_text_field'
                )
            );

        $wp_customize->add_control(
            'eight_degree_author_title',
            array(
                'type' => 'text',
                'label' => esc_html__( 'Author Title', 'eight-degree' ),
                'description' => esc_html__( 'Enter text to show the title of Author section in single page.', 'eight-degree' ),
                'section' => 'eight_degree_author',
                )
            );

    //Related on homepage
    $wp_customize->add_section(
        'eight_degree_related',
        array(
            'priority'        => 90,
            'title' => esc_html__( 'Related Post Setting', 'eight-degree' ),
            'capability' => 'edit_theme_options',
            'description' => esc_html__( 'Setup the settings for Related post.(Note: Related Posts are show in single page of the blog post only.)', 'eight-degree' ),
            'panel'		=> 'eight_degree_single',
            )
        );

        $wp_customize->add_setting(
            'eight_degree_related_option',
            array(
                'default' => 0,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            new Eight_Degree_Switch_Control(
                $wp_customize,
                'eight_degree_related_option',
                array(
                    'type' => 'switch',
                    'label' => esc_html__( 'Enable Related', 'eight-degree' ),
                    'description' => esc_html__( 'Select Yes to show Related posts on Single Post Page.', 'eight-degree' ),
                    'section' => 'eight_degree_related',
                    )
                )
            );

        $wp_customize->add_setting(
            'eight_degree_related_title',
            array(
                'default' => esc_html__( 'Related Articles', 'eight-degree' ),
                'sanitize_callback' => 'sanitize_text_field'
                )
            );

        $wp_customize->add_control(
            'eight_degree_related_title',
            array(
                'type' => 'text',
                'label' => esc_html__( 'Related Post Title', 'eight-degree' ),
                'description' => esc_html__( 'Enter title to show the title of related post.', 'eight-degree' ),
                'section' => 'eight_degree_related',
                )
            );

        $wp_customize->add_setting(
            'eight_degree_related_type',
            array(
                'default' => 'cat',
                'sanitize_callback' => 'eight_degree_sanitize_related'
                )
            );

        $wp_customize->add_control(
            'eight_degree_related_type',
            array(
                'type' => 'radio',
                'label' => esc_html__( 'Related Post Type', 'eight-degree' ),
                'description' => esc_html__( 'Select the taxonomy type to the post in related post section.', 'eight-degree' ),
                'section' => 'eight_degree_related',
                'choices'	=> array(
                		'cat' => esc_html__('Category','eight-degree'),
                		'tag' => esc_html__('Tag','eight-degree'),                		
                	)
                )
            );

        $wp_customize->add_setting(
            'eight_degree_related_post_num',
            array(
                'default' => 3,
                'sanitize_callback' => 'eight_degree_sanitize_switch'
                )
            );

        $wp_customize->add_control(
            'eight_degree_related_post_num',
            array(
                'type' => 'number',
                'label' => esc_html__( 'Related Post Number', 'eight-degree' ),
                'description' => esc_html__( 'Enter number to show total number of related post.', 'eight-degree' ),
                'section' => 'eight_degree_related',
                )
            );