Nama : Rafif Surya Murtadha
NIM : H1D023008
Shift B => C

Video : 


https://github.com/user-attachments/assets/dab2ef12-c739-4496-b2e7-2e3cb25051ef


Alur : 
  Alur data dari pemanggilan API hingga penyajian di layar dalam aplikasi Android dimulai dari proses pengiriman permintaan jaringan melalui ViewModel atau Repository. Library seperti Retrofit atau OkHttp digunakan untuk mengirim permintaan HTTP, misalnya metode GET, ke endpoint API yang menyediakan data dalam format JSON. Untuk menjaga kelancaran antarmuka, proses ini dijalankan di thread latar belakang menggunakan coroutine agar tidak mengganggu proses rendering tampilan.
  Setelah respons diterima, data JSON diparsing menggunakan library seperti Gson atau Moshi dan diubah menjadi objek Kotlin atau Java yang dapat dimanfaatkan dalam aplikasi, seperti daftar pemain dengan atribut nama, posisi, dan kebangsaan. Data yang telah diproses dapat disimpan sementara di cache lokal menggunakan Room Database atau SharedPreferences, sehingga tetap tersedia meskipun koneksi jaringan tidak aktif.
  Data yang telah siap kemudian dikirim ke lapisan UI melalui mekanisme observasi seperti LiveData atau StateFlow. Di bagian tampilan, data ditampilkan menggunakan RecyclerView, dengan bantuan Adapter yang mengikat data ke layout XML melalui View Binding. Elemen-elemen seperti TextView dan ImageView menampilkan informasi sesuai dengan struktur data yang telah diproses.
  Ketika layout dirender, data yang telah terintegrasi ditampilkan secara langsung di layar. Jika terjadi gangguan jaringan, sistem akan menampilkan pesan kesalahan atau memanfaatkan data cache sebagai alternatif. Alur ini mendukung integrasi data dinamis dari sumber eksternal secara real-time, sekaligus menjaga stabilitas dan interaktivitas aplikasi selama proses berlangsung.

Urutan Alur Data:
1. Permintaan API dikirim dari ViewModel atau Repository menggunakan Retrofit/OkHttp.

2. Eksekusi dijalankan di thread latar belakang menggunakan coroutine untuk menjaga kelancaran UI.

3. Respons JSON diterima dari server.

4. Data diparsing menggunakan Gson atau Moshi menjadi objek Kotlin/Java.

5. Data disimpan sementara di cache lokal (Room/SharedPreferences) jika diperlukan.

6. Data dikirim ke UI melalui LiveData atau StateFlow.

7. RecyclerView menampilkan data dengan bantuan Adapter dan View Binding.

8. Layout dirender, menampilkan elemen seperti TextView dan ImageView.

9. Error jaringan ditangani, dengan fallback ke cache atau pesan kesalahan.

10. Data ditampilkan secara real-time, mendukung interaksi yang lancar dan stabil.
