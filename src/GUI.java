import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {


    private JCheckBox numbersCheckBox, lowerLettersCheckBox, upperLettersCheckBox, specialSignsCheckBox, uniqueCharacters;
    private JLabel lengthLabel, resultTextLabel, resultLabel, errorLabel;
    private JTextField lengthTextField;
    private JButton generateButton;
    private Generator gen;
    private GridBagConstraints constraints;
    private final Font font;
    public GUI(){
        gen = new Generator(30, true, true, true, true, true);
        font = new Font("Arial", Font.PLAIN, 20);
    }

    private void setUpGUI(){
        setTitle("Password Generator");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.insets = new Insets(0, 20, 0, 20); // Add left margin of 10dp

        GridBagLayout layout = (GridBagLayout) getContentPane().getLayout();
        layout.columnWeights = new double[]{1.0, 2.0};

        setUpCheckboxes();
        setUpTextField();
        setUpLabels();
        setUpButton();

        setFonts();
        setUpListeners();

        setVisible(true);
    }

    private void setUpCheckboxes(){
        constraints.gridx = 0; // Starting column index
        constraints.gridy = 0; // Row index
        constraints.gridwidth = 2; // checkboxes will take 2 columns
        constraints.anchor = GridBagConstraints.WEST; // alignment
        numbersCheckBox = new JCheckBox("Numbers");
        numbersCheckBox.setSelected(true);
        add(numbersCheckBox, constraints);

        constraints.gridy = 1;
        lowerLettersCheckBox = new JCheckBox("Lowercase Letters");
        lowerLettersCheckBox.setSelected(true);
        add(lowerLettersCheckBox, constraints);

        constraints.gridy = 2;
        upperLettersCheckBox = new JCheckBox("Uppercase Letters");
        upperLettersCheckBox.setSelected(true);
        add(upperLettersCheckBox, constraints);

        constraints.gridy = 3;
        specialSignsCheckBox = new JCheckBox("Special Signs");
        specialSignsCheckBox.setSelected(true);
        add(specialSignsCheckBox, constraints);

        constraints.gridy = 4;
        uniqueCharacters = new JCheckBox("Only Unique Characters");
        uniqueCharacters.setSelected(true);
        add(uniqueCharacters, constraints);
    }

    private void setUpTextField(){
        constraints.gridy = 5;
        constraints.gridwidth = 1;
        constraints.gridx = 1; // second column
        lengthTextField = new JTextField();

        add(lengthTextField, constraints);
    }

    private void setUpLabels(){
        constraints.gridy = 5;
        constraints.gridx = 0;
        lengthLabel = new JLabel("Length: ");
        add(lengthLabel, constraints);

        constraints.gridy = 6;
        constraints.gridx = 0; // Move back to first column
        resultTextLabel = new JLabel("Password: ");
        add(resultTextLabel, constraints);

        constraints.gridx = 1; // Move to next column
        resultLabel = new JLabel();
        add(resultLabel, constraints);

        constraints.gridy = 8;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        add(errorLabel, constraints);
    }

    private void setUpButton(){
        constraints.gridy = 7;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        generateButton = new JButton("Generate");
        add(generateButton, constraints);

    }

    private void setFonts(){
        lengthLabel.setFont(font);
        resultLabel.setFont(font);
        resultTextLabel.setFont(font);
        errorLabel.setFont(font);

        numbersCheckBox.setFont(font);
        lowerLettersCheckBox.setFont(font);
        upperLettersCheckBox.setFont(font);
        specialSignsCheckBox.setFont(font);
        uniqueCharacters.setFont(font);
    }

    private void setUpListeners(){
        numbersCheckBox.addActionListener(this);
        lowerLettersCheckBox.addActionListener(this);
        upperLettersCheckBox.addActionListener(this);
        specialSignsCheckBox.addActionListener(this);
        generateButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // Handle actions
        if (e.getSource() == numbersCheckBox) {
            gen.setWithNumbers(numbersCheckBox.isSelected());
        } else if (e.getSource() == lowerLettersCheckBox) {
            gen.setWithLowercaseLetters(lowerLettersCheckBox.isSelected());
        } else if (e.getSource() == upperLettersCheckBox) {
            gen.setWithUppercaseLetters(upperLettersCheckBox.isSelected());
        } else if (e.getSource() == specialSignsCheckBox) {
            gen.setWithSpecialSigns(specialSignsCheckBox.isSelected());
        } else if (e.getSource() == uniqueCharacters) {
            gen.setOnlyUniqueCharacters(uniqueCharacters.isSelected());
        } else if (e.getSource() == generateButton) {
            try{
                int length = Integer.parseInt(lengthTextField.getText());
                if(uniqueCharacters.isSelected() && length > gen.calculateMaximumLength()){
                    errorLabel.setText("Too big length for these parameters!");
                    resultLabel.setText("");
                }else if(length <= 0){
                    errorLabel.setText("Length must be positive!");
                    resultLabel.setText("");
                }else if(length > 94){
                    errorLabel.setText("Try smaller length");
                    resultLabel.setText("");
                }else{
                    gen.setLength(length);
                    resultLabel.setText(gen.generatePassword());
                    errorLabel.setText("");
                }
            }catch (NumberFormatException exception){
                errorLabel.setText("Length must be a number!");
                resultLabel.setText("");
            }
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.setUpGUI();
    }
}
