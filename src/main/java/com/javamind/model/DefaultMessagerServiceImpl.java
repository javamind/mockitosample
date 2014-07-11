package com.javamind.model;

/**
 * Définition d'un message service avec une classe final
 *
 * @author EHRET_G
 */
public class DefaultMessagerServiceImpl {
    protected final Object lifecycleMonitor = new Object();
    /**
     * the final is not a good thing... It's only to illustrate my article
     */
    public final boolean isRunning(){
        synchronized (this.lifecycleMonitor) {
            System.out.println("Send a mail");
            return true;
        }
    }
}
