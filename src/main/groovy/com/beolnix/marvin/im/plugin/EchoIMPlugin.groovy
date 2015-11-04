package com.beolnix.marvin.im.plugin


import com.beolnix.marvin.im.api.IMIncomingMessage
import com.beolnix.marvin.im.api.IMOutgoingMessage
import com.beolnix.marvin.im.api.IMOutgoingMessageBuilder
import com.beolnix.marvin.im.api.IMSessionManager
import com.beolnix.marvin.plugins.api.IMPlugin
import com.beolnix.marvin.plugins.api.IMPluginState
import org.apache.log4j.Logger
import org.osgi.framework.BundleContext

/**
 * Author: beolnix
 * Email: beolnix@gmail.com
 * Date: 11/14/11
 * Time: 11:05 PM
 */
class EchoIMPlugin implements IMPlugin {

    Logger logger;

    IMSessionManager imSessionManager
    IMPluginState state = IMPluginState.NOT_INITIALIZED;
    String errMsg

    public EchoIMPlugin(BundleContext bundleContext) {
        logger = new PluginUtils().getLogger(bundleContext, getPluginName())
    }

    public String getPluginName() {
        if (logger != null)
            logger.info('getPluginName invoked')
        return 'echoPlugin'
    }

    public List<String> getCommandsList() {
        return ['*']
    }

    IMPluginState getPluginState() {
        return IMPluginState.INITIALIZED
    }

    public Boolean isProcessAll() {
        return true
    }

    public void process(IMIncomingMessage msg) {
        IMOutgoingMessage outMsg = new IMOutgoingMessageBuilder(msg)
                .withRecipient(msg.getAuthor())
                .withRawMessageBody("pong for: " + msg.getRawMessageBody())
                .withFromPlugin(getPluginName())
                .build();
        imSessionManager.sendMessage(outMsg)
    }

    void setIMSessionManager(IMSessionManager imSessionManagerFacade) {
        this.imSessionManager = imSessionManagerFacade
        this.state = IMPluginState.INITIALIZED
    }

    @Override
    String getErrorDescription() {
        return errMsg
    }

    @Override
    Set<String> getSupportedProtocols() {
        return Collections.emptySet()
    }

    @Override
    boolean isProtocolSupported(String protocol) {
        return true
    }

    @Override
    boolean isAllProtocolsSupported() {
        return true
    }
}
