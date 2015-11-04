package com.beolnix.marvin.im.plugin

import com.beolnix.marvin.plugins.api.IMPlugin
import org.osgi.framework.BundleActivator
import org.osgi.framework.BundleContext

/**
 * Author: Atmakin Danila 
 * Email: datmakin@dh-lab.ru
 * Date: 29.11.11
 * Time: 0:56
 */
class Activator implements BundleActivator {
    void start(BundleContext context) {
        IMPlugin plugin = new EchoIMPlugin(context)
        context.registerService(IMPlugin.class.getName(), plugin, null)
    }

    void stop(BundleContext context) {
        // NOTE: The service is automatically unregistered.
    }

}
