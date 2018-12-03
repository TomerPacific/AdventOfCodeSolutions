let generatorA = 722;
const generatorAFactor = 16807;

let generatorB = 354;
const generatorBFactor = 48271;

const divideBy = 2147483647;
let LIMIT = 40000000;
const MOVE_DIGITS = 16;
let total = 0;


function simulateGenerators(){
	for(let i = 0; i < LIMIT; i++){
		generatorA = (generatorA * generatorAFactor) % divideBy;
		generatorB = (generatorB * generatorBFactor) % divideBy;
		

		if(generatorA << MOVE_DIGITS === generatorB << MOVE_DIGITS) {
			total++;
		}

	} // end for
	
	return total;
}

function simulateGeneratorsAgain() {
	total = 0;
	LIMIT = 5000000;
	
	for(let i = 0; i < LIMIT; i++){
		do {
			generatorA = (generatorA * generatorAFactor) % divideBy;
		}
		while(generatorA % 4 !== 0)
			do {
				generatorB = (generatorB * generatorBFactor) % divideBy;
			}
			while(generatorB % 8 !== 0)
				total += generatorA << MOVE_DIGITS === generatorB << MOVE_DIGITS;
		}
	return total;
}

const pairsEqual = simulateGenerators();
generatorA = 722;
generatorB = 354;
const pairsEqual2 = simulateGeneratorsAgain();
console.table({"Solution First Half":pairsEqual, "Solution Second Half":pairsEqual2});