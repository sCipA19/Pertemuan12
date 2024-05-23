package TugasPraktikum;

public class Nodevaksin28 {
    int nomor;
    String nama;
    Nodevaksin28 prev, next;

    Nodevaksin28(int nomor, String nama) {
        this.nomor = nomor;
        this.nama = nama;
        this.prev = null;
        this.next = null;
    }
    public class QueueVaksin28 {
        Nodevaksin28 front, rear;
        int size;

        QueueVaksin28() {
            front = rear = null;
            size = 0;
        }
        boolean isEmpty() {
            return size == 0;
        }
        void enqueue(int nomor, String nama) {
            Nodevaksin28 newNode = new Nodevaksin28(nomor, nama);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                newNode.prev = rear;
                rear = newNode;
            }
            size++;
        }
        String dequeue() {
            if (isEmpty()) {
                return null;
            } else {
                String nama = front.nama;
                if (front == rear) {
                    front = rear = null;
                } else {
                    front = front.next;
                    front.prev = null;
                }
                size--;
                return nama;
            }
        }
        int size() {
            return size;
        }
        void print() {
            if (isEmpty()) {
                System.out.println("Antrian Kosong");
            } else {
                System.out.println("++++++++++++++");
                System.out.println("Daftar penerima vaksin:");
                System.out.println("+++++++++++++++++++++++");
                System.out.println("|No.       |Nama      |");
                Nodevaksin28 current = front;
                while (current != null) {
                    System.out.printf("|%-8d|%-8s|\n", current.nomor, current.nama);
                    current = current.next;
                }
            }
        }
    }
}

