package blakcjack.domain.participant;

import blakcjack.domain.card.Card;

import java.util.Collections;
import java.util.List;

public class Dealer extends Participant {
    private static final int DEALER_MAXIMUM_DRAWING_CRITERION = 17;
    private static final int FIRST_CARD_POSITION = 0;

    public Dealer() {
        super("딜러");
    }

    public List<Card> getFirstCard() {
        return Collections.singletonList(cards.get(FIRST_CARD_POSITION));
    }

    public boolean needsAdditionalCard() {
        return calculateScore() < DEALER_MAXIMUM_DRAWING_CRITERION;
    }

    @Override
    public boolean supports(final ParticipantType participantType) {
        return ParticipantType.DEALER.equals(participantType);
    }
}