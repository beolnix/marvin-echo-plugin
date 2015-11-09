package com.beolnix.marvin.im.plugin;

import com.beolnix.marvin.im.api.IMSessionManager;
import com.beolnix.marvin.im.api.model.IMIncomingMessage;
import com.beolnix.marvin.im.api.model.IMOutgoingMessage;
import com.beolnix.marvin.im.api.model.IMOutgoingMessageBuilder;
import com.beolnix.marvin.plugins.api.IMPlugin;
import com.beolnix.marvin.plugins.api.IMPluginState;
import org.apache.log4j.Logger;
import org.osgi.framework.BundleContext;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by beolnix on 11/9/2015.
 */
public class EchoIMPlugin implements IMPlugin {
    private Logger logger;

    private IMSessionManager imSessionManager;
    private IMPluginState state = IMPluginState.NOT_INITIALIZED;
    private String errMsg;

    public EchoIMPlugin(BundleContext bundleContext) {
        logger = new PluginUtils().getLogger(bundleContext, getPluginName());
    }

    @Override
    public String getPluginName() {
        logger.trace("getPluginName invoked");
        return "echoPlugin";
    }

    @Override
    public List<String> getCommandsList() {
        return Collections.emptyList();
    }

    @Override
    public boolean isCommandSupported(String s) {
        return true;
    }

    @Override
    public IMPluginState getPluginState() {
        return state;
    }

    @Override
    public boolean isProcessAll() {
        return true;
    }

    @Override
    public void process(IMIncomingMessage msg) {
        IMOutgoingMessage outMsg = new IMOutgoingMessageBuilder(msg)
                .withRecipient(msg.getAuthor())
                .withRawMessageBody("pong for: " + msg.getRawMessageBody())
                .withFromPlugin(getPluginName())
                .build();
        imSessionManager.sendMessage(outMsg);
    }

    @Override
    public void setIMSessionManager(IMSessionManager imSessionManagerFacade) {
        this.imSessionManager = imSessionManagerFacade;
        this.state = IMPluginState.INITIALIZED;
    }

    @Override
    public String getErrorDescription() {
        return errMsg;
    }

    @Override
    public Set<String> getSupportedProtocols() {
        return Collections.emptySet();
    }

    @Override
    public boolean isProtocolSupported(String protocol) {
        return true;
    }

    @Override
    public boolean isAllProtocolsSupported() {
        return true;
    }
}
