/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;

/**
 *
 * @author Akmal Kurniawan
 */
public class item {
    private int id;
    private String name;
    private int jumlah; // Tambahkan jumlah jika belum ada

    public item(int id, String name, int jumlah) {
        this.id = id;
        this.name = name;
        this.jumlah = jumlah;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getJumlah() {
        return jumlah;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + name + ", Jumlah: " + jumlah;
    }
}


