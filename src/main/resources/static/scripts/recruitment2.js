document.getElementById("isOhter").onchange = function(){
	if(document.getElementById("isOhter").checked == true){
		
		document.getElementById("pladdress").disabled = false;
		document.getElementById("plpostcode").disabled = false;
		document.getElementById("plcity").disabled = false;
		
		document.getElementById("pladdress").required = true;
		document.getElementById("plpostcode").required = true;
		document.getElementById("plcity").required = true;
		document.getElementById("bedid").required = false;
		document.getElementById("bedid").disabled = true;
		document.getElementById("acomdatefrom").disabled = true;
		document.getElementById("acomdateTo").disabled = true;
	}else{
		document.getElementById("pladdress").disabled = true;
		document.getElementById("plpostcode").disabled = true;
		document.getElementById("plcity").disabled = true;
		
		document.getElementById("pladdress").required = false;
		document.getElementById("plpostcode").required = false;
		document.getElementById("plcity").required = false;
		document.getElementById("bedid").required = true;
		document.getElementById("bedid").disabled = false;
		document.getElementById("acomdatefrom").disabled = false;
		document.getElementById("acomdateTo").disabled = false;
	}
}

function enableReadOnly(){
	if(status == "success"){
		document.getElementById("firstname").readOnly = true;
		document.getElementById("lastname").readOnly = true;
		document.getElementById("sexM").readOnly = true;
		document.getElementById("sexF").readOnly = true;
		document.getElementById("dateofbirth").readOnly = true;
		document.getElementById("isBiopass").readOnly = true;
		document.getElementById("passport").readOnly = true;
		document.getElementById("recruterid").readOnly = true;
		document.getElementById("companyid").readOnly = true;
		document.getElementById("factoryid").readOnly = true;
		document.getElementById("isOhter").readOnly = true;
		document.getElementById("bedid").readOnly = true;
		document.getElementById("pladdress").readOnly = true;
		document.getElementById("plpostcode").readOnly = true;
		document.getElementById("plcity").readOnly = true;
		document.getElementById("address").readOnly = true;
		document.getElementById("postcode").readOnly = true;
		document.getElementById("city").readOnly = true;
		document.getElementById("email").readOnly = true;
		document.getElementById("phone").readOnly = true;
		document.getElementById("note").readOnly = true;
		document.getElementById("startZus").readOnly = true;
		document.getElementById("endZus").readOnly = true;
		document.getElementById("acomdate").readOnly = true;
	}
}
