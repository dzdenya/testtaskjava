import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import service.RandomService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class RandomTest {
    RandomService randomService = new RandomService();

    @DataProvider
    public Iterator<Object[]> dataCount() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{1000});
        list.add(new Object[]{5000});
        list.add(new Object[]{10000});
        return list.iterator();
    }

    @Test(dataProvider = "dataCount")
    public void testGenerateOneDiceRoll(int count) {
        List<Integer> lists = randomService.generateIntegerSequences(1, count).get(0);

        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) == 1) {
                one++;
            } else if (lists.get(i) == 2) {
                two++;
            } else if (lists.get(i) == 3) {
                three++;
            } else if (lists.get(i) == 4) {
                four++;
            } else if (lists.get(i) == 5) {
                five++;
            } else if (lists.get(i) == 6) {
                six++;
            }
        }

        int total = one + two + three + four + five + six;
        System.out.println("total: " + total);

        System.out.println("one: " + one);
        System.out.println("two: " + two);
        System.out.println("three: " + three);
        System.out.println("four: " + four);
        System.out.println("five: " + five);
        System.out.println("six: " + six);

        assertEquals(lists.size(), total);

        double percentOne = getPercent(one, total);
        double percentTwo = getPercent(two, total);
        double percentThree = getPercent(three, total);
        double percentFour = getPercent(four, total);
        double percentFive = getPercent(five, total);
        double percentSix = getPercent(six, total);
        double ideal = (double) 100 / 6;

        assertEquals(percentOne, ideal, 5);
        assertEquals(percentTwo, ideal, 5);
        assertEquals(percentThree, ideal, 5);
        assertEquals(percentFour, ideal, 5);
        assertEquals(percentFive, ideal, 5);
        assertEquals(percentSix, ideal, 5);
    }

    @Test(dataProvider = "dataCount")
    public void testGenerateTwoDiceRoll(int count) {
        List<List<Integer>> data = randomService.generateIntegerSequences(2, count);

        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        int nine = 0;
        int ten = 0;
        int eleven = 0;
        int twelve = 0;

        for (int j = 0; j < data.get(0).size(); j++) {
            int x = data.get(0).get(j) + data.get(1).get(j);

            if (x == 2) {
                two++;
            } else if (x == 3) {
                three++;
            } else if (x == 4) {
                four++;
            } else if (x == 5) {
                five++;
            } else if (x == 6) {
                six++;
            } else if (x == 7) {
                seven++;
            } else if (x == 8) {
                eight++;
            } else if (x == 9) {
                nine++;
            } else if (x == 10) {
                ten++;
            } else if (x == 11) {
                eleven++;
            } else if (x == 12) {
                twelve++;
            }
        }

        int total = two + three + four + five + six + seven + eight + nine + ten + eleven + twelve;
        System.out.println("total: " + total);

        System.out.println("two : " + two);
        System.out.println("three : " + three);
        System.out.println("four : " + four);
        System.out.println("five : " + five);
        System.out.println("six : " + six);
        System.out.println("seven : " + seven);
        System.out.println("eight : " + eight);
        System.out.println("nine : " + nine);
        System.out.println("ten : " + ten);
        System.out.println("eleven : " + eleven);
        System.out.println("twelve : " + twelve);

        double percentTwo = getPercent(two, total);
        double percentThree = getPercent(three, total);
        double percentFour = getPercent(four, total);
        double percentFive = getPercent(five, total);
        double percentSix = getPercent(six, total);
        double percentSeven = getPercent(seven, total);
        double percentEight = getPercent(eight, total);
        double percentNine = getPercent(nine, total);
        double percentTen = getPercent(ten, total);
        double percentEleven = getPercent(eleven, total);
        double percentTwelve = getPercent(twelve, total);

        double theoryIdealPercentTwo = 2.78;
        double theoryIdealPercentThree = 5.56;
        double theoryIdealPercentFour = 8.33;
        double theoryIdealPercentFive = 11.11;
        double theoryIdealPercentSix = 13.89;
        double theoryIdealPercentSeven = 16.67;
        double theoryIdealPercentEight = 13.89;
        double theoryIdealPercentNine = 11.11;
        double theoryIdealPercentTen = 8.33;
        double theoryIdealPercentEleven = 5.56;
        double theoryIdealPercentTwelve = 2.78;

        assertEquals(percentTwo, theoryIdealPercentTwo, 5);
        assertEquals(percentThree, theoryIdealPercentThree, 5);
        assertEquals(percentFour, theoryIdealPercentFour, 5);
        assertEquals(percentFive, theoryIdealPercentFive, 5);
        assertEquals(percentSix, theoryIdealPercentSix, 5);
        assertEquals(percentSeven, theoryIdealPercentSeven, 5);
        assertEquals(percentEight, theoryIdealPercentEight, 5);
        assertEquals(percentNine, theoryIdealPercentNine, 5);
        assertEquals(percentTen, theoryIdealPercentTen, 5);
        assertEquals(percentEleven, theoryIdealPercentEleven, 5);
        assertEquals(percentTwelve, theoryIdealPercentTwelve, 5);
    }

    private double getPercent(double one, int total) {
        return one / total * 100;
    }
}
