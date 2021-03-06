package sample;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Distance extends JFrame implements Runnable{

    private WebEngine webEngine;
    private JFXPanel panel;
    String l1;
    String l2;
    String d1;
    String d2;
    void getdes(String a, String b)
    {
        l1 = a;
        l2 = b;
    }
    void getdes2(String a, String b)
    {
        d1 = a;
        d2 = b;
    }
    public void run() {
        setTitle("The Location of Your Destination");
        setVisible(true);
        setBounds(0,0,500, 500);
        //    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JFXPanel();
        add(panel);
        Platform.runLater(() -> {
            WebView view2 = new WebView();
            //view.getEngine().load("https://www.mapquest.com/");
            //String address="https://wikimapia.org/#lang=en&lat=28.304683&lon=76.706200&z=12&m=w&gz=0;"+l2+";"+l1+";0;"+d2+";"+d1+";0";
            String address = "https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route="+l1+"%2C"+l2+"%3B"+d1+"%2C"+d2+"#map=7/29.912/79.871";
            view2.getEngine().load(address);
            panel.setScene(new Scene(view2));
        });
    }

//    public static void main(String[] args) {
//        Distance objd  = new Distance();
//        objd.getdes("27.713","75.564");
//        objd.getdes2("28.910","76.457");
//       // SwingUtilities.invokeLater(new sample.WebBrowser());
//        objd.run();
//    }
public static double getDistanceBetweenTwoPlaces(String lt1, String ln1,String lt2, String ln2) {

        double lon1 = Double.parseDouble(ln1);
        double lon2 = Double.parseDouble(ln2);
        double lat1 = Double.parseDouble(lt1);
        double lat2 = Double.parseDouble(lt2);

        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat /2),2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon /2),2);

        double c =2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r =6371;

        // calculate the result
        return(c * r);
    }
}


