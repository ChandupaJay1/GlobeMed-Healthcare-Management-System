/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package report;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import report.MedicalElement;
import report.Reports;

/**
 *
 * @author dulan
 */
public class DataInputDialog extends JDialog {

    private List<MedicalElement> elements;
    private JTextField patientNameField;
    private JTextField diagnosisField;
    private JTextField doctorNameField;
    private JComboBox<String> specializationCombo;
    private JTextField billingAmountField;
    private JTextArea dataPreviewArea;
    private JFrame parentFrame;

    // Modern Color Palette
    private static final Color PRIMARY = new Color(37, 99, 235);
    private static final Color SUCCESS = new Color(16, 185, 129);
    private static final Color WARNING = new Color(245, 158, 11);
    private static final Color DANGER = new Color(239, 68, 68);
    private static final Color GRAY_50 = new Color(249, 250, 251);
    private static final Color GRAY_100 = new Color(243, 244, 246);
    private static final Color GRAY_600 = new Color(75, 85, 99);

    /**
     * Creates new form DataInputDialog
     */
    public DataInputDialog(JFrame parent) {
        super(parent, "Enter Medical Data", true);
        this.parentFrame = parent;
        this.elements = new ArrayList<>();
        initComponents();
        setLocationRelativeTo(parent);
        updatePreview();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        JPanel mainPanel = new JPanel();
        JPanel inputPanel = new JPanel();
        JPanel patientPanel = new JPanel();
        JLabel nameLabel = new JLabel();
        patientNameField = new JTextField();
        JLabel diagnosisLabel = new JLabel();
        diagnosisField = new JTextField();
        JButton addPatientButton = new JButton();
        JPanel doctorPanel = new JPanel();
        JLabel doctorNameLabel = new JLabel();
        doctorNameField = new JTextField();
        JLabel specializationLabel = new JLabel();
        specializationCombo = new JComboBox<>();
        JButton addDoctorButton = new JButton();
        JPanel billingPanel = new JPanel();
        JLabel amountLabel = new JLabel();
        billingAmountField = new JTextField();
        JButton addBillingButton = new JButton();
        JPanel previewPanel = new JPanel();
        JScrollPane previewScrollPane = new JScrollPane();
        dataPreviewArea = new JTextArea();
        JPanel buttonPanel = new JPanel();
        JButton generateReportButton = new JButton();
        JButton clearButton = new JButton();
        JButton cancelButton = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Medical Data Entry");
        setModal(true);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 15));
        inputPanel.setBackground(Color.WHITE);

        // Patient Panel - Updated styling
        patientPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                "Patient Information",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 13),
                GRAY_600));
        patientPanel.setLayout(new GridBagLayout());
        patientPanel.setBackground(Color.WHITE);

        nameLabel.setText("Patient Name:");
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        nameLabel.setForeground(GRAY_600);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);
        patientPanel.add(nameLabel, gbc);

        patientNameField.setPreferredSize(new Dimension(200, 30));
        patientNameField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        patientNameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        patientPanel.add(patientNameField, gbc);

        diagnosisLabel.setText("Diagnosis:");
        diagnosisLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        diagnosisLabel.setForeground(GRAY_600);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        patientPanel.add(diagnosisLabel, gbc);

        diagnosisField.setPreferredSize(new Dimension(200, 30));
        diagnosisField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        diagnosisField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        patientPanel.add(diagnosisField, gbc);

        addPatientButton.setText("Add Patient");
        addPatientButton.setBackground(SUCCESS);
        addPatientButton.setForeground(Color.WHITE);
        addPatientButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        addPatientButton.setFocusPainted(false);
        addPatientButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        addPatientButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPatientButton.addActionListener(evt -> addPatientButtonActionPerformed(evt));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        patientPanel.add(addPatientButton, gbc);

        inputPanel.add(patientPanel);
        inputPanel.add(Box.createVerticalStrut(15));

        // Doctor Panel - Updated styling
        doctorPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                "Doctor Information",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 13),
                GRAY_600));
        doctorPanel.setLayout(new GridBagLayout());
        doctorPanel.setBackground(Color.WHITE);

        doctorNameLabel.setText("Doctor Name:");
        doctorNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        doctorNameLabel.setForeground(GRAY_600);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);
        doctorPanel.add(doctorNameLabel, gbc);

        doctorNameField.setPreferredSize(new Dimension(200, 30));
        doctorNameField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        doctorNameField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        doctorPanel.add(doctorNameField, gbc);

        specializationLabel.setText("Specialization:");
        specializationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        specializationLabel.setForeground(GRAY_600);
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        doctorPanel.add(specializationLabel, gbc);

        specializationCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                "General Practitioner", "Cardiologist", "Dermatologist", "Neurologist",
                "Pediatrician", "Psychiatrist", "Surgeon", "Other"
        }));
        specializationCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        specializationCombo.setPreferredSize(new Dimension(200, 30));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        doctorPanel.add(specializationCombo, gbc);

        addDoctorButton.setText("Add Doctor");
        addDoctorButton.setBackground(PRIMARY);
        addDoctorButton.setForeground(Color.WHITE);
        addDoctorButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        addDoctorButton.setFocusPainted(false);
        addDoctorButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        addDoctorButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addDoctorButton.addActionListener(evt -> addDoctorButtonActionPerformed(evt));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        doctorPanel.add(addDoctorButton, gbc);

        inputPanel.add(doctorPanel);
        inputPanel.add(Box.createVerticalStrut(15));

        // Billing Panel - Updated styling
        billingPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                "Billing Information",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 13),
                GRAY_600));
        billingPanel.setLayout(new GridBagLayout());
        billingPanel.setBackground(Color.WHITE);

        amountLabel.setText("Amount ($):");
        amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        amountLabel.setForeground(GRAY_600);
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);
        billingPanel.add(amountLabel, gbc);

        billingAmountField.setPreferredSize(new Dimension(200, 30));
        billingAmountField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        billingAmountField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        billingPanel.add(billingAmountField, gbc);

        addBillingButton.setText("Add Billing");
        addBillingButton.setBackground(WARNING);
        addBillingButton.setForeground(Color.WHITE);
        addBillingButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        addBillingButton.setFocusPainted(false);
        addBillingButton.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        addBillingButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addBillingButton.addActionListener(evt -> addBillingButtonActionPerformed(evt));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        billingPanel.add(addBillingButton, gbc);

        inputPanel.add(billingPanel);

        mainPanel.add(inputPanel, BorderLayout.WEST);

        // Preview Panel - Updated styling
        previewPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(GRAY_100, 1),
                "Data Preview",
                javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                javax.swing.border.TitledBorder.DEFAULT_POSITION,
                new Font("Segoe UI", Font.BOLD, 13),
                GRAY_600));
        previewPanel.setLayout(new BorderLayout());
        previewPanel.setBackground(Color.WHITE);

        dataPreviewArea.setEditable(false);
        dataPreviewArea.setColumns(35);
        dataPreviewArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        dataPreviewArea.setRows(20);
        dataPreviewArea.setMargin(new Insets(15, 15, 15, 15));
        dataPreviewArea.setBackground(GRAY_50);
        dataPreviewArea.setForeground(GRAY_600);
        previewScrollPane.setViewportView(dataPreviewArea);
        previewScrollPane.setBorder(null);

        previewPanel.add(previewScrollPane, BorderLayout.CENTER);
        mainPanel.add(previewPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Button Panel - Updated placement and styling
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(1, 0, 0, 0, GRAY_100),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 12, 0));

        generateReportButton.setText("Generate Report");
        generateReportButton.setBackground(new Color(139, 69, 19)); // Brown for reports
        generateReportButton.setForeground(Color.WHITE);
        generateReportButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        generateReportButton.setFocusPainted(false);
        generateReportButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        generateReportButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        generateReportButton.addActionListener(evt -> generateReportButtonActionPerformed(evt));
        buttonPanel.add(generateReportButton);

        clearButton.setText("Clear All");
        clearButton.setBackground(DANGER);
        clearButton.setForeground(Color.WHITE);
        clearButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        clearButton.setFocusPainted(false);
        clearButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));
        buttonPanel.add(clearButton);

        cancelButton.setText("Cancel");
        cancelButton.setBackground(GRAY_600);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cancelButton.setFocusPainted(false);
        cancelButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        cancelButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cancelButton.addActionListener(evt -> cancelButtonActionPerformed(evt));
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = patientNameField.getText().trim();
        String diagnosis = diagnosisField.getText().trim();

        if (!name.isEmpty() && !diagnosis.isEmpty()) {
            Patient patient = new Patient(name, diagnosis);
            elements.add(patient);
            updatePreview();
            patientNameField.setText("");
            diagnosisField.setText("");
            JOptionPane.showMessageDialog(this, "Patient added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all patient fields!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String name = doctorNameField.getText().trim();
        String specialization = (String) specializationCombo.getSelectedItem();

        if (!name.isEmpty()) {
            Doctor doctor = new Doctor(name, specialization);
            elements.add(doctor);
            updatePreview();
            doctorNameField.setText("");
            specializationCombo.setSelectedIndex(0);
            JOptionPane.showMessageDialog(this, "Doctor added successfully!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter doctor name!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addBillingButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String amountText = billingAmountField.getText().trim();

        try {
            double amount = Double.parseDouble(amountText);
            if (amount > 0) {
                Billing billing = new Billing(amount);
                elements.add(billing);
                updatePreview();
                billingAmountField.setText("");
                JOptionPane.showMessageDialog(this, "Billing added successfully!",
                        "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Amount must be greater than 0!",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid amount!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateReportButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (elements.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please add some data before generating reports!",
                    "No Data", JOptionPane.WARNING_MESSAGE);
        } else {
            Reports reportsDialog = new Reports(parentFrame, elements);
            reportsDialog.setVisible(true);
        }
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        int result = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to clear all data?",
                "Confirm Clear", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            elements.clear();
            updatePreview();
            JOptionPane.showMessageDialog(this, "All data cleared!",
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void updatePreview() {
        StringBuilder preview = new StringBuilder();
        preview.append("CURRENT DATA SUMMARY\n");
        preview.append("====================\n\n");

        if (elements.isEmpty()) {
            preview.append("No data entered yet.\n");
            preview.append("Use the forms on the left to add:\n");
            preview.append("• Patient information\n");
            preview.append("• Doctor details\n");
            preview.append("• Billing records\n");
        } else {
            int patientCount = 0, doctorCount = 0, billingCount = 0;

            for (MedicalElement element : elements) {
                if (element instanceof Patient) {
                    patientCount++;
                    Patient p = (Patient) element;
                    preview.append(String.format("PATIENT #%d\n", patientCount));
                    preview.append(String.format("├─ Name: %s\n", p.getName()));
                    preview.append(String.format("└─ Diagnosis: %s\n\n", p.getDiagnosis()));
                } else if (element instanceof Doctor) {
                    doctorCount++;
                    Doctor d = (Doctor) element;
                    preview.append(String.format("DOCTOR #%d\n", doctorCount));
                    preview.append(String.format("├─ Name: %s\n", d.getName()));
                    preview.append(String.format("└─ Specialization: %s\n\n", d.getSpecialization()));
                } else if (element instanceof Billing) {
                    billingCount++;
                    Billing b = (Billing) element;
                    preview.append(String.format("BILLING #%d\n", billingCount));
                    preview.append(String.format("└─ Amount: $%.2f\n\n", b.getAmount()));
                }
            }

            preview.append("SUMMARY\n");
            preview.append("-------\n");
            preview.append(String.format("Total Patients: %d\n", patientCount));
            preview.append(String.format("Total Doctors: %d\n", doctorCount));
            preview.append(String.format("Total Billing Records: %d\n", billingCount));
            preview.append(String.format("Total Records: %d\n", elements.size()));
        }

        dataPreviewArea.setText(preview.toString());
        dataPreviewArea.setCaretPosition(0);
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
            java.util.logging.Logger.getLogger(DataInputDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            DataInputDialog dialog = new DataInputDialog(new JFrame());
            dialog.setVisible(true);
        });
    }
}