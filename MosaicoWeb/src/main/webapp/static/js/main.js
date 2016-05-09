jQuery(function($) {

//	//Isotope
//	$(window).load(function(){
//		console.log("awdfsadfasdf");
//		$portfolio = $('#port');
//		$portfolio.isotope({
//			itemSelector : 'li',
//			layoutMode : 'fitRows'
//		});
//		$portfolio_selectors = $('#filterPort >li>a');
//		console.log("awdfsadfasdf");
//		$portfolio_selectors.on('click', function(){
//			$portfolio_selectors.removeClass('active');
//			$(this).addClass('active');
//			var selector = $(this).attr('data-filter');
//			$portfolio.isotope({ filter: selector });
//			return false;
//		});
//	});
	
//	$(function(){
//		$('#main-slider.carousel').carousel({
//			interval: 600,
//			
//		});
//	});

	//Ajax contact
	var form = $('.contact-form');
	form.submit(function () {
		$this = $(this);
		$.post($(this).attr('action'), function(data) {
			$this.prev().text(data.message).fadeIn().delay(3000).fadeOut();
		},'json');
		return false;
	});

	//smooth scroll
	$('.navbar-nav > li').click(function(event) {
		event.preventDefault();
		var target = $(this).find('>a').prop('hash');
		$('html, body').animate({
			scrollTop: $(target).offset().top
		}, 500);
	});

	//scrollspy
	$('[data-spy="scroll"]').each(function () {
		var $spy = $(this).scrollspy('refresh')
	})

//	//PrettyPhoto
//	$("a.preview").prettyPhoto({
//		social_tools: false
//	});

	
});