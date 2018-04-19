<?php
    /**
     * SANITIZATION
     */
         
    function eight_degree_sanitize_textarea($input){
        return wp_kses_post( force_balance_tags( $input ) );
    }

    function eight_degree_sanitize_integer($input){
        return intval($input);
    }

    function eight_degree_sanitize_float($input){
        return floatval($input);
    }

    
    function eight_degree_sanitize_url($input){
        return esc_url_raw($input);
    }
    
    function eight_degree_sanitize_category_select($input){
        $eight_degree_category_lists = eight_degree_category_lists();
        if(array_key_exists($input,$eight_degree_category_lists)){
            return $input;
        }else{
            return '';
        }
    }

    function eight_degree_sanitize_related($input){
            $option = array(
                'cat' => esc_html__('Category','eight-degree'),
                'tag' => esc_html__('Tag','eight-degree'),
            );
            
            if(array_key_exists($input,$option)){
                return $input;
            }else{
                return '';
            }
        }

    function eight_degree_sanitize_alignment($input){
        $option = array(
                'left'  =>  esc_html__( 'Left', 'eight-degree' ),
                'center'    =>  esc_html__( 'Center', 'eight-degree' ),
                'right' =>  esc_html__( 'Right', 'eight-degree' ),
        );
        
        if(array_key_exists($input,$option)){
            return $input;
        }else{
            return '';
        }
    }

    function eight_degree_sanitize_weblayout($input){
            $option = array(
                    'ed-fullwidth' => esc_html__('Fullwidth Layout', 'eight-degree'),
                    'ed-boxed' => esc_html__('Boxed Layout', 'eight-degree'),
            );
            
            if(array_key_exists($input,$option)){
                return $input;
            }else{
                return '';
            }
        }

    function eight_degree_sanitize_sidebar($input){
        $option = array(
            'left-sidebar' =>  esc_html__('Left Sidebar','eight-degree'),
            'right-sidebar' =>  esc_html__('Right Sidebar','eight-degree'),
            'both-sidebar' =>  esc_html__('Both Sidebar','eight-degree'),
            'no-sidebar' =>  esc_html__('No Sidebar','eight-degree'),
        );
        
        if(array_key_exists($input,$option)){
            return $input;
        }else{
            return '';
        }
    }

    function eight_degree_sanitize_post_layout($input){
        $option = array(
            'large-image' => esc_html__('Posts with Large Image', 'eight-degree'),
            'medium-image' => esc_html__( 'Posts with Medium Image', 'eight-degree' ),
        );
        
        if(array_key_exists($input,$option)){
            return $input;
        }else{
            return '';
        }
    }

    function eight_degree_sanitize_switch($input){
        if($input == 1){
            return 1;
        }else{
            return 0;
        }
    }

    function eight_degree_radio_sanitize_transition($input){
        $option = array(
            'fade' => esc_html__('Fade', 'eight-degree'),
            'horizontal' => esc_html__('Slide Horizontal', 'eight-degree'),
            'vertical' => esc_html__('Slide Vertical', 'eight-degree'),
            );
        if(array_key_exists($input, $option)){
            return $input;
        }
        else
            return '';
    }

?>