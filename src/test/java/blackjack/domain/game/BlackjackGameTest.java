package blackjack.domain.game;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.domain.participant.Player;

public class BlackjackGameTest {

    @Test
    @DisplayName("블랙잭 게임 생성")
    void createBlackjackGame() {
        assertThatCode(() -> new BlackjackGame(List.of(
            new Player("마루"),
            new Player("엔젤앤지")
        ))).doesNotThrowAnyException();
    }
}
