package week7;

import java.util.Scanner;

/**
 * This class plays Crazy Eights with one human player and two computer players
 */
public class CrazyEightsAssignment {
    private static final double CARDS_PER_SUIT = 13;
    private static final String JACK = "J";
    private static final String QUEEN = "Q";
    private static final String KING = "K";
    private static final String ACE = "A";
    private static final double NUM_SUITS = 4;

    private static final String SPADES = "S";
    private static final String DIAMONDS = "D";
    private static final String CLUBS = "C";
    private static final String HEARTS = "H";

    public static void main(String[] args) {
        playGame();
    }

    // plays a full game
    public static void playGame() {
        int playerPoints = 0, c1Points = 0, c2Points = 0;

        while (!gameOver(playerPoints, c1Points, c2Points)) {
            String playerHand = "";
            String c1Hand = "";
            String c2Hand = "";
            String topCard = "";

            boolean playAnotherRound = true;
            Scanner in = new Scanner(System.in);

            while (playAnotherRound && !gameOver(playerPoints, c1Points, c2Points)) {
                playAnotherRound = playAgain(in);
                if (playAnotherRound) {

                    playerHand = initializeHand();
                    c1Hand = initializeHand();
                    c2Hand = initializeHand();
                    topCard = getCard();
                    while (getCardFace(topCard).equals("8")) {
                        topCard = getCard();
                    }

                    System.out.println("New Round: ");
                    System.out.println("");
                    boolean roundOver = false;
                    while (!roundOver) {

                        // Players turn

                        System.out.println("Player Hand: " + playerHand);
                        System.out.println("Computer 1 Hand: " + c1Hand);
                        System.out.println("Computer 2 Hand: " + c2Hand);
                        System.out.println("Top Card: " + topCard);
                        System.out.println("");

                        if (needMoreCards(playerHand, topCard)) {
                            System.out.println("You don't have any valid cards, pick up some cards");
                            playerHand = pickUpCards(playerHand, topCard);
                            System.out.println("");
                            System.out.println("New Player Hand: " + playerHand);
                            System.out.println("Top Card: " + topCard);

                        }
                        if (!isTurnOver(playerHand, topCard)) {

                            String playerCard = playerTurn(playerHand, topCard);

                            playerHand = removeFromHand(playerCard, playerHand);
                            topCard = playerCard;
                            if (isEight(playerCard)) {
                                topCard = changeSuit(topCard);
                            }
                            System.out.println("");
                            System.out.println("--------------------");
                            System.out.println("");
                        }

                        roundOver = isRoundOver(playerHand);

                        // Computer 1 turn
                        if (!roundOver) {
                            System.out.println("Player Hand: " + playerHand);
                            System.out.println("Computer 1 Hand: " + c1Hand);
                            System.out.println("Computer 2 Hand: " + c2Hand);
                            System.out.println("Top Card: " + topCard);
                            System.out.println("");
                            System.out.println("--------------------");
                            System.out.println("");

                            if (needMoreCards(c1Hand, topCard)) {
                                System.out.println("Computer 1 doesn't have any valid cards, pick up some cards");
                                c1Hand = pickUpCards(c1Hand, topCard);
                                System.out.println("");
                                System.out.println("New Computer 1 Hand: " + c1Hand);
                                System.out.println("Top Card: " + topCard);

                            }

                            if (!isTurnOver(c1Hand, topCard)) {

                                String c1Card = computerTurn(c1Hand, topCard);
                                topCard = c1Card;
                                int index1 = c1Hand.indexOf(" ");
                                if (isEight(c1Card) && c1Hand.length() == 2) {
                                    String firstCardSuit = getCardSuit(c1Hand.substring(1));
                                    topCard = getCardFace(c1Hand) + firstCardSuit;
                                }
                                System.out.println("Computer 1 played: " + c1Card);
                                c1Hand = removeFromHand(c1Card, c1Hand);

                            }

                            roundOver = isRoundOver(c1Hand);
                            if (!roundOver) {
                                // Computer 2 turn

                                System.out.println("Player Hand: " + playerHand);
                                System.out.println("Computer 1 Hand: " + c1Hand);
                                System.out.println("Computer 2 Hand: " + c2Hand);
                                System.out.println("Top Card: " + topCard);
                                System.out.println("");
                                System.out.println("--------------------");
                                System.out.println("");

                                if (needMoreCards(c2Hand, topCard)) {
                                    System.out.println("Computer 2 doesn't have any valid cards, pick up some cards");
                                    c2Hand = pickUpCards(c2Hand, topCard);
                                    System.out.println("");
                                    System.out.println("New Computer 2 Hand: " + c2Hand);
                                    System.out.println("Top Card: " + topCard);

                                }

                                if (!isTurnOver(c2Hand, topCard)) {

                                    String c2Card = computerTurn(c2Hand, topCard);
                                    topCard = c2Card;
                                    int index1 = c2Hand.indexOf(" ");
                                    if (isEight(c2Card) && c2Hand.length() == 2) {
                                        String firstCardSuit = getCardSuit(c2Hand.substring(1));
                                        topCard = getCardFace(c2Hand) + firstCardSuit;
                                    }
                                    System.out.println("Computer 2 played: " + c2Card);
                                    c2Hand = removeFromHand(c2Card, c2Hand);

                                }

                                roundOver = isRoundOver(c2Hand);

                                System.out.println("");
                                System.out.println("--------------------");
                                System.out.println("");
                            }
                        }
                    }

                    playerPoints += countPoints(playerHand);
                    c1Points += countPoints(c1Hand);
                    c2Points += countPoints(c2Hand);
                    System.out.println("Round Over");
                    System.out.println("Player Points: " + playerPoints);
                    System.out.println("Computer 1 Points: " + c1Points);
                    System.out.println("Computer 2 Points: " + c2Points);
                    System.out.println("");
                    System.out.println("--------------------");
                    System.out.println("");
                } else {
                    playAnotherRound = false;
                    System.out.println("Game Over");
                }
            }
        }
        System.out.println("Game Over");
        System.out.println(winner(playerPoints, c1Points, c2Points) + " Wins!!!");
    }

    // finds the winner
    private static String winner(int playerPoints, int c1Points, int c2Points) {
        if (playerPoints < c1Points && playerPoints < c2Points) {
            return "Player";
        } else if (c1Points < playerPoints && c1Points < c2Points) {
            return "Computer 1";
        } else {
            return "Computer 2";
        }
    }

    // checks if turn is over
    private static boolean isTurnOver(String hand, String topCard) {
        return hand.indexOf(getCardSuit(topCard)) < 0 && hand.indexOf(getCardFace(topCard)) < 0 && !hasEight(hand);
    }

    // computers turn to place a card
    public static String computerTurn(String cHand, String topCard) {
        String cardToPlace = "";
        cardToPlace = ruleOne(cHand, topCard);

        if (!cardToPlace.equals("")) {
            return cardToPlace;
        }

        cardToPlace = ruleTwo(cHand, topCard);
        if (!cardToPlace.equals("")) {
            return cardToPlace;
        }

        cardToPlace = ruleThree(cHand, topCard);
        if (!cardToPlace.equals("")) {

            return cardToPlace;
        }

        cardToPlace = ruleFour(cHand, topCard);
        if (!cardToPlace.equals("")) {
            return cardToPlace;
        }

        return cardToPlace;
    }

    // if ruleThree doesn't apply and the last card is an eight, computer will play
    // it
    public static String ruleFour(String cHand, String topCard) {
        String cardToPlace = "";

        if (cHand.length() == 2 || cHand.length() == 3) {
            if (isEight(cHand)) {
                cardToPlace = cHand;
            }
        }

        return cardToPlace;
    }

    // if ruleTwo doesn't apply and the computer hand has an eight, the computer
    // will play
    // it and choose a suit in their hand
    public static String ruleThree(String cHand, String topCard) {
        String cardToPlace = "";

        int index = cHand.indexOf("8");

        if (index == -1) {
            return "";
        } else {
            cardToPlace = cHand.substring(index, index + 2);
        }

        return cardToPlace;
    }

    // if ruleOne doesnt apply and they have a card with the same face as the top
    // card, they will play it if it isn't an eight
    public static String ruleTwo(String cHand, String topCard) {
        String cardToPlace = "";
        int topFace = cHand.indexOf(getCardFace(topCard));
        int index = cHand.indexOf(" ", topFace);

        if (topFace == -1) {
            return "";
        }
        cardToPlace = extractCardByFace(cHand, topFace);
        if (isEight(cardToPlace)) {
            int next = cHand.indexOf(getCardFace(topCard), topFace + 1);
            if (next == -1) {
                return "";
            }
            cardToPlace = extractCardByFace(cHand, next);
        }
        return cardToPlace;
    }

    // extracts card by face
    public static String extractCardByFace(String cHand, int index) {
        String card = cHand.substring(index, index + 1);

        if (cHand.substring(index, index + 2).equals("10")) {
            card = cHand.substring(index, index + 2);
            card += cHand.substring(index + 2, index + 3);
        } else {
            card = cHand.substring(index, index + 1);
            card += cHand.substring(index + 1, index + 2);
        }
        return card;
    }

    // if the computer has a card of the same suit as the top card and it is not an
    // eight, they will play it
    public static String ruleOne(String cHand, String topCard) {
        String cardToPlace = "";
        int topSuit = cHand.indexOf(getCardSuit(topCard));

        if (topSuit == -1) {
            return "";
        }

        cardToPlace = extractCardBySuit(cHand, topSuit);
        if (isEight(cardToPlace)) {
            int next = cHand.indexOf(getCardSuit(topCard), topSuit + 1);
            if (next == -1) {
                return "";
            }
            cardToPlace = extractCardBySuit(cHand, next);
        }
        return cardToPlace;
    }

    // extracts card from hand by suit
    private static String extractCardBySuit(String cHand, int index) {
        String card = cHand.substring(index - 1, index + 1);
        if (cHand.substring(index - 1, index).equals("0")) {
            card = cHand.substring(index - 2, index + 1);
        } else {
            card = cHand.substring(index - 1, index + 1);
        }
        return card;
    }

    // players turn to place a card
    public static String playerTurn(String playerHand, String topCard) {
        String cardToPlace = "";

        cardToPlace = askForCard(playerHand, topCard);

        return cardToPlace;
    }

    // counts points at the end of each round
    public static int countPoints(String hand) {

        int totalPoints = 0;

        if (hand.equals("")) {
            return 0;
        }

        int index1 = 0;
        int index2 = hand.indexOf(" ");

        if (index2 == -1) {
            return getFaceValue(hand);
        }

        boolean done = false;
        while (!done) {
            String card = "";
            if (index1 == 0) {
                card = hand.substring(0, index2);
            } else if (index2 == -1) {
                card = hand.substring(index1 + 1);
                done = true;
            } else {
                card = hand.substring(index1 + 1, index2);
            }
            totalPoints += getFaceValue(card);

            index1 = index2;
            index2 = hand.indexOf(" ", index2 + 1);
        }
        return totalPoints;
    }

    // asks the player if they want to play another round
    private static boolean playAgain(Scanner in) {
        boolean validInput = false;
        while (!validInput) {
            System.out.print("Do you want to play again? [Y]es or [N]o: ");
            String answer = in.nextLine().toUpperCase();
            System.out.println("");
            if (answer.equals("Y") || answer.equals("YES")) {
                return true;
            }
            if (answer.equals("N") || answer.equals("NO")) {
                return false;
            } else {
                System.out.println("Invalid Choice!");
            }
        }
        return false;
    }

    // checks if the player needs more cards
    private static boolean needMoreCards(String hand, String topCard) {
        return !hasEight(hand) && hand.indexOf(getCardSuit(topCard)) < 0 && hand.indexOf(getCardFace(topCard)) < 0;
    }

    // checks if a hand has an eight
    private static boolean hasEight(String hand) {

        int eight = hand.indexOf("8");

        if (eight > -1) {
            return true;
        }
        return false;
    }

    // picks up cards until the player has a card that either matches the top card
    // or is an eight
    public static String pickUpCards(String hand, String topCard) {
        int count = 0;

        while (needMoreCards(hand, topCard) && count < 5) {
            hand += " " + getCard();
            count++;
        }
        System.out.println("Picked up " + count + " additional cards");
        return hand;
    }

    // removes the card that will be placed from the hand
    public static String removeFromHand(String card, String hand) {

        int index = hand.indexOf(card);
        int index1 = hand.indexOf(" ", index + 1);
        if (index1 == -1) {
            hand = hand.substring(0, index);
        } else if (index == 0) {
            String afterCard = hand.substring(index1 + 1);

            hand = afterCard;
        } else {
            String beforeCard = hand.substring(0, index);
            String afterCard = hand.substring(index1 + 1);

            hand = beforeCard + afterCard;

            return hand.trim();
        }
        return hand.trim();
    }

    // checks if the players input is valid suit
    public static boolean validSuit(String newSuit) {
        final String VALID_SUITS = "HDSC";

        if (newSuit.length() != 1) {
            if (VALID_SUITS.indexOf(newSuit) < 0)
                System.out.println("Not a valid suit: " + newSuit);
            return false;
        }

        return true;

    }

    // chages the suit of the top card
    public static String changeSuit(String topCard) {
        Scanner in = new Scanner(System.in);
        System.out.println("Pick a new suit [S]pade [H]eart [D]iamond, [C]lub : ");
        String newSuit = in.nextLine().toUpperCase();

        while (!validSuit(newSuit)) {
            System.out.println("Please place a valid suit [C]lub [H]eart [D]iamond [S]pade: ");
            newSuit = in.nextLine().toUpperCase();

        }
        return getCardFace(topCard) + newSuit;

    }

    // checks if the card is valid
    public static boolean isvalidCard(String card, String hand, String topCard) {
        final String VALID_CARDS = "AS2S3S4S5S6S7S8S9S10SJSQSKSAC2C3C4C5C6C7C8C9C10CJCQCKCAD2D3D4D5D6D7D8D9D10DJDQDKDAH2H3H4H5H6H7H8H9H10HJHQHKH";

        if (card.length() < 2) {
            System.out.println("Invalid Card: " + card);
            return false;
        }

        if (isEight(card)) {
            return true;
        }

        else {
            if (card.length() == 2 || card.length() == 3) {
                if (VALID_CARDS.indexOf(card) < 0)
                    System.out.println("Not a valid card: " + card);
                else if (hand.indexOf(card) < 0)
                    System.out.println("You don't have a " + card);
                else if (!getCardFace(topCard).equals(getCardFace(card))
                        && !getCardSuit(topCard).equals(getCardSuit(card)))
                    System.out.println(card + " does not match top card: " + topCard);
                else
                    return true;
            } else {
                System.out.println("Invalid Card: " + card);
                return false;
            }

        }

        return false;

    }

    // asks player for a card to place
    private static String askForCard(String hand, String topCard) {
        Scanner in = new Scanner(System.in);

        System.out.print("Which card would you like to place?:");
        String card = in.nextLine().toUpperCase();

        while (!isvalidCard(card, hand, topCard)) {
            System.out.print("Which card would you like to place?:");
            card = in.nextLine().toUpperCase();
        }

        return card;
    }

    // checks card if it is an 8
    public static boolean isEight(String card) {
        String face = getCardFace(card);
        return face.equals("8");
    }

    // checks if round is over
    public static boolean isRoundOver(String hand) {

        if (hand.equals("")) {
            return true;
        }
        return false;
    }

    // initializes hand at the start of the round
    public static String initializeHand() {
        String hand = getCard() + " ";
        hand += getCard() + " ";
        hand += getCard() + " ";
        hand += getCard() + " ";
        hand += getCard() + " ";

        return hand.trim();
    }

    // gets random card
    public static String getCard() {
        return getFace() + getSuit();

    }

    // gets a random face when constructing a card
    public static String getFace() {
        int x = (int) (Math.random() * CARDS_PER_SUIT) + 2;

        if (x <= 10)
            return "" + x;
        else if (x == 11)
            return JACK;
        else if (x == 12)
            return QUEEN;
        else if (x == 13)
            return KING;
        else
            return ACE;
    }

    // gets a random suit when constructing a card
    public static String getSuit() {
        int x = (int) (Math.random() * NUM_SUITS);
        if (x == 0)
            return SPADES;
        else if (x == 1)
            return DIAMONDS;
        else if (x == 2)
            return CLUBS;
        else
            return HEARTS;
    }

    // checks if game is over
    public static boolean gameOver(int playerPoints, int c1Points, int c2Points) {
        return playerPoints >= 100 || c1Points >= 100 || c2Points >= 100;
    }

    // gets suit of each card
    public static String getCardSuit(String card) {
        String suit = card.substring(card.length() - 1);

        return suit;
    }

    // gets face of each card
    public static String getCardFace(String card) {
        String face = card.substring(0, card.length() - 1);

        return face;
    }

    // gets the face value of each card
    public static int getFaceValue(String card) {

        String face = getCardFace(card);

        if (face.equals("2"))
            return 2;
        if (face.equals("3"))
            return 3;
        if (face.equals("4"))
            return 4;
        if (face.equals("5"))
            return 5;
        if (face.equals("6"))
            return 6;
        if (face.equals("7"))
            return 7;
        if (face.equals("9"))
            return 9;
        if (face.equals("10") || face.equals("J") || face.equals("Q") || face.equals("K"))
            return 10;
        if (face.equals("A"))
            return 1;
        if (face.equals("8"))
            return 50;

        return 0;
    }
}
