package assignmenthandler.assignments.sem2vop.l4c.opg3_playingcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * VOP eksamen F2014 Kodeskelet til opgave 3c og 3d
 *
 * @author erso
 */
public class DeckOfCards implements CardInterface
{

    private Card[] deck;

    public DeckOfCards()
    {
        deck = new Card[NUMBER_OF_CARDS];
        for (int counter = 0; counter < NUMBER_OF_CARDS; counter++){
            deck[counter] = new Card(counter % KING +1, counter / KING + 1);            
        }
    }

    // Faerdiskrevet metode til "paen" udskrift af kortbunken
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < deck.length; i++)
        {
            if (i != 0 && i % 4 == 0)
            {
                sb.append("\n");
            }
            sb.append(deck[i]);
            if (i != deck.length - 1)
            {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public void shuffle(int swaps)
    {
        ArrayList<Card> list = new ArrayList<>(Arrays.asList(deck));
        for (int i = 0; i < swaps; i++)
        {
            Collections.swap(list, (int) (Math.random()*deck.length), (int) (Math.random()*deck.length));
        }
        deck = list.toArray(new Card[NUMBER_OF_CARDS]);
    }


}
