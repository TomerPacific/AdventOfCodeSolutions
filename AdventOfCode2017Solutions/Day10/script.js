const lengths = [88,88,211,106,141,1,78,254,2,111,77,255,90,0,54,205];
let list = [...Array(256).keys()];
const LIST_SIZE = list.length;
let indexInList = 0;
let skip = 0;


function simulate(){
	for(let i = 0; i < lengths.length; i++){
		console.log("List before reversing " + list);
		let amountToReverse = lengths[i];
		if(indexInList + amountToReverse > LIST_SIZE){
			let amountToBeSliced = LIST_SIZE - indexInList;
			let remainder = amountToReverse - amountToBeSliced;
			let start = list.slice(indexInList);
			let restFromStart = list.slice(0, remainder);
			let arrayPartNotReveresed = list.slice(remainder, indexInList);
			let allElements = (start.concat(restFromStart)).reverse();
			list = allElements.concat(arrayPartNotReveresed);
		}
		else
		{
			let start = list.slice(0, indexInList);
			let middle = (list.slice(indexInList, indexInList + amountToReverse)).reverse();
			let after = list.slice(indexInList+amountToReverse);
			list = start.concat(middle).concat(after);
		} 
		
		//console.log("list after reversing " + amountToReverse + " elements is " + list);
		indexInList = (indexInList + amountToReverse + skip) % LIST_SIZE;
		//console.log("Next index to reverse from is " + indexInList);
		skip++;
	}
	console.log(list);
	
}


simulate();