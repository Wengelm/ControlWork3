package client.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    @FXML
    Button sendBtn;
    @FXML
    Button connectBtn;
    @FXML
    TextField dataSend;
    @FXML
    TextField adress;
    @FXML
    TextField port;
    @FXML
    TextArea dataReceived;
    @FXML
    Label connectionStatus;

    private Socket sock = null;
    InputStream is = null;
    OutputStream os = null;

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void connectToServer() {

        if (sock == null) {

            try {
                sock = new Socket(InetAddress.getByName(adress.getText()), Integer.parseInt(port.getText()));
                connectionStatus.setText("Connected");
                connectionStatus.setStyle("-fx-text-fill: green");
                connectBtn.setText("Disconnect");

            } catch (UnknownHostException e) {
                e.printStackTrace();

            } catch (IOException e) {
                e.printStackTrace();
                connectionStatus.setText("Server Time out error.");
            }
        } else {
            try {
                sock.close();
                sock = null;
                connectionStatus.setText("Disconnected");
                connectionStatus.setStyle("-fx-text-fill: red");
                connectBtn.setText("Connect");
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    public void sendDataToServer() {
        if (sock == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Нет подключения к серверу!");
            alert.showAndWait();
                   }else  {

        try {
            is = sock.getInputStream();
            os = sock.getOutputStream();

            String sendData = dataSend.getText();
            os.write(sendData.getBytes());
            byte[] bytes = new byte[1024];
            is.read(bytes);
            String result = new String(bytes, "UTF-8");
            result = result.replace(" ","");
            dataReceived.setText(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }


}
