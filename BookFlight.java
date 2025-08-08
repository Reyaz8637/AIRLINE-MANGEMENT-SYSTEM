package airlinemanagementsystem;
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookFlight extends JFrame implements ActionListener{
    JTextField tfaadhar;
    JLabel tfname,tfphone,tfnationality,tfaddress,labelgender;
   
    public BookFlight(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("BOOK FLIGHT");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Tahoma",Font.PLAIN,32));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblaadhar);
        
        tfaadhar=new JTextField();
        tfaadhar.setBounds(220,80,150,25);
        add(tfaadhar);
        
        JButton fetchButton=new JButton("fetch");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380,80,120,25);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblname);
        
        tfname=new JLabel();
        tfname.setBounds(220,130,150,25);
        add(tfname);
        
        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblnationality);
        
        tfnationality=new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbladdress);
        
        tfaddress=new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("gender");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblgender);
        
        labelgender = new JLabel("Gender");
        labelgender.setBounds(220,280,150,25);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lblsource);
        
        Choice source =new Choice();
        source.setBounds(220,330,150,25);
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(lbldest);
        
        Choice destination =new Choice();
        destination.setBounds(220,380,150,25);
        add(destination);
        
        try{
            Conn c=new Conn();
            String query="select * from flight";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
       
        
        JButton save=new JButton("SAVE");
        save.setBackground(Color.BLACK);
        save.setForeground(Color.WHITE);
        save.setBounds(220,380,150,25);
        save.addActionListener(this);
        add(save);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
        JLabel lblimage=new JLabel(image);
        lblimage.setBounds(450,80,280,400);
        add(lblimage);
        
        
        setSize(900,600);
        setLocation(250,80);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String nationality=tfnationality.getText();
        String phone=tfphone.getText();
        String address=tfaddress.getText();
        String aadhar=tfaadhar.getText();
        String gender=null;
        if(rbmale.isSelected()){
            gender = "Male";
        }else{
            gender="female";
        }
        try{
            Conn conn=new Conn();
            String query="insert into passenger values('"+name+"','"+nationality+"','"+aadhar+"','"+address+"','"+phone+"','"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"customer details added successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String args[]){
        new BookFlight();
    }
}
 
