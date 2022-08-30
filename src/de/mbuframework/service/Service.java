package de.mbuframework.service;

import de.mbuframework.injection.MegaInjector;

public abstract class Service
{
    protected Service() {
        MegaInjector.injectFields( this );
    }
}
