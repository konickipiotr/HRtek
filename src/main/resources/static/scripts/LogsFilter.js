//Onload
if(document.getElementById("bytext").checked == true){
	document.getElementById("texttosearch").disabled = false;
	
}else{
	document.getElementById("texttosearch").disabled = true;
}


/////////////////////////////
////////////////////////


document.getElementById("bytext").onchange = function(){
	if(document.getElementById("bytext").checked == true){
		document.getElementById("texttosearch").disabled = false;
		
	}else{
		document.getElementById("texttosearch").disabled = true;
	}
}



if(document.getElementById("byTimestamp").checked == true){
	document.getElementById("timestampEqual").disabled = false;
	document.getElementById("timestampRange").disabled = false;
	document.getElementById("timestamp").disabled = false;
	document.getElementById("timestampTo").disabled = false;
	
	if(document.getElementById("timestampEqual").checked == true){
		document.getElementById("timestampTo").disabled = true;
	}
}else{
	document.getElementById("timestampEqual").disabled = true;
	document.getElementById("timestampRange").disabled = true;
	document.getElementById("timestamp").disabled = true;
	document.getElementById("timestampTo").disabled = true;
}


if(document.getElementById("timestampEqual").checked == true){
	document.getElementById("lablebirthequal").hidden = false
	document.getElementById("labelbirthfrom").hidden = true
}else{
	document.getElementById("lablebirthequal").hidden = true
	document.getElementById("labelbirthfrom").hidden = false
}


document.getElementById("byTimestamp").onchange = function(){
	if(document.getElementById("byTimestamp").checked == true){
		document.getElementById("timestampEqual").disabled = false;
		document.getElementById("timestampRange").disabled = false;
		document.getElementById("timestamp").disabled = false;
		document.getElementById("timestampTo").disabled = false;
		
		if(document.getElementById("timestampEqual").checked == true){
			document.getElementById("timestampTo").disabled = true;
		}
	}else{
		document.getElementById("timestampEqual").disabled = true;
		document.getElementById("timestampRange").disabled = true;
		document.getElementById("timestamp").disabled = true;
		document.getElementById("timestampTo").disabled = true;
	}
}

document.getElementById("timestampEqual").onchange = function(){
	document.getElementById("timestampTo").disabled = true;
	document.getElementById("lablebirthequal").hidden = false
	document.getElementById("labelbirthfrom").hidden = true
}

document.getElementById("timestampRange").onchange = function(){
	document.getElementById("timestampTo").disabled = false;
	document.getElementById("lablebirthequal").hidden = true
	document.getElementById("labelbirthfrom").hidden = false
}






