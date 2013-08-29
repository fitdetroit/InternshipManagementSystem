$(document).ready(function() { 
	$(".account").click(function() { 
		var X=$(this).attr('id');
		if(X==1) {
			$(".submenu").fadeOut();
			$(this).attr('id', '0');	}
		else	{
			$(".submenu").fadeIn();
			$(this).attr('id', '1');	}
});

//Mouseup textarea false
$(".submenu").mouseup(function()	{
	return false
});

$(".account").mouseup(function()	{
	return false
});

//Textarea without editing.
$(document).mouseup(function()	{
	$(".submenu").fadeOut();
	$(".account").attr('id', '');
});	
});