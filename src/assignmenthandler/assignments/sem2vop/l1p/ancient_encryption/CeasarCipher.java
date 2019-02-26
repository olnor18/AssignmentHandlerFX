/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l1p.ancient_encryption;

import assignmenthandler.assignments.sem2vop.l1p.ancient_encryption.AbstractCipher;

/**
 *
 * @author Oliver
 */
public class CeasarCipher extends AbstractCipher{
    int rotFactor;
    
    public CeasarCipher(int rotFactor)
    {
        if (0 < rotFactor && rotFactor < ALPHABETH.length){
            this.rotFactor = rotFactor;
        }
        else{
            throw new IllegalArgumentException("rotFactor has to be above zero and below ALPHABETH length");
        }
    }

    @Override
    public String encrypt(String original) {
        char[] charString = original.toCharArray();
        for (int i = 0; i < charString.length; i++)
        {
            charString[i] = findCharIndex(charString[i]) != -1 ? ALPHABETH[Math.floorMod((findCharIndex(charString[i])+rotFactor),(ALPHABETH.length))] : charString[i];
        }
        return String.copyValueOf(charString);
    
    }

    @Override
    public String decrypt(String encrypted) {
        char[] charString = encrypted.toCharArray();
        for (int i = 0; i < charString.length; i++)
        {
            charString[i] = findCharIndex(charString[i]) != -1 ? ALPHABETH[Math.floorMod((findCharIndex(charString[i])-rotFactor),(ALPHABETH.length))] : charString[i];
        }
        return String.copyValueOf(charString);
    }
}
