public class DifferentMethods {
    @Repeat(1)
    public void firstPublicMethod(int i) {
        System.out.println("The first public method is called " + i + " times");
    }

    public void secondPublicMethod(int i) {
        System.out.println("The second public method is called " + i + " times");
    }

    @Repeat(2)
    public void thirdPublicMethod(int i) {
        System.out.println("The third public method is called " + i + " times");
    }

    protected void firstProtectedMethod(int i) {
        System.out.println("The first protected method is called " + i + " times");
    }

    @Repeat(3)
    protected void secondProtectedMethod(int i) {
        System.out.println("The second protected method is called " + i + " times");
    }

    private void firstPrivateMethod(int i) {
        System.out.println("The first private method is called " + i + " times");
    }

    @Repeat(4)
    private void secondPrivateMethod(int i) {
        System.out.println("The second private method is called " + i + " times");
    }

    private void thirdPrivateMethod(int i) {
        System.out.println("The third private method is called " + i + " times");
    }
}