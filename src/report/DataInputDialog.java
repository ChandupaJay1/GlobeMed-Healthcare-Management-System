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
 * @author chand
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

    // FlatDarculaLaf Compatible Color Palette
    // These colors work well with FlatDarculaLaf's base theme
    private static final Color PRIMARY = new Color(98, 151, 255);      // Darcula blue accent
    private static final Color SUCCESS = new Color(98, 187, 70);       // Green accent
    private static final Color WARNING = new Color(255, 156, 67);      // Orange accent
    private static final Color DANGER = new Color(255, 108, 108);      // Red accent
    private static final Color BROWN = new Color(187, 134, 88);        // Brown for reports

    // Let FlatDarculaLaf handle most background/text colors,
    // but define some for custom styling
    private static final Color DARK_SURFACE = new Color(43, 43, 43);
    private static final Color DARK_ELEVATED = new Color(54, 54, 54);

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

        // Main panel - let FlatDarculaLaf handle background
        mainPanel.setLayout(new BorderLayout());

        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 15));

        // Patient Panel with enhanced styling
        patientPanel.setBorder(BorderFactory.createTitledBorder(
                "Patient Information"));
        patientPanel.setLayout(new GridBagLayout());

        nameLabel.setText("Patient Name:");
        nameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);
        patientPanel.add(nameLabel, gbc);

        patientNameField.setPreferredSize(new Dimension(200, 32));
        patientNameField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        patientPanel.add(patientNameField, gbc);

        diagnosisLabel.setText("Diagnosis:");
        diagnosisLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        patientPanel.add(diagnosisLabel, gbc);

        diagnosisField.setPreferredSize(new Dimension(200, 32));
        diagnosisField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        patientPanel.add(diagnosisField, gbc);

        addPatientButton = createAccentButton("Add Patient", SUCCESS);
        addPatientButton.addActionListener(evt -> addPatientButtonActionPerformed(evt));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        patientPanel.add(addPatientButton, gbc);

        inputPanel.add(patientPanel);
        inputPanel.add(Box.createVerticalStrut(15));

        // Doctor Panel
        doctorPanel.setBorder(BorderFactory.createTitledBorder("Doctor Information"));
        doctorPanel.setLayout(new GridBagLayout());

        doctorNameLabel.setText("Doctor Name:");
        doctorNameLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);
        doctorPanel.add(doctorNameLabel, gbc);

        doctorNameField.setPreferredSize(new Dimension(200, 32));
        doctorNameField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        doctorPanel.add(doctorNameField, gbc);

        specializationLabel.setText("Specialization:");
        specializationLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0;
        gbc.fill = GridBagConstraints.NONE;
        doctorPanel.add(specializationLabel, gbc);

        specializationCombo.setModel(new DefaultComboBoxModel<>(new String[] {
                "General Practitioner", "Cardiologist", "Dermatologist", "Neurologist",
                "Pediatrician", "Psychiatrist", "Surgeon", "Other"
        }));
        specializationCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        specializationCombo.setPreferredSize(new Dimension(200, 32));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        doctorPanel.add(specializationCombo, gbc);

        addDoctorButton = createAccentButton("Add Doctor", PRIMARY);
        addDoctorButton.addActionListener(evt -> addDoctorButtonActionPerformed(evt));
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        doctorPanel.add(addDoctorButton, gbc);

        inputPanel.add(doctorPanel);
        inputPanel.add(Box.createVerticalStrut(15));

        // Billing Panel
        billingPanel.setBorder(BorderFactory.createTitledBorder("Billing Information"));
        billingPanel.setLayout(new GridBagLayout());

        amountLabel.setText("Amount ($):");
        amountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc = new GridBagConstraints();
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(8, 8, 8, 8);
        billingPanel.add(amountLabel, gbc);

        billingAmountField.setPreferredSize(new Dimension(200, 32));
        billingAmountField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        gbc.gridx = 1; gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        billingPanel.add(billingAmountField, gbc);

        addBillingButton = createAccentButton("Add Billing", WARNING);
        addBillingButton.addActionListener(evt -> addBillingButtonActionPerformed(evt));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        gbc.insets = new Insets(15, 8, 8, 8);
        billingPanel.add(addBillingButton, gbc);

        inputPanel.add(billingPanel);

        mainPanel.add(inputPanel, BorderLayout.WEST);

        // Preview Panel
        previewPanel.setBorder(BorderFactory.createTitledBorder("Data Preview"));
        previewPanel.setLayout(new BorderLayout());

        dataPreviewArea.setEditable(false);
        dataPreviewArea.setColumns(35);
        dataPreviewArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        dataPreviewArea.setRows(20);
        dataPreviewArea.setMargin(new Insets(15, 15, 15, 15));
        // Let FlatDarculaLaf handle text area colors, but make it slightly elevated
        dataPreviewArea.setBackground(DARK_ELEVATED);
        previewScrollPane.setViewportView(dataPreviewArea);

        previewPanel.add(previewScrollPane, BorderLayout.CENTER);
        mainPanel.add(previewPanel, BorderLayout.CENTER);

        getContentPane().add(mainPanel, BorderLayout.CENTER);

        // Button Panel
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        generateReportButton = createAccentButton("Generate Report", BROWN);
        generateReportButton.addActionListener(evt -> generateReportButtonActionPerformed(evt));
        buttonPanel.add(generateReportButton);

        clearButton = createAccentButton("Clear All", DANGER);
        clearButton.addActionListener(evt -> clearButtonActionPerformed(evt));
        buttonPanel.add(clearButton);

        // Cancel button uses default styling to blend with theme
        cancelButton.setText("Cancel");
        cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cancelButton.addActionListener(evt -> cancelButtonActionPerformed(evt));
        buttonPanel.add(cancelButton);

        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        pack();
    }

    // Helper method to create accent-colored buttons that work with FlatDarculaLaf
    private JButton createAccentButton(String text, Color accentColor) {
        JButton button = new JButton(text);
        button.setBackground(accentColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Add subtle hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            Color originalColor = accentColor;

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(brightenColor(originalColor));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(originalColor);
            }
        });

        return button;
    }

    // Helper method to brighten colors for hover effects
    private Color brightenColor(Color color) {
        float factor = 1.1f;
        int r = Math.min(255, (int)(color.getRed() * factor));
        int g = Math.min(255, (int)(color.getGreen() * factor));
        int b = Math.min(255, (int)(color.getBlue() * factor));
        return new Color(r, g, b);
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
        // Since you're using FlatDarculaLaf.setup() for the whole system,
        // no need to set Look & Feel here - it's already configured

        // Optional: Set additional properties for better rendering
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");

        java.awt.EventQueue.invokeLater(() -> {
            // Create parent frame - FlatDarculaLaf will handle the theming
            JFrame parentFrame = new JFrame();

            DataInputDialog dialog = new DataInputDialog(parentFrame);
            dialog.setVisible(true);
        });
    }
}