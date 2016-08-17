package com.robotsandpencils.walkthrough.presentation.common.dependency.dagger;

import dagger.ObjectGraph;

/**
 * farhankhan
 * 2016-08-04
 */

public class DaggerWrapper {
    private static ObjectGraph sObjectGraph;

    public DaggerWrapper() {
    }

    public static ObjectGraph getObjectGraph() {
        if (sObjectGraph == null) {
            MainModule mainModule = new MainModule();
            sObjectGraph = ObjectGraph.create(mainModule);
        }

        return sObjectGraph;
    }
}
