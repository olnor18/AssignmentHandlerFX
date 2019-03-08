package assignmenthandler.assignments.sem2vop.l4c.opg3_playingcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
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
        deck = IntStream.range(0, NUMBER_OF_CARDS).mapToObj(val -> new Card(val % KING + 1, val / KING + 1)).toArray(Card[]::new); //Onelined by Benz56
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
        IntStream.range(0, swaps).forEach(i -> Collections.swap(list, (int) (Math.random()*deck.length), (int) (Math.random()*deck.length)));
        deck = list.toArray(new Card[NUMBER_OF_CARDS]);
    }


}
