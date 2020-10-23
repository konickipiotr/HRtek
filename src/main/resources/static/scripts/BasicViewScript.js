//Onload
console.log("elo000")
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

if(document.getElementById("byStartWork").checked == true){
	document.getElementById("startWorkEqual").disabled = false;
	document.getElementById("startWorkRange").disabled = false;
	document.getElementById("startWork").disabled = false;
	document.getElementById("startWorkTo").disabled = false;
	
	if(document.getElementById("startWorkEqual").checked == true){
		document.getElementById("startWorkTo").disabled = true;
	}
	
	if(document.getElementById("birthLess").checked == true){
		document.getElementById("dateofbirth").disabled = true;
		document.getElementById("dateofbirthTo").disabled = true;
	}
}else{
	document.getElementById("startWorkEqual").disabled = true;
	document.getElementById("startWorkRange").disabled = true;
	document.getElementById("startWork").disabled = true;
	document.getElementById("startWorkTo").disabled = true;
}




if(document.getElementById("byStartZus").checked == true){
	document.getElementById("startZusEqual").disabled = false;
	document.getElementById("startZusRange").disabled = false;
	document.getElementById("startZus").disabled = false;
	document.getElementById("startZusTo").disabled = false;
	
	if(document.getElementById("startZusEqual").checked == true){
		document.getElementById("startZusTo").disabled = true;
	}
}else{
	document.getElementById("startZusEqual").disabled = true;
	document.getElementById("startZusRange").disabled = true;
	document.getElementById("startZus").disabled = true;
	document.getElementById("startZusTo").disabled = true;
}



if(document.getElementById("byEndWork").checked == true){
	document.getElementById("endWorkEqual").disabled = false;
	document.getElementById("endWorkRange").disabled = false;
	document.getElementById("endWork").disabled = false;
	document.getElementById("endWorkTo").disabled = false;
	
	if(document.getElementById("endWorkEqual").checked == true){
		document.getElementById("endWorkTo").disabled = true;
	}
}else{
	document.getElementById("endWorkEqual").disabled = true;
	document.getElementById("endWorkRange").disabled = true;
	document.getElementById("endWork").disabled = true;
	document.getElementById("endWorkTo").disabled = true;
}



if(document.getElementById("byEndZus").checked == true){
	document.getElementById("endZusEqual").disabled = false;
	document.getElementById("endZusRange").disabled = false;
	document.getElementById("endZus").disabled = false;
	document.getElementById("endZusTo").disabled = false;
	
	if(document.getElementById("endWorkEqual").checked == true){
		document.getElementById("endZusTo").disabled = true;
	}
	
	
}else{
	document.getElementById("endZusEqual").disabled = true;
	document.getElementById("endZusRange").disabled = true;
	document.getElementById("endZus").disabled = true;
	document.getElementById("endZusTo").disabled = true;
}


if(document.getElementById("startWorkEqual").checked == true){
	document.getElementById("lablebirthequal").hidden = false
	document.getElementById("lablstartworkfrom").hidden = true
}else{
	document.getElementById("lablestartworkequal").hidden = true
	document.getElementById("lablstartworkfrom").hidden = false
}

if(document.getElementById("startZusEqual").checked == true){
	document.getElementById("lablestartworkequal").hidden = false
	document.getElementById("lablstartzusfrom").hidden = true
}else{
	document.getElementById("lablestartzusequal").hidden = true
	document.getElementById("lablstartzusfrom").hidden = false
}

if(document.getElementById("endWorkEqual").checked == true){
	document.getElementById("lableworkequal").hidden = false
	document.getElementById("lableworkfrom").hidden = true
}else{
	document.getElementById("lableworkequal").hidden = true
	document.getElementById("lableworkfrom").hidden = false
}

if(document.getElementById("endZusEqual").checked == true){
	document.getElementById("lablezusequal").hidden = false
	document.getElementById("lablezusfrom").hidden = true
}else{
	document.getElementById("lablezusequal").hidden = true
	document.getElementById("lablezusfrom").hidden = false
}



//events
document.getElementById("byEndZus").onchange = function(){
	if(document.getElementById("byEndZus").checked == true){
		document.getElementById("endZusEqual").disabled = false;
		document.getElementById("endZusRange").disabled = false;
		document.getElementById("endZus").disabled = false;
		document.getElementById("endZusTo").disabled = false;
		
		if(document.getElementById("endWorkEqual").checked == true){
			document.getElementById("endZusTo").disabled = true;
		}
	}else{
		document.getElementById("endZusEqual").disabled = true;
		document.getElementById("endZusRange").disabled = true;
		document.getElementById("endZus").disabled = true;
		document.getElementById("endZusTo").disabled = true;
	}
}

document.getElementById("endZusEqual").onchange = function(){
	document.getElementById("endZusTo").disabled = true;
	document.getElementById("lablezusequal").hidden = false
	document.getElementById("lablezusfrom").hidden = true
}

document.getElementById("endZusRange").onchange = function(){
	document.getElementById("endZusTo").disabled = false;
	document.getElementById("lablezusequal").hidden = true
	document.getElementById("lablezusfrom").hidden = false
}




document.getElementById("byEndWork").onchange = function(){
	if(document.getElementById("byEndWork").checked == true){
		document.getElementById("endWorkEqual").disabled = false;
		document.getElementById("endWorkRange").disabled = false;
		document.getElementById("endWork").disabled = false;
		document.getElementById("endWorkTo").disabled = false;
		
		if(document.getElementById("endWorkEqual").checked == true){
			document.getElementById("endWorkTo").disabled = true;
		}
	}else{
		document.getElementById("endWorkEqual").disabled = true;
		document.getElementById("endWorkRange").disabled = true;
		document.getElementById("endWork").disabled = true;
		document.getElementById("endWorkTo").disabled = true;
	}
}
document.getElementById("endWorkEqual").onchange = function(){
	document.getElementById("endWorkTo").disabled = true;
	document.getElementById("lableworkequal").hidden = false
	document.getElementById("lableworkfrom").hidden = true
}

document.getElementById("endWorkRange").onchange = function(){
	document.getElementById("endWorkTo").disabled = false;
	document.getElementById("lableworkequal").hidden = true
	document.getElementById("lableworkfrom").hidden = false
}




document.getElementById("byStartZus").onchange = function(){
	if(document.getElementById("byStartZus").checked == true){
		document.getElementById("startZusEqual").disabled = false;
		document.getElementById("startZusRange").disabled = false;
		document.getElementById("startZus").disabled = false;
		document.getElementById("startZusTo").disabled = false;
		
		if(document.getElementById("startZusEqual").checked == true){
			document.getElementById("startZusTo").disabled = true;
		}
	}else{
		document.getElementById("startZusEqual").disabled = true;
		document.getElementById("startZusRange").disabled = true;
		document.getElementById("startZus").disabled = true;
		document.getElementById("startZusTo").disabled = true;
	}
}

document.getElementById("startZusEqual").onchange = function(){
	document.getElementById("startZusTo").disabled = true;
	document.getElementById("lablestartzusequal").hidden = false
	document.getElementById("lablstartzusfrom").hidden = true
}

document.getElementById("startZusRange").onchange = function(){
	document.getElementById("startZusTo").disabled = false;
	document.getElementById("lablestartzusequal").hidden = true
	document.getElementById("lablstartzusfrom").hidden = false
}




document.getElementById("byStartWork").onchange = function(){
	if(document.getElementById("byStartWork").checked == true){
		document.getElementById("startWorkEqual").disabled = false;
		document.getElementById("startWorkRange").disabled = false;
		document.getElementById("startWork").disabled = false;
		document.getElementById("startWorkTo").disabled = false;
		
		if(document.getElementById("startWorkEqual").checked == true){
			document.getElementById("startWorkTo").disabled = true;
		}
	}else{
		document.getElementById("startWorkEqual").disabled = true;
		document.getElementById("startWorkRange").disabled = true;
		document.getElementById("startWork").disabled = true;
		document.getElementById("startWorkTo").disabled = true;
	}
}
document.getElementById("startWorkEqual").onchange = function(){
	document.getElementById("startWorkTo").disabled = true;
	document.getElementById("lablestartworkequal").hidden = false
	document.getElementById("lablstartworkfrom").hidden = true
}

document.getElementById("startWorkRange").onchange = function(){
	document.getElementById("startWorkTo").disabled = false;
	document.getElementById("lablestartworkequal").hidden = true
	document.getElementById("lablstartworkfrom").hidden = false
}





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




