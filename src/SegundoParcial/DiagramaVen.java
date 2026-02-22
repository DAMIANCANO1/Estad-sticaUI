/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package SegundoParcial;
import java.util.ArrayList;


/**
 *
 * @author damia
 */
public class DiagramaVen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DiagramaVen.class.getName());

    /**
     * Creates new form DiagramaVen
     */
    public DiagramaVen() {
        initComponents();
        this.setTitle("DIAGRAMA DE VEN");
        this.setLocationRelativeTo(null);
    }

    public void DiagramaEntero() {

        String DatosTotales = (EntradaTotal.getText());
        String[] ContTotal = DatosTotales.split("\\n");
        int Total[] = new int[ContTotal.length];

        String DatosA = (EntradaA.getText());
        String[] ContA = DatosA.split("\\n");
        int TotalA[] = new int[ContA.length];

        String DatosB = (EntradaB.getText());
        String[] ContB = DatosB.split("\\n");
        int TotalB[] = new int[ContB.length];

        for (int i = 0; i < ContA.length; i++) {
            TotalA[i] = Integer.parseInt(ContA[i].trim());
        }

        for (int i = 0; i < ContB.length; i++) {
            TotalB[i] = Integer.parseInt(ContB[i].trim());
        }

        for (int i = 0; i < ContTotal.length; i++) {
            Total[i] = Integer.parseInt(ContTotal[i].trim());
        }
        ArrayList<Integer> ListaAB = new ArrayList<>();

        for (int i = 0; i < TotalA.length; i++) {
            for (int j = 0; j < TotalB.length; j++) {
                if (TotalA[i] == TotalB[j]) {
                    SalidaAB.append(TotalA[i] + "\n");
                    ListaAB.add(TotalA[i]);
                }
            }
        }

        ArrayList<Integer> ListaA = new ArrayList<>();

        for (int i = 0; i < TotalA.length; i++) {
            boolean Bandera = false;
            for (int j = 0; j < ListaAB.size(); j++) {
                if (ListaAB.get(j) == TotalA[i]) {
                    Bandera = true;
                    break;
                }
            }
            if (Bandera == false) {
                SalidaA.append(TotalA[i] + "\n");
                ListaA.add(TotalA[i]);
            }
        }

        ArrayList<Integer> ListaB = new ArrayList<>();

        for (int i = 0; i < TotalB.length; i++) {
            boolean Bandera = false;
            for (int j = 0; j < ListaAB.size(); j++) {
                if (ListaAB.get(j) == TotalB[i]) {
                    Bandera = true;
                    break;
                }
            }
            if (Bandera == false) {
                SalidaB.append(TotalB[i] + "\n");
                ListaB.add(TotalB[i]);
            }
        }
        //aqui se compara si todos los datos ingresados estan en A o B 
        // en caso de que no esten se imprimen los numeros afuera de los circulos
        //De igual manera se crea una lista para despues hacer las operaciones 
        ArrayList<Integer> ListaAfuera = new ArrayList<>();

        for (int j = 0; j < Total.length; j++) {
            boolean Bandera2 = false;

            for (int i = 0; i < TotalA.length; i++) {
                Bandera2 = false;

                if (Total[j] == TotalA[i]) {
                    Bandera2 = true;
                    break;
                }

            }
            if (Bandera2 == false) {
                boolean Bandera2_1 = false;
                for (int i = 0; i < TotalB.length; i++) {
                    if (Total[j] == TotalB[i]) {
                        Bandera2_1 = true;
                    }
                }
                if (Bandera2_1 == false) {
                    SalidaTotal.append(Total[j] + "\n");
                    ListaAfuera.add(Total[j]);
                }
            }
        }
        // en el siguuiente apartado se realiza la manera en la que se hacen
        // las operaciones de cada apartado previamente definido por el
        // programa para que el usuario solo vea los resultados segun la operacion 

        // A y B union (abarca los dos circulos completos)
        // Se tendra que sumar todas las listas de A, B y la interseccion de las dos
        // para luego dividirlo entre el numero total de numeros
        double PrimeraU = (double) (ListaAB.size() + ListaA.size() + ListaB.size()) / Total.length;
        double Interseccion = (double) ListaAB.size() / Total.length;
        double FueraDeA = (double) (ListaB.size() + ListaAfuera.size()) / Total.length;
        double FueraDeB = (double) (ListaA.size() + ListaAfuera.size()) / Total.length;
        double AUBnegado = (double) ListaAfuera.size() / Total.length;
        double Fuera = (double) (ListaA.size() + ListaB.size() + ListaAfuera.size()) / Total.length;
        SalidaAuB1.setText(PrimeraU + "%");
        SalidaInterseccion.setText(Interseccion + "%");
        SalidaSinA.setText(FueraDeA + "%");
        SalidaSinB1.setText(FueraDeB + "%");
        SalidaTodos.setText(AUBnegado + "%");
        SalidaA_B_TODOS.setText(Fuera + "%");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SalidaAB = new javax.swing.JTextArea();
        SalidaB = new javax.swing.JTextArea();
        SalidaTotal = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        SalidaA = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        EntradaB = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        EntradaTotal = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        EntradaA = new javax.swing.JTextArea();
        BtnEntero = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        SalidaA_B_TODOS = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SalidaAuB1 = new javax.swing.JLabel();
        SalidaInterseccion = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SalidaSinA = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        SalidaSinB1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        SalidaTodos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SalidaAB.setColumns(20);
        SalidaAB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SalidaAB.setRows(5);
        jPanel1.add(SalidaAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, 50, -1));

        SalidaB.setColumns(20);
        SalidaB.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SalidaB.setRows(5);
        jPanel1.add(SalidaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 50, -1));

        SalidaTotal.setColumns(20);
        SalidaTotal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SalidaTotal.setRows(5);
        jPanel1.add(SalidaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 50, -1));

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setFont(new java.awt.Font("Elephant", 0, 36)); // NOI18N
        jLabel2.setText("DIAGRAMA DE VENN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 6, -1, -1));

        SalidaA.setColumns(20);
        SalidaA.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SalidaA.setRows(5);
        jPanel1.add(SalidaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 50, -1));

        jLabel3.setText("INGRESA TUS DATOS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 90, -1, -1));

        jLabel4.setText("INGRESA TUS DATOS A");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 260, -1, -1));

        jLabel5.setText("INGRESA TUS DATOS B");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 430, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Tabla.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 63, 921, 527));

        EntradaB.setColumns(20);
        EntradaB.setRows(5);
        EntradaB.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EntradaB.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(EntradaB);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 460, 226, 104));

        EntradaTotal.setColumns(20);
        EntradaTotal.setRows(5);
        EntradaTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EntradaTotal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(EntradaTotal);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 226, 122));

        EntradaA.setColumns(20);
        EntradaA.setRows(5);
        EntradaA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        EntradaA.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(EntradaA);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 290, 226, 116));

        BtnEntero.setText("EJECUTAR");
        BtnEntero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnteroActionPerformed(evt);
            }
        });
        jPanel1.add(BtnEntero, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 580, -1, -1));

        jLabel6.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        jLabel6.setText("RESULTADOS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 590, -1, -1));

        SalidaA_B_TODOS.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalidaA_B_TODOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SalidaA_B_TODOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 740, 90, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("P (A N B negados)");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 740, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("P (A U B)");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 640, -1, -1));

        SalidaAuB1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalidaAuB1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SalidaAuB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 640, 90, 30));

        SalidaInterseccion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalidaInterseccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SalidaInterseccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 690, 90, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("P (A N B)");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 690, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("P (A)");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 730, -1, -1));

        SalidaSinA.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalidaSinA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SalidaSinA, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 740, 90, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("P (B)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 640, -1, -1));

        SalidaSinB1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalidaSinB1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SalidaSinB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 640, 90, 30));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("P (A U B negado) ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 690, 140, -1));

        SalidaTodos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SalidaTodos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(SalidaTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 690, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1263, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEnteroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnteroActionPerformed
        DiagramaEntero();
    }//GEN-LAST:event_BtnEnteroActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new DiagramaVen().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEntero;
    private javax.swing.JTextArea EntradaA;
    private javax.swing.JTextArea EntradaB;
    private javax.swing.JTextArea EntradaTotal;
    private javax.swing.JTextArea SalidaA;
    private javax.swing.JTextArea SalidaAB;
    private javax.swing.JLabel SalidaA_B_TODOS;
    private javax.swing.JLabel SalidaAuB1;
    private javax.swing.JTextArea SalidaB;
    private javax.swing.JLabel SalidaInterseccion;
    private javax.swing.JLabel SalidaSinA;
    private javax.swing.JLabel SalidaSinB1;
    private javax.swing.JLabel SalidaTodos;
    private javax.swing.JTextArea SalidaTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
