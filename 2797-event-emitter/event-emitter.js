class EventEmitter {
    constructor() {
        // Map to store event names as keys and an array of callback functions as values
        this.events = new Map();
    }

    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        // If the event doesn't exist yet, initialize it with an empty array
        if (!this.events.has(eventName)) {
            this.events.set(eventName, []);
        }
        
        const callbacks = this.events.get(eventName);
        callbacks.push(callback);

        return {
            unsubscribe: () => {
                // Find the index of this specific callback instance
                const index = callbacks.indexOf(callback);
                
                // If found, remove it from the array
                if (index !== -1) {
                    callbacks.splice(index, 1);
                }
                
                // Optional: Clean up memory if no callbacks are left for this event
                if (callbacks.length === 0) {
                    this.events.delete(eventName);
                }
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        // If no subscriptions exist for this event, return an empty array
        if (!this.events.has(eventName)) {
            return [];
        }
        
        // Execute every callback with the provided arguments and return the results
        return this.events.get(eventName).map(callback => callback(...args));
    }
}

/**
 * const emitter = new EventEmitter();
 * 
 * // Subscribe to the same event multiple times
 * const sub1 = emitter.subscribe("firstEvent", (...args) => args[0] + 1);
 * const sub2 = emitter.subscribe("firstEvent", (...args) => args[0] + 2);
 * 
 * emitter.emit("firstEvent", [5]); // [6, 7]
 * sub1.unsubscribe(); // returns undefined
 * emitter.emit("firstEvent", [5]); // [7]
 */
