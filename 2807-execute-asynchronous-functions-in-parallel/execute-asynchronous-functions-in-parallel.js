/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
    return new Promise((resolve, reject) => {
        const results = new Array(functions.length);
        let resolvedCount = 0;
        
        // Handle edge case: if the array is empty, resolve immediately
        if (functions.length === 0) {
            resolve(results);
            return;
        }
        
        functions.forEach((fn, index) => {
            // Execute the async function and ensure it is treated as a promise
            fn()
                .then((val) => {
                    results[index] = val; // Store the result at its original index
                    resolvedCount++;
                    
                    // Once all promises are successfully fulfilled, resolve the main promise
                    if (resolvedCount === functions.length) {
                        resolve(results);
                    }
                })
                .catch((error) => {
                    // Fail-fast: instantly reject the entire sequence upon the first error
                    reject(error);
                });
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */
