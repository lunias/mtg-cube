package com.ethanaa.mtg.cube.ui.component;

import com.ethanaa.mtg.cube.model.Library;
import org.springframework.stereotype.Component;

@Component
public class PlayerLibrary {

    private Library library = new Library();

    public Library getLibrary() {

        return library;
    }
}
