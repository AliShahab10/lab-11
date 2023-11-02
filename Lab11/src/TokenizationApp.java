import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenizationApp {

    private static Map<String, String> wordToRootMap = new HashMap<>();
    private static List<String> arabicRoots = new ArrayList<>();
    private static List<String> tokenizedWords = new ArrayList<>();
    private static JComboBox<String> arabicRootComboBox;
    private static JComboBox<String> tokenizedWordComboBox;
    private static JTextArea resultTextArea;

    public static void main(String[] args) {
        wordToRootMap.put("عطي", "");
        wordToRootMap.put("رائحة", "");
        wordToRootMap.put("جميل", "");
        wordToRootMap.put("سعد", "");
        wordToRootMap.put("قلب", "");
        wordToRootMap.put("حزن", "");
        wordToRootMap.put("ورد", "");
        wordToRootMap.put("حمر", "");
        wordToRootMap.put("حديقة", "");
        wordToRootMap.put("فتح", "");
        wordToRootMap.put("ألوان", "");
        wordToRootMap.put("شرق", "");

        arabicRoots.addAll(wordToRootMap.keySet());

        JFrame frame = new JFrame("Tokenization Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea(10, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JButton tokenizeButton = new JButton("Tokenize");

        JPanel wordButtonsPanel = new JPanel();
        wordButtonsPanel.setLayout(new BoxLayout(wordButtonsPanel, BoxLayout.Y_AXIS));

        List<JButton> wordButtons = new ArrayList<>();

        resultTextArea = new JTextArea(10, 40);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);

        arabicRootComboBox = new JComboBox<>(arabicRoots.toArray(new String[arabicRoots.size()]));
        tokenizedWordComboBox = new JComboBox<>();

        JButton setRootButton = new JButton("Set Root");

        setRootButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        tokenizeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = textArea.getText();
                String[] words = inputText.split(" ");
                wordButtonsPanel.removeAll();
                wordButtons.clear();
                resultTextArea.setText("");
                tokenizedWords.clear();
                for (String word : words) {
                    tokenizedWords.add(word);
                    JButton wordButton = new JButton(word);
                    wordButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String selectedWord = wordButton.getText();
                            tokenizedWordComboBox.setSelectedItem(selectedWord);
                        }
                    });
                    wordButtons.add(wordButton);
                    wordButtonsPanel.add(wordButton);
                }
                DefaultComboBoxModel<String> tokenizedWordComboBoxModel = new DefaultComboBoxModel<>(tokenizedWords.toArray(new String[0]));
                tokenizedWordComboBox.setModel(tokenizedWordComboBoxModel);
                frame.revalidate();
                frame.repaint();
            }
        });

        frame.setLayout(new FlowLayout());
        frame.add(scrollPane);
        frame.add(tokenizeButton);
        frame.add(wordButtonsPanel);
        frame.add(resultScrollPane);
        frame.add(arabicRootComboBox);
        frame.add(tokenizedWordComboBox);
        frame.add(setRootButton);
        frame.setVisible(true);
    }

    private static void setRootForWord(String word, String root) {
        
    }
}
