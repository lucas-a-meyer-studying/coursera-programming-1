public class Clock {

    private int hh;
    private int mm;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {

        if ((h < 0) || (h > 23))
            throw new IllegalArgumentException();

        if ((m < 0) || (m > 59))
            throw new IllegalArgumentException();

        hh = h;
        mm = m;

    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {

        if (s.length() != 5)
            throw new IllegalArgumentException();

        String strH = s.substring(0, 2);
        String strM = s.substring(3);

        int colon = s.charAt(2);
        if (colon != ':')
            throw new IllegalArgumentException();

        int h = Integer.parseInt(strH);
        int m = Integer.parseInt(strM);

        if ((h < 0) || (h > 23))
            throw new IllegalArgumentException();

        if ((m < 0) || (m > 59))
            throw new IllegalArgumentException();

        hh = h;
        mm = m;

    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        return String.format("%02d:%02d", hh, mm);

    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (this.hh < that.hh)
            return true;
        if ((this.hh == that.hh) && (this.mm < that.mm))
            return true;
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (mm < 59) {
            mm++;
        }
        else { // mm == 59
            mm = 0;
            if (hh < 23) hh++;
            else hh = 0; // hh was 23
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {

        if (delta < 0)
            throw new IllegalArgumentException();

        int addedH = delta / 60;
        int addedM = delta % 60;

        hh += addedH;
        mm += addedM;

        if (mm >= 60) hh++;
        if (mm < 0) hh--;

        hh = Math.floorMod(hh, 24);
        mm = Math.floorMod(mm, 60);

    }

    public static void main(String[] args) {
        Clock c = new Clock("23:59");
        c.tic();
        StdOut.println(c);

        c.toc(1);
        StdOut.println(c);

        c.toc(1439);
        StdOut.println(c);

        c.toc(1440);
        StdOut.println(c);

        Clock c1 = new Clock("20:22");
        Clock c2 = new Clock("23:20");

        StdOut.println(c1.isEarlierThan(c2));
        StdOut.println(c1.isEarlierThan(c1));
        StdOut.println(c2.isEarlierThan(c1));
    }
}
