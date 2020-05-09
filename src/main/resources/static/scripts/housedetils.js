
document.getElementById("editaddress").onchange = function(){
	if(document.getElementById("editaddress").checked == true){
		document.getElementById("savebuttonAddress").disabled = false;
		document.getElementById("address").disabled = false;
		document.getElementById("postcode").disabled = false;
		document.getElementById("city").disabled = false;
	}else{
		document.getElementById("savebuttonAddress").disabled = true;
		document.getElementById("address").disabled = true;
		document.getElementById("postcode").disabled = true;
		document.getElementById("city").disabled = true;
	}
}

document.getElementById("editfinance").onchange = function(){
	if(document.getElementById("editfinance").checked == true){
		document.getElementById("rent").disabled = false;
		document.getElementById("media").disabled = false;
		document.getElementById("deposit").disabled = false;
		document.getElementById("savebuttonFinance").disabled = false;
		document.getElementById("typecostrent").disabled = false;
		document.getElementById("typecostrentmedia").disabled = false;
		document.getElementById("typecostperperson").disabled = false;
		
		if(document.getElementById("typecostperperson").checked == true){
			document.getElementById("perperson").disabled = false;
		}
		
		
	}else{
		document.getElementById("rent").disabled = true;
		document.getElementById("media").disabled = true;
		document.getElementById("deposit").disabled = true;
		document.getElementById("perperson").disabled = true;
		document.getElementById("savebuttonFinance").disabled = true;
		document.getElementsByName("typecost").disabled = true;
		document.getElementById("typecostrent").disabled = true;
		document.getElementById("typecostrentmedia").disabled = true;
		document.getElementById("typecostperperson").disabled = true;
	}
}


document.getElementById("typecostperperson").onchange = function(){
	if(document.getElementById("typecostperperson").checked == true){
		document.getElementById("perperson").disabled = false;
	}
}

document.getElementById("typecostrentmedia").onchange = function(){
	if(document.getElementById("typecostrentmedia").checked == true){
		document.getElementById("perperson").disabled = true;
	}
}

document.getElementById("typecostrent").onchange = function(){
	if(document.getElementById("typecostrent").checked == true){
		document.getElementById("perperson").disabled = true;
	}
}

document.getElementById("editlider").onchange = function(){
	if(document.getElementById("editlider").checked == true){
		document.getElementById("liderbonus").disabled = false;
		document.getElementById("liderid").disabled = false;
		document.getElementById("savebuttonLider").disabled = false;
	}else{
		document.getElementById("liderbonus").disabled = true;
		document.getElementById("liderid").disabled = true;
		document.getElementById("savebuttonLider").disabled = true;
	}
}

document.getElementById("clearremake").onclick = function(){
	document.getElementById("remark").value = "";
}



