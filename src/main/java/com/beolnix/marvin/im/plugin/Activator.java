package com.beolnix.marvin.im.plugin;

import com.beolnix.marvin.plugins.api.IMPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * Author: Atmakin Danila
 * Email: beolnix@gmail.com
 * Date: 29.11.11
 * Time: 0:56
 */
public class Activator implements BundleActivator {
    @Override
    public void start(BundleContext context) {
        IMPlugin plugin = new EchoIMPlugin();
        context.registerService(IMPlugin.class.getName(), plugin, null);
    }

    @Override
    public void stop(BundleContext context) {
        // NOTE: The service is automatically unregistered.
    }
}
