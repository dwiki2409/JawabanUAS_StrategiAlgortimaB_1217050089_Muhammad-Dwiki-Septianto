def brute_force_warung(jarak_ditempuh, jarak_tersisa, indeks_warung, daftar_warung):
    if jarak_tersisa == 0:
        print("Titik Warung yang Dikunjungi: ", daftar_warung)
        return
    elif jarak_tersisa < 0 or indeks_warung >= len(daftar_warung):
        return
    else:
        # Panggil rekursif dengan mengunjungi warung saat ini
        brute_force_warung(jarak_ditempuh + daftar_warung[indeks_warung], jarak_tersisa - daftar_warung[indeks_warung], indeks_warung + 1, daftar_warung + [daftar_warung[indeks_warung]])
        # Panggil rekursif tanpa mengunjungi warung saat ini
        brute_force_warung(jarak_ditempuh, jarak_tersisa, indeks_warung + 1, daftar_warung)

def main():
    jarak_sepeda = 140
    daftar_warung = [10, 25, 30, 40, 50, 75, 80, 110, 130]
    
    brute_force_warung(0, jarak_sepeda, 0, [])
    
if __name__ == '__main__':
    main()

