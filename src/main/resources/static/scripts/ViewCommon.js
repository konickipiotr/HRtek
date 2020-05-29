
/////////////////////////////////////////////////////////////


if(document.getElementById("bydateofbirth").checked == true){
	document.getElementById("birthEqual").disabled = false;
	document.getElementById("birthRange").disabled = false;
	document.getElementById("birthLess").disabled = false;
	document.getElementById("dateofbirth").disabled = false;
	document.getElementById("dateofbirthTo").disabled = false;
	
	if(document.getElementById("birthEqual").checked == true){
		document.getElementById("dateofbirthTo").disabled = true;
	}
	if(document.getElementById("birthLess").checked == true){
		document.getElementById("dateofbirthTo").disabled = true;
		document.getElementById("dateofbirth").disabled = true;
	}
}else{
	document.getElementById("birthEqual").disabled = true;
	document.getElementById("birthRange").disabled = true;
	document.getElementById("dateofbirth").disabled = true;
	document.getElementById("dateofbirthTo").disabled = true;
	document.getElementById("birthLess").disabled = true;
}


if(document.getElementById("birthEqual").checked == true){
	document.getElementById("lablebirthequal").hidden = false
	document.getElementById("labelbirthfrom").hidden = true
}else{
	document.getElementById("lablebirthequal").hidden = true
	document.getElementById("labelbirthfrom").hidden = false
}


document.getElementById("bydateofbirth").onchange = function(){
	if(document.getElementById("bydateofbirth").checked == true){
		document.getElementById("birthEqual").disabled = false;
		document.getElementById("birthRange").disabled = false;
		document.getElementById("birthLess").disabled = false;
		document.getElementById("dateofbirth").disabled = false;
		document.getElementById("dateofbirthTo").disabled = false;
		
		if(document.getElementById("birthEqual").checked == true){
			document.getElementById("dateofbirthTo").disabled = true;
		}
		if(document.getElementById("birthLess").checked == true){
			document.getElementById("dateofbirthTo").disabled = true;
			document.getElementById("dateofbirth").disabled = true;
		}
	}else{
		document.getElementById("birthEqual").disabled = true;
		document.getElementById("birthRange").disabled = true;
		document.getElementById("dateofbirth").disabled = true;
		document.getElementById("dateofbirthTo").disabled = true;
		document.getElementById("birthLess").disabled = true;
	}
}

document.getElementById("birthEqual").onchange = function(){
	document.getElementById("dateofbirthTo").disabled = true;
	document.getElementById("lablebirthequal").hidden = false
	document.getElementById("labelbirthfrom").hidden = true
}

document.getElementById("birthRange").onchange = function(){
	document.getElementById("dateofbirthTo").disabled = false;
	document.getElementById("lablebirthequal").hidden = true
	document.getElementById("labelbirthfrom").hidden = false
}

document.getElementById("birthLess").onchange = function(){
	document.getElementById("dateofbirthTo").disabled = true;
	document.getElementById("dateofbirth").disabled = true;
	document.getElementById("lablebirthequal").hidden = true
	document.getElementById("labelbirthfrom").hidden = true
}


//////////////////////////////////
