package application;


public class Main {

    /**
     * Remember! This is where the program starts, I'm going to make a few methods in here that will perform the
     * needed functions for ex 1, 2 and 3. I've separated everything out into methods so it's easier to understand,
     * and it gets you more used to how methods work. The main function will literally just run all the exercies for you
     */
    public static void main(String[] args) {
        PracticalExercise1();
        PracticalExercise2();
        PracticalExercise3();
    }

    /**
     * This will perform the functions needed by ex 1.
     */
    public static void PracticalExercise1() {
        // First we set the first and last name variables. Note it's all in lower case!
        String first = "aimee";
        String last = "mettke";

        // So what we wanna do is:
        // - Get everything after the first character (i.e, everything after index 0)
        // - Then, we capitalize the first letter of what we got above, then tack on the first letter of the initial
        //   string - boom!
        // So we do:
        // a[imee] <- get out the text in the brackets
        // Imee <- capitalize it
        // Imeea <- add the first letter back in
        // Imeeaay <- add the 'ay' thing - done!

        // Since we need to do the first and last name, we'll create another method that will 'pig latinize' a string
        // for us, so we dont have to write the code twice for first name and last name. I've called this method 'String pigLatinizer(String text)'
        // This method will return a string for us, then we can print it to the screen!

        first = pigLatinizer(first);
        last = pigLatinizer(last);

        System.out.println(first + " " + last);
    }

    /**
     * Will turn some text into pig latin (Aims, get used to doing documentation (this is called JavaDoc for your methods! Just type /** and it should start doing it for you)
     * @param text Text to pig-latinize
     * @return The pig-latinized text
     */
    public static String pigLatinizer(String text) {
        // First we check if the string is at least 2 characters long, if it is then just add 'ay' to an upper case
        // version of it (because if it was length 1 it would be turning 't' into 'Tay'
        if (text.length() < 2) return text.toUpperCase() + "ay";

        // Get the first letter of 'text' (this will get a substring from index 0 to 1, i.e, the first letter
        String firstLetter = text.substring(0, 1);

        // Get the start of the pig latin so we can capitalize it. This'll get the 1st index (a substring from index 1 to 2),
        // i.e the second letter - then it'll capitalize it using .toUpperCase()
        String pigFirstLetter = text.substring(1, 2).toUpperCase();

        // Get the rest of the text
        String pigString = text.substring(2);

        // Now we've extracted everything we need, we can just put it all together and it'll work! (dont forget to add the 'ay'!)
        return  pigFirstLetter + pigString + firstLetter + "ay";
    }

    /**
     * This one is a lot simpler, we simply need to calculate:
     * -> convert cm to m (easy, just divide by 100)
     * -> calculate bmi with weight/height^2 (the ^ means to the power of, i.e, ^2 is squared)
     *
     * Again, we will use another method double getBmi(double height, double weight) to calculate so you can get used
     * to declaring functions ;)
     *
     * You can use this to check if what you've done is right
     * https://www.heartfoundation.org.au/your-heart/know-your-risks/healthy-weight/bmi-calculator
     */
    public static void PracticalExercise2() {

        // We're using double just because it's easier, and we need decimal places
        double height = 185.5;
        double weight = 98.2;

        double bmi = getBmi(height, weight);

        System.out.println("Your BMI is : " + bmi);
    }

    /**
     * Calculates the BMI using height and weight
     * @param height Height of the person in CM
     * @param weight Weight of the person in KG
     * @return The BMI of the person
     */
    public static double getBmi(double height, double weight) {
        // First we convert the height into M. We're going to the use the /= syntax, remember, it is the same as
        // doing height = height / 100, it's just easier.
        height /= 100;

        // The Math.pow function will calculate the first parameter to the power of the second, this is the same
        // as saying height^2 (remember what I said about the ^)
        height = Math.pow(height, 2);

        // Now we can just return the BMI using the calculation weight/height (remember, we've already squared the
        // height so we dont have to do it again)
        return weight/height;
    }

    /**
     * Yeeep this one is going to be hard to explain over text, but we'll get there. It has heavy use of divide functions
     * , flooring (flooring just means getting rid of the decimal places, so 28.8 -> 28) AND the modulo operator (the % one
     * that you said you didnt' want to use)
     *
     * To do this it's pretty simple, just
     */
    public static void PracticalExercise3() {
        int seconds = 50391;

        String timeString = getTimeString(seconds);

        System.out.println(timeString);
    }

    /**
     * Converts seconds into an easily readable time string
     * @param seconds Seconds to convert
     * @return A time string in the format (xx hours, xx minutes, and xx seconds)
     */
    public static String getTimeString(int seconds) {
        // First we get the hours elapsed
        // There is 60s in a minute and 60 minutes in a hour, so just divide twice then floor (i.e, round down)
        // Note you have to say 60.0 NOT 60, if you do 60 it wont take into account decimal places and you could get
        // an incorrect answer. Also note the (int), the Math.floor function gives us a double type, so we just need
        // to convert it into an int. We'll be using this again
        int hrs = (int) Math.floor((seconds / 60.0) / 60.0);

        // Similar to the hours, but what we want to to is get the total minutes elapsed then get how many minutes have
        // passed since the past hour. To do that we use the modulo operator. It's hard to explain but I'll give a demo:
        // -> If we have 4500 seconds, that equates to 75 minutes. 75 is what we get if we do seconds/60
        // -> Thing is, we dont want to say 75 minutes because we have hours to. If we take out the hour, we get 15 minutes - great!
        // -> To get this we use the % operator, so we do 75 % 60 -> this'll equal 15
        // -> What the % operator does is divide 75 by 60, then gets the left over value that can't be divided more
        //    , so 75 / 60 = 1r15, because 15 can't be divided more
        int min = (int) Math.floor((seconds / 60.0) % 60.0);

        // We do the same modulo operation as we did for the minutes, but we just do it for 60 and that's it. Because
        // we already have it represented in seconds, we just do the same thing - divide by 60 and see what's left over
        // same principal as the minutes, but we dont have to convert the seconds into minutes. Also - no Math.floor()
        // and no (int) because we aren't dividing anything! Much simpler
        int sec = seconds % 60;

        // Now we just format the string and output it!
        return hrs + " hours, " + min + " minutes, and " + sec + " seconds.";
    }
}
