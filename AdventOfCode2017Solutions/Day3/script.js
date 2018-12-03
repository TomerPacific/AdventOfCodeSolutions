const position = 325489;
let currentX = 0;
let currentY = 0;


function sumSurroundingSquares(arr, i, j){
	let sumOfSurroundingElements = 0;

	sumOfSurroundingElements += j + 1 < arr[i].length ? arr[i][j + 1] : 0;
	sumOfSurroundingElements += i - 1 >= 0 ? arr[i - 1][j] : 0;

	if(i !== arr.length - 1) {
		sumOfSurroundingElements += arr[i + 1][j] !== undefined ? arr[i + 1][j] : 0;
		if(j !== 0) {
			sumOfSurroundingElements += arr[i + 1][j - 1] !== undefined ? arr[i + 1][j - 1] : 0;
		}
		if(j !== arr.length - 1) {
			sumOfSurroundingElements += arr[i + 1][j + 1] !== undefined ? arr[i + 1][j + 1] : 0;
		}
	}

	if(i !== 0) {
		if(j !== arr.length - 1) {
			sumOfSurroundingElements += arr[i - 1][j + 1] !== undefined ? arr[i - 1][j + 1] : 0;
		}
		if(j !== 0) {
			sumOfSurroundingElements += arr[i - 1][j - 1] !== undefined ? arr[i - 1][j - 1] : 0;
			sumOfSurroundingElements += arr[i][j - 1] !== undefined ? arr[i][j - 1] : 0;
		}
	}

	return sumOfSurroundingElements;
}

function printArr(arr){
	let row = "";
	let all = "";
	for(let i = 0; i < arr.length; i++){
		for(let j = 0; j < arr[i].length; j++){
			let val = arr[i][j] === undefined ? "0" : arr[i][j];
			row += " ["+val+"] ";
		}
		row+="\n";
		all += row;
		row = "";
	}
	console.log(all);
}


function moveRight(arr, rightMove) {
	for(let right = 1; right <= rightMove; right++){
		currentY += currentY < arr.length - 1 ? 1 : 0;
		if(currentY < arr.length) {
			arr[currentX][currentY] = sumSurroundingSquares(arr, currentX, currentY);
		}
	}
}

function moveUp(arr, upMove) {
	for(let up = 1; up <= upMove; up++){
		currentX -= currentX > 0 ? 1 : 0;
		if(currentX >= 0) {
			arr[currentX][currentY] = sumSurroundingSquares(arr, currentX, currentY);
		}
	}
}

function moveLeft(arr, leftMove) {
	for(let left = 1; left <= leftMove; left++){
		currentY -= currentY > 0 ? 1 : 0; 
		if(currentY >= 0) {
			arr[currentX][currentY] = sumSurroundingSquares(arr, currentX, currentY);
		}
	}
}

function moveDown(arr, downMove) {
	for(let down = 1; down <= downMove; down++){
		currentX += currentX < arr.length - 1 ? 1 : 0;
		if(currentX < arr.length) {
			arr[currentX][currentY] = sumSurroundingSquares(arr, currentX, currentY);
		}
	}
}

function moveRightAgain(arr, rightAgainMove) {
	for(let rightAgain = 1; rightAgain <= rightAgainMove; rightAgain++) {
		currentY += currentY < arr.length - 1 ? 1 : 0;
		if(currentY < arr.length) {
			arr[currentX][currentY] = sumSurroundingSquares(arr, currentX, currentY);
		}
	}
}



 function simulateRotation(){
	let arr = new Array(10);
	for(let i = 0; i < arr.length; i++){
		arr[i] = new Array();
		for(let j = 0; j < 10; j++) {
			arr[i].push(0);
		}
	}

	let rightMove = 1;
	let upMove = 1;
	let leftMove = 2;
	let downMove = 2;
	let rightAgainMove = rightMove + 1;
	currentX = Math.floor(arr.length / 2);
	currentY = currentX;
	arr[currentX][currentY] = 1;
	
	for(let moves = 0; moves < 4; moves++){

		moveRight(arr, rightMove);

		moveUp(arr, upMove);

		moveLeft(arr, leftMove);

		moveDown(arr, downMove);

		moveRightAgain(arr, rightAgainMove);

		upMove += 2;
		leftMove += 2;
		downMove += 2;
		rightAgainMove += 2;

	} 

	printArr(arr);
}
simulateRotation();