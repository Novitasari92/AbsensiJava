# AbsensiJava
# Panduan Instalasi dan Penggunaan Aplikasi Absensi

## 📌 Persyaratan Sebelum Menjalankan Aplikasi
Pastikan perangkat Anda telah memenuhi persyaratan berikut:

### 1. **JDK & JRE**
- Install **Java Development Kit (JDK) 8 atau lebih baru**
- Pastikan environment variable `JAVA_HOME` sudah diatur.

### 2. **Database MySQL**
- Install MySQL Server 5.7 atau lebih baru.
- Buat database baru dengan nama `absensi_db`.
- Gunakan query berikut untuk membuat tabel:

```sql
CREATE DATABASE absensi_db;

USE absensi_db;

CREATE TABLE absensi (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nama VARCHAR(100) NOT NULL,
    tanggal DATE NOT NULL
);
```

### 3. **JDBC Driver**
- Download dan tambahkan `mysql-connector-java-xx.x.xx.jar` ke dalam project Java.

---

## 🔧 Konfigurasi Aplikasi

### 1. **Clone Repository**
Jalankan perintah berikut di terminal atau command prompt:
```sh
git clone https://github.com/username/repository-name.git
cd repository-name
```

### 2. **Konfigurasi Database**
Buka `DatabaseConnection.java` dan sesuaikan kredensial:

```java
private static final String URL = "jdbc:mysql://localhost:3306/absensi_db";
private static final String USER = "root";
private static final String PASSWORD = "";
```

### 3. **Import Project ke Eclipse**
- **Buka Eclipse** → **File** → **Import** → **Existing Projects into Workspace**.
- Pilih folder proyek yang sudah di-clone.
- Klik **Finish**.

### 4. **Tambahkan MySQL Connector**
- Klik kanan project → **Build Path** → **Configure Build Path**.
- Pilih **Libraries** → **Add External JARs**.
- Pilih file `mysql-connector-java-xx.x.xx.jar`.
- Klik **Apply and Close**.

---

## 🚀 Menjalankan Aplikasi
1. Buka **`AbsensiApp.java`**.
2. Klik kanan → **Run As → Java Application**.
3. Pilih opsi yang tersedia:
   - `1` → Tambah Absensi
   - `2` → Tampilkan Absensi
   - `3` → Keluar dari aplikasi

---

## 🔍 Navigasi & Fungsi Utama
| **Fitur**  | **Navigasi** | **Fungsi yang Dipanggil** |
|------------|-------------|----------------------|
| Tambah Absensi | Menu → Pilih `1` | `AbsensiRepository.tambahAbsensi()` |
| Lihat Absensi | Menu → Pilih `2` | `AbsensiRepository.tampilkanAbsensi()` |

---

## 🛠 Troubleshooting
### ❌ Error: `java.sql.SQLException: No suitable driver found`
🔹 **Solusi:** Pastikan MySQL Connector sudah ditambahkan ke **Build Path**.

### ❌ Error: `Access denied for user 'root'@'localhost'`
🔹 **Solusi:** Periksa username & password di `DatabaseConnection.java`.

---

## 📢 Kontribusi
Jika ingin berkontribusi, silakan fork repo ini dan buat pull request.

✉️ **Kontak**: idaandroids@gmail.com
