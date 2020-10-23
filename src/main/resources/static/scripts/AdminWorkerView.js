//Onload
if(document.getElementById("bytext").checked == true){
	document.getElementById("textequal").disabled = false;
	document.getElementById("textcontains").disabled = false;
	document.getElementById("textfirst").disabled = false;
	document.getElementById("emptytext").disabled = false;
	document.getElementById("firstname").disabled = false;
	document.getElementById("lastname").disabled = false;
	document.getElementById("name").disabled = false;
	document.getElementById("pesel").disabled = false;
	document.getElementById("passport").disabled = false;
	document.getElementById("texttosearch").disabled = false;
	
}else{
	document.getElementById("textequal").disabled = true;
	document.getElementById("textcontains").disabled = true;
	document.getElementById("textfirst").disabled = true;
	document.getElementById("emptytext").disabled = true;
	document.getElementById("firstname").disabled = true;
	document.getElementById("lastname").disabled = true;
	document.getElementById("name").disabled = true;
	document.getElementById("pesel").disabled = true;
	document.getElementById("passport").disabled = true;
	document.getElementById("texttosearch").disabled = true;
}


/////////////////////////////
////////////////////////


//document.getElementById("birthRange").onclick function(){
//	document.getElementById("dateofbirthTo").disabled = false;
//}



document.getElementById("bytext").onchange = function(){
	if(document.getElementById("bytext").checked == true){
		document.getElementById("textequal").disabled = false;
		document.getElementById("textcontains").disabled = false;
		document.getElementById("textfirst").disabled = false;
		document.getElementById("emptytext").disabled = false;
		document.getElementById("firstname").disabled = false;
		document.getElementById("lastname").disabled = false;
		document.getElementById("name").disabled = false;
		document.getElementById("pesel").disabled = false;
		document.getElementById("passport").disabled = false;
		document.getElementById("texttosearch").disabled = false;
		
	}else{
		document.getElementById("textequal").disabled = true;
		document.getElementById("textcontains").disabled = true;
		document.getElementById("textfirst").disabled = true;
		document.getElementById("emptytext").disabled = true;
		document.getElementById("firstname").disabled = true;
		document.getElementById("lastname").disabled = true;
		document.getElementById("name").disabled = true;
		document.getElementById("pesel").disabled = true;
		document.getElementById("passport").disabled = true;
		document.getElementById("texttosearch").disabled = true;
	}
}

document.getElementById("emptytext").onchange = function(){
	document.getElementById("texttosearch").disabled = true;
}

document.getElementById("textfirst").onchange = function(){
	document.getElementById("texttosearch").disabled = false;
}

document.getElementById("textcontains").onchange = function(){
	document.getElementById("texttosearch").disabled = false;
}

document.getElementById("textequal").onchange = function(){
	document.getElementById("texttosearch").disabled = false;
}

//
//document.getElementById("emptytext").onclick = function(){
//	console.log("el");
//	if(document.getElementById("emptytext").checked){
//		document.getElementById("texttosearch").disabled = true;
//	}else{
//		document.getElementById("texttosearch").disabled = false;
//	}
//}
//




