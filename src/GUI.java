import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.TextStyle;
import java.util.Locale;
public class GUI {
 JTextField textField1;
      JTextField textField2;
    JTextField textField3;
    JTextField textField4;
    JTextField textField5;
    JTextField textField6;
    JTextField textField7;
 JPanel panel1;
 JPanel panel2;
      JPanel panel3;
      JPanel panel4;
      JPanel panel5;
      JPanel panel6;
      JPanel panel7;
      JButton button1;
      JButton button2;
      JButton button3;
      JButton button4;
      JButton button5;
      JButton button6;
      JButton button7;
      public GUI() {
        /*Creating a new frame, set its size, making it close on exit,adding a grid layout to our panels
        adding seven panels for each week of the day
        */

        JFrame frame = new JFrame("Calender");
        frame.setSize(1200, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(1, 7));

        LocalDate today = LocalDate.now();//Creates a local date objekt to represent todays date
        DayOfWeek currentDayOfWeek = today.getDayOfWeek(); //Current day of week holds the day of the week using today
        //Gets the month in string monthName, uses locale to convert to swedish
        String montName = today.getMonth().getDisplayName(TextStyle.FULL, new Locale("sv","SE"));


        /*Current day of week gets numeric value of the day, subtract with 1. If Wednesday is 3 subtract with 1
        we get 2. Today Wednesday(2) subtract with 2 we get 1 Numeric value of Monday
         */
        LocalDate startOfWeek = today.minusDays(currentDayOfWeek.getValue()-1);

            panel1 = new JPanel();//adds a new panel
            panel1.setSize(90, 500); //Set the size of our panel

            //if today i equal to start of week, set background color to cyan else set color to white
            if (today.isEqual(startOfWeek)) {
                panel1.setBackground(Color.CYAN);

            } else {
                panel1.setBackground(Color.WHITE);
            }
            //adds labels to our panel to print out date and month
           // panel1.add(new JLabel("Week " + startOfWeek.format(DateTimeFormatter.ofPattern("ww"))));
            panel1.add(new JLabel("Måndag"));
            panel1.add(new JLabel(startOfWeek.format(DateTimeFormatter.ofPattern("dd"))));
            panel1.add(new JLabel(montName));

            //Adds a text field to our panel
            textField1 = new JTextField(15);
            panel1.add(textField1);
            panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK)); //Adds a line border between our panels
            button1 = new JButton("Skapa");//Adds a button to our panel

            //<----------Panel2 ----------->
            panel2 = new JPanel();
            panel2.setSize(90, 500);
            // Adds Start of the week date (monday) and pluses it with one (tuesday)
            // Plus it with 2 (wednesday) and so on.
             LocalDate tuesdayDate = startOfWeek.plusDays(1);
             //If-statement to se if today is equal to tuesdayDate, if it is, set background color to cyan
            //Else, set background color to white
             if(today.isEqual(tuesdayDate)){
              panel2.setBackground(Color.CYAN);
             } else {
            panel2.setBackground(Color.WHITE);
             }
             panel2.add(new JLabel("Tisdag"));
             panel2.add(new JLabel(tuesdayDate.format(DateTimeFormatter.ofPattern("dd"))));
             panel2.add(new JLabel(montName));
             textField2 = (new JTextField(15));
            panel2.add(textField2);
            panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button2 = new JButton("Skapa");

             //<----------Panel3 ----------->
            panel3 = new JPanel();
            panel3.setSize(90, 500);

            LocalDate wednesdayDate = startOfWeek.plusDays(2);
            if(today.isEqual(wednesdayDate)){
                panel3.setBackground(Color.CYAN);
            }else{
                panel3.setBackground(Color.WHITE);
            }
            panel3.add(new JLabel("Onsdag"));
            panel3.add(new JLabel(wednesdayDate.format(DateTimeFormatter.ofPattern("dd"))));
            panel3.add(new JLabel(montName));
            textField3 = (new JTextField(15));
            panel3.add(textField3);
            panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button3 = new JButton("Skapa");

          //<----------Panel4 ----------->
            panel4 = new JPanel();
            panel4.setSize(90, 500);

            LocalDate thursdayDate = startOfWeek.plusDays(3);
            if(today.isEqual(thursdayDate)){
                panel4.setBackground(Color.CYAN);
            }else{
                panel4.setBackground(Color.WHITE);
            }
            panel4.add(new JLabel("Torsdag"));
            panel4.add(new JLabel(thursdayDate.format(DateTimeFormatter.ofPattern("dd"))));
            panel4.add(new JLabel(montName));
            textField4 = (new JTextField(15));
            panel4.add(textField4);
            panel4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button4 = new JButton("Skapa");

            //<----------Panel5 ----------->
            panel5 = new JPanel();
            panel5.setSize(90, 500);

            LocalDate fridayDate = startOfWeek.plusDays(4);

            if(today.isEqual(fridayDate)){
                panel5.setBackground(Color.CYAN);
            } else{
                panel5.setBackground(Color.WHITE);
            }
            panel5.add(new JLabel("Fredag"));
            panel5.add(new JLabel(fridayDate.format(DateTimeFormatter.ofPattern("dd"))));
            panel5.add(new JLabel(montName));
            textField5 = (new JTextField(15));
            panel5.add(textField5);
            panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             button5 = new JButton("Skapa");

            //<----------Panel6 ----------->
            panel6 = new JPanel();
            panel6.setSize(90, 500);

            LocalDate saturdayDate = startOfWeek.plusDays(5);
            if(today.isEqual(saturdayDate)){
                panel6.setBackground(Color.CYAN);
            }else {
                panel6.setBackground(Color.WHITE);
            }
            panel6.add(new JLabel("lördag"));
            panel6.add(new JLabel(saturdayDate.format(DateTimeFormatter.ofPattern("dd"))));
            panel6.add(new JLabel(montName));
            textField6 = (new JTextField(15));
            panel6.add(textField6);
            panel6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            button6 = new JButton("Skapa");

            //<----------Panel7 ----------->
            panel7 = new JPanel();
            panel7.setSize(90, 500);

            LocalDate sundayDate = startOfWeek.plusDays(6);
            if(today.isEqual(sundayDate)){
                panel7.setBackground(Color.CYAN);
            } else {
                panel7.setBackground(Color.WHITE);
            }
            panel7.add(new JLabel("Söndag"));
            panel7.add(new JLabel(sundayDate.format(DateTimeFormatter.ofPattern("dd"))));
            panel7.add(new JLabel(montName));
            textField7 = (new JTextField(15));
            panel7.add(textField7);
            panel7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             button7 = new JButton("Skapa");

             //Adding our panels to our frame
            frame.add(panel1);
            panel1.add(button1); //Adds button to our label
            frame.add(panel2);
            panel2.add(button2);
            frame.add(panel3);
            panel3.add(button3);
            frame.add(panel4);
            panel4.add(button4);
            frame.add(panel5);
            panel5.add(button5);
            frame.add(panel6);
            panel6.add(button6);
            frame.add(panel7);
            panel7.add(button7);

            //Adds action listener to our button
            button1.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String inputText1 = textField1.getText();//Adds string input text for saving user input
                        JLabel label1 = new JLabel("<html>" + inputText1 + "</html>"); //Adds a label to print out user input in panel
                        label1.setPreferredSize(new Dimension(90, 100));//Sets a preferred size of the labels
                        panel1.add(label1);//adds the label to our panel
                        textField1.setText(" ");
                        panel1.repaint();
                        panel1.revalidate();
                  }
            });

            button2.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String inputText2 = textField2.getText();
                        JLabel label2 = new JLabel("<html>" + inputText2 + "</html>");
                        label2.setPreferredSize(new Dimension(90, 100));
                        panel2.add(label2);
                        textField2.setText(" ");
                        panel1.repaint();
                        panel1.revalidate();
                  }
            });
            button3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText3 = textField3.getText();
                    JLabel label3 = new JLabel("<html>" + inputText3 + "</html>");
                    label3.setPreferredSize(new Dimension(90, 100));
                    panel3.add(label3);
                    textField3.setText(" ");
                    panel3.repaint();
                    panel3.revalidate();
                }
            });
            button4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText4 = textField4.getText();
                    JLabel label4 = new JLabel("<html>" + inputText4 + "</html>");
                    label4.setPreferredSize(new Dimension(90, 100));
                    panel4.add(label4);
                    textField4.setText(" ");
                    panel4.repaint();
                    panel4.revalidate();

                }
            });
            button5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText5 = textField5.getText();
                    JLabel label5 = new JLabel("<html>" + inputText5 + "</html>");
                    label5.setPreferredSize(new Dimension(90, 100));
                    panel5.add(label5);
                    textField5.setText(" ");
                    panel5.repaint();
                    panel5.revalidate();
                }
            });
            button6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText6 = textField6.getText();
                    JLabel label6 = new JLabel("<html>" + inputText6 + "</html>");
                    label6.setPreferredSize(new Dimension(90, 100));
                    panel6.add(label6);
                    textField6.setText(" ");
                    panel6.repaint();
                    panel6.revalidate();
                }
            });
            button7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String inputText7 = textField7.getText();
                    JLabel label7= new JLabel("<html>" + inputText7 + "</html>");
                    label7.setPreferredSize(new Dimension(90, 100));
                    panel7.add(label7);
                    textField7.setText(" ");
                    panel7.repaint();
                    panel7.revalidate();
                }
            });
            frame.revalidate();
        frame.setVisible(true);
    }
}
