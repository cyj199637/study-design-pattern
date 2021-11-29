package chapter06.exercise;

public class UsePrinter {
    public void doSomething() {
        String str = "마루코는 아홉 살";
        PrinterFactory.getPrinterFactory().getPrinter().print(str);
    }
}

interface InterfacePrinter {
    void print(String str);
}

class RealPrinter implements InterfacePrinter {
    @Override
    public void print(String str) {
        System.out.println(str);
    }
}

class FakePrinter implements InterfacePrinter {
    private String str;

    @Override
    public void print(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }
}

class PrinterFactory {
    private static PrinterFactory printerFactory = null;

    protected PrinterFactory() {}

    public synchronized static PrinterFactory getPrinterFactory() {
        if (printerFactory == null) {
            printerFactory = new PrinterFactory();
        }
        return printerFactory;
    }

    public static void setPrinterFactory(PrinterFactory p) {
        printerFactory = p;
    }

    public InterfacePrinter getPrinter() {
        return new RealPrinter();
    }
}

class FakePrinterFactory extends PrinterFactory {
    public InterfacePrinter getPrinter() {
        return new FakePrinter();
    }
}