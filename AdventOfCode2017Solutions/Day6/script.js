const memoryBanks = [14, 0, 15, 12, 11, 11, 3, 5 ,1 ,6 ,8 ,4 ,9, 1, 8, 4];

let configurations = new Map();
configurations.set(memoryBanks.join(), configurations.size);
let rounds = 0;
let i = 0;
let maximumElement = 0;
let index = 0;

function startDistributionCycles(){

	while(true){
		maximumElement = Math.max(...memoryBanks);
		index = 0;
		let valueOfBank = 0;
		for(i = 0; i < memoryBanks.length; i++){
			if(memoryBanks[i] === maximumElement){
				index = i;
				break;
			}
		}
		valueOfBank = memoryBanks[i];
		memoryBanks[i] = 0;
		i = (index + 1) % memoryBanks.length;
		while(valueOfBank > 0){
			memoryBanks[i]++;
			valueOfBank--;
			if(i === memoryBanks.length - 1){
				i = 0;
			}
			else
			{
				i++;
			}
		} // end while
		const picture = memoryBanks.join();
		if(configurations.has(picture)){
			const startIterations = configurations.get(picture);
			return {"first":configurations.size, "second":configurations.size - startIterations};
		}
		rounds++;
		configurations.set(picture, configurations.size);
	} //end while
	
} //end function startDistributionCycles

const result = startDistributionCycles();
console.table({"Day 6 First Half Solution":result.first, "Day 6 Second Half Solution":result.second});