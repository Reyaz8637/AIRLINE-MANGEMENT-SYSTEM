
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Home extends JFrame implements ActionListener{
    
    public Home(){
        
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/front.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1400,700);  
        add(image);
        
        JLabel heading=new JLabel("AIR INDIA WELCOMES YOU");
        heading.setBounds(450, 40,1000,40);
        heading.setForeground(Color.BLUE);
        heading.setFont(new Font("Tahoma",Font.PLAIN,36));
        image.add(heading);
        
        //CREATING MENUBAR//
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details=new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightDetails=new JMenuItem("Flight Details");
        flightDetails.addActionListener(this);
        details.add(flightDetails);
        
        JMenuItem customerDetails=new JMenuItem("Add Customer Details");
        customerDetails.addActionListener(this);
        details.add(customerDetails);
        
        JMenuItem bookFlight=new JMenuItem("Book flight");
        details.add(bookFlight);
        
        JMenuItem journeyDetails=new JMenuItem(" journey details");
        details.add(journeyDetails);
        
        JMenuItem ticketCancellation=new JMenuItem("cancel ticket");
        details.add(ticketCancellation);
        
        JMenu ticket=new JMenu("ticket");
        menubar.add(ticket);
        
        JMenuItem boardingPass=new JMenuItem("Boarding Pass");
        ticket.add(boardingPass);
        
        

        setExtendedState(JFrame.MAXIMIZED_BOTH);//to get full Screen//
        
        setVisible(true); 
//        ActionListener Class override//
    }
        public void actionPerformed(ActionEvent ae){
        String text=ae.getActionCommand();
        
        if(text.equals("Add Customer Details")){
            new AddCustomer();
        }else if(text.equals("Flight Details")){
            new FlightInfo();
        }
                
    }
    public static void main(String args[]){
        new Home();
    }
}

