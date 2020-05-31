package com.geekbrains.java2.homework4;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextArea msgHistory;

    @FXML
    TextField msgText;

    @FXML
    Button sendMsgButton;

    public void sendMsgAction(ActionEvent actionEvent) {
        String msg = msgText.getText().trim();

        if (!msg.isEmpty()) {
            msgHistory.appendText("You: " + msg + System.lineSeparator());
            msgText.clear();
        }
    }
}
