/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map = new Map();
    
    // Insert all objects from the first array into the map
    for (const obj of arr1) {
        map.set(obj.id, { ...obj });
    }
    
    // Merge or insert objects from the second array
    for (const obj of arr2) {
        if (map.has(obj.id)) {
            // Overwrite arr1 fields with arr2 fields using spread operator
            map.set(obj.id, { ...map.get(obj.id), ...obj });
        } else {
            map.set(obj.id, { ...obj });
        }
    }
    
    // Extract values, sort by ID ascending, and return
    return Array.from(map.values()).sort((a, b) => a.id - b.id);
};
