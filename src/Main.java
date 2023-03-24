public class Main {

    public static void main(String[] args) {
        Generator gen = new Generator(30, true, true, true, true, true);

        System.out.println(gen.generatePassword());
    }
}
