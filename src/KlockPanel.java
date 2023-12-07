import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
// La till en klocka in i kalendern och gjorde en klassfil för den.
public class KlockPanel extends JPanel {
    public KlockPanel() {
        setBackground(Color.black); // Sätter en svart bakgrund
        JTextArea clockText = new JTextArea();
        clockText.setBackground(Color.black);
        clockText.setForeground(Color.WHITE);
        clockText.setFont(new Font("Arial", Font.BOLD, 30));
        clockText.setLineWrap(true);

        // Timer som uppdaterar klockan varje sekund
        new Timer(1000, e -> updateClock(clockText)).start();
        add(clockText);
    }

    private void updateClock(JTextArea clockText) {
        String time = DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now());
        clockText.setText("Time\n" + time);
    }
}
