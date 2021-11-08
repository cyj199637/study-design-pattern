package chapter04.exercise;

public class Checkpoint153xy {

    public static void main(String[] args) {

    }
}

class X {
}

class Y {
    public void m1(int a, int b) {
        Z o = new Z();
        boolean g = (a >= b);
        if (g) {
            o.m2();
        }
    }
}

class Z {
    private W w;

    public void m2() {
        w = null;
    }
}

class W {
}
