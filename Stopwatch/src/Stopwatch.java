import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
//Martin Ambrož

public class Stopwatch implements ActionListener {
    JFrame frame = new JFrame("StopWatch");
    JButton btn_start = new JButton("Start");
    JButton btn_reset = new JButton("Reset");
    JButton btn_add = new JButton("Add");
    DefaultListModel listModel = new DefaultListModel();
    JList list = new JList(listModel);


    JLabel lbl_time = new JLabel();
    int elapsedTime =0;
    int seconds =0;
    int minutes = 0;
    int hours = 0;
    boolean started = false;
    String seconds_string = String.format("%02d",seconds);
    String minutes_string = String.format("%02d",minutes);
    String hours_string = String.format("%02d",hours);
    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
       elapsedTime = elapsedTime +1000;
       hours = (elapsedTime/3600000);
       minutes = (elapsedTime/60000)%60;
       seconds = (elapsedTime/1000)%60;
       seconds_string = String.format("%02d",seconds);
            minutes_string = String.format("%02d",minutes);
            hours_string = String.format("%02d",hours);
            lbl_time.setText(hours_string+":"+minutes_string+":"+seconds_string);


        }
    });

    Stopwatch()
{
    lbl_time.setText(hours_string+":"+minutes_string+":"+seconds_string);
    lbl_time.setBounds(100,100,200,100);
    lbl_time.setFont(new Font("Verdana",Font.PLAIN,35));
    lbl_time.setBorder(BorderFactory.createBevelBorder(1));
    lbl_time.setOpaque(true);
    lbl_time.setHorizontalAlignment(JTextField.CENTER);

    btn_start.setBounds(100,200,100,50);
    btn_start.setFocusable(false);
    btn_start.addActionListener(this);

    btn_reset.setBounds(200,200,100,50);
    btn_reset.setFocusable(false);
    btn_reset.addActionListener(this);

    btn_add.setBounds(150,250,100,50);
    btn_add.setFocusable(false);
    btn_add.addActionListener(this);

    list.setBounds(75,300,250,250);


frame.add(btn_reset);
frame.add(btn_start);
frame.add(btn_add);
frame.add(list);
    frame.add(lbl_time);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(480,620);
    frame.setLayout(null);
    frame.setVisible(true);
    frame.setResizable(false);
}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn_start) {
            if (started == false) {
                started = true;
                btn_start.setText("Stop");
                start();
            } else {
                started = false;
                btn_start.setText("Start");
                stop();
            }
        }

if(e.getSource()==btn_reset)
{started=false;
    btn_start.setText("Start");
reset();
    }

if(e.getSource()==btn_add)
{
    listModel.addElement(hours_string+":"+minutes_string+":"+seconds_string);
}
    }

    void start()
        {
timer.start();
        }
void stop()
{
    timer.stop();
}
void reset()
{timer.stop();
elapsedTime=0;
seconds=0;
minutes=0;
hours=0;
    seconds_string = String.format("%02d",seconds);
    minutes_string = String.format("%02d",minutes);
    hours_string = String.format("%02d",hours);
    lbl_time.setText(hours_string+":"+minutes_string+":"+seconds_string);
    listModel.clear();

}
}
