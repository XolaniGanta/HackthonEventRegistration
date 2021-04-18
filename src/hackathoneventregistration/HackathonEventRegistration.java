/*
 * Xolani Ganta 2nd Year Project
 * Hackthon Event Registration
 * Students register on the app ,their details are then stored on a text document
 */

package hackathoneventregistration;

/**
 *
 * @author xolan
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class HackathonEventRegistration extends JFrame implements ActionListener{
    
    private JPanel panelNorth, panelWest, panelCenter, panelSouth;
    
    private ImageIcon image;
    private JLabel lblImage;
    private JLabel lblTitle;
    
    private JLabel lblStudentNumber;
    private JTextField txtStudentNumber;
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblProgramme;
    private JComboBox selectProgramme;
    private JLabel lblConnection;
    private JRadioButton connectionYes;
    private JRadioButton connectionNo;
    private ButtonGroup connection;
    private JLabel lblDevice;
    private JRadioButton deviceYes;
    private JRadioButton deviceNo;
    private ButtonGroup device;
    
    private JButton btnSave, btnClear, btnExit;
    private Font H;
    private Font ft;
    private Font ft2;
    
    
    public HackathonEventRegistration(){
        super("Hackathon Event Registration App version 1.0");
        
        panelNorth = new JPanel();
        panelWest = new JPanel();
        panelCenter = new JPanel();
        panelSouth = new JPanel();
        
        image = new ImageIcon(getClass().getResource("hacker.png"));
        lblImage = new JLabel(image);
        lblTitle = new JLabel("Hackathon Event Registration");
        
        lblStudentNumber = new JLabel("Student Number: ");
        txtStudentNumber = new JTextField();
        
        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new JTextField();
        
        lblLastName = new JLabel("Last Name: ");
        txtLastName = new JTextField();
        
        lblProgramme = new JLabel("Programme: ");
        selectProgramme = new JComboBox();
        selectProgramme.addItem("Applications Development");
        selectProgramme.addItem("Communication Networks");
        selectProgramme.addItem("Multimedia");
        
        lblConnection = new JLabel("Do you have access to a data or wifi connection: ");
        connectionYes = new JRadioButton("Yes");
        connectionNo = new JRadioButton("No");
        connection = new ButtonGroup();
        
        lblDevice = new JLabel("Do you have a device (PC or Laptop): ");
        deviceYes = new JRadioButton("Yes");
        deviceNo = new JRadioButton("No");
        device = new ButtonGroup();
        
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        
        H = new Font("Comic Sans", Font.CENTER_BASELINE, 30);
        ft = new Font("Arial", Font.PLAIN, 24);
        ft2 = new Font("Arial", Font.PLAIN,20);
         
        
        }
    
    public void setGUI(){
        Color blue = new Color(0,100,255);
        Color lightBlue = new Color(51,153,255);
        
        panelNorth.setLayout(new FlowLayout());
        panelNorth.setBackground(blue);
        panelWest.setLayout(new GridLayout(6,1));
        panelCenter.setLayout(null);
        panelCenter.setSize(500,300);
        panelWest.setBackground(lightBlue);
        panelCenter.setBackground(lightBlue);
        panelSouth.setLayout(new GridLayout(1,3));
        
        lblTitle.setFont(H);
        lblTitle.setForeground(Color.YELLOW);
        lblStudentNumber.setFont(ft);
        lblFirstName.setFont(ft);
        lblLastName.setFont(ft);
        lblProgramme.setFont(ft);
        lblConnection.setFont(ft);
        txtStudentNumber.setFont(ft2);
        txtFirstName.setFont(ft2);
        txtLastName.setFont(ft2);
        selectProgramme.setFont(ft2);
        connectionYes.setFont(ft2);
        connectionNo.setFont(ft2);
        lblDevice.setFont(ft);
        deviceYes.setFont(ft2);
        deviceNo.setFont(ft2);
        btnSave.setFont(ft);
        btnClear.setFont(ft);
        btnExit.setFont(ft);
        
        connectionYes.setBackground(lightBlue);
        connectionNo.setBackground(lightBlue);
        deviceYes.setBackground(lightBlue);
        deviceNo.setBackground(lightBlue);
        
        lblStudentNumber.setHorizontalAlignment(lblStudentNumber.RIGHT);
        lblFirstName.setHorizontalAlignment(lblFirstName.RIGHT);
        lblLastName.setHorizontalAlignment(lblLastName.RIGHT);
        lblProgramme.setHorizontalAlignment(lblProgramme.RIGHT);
        lblConnection.setHorizontalAlignment(lblConnection.RIGHT);
        lblDevice.setHorizontalAlignment(lblDevice.RIGHT);
        
        connection.add(connectionYes);
        connection.add(connectionNo);
        device.add(deviceYes);
        device.add(deviceNo);
        panelNorth.add(lblImage);
        panelNorth.add(lblTitle);
        
        panelWest.add(lblStudentNumber);
        panelWest.add(lblFirstName);
        panelWest.add(lblLastName);
        panelWest.add(lblProgramme);
        panelWest.add(lblConnection);
        panelWest.add(lblDevice);
        
        panelCenter.add(txtStudentNumber);
        txtStudentNumber.setBounds(0,0,400,30);
        panelCenter.add(txtFirstName);
        txtFirstName.setBounds(0,30,400,30);
        panelCenter.add(txtLastName);
        txtLastName.setBounds(0,60,400,30);
        panelCenter.add(selectProgramme);
        selectProgramme.setBounds(0,90,400,30);
        panelCenter.add(connectionYes);
        connectionYes.setBounds(60,120,60,25);
        panelCenter.add(connectionNo);
        connectionNo.setBounds(150,120,60,25);
        panelCenter.add(deviceYes);
        deviceYes.setBounds(60,150,60,25);
        panelCenter.add(deviceNo);
        deviceNo.setBounds(150,150,60,25);
        
        panelSouth.add(btnSave);
        panelSouth.add(btnClear);
        panelSouth.add(btnExit);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelWest, BorderLayout.WEST);
        this.add(panelCenter,BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setSize(1300,400);
    }

    public void storeDetails(){
        boolean count = false;
        JLabel countStudent = new JLabel();
        countStudent.setForeground(Color.RED);
        panelCenter.add(countStudent);
        countStudent.setBounds(400,0,400,30);
        
        JLabel countFirst = new JLabel();
        countFirst.setForeground(Color.RED);
        panelCenter.add(countFirst);
        countFirst.setBounds(400,30,400,30);
        
        JLabel countLast = new JLabel();
        countLast.setForeground(Color.RED);
        panelCenter.add(countLast);
        countLast.setBounds(400,60,400,30);
        
        if(txtStudentNumber.getText().isEmpty()){
            countStudent.setText("* Enter Student Number");
            count = false;
        }
        else{
            count = true;
        }
        if(txtFirstName.getText().isEmpty()){
            countFirst.setText("* Enter Your First Name");
            count = false;
        }
        else{
            count = true;
        }
        
        if(txtLastName.getText().isEmpty()){
            countLast.setText("* Enter Your Last");
            count = false;
        }
        else {
            count = true;
        }
        
    if (count == true){
        try{
            PrintWriter out = new PrintWriter(new FileWriter("Details.txt", true));
            out.println("Student Number: ");
            txtStudentNumber.write(out);
            out.println("\n" + "First Name: ");
            txtFirstName.write(out);
            out.println("\n" + "Last Name: ");
            txtLastName.write(out);
            
            
            out.println("\n" + "Programme: ");
            out.println(selectProgramme.getSelectedItem());
            
            out.println("\n" + "Connection: ");
            out.println(connection.getSelection());
            
            out.println("\n" + "Device: ");
            out.println(device.getSelection());
            
            JOptionPane.showMessageDialog(null, "Saved");
            
        }
        catch  (IOException e) {
            e.printStackTrace();
        }
        }
    else if(count == false){
            JOptionPane.showMessageDialog(null, "Not Saved");
        }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
       if (e.getActionCommand().equals("Save")){
           storeDetails();
           
       } 
       else if(e.getActionCommand().equals("Clear")){
           txtStudentNumber.setText("");
           txtFirstName.setText("");
           txtLastName.setText("");
           txtStudentNumber.requestFocus();
       }
       else if(e.getActionCommand().equals("Exit")){
           System.exit(0);
       }
    }

    
    public static void main(String[] args) {
        new HackathonEventRegistration().setGUI();
    }
    
}
