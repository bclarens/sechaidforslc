package user;

import Testing.UserTesting;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import utilities.*;

public class UTesting extends javax.swing.JFrame {
    String s;
    
    String[] temppath;
    String[] tempimgname;
    sqlcon dbconn = new sqlcon();
    Connection connect = null;
    PreparedStatement pstate = null;
    Statement state = null;
    ResultSet resset = null;
    
    //classes
    retrieve_str retstr = new retrieve_str();
    rw_data wrdata = new rw_data();
    writefeatures tstr  = new writefeatures();
    checklist chk = new checklist();
    combo x = new combo();  
    progressbar progbar = new progressbar();
    usercreate create = new usercreate();
    
    String tablename = wrdata.readsession(0);
    //Feat+tablename
    public UTesting(){
        initComponents();
        this.setLocationRelativeTo(null);
        label_username.setText(wrdata.readsession(1));
        initUser();
        showfeatx();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        Task = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        Title = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        label_username = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Body = new javax.swing.JPanel();
        Specification = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_browse = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        labelimg = new javax.swing.JTextField();
        btn_prepare = new javax.swing.JButton();
        ImagePreview = new javax.swing.JPanel();
        jpanel7 = new javax.swing.JPanel();
        imgprevcas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Evaluation = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Data = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_summaryx = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Task.setBackground(new java.awt.Color(191, 191, 191));

        jButton2.setBackground(new java.awt.Color(204, 0, 0));
        jButton2.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("X");
        jButton2.setFocusPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TaskLayout = new javax.swing.GroupLayout(Task);
        Task.setLayout(TaskLayout);
        TaskLayout.setHorizontalGroup(
            TaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TaskLayout.createSequentialGroup()
                .addContainerGap(896, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        TaskLayout.setVerticalGroup(
            TaskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaskLayout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLayeredPane1.add(Task);
        Task.setBounds(0, 0, 970, 40);

        Title.setBackground(new java.awt.Color(93, 91, 87));
        Title.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/admin/Admin Logo.png"))); // NOI18N
        Title.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 58, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("CHAID for Skin Lesion");
        Title.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Classification");
        Title.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 161, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/admin/Admin Profile.png"))); // NOI18N
        Title.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, 50, 60));

        label_username.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        label_username.setForeground(new java.awt.Color(255, 255, 255));
        label_username.setText("John Doe");
        Title.add(label_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 30, 100, -1));

        jLayeredPane1.add(Title);
        Title.setBounds(0, 40, 970, 80);

        jPanel3.setBackground(new java.awt.Color(93, 91, 87));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jLayeredPane1.add(jPanel3);
        jPanel3.setBounds(0, 110, 0, 580);

        Body.setBackground(new java.awt.Color(255, 255, 255));

        Specification.setBackground(new java.awt.Color(93, 91, 87));

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Specification");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        btn_browse.setBackground(new java.awt.Color(204, 204, 204));
        btn_browse.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btn_browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/admin/Icon Browse.png"))); // NOI18N
        btn_browse.setText("Browse");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel6.setText("Filename");

        labelimg.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N

        btn_prepare.setBackground(new java.awt.Color(30, 144, 255));
        btn_prepare.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        btn_prepare.setForeground(new java.awt.Color(255, 255, 255));
        btn_prepare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/admin/Icon Prepare.png"))); // NOI18N
        btn_prepare.setText("Prepare");
        btn_prepare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prepareActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelimg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_browse, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_prepare, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_browse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6)
                    .addComponent(labelimg, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_prepare, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout SpecificationLayout = new javax.swing.GroupLayout(Specification);
        Specification.setLayout(SpecificationLayout);
        SpecificationLayout.setHorizontalGroup(
            SpecificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpecificationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SpecificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(SpecificationLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 789, Short.MAX_VALUE)))
                .addContainerGap())
        );
        SpecificationLayout.setVerticalGroup(
            SpecificationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SpecificationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ImagePreview.setBackground(new java.awt.Color(93, 91, 87));

        jpanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpanel7Layout = new javax.swing.GroupLayout(jpanel7);
        jpanel7.setLayout(jpanel7Layout);
        jpanel7Layout.setHorizontalGroup(
            jpanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgprevcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpanel7Layout.setVerticalGroup(
            jpanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgprevcas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Image Preview");

        javax.swing.GroupLayout ImagePreviewLayout = new javax.swing.GroupLayout(ImagePreview);
        ImagePreview.setLayout(ImagePreviewLayout);
        ImagePreviewLayout.setHorizontalGroup(
            ImagePreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagePreviewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImagePreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(ImagePreviewLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 347, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ImagePreviewLayout.setVerticalGroup(
            ImagePreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagePreviewLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Evaluation.setBackground(new java.awt.Color(93, 91, 87));

        jLabel9.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Evaluation");

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout EvaluationLayout = new javax.swing.GroupLayout(Evaluation);
        Evaluation.setLayout(EvaluationLayout);
        EvaluationLayout.setHorizontalGroup(
            EvaluationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvaluationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(EvaluationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(EvaluationLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 305, Short.MAX_VALUE)))
                .addContainerGap())
        );
        EvaluationLayout.setVerticalGroup(
            EvaluationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EvaluationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Data.setBackground(new java.awt.Color(93, 91, 87));

        jLabel10.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Data");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        table_summaryx.setFont(new java.awt.Font("Lucida Sans", 1, 12)); // NOI18N
        table_summaryx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Image", "Skin Lesion Classification"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_summaryx.setGridColor(new java.awt.Color(93, 91, 87));
        table_summaryx.setShowHorizontalLines(false);
        table_summaryx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_summaryxMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_summaryx);
        if (table_summaryx.getColumnModel().getColumnCount() > 0) {
            table_summaryx.getColumnModel().getColumn(0).setResizable(false);
            table_summaryx.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DataLayout = new javax.swing.GroupLayout(Data);
        Data.setLayout(DataLayout);
        DataLayout.setHorizontalGroup(
            DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DataLayout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DataLayout.setVerticalGroup(
            DataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Specification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Evaluation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ImagePreview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Specification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagePreview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BodyLayout.createSequentialGroup()
                        .addComponent(Evaluation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Data, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLayeredPane1.add(Body);
        Body.setBounds(10, 120, 940, 570);

        jPanel1.setBackground(new java.awt.Color(93, 91, 87));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 590, Short.MAX_VALUE)
        );

        jLayeredPane1.add(jPanel1);
        jPanel1.setBounds(0, 120, 970, 590);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 962, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(WIDTH);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        JFileChooser filechooser = new JFileChooser();
        //filechooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        filechooser.setCurrentDirectory(new File("E:\\THESIS\\Dataset - Resized"));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.IMAGE", "jpg","png");
        filechooser.setMultiSelectionEnabled(true);
        filechooser.addChoosableFileFilter(filter);
        int result = filechooser.showSaveDialog(null);
        
        if(result == JFileChooser.APPROVE_OPTION){
            File[] selectedfiles = filechooser.getSelectedFiles();
            temppath = new String[selectedfiles.length];
            tempimgname = new String[selectedfiles.length];
            
            for(int i=0; i<selectedfiles.length; i++){
                temppath[i] = selectedfiles[i].getAbsolutePath();       // E:\THESIS\Dataset\sampleimg\S1.jpg    
                tempimgname[i] = retstr.get_name(temppath[i]);          // S1
            }
        }else if(result == JFileChooser.CANCEL_OPTION){
            System.out.println("No Data");
        }
    }//GEN-LAST:event_btn_browseActionPerformed

    private void btn_prepareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prepareActionPerformed
        
        
        wrdata.cleartempdatacas();
        clear_table();
        insert_multiple();
        
        int checkfile = wrdata.checkifempty("tempdatacas.txt");
        // if checkfile = 1, file is not empty
        if(checkfile==1){
            tstr.feature_extractcas(tablename);
        }else{
            System.out.println("File is empty!");
        }
        
        showfeatx();
        UserTesting test = new UserTesting();
        test.UserTest(tablename, jTextArea1);
    }//GEN-LAST:event_btn_prepareActionPerformed

    private void table_summaryxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_summaryxMouseClicked
        int i = table_summaryx.getSelectedRow();
        TableModel fcmodel = table_summaryx.getModel();
        String name = (String)fcmodel.getValueAt(i,0);
        int id = tstr.get_imgidcas(name, tablename);
        byte[] byteimg = getImgBlobcas(id, tablename);
        imgprevcas.setIcon(ResizeImagecas(byteimg));
    }//GEN-LAST:event_table_summaryxMouseClicked
   
    public void insert_multiple(){
        for(int i=0; i<temppath.length; i++){
            String path = temppath[i];
            String name = tempimgname[i];
             
            //check if image exists in the database. 0 - image exists ; 1 - image does not exist
            if(chk.checknamecas(name, tablename)==0){
                System.out.println(name+" already exists!");
            }else if(chk.checknamecas(name, tablename)==1){
                insert_image(tablename,path, name);
                String featimg = retstr.feat_imgname(path);      // S1.jpg
                String featdir = retstr.feat_folderpath(path);   // E:\THESIS\Dataset\sampleimg
                wrdata.writedata_cas(featimg, featdir);          // write filename,filedir to tempdata.txt
                JOptionPane.showMessageDialog(null, "Data Inserted!");
            }
        } 
    }
    
    public void insert_image(String tn, String path, String name){
        connect = dbconn.getConnection();
        int result;
        try{
//            String query = "INSERT INTO dataset(img, img_name) VALUES (?,?)";
            String query = "INSERT INTO "+tn+"data"+"(img, img_name) VALUES (?,?)";
            pstate = connect.prepareStatement(query);
            InputStream is = new FileInputStream(new File(path));
            pstate.setBlob(1, is);
            pstate.setString(2, name);
            //pstate.setInt(3, Integer.parseInt(wrdata.readsession(1)));
            result = pstate.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void initUser(){
        create.createTable_data(wrdata.readsession(0));
        create.createTable_feat(wrdata.readsession(0));
    }
    
    public void clear_table(){
        DefaultTableModel model = (DefaultTableModel)table_summaryx.getModel();
        model.setRowCount(0);
    }
    
    public byte[] getImgBlobcas(int idimg, String tablename){
        Connection cnct = dbconn.getConnection();
        PreparedStatement pstate = null;
        ResultSet resset = null;
        
        try{
            String sql = "SELECT img from "+tablename+"data WHERE img_id = "+idimg;
            pstate = cnct.prepareStatement(sql);
            resset = pstate.executeQuery(sql);
            
            while(resset.next()){
                Blob imgblob = resset.getBlob("img");
                return imgblob.getBytes(1, (int) imgblob.length());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ImageIcon ResizeImagecas(byte[] imgpath){
        ImageIcon myimage = new ImageIcon(imgpath);
        Image img = myimage.getImage();
        Image newimg = img.getScaledInstance(imgprevcas.getWidth(), imgprevcas.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimg);
        return image;
    }
    
    public void showfeatx(){
        ArrayList<Featx> flist = featxList(tablename);
        DefaultTableModel model = (DefaultTableModel)table_summaryx.getModel(); 
         Object[] row = new Object[6];
         
         for(int i=0; i<flist.size(); i++){
             row[0] = flist.get(i).getImgName();
             //row[1] = flist.get(i).getImgClass();
             model.addRow(row); 
         }
    }
    
    public ArrayList<Featx> featxList(String tablename){
        ArrayList<Featx> featxList = new ArrayList<Featx>();
        
        Connection cnct = dbconn.getConnection();
        Statement state = null;
        ResultSet resset;
        
        try{
           String sql = "SELECT img_id, img_name, img_grp FROM "+tablename+"data ORDER BY img_name DESC";
            state = cnct.createStatement();
            resset = state.executeQuery(sql);
            Featx feat;
            
            while(resset.next()){
                feat = new Featx(resset.getInt("img_id"),resset.getString("img_name"),resset.getString("img_grp"));
                 featxList.add(feat);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return featxList;
    }
    
    void setColor (JPanel a, JPanel b)
    {
        a.setBackground(new Color(132,131,113));
        b.setBackground(new Color(255,179,123));
    }
    
    void reset (JPanel a, JPanel b)
    {
        a.setBackground(new Color(93,91,87));
        b.setBackground(new Color(93,91,87));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultpstate="collapsed" desc=" Look and feel setting code (optional) ">
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UTesting.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UTesting().setVisible(true);
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Data;
    private javax.swing.JPanel Evaluation;
    private javax.swing.JPanel ImagePreview;
    private javax.swing.JPanel Specification;
    private javax.swing.JPanel Task;
    private javax.swing.JPanel Title;
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_prepare;
    private javax.swing.JLabel imgprevcas;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel jpanel7;
    private javax.swing.JLabel label_username;
    private javax.swing.JTextField labelimg;
    private javax.swing.JTable table_summaryx;
    // End of variables declaration//GEN-END:variables
}