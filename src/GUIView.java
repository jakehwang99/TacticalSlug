import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIView {

    public GUIView(){
        //main frame of GUI
        JFrame mainFrame = new JFrame("TacticalSlug");
        mainFrame.setBounds(100, 100, 700, 500);
        mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        //JPanel to for sign-in screen
        JPanel signin = new JPanel();
        signin.setLayout(null);

        //textpane with the name of the program
        JTextArea description = new JTextArea();
        //description.set

        //textarea with description of the program and the terms to using it


        //email text box


        //"i agree" button
        JButton iAgree = new JButton("I Agree");
        iAgree.setBounds((mainFrame.getWidth()/2)-40, 400, 80, 20 );

        signin.add(iAgree);

        //iAgree.setSize(new Dimension(30, 30));

        iAgree.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("he agress :D");
            }
        });


        mainFrame.getContentPane().add(signin);
        //set it visible
        mainFrame.setVisible(true);
    }
}
