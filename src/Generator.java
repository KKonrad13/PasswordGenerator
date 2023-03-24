import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
    private boolean onlyUniqueCharacters;

    private final Random random;

    public Generator(int length, boolean withNumbers, boolean withLowercaseLetters, boolean withUppercaseLetters, boolean withSpecialSigns, boolean onlyUniqueCharacters) {
        this.length = length;
        this.withNumbers = withNumbers;
        this.withLowercaseLetters = withLowercaseLetters;
        this.withUppercaseLetters = withUppercaseLetters;
        this.withSpecialSigns = withSpecialSigns;
        this.onlyUniqueCharacters = onlyUniqueCharacters;
        this.random = new Random();
    }

    public String generatePassword(){
        return onlyUniqueCharacters? uniqueCharsPassword() : notUniqueCharsPassowrd();
    }

    private String uniqueCharsPassword(){

        StringBuilder sb = new StringBuilder();
        Set<Character> characters = new HashSet<>();
        int option;
        while(characters.size() < length){
            option = random.nextInt(4);
            switch (option){
                case 0:
                    if(withNumbers)
                        characters.add(randomNumber());
                    break;
                case 1:
                    if(withLowercaseLetters)
                        characters.add(randomLowercaseLetter());
                    break;
                case 2:
                    if(withUppercaseLetters)
                        characters.add(randomUppercaseLetter());
                    break;
                case 3:
                    if(withSpecialSigns)
                        characters.add(randomSpecialSign());
                    break;
            }
        }

        for (Character entry : characters){
            sb.insert(random.nextInt(sb.length() + 1), entry);
        }

        return sb.toString();
    }

    private String notUniqueCharsPassowrd(){

        StringBuilder sb = new StringBuilder();
        int option;
        while(sb.length() < length){
            option = random.nextInt(4);
            switch (option){
                case 0:
                    if(withNumbers)
                        sb.append(randomNumber());
                    break;
                case 1:
                    if(withLowercaseLetters)
                        sb.append(randomLowercaseLetter());
                    break;
                case 2:
                    if(withUppercaseLetters)
                        sb.append(randomUppercaseLetter());
                    break;
                case 3:
                    if(withSpecialSigns)
                        sb.append(randomSpecialSign());
                    break;
            }
        }

        return sb.toString();
    }

    private char randomLowercaseLetter(){
        return lowercaseLetters[random.nextInt(lowercaseLetters.length)];
    }

    private char randomUppercaseLetter(){
        return uppercaseLetters[random.nextInt(uppercaseLetters.length)];
    }

    private char randomSpecialSign(){
        return specialSigns[random.nextInt(specialSigns.length)];
    }
    private char randomNumber(){
        return numbers[random.nextInt(numbers.length)];
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

    public boolean isOnlyUniqueCharacters() {
        return onlyUniqueCharacters;
    }

    public void setOnlyUniqueCharacters(boolean onlyUniqueCharacters) {
        this.onlyUniqueCharacters = onlyUniqueCharacters;
    }
}
