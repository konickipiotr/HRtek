//Onload
if(document.getElementById("bytext").checked == true){
	document.getElementById("textequal").disabled = false;
	document.getElementById("textcontains").disabled = false;
	document.getElementById("textfirst").disabled = false;
	document.getElementById("emptytext").disabled = false;
	document.getElementById("firstname").disabled = false;
	document.getElementById("lastname").disabled = false;
	document.getElementById("name").disabled = false;
	document.getElementById("texttosearch").disabled = false;
	
}else{
	document.getElementById("textequal").disabled = true;
	document.getElementById("textcontains").disabled = true;
	document.getElementById("textfirst").disabled = true;
	document.getElementById("emptytext").disabled = true;
	document.getElementById("firstname").disabled = true;
	document.getElementById("lastname").disabled = true;
	document.getElementById("name").disabled = true;
	
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
		document.getElementById("texttosearch").disabled = false;
		
	}else{
		document.getElementById("textequal").disabled = true;
		document.getElementById("textcontains").disabled = true;
		document.getElementById("textfirst").disabled = true;
		document.getElementById("emptytext").disabled = true;
		document.getElementById("firstname").disabled = true;
		document.getElementById("lastname").disabled = true;
		document.getElementById("name").disabled = true;
		
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
//////////////////////////////////


if(document.getElementById("byStartMedicalFrom").checked == true){
	document.getElementById("startMedicalEqual").disabled = false;
	document.getElementById("startMedicalRange").disabled = false;
	document.getElementById("startMedicalFromFrom").disabled = false;
	document.getElementById("startMedicalFromTo").disabled = false;
	
	if(document.getElementById("startMedicalEqual").checked == true){
		document.getElementById("startMedicalFromTo").disabled = true;
	}
}else{
	document.getElementById("startMedicalEqual").disabled = true;
	document.getElementById("startMedicalRange").disabled = true;
	document.getElementById("startMedicalFromFrom").disabled = true;
	document.getElementById("startMedicalFromTo").disabled = true;
}


if(document.getElementById("startMedicalEqual").checked == true){
	document.getElementById("labelestartmedicalequal").hidden = false
	document.getElementById("labelstartmedicalfrom").hidden = true
}else{
	document.getElementById("labelestartmedicalequal").hidden = true
	document.getElementById("labelstartmedicalfrom").hidden = false
}


document.getElementById("byStartMedicalFrom").onchange = function(){
	if(document.getElementById("byStartMedicalFrom").checked == true){
		document.getElementById("startMedicalEqual").disabled = false;
		document.getElementById("startMedicalRange").disabled = false;
		document.getElementById("startMedicalFromFrom").disabled = false;
		document.getElementById("startMedicalFromTo").disabled = false;
		
		if(document.getElementById("startMedicalEqual").checked == true){
			document.getElementById("startMedicalFromTo").disabled = true;
		}
	}else{
		document.getElementById("startMedicalEqual").disabled = true;
		document.getElementById("startMedicalRange").disabled = true;
		document.getElementById("startMedicalFromFrom").disabled = true;
		document.getElementById("startMedicalFromTo").disabled = true;
	}
}

document.getElementById("startMedicalEqual").onchange = function(){
	document.getElementById("startMedicalFromTo").disabled = true;
	document.getElementById("labelestartmedicalequal").hidden = false
	document.getElementById("labelstartmedicalfrom").hidden = true
}

document.getElementById("startMedicalRange").onchange = function(){
	document.getElementById("startMedicalFromTo").disabled = false;
	document.getElementById("labelestartmedicalequal").hidden = true
	document.getElementById("labelstartmedicalfrom").hidden = false
}


/////////////////////////////////////////////////////////////


if(document.getElementById("byStartMedicalTo").checked == true){
	document.getElementById("endMedicalEqual").disabled = false;
	document.getElementById("endMedicalRange").disabled = false;
	document.getElementById("endMedicalFrom").disabled = false;
	document.getElementById("endMedicalTo").disabled = false;
	
	if(document.getElementById("endMedicalEqual").checked == true){
		document.getElementById("endMedicalTo").disabled = true;
	}
}else{
	document.getElementById("endMedicalEqual").disabled = true;
	document.getElementById("endMedicalRange").disabled = true;
	document.getElementById("endMedicalFrom").disabled = true;
	document.getElementById("endMedicalTo").disabled = true;
}


if(document.getElementById("endMedicalEqual").checked == true){
	document.getElementById("lablendmedicalequal").hidden = false
	document.getElementById("labelendmedicalfrom").hidden = true
}else{
	document.getElementById("lablendmedicalequal").hidden = true
	document.getElementById("labelendmedicalfrom").hidden = false
}


document.getElementById("byStartMedicalTo").onchange = function(){
	if(document.getElementById("byStartMedicalTo").checked == true){
		document.getElementById("endMedicalEqual").disabled = false;
		document.getElementById("endMedicalRange").disabled = false;
		document.getElementById("endMedicalFrom").disabled = false;
		document.getElementById("endMedicalTo").disabled = false;
		
		if(document.getElementById("endMedicalEqual").checked == true){
			document.getElementById("endMedicalTo").disabled = true;
		}
	}else{
		document.getElementById("endMedicalEqual").disabled = true;
		document.getElementById("endMedicalRange").disabled = true;
		document.getElementById("endMedicalFrom").disabled = true;
		document.getElementById("endMedicalTo").disabled = true;
	}
}

document.getElementById("endMedicalEqual").onchange = function(){
	document.getElementById("endMedicalTo").disabled = true;
	document.getElementById("lablendmedicalequal").hidden = false
	document.getElementById("labelendmedicalfrom").hidden = true
}

document.getElementById("endMedicalRange").onchange = function(){
	document.getElementById("endMedicalTo").disabled = false;
	document.getElementById("lablendmedicalequal").hidden = true
	document.getElementById("labelendmedicalfrom").hidden = false
}


//////////////////////////////////
/////////////////////////////////////////////////////////////


if(document.getElementById("byAddToSystem").checked == true){
	document.getElementById("addToSystemEqual").disabled = false;
	document.getElementById("addToSystemRange").disabled = false;
	document.getElementById("addToSystemFrom").disabled = false;
	document.getElementById("addToSystemTo").disabled = false;
	
	if(document.getElementById("addToSystemEqual").checked == true){
		document.getElementById("addToSystemTo").disabled = true;
	}
}else{
	document.getElementById("addToSystemEqual").disabled = true;
	document.getElementById("addToSystemRange").disabled = true;
	document.getElementById("addToSystemFrom").disabled = true;
	document.getElementById("addToSystemTo").disabled = true;
}


if(document.getElementById("addToSystemEqual").checked == true){
	document.getElementById("labladtosystemequal").hidden = false
	document.getElementById("labeladtosystemfrom").hidden = true
}else{
	document.getElementById("labladtosystemequal").hidden = true
	document.getElementById("labeladtosystemfrom").hidden = false
}


document.getElementById("byAddToSystem").onchange = function(){
	if(document.getElementById("byAddToSystem").checked == true){
		document.getElementById("addToSystemEqual").disabled = false;
		document.getElementById("addToSystemRange").disabled = false;
		document.getElementById("addToSystemFrom").disabled = false;
		document.getElementById("addToSystemTo").disabled = false;
		
		if(document.getElementById("addToSystemEqual").checked == true){
			document.getElementById("addToSystemTo").disabled = true;
		}
	}else{
		document.getElementById("addToSystemEqual").disabled = true;
		document.getElementById("addToSystemRange").disabled = true;
		document.getElementById("addToSystemFrom").disabled = true;
		document.getElementById("addToSystemTo").disabled = true;
	}
}

document.getElementById("addToSystemEqual").onchange = function(){
	document.getElementById("addToSystemTo").disabled = true;
	document.getElementById("labladtosystemequal").hidden = false
	document.getElementById("labeladtosystemfrom").hidden = true
}

document.getElementById("addToSystemRange").onchange = function(){
	document.getElementById("addToSystemTo").disabled = false;
	document.getElementById("labladtosystemequal").hidden = true
	document.getElementById("labeladtosystemfrom").hidden = false
}


//////////////////////////////////
