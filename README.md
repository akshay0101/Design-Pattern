# Design Patterns

Following the guide from [Design Patterns Reference](https://www.notion.so/Design-Patterns-18a24568da6180249462f9580ee5cf63)

## Creational Design Patterns

### Singleton Pattern

Ensures a class has only one instance while providing a global access point to this instance. Key implementation requirements:
- Private constructor to prevent external instantiation
- Thread-safe implementation to handle concurrent access

![Singleton Pattern](https://github.com/akshay0101/Design-Pattern/blob/main/Images/singleton.png?raw=true)

#### Implementation Details:

1. **Volatile Keyword**: Prevents the issue of partially constructed objects. Without it, a thread might see a non-null `instance` reference even when the object initialization is incomplete.

2. **Double-Checked Locking**: Uses a two-step verification process:
   - First check outside synchronized block to avoid unnecessary locking
   - Second check inside synchronized block to ensure only one instance is created
   - This approach prevents threads from waiting when the instance already exists

3. **Local Variable Caching**: Storing the instance in a local variable (`result`) before returning:
   - Ensures the variable is read directly from main memory once
   - Improves method performance by approximately 40%
   - Reduces the number of volatile reads which are more expensive than regular reads

This implementation ensures both thread safety and optimal performance in multi-threaded environments.

### Factory Pattern

Creates objects without exposing the instantiation logic to the client and refers to the newly created object through a common interface.

Key characteristics:
- **Loosens coupling** by separating product construction code from the code that uses the product
- It is a factory **METHOD** pattern that relies heavily on **inheritance**
- Lets creator subclasses decide which class to instantiate
- Useful when you don't know beforehand the **exact types and dependencies** of the objects your code should work with
- Makes it easy to **extend the product construction code** independently from the rest of the application


![Factory Pattern](https://github.com/akshay0101/Design-Pattern/blob/main/Images/factoryy.png?raw=true)