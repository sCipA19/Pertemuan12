package TugasPraktikum;

public class Film28 {
    int filmId;
    String judul;
    double rating;

    public Film28(int filmId, String judul, double rating) {
        this.filmId = filmId;
        this.judul = judul;
        this.rating = rating;
    }

    public String toString() {
        return "ID: " + filmId + "\nJudul Film: " + judul + "\nRating: " + rating;
    }
}

class NodeFilm28 {
    Film28 film;
    NodeFilm28 next;
    NodeFilm28 prev;

    public NodeFilm28(Film28 film) {
        this.film = film;
    }
}

class DLLFilm28 {
    NodeFilm28 head;
    NodeFilm28 tail;

    public void tambahDataAwal(Film28 film) {
        NodeFilm28 newNode = new NodeFilm28(film);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void tambahDataAkhir(Film28 film) {
        NodeFilm28 newNode = new NodeFilm28(film);
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void tambahDataIndexTertentu(Film28 film, int index) {
        if (index <= 0) {
            tambahDataAwal(film);
            return;
        }
        
        NodeFilm28 newNode = new NodeFilm28(film);
        NodeFilm28 current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) break;
            current = current.next;
        }

        if (current == null || current.next == null) {
            tambahDataAkhir(film);
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            if (current.next != null) {
                current.next.prev = newNode;
            }
            current.next = newNode;
        }

        System.out.println("Data Film ini akan masuk di urutan ke-" + index);
    }

    public void hapusDataPertama() {
        if (head == null) return;
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    public void hapusDataTerakhir() {
        if (tail == null) return;
        if (tail.prev == null) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }

    public void hapusDataTertentu(int filmId) {
        NodeFilm28 current = head;
        while (current != null) {
            if (current.film.filmId == filmId) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }
                System.out.println("ID Film: " + filmId + " telah dihapus.");
                return;
            }
            current = current.next;
        }
        System.out.println("Film dengan ID: " + filmId + " tidak ditemukan.");
    }

    public void urutDataRatingDesc() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swap;
        do {
            swap = false;
            NodeFilm28 current = head;
            while (current.next != null) {
                if (current.film.rating < current.next.film.rating) {
                    Film28 temp = current.film;
                    current.film = current.next.film;
                    current.next.film = temp;
                    swap = true;
                }
                current = current.next;
            }
        } while (swap);
    }

    public void cetak() {
        NodeFilm28 current = head;
        while (current != null) {
            System.out.println(current.film);
            current = current.next;
        }
    }

    public Film28 cariIdFilm(int filmIdCari) {
        throw new UnsupportedOperationException("Unimplemented method 'cariIdFilm'");
    }
}
