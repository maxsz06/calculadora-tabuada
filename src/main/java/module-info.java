module br.sena.sp.jandira.tabuada {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.sena.sp.jandira.tabuada to javafx.fxml;
    exports br.sena.sp.jandira.tabuada;
}