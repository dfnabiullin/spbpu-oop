public class Methods {
    public @Annotation(val = 1) void publicMethodOne(int a) {
        System.out.println("Public method one.");
    }

    public void publicMethodTwo(int a, int b) {
        System.out.println("Public method two.");
    }

    protected @Annotation(val = 2) void protectedMethodOne(int a, int b, int c) {
        System.out.println("Protected method one.");
    }

    protected void protectedMethodTwo(int a, int b, int c, int d) {
        System.out.println("Protected method two.");
    }

    private @Annotation(val = 3) void privateMethodOne(int a, int b, int c, int d, int e) {
        System.out.println("Private method one.");
    }

    private void privateMethodTwo(int a, int b, int c, int d, int e, int f) {
        System.out.println("Private method two.");
    }
}
