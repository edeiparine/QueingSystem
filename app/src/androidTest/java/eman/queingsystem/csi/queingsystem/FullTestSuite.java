package eman.queingsystem.csi.queingsystem;

import android.test.suitebuilder.TestSuiteBuilder;

import junit.framework.TestSuite;

/**
 * Created by csi on 27/8/15.
 */
public class FullTestSuite extends TestSuite {
    public static TestSuiteBuilder suite() {
        return new TestSuiteBuilder(FullTestSuite.class);
    }

    public FullTestSuite() {
        suite();
    }
}
