class Calculator {
    static int addition(int a, int b) {
        int c = a + b
        return c
    }

    static int subtraction(int a, int b) {
        int c = a - b
        return c
    }

    static int multiplication(int a, int b) {
        int c = a * b
        return c
    }

    static def division(int a, int b) {
        try {
            float c = a / b
            return c
        } catch (ArithmeticException e) {
            assert e instanceof ArithmeticException
            println "Division by 0 is prohibited!"
        }
    }
}
