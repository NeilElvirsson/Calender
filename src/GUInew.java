import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.TextStyle;
import java.util.Locale;

public class GUInew {
    /*Gjorde om alla variablerna till arrayer istället
    Gjorde om TextField till TextArea för att kunna använda wraps
    Ändrat namnen från generella namn till specifika*/
    JTextArea[] inputText = new JTextArea[7];
    JButton[] eventButtons = new JButton[7];
    JPanel[] dayPanels = new JPanel[7];
    JLabel[] dayLabels = new JLabel[7];

    public GUInew() {
        JFrame frame = new JFrame("Calender");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 7));
        frame.add(new KlockPanel()); // Lägger till KlockPanel till höger

        LocalDate today = LocalDate.now();
        DayOfWeek currentDayOfWeek = today.getDayOfWeek();
        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, new Locale("sv", "SE"));
        LocalDate startOfWeek = today.minusDays(currentDayOfWeek.getValue() - 1);

        //For loopen för att skapa alla dagar istället för att hårdkoda ut allt
        for (int i = 0; i < 7; i++) {
            LocalDate date = startOfWeek.plusDays(i);
            //Hämtar getDayOfWeek för att slippa skriva en String med alla dagarna.
            String dayName = date.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("sv", "SE"));

            dayPanels[i] = new JPanel();
            dayPanels[i].setBackground(today.isEqual(date) ? new Color(152,255, 152) : Color.WHITE);
            dayPanels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));



            dayLabels[i] = new JLabel(dayName);
            dayPanels[i].add(dayLabels[i]);
            dayPanels[i].add(new JLabel(date.format(DateTimeFormatter.ofPattern("dd"))));
            dayPanels[i].add(new JLabel(monthName));
            //Ändrat bakgrunden och texten för att vara mer läsbart
            inputText[i] = new JTextArea(1,1);
            inputText[i].setBackground(Color.BLACK);
            inputText[i].setForeground(Color.WHITE);
            inputText[i].setLineWrap(true);
            inputText[i].setWrapStyleWord(true);
            dayPanels[i].add(inputText[i]);

            eventButtons[i] = new JButton("Skapa");
            dayPanels[i].add(eventButtons[i]);

            int index = i;
            eventButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String outputText = inputText[index].getText();
                    /*Gjorde om label till textarea för att kunna använda setLineWrap,
                    setWrapStyleWord och setEditable(false)
                     */
                    JTextArea outputTextArea = new JTextArea(outputText);
                    //Ändrat texten och bakgrunden för att bli mer läsbart
                    dayPanels[index].add(outputTextArea);
                    inputText[index].setText("");
                    // Tillägg att datumet visas före texten som man skrivet in för dagen.
                    outputTextArea.setText(date + ": " + outputText);
                    outputTextArea.setLineWrap(true);
                    outputTextArea.setWrapStyleWord(true);
                    outputTextArea.setEditable(false);
                    outputTextArea.setBackground(Color.black);
                    outputTextArea.setForeground(Color.WHITE);
                    dayPanels[index].repaint();
                    dayPanels[index].revalidate();
                }
            });
            frame.add(dayPanels[i]);
        }

        frame.setVisible(true);
    }
}
