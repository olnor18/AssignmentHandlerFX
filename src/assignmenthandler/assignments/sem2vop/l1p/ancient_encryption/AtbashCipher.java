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
public class AtbashCipher extends AbstractCipher{

    @Override
    public String encrypt(String original) {
        char[] charString = original.toCharArray();
        for (int i = 0; i < charString.length; i++)
        {
            charString[i] = findCharIndex(charString[i]) != -1 ? ALPHABETH[Math.floorMod((-findCharIndex(charString[i])-1),(ALPHABETH.length))] : charString[i];
        }
        return String.copyValueOf(charString);
    }

    @Override
    public String decrypt(String encrypted) {
        return encrypt(encrypted);
    }
    
    
}
