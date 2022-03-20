package com.jpro.hellojpro;

import com.jpro.hellojpro.page.FXMLPage;
import com.jpro.hellojpro.page.InfoPage;
import com.jpro.hellojpro.page.LandingPage;
import com.jpro.web.Redirect;
import com.jpro.web.WebApp;
import com.jpro.webapi.WebAPI;
import javafx.stage.Stage;

public class HelloJProApp extends WebApp {

    HelloJProApp(Stage stage) {
        super(stage);
        getStylesheets().add(getClass().getResource("/com/jpro/hellojpro/css/HelloJPro.css").toString());

        addRouteJava((s) -> {
            if (s.equals("") || s.equals("/")) {
                return new Redirect("/landing?category=xyz");
            } else if (s.equals("/landing") || s.contains("/landing?category=")) {
                return new LandingPage(WebAPI.isBrowser() ? WebAPI.getWebAPI(stage) : null);
            } else if (s.equals("/info") || s.contains("/info?content=")) {
                return new InfoPage(WebAPI.isBrowser() ? WebAPI.getWebAPI(stage) : null);
            } else if (s.equals("/fxml")) {
                return new FXMLPage(WebAPI.isBrowser() ? WebAPI.getWebAPI(stage) : null);
            } else {
                return null;
            }
        });
    }
}
