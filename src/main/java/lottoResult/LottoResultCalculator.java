package lottoResult;

import static constant.ConstantNumber.NUMBER_INITIALIZATION;

import constant.ConstantNumber;
import game.LottoRank;
import java.util.List;

public class LottoResultCalculator {
    public int sixSuccess = NUMBER_INITIALIZATION;
    public int fiveSuccess = NUMBER_INITIALIZATION;
    public int fiveAndBonusSuccess = NUMBER_INITIALIZATION;
    public int fourSuccess = NUMBER_INITIALIZATION;
    public int threeSuccess = NUMBER_INITIALIZATION;

    public void Calculator(List<List<Integer>> userLottoNumbers, List<Integer> winningNumberList,
                           int bonusNumber) {
        for (List<Integer> userNumbers : userLottoNumbers) {
            int score = calculateScore(userNumbers, winningNumberList);
            int bonusScore = calculateBonusScore(userNumbers, bonusNumber);

            if (score == LottoRank.FIFTH_RANK.getMatchCount()) {
                threeSuccess++;
            }
            if (score == LottoRank.FOURTH_RANK.getMatchCount()) {
                fourSuccess++;
            }
            if (score == LottoRank.THIRD_RANK.getMatchCount()) {
                fiveSuccess++;
            }
            if (score == LottoRank.SECOND_RANK.getMatchCount() && bonusScore == ConstantNumber.BONUS_CRITERIA) {
                fiveAndBonusSuccess++;
            }
            if (score == LottoRank.FIRST_RANK.getMatchCount()) {
                sixSuccess++;
            }
        }
    }

    private static int calculateScore(List<Integer> userNumbers, List<Integer> winningNumberList) {
        int score = 0;
        for (int userNumber : userNumbers) {
            for (int luckyNumber : winningNumberList) {
                if (luckyNumber == userNumber) {
                    score++;
                }
            }
        }
        return score;
    }

    private static int calculateBonusScore(List<Integer> userNumbers, int bonusNumber) {
        int bonusScore = 0;
        for (int userNumber : userNumbers) {
            if (userNumber == bonusNumber) {
                bonusScore++;
            }
        }
        return bonusScore;
    }
}