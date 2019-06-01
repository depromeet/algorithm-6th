function solution(numbers) {

    const letters = numbers.split("")
    
    const primeNumbers = permutationOf(letters)
                                .map((s) => parseInt(s))
                                .filter(isUnique)
                                .filter(isPrimeNumber)

    return primeNumbers.length
}

function permutationOf(letters) {
    // The seed is provided when there is only one letter
    if (letters.length === 1) {
        return Array(letters.pop());
    }

    // Recursive function after saving the last letter
    const lastLetter = letters.pop();
    const permutations = permutationOf(letters);

    // Add the last letter to each of the permutated arrays
    // e.g., ["701"] + "1" -> ["1701", "7101", "7011", "7011"]
    const permutationsWithLetterAdded = []
    permutations.forEach((permutation) => {
        Array(permutation.length + 1)
                    .fill()
                    .map((_, i) => (i))
                    .forEach((index) => {
                        const t = permutation.split("")
                        t.splice(index, 0 ,lastLetter)
                        permutationsWithLetterAdded.push(t.join(""))
                    })
    })

    permutationsWithLetterAdded.push(lastLetter);
    return permutations.concat(permutationsWithLetterAdded);
}

function isPrimeNumber(n) {
    // [2, ..., n - 1]
    const dividers = Array(n)
                        .fill()
                        .map((_, i) => (i))
                        .slice(2)
    // If n can be divided, it is not a prime number
    for (const divider of dividers) {
        if(n % divider === 0) {
            return false
        };
    }
    return n > 1
} 

function isUnique(value, index, self) { 
    // Is value within the Array?
    return self.indexOf(value) === index;
}