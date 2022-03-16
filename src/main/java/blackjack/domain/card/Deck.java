package blackjack.domain.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import blackjack.domain.participant.Participant;

public class Deck {

    private static final String DECK_EMPTY_ERROR = "카드를 모두 사용하였습니다.";
    private static final int FIRST = 0;

    private final List<Card> deck = new ArrayList<>();

    public Deck() {
        for (Suit suit : Suit.values()) {
            Stream.of(Denomination.values())
                .forEach(denomination -> deck.add(new Card(suit, denomination)));
        }
        Collections.shuffle(deck);
    }

    public void dealInitialCards(Participant participant) {
        participant.initCards(List.of(pickCard(), pickCard()));
    }

    public void dealCard(Participant participant) {
        participant.addCard(pickCard());
    }

    public Card pickCard() {
        validateDeckSize();
        return deck.remove(FIRST);
    }

    private void validateDeckSize() {
        if (deck.isEmpty()) {
            throw new IllegalArgumentException(DECK_EMPTY_ERROR);
        }
    }
}
