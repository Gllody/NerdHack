package meteordevelopment.meteorclient.eventbus;

public class NoLambdaFactoryException extends RuntimeException {
    public NoLambdaFactoryException(Class<?> klass) {
        super("No registered lambda listener for '" + klass.getName() + "'.");
    }
}