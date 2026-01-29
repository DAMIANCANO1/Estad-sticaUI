/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pruebas;

/**
 *
 * @author Damian
 */
public class TablaIntervalo extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TablaIntervalo.class.getName());

    /**
     * Creates new form TablaIntervalo
     */
    public TablaIntervalo() {
        initComponents();
        this.setTitle("VARIANZA");
        this.setLocationRelativeTo(null);
    }

    public void FinalVarianza() {
        String A = (Entrada.getText());
        String[] lineas = A.split("\\n");
        double numeros[] = new double[lineas.length];

        for (int i = 0; i < lineas.length; i++) {
            numeros[i] = Double.parseDouble(lineas[i]);
        }

        double mayor = numeros[0];
        double menor = numeros[0];

        for (int Y = 0; Y < numeros.length; Y++) {
            if (mayor < numeros[Y]) {
                mayor = numeros[Y];
            }
            if (menor > numeros[Y]) {
                menor = numeros[Y];
            }
        }

        double rango = (mayor - menor);
        int intervalo = (int) Math.round(1 + 3.322 * Math.log10(numeros.length));
        double amplitud = rango / intervalo;

        double[] limitesInferiores = new double[intervalo];
        double[] marcasClase = new double[intervalo];
        double[] frecuencias = new double[intervalo];
        double[] fa = new double[intervalo];

        double LimiteInferior = menor;
        double LimiteSuperior;
        double Clases;
        double Igual = 0;
        double Suma = 0;

        for (int X = 0; X < intervalo; X++) {
            LimiteSuperior = (LimiteInferior + amplitud);
            Clases = (LimiteInferior + LimiteSuperior) / 2;

            for (int K = 0; K < numeros.length; K++) {
                if (X == intervalo - 1) {
                    if (numeros[K] >= LimiteInferior && numeros[K] <= LimiteSuperior) {
                        Igual++;
                    }
                } else {
                    if (numeros[K] >= LimiteInferior && numeros[K] < LimiteSuperior) {
                        Igual++;
                    }
                }
            }

            Suma = Suma + Igual;

            limitesInferiores[X] = LimiteInferior;
            marcasClase[X] = Clases;
            frecuencias[X] = Igual;
            fa[X] = Suma;

            Tabla.setValueAt(LimiteInferior + " -- " + LimiteSuperior, X, 0);
            Tabla.setValueAt(Igual, X, 1);
            Tabla.setValueAt(Suma, X, 2);
            Tabla.setValueAt(Clases, X, 3);

            Igual = 0;
            LimiteInferior = LimiteSuperior;
        }

        double N = numeros.length;

        double sumaMedia = 0;
        for (int i = 0; i < intervalo; i++) {
            sumaMedia = sumaMedia + (frecuencias[i] * marcasClase[i]);
        }
        double media = sumaMedia / N;

        double moda = 0;
        int idxModa = 0;
        double maxFrecuencia = -1;

        for (int i = 0; i < intervalo; i++) {
            if (frecuencias[i] > maxFrecuencia) {
                maxFrecuencia = frecuencias[i];
                idxModa = i;
            }
        }

        double Li_Moda = limitesInferiores[idxModa];
        double fi_Moda = frecuencias[idxModa];
        double fi_Ant = (idxModa == 0) ? 0 : frecuencias[idxModa - 1];
        double fi_Sig = (idxModa == intervalo - 1) ? 0 : frecuencias[idxModa + 1];

        double d1 = fi_Moda - fi_Ant;
        double d2 = fi_Moda - fi_Sig;

        moda = Li_Moda + ((d1 / (d1 + d2)) * amplitud);

        double mediana = 0;
        double posMediana = N / 2;
        int idxMediana = 0;

        for (int i = 0; i < intervalo; i++) {
            if (fa[i] >= posMediana) {
                idxMediana = i;
                break;
            }
        }

        double Li_Mediana = limitesInferiores[idxMediana];
        double Fi_Anterior = (idxMediana == 0) ? 0 : fa[idxMediana - 1];
        double fi_Mediana = frecuencias[idxMediana];

        mediana = Li_Mediana + (((posMediana - Fi_Anterior) / fi_Mediana) * amplitud);

        double sumaVarianza = 0;
        for (int i = 0; i < intervalo; i++) {
            double diferencia = marcasClase[i] - media;
            double cuadrado = diferencia * diferencia;
            sumaVarianza = sumaVarianza + (frecuencias[i] * cuadrado);
        }
        double varianza = sumaVarianza / (N - 1);

        double estandar = Math.sqrt(varianza);

        SalidaMedia.setText(" " + media);
        SalidaModa.setText(" " + moda);
        SalidaMediana.setText(" " + mediana);
        SalidaVarianza.setText(" " + varianza);
        SalidaEstandar.setText(" " + estandar);
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        Entrada = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        SalidaMediana = new javax.swing.JTextField();
        jlavbel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SalidaMedia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        SalidaModa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SalidaVarianza = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        SalidaEstandar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Elephant", 0, 48)); // NOI18N
        jLabel1.setText("TABLA DE FRECUENCIAS ");

        jButton1.setBackground(new java.awt.Color(204, 204, 255));
        jButton1.setText("Ejecutar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null}
            },
            new String [] {
                "Datos ", "Frecuencias", "Frecuencia Acumulada", "X"
            }
        ));
        Tabla.setGridColor(new java.awt.Color(0, 0, 0));
        Tabla.setSelectionBackground(new java.awt.Color(0, 0, 0));
        Tabla.setShowGrid(true);
        jScrollPane1.setViewportView(Tabla);

        Entrada.setColumns(20);
        Entrada.setRows(5);
        jScrollPane2.setViewportView(Entrada);

        jLabel2.setFont(new java.awt.Font("Elephant", 0, 18)); // NOI18N
        jLabel2.setText("INGRESA TUS DATOS");

        jlavbel.setText("Mediana");

        jLabel4.setText("Media ");

        jLabel5.setText("Moda");

        jLabel6.setText("Varianza");

        jLabel7.setText("D. Estandar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(143, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(260, 260, 260))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SalidaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SalidaModa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(jlavbel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SalidaMediana, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jButton1)
                                .addGap(289, 289, 289))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SalidaVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SalidaEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SalidaMediana, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(SalidaMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(SalidaModa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(SalidaVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(SalidaEstandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlavbel))
                .addGap(64, 64, 64)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FinalVarianza();
    }//GEN-LAST:event_jButton1ActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new TablaIntervalo().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Entrada;
    private javax.swing.JTextField SalidaEstandar;
    private javax.swing.JTextField SalidaMedia;
    private javax.swing.JTextField SalidaMediana;
    private javax.swing.JTextField SalidaModa;
    private javax.swing.JTextField SalidaVarianza;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlavbel;
    // End of variables declaration//GEN-END:variables
}
