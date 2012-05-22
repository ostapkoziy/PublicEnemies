toBuy = new Array();
toSell = new Array();

Count = new Array();

//shows how many items selected to buy/sell
buyCount = 0;
sellCount = 0; 

bSumm = new Array();

//increase_money = 0; 
decrease_money = 0;
function sell(item, price) {
	var curr_money = document.getElementById("money").innerHTML - decrease_money + price;
	decrease_money -= parseInt(price);
	document.getElementById("money_value").innerHTML = "$ " + curr_money;
	
	document.getElementById("selected_items").innerHTML 
	+= "<p class='sel_items' id='r" + item + "'></p>";
	toSell[toSell.length] = item;
	document.getElementById("r"+item).innerHTML = " - " +
		document.getElementById(item).getAttribute("info")
		+ " <a style=\"cursor:pointer;\" onclick=\"unSell('"
		+ item + "', '" + price + "')\"><img src='./img/cancel_buying.png'/></a>";
	document.getElementById(item).style.display = "none";
	sellCount++;	
}

function buy(item, price){
	var tb = false;
	var i = 0;
	var curr_money = document.getElementById("money").innerHTML - decrease_money - price;
	// check for below zero
	if (curr_money >= 0) {	 
		decrease_money += price;
		document.getElementById("money_value").innerHTML = "$ " + curr_money;
		
		// looking for matching id
		for(i = 0; i < toBuy.length; i++){
			if(toBuy[i] == item){
				tb = true;
				break;
			}
		}
		// if there is no match - put 1, else - increase
		if(!tb){
			toBuy[toBuy.length] = item;
			Count[Count.length] = 1;
		} else { Count[i]++; }
		
		if(!bSumm[item]) { // && bSumm[item]!=0){
			bSumm[item]=0;
			document.getElementById("selected_items").innerHTML 
				+= "<p class='sel_items' id='s" 
				+ item + "'></p>";			
		}
		bSumm[item]++;
		document.getElementById("s"+item).innerHTML = 
			" + " + document.getElementById(item).getAttribute("info")
			+ " ["+bSumm[item]+ "] <a style=\"cursor:pointer;\" onclick=\"unBuy('"
			+ item + "', '" + price+"')\"><img src='./img/cancel_buying.png'/></a>";		
	} else {		
		alert("NO MONEY!");
	}
	buyCount++;
}
	
function unSell(item, price){
	var i = 0;
	var curr_money = document.getElementById("money").innerHTML;
	
	decrease_money += parseInt(price);
	
	document.getElementById("money_value").innerHTML = "$ " + (curr_money - decrease_money);
	document.getElementById("r"+item).parentNode.removeChild(document.getElementById("r"+item));
	for (i = 0; i < toSell.length; i++) {
		if (toSell[i] == item) {
			toSell[i] = 0;
		}
	}	 
	document.getElementById(item).style.display = "block";
	sellCount--;
}
	
// back money and delete from list elements
function unBuy(item, price){
	var curr_money = document.getElementById("money").innerHTML;
	// back money if delete from cart	 
	decrease_money -= price;
	document.getElementById("money_value").innerHTML = "$ " + (curr_money - decrease_money);
	bSumm[item]--;
	// deleting <p> tag
	if(bSumm[item]==0){
		document.getElementById("s"+item).parentNode.removeChild(document.getElementById("s"+item));	
		//toBuy[item] = null;
	}
	else {
		document.getElementById("s"+item).innerHTML = 
			" + " + document.getElementById(item).getAttribute("info")
			+ " ["+bSumm[item] + "] <a style=\"cursor:pointer;\" onclick=\"unBuy('" 
					+ item + "', '" + price + "')\"><img src='./img/cancel_buying.png'/></a>";
	}
	var i = 0; 
	for(i=0;i<toBuy.length;i++){
		if(toBuy[i]==item){
			Count[i]--;
		break;
		}
	}
	buyCount--;
}
// creates hidden fields into form and commits (go to controller)
function doBuy(){
	if(buyCount > 0 || sellCount > 0){
		var i = 0; 
				
		for(i = 0; i < toBuy.length; i++){
			if (Count[i] == 0) {
				continue;
			}
			child = document.createElement("input");
			child.type = "hidden";
			child.name = "buy_" + toBuy[i];
			child.value = Count[i];
			document.forms.dobuy.appendChild(child);			
		}	
		for(i = 0;i<toSell.length;i++){
			if (toSell[i] == 0) {
				continue;
			}
			child = document.createElement("input");
			child.type = "hidden";
			child.name = "sell_" + toSell[i];
			child.value = "1";
			document.forms.dobuy.appendChild(child);			
		}
		// do submit (goes into controller through post)
		document.forms.dobuy.submit();
	} else {
		alert("You haven't selected anything!");
	}
}