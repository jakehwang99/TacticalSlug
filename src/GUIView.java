import javax.swing.*;

public class GUIView {
    
    private JButton iAgree = new JButton("I Agree");
    private JTextArea area = new JTextArea();
    private JButton reset = new JButton("Reset");
    private JRadioButton p1 = new JRadioButton("Single");
    private JRadioButton p2 = new JRadioButton("Multiplayer");
    private JTextField field = new JTextField("Single under construction");

    public GUIView(){
        JFrame frame = new JFrame("TacticalSlug");
        frame.setBounds(100, 100, 700, 500);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
