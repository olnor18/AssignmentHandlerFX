/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmenthandler.assignments.sem2vop.l1p.ancient_encryption;

/**
 *
 * @author Oliver
 */
public abstract class AbstractCipher implements CipherInterface{
    
    protected int findCharIndex (char ch) {
        for (int i = 0; i < ALPHABETH.length; i++)
        {
            if (ALPHABETH[i] == ch)
            {
                return i;
            }
        }
        return -1;
    }
}
