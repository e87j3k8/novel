function like(status){
	$.ajax({
		dataType: 'json',
		url: '/products/like',
		type: 'POST',
		data: {'status':status},
		success: function (data) {
			console.log(data);
			if(data.code===200){
				if(status===0){
					$('#like span.cnt').text(data.data.like);
				}else if(status===1){
					$('#dislike span.cnt').text(data.data.dislike);
				}
				getLikeStatus();
			}
		},
		error: function(jqXHR, textStatus, errorThrown){}
	});
}

function getLikeStatus(){
	$.ajax({
		dataType: 'json',
		url: '/products/getStatus',
		type: 'GET',
		success: function (data) {
			if(data.code===200){
				const btns = $('.recommend');
				if(data.data ===null){
					btns.prop('disabled', true);
				}else if(data.data ===false){
					$('#like').attr('onClick','like(0);');
					$('#dislike').attr('onClick','like(1);');
				}else{
					btns.prop('disabled', true);
				}
			}
		},
		error: function(jqXHR, textStatus, errorThrown){}
	});
}

$(function(){
	getLikeStatus();
});