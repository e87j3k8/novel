function viewCnt(){
	$.ajax({
		dataType: 'json',
		url: '/item/viewCnt',
		type: 'POST',
		success: function (data) {
			console.log(data);
			if(data.code===200){
				
			}
		},
		error: function(jqXHR, textStatus, errorThrown){}
	});
}
$(function(){
	const viewTime = setTimeout(viewCnt,30000);
});