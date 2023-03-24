public class Generator {
    private final char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final char[] lowercaseLetters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    private final char[] uppercaseLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private final char[] specialSigns = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '`', '~', '[', ']', '{', '}', '|', '\\', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?'};

    private int length;
    private boolean withNumbers;
    private boolean withLowercaseLetters;
    private boolean withUppercaseLetters;
    private boolean withSpecialSigns;

    public Generator(int length, boolean withNumbers, boolean withLowercaseLetters, boolean withUppercaseLetters, boolean withSpecialSigns) {
        this.length = length;
        this.withNumbers = withNumbers;
        this.withLowercaseLetters = withLowercaseLetters;
        this.withUppercaseLetters = withUppercaseLetters;
        this.withSpecialSigns = withSpecialSigns;
    }

    public String generatePassword(){
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isWithNumbers() {
        return withNumbers;
    }

    public void setWithNumbers(boolean withNumbers) {
        this.withNumbers = withNumbers;
    }

    public boolean isWithLowercaseLetters() {
        return withLowercaseLetters;
    }

    public void setWithLowercaseLetters(boolean withLowercaseLetters) {
        this.withLowercaseLetters = withLowercaseLetters;
    }

    public boolean isWithUppercaseLetters() {
        return withUppercaseLetters;
    }

    public void setWithUppercaseLetters(boolean withUppercaseLetters) {
        this.withUppercaseLetters = withUppercaseLetters;
    }

    public boolean isWithSpecialSigns() {
        return withSpecialSigns;
    }

    public void setWithSpecialSigns(boolean withSpecialSigns) {
        this.withSpecialSigns = withSpecialSigns;
    }
}
