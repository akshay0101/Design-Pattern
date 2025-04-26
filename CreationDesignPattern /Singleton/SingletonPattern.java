// Singleton class
class MongoConnection {
    // Static variable to hold the single instance
    private static volatile MongoConnection instance;

    // Private constructor to prevent instantiation from outside
    private MongoConnection(String connectionString) {
        System.out.println("MongoDB connection established with: " + connectionString);
    }

    // Public method to provide access to the instance
    public static MongoConnection getConnectionInstance() {
        MongoConnection localInstance = instance; // Local reference to the instance
        if(localInstance == null) {
            synchronized (MongoConnection.class) { // Synchronize to prevent multiple threads from creating multiple instances
                if (localInstance == null) {
                    localInstance = instance;
                    instance = localInstance = new MongoConnection("Akshay.connection"); // Create a new instance if it doesn't exist
                }
            }
        }
        // Return the single instance
        return localInstance;
    }
    // Method to simulate a database operation
    public void showMessage() {
        System.out.println("Hello from MongoDB! with string as :" + instance);
    }
}

// Main class to test the Singleton
public class SingletonPattern {
    public static void main(String[] args) {
        // Get the single instance of Singleton
        MongoConnection connection1 = MongoConnection.getConnectionInstance();
        connection1.showMessage();

        // Get the same instance again
        MongoConnection connection2 = MongoConnection.getConnectionInstance();
        System.out.println("Are both instances the same? " + (connection1 == connection2));
    }
}

