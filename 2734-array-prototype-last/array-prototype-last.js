/**
 * @return {null|boolean|number|string|array|object}
 */
Array.prototype.last = function() {
    // If the array is empty, return -1
    if (this.length === 0) {
        return -1;
    }
    
    // Otherwise, return the element at the final index
    return this[this.length - 1];
};

/**
 * const arr = [1, 2, 3];
 * arr.last(); // 3
 */
