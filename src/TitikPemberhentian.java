import java.util.ArrayList;
import java.util.List;

public class TitikPemberhentian {
    public static void main(String[] args) {
        List<Integer> warung = List.of(10, 25, 30, 40, 50, 75, 80, 110, 130);

        int minBerhenti = Integer.MAX_VALUE;
        List<Integer> kombinasiTerbaik = new ArrayList<>();

        // semua kombinasi yang ada dicari menggunakan perulangan ini
        for (int i = 0; i < (1 << warung.size()); i++) {
            List<Integer> kombinasi = new ArrayList<>();

            // penentuan warung yang dipilih
            for (int j = 0; j < warung.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    kombinasi.add(warung.get(j));
                }
            }

            // persyaratan
            if (isValidCombination(kombinasi, 140, 30)) {

                int jumlahBerhenti = kombinasi.size();

                // cek optimal
                if (jumlahBerhenti < minBerhenti) {
                    minBerhenti = jumlahBerhenti;
                    kombinasiTerbaik = new ArrayList<>(kombinasi);
                }
            }
        }

        // warung yang tono singgahi
        System.out.print("Titik-titik warung Tono akan berhenti: ");
        for (int i = 0; i < kombinasiTerbaik.size(); i++) {
            System.out.print(kombinasiTerbaik.get(i) + " ");
        }
        System.out.println();

        // Menampilkan jumlah warung yang disinggahi oleh Tono
        System.out.println("Jumlah warung yang disinggahi: " + minBerhenti);
    }

    // kombinasi titik-titik warung memenuhi persyaratan
    private static boolean isValidCombination(List<Integer> kombinasi, int jarakTotal, int jarakIstirahat) {

        // persyaratan jarak
        int jarak = 0;
        for (int i = 0; i < kombinasi.size(); i++) {
            if (kombinasi.get(i) - jarak > jarakIstirahat) {
                return false;
            }
            jarak = kombinasi.get(i);
        }
        if (jarakTotal - jarak > jarakIstirahat) {
            return false;
        }
        return true;
    }
}
