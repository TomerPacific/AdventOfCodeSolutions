const steps = 12302209;
let tape = new Array(steps).fill(0);
let indexInTape = Math.floor(steps / 2);
let actualSteps = 0;
let initialState = 'A';


function simulateStep(state) {
	let nextState = '';
	switch(state) {
		case 'A':{
			if(tape[indexInTape] === 0) {
				tape[indexInTape] = 1;
				indexInTape++;
				nextState = 'B';
			} else {
				tape[indexInTape] = 0;
				indexInTape--;
				nextState = 'D';
			}
			break;
		}
		case 'B': {
			if(tape[indexInTape] === 0){
				tape[indexInTape] = 1;
				indexInTape++;
				nextState = 'C';
			} else {
				tape[indexInTape] = 0;
				indexInTape++;
				nextState = 'F';
			}
			break;
		}
		case 'C': {
			if(tape[indexInTape] === 0){
				tape[indexInTape] = 1;
				indexInTape--;
				nextState = 'C';
			} else {
				tape[indexInTape] = 1;
				indexInTape--;
				nextState = 'A';
			}
			break;
		}
		case 'D': {
			if(tape[indexInTape] === 0){
				tape[indexInTape] = 0;
				indexInTape--;
				nextState = 'E';
			} else {
				tape[indexInTape] = 1;
				indexInTape++;
				nextState = 'A';
			}
			break;
		}
		case 'E': {
			if(tape[indexInTape] === 0){
				tape[indexInTape] = 1;
				indexInTape--;
				nextState = 'A';
			} else {
				tape[indexInTape] = 0;
				indexInTape++;
				nextState = 'B';
			}
			break;
		}
		case 'F': {
			if(tape[indexInTape] === 0){
				tape[indexInTape] = 0;
				indexInTape++;
				nextState = 'C';
			} else {
				tape[indexInTape] = 0;
				indexInTape++;
				nextState = 'E';
			}
			break;
		}
		default:
			console.log("Unrecognized state " + state);
	} //end switch
	actualSteps++;
	return nextState;
}

for(let i = 0; i < steps; i++) {
	initialState = simulateStep(initialState);
}
let count = 0;
for(let i = 0; i < steps; i++) {
	if(tape[i] === 1) {
		count++;
	}
}
console.log("First Half Answer : " + count);