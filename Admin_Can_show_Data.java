package student_management_system;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author mcmta
 */
public class Admin_Can_show_Data extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Admin_Can_show_Data.class.getName());

    // Database Credentials
    private static final String URL = "jdbc:mysql://localhost:3306/student_management_system";
    private static final String USER = "root";
    private static final String PASSWORD = "@ajay45";

    // Controls the starting X position of your scrolling text
    private int marqueeX = 1200;
    
    /**
     * Creates new form Admin_Can_show_Data
     */
    public Admin_Can_show_Data() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Maximizes the window
        
        // ==========================================
        // CUSTOM FONT & COLOR FOR "USER ID" COLUMN
        // ==========================================
        javax.swing.table.DefaultTableCellRenderer uidRenderer = new javax.swing.table.DefaultTableCellRenderer();
        uidRenderer.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16));
        uidRenderer.setForeground(new java.awt.Color(255, 0, 0)); 
        
        jTable1.getColumnModel().getColumn(0).setCellRenderer(uidRenderer);
        jTable2.getColumnModel().getColumn(0).setCellRenderer(uidRenderer);
        
        jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        jTable2.getTableHeader().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 14));
        
        // ==========================================
        // --- BULLETPROOF MARQUEE FIX ---
        // ==========================================
        
        // 1. Make the panel TALLER (80px) and WIDER (1920+ px) for large screens
        jPanel1.setPreferredSize(new java.awt.Dimension(2500, 80)); 
        jPanel1.setMinimumSize(new java.awt.Dimension(1200, 80));
        
        // 2. Disable NetBeans layout control for this specific panel
        jPanel1.setLayout(null); 
        
        // 3. Make the label MASSIVE so the text never gets cut off
        jLabelCOLLEGE_NAME.setSize(2000, 60); 
        
        startMarquee();
        
        // Load data into both tables when the window opens
        loadStudentData();
        loadTeacherData();
    }
    
    private void startMarquee() {
        javax.swing.Timer timer = new javax.swing.Timer(15, new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                marqueeX -= 3; 
                
                // Once the long text moves completely off the left side
                if (marqueeX < -2000) {
                    // Send it back to the far right side using the main window's width
                    marqueeX = getWidth(); 
                }
                
                // Lock it at Y=10 so it stays perfectly vertically centered inside the taller panel
                jLabelCOLLEGE_NAME.setLocation(marqueeX, 10);
            }
        });
        timer.start();
    }

    // ==========================================
    // DATABASE LOADING METHODS
    // ==========================================
    
    private void loadStudentData() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        
        String query = "SELECT user_id, first_name, last_name, department, mobile FROM students";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                model.addRow(new Object[]{
                    rs.getString("user_id"),
                    fullName,
                    rs.getString("department"), // Used as 'Course' here
                    rs.getString("mobile")
                });
            }
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading Student Data: " + ex.getMessage());
        }
    }

    private void loadTeacherData() {
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); 
        
        String query = "SELECT user_id, first_name, last_name, department, mobile FROM teachers";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                model.addRow(new Object[]{
                    rs.getString("user_id"),
                    fullName,
                    rs.getString("department"),
                    rs.getString("mobile")
                });
            }
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Error loading Teacher Data: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelCOLLEGE_NAME = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        SEARCH_STUDENT = new javax.swing.JLabel();
        INPUT_STUDENT = new javax.swing.JTextField();
        STUDENT_SEARCH_BTN = new javax.swing.JButton();
        SEARCH_TEACHER = new javax.swing.JLabel();
        INPUT_TEACHER = new javax.swing.JTextField();
        TEACHER_SEARCH_BTN = new javax.swing.JButton();
        TEACHER_REFRESH = new javax.swing.JButton();
        STUDENT_REFRESH = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lOGO_BANNER_SHOW.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelCOLLEGE_NAME.setFont(new java.awt.Font("Tahoma", 1, 21)); // NOI18N
        jLabelCOLLEGE_NAME.setForeground(new java.awt.Color(255, 51, 51));
        jLabelCOLLEGE_NAME.setText("MICROTEK COLLEGE OF MANAGEMENT & TECHNOLOGY SANKAT MOCHAN, DURGAKUND, VARANASI, UTTAR PRADESH - 221005");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabelCOLLEGE_NAME)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabelCOLLEGE_NAME)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "USER ID", "NAME", "COURSE", "MOBILE NO."
            }
        ));
        jTable1.setGridColor(new java.awt.Color(211, 211, 211));
        jTable1.setRowHeight(30);
        jTable1.setRowSelectionAllowed(false);
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable1.setShowGrid(true);
        jScrollPane1.setViewportView(jTable1);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "USER ID", "NAME", "DEPARTMENT", "MOBILE NO."
            }
        ));
        jTable2.setRowHeight(30);
        jTable2.setRowSelectionAllowed(false);
        jTable2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTable2.setShowGrid(true);
        jScrollPane2.setViewportView(jTable2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        SEARCH_STUDENT.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SEARCH_STUDENT.setText("SEARCH BY STUDENT ID : ");

        INPUT_STUDENT.setBackground(new java.awt.Color(108, 122, 137));
        INPUT_STUDENT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INPUT_STUDENT.setForeground(new java.awt.Color(228, 241, 254));
        INPUT_STUDENT.addActionListener(this::INPUT_STUDENTActionPerformed);

        STUDENT_SEARCH_BTN.setBackground(new java.awt.Color(153, 255, 102));
        STUDENT_SEARCH_BTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        STUDENT_SEARCH_BTN.setForeground(new java.awt.Color(255, 255, 255));
        STUDENT_SEARCH_BTN.setText("SEARCH");
        STUDENT_SEARCH_BTN.addActionListener(this::STUDENT_SEARCH_BTNActionPerformed);

        SEARCH_TEACHER.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        SEARCH_TEACHER.setText("SEARCH BY TEACHER ID : ");

        INPUT_TEACHER.setBackground(new java.awt.Color(108, 122, 137));
        INPUT_TEACHER.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        INPUT_TEACHER.setForeground(new java.awt.Color(228, 241, 254));
        INPUT_TEACHER.addActionListener(this::INPUT_TEACHERActionPerformed);

        TEACHER_SEARCH_BTN.setBackground(new java.awt.Color(153, 255, 102));
        TEACHER_SEARCH_BTN.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TEACHER_SEARCH_BTN.setForeground(new java.awt.Color(255, 255, 255));
        TEACHER_SEARCH_BTN.setText("SEARCH");
        TEACHER_SEARCH_BTN.addActionListener(this::TEACHER_SEARCH_BTNActionPerformed);

        TEACHER_REFRESH.setBackground(new java.awt.Color(34, 167, 240));
        TEACHER_REFRESH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        TEACHER_REFRESH.setForeground(new java.awt.Color(255, 255, 255));
        TEACHER_REFRESH.setText("REFRESH");
        TEACHER_REFRESH.addActionListener(this::TEACHER_REFRESHActionPerformed);

        STUDENT_REFRESH.setBackground(new java.awt.Color(34, 167, 240));
        STUDENT_REFRESH.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        STUDENT_REFRESH.setForeground(new java.awt.Color(255, 255, 255));
        STUDENT_REFRESH.setText("REFRESH");
        STUDENT_REFRESH.addActionListener(this::STUDENT_REFRESHActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(SEARCH_STUDENT)
                .addGap(18, 18, 18)
                .addComponent(INPUT_STUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(SEARCH_TEACHER)
                .addGap(33, 33, 33)
                .addComponent(INPUT_TEACHER, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(223, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(STUDENT_SEARCH_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(STUDENT_REFRESH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TEACHER_SEARCH_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(TEACHER_REFRESH)
                .addGap(282, 282, 282))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SEARCH_STUDENT)
                    .addComponent(INPUT_STUDENT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SEARCH_TEACHER)
                    .addComponent(INPUT_TEACHER, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TEACHER_SEARCH_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(STUDENT_SEARCH_BTN, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(STUDENT_REFRESH, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TEACHER_REFRESH, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 56, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 735, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void STUDENT_SEARCH_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENT_SEARCH_BTNActionPerformed
        String searchId = INPUT_STUDENT.getText().trim();
        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Student ID to search.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        
        String query = "SELECT user_id, first_name, last_name, department, mobile FROM students WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, searchId);
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                    model.addRow(new Object[]{
                        rs.getString("user_id"),
                        fullName,
                        rs.getString("department"),
                        rs.getString("mobile")
                    });
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "No student found with ID: " + searchId);
                    loadStudentData();
                }
            }
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_STUDENT_SEARCH_BTNActionPerformed

    private void STUDENT_REFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STUDENT_REFRESHActionPerformed
        INPUT_STUDENT.setText("");
        loadStudentData();
    }//GEN-LAST:event_STUDENT_REFRESHActionPerformed

    private void TEACHER_SEARCH_BTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEACHER_SEARCH_BTNActionPerformed
        String searchId = INPUT_TEACHER.getText().trim();
        if (searchId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Teacher ID to search.");
            return;
        }

        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0); 
        
        String query = "SELECT user_id, first_name, last_name, department, mobile FROM teachers WHERE user_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, searchId);
            try (ResultSet rs = pstmt.executeQuery()) {
                boolean found = false;
                while (rs.next()) {
                    found = true;
                    String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
                    model.addRow(new Object[]{
                        rs.getString("user_id"),
                        fullName,
                        rs.getString("department"),
                        rs.getString("mobile")
                    });
                }
                if (!found) {
                    JOptionPane.showMessageDialog(this, "No teacher found with ID: " + searchId);
                    loadTeacherData();
                }
            }
        } catch (SQLException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_TEACHER_SEARCH_BTNActionPerformed

    private void TEACHER_REFRESHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEACHER_REFRESHActionPerformed
        INPUT_TEACHER.setText("");
        loadTeacherData();
    }//GEN-LAST:event_TEACHER_REFRESHActionPerformed

    private void INPUT_TEACHERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_TEACHERActionPerformed
        TEACHER_SEARCH_BTNActionPerformed(evt);
    }//GEN-LAST:event_INPUT_TEACHERActionPerformed

    private void INPUT_STUDENTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_INPUT_STUDENTActionPerformed
        STUDENT_SEARCH_BTNActionPerformed(evt);
    }//GEN-LAST:event_INPUT_STUDENTActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Admin_Can_show_Data().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField INPUT_STUDENT;
    private javax.swing.JTextField INPUT_TEACHER;
    private javax.swing.JLabel SEARCH_STUDENT;
    private javax.swing.JLabel SEARCH_TEACHER;
    private javax.swing.JButton STUDENT_REFRESH;
    private javax.swing.JButton STUDENT_SEARCH_BTN;
    private javax.swing.JButton TEACHER_REFRESH;
    private javax.swing.JButton TEACHER_SEARCH_BTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCOLLEGE_NAME;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
