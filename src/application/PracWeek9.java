package application;


//  (chapter 8, Q2) Create a class named Movie that can be used with your video rental business. The Movie class should
//  track the Motion Picture Association of America (MPAA) rating (e.g., Rated G, PG-13, R), ID Number, and movie title
//  with appropriate accessor and mutator methods. Also create an equals() method that over rides Object ’s equals() me
//  thod, where two movies are equal if their ID number is identical. Next, create three additional classes named Action
//  , Comedy, and Drama that are derived from Movie. Finally, create an overridden method named calcLateFees that takes
//  as input the number of days a movie is late and returns the late fee for that movie. The default late fee is $2/day.
//  Action movies have a late fee of $3/day, comedies are $2.50/day, and dramas are $2/day. Test your classes from a mai
//  n method.


public class PracWeek9 {
    public static void main(String[] args) {
        Movie action = new Action(0, Movie.Rating.NC17, "Curse of the Killer Pineapples");
        Movie drama = new Drama(0, Movie.Rating.R, "Coffee Club and Friends");
        Movie comedy = new Comedy(0, Movie.Rating.PG13, "Squeegees 'R' Us");

        float cost = action.calculateFees(60);
        if (cost != -1) System.out.println(action.getTitle() + " $" + cost);
        else System.out.println("Invalid day.");

        cost = action.calculateFees(-15);
        if (cost != -1) System.out.println(action.getTitle() + " $" + cost);
        else System.out.println("Invalid day.");

        cost = drama.calculateFees(12);
        if (cost != -1) System.out.println(drama.getTitle() + " $" + cost);
        else System.out.println("Invalid day.");

        cost = comedy.calculateFees(7);
        if (cost != -1) System.out.println(comedy.getTitle() + " $" + cost);
        else System.out.println("Invalid day.");
    }
}

class Drama extends Movie {
    public Drama(int ID, Rating rating, String title) {
        super(ID, rating, title);
    }

    @Override
    public float calculateFees(int daysLate) {
        if (daysLate < 0) return -1;
        return daysLate * 2;
    }
}

class Comedy extends Movie {
    public Comedy(int ID, Rating rating, String title) {
        super(ID, rating, title);
    }

    @Override
    public float calculateFees(int daysLate) {
        if (daysLate < 0) return -1;
        return daysLate * 3.5f;
    }
}

class Action extends Movie {
    public Action(int ID, Rating rating, String title) {
        super(ID, rating, title);
    }

    @Override
    public float calculateFees(int daysLate) {
        if (daysLate < 0) return -1;
        return daysLate * 3;
    }
}

abstract class Movie {
    public enum Rating {
        G, PG, PG13, R, NC17
    }

    /** ID Number of the movie */
    private int ID;

    /** Movie rating */
    private Rating rating;

    /** Movie title */
    private String title;

    /**
     * Instantiate a new movie class
     * @param ID ID of the movie
     * @param rating Rating of the movie
     * @param title Title of the movie
     */
    public Movie(int ID, Rating rating, String title) {
        this.ID = ID;
        this.rating = rating;;
        this.title = title;
    }

    /**
     * Calculate fees for a given rental after a specified number of days late
     * @param daysLate Number of days late returning
     * @return The total fee, -1 if input is invalid
     */
    public abstract float calculateFees(int daysLate);

    /**
     * Get the ID of this movie
     * @return The movie's ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Set the ID of this movie
     * @param ID Movie's new ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Get the rating of this movie
     * @return The movie's rating
     */
    public Rating getRating() {
        return rating;
    }

    /**
     * Set the rating of this movie
     * @param rating Movie's new rating
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * Get the title of this movie
     * @return Movie's new title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the title of this movie
     * @param title Movie's new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Movie)) return false;

        Movie movie = (Movie) obj;

        return movie.getID() == getID();
    }
}
