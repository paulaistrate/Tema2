package ex4;

import java.time.LocalDate;

class Persoana {
    private String nume;
    private String cnp;

    public Persoana(String nume, String cnp) {
        this.nume = nume;
        this.cnp = cnp;
    }

    public String getNume() {
        return nume;
    }

    public String getCnp() {
        return cnp;
    }

    public int getVarsta() {
        int anCurent = LocalDate.now().getYear();
        int lunaCurenta = LocalDate.now().getMonthValue();
        int ziCurenta = LocalDate.now().getDayOfMonth();

        int anulNasterii = getAnulNasterii();
        int lunaNasterii = Integer.parseInt(cnp.substring(3, 5));
        int ziuaNasterii = Integer.parseInt(cnp.substring(5, 7));

        int varsta = anCurent - anulNasterii;

        // Ajustare în funcție de luna și zi
        if (lunaCurenta < lunaNasterii || (lunaCurenta == lunaNasterii && ziCurenta < ziuaNasterii)) {
            varsta--;
        }
        return varsta;
    }

    private int getAnulNasterii() {
        int an = Integer.parseInt(cnp.substring(1, 3));
        char primaCifra = cnp.charAt(0);

        if (primaCifra == '1' || primaCifra == '2') {
            return 1900 + an;
        } else if (primaCifra == '5' || primaCifra == '6') {
            return 2000 + an;
        }
        return -1; // Caz invalid, dar presupunem că acest caz nu apare.
    }

    @Override
    public String toString() {
        return String.format("Nume: %s, CNP: %s, Vârsta: %d", nume, cnp, getVarsta());
    }
}