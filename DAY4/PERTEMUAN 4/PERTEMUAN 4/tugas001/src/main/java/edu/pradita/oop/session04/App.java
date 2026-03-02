package edu.pradita.oop.session04;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * TUGAS001 - MVC CRUD Mahasiswa (JavaFX)
 * ========================================
 * VIEW: Tampilan UI menggunakan JavaFX TableView.
 *
 * Fitur yang harus diimplementasikan:
 * - TableView dengan kolom: NIM (int), Nama, Prodi
 * - Form input: TextField untuk NIM, Nama, Prodi
 * - Tombol "Tambah" → panggil controller.addStudent()
 * - Tombol "Hapus Terpilih" → panggil controller.removeStudent()
 * - Tombol "Clear Semua" → panggil controller.clearAll()
 * - Label pesan error jika input tidak valid
 */
public class App extends Application {

    // TODO 14: Buat instance StudentController
    //          private final StudentController controller = new StudentController();
    private final StudentController controller = new StudentController();

    @Override
    public void start(Stage primaryStage) {

        // -------------------------------------------------------
        // TODO 15: Buat TableView<Student>
        //          TableView<Student> tableView = new TableView<>();
        TableView<Student> tableView = new TableView<>();
        // -------------------------------------------------------

        // TODO 16: Buat kolom NIM (int)
        TableColumn<Student, Number> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(data ->
            new SimpleIntegerProperty(data.getValue().getNim()));
        nimCol.setPrefWidth(100);

        // TODO 17: Buat kolom Nama (String)
        TableColumn<Student, String> nameCol = new TableColumn<>("Nama");
        nameCol.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getName()));
        nameCol.setPrefWidth(150);

        // TODO 18: Buat kolom Prodi (String)
        TableColumn<Student, String> majorCol = new TableColumn<>("Prodi");
        majorCol.setCellValueFactory(data ->
            new SimpleStringProperty(data.getValue().getMajor()));
        majorCol.setPrefWidth(150);

        // TODO 19: Tambahkan semua kolom ke tableView dan bind data
        tableView.getColumns().addAll(nimCol, nameCol, majorCol);
        tableView.setItems(controller.getStudents());

        // -------------------------------------------------------
        // TODO 20: Buat input fields
        TextField nimField = new TextField();
        nimField.setPromptText("NIM (angka)");
        
        TextField nameField = new TextField();
        nameField.setPromptText("Nama");
        
        TextField majorField = new TextField();
        majorField.setPromptText("Prodi");
        // -------------------------------------------------------

        // TODO 21: Buat 3 tombol
        Button addButton = new Button("Tambah");
        Button deleteButton = new Button("Hapus Terpilih");
        Button clearButton = new Button("Clear Semua");

        // TODO 22: Buat Label untuk pesan error/sukses
        Label messageLabel = new Label();

        // -------------------------------------------------------
        // TODO 23: Implementasikan event handler addButton
        //
        //   Langkah:
        //   1. Ambil nilai dari nimField (pakai Integer.parseInt())
        //      → jika bukan angka → tampilkan pesan error "NIM harus berupa angka!"
        //   2. Panggil controller.addStudent(nim, name, major)
        //      → jika IllegalArgumentException → tampilkan pesan error dari exception
        //   3. Jika berhasil → clear semua field + tampilkan "Mahasiswa berhasil ditambahkan!"
        //
        addButton.setOnAction(e -> {
            try {
                int nim = Integer.parseInt(nimField.getText());
                
                controller.addStudent(nim, nameField.getText(), majorField.getText());
                    nimField.clear(); nameField.clear(); majorField.clear();
                    
                    messageLabel.setText("Mahasiswa berhasil ditambahkan!");
            
                } catch (NumberFormatException ex) {
                    messageLabel.setText("NIM harus berupa angka!");
            
                } catch (IllegalArgumentException ex) {
                    messageLabel.setText(ex.getMessage());
            }
        });                                                     
        // -------------------------------------------------------

        // TODO 24: Implementasikan event handler deleteButton
        deleteButton.setOnAction(e -> {
            Student selected = tableView.getSelectionModel().getSelectedItem();

            if (selected == null) {
                messageLabel.setText("Pilih mahasiswayang ingin di hapus");
            } else {
                controller.removeStudent(selected);
                messageLabel.setText("Mahasiswa berhasil di hapus!");
            }
        });
        //   Langkah:
        //   1. Ambil item yang terpilih di tableView
        //      → Student selected = tableView.getSelectionModel().getSelectedItem();
        //   2. Jika null → tampilkan "Pilih mahasiswa yang ingin dihapus!"
        //   3. Jika ada → panggil controller.removeStudent(selected)
        //      + tampilkan "Mahasiswa berhasil dihapus!"

        // TODO 25: Implementasikan event handler clearButton
        clearButton.setOnAction(e -> {
            controller.clearAll();
            messageLabel.setText("Semua data di hapus!");
        });
        //          → panggil controller.clearAll()
        //          → tampilkan "Semua data dihapus!"

        // -------------------------------------------------------
        // TODO 26: Susun layout menggunakan GridPane untuk form
        //
        GridPane form = new GridPane();
        form.setHgap(10); form.setVgap(8);
        form.setPadding(new Insets(10));
        
        form.add(new Label("NIM:"),   0, 0); form.add(nimField,   1, 0);
        form.add(new Label("Nama:"),  0, 1); form.add(nameField,  1, 1);
        form.add(new Label("Prodi:"), 0, 2); form.add(majorField, 1, 2);
        
        HBox buttons = new HBox(10, addButton, deleteButton, clearButton);
        buttons.setPadding(new Insets(5, 0, 0, 0));
        
        form.add(buttons,      1, 3);
        form.add(messageLabel, 1, 4);
        // -------------------------------------------------------

        // TODO 27: Susun layout utama menggunakan BorderPane
        //
        BorderPane root = new BorderPane();
        root.setCenter(tableView);
        root.setBottom(form);

        // TODO 28: Set Scene dan tampilkan Stage
        //
        Scene scene = new Scene(root, 600, 450);
        primaryStage.setTitle("Tugas001 - CRUD Mahasiswa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
