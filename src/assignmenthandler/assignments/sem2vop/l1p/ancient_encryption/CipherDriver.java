package assignmenthandler.assignments.sem2vop.l1p.ancient_encryption;

/**
 *
 * @author erso 
 *  Udleveret driver klasse til opgave 2, VOP eksamen 10 juni 2016
 */
public class CipherDriver {

    /**
     * @param args the command line arguments
     */
    public void print() {
        CipherInterface cipher;

        String message = "aHer har vi en Meddelelse, som er hemmelig!";
        System.out.println("Original: \n" + message);

        // Fjern ud-kommenteringen, når AtbashCipher skal testes
        cipher = new AtbashCipher();
        String enc = cipher.encrypt(message);
        System.out.println("Atbash: \n" + enc);
        System.out.println(cipher.decrypt(enc));

        // Fjern ud-kommenteringen, når CeasarCipher skal testes
        cipher = new CeasarCipher(13);
        enc = cipher.encrypt(message);
        System.out.println("Ceasar 13: \n" + enc);
        System.out.println(cipher.decrypt(enc));

    }

}
