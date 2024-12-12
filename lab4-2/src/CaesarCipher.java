public class CaesarCipher {
    public static String encrypt(String message, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();
        
        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) (((ch - base + shift) % 26 + 26) % 26 + base);
                encryptedMessage.append(encryptedChar);
            } else {
                encryptedMessage.append(ch);
            }
        }
        
        return encryptedMessage.toString();
    }
    
    public static String decrypt(String encryptedMessage, int shift) {
        return encrypt(encryptedMessage, -shift);
    }
    
    public static void main(String[] args) {
        String originalMessage = "Hello, World!";
        int shiftKey = 3;
        
        String encryptedMessage = encrypt(originalMessage, shiftKey);
        System.out.println("Original Message: " + originalMessage);
        System.out.println("Encrypted Message: " + encryptedMessage);
        
        String decryptedMessage = decrypt(encryptedMessage, shiftKey);
        System.out.println("Decrypted Message: " + decryptedMessage);
        
        System.out.println("\nMore Examples:");
        testCaesarCipher("Java Programming", 5);
        testCaesarCipher("Secret Message", 7);
    }
    
    private static void testCaesarCipher(String message, int shift) {
        String encrypted = encrypt(message, shift);
        String decrypted = decrypt(encrypted, shift);
        
        System.out.println("Original: " + message);
        System.out.println("Shifted by " + shift + ": " + encrypted);
        System.out.println("Decrypted: " + decrypted);
        System.out.println();
    }
}