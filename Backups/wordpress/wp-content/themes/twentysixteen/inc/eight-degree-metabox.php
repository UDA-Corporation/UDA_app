<?php
    add_action('add_meta_boxes', 'eight_degree_add_sidebar_layout_box');
    function eight_degree_add_sidebar_layout_box(){
        
        add_meta_box(
                     'eight_degree_sidebar_layout', // $id
                     'Sidebar Layout', // $title
                     'eight_degree_sidebar_layout_callback', // $callback
                     'page', // $page
                     'normal', // $context
                     'high'); // $priority
        add_meta_box(
                     'eight_degree_sidebar_layout', // $id
                     'Sidebar Layout', // $title
                     'eight_degree_sidebar_layout_callback', // $callback
                     'post', // $page
                     'normal', // $context
                     'high'); // $priority

    }

    $eight_degree_sidebar_layout = array(
        'left-sidebar' => array(
                        'value'     => 'left-sidebar',
                        'label'     => esc_html__( 'Left sidebar', 'eight-degree' ),
                        'thumbnail' => get_template_directory_uri() . '/images/left-sidebar.png'
                ), 
        'right-sidebar' => array(
                        'value' => 'right-sidebar',
                        'label' => esc_html__( 'Right sidebar', 'eight-degree' ),
                        'thumbnail' => get_template_directory_uri() . '/images/right-sidebar.png'
                    ),
        'both-sidebar' => array(
                        'value'     => 'both-sidebar',
                        'label'     => esc_html__( 'Both Sidebar', 'eight-degree' ),
                        'thumbnail' => get_template_directory_uri() . '/images/both-sidebar.png'
                    ),
       
        'no-sidebar' => array(
                        'value'     => 'no-sidebar',
                        'label'     => esc_html__( 'No sidebar', 'eight-degree' ),
                        'thumbnail' => get_template_directory_uri() . '/images/no-sidebar.png'
                    )   

        );
    

    function eight_degree_sidebar_layout_callback(){ 
        global $post , $eight_degree_sidebar_layout;
        wp_nonce_field( basename( __FILE__ ), 'eight_degree_sidebar_layout_nonce' ); 
        ?>

        <table class="form-table">
        <tr>
        <td colspan="4"><em class="f13">Choose Sidebar Template</em></td>
        </tr>

        <tr>
        <td>
        <?php  
            foreach ($eight_degree_sidebar_layout as $field) {  
            $eight_degree_sidebar_metalayout = get_post_meta( $post->ID, 'eight_degree_sidebar_layout', true ); ?>
                <div class="radio-image-wrapper" style="float:left; margin-right:30px;">
                <label class="description">
                <span><img src="<?php echo esc_url( $field['thumbnail'] ); ?>" alt="" /></span></br>
                <input type="radio" name="eight_degree_sidebar_layout" value="<?php echo esc_attr($field['value']); ?>" <?php checked( $field['value'], $eight_degree_sidebar_metalayout ); if(empty($eight_degree_sidebar_metalayout) && $field['value']=='right-sidebar'){ echo "checked='checked'";} ?>/>&nbsp;<?php echo esc_attr($field['label']); ?>
                </label>
                </div>
            <?php } // end foreach 
            ?>
            <div class="clear"></div>
        </td>
        </tr>
        </table>

    <?php } 

    /**
     * save the custom metabox data
     * @hooked to save_post hook
     */
    function eight_degree_save_sidebar_layout( $post_id ){ 
        global $eight_degree_sidebar_layout, $post; 

        // Verify the nonce before proceeding.
        if ( wp_unslash(!isset( $_POST[ 'eight_degree_sidebar_layout_nonce' ] )) || !wp_verify_nonce( wp_unslash($_POST[ 'eight_degree_sidebar_layout_nonce' ]), basename( __FILE__ ) ) )
            return;

        // Stop WP from clearing custom fields on autosave
        if ( defined( 'DOING_AUTOSAVE' ) && DOING_AUTOSAVE)  
            return;
            
        if ('page' == $_POST['post_type']) {  
            if (!current_user_can( 'edit_page', $post_id ) )  
                return $post_id;  
        } elseif (!current_user_can( 'edit_post', $post_id ) ) {  
                return $post_id;  
        }  
        

        foreach ($eight_degree_sidebar_layout as $field) {  
            //Execute this saving function
            $old = get_post_meta( $post_id, 'eight_degree_sidebar_layout', true); 
            $new = sanitize_text_field(wp_unslash($_POST['eight_degree_sidebar_layout']));
            if ($new && $new != $old) {  
                update_post_meta($post_id, 'eight_degree_sidebar_layout', $new);  
            } elseif ('' == $new && $old) {  
                delete_post_meta($post_id,'eight_degree_sidebar_layout', $old);  
            } 
         } // end foreach   
         
    }
    add_action('save_post', 'eight_degree_save_sidebar_layout');