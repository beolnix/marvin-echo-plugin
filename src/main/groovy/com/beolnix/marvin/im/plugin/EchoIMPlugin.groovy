package com.beolnix.marvin.im.plugin


import com.beolnix.marvin.im.api.model.IMIncomingMessage
import com.beolnix.marvin.im.api.model.IMOutgoingMessage
import com.beolnix.marvin.im.api.model.IMOutgoingMessageBuilder
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

    private Logger logger;

    private IMSessionManager imSessionManager
    private IMPluginState state = IMPluginState.NOT_INITIALIZED;
    private String errMsg

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

    @Override
    boolean isCommandSupported(String s) {
        return true
    }

    IMPluginState getPluginState() {
        return state
    }

    public boolean isProcessAll() {
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
