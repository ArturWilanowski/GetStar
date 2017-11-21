package GetStar;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;

public class Game{

    private Scanner scanner;
    private Random random;
    private int round;
    private double timeStart;

    public Game() {
        scanner = new Scanner(System.in);
        random = new Random();
        round = 0;
    }

    public void startGame() {
        System.out.println("Witaj w zgadywance");
        System.out.println("Twoim zadaniem jest odgadywanie slow");

        timeStart = System.currentTimeMillis();

        for(int i = 0; i < 5; i++) {
            nextRound();
        }
        double endTime = System.currentTimeMillis();
        double allTime = (endTime - timeStart)/ 1000;
        System.out.println("Twój czas to: " + allTime + "s");
    }

    private void nextRound() {
        String randomWord = SentenceUtils.getWord()[random.nextInt(SentenceUtils.getWord().length - 1)];
        String hashWord = getHashWord(randomWord);

        System.out.println("Twoj wyraz to: " + hashWord);
        System.out.println("Wpisz wyraz: ");
        String typedWord = scanner.nextLine();

        if(!typedWord.equalsIgnoreCase(randomWord)){
            System.out.println("Błąd!");
            timeStart -= 5000;
        }
    }

    private String getHashWord(String randomWord) {
        for (int i = 0; i < randomWord.length()/2 ; i++) {
            char someChar = randomWord.charAt(random.nextInt(randomWord.length() - 1));
            if (someChar != '*') {
                randomWord = randomWord.replace(String.valueOf(someChar), "*");
            }
        }
        return randomWord;
    }
}
