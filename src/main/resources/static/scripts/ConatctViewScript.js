//Onload
if(document.getElementById("bytext").checked == true){
	document.getElementById("textequal").disabled = false;
	document.getElementById("textcontains").disabled = false;
	document.getElementById("textfirst").disabled = false;
	document.getElementById("emptytext").disabled = false;
	document.getElementById("firstname").disabled = false;
	document.getElementById("lastname").disabled = false;
	document.getElementById("name").disabled = false;
	
	document.getElementById("email").disabled = false;
	document.getElementById("phone").disabled = false;
	document.getElementById("pladdress").disabled = false;
	document.getElementById("plpostcode").disabled = false;
	document.getElementById("plcity").disabled = false;
	document.getElementById("address").disabled = false;
	document.getElementById("postcode").disabled = false;
	document.getElementById("city").disabled = false;

	document.getElementById("texttosearch").disabled = false;
	
}else{
	document.getElementById("textequal").disabled = true;
	document.getElementById("textcontains").disabled = true;
	document.getElementById("textfirst").disabled = true;
	document.getElementById("emptytext").disabled = true;
	document.getElementById("firstname").disabled = true;
	document.getElementById("lastname").disabled = true;
	document.getElementById("name").disabled = true;

	document.getElementById("email").disabled = true;
	document.getElementById("phone").disabled = true;
	document.getElementById("pladdress").disabled = true;
	document.getElementById("plpostcode").disabled = true;
	document.getElementById("plcity").disabled = true;
	document.getElementById("address").disabled = true;
	document.getElementById("postcode").disabled = true;
	document.getElementById("city").disabled = true;
	
	document.getElementById("texttosearch").disabled = true;
}

document.getElementById("bytext").onchange = function(){
	if(document.getElementById("bytext").checked == true){
		document.getElementById("textequal").disabled = false;
		document.getElementById("textcontains").disabled = false;
		document.getElementById("textfirst").disabled = false;
		document.getElementById("emptytext").disabled = false;
		document.getElementById("firstname").disabled = false;
		document.getElementById("lastname").disabled = false;
		document.getElementById("name").disabled = false;
		
		document.getElementById("email").disabled = false;
		document.getElementById("phone").disabled = false;
		document.getElementById("pladdress").disabled = false;
		document.getElementById("plpostcode").disabled = false;
		document.getElementById("plcity").disabled = false;
		document.getElementById("address").disabled = false;
		document.getElementById("postcode").disabled = false;
		document.getElementById("city").disabled = false;

		document.getElementById("texttosearch").disabled = false;
		
	}else{
		document.getElementById("textequal").disabled = true;
		document.getElementById("textcontains").disabled = true;
		document.getElementById("textfirst").disabled = true;
		document.getElementById("emptytext").disabled = true;
		document.getElementById("firstname").disabled = true;
		document.getElementById("lastname").disabled = true;
		document.getElementById("name").disabled = true;

		document.getElementById("email").disabled = false;
		document.getElementById("phone").disabled = false;
		document.getElementById("pladdress").disabled = false;
		document.getElementById("plpostcode").disabled = false;
		document.getElementById("plcity").disabled = false;
		document.getElementById("address").disabled = false;
		document.getElementById("postcode").disabled = false;
		document.getElementById("city").disabled = false;
		
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


/////////////////////////////////////////////////////////////

