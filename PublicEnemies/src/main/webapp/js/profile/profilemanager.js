function undressWeapon1(wid){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "undressWeapon1_" + wid;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}
function undressWeapon2(wid){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "undressWeapon2_" + wid;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}

function undressArmor(armorId){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "undressArmor_" + armorId;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}
function undressAid(aidId){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "undressAid_" + aidId;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}


function dressWeapon(wid){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "dressWeapon_" + wid;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}

function dressArmor(armorId){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "dressArmor_" + armorId;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}
function dressAid(aidId){
	child = document.createElement("input");
	child.type = "hidden";
	child.name = "dressAid_" + aidId;
	child.value = "1";
	document.forms.changeForm.appendChild(child);			
	// do submit (goes into controller through post)
	document.forms.changeForm.submit();
}