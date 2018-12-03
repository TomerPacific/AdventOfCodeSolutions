const puzzleInput = [3, 4, 1, 5];
let list = [...Array(5).keys()];
let skipAmount = 0;
let indexInList = 0;

for(let i = 0; i < puzzleInput.length; i++) {
	let amountToReverse = puzzleInput[i];
	if(amountToReverse + indexInList >= list.length) {
		let remainderToReverse = amountToReverse - (list.length - indexInList);
		let toReverse2 = list.slice(indexInList);
		let moreToReverse = list.slice(0, remainderToReverse);
		let middle = list.slice(remainderToReverse, indexInList);
		let toReverse2Length = toReverse2.length;
		let moreToReverseLength = moreToReverse.length;
		let all = toReverse2.concat(moreToReverse);
		all = all.reverse();
		toReverse2 = all.slice(0, toReverse2.length);
		moreToReverse = all.slice(moreToReverseLength);
		list = moreToReverse.concat(middle).concat(toReverse2);
	} else if(amountToReverse > 1) {
		let toReverse = list.slice(indexInList, amountToReverse);
		let restOfList = list.slice(amountToReverse);
		toReverse = toReverse.reverse();
		list = toReverse.concat(restOfList);
	}

	indexInList = (indexInList + amountToReverse + skipAmount) % list.length;
	skipAmount++;
}