/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    // Base Case 1: If the value is null, return null (since typeof null is 'object')
    if (obj === null) return null;
    
    // Base Case 2: If it's not an object or array, it's a primitive value
    if (typeof obj !== 'object') return obj;
    
    // Case 1: If it's an array, filter out falsy items and recursively compact the rest
    if (Array.isArray(obj)) {
        const compactedArray = [];
        for (const item of obj) {
            if (item) { // Checks if the item is truthy
                compactedArray.push(compactObject(item));
            }
        }
        return compactedArray;
    }
    
    // Case 2: If it's a standard object, recursively compact its key-value pairs
    const compactedObj = {};
    for (const key in obj) {
        if (obj[key]) { // Checks if the value at this key is truthy
            compactedObj[key] = compactObject(obj[key]);
        }
    }
    
    return compactedObj;
};
