import javax.swing.*;
import java.awt.*;

public class ListManual {

    JFrame frame;
    JButton close;

    public ListManual() {
        JMenuBar menuBar = new JMenuBar();
        close = new JButton("x");
        menuBar.add(close);

        frame = new JFrame("Manual");
        frame.setSize(700, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JTextArea textArea = new JTextArea();
        textArea.setText("""
                How to use Workout Memo

                Create a new memo
                1. Type in the text box
                2. Go to File on menu bar
                3. Click Save in the drop down list
                4. Name your file in .txt form in the Save As box
                5. Select the desired location to save a file
                6. Click Save

                Load up an existing memo
                1. Go to File on menu bar
                2. Click Open in the drop down list
                3. Select the txt file you left your memo on
                4. Click Open
                """);

        textArea.setBounds(50, 50, 500, 700);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(200, 200, 200));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setForeground(new Color(55, 55, 55));
        textArea.setFont(new Font("Arial", Font.BOLD, 15));
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        close.addActionListener(e -> frame.dispose());

        frame.add(scrollPane);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
}
