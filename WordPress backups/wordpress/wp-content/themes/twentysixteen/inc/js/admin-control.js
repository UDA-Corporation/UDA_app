jQuery(document).ready(function($) {

    $('.switch_options').each(function() {
        //This object
        var obj = $(this);

        var enb = obj.children('.switch_enable'); //cache first element, this is equal to ON
        var dsb = obj.children('.switch_disable'); //cache first element, this is equal to OFF
        var input = obj.children('input'); //cache the element where we must set the value
        var input_val = obj.children('input').val(); //cache the element where we must set the value

        /* Check selected */
        if (0 == input_val) {
            dsb.addClass('selected');
        }
        else if (1 == input_val) {
            enb.addClass('selected');
        }

        //Action on user's click(ON)
        enb.on('click', function() {
            $(dsb).removeClass('selected'); //remove "selected" from other elements in this object class(OFF)
            $(this).addClass('selected'); //add "selected" to the element which was just clicked in this object class(ON) 
            $(input).val(1).change(); //Finally change the value to 1
        });

        //Action on user's click(OFF)
        dsb.on('click', function() {
            $(enb).removeClass('selected'); //remove "selected" from other elements in this object class(ON)
            $(this).addClass('selected'); //add "selected" to the element which was just clicked in this object class(OFF) 
            $(input).val(0).change(); // //Finally change the value to 0
        });

    });

    jQuery(document).on('click', '.ed-font-group li', function(){
        $('.ed-font-group li').removeClass();
        $(this).addClass('selected');
        var aa = $(this).parents('#ed-font-awesome-list').find('.ed-font-group li.selected').children('i').attr('class');
        $(this).parents('#ed-font-awesome-list').siblings('p').find('.hidden-icon-input').val(aa);
        $(this).parents('#ed-font-awesome-list').siblings('p').find('.icon-receiver').html('<i class="'+aa+'"></i>');
        return false;
   });
    

});//document.ready close