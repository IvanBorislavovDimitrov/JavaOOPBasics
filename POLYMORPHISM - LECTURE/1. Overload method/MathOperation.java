public class MathOperation {

    public int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    public int add(int a, int b, int c) {
        return add(a, b, c, 0);
    }

    public int add(int a, int b) {
        return this.add(a, b, 0);
    }

}
