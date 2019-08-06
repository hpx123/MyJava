package LeetCode;

import java.util.Scanner;

public class LeetCode035 {
    public static void main(String[] args) {
        A a = new A();
        A a1 = new B();
        A a2 = new C();

        B b = new B();
        B b1 = new C();

        a.run(a1);
        a.run(a2);
        a1.run(b);

        b.run(a);
        b.run(b1);

        D d = new D();
        d.run(a);
    }
    static class A {
        public void run(A a) {
            System.out.println(a.out());
        }

        public String out() {
            return "这是A";
        }
    }

    static class B extends A{

        public void run(A a) {
            System.out.println(a.out() + "---B");
        }

        public String out() {
            return "这是B";
        }
    }

    static class C extends B {
        public String out() {
            return "这是C";
        }
    }

    static class D extends A {

    }
}
