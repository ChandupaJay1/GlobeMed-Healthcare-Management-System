/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dulan
 */
public class Patient_Frame extends JDialog {

    // UI Components
    private JTextField patientNameField;
    private JTextArea recordDataArea;
    private JTextArea outputArea;
    private JCheckBox loggingCheckBox;
    private JCheckBox encryptionCheckBox;
    private JCheckBox authorizationCheckBox;
    private JComboBox<String> userRoleCombo;
    private JButton saveButton;
    private JButton loadButton;
    private JButton clearButton;
    private JLabel statusLabel;

    // Current patient record
    private PatientRecord currentRecord;

    /**
     * Creates new form PatientRecords
     */
    public Patient_Frame(JFrame parent) {
        super(parent, "Patient Records", true);
        initComponents();
        setupEventHandlers();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patient Records Management System");
        setSize(900, 600);

        // Main panel with simple layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // Title
        JLabel titleLabel = new JLabel("Patient Records Management System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createVerticalStrut(20));

        // Patient Info Section
        JPanel patientPanel = createPatientInfoSection();
        mainPanel.add(patientPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // Decorators Section
        JPanel decoratorPanel = createDecoratorsSection();
        mainPanel.add(decoratorPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // Buttons Section
        JPanel buttonPanel = createButtonsSection();
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createVerticalStrut(15));

        // Output Section
        JPanel outputPanel = createOutputSection();
        mainPanel.add(outputPanel);

        // Status bar
        statusLabel = new JLabel("Ready");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        mainPanel.add(statusLabel);

        getContentPane().add(mainPanel);
    }

    private JPanel createPatientInfoSection() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Patient Information"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Patient Name
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(new JLabel("Patient Name:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        patientNameField = new JTextField("Kasun", 20);
        panel.add(patientNameField, gbc);

        // Medical Record
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        panel.add(new JLabel("Medical Record:"), gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        recordDataArea = new JTextArea("Diagnosed with Flu, Treatment = Rest + Medication", 3, 40);
        recordDataArea.setLineWrap(true);
        recordDataArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(recordDataArea);
        scrollPane.setPreferredSize(new Dimension(400, 80));
        panel.add(scrollPane, gbc);

        return panel;
    }

    private JPanel createDecoratorsSection() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Security Decorators"));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // First row of checkboxes
        gbc.gridx = 0; gbc.gridy = 0;
        loggingCheckBox = new JCheckBox("Logging", true);
        panel.add(loggingCheckBox, gbc);

        gbc.gridx = 1;
        encryptionCheckBox = new JCheckBox("Encryption", true);
        panel.add(encryptionCheckBox, gbc);

        gbc.gridx = 2;
        authorizationCheckBox = new JCheckBox("Authorization", true);
        panel.add(authorizationCheckBox, gbc);

        // User Role
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("User Role:"), gbc);

        gbc.gridx = 1;
        userRoleCombo = new JComboBox<>(new String[]{"Doctor", "Nurse", "Admin"});
        userRoleCombo.setSelectedItem("Doctor");
        panel.add(userRoleCombo, gbc);

        return panel;
    }

    private JPanel createButtonsSection() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));

        saveButton = new JButton("Save Record");
        loadButton = new JButton("Load Record");
        clearButton = new JButton("Clear Output");

        panel.add(saveButton);
        panel.add(loadButton);
        panel.add(clearButton);

        return panel;
    }

    private JPanel createOutputSection() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("System Output"));

        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 11));

        JScrollPane scrollPane = new JScrollPane(outputArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        return panel;
    }

    private void setupEventHandlers() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveRecord();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadRecord();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.setText("");
                statusLabel.setText("Output cleared");
            }
        });
    }

    private void saveRecord() {
        try {
            String patientName = patientNameField.getText().trim();
            String recordData = recordDataArea.getText().trim();

            if (patientName.isEmpty() || recordData.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter patient name and record data!",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Capture output
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            java.io.PrintStream oldOut = System.out;
            System.setOut(ps);

            // Create the decorated record
            currentRecord = buildDecoratedRecord(patientName);

            // Save the record
            outputArea.append("=== SAVING RECORD ===\n");
            outputArea.append("Patient: " + patientName + "\n");
            outputArea.append("Data: " + recordData + "\n");
            outputArea.append("Active Decorators: " + getActiveDecorators() + "\n\n");

            currentRecord.save(recordData);

            // Restore output and capture what was printed
            System.out.flush();
            System.setOut(oldOut);
            String capturedOutput = baos.toString();
            outputArea.append(capturedOutput);
            outputArea.append("\n" + "=".repeat(50) + "\n\n");

            statusLabel.setText("Record saved successfully with " + getActiveDecorators());
            outputArea.setCaretPosition(outputArea.getDocument().getLength());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error saving record: " + ex.getMessage(),
                    "Save Error", JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Error occurred during save operation");
        }
    }

    private void loadRecord() {
        try {
            if (currentRecord == null) {
                JOptionPane.showMessageDialog(this, "No record to load! Please save a record first.",
                        "Load Error", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Capture output
            java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
            java.io.PrintStream ps = new java.io.PrintStream(baos);
            java.io.PrintStream oldOut = System.out;
            System.setOut(ps);

            // Load the record
            outputArea.append("=== LOADING RECORD ===\n");
            outputArea.append("Patient: " + patientNameField.getText() + "\n");
            outputArea.append("Active Decorators: " + getActiveDecorators() + "\n\n");

            String loadedData = currentRecord.load();

            // Restore output and capture what was printed
            System.out.flush();
            System.setOut(oldOut);
            String capturedOutput = baos.toString();
            outputArea.append(capturedOutput);

            outputArea.append("Loaded Data: " + loadedData + "\n");
            outputArea.append("\n" + "=".repeat(50) + "\n\n");

            statusLabel.setText("Record loaded successfully");
            outputArea.setCaretPosition(outputArea.getDocument().getLength());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error loading record: " + ex.getMessage(),
                    "Load Error", JOptionPane.ERROR_MESSAGE);
            statusLabel.setText("Error occurred during load operation");
        }
    }

    private PatientRecord buildDecoratedRecord(String patientName) {
        // Start with basic record
        PatientRecord record = new BasicPatientRecord(patientName);

        // Apply decorators in order based on checkboxes
        if (loggingCheckBox.isSelected()) {
            record = new LoggingDecorator(record);
        }

        if (encryptionCheckBox.isSelected()) {
            record = new EncryptionDecorator(record);
        }

        if (authorizationCheckBox.isSelected()) {
            String userRole = (String) userRoleCombo.getSelectedItem();
            record = new AuthorizationDecorator(record, userRole);
        }

        return record;
    }

    private String getActiveDecorators() {
        java.util.List<String> decorators = new java.util.ArrayList<>();

        if (loggingCheckBox.isSelected()) {
            decorators.add("Logging");
        }
        if (encryptionCheckBox.isSelected()) {
            decorators.add("Encryption");
        }
        if (authorizationCheckBox.isSelected()) {
            decorators.add("Authorization(" + userRoleCombo.getSelectedItem() + ")");
        }

        return decorators.isEmpty() ? "None" : String.join(" → ", decorators);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Patient_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}