package com.ethanaa.mtg.cube;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public abstract class JavaFxApplicationSupport extends Application {

    private static String[] savedArgs;

    private ConfigurableApplicationContext configurableApplicationContext;

    @Override
    public void init() throws Exception {

        configurableApplicationContext = SpringApplication.run(getClass(), savedArgs);
        configurableApplicationContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public void stop() throws Exception {

        super.stop();
        configurableApplicationContext.close();
    }

    protected static void launchApp(Class<? extends JavaFxApplicationSupport> appClass, String[] args) {

        JavaFxApplicationSupport.savedArgs = args;
        Application.launch(appClass, args);
    }
}
