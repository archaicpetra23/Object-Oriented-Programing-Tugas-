package edu.pradita.oop.session04;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TUGAS000 - JavaFX Hello, CSS, dan Counter
 *
 * Fitur yang harus diimplementasikan:
 * 1. Tampilkan "Hello, <nama kamu>" dengan teks berwarna merah (via CSS)
 * 2. Counter dengan tombol "+" dan "-"
 * 3. Validasi: counter tidak boleh melebihi 10 atau kurang dari -3
 *    → tampilkan Alert jika melanggar batas
 */
public class App extends Application {

    // TODO 1: Deklarasi counter dengan nilai awal 0
    private int counter = 0;

    // Batas counter (jangan diubah)
    private static final int MAX_COUNTER = 10;
    private static final int MIN_COUNTER = -3;

    @Override
    public void start(Stage primaryStage) {

        // TODO 2: Ganti "NAMA SAYA" dengan nama kamu sendiri
        Label helloLabel = new Label("Hello, Razan Rafi Akmaluzzuhair");

        // TODO 3: Tambahkan CSS class "hello-text" ke helloLabel
        //         agar teks berwarna merah sesuai styles.css
        helloLabel.getStyleClass().add("hello-text");

        Label counterLabel = new Label("Counter: " + counter);

        Button plusButton = new Button("+");
        Button minusButton = new Button("-");

        // TODO 4: Implementasikan event handler plusButton
        //         - Panggil increment()
        //         - Jika increment() return false → tampilkan alert "Batas maksimum tercapai! (maks: 10)"
        //         - Jika true → update counterLabel
        plusButton.setOnAction(e -> {
            // TODO: implement
            if (!increment()){
                showAlert("Batas maksimum tercapai! (maks: 10)");
            } else {
                counterLabel.setText("Counter: " + counter);
            }
        });

        // TODO 5: Implementasikan event handler minusButton
        //         - Panggil decrement()
        //         - Jika decrement() return false → tampilkan alert "Batas minimum tercapai! (min: -3)"
        //         - Jika true → update counterLabel
        minusButton.setOnAction(e -> {
            // TODO: implement
            if (!decrement()) {
                showAlert("Batas minimum tercapai! (min: -3)");
            } else counterLabel.setText("Counter: " + counter);
        });

        VBox root = new VBox(10, helloLabel, counterLabel, plusButton, minusButton);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 300, 250);

        // TODO 6: Load CSS dari "/styles.css" <- UBAH WARNA DARI BIRU JADI MERAH
        //         Gunakan: scene.getStylesheets().add(...)
        scene.getStylesheets().add("styles.css");

        primaryStage.setTitle("Tugas000 JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // =========================================================
    // LOGIC METHODS - Harus diimplementasikan untuk lolos test
    // =========================================================

    /**
     * TODO 7: Implementasikan increment()
     *
     * Aturan:
     * - Jika counter SUDAH sama dengan MAX_COUNTER (10) → jangan tambah, return false
     * - Jika belum → tambah counter 1, return true
     *
     * @return true jika berhasil, false jika sudah mencapai batas maksimum
     */
    public boolean increment() {
        // TODO: implement
        if (counter >= MAX_COUNTER) { 
        return false;
        }
        counter++;
        return true;
    }

    /**
     * TODO 8: Implementasikan decrement()
     *
     * Aturan:
     * - Jika counter SUDAH sama dengan MIN_COUNTER (-3) → jangan kurangi, return false
     * - Jika belum → kurangi counter 1, return true
     *
     * @return true jika berhasil, false jika sudah mencapai batas minimum
     */
    public boolean decrement() {
        // TODO: implement
        if (counter <= MIN_COUNTER) {  
        return false;
        }
        counter--;
        return true;

    }

    /**
     * Getter untuk unit test (jangan diubah)
     */
    public int getCounter() {
        return counter;
    }

    /**
     * TODO 9 (Helper - opsional):
     * Tampilkan Alert WARNING
     *
     * @param message pesan yang ditampilkan di alert
     */
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Peringatan");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
