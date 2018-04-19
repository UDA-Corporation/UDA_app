jQuery(document).ready(function($){
    //Search Box Toogle
    $('.ed-search-wrap .search-icon .fa-search').click(function(){
      $('#masthead .ed-search-wrap').addClass('show');
  });
    $('.ed-search-wrap .search-icon .fa-close').click(function(){
      $('#masthead .ed-search-wrap').removeClass('show');
  });
    $('.menu-item-has-children,.page_item_has_children').prepend('<i class="fa fa-caret-down menu-caret"></i>');
    var winwidth = $(window).width();
    if(winwidth <= 980) {
        $('.main-navigation ul.sub-menu,.main-navigation ul.children').hide();
        $('body').on('click','.main-navigation.toggled .menu-caret',function(){
           $(this).siblings('ul.sub-menu,ul.children').slideToggle();
        });
    }
    //go to top 
    if ($('#back-to-top').length) {
        var scrollTrigger = 100, // px
        goToTop = function () {
            var scrollTop = $(window).scrollTop();
            if (scrollTop > scrollTrigger) {
                $('#back-to-top').addClass('show');
            } else {
                $('#back-to-top').removeClass('show');
            }
        };
        //goToTop();
        $(window).on('scroll', function () {
            goToTop();
        });
        $('#back-to-top').on('click', function (e) {
            e.preventDefault();
            $('html,body').animate({
                scrollTop: 0
            }, 700);
        });
    }

    /*main slider*/
    var options = {};
    if(eightDegreeSliderData.pager=='true'){ options.pager = true;}
    else{ options.pager = false; }
    if(eightDegreeSliderData.autop=='true'){ options.auto = true;}
    else{ options.auto = false; }
    if(eightDegreeSliderData.controls=='true'){ options.controls = true;}
    else{ options.controls = false; }
    if(eightDegreeSliderData.trans ){ options.mode = eightDegreeSliderData.trans;}
    else{ options.mode = "horizontal"; }
    if(eightDegreeSliderData.pause ){ options.pause = eightDegreeSliderData.pause;}
    else{ options.pause = 3500; }
    if(eightDegreeSliderData.speed ){ options.speed = eightDegreeSliderData.speed;}
    else{ options.speed = 1000; }
    $("#ed-slider").bxSlider(options);
    
    // featured tab    
    $('.featured-tab-wrap .featured-title:first').addClass("active");
    $('.featured-tab-post .featured-post:not(:first)').hide();
    $( '.featured-tab-wrap .featured-title' ).on( 'click',function(){
        $( '.featured-tab-wrap .featured-title' ).removeClass("active");
        $(this).addClass("active");
        var id = $(this).attr('id');
        $(this).parent().siblings().find('.featured-post').hide();
        $(this).parent().siblings().find('.' + id).show();

    });

    new WOW().init();

    var winwidth = $(window).width();
    var smargin = 45;
    var maxsl = 2;
    var swidth = 500;
    if(winwidth<=640){ maxsl = 1; swidth = 300; smargin = 0; }
    else if(winwidth<=1100){  swidth= (winwidth/2)-45;  }
    
    // testimonial slider
    $('.testimonial-slider').bxSlider({
        auto:true,
        controls:false,
        pager: true,
        moveSlides:1,
        minSlides: 1,
        maxSlides: maxsl,
        slideWidth: swidth,
        slideMargin: smargin,
    });

    $('.ed-portfolio-section').imagesLoaded( function() {

        var $grid1 = $('.portfolio-post-wrap').isotope({
            itemSelector: '.portfolio-post',
            percentPosition: true,
        });


        // bind filter button click
        $('.filters-button-group').on('click', 'li', function () {
            var filterValue = $(this).attr('data-filter');
            $grid1.isotope({filter: filterValue});
        });

        // change is-checked class on buttons
        $('.button-group').each(function (i, buttonGroup) {
            var $buttonGroup = $(buttonGroup);
            $buttonGroup.on('click', 'li', function () {
                $buttonGroup.find('.is-checked').removeClass('is-checked');
                $(this).addClass('is-checked');
            });
        });
    });
    // counter for widget
    $('.counter').counterUp({
      delay: 10,
      time: 1000
    });
    
    $('.widget_eight_degree_progress_bar').each(function(){
    $(this).waypoint(function() {
      var progressWidth = $(this).find('.ed-progress-bar-percentage').data('value')+'%';
      $(this).find('.ed-progress-bar-percentage').animate({width:progressWidth},2000);         
    }, {
    offset: '95%'
  });
  });

/***** widget js ends **********/



});