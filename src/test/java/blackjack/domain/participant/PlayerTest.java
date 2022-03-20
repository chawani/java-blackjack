package blackjack.domain.participant;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import blackjack.domain.card.Card;
import blackjack.domain.card.Denomination;
import blackjack.domain.card.Suit;
import blackjack.domain.game.PlayerWinningResult;

public class PlayerTest {

    @Test
    @DisplayName("블랙잭이 나면 플레이어는 hit 할 수 없다")
    void canNotHitBlackjack() {
        Player player = new Player("player", 0);

        player.initCards(List.of(
            new Card(Suit.DIAMOND, Denomination.TEN),
            new Card(Suit.HEART, Denomination.ACE)
        ));

        assertThat(player.canHit()).isFalse();
    }

    @Test
    @DisplayName("버스트가 나면 플레이어는 hit 할 수 없다")
    void canNotHitBust() {
        Player player = new Player("player", 0);

        player.initCards(List.of(
            new Card(Suit.DIAMOND, Denomination.TEN),
            new Card(Suit.HEART, Denomination.JACK)
        ));
        player.addCard(new Card(Suit.DIAMOND, Denomination.FIVE));

        assertThat(player.canHit()).isFalse();
    }

    @Test
    @DisplayName("stay하면 플레이어는 hit 할 수 없다")
    void canNotHitStay() {
        Player player = new Player("player", 0);

        player.initCards(List.of(
            new Card(Suit.DIAMOND, Denomination.TEN),
            new Card(Suit.HEART, Denomination.JACK)
        ));
        player.stay();

        assertThat(player.canHit()).isFalse();
    }

    @Test
    @DisplayName("플레이어가 블랙잭일 경우 수익이 베팅금의 1.5배")
    void getBlackjackProfit() {
        Player player = new Player("player", 1000);

        player.initCards(List.of(new Card(Suit.DIAMOND, Denomination.ACE),
            new Card(Suit.HEART, Denomination.JACK)));

        assertThat(player.calculateProfit(PlayerWinningResult.WIN)).isEqualTo(1500);
    }

    @Test
    @DisplayName("플레이어가 이길 경우 수익이 베팅금 만큼")
    void getWinProfit() {
        Player player = new Player("player", 1000);

        assertThat(player.calculateProfit(PlayerWinningResult.WIN)).isEqualTo(1000);
    }

    @Test
    @DisplayName("플레이어가 비길 경우 수익이 없음")
    void getDrawProfit() {
        Player player = new Player("player", 1000);

        assertThat(player.calculateProfit(PlayerWinningResult.DRAW)).isEqualTo(0);
    }

    @Test
    @DisplayName("플레이어가 질 경우 수익이 베팅금 만큼 손해")
    void getLoseProfit() {
        Player player = new Player("player", 1000);

        assertThat(player.calculateProfit(PlayerWinningResult.LOSE)).isEqualTo(-1000);
    }
}
