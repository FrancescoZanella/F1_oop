package graphics;

import database.DataConstructor;
import database.DataDriver;
import database.Utils;
import domain_classes.Driver;
import domain_classes.F1_Item;
import domain_classes.Squad;
import domain_classes.Team;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Objects;





    public class TeamPage extends JPanel implements MouseListener, ListSelectionListener {
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel13;
        private javax.swing.JLabel jLabel14;
        private javax.swing.JLabel jLabel15;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JList<F1_Item> jList1;
        private javax.swing.JPanel jPanel2;
        private MyPanel jPanel3;
        private javax.swing.JScrollPane jScrollPane1;

        JLabel a;
        String current_user;
        Team t;
        DataDriver d=new DataDriver();
        DataConstructor d1=new DataConstructor();
        DefaultListModel<F1_Item> dd=new DefaultListModel<>();

        public TeamPage(String current_user){

            jPanel3 =new MyPanel(250,100, Utils.width-250,500,"src/resources/background/Cattura1.jpg");
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jScrollPane1 = new javax.swing.JScrollPane();
            jList1 = new javax.swing.JList<F1_Item>();
            jPanel2 = new javax.swing.JPanel();
            jLabel8 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();

            this.current_user = current_user;
            t = new Team();

            setPreferredSize(new java.awt.Dimension(1030, 500));

            jPanel2.setBackground(new java.awt.Color(250, 0, 0));

            jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel1.setText("                              Save Team ");

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            );

            jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(255, 0, 0));
            jLabel2.setText("Team Unsaved !");

            jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
            jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_business_building_35px_1.png")); // NOI18N
            jLabel3.setText(current_user);

            jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
            jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_coins_35px_2.png")); // NOI18N
            jLabel4.setText("Crediti rimanenti "+ t.getBudget()+" M");
            jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

            jScrollPane1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

            jList1.setBackground(new java.awt.Color(69, 73, 74));
            jList1.setForeground(new java.awt.Color(255, 255, 255));

            jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
            jList1.setVisibleRowCount(20);
            jScrollPane1.setViewportView(jList1);

            jPanel3.setBackground(new java.awt.Color(255, 255, 255));
            jPanel3.setPreferredSize(new java.awt.Dimension(445, 500));

            jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_plus_35px_2.png")); // NOI18N
            jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_plus_35px_2.png")); // NOI18N
            jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_plus_35px_2.png")); // NOI18N
            jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
            jLabel12.setForeground(Color.WHITE);
            jLabel12.setFont(new Font("Tahoma",Font.PLAIN,8));

            jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_plus_35px_2.png")); // NOI18N
            jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabel13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_plus_35px_2.png")); // NOI18N
            jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\franc\\Desktop\\Università\\F1_oop\\src\\resources\\icons\\icons8_plus_35px_2.png")); // NOI18N
            jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

            javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
            jPanel3.setLayout(jPanel3Layout);
            jPanel3Layout.setHorizontalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(145, 145, 145)
                                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(46, 46, 46)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addGap(86, 86, 86)
                                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(47, 47, 47)
                                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(64, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(177, 177, 177))
            );
            jPanel3Layout.setVerticalGroup(
                    jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(98, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            this.setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(61, 61, 61)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(143, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGap(15, 15, 15)
                                                                    .addComponent(jLabel3)
                                                                    .addGap(30, 30, 30)
                                                                    .addComponent(jLabel4))
                                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel2))
                                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap(23, Short.MAX_VALUE))
            );

            jList1.setEnabled(false);
            jLabel1.addMouseListener(this);
            jLabel8.addMouseListener(this);
            jLabel11.addMouseListener(this);
            jLabel12.addMouseListener(this);
            jLabel13.addMouseListener(this);
            jLabel14.addMouseListener(this);
            jLabel15.addMouseListener(this);

            jList1.addListSelectionListener(this);
            jList1.setModel(dd);
            for(Driver h : d.getAllDrivers()){
                dd.addElement(h);
            }
            jLabel11.setForeground(Color.WHITE);
            jLabel11.setFont(new Font("Tahoma",Font.PLAIN,8));
            jLabel13.setForeground(Color.WHITE);
            jLabel13.setFont(new Font("Tahoma",Font.PLAIN,8));
            jLabel15.setForeground(Color.WHITE);
            jLabel15.setFont(new Font("Tahoma",Font.PLAIN,8));
            jLabel8.setForeground(Color.WHITE);
            jLabel8.setFont(new Font("Tahoma",Font.PLAIN,8));





        }
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==jLabel1){
                jLabel2.setText("Team saved");
                // TODO: 02/09/2021
                //metodo per salvare team nel db

            }
            //aggiungi al team
            if(e.getSource()==jLabel11 || e.getSource()==jLabel12 || e.getSource()==jLabel13 || e.getSource()==jLabel15 || e.getSource()==jLabel8){
                jList1.setEnabled(true);
                a=(JLabel) e.getSource();

            }
            //costruttore
            if(e.getSource()==jLabel14){

                jList1.setEnabled(true);
                a=(JLabel) e.getSource();
                dd.clear();
                for(Squad s : d1.getAllConstructors()){
                    dd.addElement(s);
                }




            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            a.setText(jList1.getSelectedValue().getName());
            a.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/icons/"+jList1.getSelectedValue().getName()+".png"))));
            a.setHorizontalTextPosition(SwingConstants.CENTER);
            a.setHorizontalAlignment(SwingConstants.CENTER);
            a.setVerticalAlignment(SwingConstants.CENTER);
            a.setVerticalTextPosition(SwingConstants.BOTTOM);
            jList1.setEnabled(false);
        }
    }


