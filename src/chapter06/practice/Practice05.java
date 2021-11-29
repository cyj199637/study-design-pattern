package chapter06.practice;

public class Practice05 {

}

interface Server {
    void doSomething();
}

class ServerProxy implements Server {
    @Override
    public void doSomething() {}
}

class FakeServer implements Server {
    @Override
    public void doSomething() {}
}

class ServerFactory {
    private static ServerFactory instance = new ServerFactory();

    protected ServerFactory() {}

    public static ServerFactory getInstance() {
        return instance;
    }

    public static void setInstance(ServerFactory serverFactory) {
        instance = serverFactory;
    }

    public Server getServer() {
        return new ServerProxy();
    }
}

class FakeServerFactory extends ServerFactory {
    public Server getServer() {
        return new FakeServer();
    }
}

class UseServer {
    public void doSomething() {
        final var server = ServerFactory.getInstance().getServer();
        server.doSomething();
    }
}
