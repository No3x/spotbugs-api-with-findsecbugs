package de.sample;

import edu.umd.cs.findbugs.BugInstance;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {

    private Application app;

    @Before
    public void setUp() {
        app = new Application();
    }

    @Test
    public void testNoOfDefects() throws IOException, InterruptedException {
        final Collection<BugInstance> defects = app.findBugs();
        assertThat(defects.size()).as("Should find more than 2 defects").isGreaterThan(2);
    }
}
