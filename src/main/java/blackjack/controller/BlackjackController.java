package blackjack.controller;

import java.util.stream.Collectors;

import blackjack.domain.game.BlackjackGame;
import blackjack.domain.game.GameResult;
import blackjack.domain.participant.Participants;
import blackjack.domain.participant.Player;
import blackjack.view.InputView;
import blackjack.view.OutputView;

public class BlackjackController {

    public void run() {
        Participants participants = createParticipants();
        BlackjackGame blackjackGame = new BlackjackGame(participants);

        dealInitialCards(blackjackGame);
        dealMoreCards(blackjackGame);
        printResult(blackjackGame.getParticipants());
    }

    private Participants createParticipants() {
        return new Participants(InputView.inputPlayerName().stream()
            .map(Player::new)
            .collect(Collectors.toList()));
    }

    private void dealInitialCards(BlackjackGame blackjackGame) {
        blackjackGame.dealInitialCards();
        OutputView.printInitialCardInformation(blackjackGame.getParticipants());
    }

    private void dealMoreCards(BlackjackGame blackjackGame) {
        dealMoreCardsToPlayers(blackjackGame);
        dealMoreCardsToDealer(blackjackGame);
    }

    private void dealMoreCardsToPlayers(BlackjackGame blackjackGame) {
        while (!blackjackGame.isPlayersTurnEnd()) {
            Player player = blackjackGame.getCurrentPlayer();
            blackjackGame.playPlayerTurn(InputView.inputPlayerHit(player.getName()));
            OutputView.printPlayerCardInformation(player);
        }
    }

    private void dealMoreCardsToDealer(BlackjackGame blackjackGame) {
        while (!blackjackGame.isDealerTurnEnd()) {
            blackjackGame.playDealerTurn();
            OutputView.printDealerHitMessage();
        }
    }

    private void printResult(Participants participants) {
        OutputView.printCardsAndPoint(participants);
        GameResult gameResult = new GameResult(participants);
        OutputView.printResult(gameResult.getDealerResult(), gameResult.getPlayerResult());
    }
}

