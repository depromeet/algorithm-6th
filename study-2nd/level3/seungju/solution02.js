function solution(n, computers) {
    // Graph object holding the node numbers and connections
    const graph = {};

    computers.forEach((computer, index) => {
        const currentNodeNumber = index + 1;
        
        // Change 1, 0 to node number that the current node is connected to and add to graph object
        graph[currentNodeNumber] = computer.map((connection, i) => connection * (i + 1))
                                        .map((i) => String(i))
                                        .filter((i) => i != 0)
                                        .filter((nodeNumber) => nodeNumber != currentNodeNumber);
    });

    return Object.keys(graph)
                .map((node) => depthFirstSearch(graph, node)) // DFS algorithm
                .map((i) => i.sort().join("")) // Sort and join to filter out unique values
                .filter(isUnique)
                .length;
}


function depthFirstSearch(graph, startsAt) {
    const stack = [];
    const history = [];

    stack.push(startsAt);

    while (stack.length > 0) {
        node = stack.pop();
        if (history.indexOf(node) < 0) {
            history.push(node);
            // Push all the connected nodes into the stack
            graph[node].forEach((i) => stack.push(i));
        }
    }

    return history;
}

function isUnique(value, index, self) { 
    // Is value within the Array?
    return self.indexOf(value) === index;
}
