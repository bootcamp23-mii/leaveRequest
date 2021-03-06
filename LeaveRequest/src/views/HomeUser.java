/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.CutiController;
import controllers.CutiControllerInterface;
import controllers.EmailController;
import controllers.EmailInterface;
import controllers.JenisCutiController;
import controllers.JenisCutiInterface;
import controllers.KaryawanController;
import controllers.KaryawanInterface;
import controllers.StatusPengajuanController;
import controllers.StatusPengajuanInterface;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import mainTools.DBConnection;
import mainTools.HibernateUtil;
import models.JenisCuti;
import models.Karyawan;
import models.SendEmailTemp;
import models.Session;
import org.hibernate.SessionFactory;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pandu
 */
public class HomeUser extends javax.swing.JInternalFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private SessionFactory factory = HibernateUtil.getSessionFactory();
//    JDesktopPane desktop;
//    CONTROLLER
    DBConnection connection = new DBConnection();
    private final CutiControllerInterface cc = new CutiController(factory);
    private final JenisCutiInterface jc = new JenisCutiController(factory);
    private final KaryawanInterface kc = new KaryawanController(factory);
    private final StatusPengajuanInterface spc = new StatusPengajuanController(factory);
//    private CutiController cc = new CutiControllerInterface(factory, new Pengajuan());
    DefaultTableModel myTable = new DefaultTableModel();
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    EmailInterface emailInterface = new EmailController();

    String var = Session.getId();
    String username = kc.getById(var).getNama();

    /**
     * Creates new form Home
     */
    public HomeUser() {
        initComponents();
        getRidTheBar();
        setColor(btnHome);
        getTheDamnPhotos();
        userCutiInit();
        //CONTENT BASED SESSION CONTROLL
    }

    private void userCutiInit() {
//        PANEL CONTROLLER

        if (kc.getById(var).getJobs().getId().equals("J0")) {
            pnAdmin.setVisible(true);
            pnMenu.setVisible(false);
            pnManager.setVisible(false);
            pnHome.setVisible(false);
            pnUser.setVisible(false);
            pnRequest.setVisible(false);
            pnHistory.setVisible(false);

            for (Karyawan karyawan : kc.getByJob("J2")) {
                cbGetManager.addItem(karyawan.getId());
            }

            tableAll(kc.getAll());
        } else if (kc.getById(var).getJobs().getId().equals("J2")) {
            pnAdmin.setVisible(false);
            pnHome.setVisible(true);
            pnUser.setVisible(false);
            pnHistory.setVisible(false);
            pnRequest.setVisible(false);
            pnManager.setVisible(false);
            btnManager.setVisible(true);
        } else {
            pnAdmin.setVisible(false);
            pnHome.setVisible(true);
            pnUser.setVisible(false);
            pnHistory.setVisible(false);
            pnRequest.setVisible(false);
            pnManager.setVisible(false);
            btnManager.setVisible(false);
        }

        lbCurrentDate.setText(dateFormat.format(date));

//        COMBO BOX CONTROLLER
        for (JenisCuti jenisCuti : jc.getAll("")) {
            cbJenisCuti.addItem(jenisCuti.getId() + " - " + jenisCuti.getJenis());
        }

//        GIMMICK CONTROLLER
        for (Karyawan karyawan : kc.getIdKar(var)) {
            lbDescriptionUserName.setText(karyawan.getNama());
            sisaCutiCounter.setText(karyawan.getJumlahcuti().toString());
        }

        for (Karyawan karyawan : kc.getIdKar(var)) {
            if (karyawan.getIdmanager() != null) {
                lbDescriptionManager.setText("Managed by " + karyawan.getIdmanager().getNama());
            } else {
                lbDescriptionManager.setText("Ultra Supervisor");
            }
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

        pnAdmin = new javax.swing.JPanel();
        pnSignUp = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        tfRegFirstName = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfRegLastName = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        tfRegEmail = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        cbRegMarried = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbRegGender = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        tfRegUsername = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        tfRegPass1 = new javax.swing.JPasswordField();
        tfRegPass2 = new javax.swing.JPasswordField();
        btRegSignUp = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAllUser = new javax.swing.JTable();
        btnDeleteUser = new javax.swing.JButton();
        cbJobs = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        btSelectImage = new javax.swing.JButton();
        tfLocationFile = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        cbGetManager = new javax.swing.JComboBox<>();
        btUpdateUser = new javax.swing.JButton();
        pnAllUser = new javax.swing.JPanel();
        pnMenu = new javax.swing.JPanel();
        btnHome = new javax.swing.JPanel();
        ind_1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnUser = new javax.swing.JPanel();
        ind_3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnRequest = new javax.swing.JPanel();
        ind_4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnHistory = new javax.swing.JPanel();
        ind_2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnManager = new javax.swing.JPanel();
        ind_5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        pnBar = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btExit = new javax.swing.JLabel();
        pnDescription = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbCurrentDate = new javax.swing.JLabel();
        profilePic = new javax.swing.JLabel();
        lbDescriptionUserName = new javax.swing.JLabel();
        lbDescriptionManager = new javax.swing.JLabel();
        dynamicPane = new javax.swing.JLayeredPane();
        pnHome = new javax.swing.JPanel();
        pnHomeHeader = new javax.swing.JPanel();
        pnHomeContent = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        sisaCutiCounter = new javax.swing.JLabel();
        pnUser = new javax.swing.JPanel();
        pnUserHeader = new javax.swing.JPanel();
        pnUserContent = new javax.swing.JPanel();
        tfUserName = new javax.swing.JTextField();
        tfUserEmail = new javax.swing.JTextField();
        tfUserID = new javax.swing.JTextField();
        tfUserPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btUserUpdate = new javax.swing.JButton();
        tfIdManager = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cbMarital = new javax.swing.JComboBox<>();
        cbGender = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        tfLeaveLeft = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfJobsTitle = new javax.swing.JTextField();
        pnRequest = new javax.swing.JPanel();
        btUserSubmitRequest = new javax.swing.JButton();
        cbJenisCuti = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfUserTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        dcStart = new com.toedter.calendar.JDateChooser();
        dcEnd = new com.toedter.calendar.JDateChooser();
        jLabel14 = new javax.swing.JLabel();
        pnCntentFill = new javax.swing.JPanel();
        btCancel = new javax.swing.JLabel();
        tfSelectedRequest = new javax.swing.JTextField();
        tfSelectedRequestDesc = new javax.swing.JTextField();
        tfSelectedRequestStatus = new javax.swing.JTextField();
        tfSelectedRequestDate = new javax.swing.JTextField();
        tfSelectedRequestPengajuan = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbRequestStatus = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnHistory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHistory = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        pnManager = new javax.swing.JPanel();
        pnUserHeader1 = new javax.swing.JPanel();
        btReport = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        pnUserContent1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbManagerUserRequest = new javax.swing.JTable();
        tfSelectedUser = new javax.swing.JTextField();
        btManagerReject = new javax.swing.JButton();
        btManagerAccept = new javax.swing.JButton();
        strID = new javax.swing.JTextField();
        strDate = new javax.swing.JTextField();
        strRequestId = new javax.swing.JTextField();
        strType = new javax.swing.JTextField();
        strDesc = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnAdmin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnSignUp.setBackground(new java.awt.Color(255, 255, 255));
        pnSignUp.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel22.setText("First Name");
        pnSignUp.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, -1));

        tfRegFirstName.setBackground(new java.awt.Color(120, 168, 252));
        tfRegFirstName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfRegFirstName.setForeground(new java.awt.Color(255, 255, 255));
        tfRegFirstName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfRegFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 170, 30));

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel23.setText("Last Name");
        pnSignUp.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 140, -1));

        tfRegLastName.setBackground(new java.awt.Color(120, 168, 252));
        tfRegLastName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfRegLastName.setForeground(new java.awt.Color(255, 255, 255));
        tfRegLastName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfRegLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 170, 30));

        jLabel24.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel24.setText("Email");
        pnSignUp.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, -1));

        tfRegEmail.setBackground(new java.awt.Color(120, 168, 252));
        tfRegEmail.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfRegEmail.setForeground(new java.awt.Color(255, 255, 255));
        tfRegEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfRegEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 170, 30));

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel25.setText("Married Status");
        pnSignUp.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 100, -1));

        cbRegMarried.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SN1 - Single", "SN2 - Married" }));
        pnSignUp.add(cbRegMarried, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 90, 170, 30));

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel26.setText("Gender");
        pnSignUp.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, 154, -1));

        cbRegGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita" }));
        pnSignUp.add(cbRegGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 170, 30));

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel27.setText("ID Manager");
        pnSignUp.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 90, 20));

        tfRegUsername.setEditable(false);
        tfRegUsername.setBackground(new java.awt.Color(120, 168, 252));
        tfRegUsername.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfRegUsername.setForeground(new java.awt.Color(204, 204, 204));
        tfRegUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfRegUsername.setText("AUTO GENERATED");
        tfRegUsername.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfRegUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 30, 170, 30));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel28.setText("Re-Type Password");
        pnSignUp.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 162, -1));

        tfRegPass1.setBackground(new java.awt.Color(120, 168, 252));
        tfRegPass1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfRegPass1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfRegPass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 170, 30));

        tfRegPass2.setBackground(new java.awt.Color(120, 168, 252));
        tfRegPass2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfRegPass2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfRegPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 170, 30));

        btRegSignUp.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btRegSignUp.setText("SIGN UP");
        btRegSignUp.setBorder(null);
        btRegSignUp.setBorderPainted(false);
        btRegSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegSignUpActionPerformed(evt);
            }
        });
        pnSignUp.add(btRegSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 80, 42));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel29.setText("ID");
        pnSignUp.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 90, 20));

        tbAllUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbAllUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAllUserMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbAllUser);

        pnSignUp.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 630, 210));

        btnDeleteUser.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btnDeleteUser.setForeground(new java.awt.Color(0, 0, 0));
        btnDeleteUser.setText("REMOVE USER");
        btnDeleteUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        pnSignUp.add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 480, 170, 50));

        cbJobs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "J1 - Direktur", "J2 - Manager", "J3 - Developer", "J0 - Admin" }));
        pnSignUp.add(cbJobs, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 30));

        jLabel32.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel32.setText("Position");
        pnSignUp.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 162, 20));

        btSelectImage.setText("SELECT");
        btSelectImage.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelectImageActionPerformed(evt);
            }
        });
        pnSignUp.add(btSelectImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 50, 30));

        tfLocationFile.setBackground(new java.awt.Color(120, 168, 252));
        tfLocationFile.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tfLocationFile.setForeground(new java.awt.Color(255, 255, 255));
        tfLocationFile.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        pnSignUp.add(tfLocationFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 110, 30));

        jLabel33.setText("Photos");
        pnSignUp.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel35.setText("Password");
        pnSignUp.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 162, -1));

        cbGetManager.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        pnSignUp.add(cbGetManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 170, 30));

        btUpdateUser.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btUpdateUser.setText("UPDATE");
        btUpdateUser.setBorder(null);
        btUpdateUser.setBorderPainted(false);
        btUpdateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUpdateUserActionPerformed(evt);
            }
        });
        pnSignUp.add(btUpdateUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, 80, 42));

        pnAdmin.add(pnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 580));

        javax.swing.GroupLayout pnAllUserLayout = new javax.swing.GroupLayout(pnAllUser);
        pnAllUser.setLayout(pnAllUserLayout);
        pnAllUserLayout.setHorizontalGroup(
            pnAllUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        pnAllUserLayout.setVerticalGroup(
            pnAllUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        pnAdmin.add(pnAllUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 650, 350));

        getContentPane().add(pnAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 650, 580));

        pnMenu.setBackground(new java.awt.Color(23, 35, 51));
        pnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnHome.setBackground(new java.awt.Color(23, 35, 51));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHomeMousePressed(evt);
            }
        });

        ind_1.setOpaque(false);
        ind_1.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_1Layout = new javax.swing.GroupLayout(ind_1);
        ind_1.setLayout(ind_1Layout);
        ind_1Layout.setHorizontalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_1Layout.setVerticalGroup(
            ind_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Home");

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel8)
                .addGap(0, 79, Short.MAX_VALUE))
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addComponent(ind_1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMenu.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 150, -1));

        btnUser.setBackground(new java.awt.Color(23, 35, 51));
        btnUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUserMousePressed(evt);
            }
        });

        ind_3.setOpaque(false);
        ind_3.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_3Layout = new javax.swing.GroupLayout(ind_3);
        ind_3.setLayout(ind_3Layout);
        ind_3Layout.setHorizontalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_3Layout.setVerticalGroup(
            ind_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Users");

        javax.swing.GroupLayout btnUserLayout = new javax.swing.GroupLayout(btnUser);
        btnUser.setLayout(btnUserLayout);
        btnUserLayout.setHorizontalGroup(
            btnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUserLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel10)
                .addGap(0, 84, Short.MAX_VALUE))
        );
        btnUserLayout.setVerticalGroup(
            btnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnUserLayout.createSequentialGroup()
                .addComponent(ind_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnUserLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMenu.add(btnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 150, -1));

        btnRequest.setBackground(new java.awt.Color(23, 35, 51));
        btnRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRequestMousePressed(evt);
            }
        });

        ind_4.setOpaque(false);
        ind_4.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_4Layout = new javax.swing.GroupLayout(ind_4);
        ind_4.setLayout(ind_4Layout);
        ind_4Layout.setHorizontalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_4Layout.setVerticalGroup(
            ind_4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Add Request");

        javax.swing.GroupLayout btnRequestLayout = new javax.swing.GroupLayout(btnRequest);
        btnRequest.setLayout(btnRequestLayout);
        btnRequestLayout.setHorizontalGroup(
            btnRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRequestLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel11)
                .addGap(0, 45, Short.MAX_VALUE))
        );
        btnRequestLayout.setVerticalGroup(
            btnRequestLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRequestLayout.createSequentialGroup()
                .addComponent(ind_4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnRequestLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMenu.add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 150, -1));

        btnHistory.setBackground(new java.awt.Color(23, 35, 51));
        btnHistory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnHistoryMouseReleased(evt);
            }
        });

        ind_2.setOpaque(false);
        ind_2.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_2Layout = new javax.swing.GroupLayout(ind_2);
        ind_2.setLayout(ind_2Layout);
        ind_2Layout.setHorizontalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_2Layout.setVerticalGroup(
            ind_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("History and Request");

        javax.swing.GroupLayout btnHistoryLayout = new javax.swing.GroupLayout(btnHistory);
        btnHistory.setLayout(btnHistoryLayout);
        btnHistoryLayout.setHorizontalGroup(
            btnHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHistoryLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel9)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        btnHistoryLayout.setVerticalGroup(
            btnHistoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHistoryLayout.createSequentialGroup()
                .addComponent(ind_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnHistoryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMenu.add(btnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 150, -1));

        btnManager.setBackground(new java.awt.Color(23, 35, 51));
        btnManager.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnManagerMouseClicked(evt);
            }
        });

        ind_5.setOpaque(false);
        ind_5.setPreferredSize(new java.awt.Dimension(3, 43));

        javax.swing.GroupLayout ind_5Layout = new javax.swing.GroupLayout(ind_5);
        ind_5.setLayout(ind_5Layout);
        ind_5Layout.setHorizontalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );
        ind_5Layout.setVerticalGroup(
            ind_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 43, Short.MAX_VALUE)
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Approval");

        javax.swing.GroupLayout btnManagerLayout = new javax.swing.GroupLayout(btnManager);
        btnManager.setLayout(btnManagerLayout);
        btnManagerLayout.setHorizontalGroup(
            btnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnManagerLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel12)
                .addGap(0, 64, Short.MAX_VALUE))
        );
        btnManagerLayout.setVerticalGroup(
            btnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnManagerLayout.createSequentialGroup()
                .addComponent(ind_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(btnManagerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnMenu.add(btnManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 253, 150, -1));

        getContentPane().add(pnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 660));

        pnBar.setBackground(new java.awt.Color(71, 120, 197));
        pnBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setBackground(new java.awt.Color(123, 156, 225));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setPreferredSize(new java.awt.Dimension(2, 20));
        pnBar.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 10, 150, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_search_more_24px.png"))); // NOI18N
        pnBar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 30, 30));

        btExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_exit_24px.png"))); // NOI18N
        btExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btExitMouseClicked(evt);
            }
        });
        pnBar.add(btExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 30, 30));

        getContentPane().add(pnBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 920, 50));

        pnDescription.setBackground(new java.awt.Color(71, 120, 197));

        jPanel4.setBackground(new java.awt.Color(120, 168, 252));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(84, 127, 206));

        lbCurrentDate.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        lbCurrentDate.setForeground(new java.awt.Color(255, 255, 255));
        lbCurrentDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCurrentDate.setText("19:30 - 03/03/2019");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbCurrentDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 270, -1));

        profilePic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_image_file_remove_48px.png"))); // NOI18N
        jPanel4.add(profilePic, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 10, 80, 70));

        lbDescriptionUserName.setFont(new java.awt.Font("Multicolore ", 0, 18)); // NOI18N
        lbDescriptionUserName.setForeground(new java.awt.Color(255, 255, 255));
        lbDescriptionUserName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDescriptionUserName.setText("Pandu Galang");
        jPanel4.add(lbDescriptionUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 160, 30));

        lbDescriptionManager.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lbDescriptionManager.setForeground(new java.awt.Color(255, 255, 255));
        lbDescriptionManager.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbDescriptionManager.setText("-");
        jPanel4.add(lbDescriptionManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, -1));

        javax.swing.GroupLayout pnDescriptionLayout = new javax.swing.GroupLayout(pnDescription);
        pnDescription.setLayout(pnDescriptionLayout);
        pnDescriptionLayout.setHorizontalGroup(
            pnDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnDescriptionLayout.setVerticalGroup(
            pnDescriptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDescriptionLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(427, Short.MAX_VALUE))
        );

        getContentPane().add(pnDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 270, 630));

        dynamicPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnHome.setBackground(new java.awt.Color(255, 255, 255));

        pnHomeHeader.setBackground(new java.awt.Color(242, 247, 247));

        javax.swing.GroupLayout pnHomeHeaderLayout = new javax.swing.GroupLayout(pnHomeHeader);
        pnHomeHeader.setLayout(pnHomeHeaderLayout);
        pnHomeHeaderLayout.setHorizontalGroup(
            pnHomeHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        pnHomeHeaderLayout.setVerticalGroup(
            pnHomeHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 118, Short.MAX_VALUE)
        );

        pnHomeContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(120, 168, 252));
        jLabel20.setText("SISA CUTI ANDA");
        pnHomeContent.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, -1, -1));

        jPanel2.setBackground(new java.awt.Color(120, 168, 252));

        sisaCutiCounter.setBackground(new java.awt.Color(120, 168, 252));
        sisaCutiCounter.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        sisaCutiCounter.setForeground(new java.awt.Color(255, 255, 255));
        sisaCutiCounter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sisaCutiCounter.setText("8");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sisaCutiCounter, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sisaCutiCounter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnHomeContent.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 46, 70, 70));

        javax.swing.GroupLayout pnHomeLayout = new javax.swing.GroupLayout(pnHome);
        pnHome.setLayout(pnHomeLayout);
        pnHomeLayout.setHorizontalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnHomeHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnHomeContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnHomeLayout.setVerticalGroup(
            pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHomeLayout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(pnHomeHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(377, Short.MAX_VALUE))
            .addGroup(pnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnHomeLayout.createSequentialGroup()
                    .addGap(0, 202, Short.MAX_VALUE)
                    .addComponent(pnHomeContent, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dynamicPane.add(pnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 650, 580));

        pnUser.setBackground(new java.awt.Color(255, 255, 255));

        pnUserHeader.setBackground(new java.awt.Color(242, 247, 247));

        javax.swing.GroupLayout pnUserHeaderLayout = new javax.swing.GroupLayout(pnUserHeader);
        pnUserHeader.setLayout(pnUserHeaderLayout);
        pnUserHeaderLayout.setHorizontalGroup(
            pnUserHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        pnUserHeaderLayout.setVerticalGroup(
            pnUserHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );

        tfUserName.setBackground(new java.awt.Color(120, 168, 252));
        tfUserName.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfUserName.setForeground(new java.awt.Color(255, 255, 255));
        tfUserName.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        tfUserEmail.setBackground(new java.awt.Color(120, 168, 252));
        tfUserEmail.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfUserEmail.setForeground(new java.awt.Color(255, 255, 255));
        tfUserEmail.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        tfUserEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUserEmailActionPerformed(evt);
            }
        });

        tfUserID.setEditable(false);
        tfUserID.setBackground(new java.awt.Color(120, 168, 252));
        tfUserID.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfUserID.setForeground(new java.awt.Color(255, 255, 255));
        tfUserID.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        tfUserPassword.setEditable(false);
        tfUserPassword.setBackground(new java.awt.Color(120, 168, 252));
        tfUserPassword.setForeground(new java.awt.Color(120, 168, 252));
        tfUserPassword.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel1.setText("ID");

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel13.setText("Email");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel15.setText("Password");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel16.setText("Username");

        btUserUpdate.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btUserUpdate.setText("SUBMIT");
        btUserUpdate.setBorder(null);
        btUserUpdate.setBorderPainted(false);
        btUserUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserUpdateActionPerformed(evt);
            }
        });

        tfIdManager.setEditable(false);
        tfIdManager.setBackground(new java.awt.Color(120, 168, 252));
        tfIdManager.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfIdManager.setForeground(new java.awt.Color(255, 255, 255));
        tfIdManager.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel17.setText("ID Manager");

        cbMarital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SN1 - Single", "SN2 - Married" }));

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pria", "Wanita" }));

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel18.setText("Marital");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel19.setText("Gender");

        tfLeaveLeft.setEditable(false);
        tfLeaveLeft.setBackground(new java.awt.Color(120, 168, 252));
        tfLeaveLeft.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfLeaveLeft.setForeground(new java.awt.Color(255, 255, 255));
        tfLeaveLeft.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel21.setText("Leave Available");

        tfJobsTitle.setEditable(false);
        tfJobsTitle.setBackground(new java.awt.Color(120, 168, 252));
        tfJobsTitle.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfJobsTitle.setForeground(new java.awt.Color(255, 255, 255));
        tfJobsTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));

        javax.swing.GroupLayout pnUserContentLayout = new javax.swing.GroupLayout(pnUserContent);
        pnUserContent.setLayout(pnUserContentLayout);
        pnUserContentLayout.setHorizontalGroup(
            pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserContentLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnUserContentLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnUserContentLayout.createSequentialGroup()
                        .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnUserContentLayout.createSequentialGroup()
                        .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnUserContentLayout.createSequentialGroup()
                                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfLeaveLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnUserContentLayout.createSequentialGroup()
                                        .addGap(130, 130, 130)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserContentLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                                        .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(tfUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel13))
                                            .addComponent(tfJobsTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pnUserContentLayout.createSequentialGroup()
                                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIdManager, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnUserContentLayout.createSequentialGroup()
                                            .addComponent(cbMarital, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                    .addComponent(btUserUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(63, 63, 63))))
        );
        pnUserContentLayout.setVerticalGroup(
            pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserContentLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUserEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMarital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfIdManager, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfUserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUserContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfLeaveLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfJobsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btUserUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnUserLayout = new javax.swing.GroupLayout(pnUser);
        pnUser.setLayout(pnUserLayout);
        pnUserLayout.setHorizontalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnUserContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnUserHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnUserLayout.setVerticalGroup(
            pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                    .addGap(0, 202, Short.MAX_VALUE)
                    .addComponent(pnUserContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnUserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserLayout.createSequentialGroup()
                    .addContainerGap(85, Short.MAX_VALUE)
                    .addComponent(pnUserHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(338, Short.MAX_VALUE)))
        );

        dynamicPane.add(pnUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 650, 540));

        pnRequest.setBackground(new java.awt.Color(255, 255, 255));
        pnRequest.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btUserSubmitRequest.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btUserSubmitRequest.setText("SUBMIT");
        btUserSubmitRequest.setBorder(null);
        btUserSubmitRequest.setBorderPainted(false);
        btUserSubmitRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUserSubmitRequestActionPerformed(evt);
            }
        });
        pnRequest.add(btUserSubmitRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 70, 100));

        cbJenisCuti.setBackground(new java.awt.Color(120, 168, 252));
        cbJenisCuti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJenisCutiActionPerformed(evt);
            }
        });
        pnRequest.add(cbJenisCuti, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 210, 30));

        jLabel3.setText("Start Leave");
        pnRequest.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setText("End Leave");
        pnRequest.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, -1, -1));

        jLabel5.setText("Leave Type");
        pnRequest.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, -1, -1));

        tfUserTotal.setEditable(false);
        tfUserTotal.setBackground(new java.awt.Color(120, 168, 252));
        pnRequest.add(tfUserTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 170, 30));

        jLabel6.setText("TOTAL");
        pnRequest.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        dcStart.setDateFormatString("dd-MM-yyyy");
        pnRequest.add(dcStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 30));
        pnRequest.add(dcEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 210, 30));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_refresh_25px.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        pnRequest.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 160, 30, 30));

        pnCntentFill.setBackground(new java.awt.Color(242, 247, 247));
        pnCntentFill.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/icons8_close_window_96px.png"))); // NOI18N
        btCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCancelMouseClicked(evt);
            }
        });
        pnCntentFill.add(btCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 70, 74));

        tfSelectedRequest.setEditable(false);
        tfSelectedRequest.setBackground(new java.awt.Color(255, 255, 255));
        tfSelectedRequest.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tfSelectedRequest.setForeground(new java.awt.Color(0, 0, 0));
        tfSelectedRequest.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSelectedRequest.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnCntentFill.add(tfSelectedRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 70, 20));

        tfSelectedRequestDesc.setEditable(false);
        tfSelectedRequestDesc.setBackground(new java.awt.Color(255, 255, 255));
        tfSelectedRequestDesc.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tfSelectedRequestDesc.setForeground(new java.awt.Color(0, 0, 0));
        tfSelectedRequestDesc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSelectedRequestDesc.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnCntentFill.add(tfSelectedRequestDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 130, 20));

        tfSelectedRequestStatus.setEditable(false);
        tfSelectedRequestStatus.setBackground(new java.awt.Color(255, 255, 255));
        tfSelectedRequestStatus.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tfSelectedRequestStatus.setForeground(new java.awt.Color(0, 0, 0));
        tfSelectedRequestStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSelectedRequestStatus.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnCntentFill.add(tfSelectedRequestStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 70, 20));

        tfSelectedRequestDate.setEditable(false);
        tfSelectedRequestDate.setBackground(new java.awt.Color(255, 255, 255));
        tfSelectedRequestDate.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tfSelectedRequestDate.setForeground(new java.awt.Color(0, 0, 0));
        tfSelectedRequestDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSelectedRequestDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnCntentFill.add(tfSelectedRequestDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 170, 20));

        tfSelectedRequestPengajuan.setEditable(false);
        tfSelectedRequestPengajuan.setBackground(new java.awt.Color(255, 255, 255));
        tfSelectedRequestPengajuan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        tfSelectedRequestPengajuan.setForeground(new java.awt.Color(0, 0, 0));
        tfSelectedRequestPengajuan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSelectedRequestPengajuan.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnCntentFill.add(tfSelectedRequestPengajuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 50, 20));

        tbRequestStatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ID", "Request Date", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbRequestStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRequestStatusMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbRequestStatus);

        pnCntentFill.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 530, 140));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(120, 168, 252));
        jLabel30.setText("Track Your Request");
        pnCntentFill.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnRequest.add(pnCntentFill, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 205, 650, 380));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(120, 168, 252));
        jLabel2.setText("Create Your Request");
        pnRequest.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        dynamicPane.add(pnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 650, 580));

        pnHistory.setBackground(new java.awt.Color(255, 255, 255));
        pnHistory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tbHistory.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        tbHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Start", "End", "Total", "Leave Type", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbHistory.setGridColor(new java.awt.Color(255, 255, 255));
        tbHistory.setRowHeight(22);
        jScrollPane1.setViewportView(tbHistory);

        pnHistory.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 87, 630, 480));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(120, 168, 252));
        jLabel31.setText("History of Your Request");
        pnHistory.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        dynamicPane.add(pnHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 650, 580));

        pnUserHeader1.setBackground(new java.awt.Color(242, 247, 247));

        btReport.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        btReport.setText("Report");
        btReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btReportActionPerformed(evt);
            }
        });

        jButton1.setText("---");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnUserHeader1Layout = new javax.swing.GroupLayout(pnUserHeader1);
        pnUserHeader1.setLayout(pnUserHeader1Layout);
        pnUserHeader1Layout.setHorizontalGroup(
            pnUserHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserHeader1Layout.createSequentialGroup()
                .addContainerGap(357, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btReport, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        pnUserHeader1Layout.setVerticalGroup(
            pnUserHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserHeader1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(pnUserHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btReport, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        tbManagerUserRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NO", "ID", "Requested", "Type", "Action", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbManagerUserRequest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbManagerUserRequestMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbManagerUserRequest);

        tfSelectedUser.setEditable(false);
        tfSelectedUser.setBackground(new java.awt.Color(120, 168, 252));
        tfSelectedUser.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        tfSelectedUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btManagerReject.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btManagerReject.setForeground(new java.awt.Color(0, 0, 0));
        btManagerReject.setText("REJECT");
        btManagerReject.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btManagerReject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btManagerRejectActionPerformed(evt);
            }
        });

        btManagerAccept.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btManagerAccept.setForeground(new java.awt.Color(0, 0, 0));
        btManagerAccept.setText("ACCEPT");
        btManagerAccept.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btManagerAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btManagerAcceptActionPerformed(evt);
            }
        });

        strID.setEditable(false);
        strID.setBackground(new java.awt.Color(255, 255, 102));

        strDate.setEditable(false);
        strDate.setBackground(new java.awt.Color(255, 255, 102));

        strRequestId.setEditable(false);
        strRequestId.setBackground(new java.awt.Color(255, 255, 102));

        strType.setEditable(false);
        strType.setBackground(new java.awt.Color(255, 255, 102));

        strDesc.setBackground(new java.awt.Color(120, 168, 252));

        javax.swing.GroupLayout pnUserContent1Layout = new javax.swing.GroupLayout(pnUserContent1);
        pnUserContent1.setLayout(pnUserContent1Layout);
        pnUserContent1Layout.setHorizontalGroup(
            pnUserContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnUserContent1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnUserContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnUserContent1Layout.createSequentialGroup()
                        .addComponent(tfSelectedUser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btManagerAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btManagerReject, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 20, Short.MAX_VALUE))
            .addGroup(pnUserContent1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(strID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(strDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(strRequestId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(strType, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(strDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnUserContent1Layout.setVerticalGroup(
            pnUserContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnUserContent1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnUserContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strRequestId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(pnUserContent1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btManagerReject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfSelectedUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btManagerAccept, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnManagerLayout = new javax.swing.GroupLayout(pnManager);
        pnManager.setLayout(pnManagerLayout);
        pnManagerLayout.setHorizontalGroup(
            pnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(pnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnUserHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pnUserContent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnManagerLayout.setVerticalGroup(
            pnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
            .addGroup(pnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnManagerLayout.createSequentialGroup()
                    .addGap(85, 85, 85)
                    .addComponent(pnUserHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(335, Short.MAX_VALUE)))
            .addGroup(pnManagerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnManagerLayout.createSequentialGroup()
                    .addGap(0, 200, Short.MAX_VALUE)
                    .addComponent(pnUserContent1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        dynamicPane.add(pnManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 650, 540));

        getContentPane().add(dynamicPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 920, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMousePressed
        // TODO add your handling code here:
        setColor(btnHome);
        ind_1.setOpaque(true);
        resetColor(new JPanel[]{btnHistory, btnUser, btnRequest, btnManager}, new JPanel[]{ind_2, ind_3, ind_4, ind_5});
        pnHome.setVisible(true);
        pnUser.setVisible(false);
        pnHistory.setVisible(false);
        pnRequest.setVisible(false);
        pnManager.setVisible(false);
    }//GEN-LAST:event_btnHomeMousePressed

    private void btnHistoryMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHistoryMouseReleased
        // TODO add your handling code here:
        setColor(btnHistory);
        ind_2.setOpaque(true);
        resetColor(new JPanel[]{btnHome, btnUser, btnRequest, btnManager}, new JPanel[]{ind_1, ind_3, ind_4, ind_5});
        pnHome.setVisible(false);
        pnUser.setVisible(false);
        pnHistory.setVisible(true);
        pnRequest.setVisible(false);
        pnManager.setVisible(false);

        tableHistory(spc.getHistory(var, true));
    }//GEN-LAST:event_btnHistoryMouseReleased

    private void btnUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserMousePressed
        // TODO add your handling code here:
        setColor(btnUser);
        ind_3.setOpaque(true);
        resetColor(new JPanel[]{btnHistory, btnHome, btnRequest, btnManager}, new JPanel[]{ind_2, ind_1, ind_4, ind_5});
        pnHome.setVisible(false);
        pnUser.setVisible(true);
        pnHistory.setVisible(false);
        pnRequest.setVisible(false);
        pnManager.setVisible(false);

        for (Karyawan karyawan : kc.getIdKar(var)) {
            tfUserName.setText(karyawan.getNama());
            tfUserEmail.setText(karyawan.getEmail());
            tfUserID.setText(karyawan.getId());
            tfIdManager.setText(karyawan.getIdmanager().getId());
            tfLeaveLeft.setText(karyawan.getJumlahcuti().toString());
            tfUserPassword.setText(karyawan.getPassword());
            tfJobsTitle.setText(karyawan.getJobs().getId());
        }
    }//GEN-LAST:event_btnUserMousePressed

    private void btnRequestMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRequestMousePressed
        // TODO add your handling code here:
        setColor(btnRequest);
        ind_4.setOpaque(true);
        resetColor(new JPanel[]{btnHistory, btnUser, btnHome, btnManager}, new JPanel[]{ind_2, ind_3, ind_1, ind_5});
        pnHome.setVisible(false);
        pnUser.setVisible(false);
        pnHistory.setVisible(false);
        pnRequest.setVisible(true);
        pnManager.setVisible(false);
        tableRequestStatus(spc.getHistory(var, false));
    }//GEN-LAST:event_btnRequestMousePressed

    int xx, xy;
    private void btExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btExitMouseClicked
        // TODO add your handling code here:
        var = "";
        this.dispose();
        new Landing().setVisible(true);
    }//GEN-LAST:event_btExitMouseClicked

    private void tfUserEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUserEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfUserEmailActionPerformed

    private void btUserSubmitRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserSubmitRequestActionPerformed
        // TODO add your handling code here:

        LocalDateTime from = LocalDateTime.ofInstant(dcStart.getDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime to = LocalDateTime.ofInstant(dcEnd.getDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime now = LocalDateTime.now();

        Duration dur = Duration.between(from, to);
        Duration durB = Duration.between(now, from);

        String start = String.valueOf(sdf.format(dcStart.getDate()));
        String end = String.valueOf(sdf.format(dcEnd.getDate()));

        String tot = String.valueOf(dur.toDays() + 1);
        String totb = String.valueOf(durB.toDays());

        String jcut = cbJenisCuti.getSelectedItem().toString().split(" - ")[0];

        if (start.equals("") || end.equals("")) {
            JOptionPane.showMessageDialog(null, "PLEASE, FILL ALL FORM");
        } else if (Integer.parseInt(tot) > kc.getById(var).getJumlahcuti()) {
            JOptionPane.showMessageDialog(null, "YOUR CURRENT AVAILABLE REQUEST AREN'T ENOUGH");
        } else if (jcut.equals("JC1") && Integer.parseInt(totb) <= 7) {
            JOptionPane.showMessageDialog(null, "LEAVE REQUEST CANT PROCCESS DUE DURATION OF TIME YOU PICKED");
        } else {
            cc.save("", start, end, totb, var, cbJenisCuti.getSelectedItem().toString().split(" - ")[0]);
            JOptionPane.showMessageDialog(null, "YOUR REQUEST HAVE BEEN SUBMITED");
        }
    }//GEN-LAST:event_btUserSubmitRequestActionPerformed

    private void btnManagerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnManagerMouseClicked
        setColor(btnManager);
        ind_5.setOpaque(true);
        resetColor(new JPanel[]{btnHistory, btnUser, btnHome, btnRequest}, new JPanel[]{ind_2, ind_3, ind_1, ind_4});
        pnHome.setVisible(false);
        pnUser.setVisible(false);
        pnHistory.setVisible(false);
        pnRequest.setVisible(false);
        pnManager.setVisible(true);
        tableEmployeeRequestOnManager(spc.getHistoryByMang(var, true));
    }//GEN-LAST:event_btnManagerMouseClicked

    private void tbManagerUserRequestMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbManagerUserRequestMouseClicked
        strID.setText(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 1).toString());
        strDate.setText(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 2).toString().split(" ")[0]);
        strType.setText(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 3).toString());
        strRequestId.setText(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 4).toString());

//        String y = String.valueOf(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 5));
        if (tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 5) != null) {
            strDesc.setText(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 5) + "");
        }
        tfSelectedUser.setText(tbManagerUserRequest.getValueAt(tbManagerUserRequest.getSelectedRow(), 1).toString());
    }//GEN-LAST:event_tbManagerUserRequestMouseClicked

    private void btManagerAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btManagerAcceptActionPerformed

//        KINDA LIKE TO WRITE SOME LOGIC TO MINUS THE LEAVE ABVAILABLE HERE
        String idkar = cc.getById(strRequestId.getText()).getKaryawan().getId();
        int cutiTotal = cc.getById(strRequestId.getText()).getJumlah();
        int sisaCuti = kc.getById(String.valueOf(cc.getById(strRequestId.getText()).getKaryawan().getId())).getJumlahcuti().intValue();
        int newSisa = sisaCuti - cutiTotal;
        System.out.println(idkar);
        System.out.println(sisaCuti);
        System.out.println(newSisa);
 

//        IF I CANT FIND HOW THE HECK TO UPDATE SINGLE ROW ON HQL, I'LL FORCEFULLY USING LEGACY SQL
        
        if (tfSelectedUser.getText() != null) {
            spc.update(tfSelectedUser.getText(), dateFormat.format(date), strDesc.getText(), strRequestId.getText(), "S2");
            tableEmployeeRequestOnManager(spc.getHistoryByMang(var, true));
            String message = "THANKS FOR REQUESTING, WE'VE ACCEPT YOUR REQUEST";
            String emailTo = kc.getById(cc.getById(strRequestId.getText()).getKaryawan().getId()).getEmail();
            emailSend(message, emailTo);
            for (Karyawan karyawan : kc.getIdKar(idkar)) {
            System.out.println(kc.update(karyawan.getId(), karyawan.getNama(), 
                    karyawan.getJeniskelamin(), String.valueOf(newSisa), 
                    karyawan.getEmail(), karyawan.getPassword(), 
                    karyawan.getStatusnikah().getId(), 
                    karyawan.getIdmanager().getId(), karyawan.getJobs().getId()));
        }
            spc.insert("1", dateFormat.format(date), strDesc.getText(), strRequestId.getText(), "S2");
//            kc.literallyUpdate(idkar, String.valueOf(newSisa));
            JOptionPane.showMessageDialog(pnHomeContent, "SUCCESS");
        } else if (tfSelectedUser.getText() == null) {
            JOptionPane.showMessageDialog(pnHomeContent, "SELECT THE LIST FIRST");
        } else {
            JOptionPane.showMessageDialog(pnHomeContent, "SOMETHING WENT WRONG");
        }
    }//GEN-LAST:event_btManagerAcceptActionPerformed

    private void btManagerRejectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btManagerRejectActionPerformed
        if (tfSelectedUser.getText() != null) {
            spc.update(tfSelectedUser.getText(), dateFormat.format(date), strDesc.getText(), strRequestId.getText(), "S3");
            tableEmployeeRequestOnManager(spc.getHistoryByMang(var, true));
            String message = "SORRY, YOUR REQUEST CANT BE PROCCESSED";
            String emailTo = kc.getById(cc.getById(strRequestId.getText()).getKaryawan().getId()).getEmail();
            emailSend(message, emailTo);
            JOptionPane.showMessageDialog(pnHomeContent, "SUCCESS");
        } else if (tfSelectedUser.getText() == null) {
            JOptionPane.showMessageDialog(pnHomeContent, "SELECT THE LIST FIRST");
        } else {
            JOptionPane.showMessageDialog(pnHomeContent, "SOMETHING WENT WRONG, PLEASE CHECK AGAIN");
        }
    }//GEN-LAST:event_btManagerRejectActionPerformed

    private void btReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btReportActionPerformed
        try {
            String fileName = "./Report/report1.jrxml";
            String filetoFill = "./Report/report1.jasper";
            JasperCompileManager.compileReport(fileName);
            Map param = new HashMap();
            JasperFillManager.fillReport(filetoFill, param, connection.getConnection());
            JasperPrint jp = JasperFillManager.fillReport(filetoFill, param, connection.getConnection());
            JasperViewer.viewReport(jp, false);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }//GEN-LAST:event_btReportActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        LocalDateTime from = LocalDateTime.ofInstant(dcStart.getDate().toInstant(), ZoneId.systemDefault());
        LocalDateTime to = LocalDateTime.ofInstant(dcEnd.getDate().toInstant(), ZoneId.systemDefault());

        Duration dur = Duration.between(from, to);

        tfUserTotal.setText(String.valueOf(dur.toDays() + 1));
    }//GEN-LAST:event_jLabel14MouseClicked

    private void btUserUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUserUpdateActionPerformed
        kc.update(tfUserID.getText(), tfUserName.getText(), cbGender.getSelectedItem().toString(), tfLeaveLeft.getText(), tfUserEmail.getText(), tfUserPassword.getText(), cbMarital.getSelectedItem().toString().split(" - ")[0], tfIdManager.getText(), tfJobsTitle.getText());
        emailSend("YOUR ACCOUNT HAS BEEN UPDATED", tfUserEmail.getText());
        JOptionPane.showMessageDialog(pnHomeContent, "SUCCESS UPDATE YOUR PROFILE \nPLEASE CHECK YOUR EMAIL FOR THIS");
    }//GEN-LAST:event_btUserUpdateActionPerformed

    private void tbRequestStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRequestStatusMouseClicked
        tfSelectedRequest.setText(tbRequestStatus.getValueAt(tbRequestStatus.getSelectedRow(), 1).toString());
        tfSelectedRequestDate.setText(tbRequestStatus.getValueAt(tbRequestStatus.getSelectedRow(), 2).toString());
        tfSelectedRequestDesc.setText(tbRequestStatus.getValueAt(tbRequestStatus.getSelectedRow(), 3).toString());
        tfSelectedRequestPengajuan.setText(tbRequestStatus.getValueAt(tbRequestStatus.getSelectedRow(), 4).toString());
        tfSelectedRequestStatus.setText(tbRequestStatus.getValueAt(tbRequestStatus.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbRequestStatusMouseClicked

    private void btCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelMouseClicked
        spc.update(tfSelectedRequest.getText(), dateFormat.format(date), tfSelectedRequestDesc.getText(), tfSelectedRequestPengajuan.getText(), "S4");

        tfSelectedRequest.setText("");
        tfSelectedRequestDate.setText("");
        tfSelectedRequestDesc.setText("");
        tfSelectedRequestPengajuan.setText("");
        tfSelectedRequestStatus.setText("");

        tbRequestStatus.setModel(myTable);
    }//GEN-LAST:event_btCancelMouseClicked

    private void cbJenisCutiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJenisCutiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJenisCutiActionPerformed

    private void btRegSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegSignUpActionPerformed
        String id = "";
        String nama = tfRegFirstName.getText() + tfRegLastName.getText();
        String gender = cbGender.getSelectedItem().toString();
        String jumcut = "0";
        String email = tfRegEmail.getText();
        String pass1 = tfRegPass1.getText();
        String pass2 = tfRegPass2.getText();
        String marital = cbRegMarried.getSelectedItem().toString().split(" - ")[0];
        String idmanagaer = cbGetManager.getSelectedItem().toString();
        String jobs = cbJobs.getSelectedItem().toString().split(" - ")[0];

        if (pass1.equals(pass2)) {
//            System.out.println(id + " " + nama + " " + gender + " " + jumcut + " " + email + " " + pass1 + " " + marital + " " + idmanagaer + " " + jobs);
            kc.register(id, nama, gender, jumcut, email, pass1, marital, idmanagaer, jobs);
            String message = "Yeay your Account has been created, Let's check it out on our App \nAccount Detail: \nUSERNAME   = " + nama + "\nPASSWORD = " + pass1;
            if (tfLocationFile.getText() != null) {
                weirdButWorksPhotoUploader();
            }
            emailSend(message, email);
            JOptionPane.showMessageDialog(pnHomeContent, "Account Successfully Created");
        }
    }//GEN-LAST:event_btRegSignUpActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tableEmployeeRequestOnManager(spc.getHistory("", isIcon));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelectImageActionPerformed
        // TODO add your handling code here:
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
        JFileChooser jf = new JFileChooser();
        jf.setCurrentDirectory(new java.io.File("C:/User"));
        jf.setDialogTitle("Chose Profile Image");
        jf.setFileFilter(filter);
        if (jf.showOpenDialog(pnMenu) == JFileChooser.APPROVE_OPTION) {
            //
        }
        tfLocationFile.setText(jf.getSelectedFile().getAbsolutePath());
    }//GEN-LAST:event_btSelectImageActionPerformed

    private void btUpdateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUpdateUserActionPerformed
        // TODO add your handling code here:
        String id = "";
        String nama = tfRegFirstName.getText() + tfRegLastName.getText();
        String gender = cbGender.getSelectedItem().toString();
        String jumcut = "0";
        String email = tfRegEmail.getText();
        String pass1 = tfRegPass1.getText();
        String pass2 = tfRegPass2.getText();
        String marital = cbRegMarried.getSelectedItem().toString().split(" - ")[0];
        String idmanagaer = cbGetManager.getSelectedItem().toString();
        String jobs = cbJobs.getSelectedItem().toString().split(" - ")[0];

        if (pass1.equals(pass2)) {
//            System.out.println(id + " " + nama + " " + gender + " " + jumcut + " " + email + " " + pass1 + " " + marital + " " + idmanagaer + " " + jobs);
            kc.update(id, nama, gender, jumcut, email, pass1, marital, idmanagaer, jobs);
            String message = "Yeay your Account " + nama + " has been created, Let's check it out on our App";
            if (tfLocationFile.getText() != null) {
                weirdButWorksPhotoUploader();
            }
            emailSend(message, email);
            JOptionPane.showMessageDialog(pnHomeContent, "Account Successfully Created");
        }
    }//GEN-LAST:event_btUpdateUserActionPerformed

    private void tbAllUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAllUserMouseClicked
        tfRegFirstName.setText(tbAllUser.getValueAt(tbAllUser.getSelectedRow(), 2).toString());
        tfRegUsername.setText(tbAllUser.getValueAt(tbAllUser.getSelectedRow(), 1).toString());
        tfRegEmail.setText(tbAllUser.getValueAt(tbAllUser.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_tbAllUserMouseClicked

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        int dialogue = JOptionPane.showConfirmDialog(pnHomeContent, "ARE YOU SURE?");
        if (dialogue == JOptionPane.YES_OPTION) {
            kc.delete(tfRegUsername.getText());
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

//    SELF METHOD
//    NOTE NOTE : SUBJECT DONT BE STATIC VALUE 
    private void emailSend(String messages, String email) {
        SendEmailTemp.setFromEmail("lgg121770@gmail.com");
        SendEmailTemp.setToEmail(email);
        SendEmailTemp.setMessage(messages);
        SendEmailTemp.setSubject("Leave Request Respond");
        SendEmailTemp.setPassword("123Q123Q@");
        emailInterface.sendEmail();
    }

    private void getRidTheBar() {
        putClientProperty("Home.isPallete", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
    }

    private void getTheDamnPhotos() {
        try {
            byte[] imageBytes;
            Image image;
            Connection connect = connection.getConnection();
            Statement stm = connect.createStatement();
            String sql = "SELECT PHOTO FROM KARYAWAN WHERE ID = " + var;
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                imageBytes = rs.getBytes("photo");
                image = getToolkit().createImage(imageBytes);
                ImageIcon icon = new ImageIcon(image);
                profilePic.setIcon(icon);
            }
        } catch (Exception e) {
            System.out.println("SORRY NOT PHOTOS AVAILABLE FOR THIS ACC");
//            profilePic.setIcon();
        }

    }

    private void weirdButWorksPhotoUploader() {
        String s = tfLocationFile.getText();
        String nama = tfRegFirstName.getText() + tfRegLastName.getText();

        try {
            Connection connect = connection.getConnection();
            Statement stm = connect.createStatement();
            PreparedStatement ps = connect.prepareStatement("UPDATE KARYAWAN SET PHOTO=?  WHERE NAMA = '" + nama + "'");
            InputStream is = new FileInputStream(new File(s));
            ps.setBlob(1, is);
            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Data Inserted");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void tableAll(List<models.Karyawan> kar) {
        Object[] columnNames = {"Nomor", "ID", "Nama", "Gender", "Cuti", "Email", "Marital", "Manager"};
        Object[][] data = new Object[kar.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = kar.get(i).getId();
            data[i][2] = kar.get(i).getNama();
            data[i][3] = kar.get(i).getJeniskelamin();
            data[i][4] = kar.get(i).getJumlahcuti();
            data[i][5] = kar.get(i).getEmail();
            data[i][6] = kar.get(i).getStatusnikah().getStatus();

            if (kar.get(i).getIdmanager() != null) {
                data[i][7] = kar.get(i).getIdmanager().getNama() + "";
            } else {
                data[i][7] = "";
            }
        }
        myTable = new DefaultTableModel(data, columnNames);
        tbAllUser.setModel(myTable);
    }

    private void tableEmployeeRequestOnManager(List<models.StatusPengajuan> kar) {
        Object[] columnNames = {"Nomor", "Requester", "Date", "Status", "ID Pengajuan", "Description"};
        Object[][] data = new Object[kar.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = kar.get(i).getId();

//            THIS METHOD BELOW ARE WORK, THE PROBLEM IS WE GOT NO NDEX WHEN UPDATING THE STATUS THEN
//            data[i][1] = cc.getById(kar.get(i).getPengajuan().getId()).getKaryawan().getNama();
            data[i][2] = kar.get(i).getDatetime();
            data[i][3] = kar.get(i).getStatus().getTipe();
            data[i][4] = kar.get(i).getPengajuan().getId();

            if (kar.get(i).getKeterangan() != null) {
                data[i][5] = kar.get(i).getKeterangan() + "";
            } else {
            }
            myTable = new DefaultTableModel(data, columnNames);
            tbManagerUserRequest.setModel(myTable);
        }
    }

    private void tableRequestStatus(List<models.StatusPengajuan> req) {
        Object[] columnNames = {"Nomor", "ID", "Date", "Keterangan", "Pengajuan", "Status"};
        Object[][] data = new Object[req.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = req.get(i).getId();
            data[i][2] = req.get(i).getDatetime();
            if (req.get(i).getKeterangan() != null) {
                data[i][3] = req.get(i).getKeterangan() + "";
            } else {
                data[i][3] = "";
            }
            data[i][4] = req.get(i).getPengajuan().getId();
            data[i][5] = req.get(i).getStatus().getTipe();
        }
        myTable = new DefaultTableModel(data, columnNames);
        tbRequestStatus.setModel(myTable);
    }

    private void tableHistory(List<models.StatusPengajuan> req) {
        Object[] columnNames = {"Nomor", "ID", "Date", "Description", "Status"};
        Object[][] data = new Object[req.size()][columnNames.length];
        for (int i = 0; i < data.length; i++) {
            data[i][0] = (i + 1);
            data[i][1] = req.get(i).getId();
            data[i][2] = req.get(i).getDatetime();
            if (req.get(i).getKeterangan() != null) {
                data[i][3] = req.get(i).getKeterangan() + "";
            } else {
                data[i][3] = "";
            }
            data[i][4] = req.get(i).getStatus().getTipe();
        }
        myTable = new DefaultTableModel(data, columnNames);
        tbHistory.setModel(myTable);
    }

    private void setColor(JPanel pane) {
        pane.setBackground(new Color(41, 57, 80));
    }

    private void resetColor(JPanel[] pane, JPanel[] indicators) {
        for (int i = 0; i < pane.length; i++) {
            pane[i].setBackground(new Color(23, 35, 51));
        }
        for (int i = 0; i < indicators.length; i++) {
            indicators[i].setOpaque(false);
        }

    }

    //PRINTHILAN TEXT

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btCancel;
    private javax.swing.JLabel btExit;
    private javax.swing.JButton btManagerAccept;
    private javax.swing.JButton btManagerReject;
    private javax.swing.JButton btRegSignUp;
    private javax.swing.JButton btReport;
    private javax.swing.JButton btSelectImage;
    private javax.swing.JButton btUpdateUser;
    private javax.swing.JButton btUserSubmitRequest;
    private javax.swing.JButton btUserUpdate;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JPanel btnHistory;
    private javax.swing.JPanel btnHome;
    private javax.swing.JPanel btnManager;
    private javax.swing.JPanel btnRequest;
    private javax.swing.JPanel btnUser;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbGetManager;
    private javax.swing.JComboBox<String> cbJenisCuti;
    private javax.swing.JComboBox<String> cbJobs;
    private javax.swing.JComboBox<String> cbMarital;
    private javax.swing.JComboBox<String> cbRegGender;
    private javax.swing.JComboBox<String> cbRegMarried;
    private com.toedter.calendar.JDateChooser dcEnd;
    private com.toedter.calendar.JDateChooser dcStart;
    private javax.swing.JLayeredPane dynamicPane;
    private javax.swing.JPanel ind_1;
    private javax.swing.JPanel ind_2;
    private javax.swing.JPanel ind_3;
    private javax.swing.JPanel ind_4;
    private javax.swing.JPanel ind_5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbCurrentDate;
    private javax.swing.JLabel lbDescriptionManager;
    private javax.swing.JLabel lbDescriptionUserName;
    private javax.swing.JPanel pnAdmin;
    private javax.swing.JPanel pnAllUser;
    private javax.swing.JPanel pnBar;
    private javax.swing.JPanel pnCntentFill;
    private javax.swing.JPanel pnDescription;
    private javax.swing.JPanel pnHistory;
    private javax.swing.JPanel pnHome;
    private javax.swing.JPanel pnHomeContent;
    private javax.swing.JPanel pnHomeHeader;
    private javax.swing.JPanel pnManager;
    private javax.swing.JPanel pnMenu;
    private javax.swing.JPanel pnRequest;
    private javax.swing.JPanel pnSignUp;
    private javax.swing.JPanel pnUser;
    private javax.swing.JPanel pnUserContent;
    private javax.swing.JPanel pnUserContent1;
    private javax.swing.JPanel pnUserHeader;
    private javax.swing.JPanel pnUserHeader1;
    private javax.swing.JLabel profilePic;
    private javax.swing.JLabel sisaCutiCounter;
    private javax.swing.JTextField strDate;
    private javax.swing.JTextField strDesc;
    private javax.swing.JTextField strID;
    private javax.swing.JTextField strRequestId;
    private javax.swing.JTextField strType;
    private javax.swing.JTable tbAllUser;
    private javax.swing.JTable tbHistory;
    private javax.swing.JTable tbManagerUserRequest;
    private javax.swing.JTable tbRequestStatus;
    private javax.swing.JTextField tfIdManager;
    private javax.swing.JTextField tfJobsTitle;
    private javax.swing.JTextField tfLeaveLeft;
    private javax.swing.JTextField tfLocationFile;
    private javax.swing.JTextField tfRegEmail;
    private javax.swing.JTextField tfRegFirstName;
    private javax.swing.JTextField tfRegLastName;
    private javax.swing.JPasswordField tfRegPass1;
    private javax.swing.JPasswordField tfRegPass2;
    private javax.swing.JTextField tfRegUsername;
    private javax.swing.JTextField tfSelectedRequest;
    private javax.swing.JTextField tfSelectedRequestDate;
    private javax.swing.JTextField tfSelectedRequestDesc;
    private javax.swing.JTextField tfSelectedRequestPengajuan;
    private javax.swing.JTextField tfSelectedRequestStatus;
    private javax.swing.JTextField tfSelectedUser;
    private javax.swing.JTextField tfUserEmail;
    private javax.swing.JTextField tfUserID;
    private javax.swing.JTextField tfUserName;
    private javax.swing.JPasswordField tfUserPassword;
    private javax.swing.JTextField tfUserTotal;
    // End of variables declaration//GEN-END:variables
}
