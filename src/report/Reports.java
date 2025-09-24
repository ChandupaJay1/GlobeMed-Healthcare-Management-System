/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package report;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author chand
 */
public class Reports extends JDialog {

    private List<MedicalElement> elements;
    private JTabbedPane tabbedPane;
    private JTextArea treatmentReportArea;
    private JTextArea financialReportArea;

    /**
     * Creates new form Reports
     */
    public Reports(JFrame parent, List<MedicalElement> elements1) {
        super(parent, "Medical Reports", true);
        this.elements = (elements1 != null) ? elements1 : new ArrayList<>();
        initComponents();
        generateReports();
        setLocationRelativeTo(parent);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JPanel headerPanel = new JPanel();
        JLabel titleLabel = new JLabel();
        JLabel dateLabel = new JLabel();
        tabbedPane = new JTabbedPane();
        JPanel treatmentPanel = new JPanel();
        JScrollPane treatmentScrollPane = new JScrollPane();
        treatmentReportArea = new JTextArea();
        JPanel financialPanel = new JPanel();
        JScrollPane financialScrollPane = new JScrollPane();
        financialReportArea = new JTextArea();
        JPanel buttonPanel = new JPanel();
        JButton printButton = new JButton();
        JButton saveButton = new JButton();
        JButton closeButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medical Reports");
        setModal(true);

        // Modern Header Panel - Updated Colors
        headerPanel.setBackground(new Color(129, 123, 123)); // Modern blue
        headerPanel.setBorder(BorderFactory.createEmptyBorder(20, 25, 20, 25));
        headerPanel.setLayout(new BorderLayout());

        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setText("Medical Reports Dashboard");
        headerPanel.add(titleLabel, BorderLayout.WEST);

        dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        dateLabel.setForeground(new Color(0, 0, 0)); // Light blue
        dateLabel.setText("Generated: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm")));
        headerPanel.add(dateLabel, BorderLayout.EAST);

        getContentPane().add(headerPanel, BorderLayout.NORTH);

        // Treatment Report Tab - Updated styling
        treatmentPanel.setLayout(new BorderLayout());
        treatmentPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        treatmentPanel.setBackground(Color.WHITE);

        treatmentReportArea.setEditable(false);
        treatmentReportArea.setColumns(20);
        treatmentReportArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        treatmentReportArea.setRows(5);
        treatmentReportArea.setMargin(new Insets(20, 20, 20, 20));
        treatmentReportArea.setBackground(new Color(248, 248, 248));//report background
        treatmentReportArea.setForeground(new Color(37, 37, 39));
        treatmentScrollPane.setViewportView(treatmentReportArea);
        treatmentScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(0, 0, 0), 1),
                "Treatment Summary Report",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(0, 0, 0)));

        treatmentPanel.add(treatmentScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Treatment Report", new ImageIcon(), treatmentPanel, "View treatment details and patient information");

        // Financial Report Tab - Updated styling
        financialPanel.setLayout(new BorderLayout());
        financialPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        financialPanel.setBackground(Color.WHITE);

        financialReportArea.setEditable(false);
        financialReportArea.setColumns(20);
        financialReportArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        financialReportArea.setRows(5);
        financialReportArea.setMargin(new Insets(20, 20, 20, 20));
        financialReportArea.setBackground(new Color(249, 250, 251));//second report background
        financialReportArea.setForeground(new Color(17, 24, 39));
        financialScrollPane.setViewportView(financialReportArea);
        financialScrollPane.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
                "Financial Summary Report",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 14),
                new Color(0, 0, 0)));

        financialPanel.add(financialScrollPane, BorderLayout.CENTER);
        tabbedPane.addTab("Financial Report", new ImageIcon(), financialPanel, "View billing and financial information");

        // Modern Tab Styling
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabbedPane.setBackground(new Color(28, 27, 27));
        getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Modern Button Panel - Updated placement and styling
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(229, 231, 235)),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 12, 0));

        // Modern Print Button
        printButton.setText("Print Report");
        printButton.setBackground(new Color(245, 158, 11)); // Amber
        printButton.setForeground(Color.WHITE);
        printButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        printButton.setFocusPainted(false);
        printButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        printButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        printButton.addActionListener(evt -> printButtonActionPerformed(evt));
        buttonPanel.add(printButton);

        // Modern Save Button
        saveButton.setText("Export");
        saveButton.setBackground(new Color(16, 185, 129)); // Emerald
        saveButton.setForeground(Color.WHITE);
        saveButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        saveButton.setFocusPainted(false);
        saveButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.addActionListener(evt -> saveButtonActionPerformed(evt));
        buttonPanel.add(saveButton);

        // Modern Close Button
        closeButton.setText("Close");
        closeButton.setBackground(new Color(107, 114, 128)); // Gray
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        closeButton.setFocusPainted(false);
        closeButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        closeButton.addActionListener(evt -> closeButtonActionPerformed(evt));
        buttonPanel.add(closeButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setSize(900, 650);
    }

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedIndex = tabbedPane.getSelectedIndex();
        JTextArea currentArea = selectedIndex == 0 ? treatmentReportArea : financialReportArea;

        try {
            currentArea.print();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error printing report: " + ex.getMessage(),
                    "Print Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Export Report");
        fileChooser.setSelectedFile(new java.io.File("medical_report_" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt"));

        int userSelection = fileChooser.showSaveDialog(this);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                int selectedIndex = tabbedPane.getSelectedIndex();
                JTextArea currentArea = selectedIndex == 0 ? treatmentReportArea : financialReportArea;

                java.io.FileWriter writer = new java.io.FileWriter(fileChooser.getSelectedFile());
                writer.write(currentArea.getText());
                writer.close();

                JOptionPane.showMessageDialog(this,
                        "Report exported successfully!",
                        "Export Success",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,
                        "Error exporting report: " + ex.getMessage(),
                        "Export Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void generateReports() {
        // Generate Treatment Report
        String treatmentReport = generateReport(new TreatmentReportVisitor(), "TREATMENT REPORT");
        treatmentReportArea.setText(treatmentReport);
        treatmentReportArea.setCaretPosition(0);

        // Generate Financial Report
        String financialReport = generateReport(new FinancialReportVisitor(), "FINANCIAL REPORT");
        financialReportArea.setText(financialReport);
        financialReportArea.setCaretPosition(0);
    }

    private String generateReport(ReportVisitor visitor, String reportTitle) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream oldOut = System.out;
        System.setOut(ps);

        // Modern Report Header Design
        System.out.println("┌─────────────────────────────────────────────────────────────────┐");
        System.out.println("│                        " + reportTitle + "                        │");
        System.out.println("└─────────────────────────────────────────────────────────────────┘");
        System.out.println();
        System.out.println("📅 Generated: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        System.out.println("📊 Total Records: " + elements.size());
        System.out.println();
        System.out.println("─".repeat(65));
        System.out.println();

        for (MedicalElement element : elements) {
            element.accept(visitor);
        }

        System.out.println();
        System.out.println("─".repeat(65));
        System.out.println("✓ End of Report");
        System.out.println();

        System.out.flush();
        System.setOut(oldOut);

        return baos.toString();
    }

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            // Create the sample elements as a local variable in the static context
            java.util.List<MedicalElement> sampleElements = new java.util.ArrayList<>();
            sampleElements.add(new Patient("Kasun", "Flu"));
            sampleElements.add(new Doctor("Dr. Shasha", "Dermatologist"));
            sampleElements.add(new Billing(2500.0));

            // Pass the local variable to the constructor
            Reports dialog = new Reports(new JFrame(), sampleElements);
            dialog.setVisible(true);
        });
    }
}