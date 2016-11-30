package rules;

import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

/**
 * Created by Ravi Aghera
 */
public class EpaTestWatcher extends TestWatcher {
    @Override
    protected void failed(Throwable e, Description description) {
        System.out.println("Ravi Failed: " + description);
    }
}
