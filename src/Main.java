import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    // Declare GUI components
    private JCheckBox numbersCheckBox, lowerLettersCheckBox, upperLettersCheckBox, specialSignsCheckBox, uniqueCharacters;
    private JLabel lengthLabel, resultTextLabel, resultLabel;
    private JTextField lengthTextField;
    private JButton generateButton;
    private Generator gen = new Generator(30, true, true, true, true, true);
    private void gui(){
        // Set up JFrame
        setTitle("Password Generator");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

// Set up layout with 6 rows and 2 columns
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.insets = new Insets(0, 10, 0, 0); // Add left margin of 10dp

        GridBagLayout layout = (GridBagLayout) getContentPane().getLayout();
        layout.columnWeights = new double[]{1.0, 2.0};

// Create and add components
        constraints.gridx = 0; // Starting column index
        constraints.gridy = 0; // Row index
        constraints.gridwidth = 2; // Number of columns to span
        constraints.anchor = GridBagConstraints.WEST; // Checkbox alignment
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

        constraints.gridy = 5;
        constraints.gridwidth = 1; // Reset number of columns to 1
        lengthLabel = new JLabel("Length: ");
        add(lengthLabel, constraints);

        constraints.gridx = 1; // Move to next column
        lengthTextField = new JTextField();
        add(lengthTextField, constraints);

        constraints.gridy = 6;
        constraints.gridx = 0; // Move back to first column
        constraints.gridwidth = 1; // Reset number of columns to 1
        resultTextLabel = new JLabel("Password: ");
        add(resultTextLabel, constraints);

        constraints.gridx = 1; // Move to next column
        resultLabel = new JLabel();
        add(resultLabel, constraints);

        constraints.gridy = 7;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        generateButton = new JButton("Generate");
        add(generateButton, constraints);

        setFonts();
        setUpListeners();

        System.out.println(gen.generatePassword());
    }

    private void setFonts(){
        lengthLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        resultTextLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        numbersCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        lowerLettersCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        upperLettersCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        specialSignsCheckBox.setFont(new Font("Arial", Font.PLAIN, 20));
        uniqueCharacters.setFont(new Font("Arial", Font.PLAIN, 20));
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
            resultLabel.setText(gen.generatePassword());
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.gui();
        m.setVisible(true);
    }
}
