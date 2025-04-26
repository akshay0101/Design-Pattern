# Design Patterns

Following the guide from [Design Patterns Reference](https://www.notion.so/Design-Patterns-18a24568da6180249462f9580ee5cf63)

## Creational Design Patterns

### Singleton Pattern

Ensures a class has only one instance while providing a global access point to this instance. Key implementation requirements:
- Private constructor to prevent external instantiation
- Thread-safe implementation to handle concurrent access

![Singleton Pattern](images/singleton.png)

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