$(function(){
	rankingTop5();
	
	function rankingTop5(){
		$.ajax({
			dataType: 'json',
			url: '/rankngtop',
			type: 'GET',
			success: function (data) {
				if(data.code==200){
					const rankingTemplate = $('#rankingTopTemplate').html();
					const template = Handlebars.compile(rankingTemplate);
					$('#rankingTop').html(template(data));
				}
			},
			error: function(jqXHR, textStatus, errorThrown){}
		});
	}
});
