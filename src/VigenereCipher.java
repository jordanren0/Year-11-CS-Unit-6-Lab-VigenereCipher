public class VigenereCipher {
    private String key;
    private String alphabet;

    public VigenereCipher(String key){
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public String newKey(String message, String key) {
        StringBuilder newKey = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            newKey.append(key.charAt(i % key.length()));
        }
        return newKey.toString();
    }


    public String encode(String message) {
        String newKey = newKey(message, this.key);
        String encodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            if (alphabet.indexOf(message.charAt(i)) == -1) {
                encodedMessage += message.charAt(i);
            } else {
                int sum = alphabet.indexOf(message.charAt(i)) + alphabet.indexOf(newKey.charAt(i));
                if (sum > 52) {
                    sum -= 26;
                }
                encodedMessage += alphabet.charAt(sum);
            }
        }
        encodedMessage = encodedMessage.toLowerCase();
        return encodedMessage;
    }

    public String decode(String message) {
        String newKey = newKey(message, this.key);
        String decodedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            if (alphabet.indexOf(message.charAt(i)) == -1) { // checks if the character is a letter in the alphabet
                decodedMessage += message.charAt(i);
            } else {
                int sum = alphabet.indexOf(message.charAt(i)) - alphabet.indexOf(newKey.charAt(i));
                if (sum < 0) {
                    sum += 26;
                }
                decodedMessage += alphabet.charAt(sum);
            }
        }
        decodedMessage = decodedMessage.toLowerCase();
        return decodedMessage;
    }
}
