package assignmenthandler.assignments.sem2vop.l4c.opg3_playingcards;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * VOP eksamen F2014 Tom klasse til opgave 3
 *
 * @author erso
 */
public class Card implements CardInterface
{

    private final int face;
    private final int suit;

    public Card(int face, int suit)
    {
        if (face < ACE || face > KING || suit < CLUBS || suit > SPADES)
        {
            throw new IllegalArgumentException("ERROR: Illegal card - " + face + " " + suit);
        }
        this.face = face;
        this.suit = suit;
    }

    @Override
    public String toString()
    {
        final StringBuilder suitName = new StringBuilder();
        final StringBuilder faceName = new StringBuilder();
        Arrays.stream(CardInterface.class.getDeclaredFields()).forEach(f ->
        {
            try
            {
                if (f.get(null).equals(suit) && suitName.length() == 0)
                {
                    suitName.append(String.format("%-8s", CardInterface.class.getDeclaredField(f.getName() + "_NAME").get(null)));
                } else if (f.get(null).equals(face) && f.getName() != "CLUBS")
                {
                    faceName.append(String.format("%-2s",CardInterface.class.getDeclaredField(f.getName() + "_NAME").get(null)));
                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        });
        
        return suitName.toString() + ((ACE < face && face < JACK) ? String.format("%-2s", String.valueOf(face)) : faceName.toString());
    }

}
