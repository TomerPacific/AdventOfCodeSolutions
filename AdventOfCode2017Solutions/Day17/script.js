const puzzleInput = 304;
const limit = 2018;
const jump = 3;
let arr = [0];
let elem = 1;
let index = 0;
let land = 0;
let steps = 0;

function simulate(){
	while(elem < limit){
		while(steps < puzzleInput){
			index = (index + 1) % arr.length;
			steps++;
		}	
		index++;
		arr.splice(index, 0, elem);
		elem++;
		steps = 0;
	}

	console.log(arr[index - 1], arr[index], arr[index + 1]);
	
}

simulate();