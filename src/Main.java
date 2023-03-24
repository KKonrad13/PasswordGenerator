public class Main {

    public static void main(String[] args) {
        Generator gen = new Generator(10, true, true, true, true);

        System.out.println(gen.generatePassword());
    }
}
