public class Huntingtons {
    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int length = dna.length();
        //        StdOut.printf("length = %d\n", length);
        int pointer = 0;
        int count = 0;
        int maxCount = 0;

        // StdOut.printf("Looking for 'CAG' at pointer = %d\n", pointer);
        int res = dna.indexOf("CAG", pointer);
        while (res >= 0) {
            // StdOut.printf("Found 'CAG' at position %d, pointer = %d\n", res, pointer);

            // check if consecutive
            if ((res == pointer) || (count == 0)) {
                //  StdOut.println("Consecutive");
                // Update count and maxCount;
                count++;
                if (count > maxCount)
                    maxCount = count;
            }
            else {
                count = 1;
                // StdOut.println("Not consecutive");
            }
            pointer = res + 3;
            // StdOut.printf("Looking for 'CAG' at pointer = %d\n", pointer);
            res = dna.indexOf("CAG", pointer);
        }
        return maxCount;

    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        String ret = s;
        ret = ret.replace(" ", "");
        ret = ret.replace("\n", "");
        ret = ret.replace("\t", "");
        return ret;
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9)
            return "not human";
        if (maxRepeats <= 35)
            return "normal";
        if (maxRepeats <= 39)
            return "high risk";
        if (maxRepeats <= 180)
            return "Huntington's";
        return "not human";
    }

    public static void main(String[] args) {

        String fileName = args[0];

        In in = new In(fileName);
        String dna = in.readAll();
        String wdna = removeWhitespace(dna);
        int repeats = maxRepeats(wdna);
        StdOut.printf("max repeats = %d\n", repeats);
        StdOut.printf(diagnose(repeats));

    }
}
