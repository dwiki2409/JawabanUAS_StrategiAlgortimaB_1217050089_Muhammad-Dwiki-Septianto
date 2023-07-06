import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
    private static List<Integer> warung = Arrays.asList(10, 25, 30, 40, 50, 75, 80, 110, 130);
    private static int jarakIstirahat = 30;
    private static int jarakTotal = 140;

    private static List<List<Integer>> generateSubsets() {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int r = 1; r <= warung.size(); r++) {
            generateSubsetsRecursive(subsets, new ArrayList<>(), 0, r);
        }
        return subsets;
    }

    private static void generateSubsetsRecursive(List<List<Integer>> subsets, List<Integer> currentSubset, int startIndex, int k) {
        if (k == 0) {
            subsets.add(new ArrayList<>(currentSubset));
            return;
        }

        for (int i = startIndex; i <= warung.size() - k; i++) {
            currentSubset.add(warung.get(i));
            generateSubsetsRecursive(subsets, currentSubset, i + 1, k - 1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    private static boolean isValidSubset(List<Integer> subset) {
        List<Integer> distances = new ArrayList<>();
        for (int i = 1; i < subset.size(); i++) {
            distances.add(subset.get(i) - subset.get(i - 1));
        }
        distances.add(jarakTotal - subset.get(subset.size() - 1));
        return distances.stream().allMatch(distance -> distance == jarakIstirahat);
    }

    private static int countStops(List<Integer> subset) {
        return subset.size() - 1;
    }

    public static void main(String[] args) {
        // Langkah 2: Menghasilkan semua subset yang mungkin
        List<List<Integer>> subsets = generateSubsets();

        // Langkah 3: Mencari subset dengan jumlah berhenti minimum
        int minStops = Integer.MAX_VALUE;
        List<Integer> bestSubset = null;

        for (List<Integer> subset : subsets) {
            if (isValidSubset(subset)) {
                int stops = countStops(subset);
                if (stops < minStops) {
                    minStops = stops;
                    bestSubset = subset;
                }
            }
        }

        // Langkah 4: Cetak subset terbaik dan jumlah berhenti minimum
        System.out.println("Subset terbaik: " + bestSubset);
        System.out.println("Jumlah berhenti minimum: " + minStops);
    }
}
