/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package patient;

/**
 *
 * @author chand
 */
public class EncryptionDecorator extends PatientRecordDecorator {
    
    public EncryptionDecorator(PatientRecord patientRecord) {
        super(patientRecord);
    }

    @Override
    public void save(String data) {
        System.out.println("EncryptionDecorator: Encrypting data...");
        String encryptedData = encrypt(data);
        super.save(encryptedData);
        System.out.println("EncryptionDecorator: Data encrypted and saved");
    }

    @Override
    public String load() {
        System.out.println("EncryptionDecorator: Loading encrypted data...");
        String encryptedData = super.load();
        String decryptedData = decrypt(encryptedData);
        System.out.println("EncryptionDecorator: Data decrypted successfully");
        return decryptedData;
    }

    private String encrypt(String data) {
        // Simple encryption simulation (reverse string)
        return new StringBuilder(data).reverse().toString();
    }

    private String decrypt(String encryptedData) {
        // Simple decryption simulation (reverse string back)
        return new StringBuilder(encryptedData).reverse().toString();
    }
}
