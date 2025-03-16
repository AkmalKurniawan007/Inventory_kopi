/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventory;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

    


public class manager<T extends item> { // Hanya menerima objek Kopi atau turunannya
    private List<T> inventory;

    public manager() {
        inventory = new ArrayList<>();
    }

    // Menambahkan kopi ke inventaris
    public void tambahKopi(T kopi) {
        inventory.add(kopi);
        System.out.println("✅ Kopi ditambahkan: " + kopi);
    }

    // Menampilkan seluruh inventaris kopi
    public void tampilkanInventaris() {
        if (inventory.isEmpty()) {
            System.out.println("📢 Inventaris kosong.");
        } else {
            System.out.println("\n📋 Daftar Inventaris Kopi:");
            for (T kopi : inventory) {
                System.out.println("- " + kopi);
            }
        }
    }

    // Menghapus kopi berdasarkan list yang diberikan (menggunakan wildcard ? extends T)
    public void hapusKopi(List<? extends T> kopiDihapus) {
        inventory.removeAll(kopiDihapus);
        System.out.println("❌ Data kopi telah dihapus.");
    }

    // Mengambil seluruh inventaris
    public List<T> getInventaris() {
        return inventory;
    }
}


    

