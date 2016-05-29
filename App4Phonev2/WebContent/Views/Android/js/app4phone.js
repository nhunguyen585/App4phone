var i = 1;
var sum_img = 4;
function next(){
	while(i == sum_img){
		i = 0;
	}
	i++;
	document.getElementById("img").setAttribute("src", "Image/Homepage/"+i+".jpg");
}
function previous(){
	while(i == 1){
		i = sum_img + 1;
	}
	i--;
	document.getElementById("img").setAttribute("src", "Image/Homepage/"+i+".jpg");
}
function main(){
	setInterval(function(){
		next();
	}, 2000);
}
main();
$(document).ready(function(){
	$("#game").mouseenter(function(){
		$("#menu_game").slideDown(300);
	});
	$("#game").mouseleave(function(){
		$("#menu_game").slideUp(300);
	});
	$("#app").mouseenter(function(){
		$("#menu_app").slideDown(300);
	});
	$("#app").mouseleave(function(){
		$("#menu_app").slideUp(300);
	});
	$("#next").click(function(){
		next();	
	});
	$("#previous").click(function(){
		previous();	
	});
	$("#login").click(function(){
		$("#popup_login").fadeIn();
		$("#dark").fadeIn();
	});
	$("#close_popup_login").click(function(){
		$("#popup_login").fadeOut();
		$("#dark").fadeOut();
	});
	$("#register").click(function(){
		$("#popup_register").fadeIn();
		$("#dark").fadeIn();
	});
	$("#close_popup_register").click(function(){
		$("#popup_register").fadeOut();
		$("#dark").fadeOut();
	});
	$("#admin").click(function(){
		$("#add").fadeToggle();
	});
});